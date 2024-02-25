<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Donor</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/Donor.css" rel="stylesheet">
    <link href="css/hospital req.css" rel="stylesheet">
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
        <div class ="title">Hospital Request Form</div>	
        	<form action="#">
        	<div class="user-details">
        	<div class="input-box">
        		<span class="details">Hospital Name</span>
        		<input type="text" placeholder="Enter Hospital Name" required>
        	</div>
        	
        	<div class="input-box">
        		<span class="details">Hospital ID</span>
        		<input type="text" placeholder="Enter Hospital ID" required>
        	</div>
        	
        	<div class="input-box">
        		<span class="details">City</span>
        		<input type="text" placeholder="City" required>
        	</div>
        	
        	<div class="input-box">
        		<span class="details">Postal Code</span>
        		<input type="text" placeholder="Postal Code" required>
        	</div>
        	
        	<div class="input-box">
        		<span class="details">Hospital Email Address</span>
        		<input type="text" placeholder="Enter Hospital Email" required>
        	</div>
        	
        	<div class="input-box">
        		<span class="details">Hospital Phone Number</span>
        		<input type="text" placeholder="Enter Hospital Phone Number" required>
        	</div>
        	
        	<div class="input-box">
        		<span class="details">Blood Type</span>
        		<input type="text" placeholder="Enter Blood Type" required>
        	</div>
        	
        	<div class="input-box">
        		<span class="details">Blood Point</span>
        		<input type="text" placeholder="Enter Number of Blood Point" required>
        	</div>
        	
        	
        	
        	
        	</div>
        	
        	<div class="button">
        	<input type="submit" value="Submit">
        	</div>
        	</form>
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	<script>
        		const First Name = document.getElementById('First Name');
        		const Last Name = document.getElementById('Last Name');
        		const Address = document.getElementById('Address');
        		const Mobile = document.getElementById('Mobile');
        		let blood = ["A+" ,"A-", "B+", "B-", "O+", "O-", "AB+", "AB-"];
        		let slct1= document.getElementById("slct1");
        		const form = document.getElementById('form');
        		
        		const First Name_error = document.getElementById('First Name_error');
        		const Last Name_error = document.getElementById('Last Name_error');
        		
        		form.addEventListnener('submit',(e)=>
        		{
        			if(First Name.value ==='' ||First Name.value == null)
        				{
        					e.preventDefault();
        					First Name_error.inerHTML = "Name is requied";
        				}
        		})
        	</script>
        </div>
  </body>
  </html>
  