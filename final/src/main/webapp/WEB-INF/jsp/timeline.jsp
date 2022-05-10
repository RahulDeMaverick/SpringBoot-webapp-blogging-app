<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>




<div style="background-color: #C2FFF9; margin:20px">
<nav  class="navbar navbar-light" style="background-color: #71DFE7;">
  <a class="navbar-brand" href="#"> Logged in sucessfully </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" style="color: white" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
       
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"></a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#"></a>
      </li>
    </ul>
  </div>
</nav>

 <%@ include file ="login.jsp" %>
 


 <form:form modelAttribute="image" action="post.htm" method="post" enctype="multipart/form-data">
 <div class="form-group" margin-left:380px;>
<label for="exampleFormControlFile1"><p>post Name</p></label>
<input type="text" id="postName" name="postName">
<br>
<br>
<div style="width: 60rem; margin-left:380px;">
<label><p>Description: </p></label>
<br>
<br>
<textarea name="description" id = "description"> </textarea>
<br>
<br><p>
Select File: </p><input type="file" name="imageFile" class="form-control-file" id="imageFile"/>  
<br>
<br>
<input type="submit" value="Submit"/>  
</div>
</div>
</form:form>

<div class="text-left" style="color:white">
  <button type="button" class="btn btn-info">
  <a  style="text-decoration:none; color:white" href="logout.htm">logout</a>
  </button>
  </div>
<br>

<div class="text-right" style="color:white">
  <button type="button" class="btn btn-info">
 <a  style="text-decoration:none; color:white" href="view.htm">view</a>
  </button> 
  </div>
<br>


</body>
</html>