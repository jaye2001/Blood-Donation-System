<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="classes.Checklogin" %>
  <%@page import="classes.Userdetails" %>
<!DOCTYPE html>
<html>
<head>
    <title>Blood Bank Sri Lanka</title>
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link href="css/home.css" rel="stylesheet">
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
                    <a class="nav-link" href="home.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
                
	  		
                 <%
                  
                  if (Userdetails.getType() == "admin" && Userdetails.getType() != null)
                  {
                  
                  %>
                  <li class="nav-item">
                 		<a class="nav-link" href="Dashboard.jsp">Dashboard</a>
                 </li>
                 
                 <% } %> 
                
                  
                 		 
                 
                 
        
        
        
        
                    
                
                <li class="nav-item">
                    <a class="nav-link" href="Campaign.jsp">Campaigns</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
                <%//Checklogin checklogin = (Checklogin) request.getAttribute("Checklogin") ;
        	if(Checklogin.getStatus() == true){	
        
        %>
                <li class="nav-item">
                    <a class="nav-link" href="LogoutServlet">Logout</a>
                </li>
		<%} %>
            </ul>
        </div>
        
        <%//Checklogin checklogin = (Checklogin) request.getAttribute("Checklogin") ;
        	if(Checklogin.getStatus() == true){	
        
        %>
        
        <a href="UserprofileServlet" class="navbar-icon">
            <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z"/>
            </svg>
        </a>
        
        <%}
        else{	
        %>
        <a href="Login.jsp" class="navbar-icon">
            <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z"/>
            </svg>
        </a>
        
        <%} %>
        
    </div>
</nav>

<!-- Hero Section -->
<div class="hero-section" style="background-image: url('images/pexels-photo-6823567.jpg');">
    <div class="overlay">
        <div class="hero-content">
            <h1>Donate Blood Today</h1>
            <p>Join the life-saving mission by contributing to our Blood Bank in Colombo.</p>
            <a href="#" class="btn btn-hero">Give Now</a>
        </div>
    </div>
</div>

<div class="recent-work">
	<h2 class="text-center mb-4">Recent Blood Donation Projects</h2>
	<div class="container mt-5">
	    <div class="row">
	        <div class="col-md-4">
	            <div class="card">
	                <img class="card-img-top" src="images/crd1.webp" alt="Blood Drive Campaign">
	                <div class="card-body">
	                    <h5 class="card-title">Kandy Blood Donation Campaign</h5>
	                    <p class="card-text">Thank you, Kandy residents, for your generous blood donations. Your contributions have been invaluable in replenishing our Blood Bank. Your selfless act has saved countless lives. We are deeply grateful for your support</p>
	                </div>
	            </div>
	        </div>
	        <div class="col-md-4">
	            <div class="card">
	                <img class="card-img-top" src="images/crd2.webp" alt="Social Media Content">
	                <div class="card-body">
	                    <h5 class="card-title">Galle Blood Donation Campaignt</h5>
	                    <p class="card-text">Thank you, Galle residents, for your generous blood donations. Your contributions have been invaluable in replenishing our Blood Bank. Your selfless act has saved countless lives. We are deeply grateful for your support</p>
	                </div>
	            </div>
	        </div>
	        <div class="col-md-4">
	            <div class="card">
	                <img class="card-img-top" src="images/crd3.webp" alt="User Engagement">
	                <div class="card-body">
	                    <h5 class="card-title">Jaffna Blood Donation Campaign</h5>
	                    <p class="card-text">Thank you, Jaffna residents, for your generous blood donations. Your contributions have been invaluable in replenishing our Blood Bank. Your selfless act has saved countless lives. We are deeply grateful for your support</p>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
</div>

<!-- Services Section -->
<div class="services">
	<div class="container mt-5">
		<div class="serviceshome">
	    <h2 class="text-center mb-4">Services</h2>
	    </div>
	    <div class="row">
	        <div class="col-md-4 mb-4">
	            <div class="card h-100">
	                <img class="card-img-top" src="images/crd4.webp" alt="Blood Donation Drives">
	                <div class="card-body">
	                    <h5 class="card-title">Blood Donation Drives</h5>
	                    <p class="card-text">Participate in our organized blood donation drives and help save lives by donating blood. Your contribution can make a meaningful difference.</p>
	                </div>
	            </div>
	        </div>
	        <div class="col-md-4 mb-4">
	            <div class="card h-100">
	                <img class="card-img-top" src="images/crd5.webp" alt="Blood Testing Facilities">
	                <div class="card-body">
	                    <h5 class="card-title">Blood Testing Facilities</h5>
	                    <p class="card-text">We offer comprehensive blood testing facilities for individuals and organizations. Our advanced equipment ensures accurate and timely results.</p>
	                </div>
	            </div>
	        </div>
	        <div class="col-md-4 mb-4">
	            <div class="card h-100">
	                <img class="card-img-top" src="images/crd6.webp" alt="Emergency Blood Supply">
	                <div class="card-body">
	                    <h5 class="card-title">Emergency Blood Supply</h5>
	                    <p class="card-text">In times of urgent need, we provide emergency blood supply services to hospitals and medical institutions, ensuring patients receive critical care.</p>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
