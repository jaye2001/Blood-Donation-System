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

<div class="containerX">
    <div class="title">Blood Campaign Details</div>    
    <form action="#">
        <div class="user-details">
            <div class="input-box">
                <span class="details">Campaign Name</span>
                <input type="text" placeholder="Enter Campaign Name" required>
            </div>
            <div class="input-box">
                <span class="details">Location</span>
                <input type="text" placeholder="Enter Location" required>
            </div>
            <div class="input-box">
                <span class="details">Area</span>
                <input type="text" placeholder="Enter Area" required>
            </div>
            <div class="input-box">
                <span class="details">Date</span>
                <input type="date" placeholder="" required>
            </div>
            <div class="input-box">
                <span class="details">Time</span>
                <input type="time" placeholder="" required>
            </div>
            <div class="input-box">
                <span class="details">Organizers</span>
                <input type="text" placeholder="Enter Organizers" required>
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

</body>
</html>
