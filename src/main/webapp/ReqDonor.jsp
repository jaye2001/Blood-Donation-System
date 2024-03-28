<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Request From Donor</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet"  href="css/Donorrequest.css">
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
                        <a class="dropdown-item" href="#">Add Admin</a>
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
                        <a class="dropdown-item" href="#">Add Donor </a>
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
    <div class="card">
        <div class="card-body">
            <h2 class="card-title text-center">Request From Donor</h2>
            <form id="donorRequestForm" class="pt-3" onSubmit="submitFunction()">
                <h5>Select Blood Type(s):</h5>
                <div class="form-check">
                    <!-- Repeat this block for each blood type -->
                    <input class="form-check-input" type="checkbox" name="bloodType" value="A+" id="typeAPlus">
                    <label class="form-check-label" for="typeAPlus">A+</label>
                </div>
                <!-- Repeat for A-, B+, B-, AB+, AB-, O+, O- -->
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="bloodType" value="A-" id="typeANegative">
                    <label class="form-check-label" for="typeRare">A-</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="bloodType" value="B+" id="typeBPlus">
                    <label class="form-check-label" for="typeRhNull">B+</label>
                </div>
                
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="bloodType" value="B-" id="typeBNegative">
                    <label class="form-check-label" for="typeRhNull">B-</label>
                </div>
                
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="bloodType" value="AB+" id="typeABPlus">
                    <label class="form-check-label" for="typeRhNull">AB+</label>
                </div>
                
                 <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="bloodType" value="AB-" id="typeABNegative">
                    <label class="form-check-label" for="typeRhNull">AB-</label>
                </div>
                
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="bloodType" value="AB+" id="typeOPlus">
                    <label class="form-check-label" for="typeRhNull">O+</label>
                </div>
                
                 <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="bloodType" value="AB-" id="typeONegative">
                    <label class="form-check-label" for="typeRhNull">O-</label>
                </div>
                
                
                <div class="form-group pt-3">
                    <label for="messageBox">Message:</label>
                    <textarea class="form-control" id="messageBox" name="message" rows="4"></textarea>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Submit Request</button>
            </form>
        </div>
    </div>
</div>

<script>
function submitFunction() {
	alert('EMAIL SEND');
}

</script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.7.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="JS/reqDonor.js"></script>
</body>
</html>
