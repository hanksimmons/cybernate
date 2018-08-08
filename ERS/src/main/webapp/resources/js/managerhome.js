window.onload = function () {
	document.getElementById("logout").addEventListener("click", logout);
    document.getElementById("registerEmployee").addEventListener("click", registerEmployee);
    document.getElementById("viewEmployees").addEventListener("click", viewEmployees);
    document.getElementById("submitRequest").addEventListener("click", makeRequest);
    document.getElementById("getEmployeeButton").addEventListener("click", getEmployee);
    document.getElementById("viewAllRequests").addEventListener("click", viewAllRequests);
    document.getElementById("viewPendingRequests").addEventListener("click", viewPendingRequests);
    document.getElementById("viewResolvedRequests").addEventListener("click", viewResolvedRequests);
    document.getElementById("approveButton").addEventListener("click", approveRequest);
    document.getElementById("denyButton").addEventListener("click", denyRequest);

};

//////////////////////////////////////////////////

function registerEmployee() {
	console.log("register employee called")
	
    var firstname = document.getElementById("firstname").value;
    var lastname = document.getElementById("lastname").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    console.log("Register Employee with: " + firstname + " " + lastname + " " + email + " " + password);
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {

        	////////DOM MANIPULATION
        		if (xhttp.responseText != null) {}
        			document.getElementById("sandboxDiv").innerHTML = xhttp.responseText;
        		}
        else {
        	xhttp.responseText = "Please fill all the required fields."
        }


        }
  
    xhttp.open("POST", "http://localhost:8080/ERS/registerEmployee.ajax?firstname=" + firstname + "&lastname=" + lastname + "&email=" + email + "&password=" + password, true);
    xhttp.send();
}

///////////////////////////////////////////////////

function viewEmployees() {
    console.log("Viewing all employees");
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            document.getElementById("sandboxDiv").innerHTML = xhttp.responseText;

        }
    };
    xhttp.open("POST", "http://localhost:8080/ERS/viewAllEmployees.ajax", true);
    xhttp.send();
}

function viewAllRequests() {
    console.log("Viewing all requests");
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            document.getElementById("sandboxDiv").innerHTML = xhttp.responseText;

        }
    };
    xhttp.open("POST", "http://localhost:8080/ERS/ViewAllRequests.ajax", true);
    xhttp.send();
}

function viewPendingRequests() {
    console.log("Viewing all pending requests");
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            document.getElementById("sandboxDiv").innerHTML = xhttp.responseText;

        }
    };
    xhttp.open("POST", "http://localhost:8080/ERS/ViewPendingRequests.ajax", true);
    xhttp.send();
}

function viewResolvedRequests() {
    console.log("Viewing all pending requests");
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            document.getElementById("sandboxDiv").innerHTML = xhttp.responseText;

        }
    };
    xhttp.open("POST", "http://localhost:8080/ERS/ViewResolvedRequests.ajax", true);
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

function makeRequest() {
    var amount = document.getElementById("requestAmount").value;
    var body = document.getElementById("requestBody").value;

    console.log("Making request for $" + amount + ", body: " + body);
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            document.getElementById("sandboxDiv").innerHTML = "request made for " + amount;
        }
    };
    xhttp.open("POST", "http://localhost:8080/ERS/makeRequest.ajax?amount=" + amount + "&body=" + body, true);
    xhttp.send();
}

function approveRequest() {
    var r_id = document.getElementById("r_id").value;

    console.log("Approving r_id:" + r_id);
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            document.getElementById("sandboxDiv").innerHTML = xhttp.responseText;
        }
    };
    xhttp.open("POST", "http://localhost:8080/ERS/approveRequest.ajax?r_id=" + r_id, true);
    xhttp.send();
}

function denyRequest() {
    var r_id = document.getElementById("r_id").value;

    console.log("Denying r_id:" + r_id);
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            document.getElementById("sandboxDiv").innerHTML = xhttp.responseText;
        }
    };
    xhttp.open("POST", "http://localhost:8080/ERS/denyRequest.ajax?r_id=" + r_id, true);
    xhttp.send();
}

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

function setValues(ajaxObject) {
    document.getElementById("message").innerHTML = ajaxObject.message;
}