<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="chartContainer" style="height: 300px; width: 100%;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>

<script type="text/javascript">
	window.onload = function() {

		var dps = []; // dataPoints
		var chart = new CanvasJS.Chart("chartContainer", {
			title : {
				text : "Dynamic Data"
			},
			axisY : {
				includeZero : false
			},
			data : [ {
				type : "line",
				dataPoints : dps
			} ]
		});

		var xVal = 0;
		var yVal = 100;
		var updateInterval = 1000;
		var dataLength = 20; // number of dataPoints visible at any point

		var updateChart = function(count) {


			for (var j = 0; j < count; j++) {

				yVal = yVal + Math.round(5 + Math.random() * (-5 - 5));
				dps.push({
					x : xVal,
					y : yVal

				});
				xVal++;
			}

			if (dps.length > dataLength) {
				dps.shift();
			}

			chart.render();
		};

		updateChart(dataLength);
		setInterval(function() {
			updateChart()
		}, updateInterval);

	}
</script>
</html>