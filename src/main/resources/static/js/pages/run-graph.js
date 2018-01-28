var chartData1 = [];
var chartData2 = [];
var chartData3 = [];
var chartData4 = [];

generateChartData();

function generateChartData() {

    $.get( "/api/v1/run/"+c_run_name+ "/" + c_run_type + "/readings/" , function ( data ) {

        for ( var i = 0; i < data.length; i++ ) {
            var reading = data[i];
            var samplingDate = new Date ( reading.samplingTimestamp );

            chartData1.push( {
                "date": samplingDate,
                "value": reading.temperature,
                "volume": 1
            } );
            chartData2.push( {
                "date": samplingDate,
                "value": reading.turbidity,
                "volume": 1
            } );
            chartData3.push( {
                "date": samplingDate,
                "value": reading.disolvedOxygen,
                "volume": 1
            } );
            chartData4.push( {
                "date": samplingDate,
                "value": reading.flowRate,
                "volume": 1
            } );
        }

        drawChart();

    });
}

function drawChart() {

    var chart = AmCharts.makeChart( "chartdiv", {
        "type": "stock",
        "theme": "none",
        "dataSets": [ {
            "title": "Temperature",
            "fieldMappings": [ {
                "fromField": "value",
                "toField": "value"
            }, {
                "fromField": "volume",
                "toField": "volume"
            } ],
            "dataProvider": chartData1,
            "categoryField": "date"
        }, {
            "title": "Turbidity",
            "fieldMappings": [ {
                "fromField": "value",
                "toField": "value"
            }, {
                "fromField": "volume",
                "toField": "volume"
            } ],
            "dataProvider": chartData2,
            "categoryField": "date"
        }, {
            "title": "Disolved Oxygen",
            "fieldMappings": [ {
                "fromField": "value",
                "toField": "value"
            }, {
                "fromField": "volume",
                "toField": "volume"
            } ],
            "dataProvider": chartData3,
            "categoryField": "date"
        }, {
            "title": "Flow rate",
            "fieldMappings": [ {
                "fromField": "value",
                "toField": "value"
            }, {
                "fromField": "volume",
                "toField": "volume"
            } ],
            "dataProvider": chartData4,
            "categoryField": "date"
        }
        ],

        "panels": [ {
            "showCategoryAxis": false,
            "title": "Value",
            "percentHeight": 70,
            "stockGraphs": [ {
                "id": "g1",
                "valueField": "value",
                "comparable": true,
                "compareField": "value",
                "balloonText": "[[title]]:<b>[[value]]</b>",
                "compareGraphBalloonText": "[[title]]:<b>[[value]]</b>"
            } ],
            "stockLegend": {
                "periodValueTextComparing": "[[percents.value.close]]%",
                "periodValueTextRegular": "[[value.close]]"
            }
        }, {
            "title": "Volume",
            "percentHeight": 30,
            "stockGraphs": [ {
                "valueField": "volume",
                "type": "column",
                "showBalloon": false,
                "fillAlphas": 1
            } ],
            "stockLegend": {
                "periodValueTextRegular": "[[value.close]]"
            }
        } ],

        "chartScrollbarSettings": {
            "graph": "g1"
        },

        "chartCursorSettings": {
            "valueBalloonsEnabled": true,
            "fullWidth": true,
            "cursorAlpha": 0.1,
            "valueLineBalloonEnabled": true,
            "valueLineEnabled": true,
            "valueLineAlpha": 0.5
        },

        "periodSelector": {
            "position": "left",
            "periods": [
                {
                    "period": "DD",
                    "selected": true,
                    "count": 1,
                    "label": "1 day"
                },
                {
                    "period": "MM",
                    "count": 1,
                    "label": "1 month"
                }, {
                    "period": "YYYY",
                    "count": 1,
                    "label": "1 year"
                }, {
                    "period": "YTD",
                    "label": "YTD"
                }, {
                    "period": "MAX",
                    "label": "MAX"
                } ]
        },

        "dataSetSelector": {
            "position": "left"
        },

        "export": {
            "enabled": true
        }
    } );
}