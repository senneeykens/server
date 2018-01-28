var map;
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 15,
        center: new google.maps.LatLng(50.878301, 4.696478),
        mapTypeId: 'terrain'
    });

    $.get( "/api/v1/run/"+c_run_name+ "/" + c_run_type + "/geometry/", function ( data ) {

        for ( var i = 0 ; i < data.length; i ++ ) {
            var reading = data[i];
            new google.maps.Marker({
                position: {lat: reading.latitude, lng: reading.longtitude},
                map: map
            });
        }

    });

}

// Loop through the results array and place a marker for each
// set of coordinates.
window.eqfeed_callback = function(results) {
    for (var i = 0; i < results.features.length; i++) {
        var coords = results.features[i].geometry.coordinates;
        var latLng = new google.maps.LatLng(coords[1],coords[0]);
        var marker = new google.maps.Marker({
            position: latLng,
            map: map
        });
    }
}
