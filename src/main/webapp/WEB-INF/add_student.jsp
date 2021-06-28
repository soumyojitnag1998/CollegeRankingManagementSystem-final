<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/Style.css">
	<link rel="stylesheet" href="css/frontStyle.css">
	<meta charset="ISO-8859-1">
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="css/frontStyle.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Seaweed+Script&display=swap" rel="stylesheet">
    <title>Student Login</title>
	
	<!-- The core Firebase JS SDK is always required and must be listed first -->
	<script src="https://www.gstatic.com/firebasejs/8.6.1/firebase-app.js"></script>
	<script src="https://www.gstatic.com/firebasejs/8.6.1/firebase-analytics.js"></script>
	<script src="https://www.gstatic.com/firebasejs/8.6.1/firebase-auth.js"></script>
	
	<script>
			var firebaseConfig = {
					apiKey: "${apiKey}",
					authDomain: "${authDomain}",
					projectId: "${projectId}",
					storageBucket: "${storageBucket}",
					messagingSenderId: "${messagingSenderId}",
					appId: "${appId}"
			};

			firebase.initializeApp(firebaseConfig);
			
			firebase.auth().onAuthStateChanged(function(user) {
			    if (user) {
			      document.getElementById("userId").innerHTML = firebase.auth().currentUser.uid;
			    }
			    });
	</script>
	<link rel="stylesheet" href="css/Style.css">
	<link rel="stylesheet" href="css/frontStyle.css">
</head>
<style>

body {
    font-family: Arial, Helvetica, sans-serif;
    background-color:darkblue;
    color: white;
}
form {
    border: 3px solid #f1f1f1;

}

   .content
{
    
     max-width: 500px;
  margin: auto;
}

input {
  background-color: white;
  
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
 
  width: 100%;
}

