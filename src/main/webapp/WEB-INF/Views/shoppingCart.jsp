<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>

    <link href="<c:url value="/CSS/mystyle.css" />" rel="stylesheet">

   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="mystyle.css">
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

    <script src="https://kit.fontawesome.com/c015bc8299.js" crossorigin="anonymous"></script>

    <script src="https://kit.fontawesome.com/c015bc8299.js" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<div class="container px-3 my-5 clearfix">
    <!-- Shopping cart table -->
    <div class="card">
        <div class="card-header">
            <h2>Shopping Cart</h2>
        </div>
        <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered m-0">
                <thead>
                  <tr>
                    <!-- Set columns width -->
                    <th class="text-center py-3 px-4" style="min-width: 400px;">Product Name &amp; Details</th>
                    <th class="text-right py-3 px-4" style="width: 100px;">Price</th>
                    <th class="text-right py-3 px-4" style="width: 100px;">Total</th>
                    <th class="text-center align-middle py-3 px-0" style="width: 40px;"><a href="#" class="shop-tooltip float-none text-light" title="" data-original-title="Clear cart"><i class="ino ion-md-trash"></i></a></th>
                  </tr>
                </thead>
                <tbody>
        <c:forEach items="${shoppingCart.cartProducts}" var="cart">
                  <tr>
                    <td class="p-4">
                      <div class="media align-items-center">
                        <img src="data:image/jpeg;base64,${cart.product.image}" class="d-block ui-w-40 ui-bordered mr-4" alt="">
                        <div class="media-body">
                          <a href="#" class="d-block text-dark">${cart.product.name}</a>
                          <small>
                            
                            <span class="text-muted">Description: </span> ${cart.product.description}
                          </small>
                        </div>
                      </div>
                    </td>
                    <td class="text-right font-weight-semibold align-middle p-4">$ ${cart.product.price}</td>
                    <td class="text-right font-weight-semibold align-middle p-4">$ ${cart.product.price}</td>
                    <td class="text-center align-middle px-0"><a href="#" class="shop-tooltip close float-none text-danger" title="" data-original-title="Remove">remove</a></td>
                  </tr>
        </c:forEach>
                </tbody>
              </table>
            </div>
            <!-- / Shopping cart table -->
        
            <div class="d-flex flex-wrap justify-content-between align-items-center pb-4">
              <div class="mt-4">
                <label class="text-muted font-weight-normal">Promocode</label>
                <input type="text" placeholder="ABC" class="form-control">
              </div>
              
                <div class="text-right mt-4">
                  <label class="text-muted font-weight-normal m-0">Grand Total</label>
                  <div class="text-large"><strong>$ ${shoppingCart.totalPrice}</strong></div>
                </div>
              </div>
            </div>
        
            <div class="float-right">
             
              <a type="button" href="<c:url value = '/index'></c:url> "class="btn btn-lg btn-secondary md-btn-flat mt-2 mr-3">Back to shopping</a>
              <button type="button" class="btn btn-lg btn-primary md-btn-flat mt-2 mr-3"  data-bs-toggle="modal" data-bs-target="#addModel">CheckOut</button>
            </div>
            
            
            <div class="modal fade" id="addModel" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Payment</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>


							<div class="modal-body">

								<form method="post" action="/shoppingCart">
									
										<h3>Payment</h3>
										<label>Accepted Cards</label>
										<div class="icon-container">
											<i class="fa fa-cc-visa" style="color: navy;"></i> <i
												class="fa fa-cc-amex" style="color: blue;"></i> <i
												class="fa fa-cc-mastercard" style="color: red;"></i> <i
												class="fa fa-cc-discover" style="color: orange;"></i>
										</div>
										<br>
										
										<div class="form-group">
										<label for="price">Total</label><br>
										<input type="text" id="price" name="price" value="${shoppingCart.totalPrice}"> 
										</div>
										<br>
										<div class="form-group">
										<label for="currency">Currency</label><br>
										<input  type="text" id="currency" name="currency" value="USD" placeholder="Enter Currency">
										</div>
										<br>
										<div class="form-group">
									    <label for="method">PaymentMethod</label><br>
										<input  type="text" id="method" name="method"placeholder="Payment Method" value ="paypal">
										</div>
										<br>
										<div class="form-group">
									    <label for="intent">Intent</label><br>
										<input  type="text" id="intent" name="intent" value="sale">
										</div>
										<br>
										<div class="form-group">
										<label for="description">Payment Description</label><br>
										<input  type="text" id="description" name="description" placeholder="Payment Description"value="test">
										</div>
										<br>
										<br>

									
									<input type="submit" value="Continue to checkout" class="btn btn-primary">


								</form>


							</div>
							<div  class="modal-footer">
										
											<button type="button" class="btn btn-secondary"
												data-bs-dismiss="modal">Close</button>
										
									</div>
								</div>
							</div>
						</div>
            
          </div>
      </div>
  </div>
</body>
</html>