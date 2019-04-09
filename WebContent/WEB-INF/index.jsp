<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.user.Car"%>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<Car> inventory = (ArrayList<Car>) session.getAttribute("inventory");
%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="keywords" content="" />

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="styles/style.css" type="text/css">

<!-- FONT -->
<link href="https://fonts.googleapis.com/css?family=Permanent+Marker"
	rel="stylesheet">
<title>Car Dealer Pro</title>
</head>
<body>
	<!-- Top Navigation Bar -->
	<header>
		<div class="collapse bg-dark" id="navbarHeader">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-md-7 py-4">
						<h4 class="text-white">About</h4>
						<p class="text-white">Welcome to Car Dealer Pro! We make it
							easy for you to buy and sell cars. We are here for you and
							welcome suggestions on how we can improve our site or service.
							Please contact us or follow us on social media.</p>
					</div>
					<div class="col-sm-4 offset-md-1 py-4">
						<h4 class="text-white">Contact</h4>
						<ul class="list-unstyled">
							<li><a href="#" class="text-white">Follow on Twitter</a></li>
							<li><a href="#" class="text-white">Like on Facebook</a></li>
							<li><a href="ReportLogServlet" class="text-white">Dashboard</a></li>
							<!-- Figured out how to use a link to go to another page and call the servlet doGet method Link: https://stackoverflow.com/questions/14637710/how-do-you-make-a-html-link-call-a-java-function-within-your-servlet & https://stackoverflow.com/questions/1907482/call-a-servlet-on-click-of-hyperlink -->
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="navbar navbar-dark bg-dark shadow-sm">
			<div class="container d-flex justify-content-between">
				<a href="#" class="navbar-brand d-flex align-items-center"> <svg
						xmlns="http://www.w3.org/2000/svg" width="20" height="20"
						fill="none" stroke="currentColor" stroke-linecap="round"
						stroke-linejoin="round" stroke-width="2" aria-hidden="true"
						class="mr-2" viewBox="0 0 24 24" focusable="false">
						<path
							d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z" />
						<circle cx="12" cy="13" r="4" /></svg> <strong
					class="fancyTitle titleLogo">Car Dealer Pro</strong>
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarHeader" aria-controls="navbarHeader"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			</div>
		</div>
	</header>

	<main role="main"> <!-- Start of form  -->

	<div class="container mainForm">
		<div class="row">
			<div class="col"></div>
			<div class="col-6 placeBorderHere">
				<h1 class="fancyTitle">Sell Your Car Fast!</h1>
				<form method="post" action="upload" name="uploadForm"
					enctype="multipart/form-data">
					<div class="form-group">
						<label for="make">Make: </label> <input type="text"
							class="form-control" name="make" id="make"
							placeholder="Enter vehicle make">
					</div>
					<div class="form-group">
						<label for="model">Model: </label> <input type="text"
							class="form-control" name="model" id="model"
							placeholder="Enter vehicle model">
					</div>
					<!--<div class="form-group">
                    <label for="inputType">Type: </label>
                    <input type="text" class="form-control" id="inputType" placeholder="Enter vehicle type">
                  </div>-->
					<div class="form-group">
						<label for="mileage">Mileage: </label> <input type="text"
							class="form-control" name="mileage" id="mileage"
							placeholder="Enter vehicle mileage">
					</div>
					<div class="form-group">
						<label for="year">Year: </label> <input type="text"
							class="form-control" name="year" id="year"
							placeholder="Enter vehicle year">
					</div>
					<div class="form-group">
						<label for="price">Price: </label> <input type="text"
							class="form-control" name="price" id="price"
							placeholder="Your Asking Price">
					</div>
					<div class="form-group">
						<label for="description">Description: </label>
						<textarea rows="6" cols="60" class="form-control"
							name="description" id="description"
							placeholder="Details about the car"></textarea>
					</div>
					<div class="form-group">
						<label for="file">Upload A Picture</label> <input type="file"
							class="form-control-file" name="fileToUpload" id="file">
					</div>
					<input type="submit" class="btn btn-primary" name="submit"
						></input>

				</form>
			</div>
			<div class="col"></div>
		</div>
	</div>
	<!-- END OF SELL FORM --> <!-------------------------- Start of buy section ------------------------------------>




	<div class="container">
		<div class="row">
			<div class="col"></div>
			<div class="col-6">
				<h1 class=" fancyTitle buySectionHeader text-center">Check Out Our Inventory!</h1>
			</div>
			<div class="col"></div>
		</div>
	</div>


	<div class="album py-5 bg-light">
		<div class="container buySection">
			<!-- 	<center>
				<form method="get" action="IndexServlet" id="buyACarForm">
					<h1 class="buySectionHeader fancyTitle">View Inventory</h1>
					<button class="btn btn-primary" type="submit" name="buyAcar">Click
						Here</button>
				</form>
			</center> -->

			<!--  <div class="collapse" id="collapseExample">
				<div class="card card-body"> -->

			<div class="row">


				<c:forEach items="${inventory}" var="myCar">
					<c:if test="${myCar.soldStatus != true}">
						<div class="col-md-4">
							<div class="card mb-4 shadow-sm">
								<img alt="" class="card-image" width="100%" height="225px"
									src="img/${myCar.imagePath}" />
								<div class="card-body">
									<div class="carDetails">
										<c:if test="${myCar.specialPricing == true}">
											<p class="specialPricingStyle">This vehicle qualifies for
												special pricing! Receive up to a 10% discount!</p>
										</c:if>
										<p>
											<strong>Make: </strong> ${myCar.make}
										</p>
										<p>
											<strong>Model: </strong> ${myCar.model}
										</p>
										<p>
											<strong>Year: </strong> ${myCar.year}
										</p>
										<p>
											<strong>Mileage: </strong> ${myCar.mileage}
										</p>
										<p>
											<strong>Price: </strong> $${myCar.price}
										</p>
										<p>
											<strong>Description: </strong> ${myCar.description}
										</p>
									</div>
									<div class="d-flex justify-content-between align-items-center">
										<div class="btn-group">
											<a href="DetailsServlet?id=${myCar.id}" type="button"
												class="btn btn-primary">View Details</a>
											<c:if test="${myCar.specialPricing == false}">
												<a href="BuyNowServlet?id=${myCar.id}" type="button"
													class="btn btn-sm btn-success bidButton">Buy Now</a>
												<!-- <button type="button"
												class="btn btn-sm btn-success bidButton" data-toggle="modal" data-target="#buyNowModal">Buy Now</button>   -->
											</c:if>
											<c:if test="${myCar.specialPricing == true}">
												<a type="button" class="btn btn-warning bidButton"
													href="BidNowServlet?id=${myCar.id}"> Bid Now</a>
											</c:if>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:if>
				</c:forEach>

			</div>
		</div>
	</div>
	</main>


	<!-- Modal For View Details Button -->
