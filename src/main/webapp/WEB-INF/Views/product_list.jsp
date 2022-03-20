<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="bootstrap.jsp"></jsp:include>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="#">Product Database</a>
  </nav>
<table class="table table-hover">
  <caption>List of Products</caption>

  <thead class="thead-dark">
    <tr>
      <th scope="col">Product Image</th>
      <th scope="col">Product Name</th>
      <th scope="col">Product Description</th>
      <th scope="col">Product Price</th>
      <th scope="col">Edit</th>
      <th scope="col">Delete</th> 
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${plist}" var="product">
    <tr>
      <th scope="row"><img alt="" src="data:image/jpeg;base64,${product.image}" style="width: 100px;height: 100px;"></th>
      <td>${product.name}</td>
      <td>${product.description}</td>
      <td>${product.price}</td>
      <td><a class="btn btn-info" href="<c:url value='/change-${product.id}-ok' />"role="button">update</a></td>
      <td><a class="btn btn-danger" href="<c:url value='/delete-${product.id}-product' />"role="button">delete</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>

<br>
<a class="btn btn-secondary" href="<c:url value='/new' />" role="button">Add Products</a>
<a class="btn btn-secondary" href="<c:url value='/index' />" role="button">Show Website</a>
<a class="btn btn-secondary" href="<c:url value='/catagory' />" role="button">Add Category</a>

</div>
</body>
</html>