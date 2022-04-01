<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp" %>
</head>
<body>
<div class="container mt-4">
<h1>Add the details</h1>
<form action="handlerproduct" method="post">
<div class="mb-3">
  <label for="name" class="form-label">Product Name</label>
  <input type="text" class="form-control" id="name" name="name" placeholder="Enter the name of the product">
</div>
<div class="mb-3">
  <label for="description" class="form-label">Product Description</label>
  <textarea class="form-control" id="description" name="description" rows="2"></textarea>
</div>
<div class="mb-3">
  <label for="price" class="form-label">Product price</label>
  <input type="text" class="form-control" id="price" name="price" placeholder="Enter the Price of the product">
</div>
<a class="btn btn-primary" href="${pageContext.request.contextPath}/" role="button">Back</a>
<button type="submit" class="btn btn-success">Add</button>
</form>
</div>
</body>
</html>