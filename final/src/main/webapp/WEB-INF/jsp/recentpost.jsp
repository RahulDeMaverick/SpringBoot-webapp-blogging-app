<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recents</title>
</head>
<body style="width:30%; margin-left: 0px; border: 1px solid black">

<c:forEach var="image" items="${posting}">

<div class="accordion" id="accordionExample">


  <div class="accordion-item">
    <p class="accordion-header" id="headingOne">
      <p class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
        <a href="searchrecent.htm/${image.postName}">${image.postName}</a>
      </p>
    </p>
    
  </div>
 
</div>

</c:forEach>








</body>
</html>