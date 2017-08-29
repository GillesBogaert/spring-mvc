
var xHRObject = new XMLHttpRequest();
var xHRObject2 = new XMLHttpRequest();


function start(){
    getQuote();
    getEvents();
    
}
function getEvents() {
	xHRObject.open("GET", "http://localhost:8080/Events/rest/users", true);
	xHRObject.onreadystatechange = getData;
	xHRObject.send(null);

}

function getData() {

	if (xHRObject.readyState == 4) {
		if (xHRObject.status == 200) {
			var serverResponse = JSON.parse(xHRObject.responseText);
			
			var col = [];
			for (var i = 0; i < serverResponse.length; i++) {
				for ( var key in serverResponse[i]) {
					if (col.indexOf(key) === -1) {
						col.push(key);
					}
				}
			}

			var table = document.createElement("table");
                        table.setAttribute("class", "table table-hover table-bordered");

			var tr = table.insertRow(-1);

			for (var i = 0; i < col.length; i++) {
				var th = document.createElement("th") 
				th.innerHTML = col[i];
				tr.appendChild(th);
			}

			for (var i = 0; i < serverResponse.length; i++) {

				tr = table.insertRow(-1);

				for (var j = 0; j < col.length; j++) {
					var tabCell = tr.insertCell(-1);
					tabCell.innerHTML = serverResponse[i][col[j]];
				}
			}
			var divContainer = document.getElementById("showData");
			divContainer.innerHTML = "";
			divContainer.appendChild(table);
		}

	} else {

	}

}

function getQuote(){
    
    xHRObject2.open("GET", "http://date.jsontest.com/", true);
	xHRObject2.onreadystatechange = getQuoteData;
	xHRObject2.send(null);
}

function getQuoteData() {

	if (xHRObject2.readyState == 4) {
		if (xHRObject2.status == 200) {
                var quote = "Current time is : ";
		var serverResponse = JSON.parse(xHRObject.responseText);
                quote += serverResponse.time;
                quote += " Miliseconds since epoch : "
                quote += serverResponse.milliseconds_since_epoch;
                quote += " Date is : "
                quote += serverResponse.date
                var div = document.createElement("div");
                div.innerHTML = quote;
                var divContainer = document.getElementById("showQuote");
                divContainer.appendChild(div);
                
                
		}

	} else {

	}

}
