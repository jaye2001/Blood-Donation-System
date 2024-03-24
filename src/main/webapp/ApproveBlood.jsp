<%@ page import="classes.ApproveBlood" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Approve Blood</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="css/main.css" rel="stylesheet">
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
    <div class="title">Approve Blood Requests</div>
    <div class="history-table">
        <table class="table">
            <thead>
                <tr>
                    
                    <th>Blood type</th>
                    <th>Available amount</th>
                    <th>Requested amount</th>
                </tr>
            </thead>
            <tbody>
                <%
        	if(request.getAttribute("approvebl")==null){
        		response.sendRedirect("ApproveBloodServlet");
        	}else{
        		List<ApproveBlood> approvebl = (List<ApproveBlood>) request.getAttribute("approvebl");
        		for(ApproveBlood approveblood : approvebl){
        	
        
        %>
                <tr>
                    <td><%= approveblood.getBloodType() %></td>
                    <td><%= approveblood.getAvailable() %></td>
                    <td><%= approveblood.getRequested() %></td>
  	                
                    <td>
                    <form action="ApproveUpdate" method="post">
                    <input type="hidden" name="blood_type" value="<%= approveblood.getBloodType() %>">
                    <input type="hidden" name="requested_amount" value="<%= approveblood.getAvailable() %>">
    
				    <div class="button">
				        <input type="submit" value="Approve">
				    </div>
					</form>
        			</td>
        			<td>
                    <form action="CustomApprove" method="post">
                    <input type="hidden" name="blood_type" value="<%= approveblood.getBloodType() %>">
                    
                    <div class="input-box">
                		
                			<input type="text" name="custom"  placeholder="Enter amount" required>
           			 </div>
           			 </td>
           			 <td>
    
				    <div class="button">
				        <input type="submit" value="Custom">
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