<!--  	<div class="modal fade" id="viewDetailsModal" tabindex="-1"
		role="dialog" aria-labelledby="viewDetailsModalTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="viewDetailsModalTitle">Vehicle
						Details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<h6 class="fancyTitle">About This Vehicle</h6>


					<div class="">
						<div class="card shadow-sm">
							<img alt="" class="card-image" width="100%" height="225px"
								src="img/${myCar.imagePath}" />
							<div class="card-body">
								<div class="carDetails">
									<c:if test="${myCar.specialPricing == true}">
										<p class="specialPricingStyle">This vehicle qualifies for
											special pricing! Receive up to a 10% discount!</p>
									</c:if>
									<p>
										<strong>Make: </strong> ${myCar.make}
									</p>
									<p>
										<strong>Model: </strong> ${myCar.model}
									</p>
									<p>
										<strong>Year: </strong> ${myCar.year}
									</p>
									<p>
										<strong>Mileage: </strong> ${myCar.mileage}
									</p>
									<p>
										<strong>Price: </strong> $${myCar.price}
									</p>
									<p>
										<strong>Description: </strong> ${myCar.description}
									</p>
								</div>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<c:if test="${myCar.specialPricing == false}">
											<button type="button"
												class="btn btn-sm btn-success bidButton" data-toggle="modal"
												data-target="#buyNowModal">Buy Now</button>
										</c:if>
										<c:if test="${myCar.specialPricing == true}">
											<button type="button" class="btn btn-warning bidButton"
												data-toggle="modal" data-target="#bidNowModal">Bid
												Now</button>
										</c:if>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal">Buy
						Now</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
				</div>
			</div>
		</div>
	</div> 									-->


	<!-- Modal For Buy Now Button -->
<!--  	<div class="modal fade" id="buyNowModal" tabindex="-1" role="dialog"
		aria-labelledby="buyNowModalTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="buyNowModalTitle">Buy Now</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<h6 class="fancyTitle">Purchase This Vehicle</h6>
					<form method="post" action="upload" name="uploadForm"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="modalLabel" for="firstName">First Name: </label> <input
								type="text" class="form-control" name="firstName" id="firstName"
								placeholder="Enter your name">
						</div>
						<div class="form-group">
							<label class="modalLabel" for="lastName">Last Name: </label> <input
								type="text" class="form-control" name="lastName" id="lastName"
								placeholder="Enter your last name">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal">Submit</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
				</div>
			</div>
		</div>
	</div>					-->

	<!-- Modal For Bid Now Button -->
	<div class="modal fade" id="bidNowModal" tabindex="-1" role="dialog"
		aria-labelledby="bidNowModalTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="bidNowModalTitle">Bid Now To Get
						An Awesome Deal!</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<h6 class="fancyTitle">Place an offer</h6>
					<form method="post" action="upload" name="uploadForm"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="modalLabel" for="firstName">First Name: </label> <input
								type="text" class="form-control" name="firstName" id="firstName"
								placeholder="Enter your name">
						</div>
						<div class="form-group">
							<label class="modalLabel" for="lastName">Last Name: </label> <input
								type="text" class="form-control" name="lastName" id="lastName"
								placeholder="Enter your last name">
						</div>
						<div class="form-group">
							<label class="modalLabel" for="inputBid">Your offer: </label> <input
								type="text" class="form-control" name="inputBid" id="inputBid"
								placeholder="Enter an amount">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal">Submit</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
				</div>
			</div>
		</div>
	</div>



	<!-- Footer Section -->
	<footer class="text-muted">
		<div class="container">
			<p class="float-right">
				<a href="#">Back to top</a>
			</p>
			<p>Car Dealer Pro &copy; 2019. All rights reserved.</p>
		</div>
	</footer>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>