button {
  background-color:#4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  border-radius: 20px;
}
/* latin-ext */
@font-face {
  font-family: 'Seaweed Script';
  font-style: normal;
  font-weight: 400;
  font-display: swap;
  src: url(https://fonts.gstatic.com/s/seaweedscript/v8/bx6cNx6Tne2pxOATYE8C_Rsoe3WA8qY2VQ.woff2) format('woff2');
  unicode-range: U+0100-024F, U+0259, U+1E00-1EFF, U+2020, U+20A0-20AB, U+20AD-20CF, U+2113, U+2C60-2C7F, U+A720-A7FF;
}
/* latin */
@font-face {
  font-family: 'Seaweed Script';
  font-style: normal;
  font-weight: 400;
  font-display: swap;
  src: url(https://fonts.gstatic.com/s/seaweedscript/v8/bx6cNx6Tne2pxOATYE8C_Rsoe3WO8qY.woff2) format('woff2');
  unicode-range: U+0000-00FF, U+0131, U+0152-0153, U+02BB-02BC, U+02C6, U+02DA, U+02DC, U+2000-206F, U+2074, U+20AC, U+2122, U+2191, U+2193, U+2212, U+2215, U+FEFF, U+FFFD;
}
body{
    margin:0px;
    padding:5px;
    background-position:center center;
    background-repeat:no-repeat;
    background-size:cover;
    height: 95vh;
    width:100%;
    background: url(https://wallpaperaccess.com/full/1209477.jpg) no-repeat center fixed;
    background-size:  cover;
   }


form {
    /*border: 3px solid rgb(0, 0, 0);*/
    width:430px;
    height:520px;
    background: rgba(0,0,0,0.6);
    color:#fff;
    top:65%;
    left:50%;
    position:absolute;
    transform:translate(-50%,-50%);
    box-sizing:border-box;
    border-radius: 20px;
    padding:10px;

}

   .content
{
    top:480px;
     max-width: 500px;
  margin: auto;
}

input {
  background-color: white;
  
  padding: 5px 30px;
  margin: 8px 0;
   border: 3px solid rgb(0, 0, 0);
 
  width: 100%;
}

button {
  background-color:#ff952b;
  color: white;
  padding: 10px 5px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}





ul{
    list-style-type: none;
}
   
   .my-navbar{
   background-color: #ffffff;
   }
   .heading
   {
   color: orange;
   }
   
   .nav-item .nav-link{
       color:#000000;
       font-size:13px;
       font-family:arial;
       letter-spacing: 2px;
       margin: 0px 10px;
       text-transform: uppercase;
   }
   .mega-menu{
       background-color: transparent;
   }
   .dropdown:hover .dropdown-menu{
       display: block;
   }
   
   .dropdown-menu{
       border:none;
   }
   
   .dropdown-item{
       padding: 12px 40px 12px 20px;
       font-size: 15px;
       font-family:arial;
       color:#000000;
       font-weight: lighter;
       background-color: #c0c0c0;
       transform-origin: center;
       animation :rotate 1.5s ease 1;
   }
   @keyframes rotate{
       0%{transform: perspective(600px) rotatey(90deg); transform-origin:center;}
       100%{transform: perspective(600px) rotatey(0deg); transform-origin:center;}
   }
   
   .dropdown-item:nth-of-type(1){
       animation-delay: 0s;
   }
   .dropdown-item:nth-of-type(2){
       animation-delay: 0.1s;
   }
   .dropdown-item:nth-of-type(3){
       animation-delay: 0.2s;
   }
   .dropdown-item:nth-of-type(4){
       animation-delay: 0.3s;
   }
   .dropdown-item:nth-of-type(5){
       animation-delay: 0.4s;
   }
   .dropdown-item:nth-of-type(6){
       animation-delay: 0.5s;
   }
   
   .dropdown-item:hover{
       background-color: #808080;
       color:#000000;
   }
   .navbar-brand:hover{
       text-decoration:none;
   }
   .navbar-brand img{
       width: 110px;
       height: 50px;
       border-radius: 50%;
   }
.search-form{
   float:right;
   margin-top:10px;
   margin-right: 100px;
    


}
input[type =text]
{
    padding:7px;
    border:none;
    font-size:16px;
    font-family:sans-serif;
}



.profile{
    position: relative;
    width:60px;
    height:60px;
    border-radius: 20%;
    overflow:hidden;
    cursor: pointer;

}
.profile i{
    position: absolute;
    top: 15px;
    left:10px;
    width:100%;
    height:100%;
    object-fit: cover;
    color: black;
    fill: black;
    font-size: 30px;
}
.menu{
    position:absolute;
    top:120px;
    right: 10px;
    padding:20px 15px ;
   /* background:rgb(83, 93, 94);*/
    background:#c0c0c0;
    width:300px;
    box-sizing: 0 5px 25px rgba(0,0,0,0.1);
    border-radius: 15px;
    transition:0.5s;
    visibility:hidden;
    opacity:0;
    /*background: rgb(0, 0, 0); /* Fallback color */
  /*  background: rgba(0, 0, 0, 0.7); /* Black background with 0.5 opacity */

}
.menu.active{
    visibility:visible;
    top:80px;
    opacity:1;
}
.menu::before{
    content:'';
    position:absolute;
    top:-5px;
    right:15px;
    height:20px; 
    background:#fff;
    transform: rotate(45deg);
}
.menu h3{
    width: 100%;
    text-align: center;
    font-size:18px;
    padding: 20px 0;
    font-family:500;
    color:#fff;
    line-height: 1.2em;

}
.menu ul li i{
    margin-right: 10px;
}
.menu ul li{
    list-style: none;
    padding: 10px 0;
    border-top:1px solid rgba(0,0,0,0.05);
    display:flex;
    align-items: center;
}
.menu ul li img{
    max-width: 20px;
    margin-right:10px ;
    opacity:0.5;
    transition:0.5s;
    
}
.menu ul li:hover img{
    opacity:1;
}
.menu ul li a{
    display: inline-block;
    text-decoration: none;
    color:#000000;
    font-weight:500;
    transition:0.5s;
}
.menu ul li:hover a{
    color:#808080;
}
.wrapper{
    position: absolute;
    top: 38%;
    left: 50%;
    transform: translate(-50%,-50%);
  }
  
  .wrapper .search_box{
    width: 500px;
   /* background: #fff; */
    border-radius: 8px;
    height: 70px;
    display: flex;
    padding: 10px;
    box-shadow: 0 8px 6px -10px #ffffff;
    background: rgb(0, 0, 0,1); /* Fallback color */
    background: rgba(0, 0, 0,0.7); /* Black background with 0.5 opacity */
    color: #f1f1f1;
  }
  
  .wrapper .search_box .dropdown{
    width: 180px;
    border-right: 2px solid #dde2f1;
    color: #ffffff;
    position: relative;
    cursor: pointer;
  }
  
  .wrapper .search_box .dropdown .default_option{
    text-transform: uppercase;
    padding: 13px 15px;
    font-size: 14px;
  }
  
  .wrapper .search_box .dropdown ul{
    position: absolute;
    top: 60px;
    left: -10px;
   /* background: #fff; */
    width: 150px;
    border-radius: 5px;
    padding: 10px;
    display: none;
    box-shadow: 8px 8px 6px -10px #b3c6ff;
     background: rgb(0, 0, 0); /* Fallback color */
  background: rgba(0, 0, 0, 0.7); /* Black background with 0.5 opacity */
  color: #f1f1f1;
  }
  
  .wrapper .search_box .dropdown ul.active{
    display: block;
  }
  
  .wrapper .search_box .dropdown ul li{
    padding-bottom: 10px;
  }
  
  .wrapper .search_box .dropdown ul li:last-child{
    padding-bottom: 0;
  }
  
  .wrapper .search_box .dropdown ul li:hover{
   /* color: #616e9c;*/
    background: rgb(0, 0, 0); /* Fallback color */
  background: rgb(255, 128, 0); /* Black background with 0.5 opacity */
  color: #f1f1f1;
  border-radius: 5px;
  }
  
  .wrapper .search_box .dropdown:before{
    content: "";
    position: absolute;
    top: 18px;
    right: 20px;
    border: 8px solid;
    border-color: #ff8000 transparent transparent transparent;
  }
  
  .wrapper .search_box .search_field{
    width: 350px;
    height: 80%;
    position: relative;
  }
  
  .wrapper .search_box .search_field .input{
    width: 100%;
    height: 100%;
    border: 0px;
    font-size: 16px;
    padding-left: 20px;
    padding-right: 38px;
    color: #c0c0c0;
    background: rgba(0, 0, 0,0.2); /* Fallback color */
    background: rgba(0, 0, 0, 0.7); /* Black background with 0.5 opacity */
    color: #ffffff;
  }
  
  .wrapper .search_box .search_field .fas{
    position: absolute;
    top: 16px;
    right: 10px;
    font-size: 22px;
    color: #ff8000;
    cursor: pointer;
  }
  
  ::-webkit-input-placeholder { 
    color: #bcbcbc;
  }
  .wrapper h3{
      color:#414141;
      margin-bottom: 30px;
      font-style: italic;
  }
  footer{
      position:absolute;
      top: 600px;
      background:#ffffff;
      width:100%;
  }
  .foot{
  position:absolute;
      top: 800px;
      background:#ffffff;
      width:100%;
  }
   .main-content{
  color:black;
  display:flex;
  }
  
  .main-content .box{
  flex-basis: 50%;
  padding:10px 30px;
  }
  .box h2{
  font-size: 1.5rem;
  font-weight: 600;
  text-transform: uppercase;
  }
  .box .footercontent{
  margin: 15px 0 0 0 ;
  }
 .l .footercontent .social{
 margin: 15px 0 0 0 ;
 }
 .l .footercontent .p{
 text-align: justify;
 }
 
 
 
  .l .footercontent .social a{
  padding: 0 2px;
  }
  .l .footercontent .social a span{
  height:40px;
  width: 40px;
  background: #1a1a1a;
  line-height:40px;
  text-align: center;
  font-size: 18px;
  border-radius: 10px;
  transition:0.3s;
  color:white;
  }
  
  .l .footercontent .social a span:hover{
  background: #ff8000;
  }
  .left{
      top:10px;
      left:20px;
      color: #ffffff;
      font-style: italic;
      margin-left:40px;
      margin-top:35px;
      font-size: 25px;
  }
  .h1-head{
  margin-top:200px;
  margin-left:30px;
  font-style: italic;
  color: #ffffff;
  font-size: 25px;
  }
 
 

</style>
<body>

<div class="container-fluid p-0">
    <nav class="navbar navbar-expand-lg my-navbar">
        <a class="navbar-brand" ><img id="logo" src="data:image/png;base64,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" alt="logo"></a>
      
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav m-auto">
            <li class="heading">
              <h3> College Ranking Management System </h3>
            </li>
            
        </ul>
        </div>
       <!--  
        <div class="profile" onclick="menuToggle();">
          <i class="far fa-user icon-4x"></i>
        </div>
        <div class="menu">
         
          <ul>
          
          <li><i class="fas fa-school"></i><a href="/">Home</a></li>
          <li><i class="far fa-user"></i><a href="registration">Student Registration</a></li>
          <li><i class="fas fa-school"></i><a href="collegeLogin">College Login</a></li>
          
          
        </ul>
        </div>
        -->
      </nav>
      






		<footer class="foot">
			<br> <br>
			<div class="main-content">
				<div class="l box">
					<h2>About Us</h2>
					<div class="footercontent">
						<p>A Web site is developed to display the information
							regarding the college for a student to access the website and
							consider the colleges to pursue their education. The website also
							asks for information such as which path are they interested in,
							which job perspective or higher education.</p>
						<div class="social">
							<a href="#"><span class="fab fa-facebook-f"></span></a> <a
								href="#"><span class="fab fa-twitter"></span></a> <a href="#"><span
								class="fab fa-instagram"></span></a> <a href="#"><span
								class="fab fa-youtube"></span></a>
						</div>
					</div>
				</div>
				<div class="c box">
					<h2>Address</h2>
					<div class="footercontent">
						<div class="place">
							<span class="fas fa-map-marker-alt"></span> <span class="text">No
								5/535, Old Mahabalipuram Road, Okkiam -Thoraipakkam, Chennai
								600096, Tamil Nadu, India.</span>
						</div>

					</div>
				</div>
				<div class="r box">
					<h2>Contact Us</h2>
					<div class="footercontent">
						<div class="phone">
							<span class="fas fa-phone-alt"></span> <span class="text">+91-7547808959</span>
						</div>
						<div class="email">
							<span class="fas fa-envelope"></span> <span class="text">college.ranking@gmail.com</span>
						</div>
					</div>
				</div>
			</div>

		</footer>

	
   </div>
<center>
<br>
		<p style="color:black;font-size:20px;">Thank you for Registering with us!</p>
		<p style="border:1px solid white;background-color:red;width:1100px;border-radius:20px;color:white;font-size:20px;">A verification email is sent to your email address, Please fill your details in the below form and verify your email address</p>
	<form:form action="/addStudent" method="post" modelAttribute="student" class="content">
		
		<table>
			<tr>
				<td><form:label path="studentId">Student ID: </form:label></td>
				<td><p style="color:orange;" id="userId">${userId}</p></td>
				<td><form:input path="studentId" id="userId" type="hidden"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="firstName">First Name: </form:label></td>
				<td><form:input path="firstName"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name: </form:label></td>
				<td><form:input path="lastName"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="branch">Branch: </form:label></td>
				<td><form:input path="branch"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="score">Score: </form:label></td>
				<td><form:input path="score"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="location">Location: </form:label></td>
				<td><form:input path="location"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="catagory" style="padding-top:20px;">Category: </form:label></td>
				<td>
					<form:select path="catagory" style="height:40px; width:300px;">
					    <form:option value="Overall">Overall</form:option>
					    <form:option value="Research">Research</form:option>
					    <form:option value="Employment">Employment</form:option>
					</form:select>
				</td>
			</tr>
			<tr>
				<td><form:label path="nationalExamRank">National ExamRank: </form:label></td>
				<td><form:input path="nationalExamRank"></form:input></td>
			</tr>
		</table>
		<form:button>Register</form:button>
	</form:form>
</center>
<script>document.getElementById("userId").InnerHTML = firebase.auth().currentUser.uid</script>
</body>
</html>