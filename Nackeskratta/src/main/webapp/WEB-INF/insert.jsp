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
              <input type="radio" name="category" id="cat_bed" autocomplete="off" value="1" checked> Bed
            </label>
            <label class="btn btn-secondary">
              <input type="radio" name="category" id="cat_chair" autocomplete="off" value="2"> Chair
            </label>
            <label class="btn btn-secondary">
              <input type="radio" name="category" id="cat_table" autocomplete="off" value="3"> Table
            </label>
            <label class="btn btn-secondary">
              <input type="radio" name="category" id="cat_cabinet" autocomplete="off" value="4"> Cabinet
            </label>
            <label class="btn btn-secondary">
              <input type="radio" name="category" id="cat_meatball" autocomplete="off" value="5"> Meatball
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
