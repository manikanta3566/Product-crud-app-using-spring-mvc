<html>
<head>
<%@include file="./base.jsp" %>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div class="container">


<h1 class="text-center">Welcome to Product App</h1>
<table class="table table-striped mt-4" >
  <thead>
    <tr>
      <th scope="col">Product name</th>
      <th scope="col">Product Description</th>
      <th scope="col">Product Price</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${products}" var="product">
    <tr>
      <td>${product.name}</td>
      <td>${product.description}</td>
      <td>${product.price}</td>
      <td><a href="update/${product.id}" class="btn btn-success" style=margin-right:20px;>Update</a>
      <a href="delete/${product.id}" class="btn btn-danger">Delete</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<a href="addproduct" type="button" class="btn btn-primary mt-3">Add Product</a>


</div>
</body>
</html>
