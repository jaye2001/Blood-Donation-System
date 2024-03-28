<%@ page import="java.util.List" %>
<%@ page import="classes.LabView" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Lab Approval</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Include FontAwesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <!-- Custom styles -->
    <style>
        /* Additional custom styles can be added here */
    </style>
    <script>
    function setSampleStatus(id, status) {
    	console.log("ABCD");
    	const data = {
    			id, 
    			status
    	};
    	  
    	fetch('http://localhost:8080/BLOOD_DONATION_SYSTEM/LabBloodApproveServlet', {
    	    method: 'POST',
    	    headers: {
    	      'Content-Type': 'application/json',
    	    },
    	    body: JSON.stringify(data)
    	  })
    	  .then(response => {
    	    if (!response.ok) {
    	      throw new Error('Network response was not ok ' + response.statusText);
    	    }
    	    return response.json();
    	  })
    	  .then(data => {
    	    console.log('Success:', data);
    	    window.location.reload(); 
    	  })
    	  .catch((error) => {
    	    console.error('Error:', error); // Handle errors
    	  });
    	}
    </script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <!-- Navbar Content Here -->
</nav>

	<!-- Lab Approval Form -->
	<div class="container mt-5">
	    <h2 class="mb-4">Blood Sample Approval</h2>
	    
	    <!-- Filter by Date -->
	    <div class="row mb-3">
	        <div class="col-md-4">
	            <div class="input-group">
	                <div class="input-group-prepend">
	                    <span class="input-group-text" id="filterDatePrepend">Filter by Date</span>
	                </div>
	                <input type="date" class="form-control" name="filterDate" aria-describedby="filterDatePrepend">
	                <div class="input-group-append">
	                    <button class="btn btn-outline-secondary" type="submit">Filter</button>
	                </div>
	            </div>
	        </div>
	    </div>
    
    
		<!-- Filter by NIC Form -->
		<form action="LabViewServlet" method="get">
		    <div class="row mb-3">
		        <div class="col-md-4">
		            <div class="input-group">
		                <div class="input-group-prepend">
		                    <span class="input-group-text" id="filterNicPrepend">Search by NIC</span>
		                </div>
		                <input type="text" class="form-control" name="search_query" placeholder="Enter NIC" aria-describedby="filterNicPrepend">
		                <div class="input-group-append">
		                    <button class="btn btn-outline-secondary" type="submit">Search</button>
		                </div>
		            </div>
		        </div>
		    </div>
		</form>

    
    
    
    <!-- Blood Samples Table -->
    <div class="table-responsive">
        <table class="table table-bordered table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>Sample ID</th>
                    <th>NIC</th>
                    <th>Date</th>
                    <th>Blood Type</th>
                    <th>Status</th>
                    <th>Location</th>
                    <th>Actions</th>
                    <th>Remove Eligibility</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<LabView> labViewList = (List<LabView>) request.getAttribute("labViewList");
                    for (LabView labView : labViewList) {
                %>
                <tr>
                    <td><%= labView.getId() %></td>
                    <td><%= labView.getNic() %></td>
                    <td><%= labView.getDate() %></td>
                    <td><%= labView.getBloodType() %></td>
                    <td><%= labView.getStatus() %></td>
                    <td><%= labView.getLocation() %></td>
                    <td>
                    <% if(labView.getStatus().equals("Pending")) { %>
                        <a href="LabBloodApproveServlet?NIC=<%= labView.getNic() %>&status=Approved">
                        <button class="btn btn-sm btn-success btn-approve"><i class="fas fa-check"></i> Approve</button>
                        </a>
                        <a href="LabBloodApproveServlet?NIC=<%= labView.getNic() %>&status=Rejected">
                        <button class="btn btn-sm btn-danger btn-reject"><i class="fas fa-times"></i> Reject</button>
                        </a>
                    <% } else { %>
                    	<button class="btn btn-sm btn-success btn-approve" disabled><i class="fas fa-check"></i> Approve</button>
                        <button class="btn btn-sm btn-danger btn-reject" disabled><i class="fas fa-times"></i> Reject</button>
                    <% } %>
                    </td>
                    <td>
	                    <a href="DonorEligibilityServlet?NIC=<%= labView.getNic() %>">
		                    <button class="btn btn-sm btn-danger btn-reject"><i class="fas fa-times"></i> Remove eligibility</button>
        	            </a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody> 
        </table>
    </div>
</div>

<!-- Include jQuery and Bootstrap Bundle which includes Popper -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.7.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
