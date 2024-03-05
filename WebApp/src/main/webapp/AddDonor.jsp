<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Donor</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">

    <link href="css/Donor.css" rel="stylesheet">
     <link href="css/main.css" rel="stylesheet">
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

  	<div class="containerX">
        <div class ="title">Donor Details</div>	
        	<form action="#">
        	<div class="user-details">
        	<div class="input-box">
        		<span class="details">Full Name</span>
        		<input type="text" placeholder="Enter Your Full Name" required>
        	</div>
        	
        	<div class="input-box">
              <span class="details">NIC</span>
              <input type="text" placeholder="Enter Your NIC" required>
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
       		 <span class="details">Mobile Phone</span>
        	 <input type="text" placeholder="Enter Your Mobile Phone Number" required>
    	   </div>
        	
        	
        	<div class="input-box">
        		<span class="details">Address</span>
        		<input type="text" placeholder="Enter Your Address" required>
        	</div>
        	

        	
		<div class="input-box">
		        <span class="details">Blood Type</span>
		        <select name="bloodType" required>
		            <option value="">Select Donor's Blood Type</option>
		            <option value="A+">A+</option>
		            <option value="A-">A-</option>
		            <option value="B+">B+</option>
		            <option value="B-">B-</option>
		            <option value="O+">O+</option>
		            <option value="O-">O-</option>
		            <option value="AB+">AB+</option>
		            <option value="AB-">AB-</option>
		            <option value="unknown">Don't Know</option>
		        </select>
		    </div>
        
			<div class="gender-details">
			    <input type="radio" id="male" name="gender" value="Male" required>
			    <label for="male" class="gender">Male</label>
			    
			    <input type="radio" id="female" name="gender" value="Female" required>
			    <label for="female" class="gender">Female</label>
			    

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
        	
     <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
 	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.7.0/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        </div>
  </body>
  </html>
  