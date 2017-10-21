<%@include file="includes/header.jsp" %>

<!-- Page Content -->
<div class="container">

    <!-- Page Heading -->
    <h1 class="my-4">Data Generator</h1>

    <form method="POST">
        <div class="form-group">
	    <label for="nb_elements">Number of elements to generate</label>
	    <input type="number" value="0" class="form-control" name="nb_elements" id="nb_elements">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form> 
    <!-- /.row -->

</div>
<!-- /.container -->

<%@include file="includes/footer.jsp" %>