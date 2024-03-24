<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="classes.Userdetails" %>
<!DOCTYPE html>
<html>
<head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>User profile</title>

      <link rel="stylesheet" href="css/Userprofile.css" class="rel" />

      <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
  </head>
  <body>
      <div class="main-content">
            

          <div class="header pb-8 pt-5 pt-lg-8 d-flex align-items-center" style="min-height: 600px; background-image: url(https://steamuserimages-a.akamaihd.net/ugc/792007521116448905/F7A121A3F7A929FFB4DBC3AE241B3B4B6EAAED1D/); background-size: cover; background-position: center top;">
          
            <span class="mask bg-gradient-default opacity-8"></span>
          
            <div class="container-fluid d-flex align-items-center">
              <div class="row">
                <div class="col-lg-7 col-md-10">
                  <h1 class="display-2 text-white">Hello Jesse</h1>
                  <p class="text-white mt-0 mb-5">This is your profile page. You can see the progress you've made with your work and manage your projects or assigned tasks</p>
                  
                  <% Userdetails Userdetails = (Userdetails) request.getAttribute("Userdetails"); 
                  
                  if (Userdetails.getType() == "admin")
                  {
                  
                  %>
                  
                 		 <a href="#!" class="btn btn-info" onclick="editaccess()">Edit profile</a>
                 
                 <% } %>
                </div>
              </div>
            </div>
          </div>
          
          <div class="container-fluid mt--7">
            <div class="row">
              <div class="col-xl-4 order-xl-2 mb-5 mb-xl-0">
                <div class="card card-profile shadow">
                  <div class="row justify-content-center">
                    <div class="col-lg-3 order-lg-2">
                      <div class="card-profile-image" style="padding-bottom: 50px;">
                        <a href="#">
                          <img src="https://demos.creative-tim.com/argon-dashboard/assets-old/img/theme/team-4.jpg" class="rounded-circle">
                        </a>
                      </div>
                    </div>
                  </div>
                  <!-- <div class="card-header text-center border-0 pt-8 pt-md-4 pb-0 pb-md-4">
                    <div class="d-flex justify-content-between">
                      <a href="#" class="btn btn-sm btn-info mr-4">Connect</a>
                      <a href="#" class="btn btn-sm btn-default float-right">Message</a>
                    </div>
                  </div> -->
                  
                  
                  <div class="card-body pt-0 pt-md-4">
                    <div class="row">
                      <div class="col">
                        <div class="card-profile-stats d-flex justify-content-center mt-md-5">    
                        </div>
                      </div>
                    </div>
                    <div class="text-center">
                      <h3>
                        <%= Userdetails.getFnameString() + "  " + Userdetails.getLnameString()  %><span class="font-weight-light">, <%= Userdetails.getAge() %></span>
                      </h3>
                      <label></label>
                                        
                      <hr class="my-4">
                      <a href="DonationHistory?nic=<%= (String) session.getAttribute("nic") %>">History</a>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-xl-8 order-xl-1">
                <div class="card bg-secondary shadow">
                  <div class="card-header bg-white border-0">
                    <div class="row align-items-center">
                      <div class="col-8">
                        <h3 class="mb-0">My account</h3>
                      </div>                   
                    </div>
                  </div>
                  <div class="card-body">
                  
                  
                  
                    <form id="form" action="UserUpdateServlet" method="post">
                      <h6 class="heading-small text-muted mb-4">User information</h6>
                      <div class="pl-lg-4">
                        <div class="row">
                                                  <div class="col-lg-4">
                            <div class="form-group focused">
                              <label class="form-control-label"  for="input-username">NIC</label>
                              <input type="text" id="nic" name="nic" class="form-control form-control-alternative" placeholder="Username" value="<%= Userdetails.getNicString() %>" disabled>
                            </div>
                          </div>
                          <div class="col-lg-4">
                            <div class="form-group">
                              <label class="form-control-label"  for="input-email">Email address</label>
                              <input type="email" id="email" name="email" class="form-control form-control-alternative" value="<%= Userdetails.getEmailString() %>" disabled>
                            </div>
                          </div>
                           <div class="col-lg-4">
                            <div class="form-group">
                              <label class="form-control-label"  for="input-email">Blood type</label>
                              <input type="text" id="bltype" name="bloodtype" class="form-control form-control-alternative" value="<%= Userdetails.getBloodtypeString() %>" disabled>
                            </div>
                          </div>
                          
                        <div class="row">
                          <div class="col-lg-6">
                            <div class="form-group focused">
                              <label class="form-control-label"  for="input-first-name">First name</label>
                              <input type="text" id="fname" name="Fname" class="form-control form-control-alternative" placeholder="First name" value="<%= Userdetails.getFnameString() %>" disabled>
                            </div>
                          </div>
                          <div class="col-lg-6">
                            <div class="form-group focused">
                              <label class="form-control-label"  for="input-last-name">Last name</label>
                              <input type="text" id="lname" name="Lname" class="form-control form-control-alternative" placeholder="Last name" value="<%= Userdetails.getLnameString() %>" disabled>
                            </div>
                          </div>
                          <div class="col-lg-6">
                            <div class="form-group focused">
                              <label class="form-control-label"  for="input-last-name">DOB</label>
                              <input type="text" id="dob" name="dob" class="form-control form-control-alternative" placeholder="Last name" value="<%= Userdetails.getDate() %>" disabled>
                            </div>
                          </div>
                          <div class="col-lg-6">
                            <div class="form-group focused">
                              <label class="form-control-label"  for="input-last-name">Gender</label>
                              <input type="text" id="gender" name="gender" class="form-control form-control-alternative" placeholder="Last name" value="<%= Userdetails.getGenderString() %>" disabled>
                            </div>
                          </div>
                        </div>
                      </div>
                      <hr class="my-4">
                    
                      <h6 class="heading-small text-muted mb-4">Contact information</h6>
                      <div class="pl-lg-4">
                        <div class="row">
                          <div class="col-md-12">
                            <div class="form-group focused">
                              <label class="form-control-label"  for="input-address">Address</label>
                              <input id="address" name="address" class="form-control form-control-alternative" placeholder="Home Address" value="<%= Userdetails.getAddresssString() %>" type="text" disabled>
                            </div>
                          </div>
                        </div>
                         <div style="display: none;" id="location">
                            	<a href="UserprofilechangestateServle?nic=<%= Userdetails.getNicString() %>" class="btn btn-info" onclick="editaccess()">Edit Location</a>
                            </div>
                        <div class="row">
                          <div class="col-lg-4">
                            <div class="form-group focused">
                              <label class="form-control-label"  for="input-city">City</label>
                              <input type="text" id="city" class="form-control form-control-alternative" placeholder="City" value="<%= Userdetails.getCname() %>" disabled>
                            </div>
                          </div>
                          <div class="col-lg-4">
                            <div class="form-group focused">
                              <label class="form-control-label"  for="input-country">State</label>
                              <input type="text" id="state" class="form-control form-control-alternative" placeholder="Country" value="<%= Userdetails.getDname() %>" disabled>
                            </div>
                          </div>
                          <div class="col-lg-4">
                            <div class="form-group focused">
                              <label class="form-control-label"  for="input-country">Provice</label>
                              <input type="text" id="Province" class="form-control form-control-alternative" placeholder="Country" value="<%= Userdetails.getPname() %>" disabled>
                            </div>
                            
                           
                            
                            <div style="display: none;" id="submit">
                            <a href="UserprofileServlet?nic=<%= Userdetails.getNicString() %>" class="btn btn-info" >Cancel</a>
                            <a class="btn btn-info"  onclick="submit()">Submit</a>
                            
                            </div>
                            
                          </div>
                         
                        </div>
                      </div>

                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        
        <script>
       <% if (Userdetails.getType() == "admin") {   %> 
        function editaccess() {
			document.getElementById("nic").disabled = false;
			document.getElementById("email").disabled = false;
			document.getElementById("bltype").disabled = false;
			document.getElementById("fname").disabled = false;
			document.getElementById("lname").disabled = false;
			document.getElementById("dob").disabled = false;
			document.getElementById("gender").disabled = false;
			document.getElementById("address").disabled = false;
			/* document.getElementById("city").disabled = false;
			document.getElementById("state").disabled = false;
			document.getElementById("Province").disabled = false; */
			document.getElementById("submit").style.display = "block";
			document.getElementById("location").style.display = "block";
			document.getElementById("dob").type = "date";
			document.getElementById("dob").value = "<%= Userdetails.getDate() %>";
			
		}
        
        function submit() {
        	document.getElementById("form").submit();
		}
         <% } %>
        </script>
        
  </body>
</html>