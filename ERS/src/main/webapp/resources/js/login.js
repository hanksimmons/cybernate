window.onload = function () {
    document.getElementById("login").addEventListener("click", employeeLogin);
    document.getElementById("managerLogin").addEventListener("click", managerLogin);
};

function employeeLogin() {
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    console.log("Login as : " + email + " " + password);
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            var ajaxObject = JSON.parse(xhttp.responseText);
            setValues(ajaxObject);
        }
    };
    xhttp.open("POST", "http://localhost:8080/ERS/employeeLogin.ajax?firstname=" + username + "?lastname=" + lastname + "?email=" + email + "?password=" + password, true);
    xhttp.send();
}

function managerLogin() {
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    console.log("Viewing all employees");
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            var ajaxObject = JSON.parse(xhttp.responseText);
            setValues(ajaxObject);
        }
    };
    xhttp.open("POST", "http://localhost:8085/Expenses/managerLogin.ajax?email=" + email + "?password=" + password, true);
    xhttp.send();
}

function setValues(ajaxObject) {
    document.getElementById("message").innerHTML = ajaxObject.message;
}