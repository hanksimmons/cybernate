<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Employee Home</title>
</head>

<body>
	<!-- MAKE REQUEST || Submit ID = "submit Request" || PARAM ID's = "requestAmount" "requestBody"-->
<div>
	<h4>Request a Reimbursement:</h4>

		<input type="text" id="requestAmount" name="requestAmount"
			placeholder="How much $ would you like reimbursed?" charset="utf-8"> <input
			type="text" id="requestBody" name="requestBody"
			placeholder="What are we reimbursing you for?">

		<button type="button" id="submitRequest">Submit Request</button>
	<div>
	
			<button type="button" id="viewRequests">Review Your Past Requests</button>

	</div>
	</div>

	
	<div>
		<button type="button" id="getEmployeeButton">View My Employee Info</button>
	</div>
	<!-- LOGOUT -->
	<div>
			<button type="button" id="logout">Logout</button>
	</div>
	
		<div id="sandboxDiv"></div>

	<script type="text/javascript" src="resources/js/employeehome.js"></script>
</body>

</html>