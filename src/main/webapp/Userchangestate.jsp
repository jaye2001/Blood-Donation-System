<%@page import="classes.CityLoader"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="classes.Loader" %>
<%@page import="classes.ProvinceLoader" %>
<%@page import="classes.DistricLoader" %>
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
                    <a class="nav-link" href="Dashboard.jsp">Dashboard</a>
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
        	<form action="UserChangeStateServlet" method = "post" id="province" >
        	<div class="user-details">
        	
        	<div class="input-box">
        		<span class="details">Province</span>
        		<input type="hidden" name="hiddenP" value="province">
        		<select id="country-Province" name="country-Province" required onchange="submitprovince()">
        		<option value="">Select Province</option>
   					<%ProvinceLoader myobj = new ProvinceLoader();
    					List<Loader> loade = myobj.getLoade();
    				
    					for (Loader loader : loade){
    						%>
    						
    						<option value="<%= loader.getNumber() %>"><%=loader.getNameString() %></option>
    						
    						<%
    					}
    					
    				%>
				</select>
        	</div>
        	 </div>
        	</form> 
        	
        	<form action="UserChangeStateServlet" method = "post" id="state" onchange="submitState()" >
        	<div class="user-details"> 
        	<div class="input-box">
        		<span class="details">State</span>
        		<input type="hidden" name="hiddens" value="State">
        		
        		<select id="country-state" name="country-state" required disabled>
   					<option value="">Select state</option>
    				
    				<%
    				
    				if (request.getAttribute("district") != null) {
    				
    				String value2 = request.getAttribute("district").toString();
    				if("true".equals(value2)){
    					
    		        		
    				DistricLoader myobj2 = new DistricLoader();
    					List<Loader> loade1 = myobj2.getLoade();
    				
    					for (Loader loader1 : loade1){
    						%>
    						
    						<option value="<%= loader1.getNumber() %>"><%=loader1.getNameString() %></option>
    						
    						<%
    					}
    					
    					String value3 = request.getAttribute("district").toString();
	        			if("true".equals(value3)){
	        				String value4 = request.getAttribute("province").toString();
	        			int value4int = Integer.parseInt(value4);
				%> 
							<input type="hidden" name="hiddenP1" value="<%= value4int %>">
				<% 	}
    				} }
    					
    				%>
    					
    					
				</select>
        	</div>
        	</div>
        	</form>
        	<form action="UserChangeStateServlet" method = "post" >
        	<div class="user-details"> 
        	<div class="input-box">
        		<span class="details">City</span>
        		<input type="hidden" name="hiddenc" value="City">
        		<select id="country-city" name="country-city" required disabled>
   					<option value="">Select city</option>
    				
    				<%
    				
    				if (request.getAttribute("city") != null) {
    				
    				String value2 = request.getAttribute("city").toString();
    				if("true".equals(value2)){
    					
    		        		
    				CityLoader myobj3 = new CityLoader();
    					List<Loader> loade2 = myobj3.getLoade();
    				
    					for (Loader loader2 : loade2){
    						%>
    						
    						<option value="<%= loader2.getNumber() %>"><%=loader2.getNameString() %></option>
    						
    						<%
    					}
    					String value6 = request.getAttribute("city").toString();
	        			if("true".equals(value6)){
	        				String value7 = request.getAttribute("state").toString();
	        			int value7int = Integer.parseInt(value7);
	        			String value8 = request.getAttribute("province").toString();
	        			int value8int = Integer.parseInt(value8);
				%> 
				<input type="hidden" name="hiddenP" value="<%= value7int %>">
				<input type="hidden" name="hiddenD" value="<%= value8int %>">
				<% 	}	
    				} }
    					
    				%>
    					
    					
				</select>
        	</div>
        	</div>

        	
		
			
        	<div class="button">
        	<input type="submit" value="Submit">
        	</div>
        	</form>
        	

        	<script>
        		function submitprovince() {
					document.getElementById("province").submit();
				}
        		function submitState() {
					document.getElementById("state").submit();
				}
        		
        		<% 
        		if(request.getAttribute("district") != null){
        		String value3 = request.getAttribute("district").toString();
        			if("true".equals(value3)){
        				String value4 = request.getAttribute("province").toString();
        			int value4int = Integer.parseInt(value4);
        			%>
        			document.getElementById("country-Province").value = "<%= value4int %>";
        			document.getElementById("country-state").disabled = false;
        			<%
        			} }
        		%>
        		
        		<% 
        		if(request.getAttribute("city") != null){
        		String value3 = request.getAttribute("city").toString();
        			if("true".equals(value3)){
        				String value5 = request.getAttribute("state").toString();
        			int value5int = Integer.parseInt(value5);
        			%>
        			document.getElementById("country-state").value = "<%= value5int %>";
        			document.getElementById("country-city").disabled = false;
        			<%
        			} }
        		%>
        		
        	</script>
        	
     <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
 	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.7.0/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        </div>
  </body>
  </html>