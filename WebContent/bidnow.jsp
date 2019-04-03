<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.user.Car"%>
<%@ page import="java.util.ArrayList"%>
<%
	Car carDetails = (Car) session.getAttribute("carDetails");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
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
<link rel="stylesheet" href="styles/style3.css" type="text/css">
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
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="navbar navbar-dark bg-dark shadow-sm">
			<div class="container d-flex justify-content-between">
				<a href="http://localhost:8080/ServletTutorial/home"
					class="navbar-brand d-flex align-items-center"> <svg
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
				<h1 class="fancyTitle">Big Now</h1>
				<p>Please a bid on this vehicle</p>
				<img alt="" width="100%" height="45%"
					src="img/${carDetails.imagePath}">
				<form method="get" action="PurchaseFormServlet" name="buyForm"
					enctype="multipart/form-data">
					<div class="form-group">
						<label for="buyerFirstName">First Name: </label> <input
							type="text" class="form-control" name="buyerFirstName"
							id="buyerFirstName" placeholder="Enter your first name" required>
					</div>
					<div class="form-group">
						<label for="buyerLastName">Last Name: </label> <input type="text"
							class="form-control" name="buyerLastName" id="buyerLastName"
							placeholder="Enter last name" required>
					</div>
					<div class="form-group">
						<label for="inputBid">Your offer: </label> <input type="number"
							class="form-control" name="inputBid" id="inputBid"
							placeholder="Enter an amount">
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
					<a type="submit" class="btn btn-danger"
						href="http://localhost:8080/ServletTutorial/home">Cancel</a>

				</form>
			</div>
			<div class="col"></div>
		</div>
	</div>

























	<!--  	<div>
		<div class="container mainForm">
			<div class="row">
				<div class="col"></div>
				<div class="col-6 placeBorderHere">
					<h1 class="fancyTitle">Purchase This Vehicle</h1>

					<p>Below are the details of this vehicle</p>
					<img alt="" width="100%" height="50%"
						src="img/${carDetails.imagePath}">
					<div class="carDetails">
						<p>
							<strong>Make: </strong>
					out.print(carDetails.getMake());				%>
						</p>
						<p>
							<strong>Model: </strong>
					out.print(carDetails.getModel());				%>
						</p>
						<p>
							<strong>Year: </strong>
					out.print(carDetails.getYear());				%>
						</p>
						<p>
							<strong>Mileage: </strong>
					out.print(carDetails.getMileage());				%>
						</p>
						<p>
							<strong>Price: </strongout.print(carDetails.getPrice());				%>
						</p>
						<p>
							<strong>Description: </strong>
					out.print(carDetails.getDescription());				%>
						</p>
					<form method="post" action="upload">
							<div class="form-group">
								<label for="buyerFirstName">First Name: </label> <input type="text"
									class="form-control" name="buyerFirstName"
									placeholder="Enter your first name">
							</div>
							<div class="form-group">
								<label for="buyerLastName">Last Name: </label> <input type="text"
									class="form-control" name="buyerLastName"
									placeholder="Enter your last name">
							</div>
						</form> 
					</div>

				</div>
				<div class="col"></div>
			</div>
		</div>  --> </main>

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