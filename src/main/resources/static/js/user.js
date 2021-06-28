/**
 * 
 */

async function logoutUser()
{
	firebase.auth().signOut();
}


async function logoutAdmin()
{
	
	firebase.auth().signOut();
}

function proceedSaveStudent()
{
	alert("added");
	var studentId = document.getElementById("studentId").value;
	alert(studentId);
	/*window.location.href = "/saveStudent";*/
}

function resetPassword()
{
	var auth = firebase.auth();
	var emailAddress = auth.currentUser.email;
	
	auth.sendPasswordResetEmail(emailAddress).then(function() {
	  alert("A password reset email has been sent, please check your mail")
	}).catch(function(error) {
	  alert("An error occured, please contact our support")
	  console.log(error)
	});
}

async function forgotPassword(e)
{
	e.preventDefault()
	
	var auth = firebase.auth();
	var emailAddress = document.getElementById("email").value;
	
	auth.sendPasswordResetEmail(emailAddress).then(function() {
	  alert("A password reset email has been sent, please check your mail")
	  window.location.replace("/login")
	}).catch(function(error) {
	  alert("An error occured, please contact our support")
	  console.log(error)
	});
}