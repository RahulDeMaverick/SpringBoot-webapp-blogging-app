<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.0.272/jspdf.debug.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
</head>


<body style="background-color:#D8E3E7">

<div style="background-color: #C2FFF9; margin:20px">
<nav  class="navbar navbar-light" style="background-color: #71DFE7;">
  <a class="navbar-brand" href="#"> Your feed </a>
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
</div>


  <div class="card col-6" style="width: 60rem; margin-left:380px; background-color:#F0FFF3">
  <div class="card-body">
 <input class="card-title" type="button" value="download" id="btnPrint" />
<h5 class="card-title">${image.postName}</h5>
<p class="card-text">Description:</p>
    <p class="card-text">${image.description}<small class="text-muted"></small></p>
   
    </div>
      <img class="card-img-bottom" src="/foodapp/images/${image.imagePath}" alt="Card image cap">
	<hr><a href="/foodapp/update.htm/${image.id}">update</a>
<br>
<a href="/foodapp/delete.htm/${image.id}">delete</a>

</div>
 
<div class="text-left" style="color:white">
  <button type="button" class="btn btn-info">
  <a  style="text-decoration:none" href="logout.htm">logout</a>
  </button>
  </div>
<br>

<div class="text-right" style="color:white">
  <button type="button" class="btn btn-info">
 <a  style="text-decoration:none" href="/foodapp/view.htm">view</a>
  </button> 
  </div>
<br>

</body>
<script type="text/javascript">
    $("#btnPrint").click(function () {
        let doc = new jsPDF('p', 'pt', 'a4');
        doc.addHTML(document.body, function () {
            doc.save("Recipie");
        });
    });
</script>
</html>