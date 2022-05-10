<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/home.css" type="text/css">
	<!--  -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
</head>
<body>
		<div class="form">

		<div class="buttons">
			<label for="chbox" class="login btn"><span>Login</span></label>
			<label for="chbox" class="SignUp btn"><span>SignUp</span></label>
		</div>
		
		<input type="checkbox" id="chbox">	
		<div class="layer"></div>
		<div class="layer2"></div>
		<div class="login_form">
		<form action="signup.htm" method="post">
			<br><input type="text" name="uname" placeholder="Username"><br>
			<input type="password" name="upass" placeholder="password"><br>
					    <input type="submit" name="login" value="login"/>
       		<input type="hidden" name="page" value="login"/>
  			</form>
		</div>

		<div class="SignUp_form" >
			<form:form modelAttribute="user" method="post" action="login.htm">
			<br><input type="text" name="firstName" placeholder="Name"><br>
			<input type="text" name="lastName" placeholder="lastname"><br>
			<input type="email" name="email" placeholder="E-Mail"><br>
			<input type="password" name="password" placeholder="password"><br>
		    <input type="submit" name="signup" value="signup"/>
  			</form:form>
		</div>

	</div>
</body>
</html>
