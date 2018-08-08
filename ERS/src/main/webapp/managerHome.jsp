

<html>

<head>
<meta charset="utf-8" />
<title>Manager Home</title>
</head>



<!-- REGISTER EMPLOYEES || submit ID = "registerEmployee" || PARAM ID's "firstname" "lastname" "email" "password"-->

<body>
<h4>Access Employees</h4>
	<div>
		<input type="text" id="firstname" name="firstname"
			placeholder="Firstname" /> <input type="text" id="lastname"
			name="lastname" placeholder="Lastname"> <input type="text"
			id="email" name="email" placeholder="Enter your email" /> <input
			type="password" id="password" name="password"
			placeholder="Enter your password" />

		<button type="button" id="registerEmployee">Register
			Employee!</button>

	</div>

	<br>
	<!-- VIEW ALL EMPLOYEES || submit ID = "viewEmployees" -->
	<div>
		<button type="button" id="viewEmployees">View List of All Employees</button>

	</div>

	<br>

	<!-- MAKE REQUEST || submit ID = "submitRequest" || PARAM ID's "requestAmount" "requestBody" -->
	<h4>Make a Request</h4>
	<div>

		<input type="text" id="requestAmount" name="requestAmount"
			placeholder="How much $ would you like reimbursed?"> <input
			type="text" id="requestBody" name="requestBody"
			placeholder="What are we reimbursing you for?">

		<button type="button" id="submitRequest">Submit Request</button>

	</div>

	<div>


		<input type="text" id="r_id" name="r_id" placeholder="r_id">
		<button type="button" id="approveButton">Approve Request</button>
		<button type="button" id="denyButton">Deny Request</button>

	</div>

	<br>

<h4>View Known Requests</h4>

	<!-- VIEW PENDING REQUESTS || submit ID = "viewPendingRequests"  -->
	<div>
		<button type="button" id="viewAllRequests">View All
			Requests</button>
				<button type="button" id="viewPendingRequests">View Pending
			Requests</button>
				<button type="button" id="viewResolvedRequests">View Resolved
			Requests</button>
	</div>

	<h4>Requests</h4>

	<!-- <table>
		<h3>Table to populate:</h3>
		<tr>
			<th>Employee</th>
			<th>Amount</th>
			<th>Reason</th>
		</tr>
		<tr>
			<th></th>
			<th></th>
		</tr>
	</table>
 -->
	<div>
		<button type="button" id="getEmployeeButton">View Your Employee Info:</button>
	</div>

	<div id="employeeDiv"></div>



	<!-- LOGOUT -->
	<div>

		<button type="button" id="logout">Logout</button>

	</div>

	<div id="sandboxDiv"></div>


	<script type="text/javascript" src="resources/js/managerhome.js"></script>
</body>

</html>