<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Include FontAwesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <!-- Link to the custom CSS for dashboard tiles -->
    <link rel="stylesheet" href="css/dash.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>

<!-- Navigation Bar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">

        <!-- Branding -->
        <a class="navbar-brand" href="#">Blood Bank Admin</a>
        
        <!-- Navbar Links -->
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="Dashbord.jsp">Dashboard</a>
                </li>

                <!-- Admin Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuAdmin" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Admin
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuAdmin">
                        <a class="dropdown-item" href="AddAdmin.jsp">Add Admin</a>
                        <a class="dropdown-item" href="#">Update Admin</a>
                        <!-- Additional sub-items here -->
                    </div>
                </li>
                <!-- Donor Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuDonor" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Donor
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuDonor">
                        <a class="dropdown-item" href="AddDonor.jsp">Add Donor </a>
                        <a class="dropdown-item" href="#">Update Donor</a>
                        <!-- Additional sub-items here -->
                    </div>
                </li>
                <!-- Hospital Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuHospital" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Hospital
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuHospital">
                        <a class="dropdown-item" href="#">Hospital Stock</a>
                        <a class="dropdown-item" href="#"></a>
                        <!-- Additional sub-items here -->
                    </div>
                </li>
                <!-- Blood Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuBlood" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Blood
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuBlood">
                        <a class="dropdown-item" href="#">Blood Stock</a>
                        <a class="dropdown-item" href="#"></a>
                        <!-- Additional sub-items here -->
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Main Content Area -->
<div class="container-fluid">
    <div class="row">
        <!-- Main content -->
        <main role="main" class="col-12">
            <div class="pt-2 pb-2 mb-3">
                <h1 class="h2">Admin Dashboard</h1>
                <hr>
            </div>
            <!-- Clickable Tiles -->
            <div class="row">
				 <div class="col-lg-3 col-md-6">
                	<a href="AddAdmin.jsp">
                    	<div class="dashboard-tile" >
                        	<h4>Add Admin</h4>
                   		 </div>
               		 </a>
                </div>
                <div class="col-lg-3 col-md-6">
                	<a href="#">
                    	<div class="dashboard-tile" >
                        	<h4>Update Admin</h4>
                   		 </div>
               		 </a>
                </div>
                <div class="col-lg-3 col-md-6">
                	<a href="AddDonor.jsp">
                    	<div class="dashboard-tile" >
                        	<h4>Register Donor</h4>
                   		 </div>
               		 </a>
                </div>
                <div class="col-lg-3 col-md-6">
                	<a href="#">
                    	<div class="dashboard-tile" >
                        	<h4>Update Donor</h4>
                   		 </div>
               		 </a>
                </div>
               <div class="col-lg-3 col-md-6">
                	<a href="#">
                    	<div class="dashboard-tile" >
                        	<h4>Blood Stock</h4>
                   		 </div>
               		 </a>
                </div>
                <div class="col-lg-3 col-md-6">
                	<a href="reqDonor.jsp">
                    	<div class="dashboard-tile" >
                        	<h4>Request From Donot</h4>
                   		 </div>
               		 </a>
                </div>
               <div class="col-lg-3 col-md-6">
                	<a href="#">
                    	<div class="dashboard-tile" >
                        	<h4>#</h4>
                   		 </div>
               		 </a>
                </div>
                               <div class="col-lg-3 col-md-6">
                	<a href="#">
                    	<div class="dashboard-tile" >
                        	<h4>#</h4>
                   		 </div>
               		 </a>
                </div>
            </div>
        </main>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.7.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>