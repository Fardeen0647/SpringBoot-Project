<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>



<link href="<c:url value="/CSS/mystyle.css" />" rel="stylesheet">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="mystyle.css">
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"></script>

<script src="https://kit.fontawesome.com/c015bc8299.js"
	crossorigin="anonymous"></script>

<script src="https://kit.fontawesome.com/c015bc8299.js"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>


</head>
<body bgcolor="#F1F3F6">

	<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
		<div class="container-fluid">
			<!-- <a class="navbar-brand" href="#">Online Shopping</a> -->
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<form class="d-flex">
						<input size="100%" class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button style="background-color: white; color: black;"
							class="btn btn-cust" type="submit">Search</button>
					</form>

				</ul>
				<div class="d-flex">
					<a class="nav-link active" aria-current="page" href="#"><i
						style="color: white;" class="fas fa-bell"></i></a>
				</div>
				<div class="d-flex">
					<a class="nav-link active" aria-current="page" href="#"><i
						style="color: white;" class="fas fa-cart-plus"></i></a>
				</div>
				<div class="d-flex">
					<a class="nav-link active" aria-current="page" href="#"><i
						style="color: white;" class="fas fa-user-circle"></i></a>
				</div>

			</div>
		</div>
	</nav>

	<div class="sidebar-container">
		<div class="sidebar-logo">Online Shopping</div>
		<ul class="sidebar-navigation">
			<li><a href="#"> <i class="fa fa-home" aria-hidden="true"></i>
					Homepage
			</a></li>
			<li><a href="<c:url value='/shoppingCart'/>"> <i
					class="fas fa-shopping-cart"></i> Orders
			</a></li>

			<li><a href="#"> <i class="fa fa-users" aria-hidden="true"></i>
					About us
			</a></li>
			<li><a href="#"> <i class="fa fa-info-circle"
					aria-hidden="true"></i> FAQ
			</a></li>
			<li><a href="#"> <i class="fa fa-cog" aria-hidden="true"></i>
					Logout
			</a></li>
		</ul>
	</div>

	<div class="content-container">

		<div class="container-fluid">

			<div id="carouselExampleFade" class="carousel slide carousel-fade"
				data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="<c:url value ="/pics/variation-2.jpeg"/>"
							class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="<c:url value ="/pics/variation-2.jpeg"/>"
							class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="<c:url value ="/pics/variation-2.jpeg"/>"
							class="d-block w-100" alt="...">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleFade" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleFade" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>

			<br>

			<table class="table" border="2">

				<tr align="center">
					<c:forEach items="${categoriesList}" var="category">
						<th scope="col"><a class="btn btn-custom"
							href="<c:url value="category-${category.cid}-cid"></c:url>"
							role="button">${category.name}</a></th>
					</c:forEach>
					<!-- <th scope="col"><a class="btn btn-custom" href="#" role="button">Electronics</a>
      </th>
      <th scope="col"><a class="btn btn-custom" href="#" role="button">Dresses</a>
      </th>
      <th scope="col"><a class="btn btn-custom" href="#" role="button">All Categories</a>
      </th>
 -->
				</tr>
			</table>
			<br>

			<div class="row row-cols-1 row-cols-md-3 g-4">
				<c:forEach items="${allProducts}" var="product">
					<div class="col">
						<div class="card">
							<img src="data:image/jpeg;base64,${product.image}"
								class="card-img-top" alt="...">
							<div class="card-body">
								<h5 class="card-title">${product.name}</h5>
								<p class="card-text">${product.description}</p>
								<a href="<c:url value = "add-${product.id}-cart"></c:url>"
									class="btn btn-outline-primary">${product.price}</a> <a href=""
									class="btn btn-primary" data-bs-toggle="modal"
									data-bs-target="#addModel${product.id}">Add to cart</a>



								<div class="modal fade" id="addModel${product.id}" tabindex="-1"
									aria-labelledby="exampleModalLabel" aria-hidden="true">
									<div class="modal-dialog modal-dialog-centered">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLabel">${product.name}</h5>
												<button type="button" class="btn-close"
													data-bs-dismiss="modal" aria-label="Close"></button>
											</div>


											<div class="modal-body">

												<div class="card">
													<img src="data:image/jpeg;base64,${product.image}"
														class="card-img-top" alt="...">
													<div class="card-body">
														<h5 class="card-title">${product.name}</h5>
														<p class="card-text">${product.description}</p>
													</div>
												</div>


												<h5>
													${product.price}
													</h3>
											</div>
											<div class="modal-footer">
												<form:form modelAttribute="cart" action="/add-to-cart"
													method="POST">
													<form:input path="id" type="hidden" id="id"
														value="${product.id}" />

													<button type="button" class="btn btn-secondary"
														data-bs-dismiss="modal">Close</button>
													<button type="submit" class="btn btn-primary">Add</button>
												</form:form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>


				</c:forEach>
			</div>



			<di v class="row row-cols-1 row-cols-md-3 g-4">
				<c:forEach items="${categoryProducts}" var="product">
					<div class="col">
						<div class="card">
							<img src="data:image/jpeg;base64,${product.image}"
								class="card-img-top" alt="...">
							<div class="card-body">
								<h5 class="card-title">${product.name}</h5>
								<p class="card-text">${product.description}</p>
								<a href='<c:url value = "add-${product.id}-cart"></c:url>'
									class="btn btn-primary">${product.price}</a>

							</div>
						</div>
					</div>
				</c:forEach>
			</div>


		</div>

	</div>

	<br>




</body>
</html>