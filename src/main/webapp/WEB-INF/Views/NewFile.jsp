<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Online Shopping</title>

<script src="https://kit.fontawesome.com/c015bc8299.js"
	crossorigin="anonymous"></script>

<script src="https://kit.fontawesome.com/c015bc8299.js"
	crossorigin="anonymous"></script>

<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700"
	rel="stylesheet">

<!-- Bootstrap -->
<link type="text/css" rel="stylesheet" href="CSS/bootstrap.min.css" />

<!-- Slick -->
<link type="text/css" rel="stylesheet" href="CSS/slick.css" />
<link type="text/css" rel="stylesheet" href="CSS/slick-theme.css" />

<!-- nouislider -->
<link type="text/css" rel="stylesheet" href="CSS/nouislider.min.css" />

<!-- Font Awesome Icon -->
<link rel="stylesheet" href="CSS/font-awesome.min.css">

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="CSS/style.css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>
<body>
	<!-- HEADER -->
	<header>
		<!-- TOP HEADER -->
		<div id="top-header">
			<div class="container">
				<ul class="header-links pull-left">
					<li><a href="#"><i class="far fa-address-card"></i> About US</a></li>
					<li><a href="<c:url value ='/list'></c:url>"><i class="far fa-plus-square"></i> Add Product</a></li>
					<li><a href="#"><i class="fas fa-info"></i> FAQ</a></li>
				</ul>
				<ul class="header-links pull-right">
					<li><a href="#"><i class="fa fa-user-o"></i> My Account</a></li>
				</ul>
			</div>
		</div>
		<!-- /TOP HEADER -->

		<!-- MAIN HEADER -->
		<div id="header">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<!-- LOGO -->
					<div class="col-md-3">
						<div class="header-logo">
							<a href="#" class="logo">
								<h2 style="color: white;">Online Shopping</h2>
							</a>
						</div>
					</div>
					<!-- /LOGO -->

					<!-- SEARCH BAR -->
					<div class="col-md-6">
						<div class="header-search">
							<form>
								<select class="input-select">
									<option value="0">All Categories</option>
									<option value="1">Category 01</option>
									<option value="1">Category 02</option>
								</select> <input class="input" placeholder="Search here">
								<button class="search-btn">Search</button>
							</form>
						</div>
					</div>
					<!-- /SEARCH BAR -->

					<!-- ACCOUNT -->
					<div class="col-md-3 clearfix">
						<div class="header-ctn">
							<!-- Wishlist -->
							<div>
								<a href="#"> <i class="fa fa-heart-o"></i> <span>Your
										Wishlist</span>
									<div class="qty">2</div>
								</a>
							</div>
							<!-- /Wishlist -->

							<!-- Cart -->
							<div class="dropdown">
								<a class="dropdown-toggle" data-toggle="dropdown" href="<c:url value='/shoppingCart'/>"
									aria-expanded="true"> <i class="fa fa-shopping-cart"></i> <span>Your
										Cart</span>	
								</a>
								
							</div>
							<!-- /Cart -->

							
						</div>
					</div>
					<!-- /ACCOUNT -->
				</div>
				<!-- row -->
			</div>
			<!-- container -->
		</div>
		<!-- /MAIN HEADER -->
	</header>
	<!-- /HEADER -->

	<!-- NAVIGATION -->
	<nav id="navigation">
		<!-- container -->
		<div class="container">
			<!-- responsive-nav -->
			<div id="responsive-nav">
				<!-- NAV -->
				<ul class="main-nav nav navbar-nav">
					<li class="active"><a href="<c:url value='/index'></c:url>">Home</a></li>
					<c:forEach items="${categoriesList}" var="category">
						<li><a
							href="<c:url value="category-${category.cid}-cid"></c:url>">${category.name}</a></li>
					</c:forEach>

				</ul>
				<!-- /NAV -->
			</div>
			<!-- /responsive-nav -->
		</div>
		<!-- /container -->
	</nav>
	<!-- /NAVIGATION -->

	<!-- SECTION -->
	
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<!-- section title -->
					<div class="col-md-12">
						<div class="section-title">
							<h3 class="title">New Products</h3>
							<div class="section-nav">
								<ul class="section-tab-nav tab-nav">
								<c:forEach items="${categoriesList}" var="category">
									<li class="t"><a data-toggle="tab" href="<c:url value = "category-${category.cid}-cid"></c:url>">${category.name}</a></li>
								</c:forEach>	
								</ul>
							</div>
						</div>
					</div>
					<!-- /section title -->
					</div>

					<!-- /container -->
				</div>
				<!-- /SECTION -->
        </div>

				<div class="section">
					<!-- container -->
					<div class="container">
						<!-- row -->
						<div class="row">
							<c:forEach items="${allProducts}" var="product">
								<div class="col-md-3 col-xs-6">
									<div class="product">
										<div class="product-img">
											<img src="data:image/jpeg;base64,${product.image}" alt="">
											<div class="product-label">
												<span class="sale">-30%</span> <span class="new">NEW</span>
											</div>
										</div>
										<div class="product-body">
											<p class="product-category">Product</p>
											<h3 class="product-name">
												<a href="#">${product.name}</a>
											</h3>
											<p class="text">${product.description}</p>
											<h4 class="product-price">$ ${product.price}</h4>
											<div class="product-rating">
												<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i>
											</div>

										</div>
								 <div class="add-to-cart">
										<form:form modelAttribute="cart" method="POST" action="/add-to-cart">
										<form:input path="id" type="hidden" id="id" value="${product.id}"/>

									   <button type="submit" class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
								       </form:form>
									</div>


										



									</div>
								</div>
							</c:forEach>

						</div>
						<!-- /row -->
						
						<div class="row">
							<c:forEach items="${categoryProducts}" var="product">
								<div class="col-md-3 col-xs-6">
									<div class="product">
										<div class="product-img">
											<img src="data:image/jpeg;base64,${product.image}" alt="">
											<div class="product-label">
												<span class="sale">-30%</span> <span class="new">NEW</span>
											</div>
										</div>
										<div class="product-body">
											<p class="product-category">Product</p>
											<h3 class="product-name">
												<a href="#">${product.name}</a>
											</h3>
											<p class="text">${product.description}</p>
											<h4 class="product-price">$ ${product.price}</h4>
											<div class="product-rating">
												<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i>
											</div>

										</div>
								 <div class="add-to-cart">
										<form:form modelAttribute="cart" method="POST" action="/add-to-cart">
										<form:input path="id" type="hidden" id="id" value="${product.id}"/>

									   <button type="submit" class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
								       </form:form>
									</div>



									</div>
								</div>
							</c:forEach>

						</div>
						
						
					</div>
					<!-- /container -->
				</div>








				<!-- NEWSLETTER -->
				<div id="newsletter" class="section">
					<!-- container -->
					<div class="container">
						<!-- row -->
						<div class="row">
							<div class="col-md-12">
								<div class="newsletter">

									<ul class="newsletter-follow">
										<li><a href="#"><i class="fa fa-facebook"></i></a></li>
										<li><a href="#"><i class="fa fa-twitter"></i></a></li>
										<li><a href="#"><i class="fa fa-instagram"></i></a></li>
										<li><a href="#"><i class="fa fa-pinterest"></i></a></li>
									</ul>
								</div>
							</div>
						</div>
						<!-- /row -->
					</div>
					<!-- /container -->
				</div>


				<!-- jQuery Plugins -->
				<script src="js/jquery.min.js"></script>
				<script src="js/bootstrap.min.js"></script>
				<script src="js/slick.min.js"></script>
				<script src="js/nouislider.min.js"></script>
				<script src="js/jquery.zoom.min.js"></script>
				<script src="js/main.js"></script>
</body>
</html>
