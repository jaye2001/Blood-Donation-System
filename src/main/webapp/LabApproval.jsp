<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lab Approval</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Include FontAwesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <!-- Custom styles -->
    <style>
        .btn-approve { background-color: green; }
        .btn-approve:hover { background-color: darkgreen; }
        
        .btn-reject { background-color: red; }
        .btn-reject:hover { background-color: darkred; }
        
        /* Additional custom styles can be added here */
    </style>
</head>
<body>

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
                       
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Lab Approval Form -->
<div class="container mt-5">
    <h2 class="mb-4">Lab Approval</h2>
    
    <!-- Filter by Date -->
    <div class="row mb-3">
        <div class="col-md-4">
            <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text">Filter by Date</span>
                </div>
                <input type="date" class="form-control" id="filterDate" name="filterDate">
            </div>
        </div>
    </div>
    
    <!-- Blood Samples Table -->
    <table class="table table-hover">
        <thead class="thead-dark">
            <tr>
                <th scope="col">Sample ID</th>
                <th scope="col">Donor NIC</th>
                <th scope="col">Blood Type</th>
                <th scope="col">Date</th>
                <th scope="col">Status</th>
                <th scope="col">Action</th>
            </tr>
        </thead>
        <tbody>
            <!-- Dynamic rows will be added here based on the server-side data -->
        </tbody>
    </table>
</div>

<!-- Include jQuery and Bootstrap Bundle which includes Popper -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.7.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
