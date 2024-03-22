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
                <input type="date" class="form-control" aria-describedby="filterDatePrepend">
            </div>
        </div>
    </div>
    
    <!-- Blood Samples Table -->
    <div class="table-responsive">
        <table class="table table-bordered table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>Sample ID</th>
                    <th>NIC</th>
                    <th>Date</th>
                    <th>Status</th>
                    <th>Location</th>
                    <th>Actions</th>
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
                    <td><%= labView.getStatus() %></td>
                    <td><%= labView.getLocation() %></td>
                    <td>
                        <button class="btn btn-sm btn-success btn-approve"><i class="fas fa-check"></i> Approve</button>
                        <button class="btn btn-sm btn-danger btn-reject"><i class="fas fa-times"></i> Reject</button>
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
