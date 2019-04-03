<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.user.Car"%>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<Car> inventory = (ArrayList<Car>) session.getAttribute("inventory");
%>
<%
	ArrayList<Car> searchByMakeDataList = (ArrayList<Car>) session.getAttribute("searchByMakeDataList");
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="styles/dashboard.css" type="text/css">
<!-- FONT -->
<link href="https://fonts.googleapis.com/css?family=Permanent+Marker"
	rel="stylesheet">
<title>Car Dealer Pro Dashboard</title>
</head>


<body>
	<form method="get" action="SearchServlet">
		<nav
			class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
			<a class="navbar-brand col-sm-3 col-md-2 mr-0" href="http://localhost:8080/ServletTutorial/home"><strong
				class="fancyTitle titleLogo">Car Dealer Pro</strong></a> <input
				class="form-control form-control-dark w-100" type="text"
				placeholder="Search" aria-label="Search" name="Search">
			<ul class="navbar-nav px-3">
				<li class="nav-item text-nowrap"><a class="nav-link" href="#">Sign
						out</a></li>
			</ul>
		</nav>
	</form>
	<div class="container-fluid">
		<div class="row">
			<nav class="col-md-2 d-none d-md-block bg-light sidebar">
				<div class="sidebar-sticky">
					<ul class="nav flex-column">
						<li class="nav-item"><a class="nav-link active" href="ReportLogServlet">
								<span data-feather="home"></span> Dashboard <span
								class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file"></span> Bid Nows
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="shopping-cart"></span> Sold
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="users"></span> Customers
						</a></li>
						<!--  	<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="bar-chart-2"></span> Reports
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="layers"></span> Integrations
						</a></li>  -->
					</ul>

					<!--  		<h6
						class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
						<span>Saved reports</span> <a
							class="d-flex align-items-center text-muted" href="#"> <span
							data-feather="plus-circle"></span>
						</a>
					</h6>
					<ul class="nav flex-column mb-2">
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> Current month
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> Last quarter
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> Social engagement
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> Year-end sale
						</a></li>
					</ul> -->
				</div>
			</nav>

			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
			<!--<div
				class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
				<h1 class="h2">Dashboard</h1>
				<div class="btn-toolbar mb-2 mb-md-0">
					<div class="btn-group mr-2">
						<button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
						<button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
					</div>
					<button type="button"
						class="btn btn-sm btn-outline-secondary dropdown-toggle">
						<span data-feather="calendar"></span> This week
					</button>
				</div>
			</div> --> <!--  	<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas> -->
			<div class="inventoryArea">
				<div class="row">
					<h4>Inventory</h4>
					<div class="table-responsive">
						<table class="table table-striped table-sm">
							<thead>
								<tr>
									<th>Vehicle ID</th>
									<th>Purchase Date</th>
									<th>Make</th>
									<th>Model</th>
									<th>Mileage</th>
									<th>Price</th>
									<th>Description</th>
									<th>Sold Status</th>
									<th>Buyer Name</th>
								</tr>
							</thead>
							<tbody>
								 	<c:if test="${inventory != null && searchByMakeDataList == null}">
									<c:forEach items="${inventory}" var="myCar">
										<tr>
											<td>${myCar.id}</td>
											<td>${myCar.purchaseDate}</td>
											<td>${myCar.make}</td>
											<td>${myCar.model}</td>
											<td>${myCar.mileage}</td>
											<td>${myCar.price}</td>
											<td>${myCar.description}</td>
											<td>${myCar.soldStatus}</td>
											<td>${myCar.buyer}</td>
										</tr>
									</c:forEach>
								</c:if>  
								<c:if test="${searchByMakeDataList != null}">
									<c:forEach items="${searchByMakeDataList}" var="myCar">
										<tr>
											<td>${myCar.id}</td>
											<td>${myCar.purchaseDate}</td>
											<td>${myCar.make}</td>
											<td>${myCar.model}</td>
											<td>${myCar.mileage}</td>
											<td>${myCar.price}</td>
											<td>${myCar.description}</td>
											<td>${myCar.soldStatus}</td>
											<td>${myCar.buyer}</td>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			</main>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')
	</script>
	<script src="/docs/4.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
	<script src="dashboard.js"></script>
</body>
</html>
