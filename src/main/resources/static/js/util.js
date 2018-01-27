jQuery.fn.numeric = function () {
	return this.each(() => {
		$(this).keydown(e => {
			const key = e.charCode || e.keyCode || 0;
			// allow backspace, tab, delete, enter, arrows, numbers and keypad numbers ONLY
			// home, end, period, and numpad decimal
			return (key === 8 ||
				key === 9 ||
				key === 13 ||
				key === 46 ||
				key === 110 ||
				key === 190 ||
				(key >= 35 && key <= 40) ||
				(key >= 48 && key <= 57) ||
				(key >= 96 && key <= 105));
		});
	});
};

$.fn.datepicker.defaults.format = 'dd-mm-yyyy';

const LOGGING_LEVEL = Object.freeze({
	INFO: 'info',
	SUCCESS: 'success',
	WARN: 'warning',
	ERROR: 'error'
});

const DATE_FORMAT= 'DD-MM-YYYY';

$(function(){
	$('.numeric').numeric();
});

function getDateFromLocalDateTimeObject(dateTime) {
	if(!dateTime){
		return '';
	}
	return new Date(dateTime.year, dateTime.monthValue - 1, dateTime.dayOfMonth, dateTime.hour, dateTime.minute);
}

function getDateFromLocalDateObject(date){
	if(!date){
		return '';
	}
	return new Date(date.year, date.monthValue - 1, date.dayOfMonth);
}

function getFormattedDateFromLocalDateObject(date, format){
	if(!date)
		return '';
	return moment(getDateFromLocalDateObject(date)).format(format || DATE_FORMAT);
}

function getFormattedTimeFromLocalTimeObject(time) {
	function padZero(n) {
		return (n < 10) ? ('0' + n) : n;
	}

	if(!time){
		return '';
	}

	return '' + padZero(time.hour) + ':' + padZero(time.minute);
}

function getColorForPlanning(planning){
	let color = 'blue';
	if (planning.extra) {
		color = 'green';
	}
	if (planning.intake) {
		color = 'yellow';
	}
	if (planning.cancelled) {
		color = 'red';
	}
	return color;
}

function getFormattedReceptionPlanning(planning, showDate = false){
	let date = '';
	if(showDate){
		date = getFormattedDateFromLocalDateObject(planning.start) + ' ';
	}
	return `${date}${getFormattedTimeFromLocalTimeObject(planning.start)} - ${getFormattedTimeFromLocalTimeObject(planning.end)}: ${planning.userName}`;
}

function validEmail(email) {
	// todo: extra email validation?
	return validString(email);
}

function validString(s){
	return !!(s && s.length > 0);
}

function loadReferralTypes(selector) {
	$.get('/api/child/referralTypes', null, referralTypes => {
		let optGroup0 = '<optgroup label="Nuldelijns">',
			optGroup1 = '<optgroup label="Eerstelijns">',
			optGroup2 = '<optgroup label="Tweedelijns">',
			optGroup3 = '<optgroup label="Derdelijns">',
			optGroup4 = '<optgroup label="Andere">';
		for (let i = 0; i < referralTypes.length; i++) {
			const referralType = referralTypes[i];
			switch (referralType.line) {
				case 0:
					optGroup0 += `<option value="${referralType.value}">${referralType.label}</option>`;
					break;
				case 1:
					optGroup1 += `<option value="${referralType.value}">${referralType.label}</option>`;
					break;
				case 2:
					optGroup2 += `<option value="${referralType.value}">${referralType.label}</option>`;
					break;
				case 3:
					optGroup3 += `<option value="${referralType.value}">${referralType.label}</option>`;
					break;
				case 4:
					optGroup4 += `<option value="${referralType.value}">${referralType.label}</option>`;
					break;
			}
		}

		$(`#${selector}`).empty()
			.append('<option value="" selected disabled></option>' +
				optGroup0 + '</optgroup>' +
				optGroup1 + '</optgroup>' +
				optGroup2 + '</optgroup>' +
				optGroup3 + '</optgroup>' +
				optGroup4 + '</optgroup>');
	});
}

function showToast(message, loggingLevel = LOGGING_LEVEL.INFO){
	toastr.options = {
		closeButton: true,
		debug: false,
		newestOnTop: true,
		showDuration: 300,
		hideDuration: 1000,
		timeOut: 5000
	};

	if(typeof message === 'object'){
		toastr[loggingLevel](message.content, message.title);
	}else {
		toastr[loggingLevel](message);
	}
}

function showStandardSuccessToast(){
	showToast(c_submitted_success, LOGGING_LEVEL.SUCCESS);
}

function showErrorMessagesToast(messages) {
    for (let i = messages.length - 1; i >= 0; i--) {
        showToast(messages[i], LOGGING_LEVEL.ERROR);
    }
}

function showPortletContainer(selector){
	$(selector).show().css('margin-top', $(document).scrollTop());
	$(window).scroll(() => {
		$(selector).css('margin-top', $(document).scrollTop());
	})
}

function createCheckBox(object, name){
    return `<label class="mt-checkbox mt-checkbox-outline">
					<input type="checkbox" value="${object.value}" name="${name}">
					${object.label}
					<span></span>
				</label>`;
}

function createRadioButton(object, name, enabled){
	let disabled = enabled ? '' : ' disabled';
    return `<label class="mt-radio mt-radio-outline">
					<input type="radio" value="${object.value}" name="${name}" ${disabled}>
					${object.label}
					<span></span>
				</label>`;
}

function changeVisibility(selector, visible){
	return visible ? $(selector).show() : $(selector).hide();
}