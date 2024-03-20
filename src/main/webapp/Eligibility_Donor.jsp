<%@ page import="java.util.*,java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        
        <!-- Search Form -->
        <form action="SearchPersonServlet" method="post" class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" name="searchNIC" placeholder="Enter NIC" aria-label="Search NIC">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>

        <!-- Navbar Links -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav ml-auto">
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

<div class="container mt-5">
         <h5 class="card-header">Update Person Details</h5>
        <div class="card-body">
            <!-- Form Start -->
            <form action="UpdatePersonServlet" method="post">
                
                <!-- NIC -->
                <div class="form-group">
                    <label for="nicInput">NIC</label>
                    <input type="text" class="form-control" id="nicInput" name="nic" placeholder="Enter NIC">
                </div>
                
                <!-- Name -->
                <div class="form-group">
                    <label for="nameInput">Name</label>
                    <input type="text" class="form-control" id="nameInput" name="name" placeholder="Enter Full Name">
                </div>
                
                <!-- Email -->
                <div class="form-group">
                    <label for="emailInput">Email</label>
                    <input type="email" class="form-control" id="emailInput" name="email" placeholder="Enter Email">
                </div>
                
                <!-- Eligibility Selection -->
                <div class="form-group">
                    <label for="eligibilitySelect">Eligibility</label>
                    <select class="form-control" id="eligibilitySelect" name="eligibility">
                        <option>Eligible</option>
                        <option>Not Eligible</option>
                    </select>
                </div>
                
                <!-- Description Box for Health Issues -->
                <div class="form-group">
                    <label for="descriptionTextarea">Health Issues or Other Criteria</label>
                    <textarea class="form-control" id="descriptionTextarea" name="description" rows="3"></textarea>
                </div>
                
                <!-- Update Button -->
                <button type="submit" class="btn btn-primary">Update</button>
            </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.7.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
