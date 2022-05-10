<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#postName").autocomplete({
				source: "autocomplete", 
				minLength: 3,
				select: function(event, ui) {
					this.value = ui.item.label;
					$("#ID").val(ui.item.value);
					return false;
				}
			});

		});
	</script>
		<script type="text/javascript">
		$(function() {
			$("#firstName").autocomplete({
				source: "getusers", 
				minLength: 3,
				select: function(event, ui) {
					this.value = ui.item.label;
					$("#userID").val(ui.item.value);
					return false;
				}
			});

		});
	</script>
</head>
<body>


<nav class="navbar navbar-light" style="background-color: #FFBBBB">
  <form action="search.htm" method="post" class="form-inline">
    <input id="postName" type="text" name="postName" class="form-control mr-sm-2" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><input id="submit" type="submit" name="submit"></button>
    </form>
    
   <form action="searchuser.htm" method="post" class="form-inline">
   <input id="firstName" type="text" name="firstName" class="form-control mr-sm-2" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><input id="submit" type="submit" name="submit"></button>
    </form>
</nav>

<!--  

-->
</body>
</html>