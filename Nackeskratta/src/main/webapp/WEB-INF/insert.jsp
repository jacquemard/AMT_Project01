<%@include file="includes/header.jsp" %>

<!-- Page Content -->
<div class="container">

    <!-- Page Heading -->
    <h1 class="my-4">Create Furniture
        <small>Choose wisely!</small>
    </h1>

    <form method="POST">
        <div class="form-group">
	    <label for="name">Name</label>
	    <input type="text" placeholder="Nackeskratta" name="name" class="form-control" id="name">
        </div>

        <label class="form-contol-label" for="category">Category</label>
        <div class="form-group">
	    <div class="btn-group" data-toggle="buttons" id="category">
		<label class="btn btn-secondary active">
		    <input type="radio" name="category" id="cat_bed" autocomplete="off" value="3" checked> Bed
		</label>
		<label class="btn btn-secondary">
		    <input type="radio" name="category" id="cat_chair" autocomplete="off" value="2"> Chair
		</label>
		<label class="btn btn-secondary">
		    <input type="radio" name="category" id="cat_table" autocomplete="off" value="5"> Table
		</label>
		<label class="btn btn-secondary">
		    <input type="radio" name="category" id="cat_cabinet" autocomplete="off" value="4"> Cabinet
		</label>
		<label class="btn btn-secondary">
		    <input type="radio" name="category" id="cat_meatball" autocomplete="off" value="1"> Meatball
		</label>
	    </div>
        </div>

        <label for="material">Material</label>
        <div class="form-group">
	    <div class="btn-group" data-toggle="buttons" id="material">
		<label class="btn btn-secondary active">
		    <input type="radio" name="material" id="mat_wood" autocomplete="off" value="1" checked> Wood
		</label>
		<label class="btn btn-secondary">
		    <input type="radio" name="material" id="mat_metal" autocomplete="off" value="2"> Metal
		</label>
		<label class="btn btn-secondary">
		    <input type="radio" name="material" id="mat_plastic" autocomplete="off" value="3"> Plastic
		</label>
		<label class="btn btn-secondary">
		    <input type="radio" name="material" id="mat_horse" autocomplete="off" value="4"> Horse
		</label>
	    </div>
        </div>

        <label for="color">Color</label>
        <div class="form-group">          
	    <div class="btn-group" data-toggle="buttons" id="color">
		<label class="btn btn-secondary active">
		    <input type="radio" name="color" id="col_black" autocomplete="off" value="1" checked> Black
		</label>
		<label class="btn btn-secondary">
		    <input type="radio" name="color" id="col_brown" autocomplete="off" value="2"> Brown
		</label>
		<label class="btn btn-secondary">
		    <input type="radio" name="color" id="col_red" autocomplete="off" value="3"> Red
		</label>
	    </div>
        </div>

        <div class="form-group">
	    <label for="price">Price</label>
	    <input type="number" name="price" placeholder="0" class="form-control" id="price">
        </div>

        <button type="submit" class="btn btn-default">Submit</button>
    </form>
    <!-- /.row -->

</div>
<!-- /.container -->

<%@include file="includes/footer.jsp" %>