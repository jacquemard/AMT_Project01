<%@include file="includes/header.jsp" %>

<!-- Page Content -->
<div class="container">

    <!-- Page Heading -->
    <h1 class="my-4">Edit Furniture
        <small>Choose wisely!</small>
    </h1>

    <form method="POST">
        <div class="form-group">
	    <label for="name">Name</label>
	    <input type="text" placeholder="Nackeskratta" name="name" class="form-control" id="name"
		   value="${requestScope.furniture.name}">
        </div>

        <label class="form-contol-label" for="category">Category</label>
        <div class="form-group">
	    <div class="btn-group" data-toggle="buttons" id="category">
		<label class="btn btn-secondary ${requestScope.furniture.category == 'BED' ? 'active' : ''} ">
		    <input type="radio" name="category" id="cat_bed" autocomplete="off" value="1" 
			   ${requestScope.furniture.category == 'BED' ? 'checked' : ''} > Bed
		</label>
		<label class="btn btn-secondary ${requestScope.furniture.category == 'CHAIR' ? 'active' : ''}">
		    <input type="radio" name="category" id="cat_chair" autocomplete="off" value="2"
			   ${requestScope.furniture.category == 'CHAIR' ? 'checked' : ''} > Chair 
		</label>
		<label class="btn btn-secondary ${requestScope.furniture.category == 'TABLE' ? 'active' : ''}">
		    <input type="radio" name="category" id="cat_table" autocomplete="off" value="3"
			   ${requestScope.furniture.category == 'TABLE' ? 'checked' : ''}> Table
		</label>
		<label class="btn btn-secondary ${requestScope.furniture.category == 'CABINET' ? 'active' : ''}">
		    <input type="radio" name="category" id="cat_cabinet" autocomplete="off" value="4"
			   ${requestScope.furniture.category == 'CABINET' ? 'checked' : ''} > Cabinet
		</label>
		<label class="btn btn-secondary ${requestScope.furniture.category == 'MEATBALLS' ? 'active' : ''}">
		    <input type="radio" name="category" id="cat_meatball" autocomplete="off" value="5"
			   ${requestScope.furniture.category == 'MEATBALLS' ? 'checked' : ''} > Meatball
		</label>
	    </div>
        </div>

        <label for="material">Material</label>
        <div class="form-group">
	    <div class="btn-group" data-toggle="buttons" id="material">
		<label class="btn btn-secondary ${requestScope.furniture.material == 'WOOD' ? 'active' : ''}">
		    <input type="radio" name="material" id="mat_wood" autocomplete="off" value="1" 
			   ${requestScope.furniture.material == 'WOOD' ? 'checked' : ''} > Wood
		</label>
		<label class="btn btn-secondary ${requestScope.furniture.material == 'METAL' ? 'active' : ''}">
		    <input type="radio" name="material" id="mat_metal" autocomplete="off" value="2"
			   ${requestScope.furniture.material == 'METAL' ? 'checked' : ''} > Metal
		</label>
		<label class="btn btn-secondary ${requestScope.furniture.material == 'PLASTIC' ? 'active' : ''}">
		    <input type="radio" name="material" id="mat_plastic" autocomplete="off" value="3"
			   ${requestScope.furniture.material == 'PLASTIC' ? 'checked' : ''} >  Plastic
		</label>
		<label class="btn btn-secondary ${requestScope.furniture.material == 'HORSE' ? 'active' : ''}">
		    <input type="radio" name="material" id="mat_horse" autocomplete="off" value="4"
			   ${requestScope.furniture.material == 'HORSE' ? 'checked' : ''} > Horse
		</label>
	    </div>
        </div>

        <label for="color">Color</label>
        <div class="form-group">          
	    <div class="btn-group" data-toggle="buttons" id="color">
		<label class="btn btn-secondary ${requestScope.furniture.color == 'BLACK' ? 'active' : ''}">
		    <input type="radio" name="color" id="col_black" autocomplete="off" value="1" 
			   ${requestScope.furniture.color == 'BLACK' ? 'checked' : ''} > Black
		</label>
		<label class="btn btn-secondary ${requestScope.furniture.color == 'BROWN' ? 'active' : ''}">
		    <input type="radio" name="color" id="col_brown" autocomplete="off" value="2"
			   ${requestScope.furniture.color == 'BROWN' ? 'checked' : ''} > Brown
		</label>
		<label class="btn btn-secondary ${requestScope.furniture.color == 'RED' ? 'active' : ''}">
		    <input type="radio" name="color" id="col_red" autocomplete="off" value="3"
			   ${requestScope.furniture.color == 'RED' ? 'checked' : ''}> Red
		</label>
	    </div>
        </div>

        <div class="form-group">
	    <label for="price">Price</label>
	    <input type="number" name="price" placeholder="0" class="form-control" id="price"
		   value="${requestScope.furniture.price}">
        </div>

        <div class="form-group">
	    <button type="submit" class="btn btn-default">Update</button>
	    <a href="delete?id=${requestScope.furniture.id}"><button type="button" class="btn btn-danger">Delete</button></a>
        </div>

    </form>
    <!-- /.row -->

</div>
<!-- /.container -->

<%@include file="includes/footer.jsp" %>