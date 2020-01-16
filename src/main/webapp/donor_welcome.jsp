<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible">
<title>Donor Welcome</title>
</head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" href="./css/main.css">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/34ba01c15e.js"
	crossorigin="anonymous"></script>
<body>
	<nav class="navbar navbar-expand-lg navbar-light"
		style="background: white;">
		<a class="navbar-brand" href="#"> <img
			src="./images/save-a-life-give-blood-logo (2).jpg" width="60" alt="">
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active px-2">
					<button type="button" class="btn btn-outline-danger">Home</button>
				</li>
				<li class="nav-item active px-2">
					<button type="button" class="btn btn-outline-danger">Blog</button>
				</li>
				<li class="nav-item active px-2">
					<button type="button" class="btn btn-outline-danger">Testimonials</button>
				</li>
				<li class="nav-item px-2">
					<button type="button" class="btn btn-outline-danger">Blood
						Bank</button>
				</li>
				<li class="nav-item px-2">
					<a href="admin_login.jsp"><button type="button" class="btn btn-outline-danger">Admin</button></a>
				</li>
				<li class="nav-item dropdown px-2">
					<div class="dropdown">
						<button class="btn btn-outline-danger dropdown-toggle"
							type="button" id="dropdownMenuButton" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">Donor</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item" href="donor_login.jsp">Login</a> <a
								class="dropdown-item" href="donor_reg.jsp">Register</a>
						</div>
					</div>
				</li>
			</ul>
			<button type="button" class="btn btn-danger">Need Blood
				Immediately!</button>
		</div>
	</nav>



	<!-- CAROUSEL -->


	<div id="carouselExampleFade" class="carousel slide carousel-fade"
		data-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="./images/Webp.net-resizeimage (1).jpg" class="w-100">
			</div>
			<div class="carousel-item">
				<img src="./images/Webp.net-resizeimage (2).jpg" class="w-100">
			</div>
			<div class="carousel-item">
				<img src="./images/Webp.net-resizeimage.jpg" class="w-100">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleFade"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleFade"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>


	<div class="container">
		<h2>Hi ${message} !! Glad to have you onboard :)</h2>
	</div>

	<!-- FOOTER -->


	<footer class="footer-distributed">
		<div class="footer-left">
			<!-- <img src="/assets/images/save-a-life-give-blood-logo (2).jpg"> -->
			<h3>
				About <span>Us:</span>
			</h3>

			<p class="footer-links">
				<a href="#">Home</a> | <a href="#">Blog</a> | <a href="#">About</a>
				| <a href="#">Contact</a>
			</p>

			<p class="footer-company-name">© 2019 Blood Bank Management
				System Pvt. Ltd.</p>
		</div>

		<div class="footer-center">
			<div>
				<i class="fa fa-map-marker"></i>
				<p>
					<span>Delhi/NCR</span>
				</p>
			</div>

			<div>
				<i class="fa fa-phone"></i>
				<p>+91 98-108-36-964</p>
			</div>
			<div>
				<i class="fa fa-envelope"></i>
				<p>
					<a href="mailto:support@eduonix.com">support@donateblood.com</a>
				</p>
			</div>
		</div>
		<div class="footer-right">
			<p class="footer-company-about">
				<span>About the company</span> Lorem ipsum dolor sit amet
				consectetur adipisicing elit. Temporibus, quia fugit recusandae
				cumque dolores laboriosam inventore, delectus ex corporis quos rerum
				necessitatibus earum labore blanditiis accusantium? Non
				reprehenderit quas impedit necessitatibus a! Omnis, debitis cum.
			</p>
			<div class="footer-icons">
				<a href="#"><i class="fab fa-facebook-square"></i></a> <a href="#"><i
					class="fab fa-twitter-square"></i></a> <a href="#"><i
					class="fab fa-instagram"></i></a> <a href="#"><i
					class="fab fa-linkedin"></i></a> <a href="#"><i
					class="fab fa-youtube-square"></i></a>
			</div>
		</div>
	</footer>


</body>
</html>