</div>


<!-- Footer -->

<footer class="bg-dark text-white pt-4 pb-4">
    <div class="container">
        <div class="row">
            <div class="col-md-8 text-center text-md-left mb-3 mb-md-0">
                <h5>We provided an Incredible Service as Blood Bank Sri Lanka.</h5>
                <p>The staff was efficient, caring, and made the donation process so easy.</p>
                <!-- Address and Phone -->
                <p>
                    <!-- Address Icon -->
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-geo-alt" viewBox="0 0 16 16">
                        <path d="M12.5 3.5a5.5 5.5 0 1 0-11 0 5.5 5.5 0 0 0 11 0z"/>
                        <path d="M7.5 6.5a2 2 0 1 1-4 0 2 2 0 0 1 4 0z"/>
                    </svg>
                    123 Blood Bank Street, City, Country
                </p>
                <p>
                    <!-- Phone Icon -->
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-telephone" viewBox="0 0 16 16">
                        <path d="M3.654 1.328a.678.678 0 0 1 .26-.53.778.778 0 0 1 .603-.117c1.254.33 3.12.987 5.25 2.256 2.19 1.31 3.778 2.987 4.65 4.237.304.435.34.92.103 1.364a.678.678 0 0 1-.274.3l-2.383 1.59a1.745 1.745 0 0 1-2.1-.334 11.05 11.05 0 0 1-1.65-2.1 1.745 1.745 0 0 1 .062-1.65l1.59-2.383a.678.678 0 0 1 .441-.26c.174-.03.473-.07.927-.117.456-.046.988-.09 1.593-.117.605-.028 1.24.003 1.796.087.5.077.92.26 1.23.541.311.28.485.631.485 1.04 0 .325-.065.744-.195 1.256a16.35 16.35 0 0 1-.927 2.59c-.371.748-.87 1.522-1.485 2.313-.62.79-1.318 1.58-2.082 2.356-1.967 2-3.95 3.1-5.917 3.28a.678.678 0 0 1-.605-.117.778.778 0 0 1-.26-.53c-.033-.488.987-1.42 3.05-2.782 2.065-1.361 3.99-3.123 5.75-5.261.304-.371.552-.928.741-1.664.19-.736.31-1.61.358-2.615.048-1.004.003-2.065-.133-3.181a2.06 2.06 0 0 0-.358-.927 2.442 2.442 0 0 0-.485-.736 2.48 2.48 0 0 0-.927-.541 17.25 17.25 0 0 0-1.796-.087c-.605-.028-1.137.003-1.593.117-.454.046-.753.087-.927.117a.678.678 0 0 1-.441.26l-1.59 2.383a1.745 1.745 0 0 1-.062 1.65 11.05 11.05 0 0 1 1.65 2.1c.62.79 1.45 1.35 2.1 1.65l2.383-1.59a.678.678 0 0 1 .274-.3 16.358 16.358 0 0 1 2.591-.927c.512-.13.931-.195 1.256-.195.409 0 .76.174 1.04.485.32.31.464.73.541 1.23.084.556.115 1.191.087 1.796-.028.605-.071 1.137-.117 1.593-.046.454-.086.753-.117.927a.678.678 0 0 1-.26.441l-2.383 1.59a.678.678 0 0 1-.3.274 16.346 16.346 0 0 1-1.364.103c-.748-.05-1.45-.26-2.1-.741-1.138-.79-2.9-2.365-5.261-5.75-1.361-2.065-2.421-3.99-2.782-5.75a.678.678 0 0 1 .117-.605z"/>
                    </svg>
                    +94 12 345 6789
                </p>
            </div>
        </div>
    </div>
</footer>




<!-- Include other sections here based on the images provided -->

<script src="resources/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>