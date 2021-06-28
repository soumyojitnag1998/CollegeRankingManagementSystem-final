<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/frontStyle.css">
<meta charset="ISO-8859-1">
<title>College Ranking Management System</title>

<!-- The core Firebase JS SDK is always required and must be listed first -->
<script src="https://www.gstatic.com/firebasejs/8.6.1/firebase-app.js"></script>
<script
	src="https://www.gstatic.com/firebasejs/8.6.1/firebase-analytics.js"></script>
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
			
			var userId="";
			firebase.auth().onAuthStateChanged(function(user) {
			    if (user) {
			      document.getElementById("userEmail").innerHTML = firebase.auth().currentUser.email;
			      document.getElementById("userId").innerHTML = firebase.auth().currentUser.uid;
			      userId = firebase.auth().currentUser.uid;
			    } else {
			    	window.location.href = "/";
			    }
			    });
			function myFunction(){
				window.location.replace('/updateStudent/'+userId);
			}
	</script>

<script src="js/user.js"></script>
</head>
<body>
	<center>
		<h1>Welcome</h1>

		<p id="userEmail">User</p>
		<p id="userId"></p>
		<button onclick="logoutUser()">Logout</button>
		<button onclick="window.location.href='studentHomepage'">Continue
			to the website</button>
		<button onclick="myFunction()">Add or Edit Details</button>
	</center>
</body>
</html>