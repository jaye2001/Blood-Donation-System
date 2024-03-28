<%@ page import="classes.RequestedBlood" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>History</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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

<div class="container">
    <div class="title">Blood Requests from Hospital</div>
    <div class="history-table">
        <table class="table">
            <thead>
                <tr>
                    <th>Hospital ID</th>
                    <th>Hospital Name</th>
                    <th>Blood type</th>
                    <th>Requested amount</th>
                </tr>
            </thead>
            <tbody>
                <%
        	if(request.getAttribute("reqblood")==null){
        		response.sendRedirect("RequestedBloodServlet");
        	}else{
        		List<RequestedBlood> reqblood = (List<RequestedBlood>) request.getAttribute("reqblood");
        		for(RequestedBlood rblood : reqblood){
        	
        
        %>
                <tr>
                    <td><%= rblood.getHospitalId() %></td>
                    <td><%= rblood.getHospitalName() %></td>
                    <td><%= rblood.getBloodType() %></td>
                    <td><%= rblood.getAmount() %></td>
                    <td>
                    <form action="ApproveBloodServlet" method="post">
                    	<input type="hidden" name="blood_type" value="<%= rblood.getBloodType() %>">
                    	<input type="hidden" name="requested_amount" value="<%= rblood.getAmount() %>">
					    <div class="button">
					        <input type="submit" value="View more">
					    </div>
					</form>
        			</td>
                </tr>
                <%}} %>
                <!-- Add more rows as needed -->
            </tbody>
        </table>
    </div>
</div>

</body>
</html>