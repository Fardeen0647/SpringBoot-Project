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


<form:form action="" modelAttribute="catagories" method="POST">
  <div class="form-group">

    
    <form:input path="cid" type="hidden" class="form-control" id="catagory"  placeholder="Enter cid"/>
  
    <label for="catagories">Set Category</label>
    <form:input path="name" type="text" class="form-control" id="catagory"  placeholder="Enter catagory"/>
  </div><br><br>
  <button type="submit" class="btn btn-primary">Submit</button>
</form:form>


</div>

</body>
</html>