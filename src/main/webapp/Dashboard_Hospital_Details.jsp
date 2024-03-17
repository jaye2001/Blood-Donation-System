<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>Hospital Request Details</title>
    <link href="css/DashbordH.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer">
</head>
<body>
    <nav class="sidebar">
       <a href="#" class="logo">Blood Bank System</a> 

       <div class="menu-content">
        <ul class="menu-items">
            <div class="menu-title">Dashboard</div>

            <li class="item">
                <a href="home.jsp">Home</a>
            </li>

            <li class="item">
                <div class="submenu-item">
                    <span>Admin</span>
                    <i class="fa-solid fa-chevron-right"></i>
                </div>

                <ul class="menu-items submenu">
                    <div class="menu-title">
                    <i class="fa-solid fa-chevron-left"></i>
                    Admin</div>
        
                    <li class="item">
                        <a href="#">Admin Profile</a>
                    </li>

                    <li class="item">
                        <a href="#">Add Admin</a>
                    </li>
        
                </ul>
                
            </li>
            
            
            <li class="item">
                <div class="submenu-item">
                    <span>Doner</span>
                    <i class="fa-solid fa-chevron-right"></i>
                </div>

                <ul class="menu-items submenu">
                    <div class="menu-title">
                        <i class="fa-solid fa-chevron-left"></i>
                        Doner</div>
        
                    <li class="item">
                        <a href="#">Doner Profile</a>
                    </li>

                    <li class="item">
                        <a href="#">Doner History</a>
                    </li>
        			
        			<li class="item">
                        <a href="#">Doner Registration</a>
                    </li>

                    <li class="item">
                        <a href="#">Doner blood give profile</a>
                    </li>
                    
                </ul>
                
            </li>
            
            <li class="item">
                <div class="submenu-item">
                    <span>Hospital</span>
                    <i class="fa-solid fa-chevron-right"></i>
                </div>

                <ul class="menu-items submenu">
                    <div class="menu-title">
                    <i class="fa-solid fa-chevron-left"></i>
                    Hospital</div>
        
                    <li class="item">
                        <a href="#">Hospital Profile</a>
                    </li>

                    <li class="item">
                        <a href="#">Hospital Request Blood Details</a>
                    </li>
        			
        			<li class="item">
                        <a href="#">Request Blood Details History</a>
                    </li>
                    
                </ul>
                
            </li>
            
            <li class="item">
                <div class="submenu-item">
                    <span>Blood</span>
                    <i class="fa-solid fa-chevron-right"></i>
                </div>

                <ul class="menu-items submenu">
                    <div class="menu-title">
                    <i class="fa-solid fa-chevron-left"></i>
                    Blood</div>
        
                    <li class="item">
                        <a href="#">Blood give profile</a>
                    </li>

                    <li class="item">
                        <a href="#">Blood stock check</a>
                    </li>
        			
        			<li class="item">
                        <a href="#">Blood approval</a>
                    </li> 
                </ul>   
            </li>
         </ul>
       </div>
    </nav>

    <nav class="navbar">
        <i class="fa-solid fa-bars" id="sidebar-close"></i>
    </nav>

    <main class="main">
        <h1>Admin Dashboard</h1>
    </main>

    <script>
        const sidebar = document.querySelector(".sidebar");
        const sidebarClose = document.querySelector(".#sidebar-close");
        const menu = document.querySelector(".menu-content");
        const SubMenuItems = document.querySelectorAll("submenu .menu-item");
        const SubMenuTitles = document.querySelectorAll("submenu .menu-title");
        
        sidebarClose.addEventListener("click", ()=>sidebar.classList.toggle("close"));
        
        
        
        menuItems.forEach((item,index) => {
            item.addEventListener("click", () =>{
                menu.classList.add("submenu-active");
               item.classList.add("show-submenu") ;
               menuItems.forEach((item2.index2) => {
                    if(index !== index2){
                        item2.classList.remove("show-submenu");
                    };
               });
            });
        });

        SubMenuTitles.forEach((title) => {
          title.addEventListener("click", () => {
            menu.classList.remove("submenu-active");
          })  
        });
        console.log(menuItems, SubMenuTitles);
    </script>
</body>
</html>