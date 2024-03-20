<%@ page import="servlets.Campaign" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Campaigns</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/camp.css" rel="stylesheet">
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
                <li class="nav-item">
                    <a class="nav-link" href="campaign.jsp">Campaigns</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>

            </ul>
        </div>
         <a href="login.jsp" class="navbar-icon">
            <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z"/>
            </svg>
        </a>
    </div>
</nav>




<section class="upcoming-campaigns">
    <div class="container mt-5">
        <h2 class="text-center mb-4">Upcoming Campaigns</h2>
      	<div style ="display: flex; justify-conent:space-between; flex-wrap: wrap;">
        
        <%
        	if(request.getAttribute("campaigns")==null){
        		response.sendRedirect("CampaignPage");
        	}else{
        		List<Campaign> campaigns = (List<Campaign>) request.getAttribute("campaigns");
        		for(Campaign campaign : campaigns){
        	
        
        %>
        <div class="row" style="margin-left: 50px; margin-bottom: 30px" >
            <!-- Campaign Card -->
            <div class="col-sm-3" >
                <div class="card campaign-card" style="width: 18rem">
                    <img class="card-img-top" src="images/<%= campaign.getImage() %>" alt="Campaign Image">
                    <div class="card-body">
                        <h5 class="card-title"><%= campaign.getName() %></h5>
                        <p class="card-text"><%= campaign.getDescription() %></p>
                        <ul class="list-unstyled">
                            <li><strong>Date :</strong> <%= campaign.getDate() %></li>
                            <li><strong>Time :</strong> <%= campaign.getTime() %></li>
                            <li><strong>Location :</strong> <%= campaign.getLocation() %></li>
                        </ul>
                    </div>
                </div>
            </div>
            
            
        </div>
        <%}} %>
        </div>
    </div>
</section>



<section class="recent-campaigns">
    <div class="container mt-5">
        <h2 class="text-center mb-4">Recent Campaigns</h2>
        <div class="row">
            <!-- Campaign Card -->
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
</section>


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

                    SL Blood Bank Narahenpita, Colombo, Sri Lanka.
                </p>
                <p>
                    <!-- Phone Icon -->
                    +94 112 123456
                </p>
            </div>
        </div>
    </div>
</footer>


<script src="resources/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>