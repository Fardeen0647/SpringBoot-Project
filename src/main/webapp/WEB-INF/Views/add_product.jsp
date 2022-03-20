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
    <a class="navbar-brand" href="#">Add Products</a>
  </nav>
<form:form action="" modelAttribute="product" method="POST" enctype="multipart/form-data">
   <form:input type="hidden" path="id" id="id"/>

  <div class="form-group">
    <label for="name">Product Name</label>
    <form:input path="name" type="text" class="form-control" id="sname" aria-describedby="" placeholder="Enter name"/>
    <small id="emailHelp" class="form-text text-muted"></small>
  </div>
  <div class="form-group">
    <label for="discription">Product Description</label>
    <form:input path="description" type="text" class="form-control" id="dob" placeholder="Enter your Description"/>
  </div>
  <div class="form-group">
     <label for="rollno">Product Price</label>
    <form:input path="price" type="text" class="form-control" id="price"/>
  </div>
  <div class="custom-file">
  <form:input path="image" type="file" class="custom-file-input" id="customFile"/>
  <label class="custom-file-label" for="customFile">Choose file</label>
</div>
<br>
<br>
<div class="form-group">
<form:select path="cat" cssClass="custom-select"  >
<c:forEach items="${catagories}" var="catagories">
<form:option value="${catagories.cid}">${catagories.name}</form:option>
</c:forEach>
</form:select>
</div>
<br>
<br>
  <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
</div>
</body>
</html>