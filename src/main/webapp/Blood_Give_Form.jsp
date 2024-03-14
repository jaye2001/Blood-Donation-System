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
        <div class ="title">Donor Details</div>	
        	<form action="#">
        	<div class="user-details">
        	<div class="input-box">
        		<span class="details">Full Name</span>
        		<input type="text" placeholder="Enter Your Full Name" required>
        	</div>
        	
        	<div class="input-box">
        		<span class="details">Date of Birth Day</span>
        		<input type="date" placeholder="" required>
        	</div>
        	
        	<div class="input-box">
        		<span class="details">Email Address</span>
        		<input type="text" placeholder="Enter Your Email" required>
        	</div>
        	
        	<div class="input-box">
        		<span class="details">Address</span>
        		<input type="text" placeholder="Enter Your Address" required>
        	</div>
        	
        	<div class="input-box">
        		<span class="details">Phone Number</span>
        		<input type="text" placeholder="Enter Your Phone NO" required>
        	</div>
        	
        	<div class="input-box">
        		<span class="details">Blood Type</span>
        		<input type="text" placeholder="Enter Your Blood Type" required>
        	</div>
        	</div>
        	<div class="gender-details">
        		<span class="gender-title">Gender</span>
        		<div class="category">
        			<lable for="">
        			<span class="dot one"></span>
        			<span class="gender">Male</span>
        			</lable>
        			
        			<lable for="">
        			<span class="dot one"></span>
        			<span class="gender">Female</span>
        			</lable>
        			
        			<lable for="">
        			<span class="dot one"></span>
        			<span class="gender">Prefer not to say</span>
        			</lable>
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