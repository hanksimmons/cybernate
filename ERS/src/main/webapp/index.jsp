<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div>
<p>
<h1>Henry's Expense Reimbursement System</</p>
</div>

	<div>
		<form method="post" action="login.do">
			<input type="text" id="email" name="email"
				placeholder="Enter your email!" /> <input type="password"
				id="password" name="password" placeholder="Enter your password!" />
			<input type="submit" id="submit" value="Login"
				style="color: Fuchsia; width: 147px; height: 40px" />
		</form>
	</div>

	<div>
		<form method="post" action="loginmanager.do">
			<input type="text" id="email" name="email"
				placeholder="Enter your email!" /> <input type="password"
				id="password" name="password" placeholder="Enter your password!" />
			<input type="submit" id="submit" value="Manager Login"
				style="color: Fuchsia; width: 147px; height: 40px" />
		</form>
	</div>
	
	<div id="dialogue">
	<!-- DOM MANIPULATION HERE  -->
	</div>


</body>
</html>