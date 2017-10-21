<%@include file="includes/header.jsp" %>
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
			    <a href="edit?id=${furniture.id}">${furniture.name}</a>
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
<%@include file="includes/footer.jsp" %>