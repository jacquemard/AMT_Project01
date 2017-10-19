<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>4 Col Portfolio - Start Bootstrap Template</title>

	<!-- Bootstrap core CSS -->
	<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<!-- Custom styles for this template -->
	<link href="css/4-col-portfolio.css" rel="stylesheet">

    </head>

    <body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	    <div class="container">
		<a class="navbar-brand" href="#">Start Bootstrap</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
		    <ul class="navbar-nav ml-auto">
			<li class="nav-item active">
			    <a class="nav-link" href="#">Home
				<span class="sr-only">(current)</span>
			    </a>
			</li>
			<li class="nav-item">
			    <a class="nav-link" href="#">About</a>
			</li>
			<li class="nav-item">
			    <a class="nav-link" href="#">Services</a>
			</li>
			<li class="nav-item">
			    <a class="nav-link" href="#">Contact</a>
			</li>
		    </ul>
		</div>
	    </div>
	</nav>

	<!-- Page Content -->
	<div class="container">

	    <!-- Page Heading -->
	    <h1 class="my-4">Furnitures
		<small>List</small>
	    </h1>

	    <div class="row">
		<c:forEach items="${requestScope.furnitures}" var="furniture" >
		    <div class="col-lg-3 col-md-4 col-sm-6 portfolio-item">
			<div class="card h-100">
			    <a href="#"><img class="card-img-top" src="${furniture.imageUrl}" alt=""></a>
			    <div class="card-body">
				<h4 class="card-title">
				    <a href="#">${furniture.name}</a>
				</h4>
				<p class="card-text">Category : ${furniture.category}</p>
				<p class="card-text">Color : ${furniture.color}</p>
				<p class="card-text">Material : ${furniture.material}</p>
				<p class="card-text">Price : ${furniture.price}</p>
			    </div>
			</div>
		    </div>
		</c:forEach>
	    </div>
	    <!-- /.row -->

	    <!-- Pagination -->
	    <ul class="pagination justify-content-center">
		<c:if test="${requestScope.currentPage > requestScope.firstPage}" >
		    <li class="page-item">
			<a class="page-link" href="?page=${requestScope.currentPage - 1}" aria-label="Previous">
			    <span aria-hidden="true">&laquo;</span>
			    <span class="sr-only">Previous</span>
			</a>
		    </li>
		</c:if>
		<c:forEach var="p" begin="${requestScope.firstPage}" end="${requestScope.lastPage}" >
		    <li class="page-item">
			<a class="page-link" href="?page=${p}">${p}</a>
		    </li>
		</c:forEach>

		<c:if test="${requestScope.currentPage < requestScope.lastPage}" >
		    <li class="page-item">
			<a class="page-link" href="?page=${requestScope.currentPage + 1}" aria-label="Next">
			    <span aria-hidden="true">&raquo;</span>
			    <span class="sr-only">Next</span>
			</a>
		    </li>
		</c:if>
	    </ul>

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
	    <div class="container">
		<p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
	    </div>
	    <!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/popper/popper.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    </body>

</html>
