<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Admin</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet"  href="css/addadmin.css"> 
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

<!-- Add Admin Form -->
<div class="container">
    <h2>Add Admin</h2>
    <form id="addAdminForm" action="AddAdminServlet" method ="post" >
        <div class="form-group">
            <label for="adminFName">First Name</label>
            <input type="text" class="form-control" id="adminName" name="adminFName" required>
            </div>
            <div class="form-group">
            <label for="adminLName">Last Name</label>
            <input type="text" class="form-control" id="adminName" name="adminLName" required>
            </div>
         <div class="form-group">
            <label for="adminNIC">NIC</label>
            <input type="text" class="form-control" id="adminNIC" name="adminNIC" required>
        </div>   
        <div class="form-group">
            <label for="adminEmail">Email</label>
            <input type="email" class="form-control" id="adminEmail" name="adminEmail" required>
        </div>
        <div class="form-group">
            <label for="adminMobile">Mobile No</label>
            <input type="tel" class="form-control" id="adminMobile" name="adminMobile" required>
        </div>
        <div class="form-group">
            <label for="adminUsername">Username</label>
            <input type="text" class="form-control" id="adminUsername" name="adminUsername" required>
        </div>
        <div class="form-group">
            <label for="adminPassword">Password</label>
            <input type="password" class="form-control" id="adminPassword" name="adminPassword" required>
            <small id="passwordHelpBlock" class="form-text text-muted">
                <input type="checkbox" onclick="togglePasswordVisibility()"> Show Password
            </small>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<script src="JS/addAdmin.js"></script> 
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.7.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>