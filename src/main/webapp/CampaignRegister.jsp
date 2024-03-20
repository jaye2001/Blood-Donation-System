<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Blood Campaign Registration</title>
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
    <div class="title">Blood Campaign Details</div>    
    <form method ="post" action="campRegister" enctype="multipart/form-data">
        <div class="user-details">
            <div class="input-box">
                <span class="details">Campaign Name</span>
                <input type="text" name="name" placeholder="Enter Campaign Name" required>
            </div>
            <div class="input-box">
                <span class="details">Select Image</span>
                <input type="file" name="image" required>
            </div>
            <div class="input-box">
                <span class="details">Location</span>
                <input type="text" name="location"  placeholder="Enter Location" required>
            </div>
            
            <div class="input-box">
                <span class="details">Date</span>
                <input type="date" name="date"  placeholder="" required>
            </div>
            <div class="input-box">
                <span class="details">Starting time</span>
                <input type="time" name="STime"  placeholder="" required>
            </div>
            <div class="input-box">
                <span class="details">Ending time</span>
                <input type="time" name="FTime"  placeholder="" required>
            </div>
            <div class="input-box">
                <span class="details">Organizers</span>
                <input type="text" name="organizer"  placeholder="Enter Organizers" required>
            </div>
            <div class="input-box">
                <span class="details">Most needed Blood group</span>
                <input type="text" name="bloodGroup"  placeholder="Enter Blood group" required>
            </div>
            <div class="input-box">
                <span class="details">Add Description</span>
                <input type="text" name="description"  placeholder="Description" required>
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