window.onload = function () {
    document.getElementById("submitRequest").addEventListener("click", makeRequest);
    document.getElementById("viewRequests").addEventListener("click", viewEmployeeRequests);
    document.getElementById("logout").addEventListener("click", logout);
    document.getElementById("getEmployeeButton").addEventListener("click", getEmployee);

};

function logout() {


    console.log("Logging out..");
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
        	console.log(xhttp.responseText);
        	window.location = "http://localhost:8080/ERS/index.jsp"
        }
    };
    xhttp.open("POST", "http://localhost:8080/ERS/logout.do");
    xhttp.send();
}


function makeRequest() {
    var amount = document.getElementById("requestAmount").value;
    var body = document.getElementById("requestBody").value;

    console.log("Making request for $" + amount + ", body: " + body);
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            document.getElementById("sandboxDiv").innerHTML = xhttp.responseText;
        }
    };
    xhttp.open("POST", "http://localhost:8080/ERS/makeRequest.ajax?amount=" + amount + "&body=" + body, true);
    xhttp.send();
}

function viewEmployeeRequests() {
    console.log("Get employee's requests");
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
          if (xhttp.responseText != "[]") {
            document.getElementById("sandboxDiv").innerHTML = xhttp.responseText;
          }
          else {
              document.getElementById("sandboxDiv").innerHTML = "You haven't made any requests.";
          }
        }
    };
    xhttp.open("POST", "http://localhost:8080/ERS/ViewEmployeeRequests.ajax", true);
    xhttp.send();
}

function getEmployee() {
    console.log("Get employee");
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
          
            document.getElementById("sandboxDiv").innerHTML = xhttp.responseText;
        }
    };
    xhttp.open("POST", "http://localhost:8080/ERS/GetEmployee.ajax", true);
    xhttp.send();
}

function setValues(ajaxObject) {
    document.getElementById("message").innerHTML = ajaxObject.message;
}