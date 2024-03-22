<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hospital Registation</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/campaignReg.css">
</head>
<body>



<!-- Navigation Bar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="#">Blood Bank Sri Lanka</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="Blood_Bank/home.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="campaign.jsp">Campaigns</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Donor</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<input type="hidden" id ="status" value="<%= request.getAttribute("status") %>">

<div class="containerX">
    <div class="title">Hospital Registation</div>    
    <form method ="post" action="AddHospital" >
        <div class="user-details">
            <div class="input-box">
                <span class="details">Hospital Name</span>
                <input type="text" name="name" placeholder="Enter Hospital Name" required>
            </div>
            
            <div class="input-box">
                <span class="details">Location</span>
                <input type="text" name="location"  placeholder="Enter Location" required>
            </div>
            
            <div class="input-box">
                <span class="details">Email</span>
                <input type="text" name="email"  placeholder="Enter Email" required>
            </div>
            
            <div class="input-box">
                <span class="details">Password</span>
                <input type="password" name="password"  placeholder="Enter Password" required>
            </div>
            
            
        </div>
        <div class="button">
            <input type="submit" value="Submit">
        </div>
    </form>
</div>

<!-- Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	
<!-- <script type="text/javascript">
	var status = document.getElementById("status").value;
	if(status == "success"){
		swal("Campaign registered successfully");
	}
	
</script> -->	

</body>
</html>