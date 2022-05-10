<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div style="background-color: #C2FFF9; margin:20px">
<nav  class="navbar navbar-light" style="background-color: #71DFE7;">
  <a class="navbar-brand" href="#"> Edit Page</a>
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

<form:form modelAttribute="image" action="${pageContext.request.contextPath}/update.htm" method="post" enctype="multipart/form-data" >
<img src="/foodapp/images/${requestScope.posting.imagePath}" width="300" height="300">

  <div class="form-group row">
    <label for="Description" class="col-sm-2 col-form-label">Description:</label>
    <div class="col-sm-6">
  <input type="text" class="form-control" id="postName" name="postName" size="30" value="${requestScope.posting.postName}">
      <form:input class="form-control" id="inputEmail3" placeholder="Description" path="description" size="30" /><br>
      
      <input id="id" name="id" type="hidden" value="${requestScope.posting.id}"/>
      <p>Please upload new image</p>
<br><p>
Select File: </p> <input type="file" name="imageFile" class="form-control-file" id="imageFile"/> 
    </div>
  </div>
  <div class="text-center">

  <input type="submit" value="Submit"/>  
 
  </div>
  </form:form>
</div>


</body>
</html>