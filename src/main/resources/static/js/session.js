/**
 * 
 */
async function sendEmailVerification()
{
	var user = firebase.auth().currentUser;
	var promise = user.sendEmailVerification()
	promise.catch(function(error) {
		alert(error.message);
	});
	return true;
}

async function registerUser(e){
	e.preventDefault()

    var email  = document.getElementById('email').value;
	var password1  = document.getElementById('password1').value;
    var password2  = document.getElementById('password2').value;
	var username = document.getElementById('username').value;
	
	if(password1 === password2) {
		var promise = firebase.auth().createUserWithEmailAndPassword(email,password1).then(function(){
			sendEmailVerification().then(alert("A verification link has been sent to your email. Please check that to continue."));
			var userId = firebase.auth().currentUser.uid;
			const user = firebase.auth().currentUser;

			user.updateProfile({
			  displayName: username
			});
			
			document.getElementById("email").InnerHTML = firebase.auth().currentUser.uid;
			firebase.auth().signOut();
			window.location.replace('/addStudent/'+userId);
		});
		promise.catch(e => alert(e.message));
	}
	else {
		document.getElementById("alert").innerHTML = "The passwords don't match";
	}
}
	
async function loginUser(e){
	e.preventDefault()

    var email  = document.getElementById('email');
    var password  = document.getElementById('password');
	
	var promise = firebase.auth().signInWithEmailAndPassword(email.value,password.value).then(function(){
		var user = firebase.auth().currentUser;
		if(user.emailVerified)
		{
			window.location.href = "/studentHomepage";
		}
		else
		{
			alert("You are not verified yet!")
			sendEmailVerification().then(alert("Email verification sent!"));
			firebase.auth().signOut();
		}
	});
	promise.catch(e => alert(e.message));
}

async function loginCollege(e){
	e.preventDefault()

    var email  = document.getElementById('email');
    var password  = document.getElementById('password');
	
	var promise = firebase.auth().signInWithEmailAndPassword(email.value,password.value).then(function(){
		var user = firebase.auth().currentUser;
		if(user.emailVerified)
		{
			window.location.href = "/adminFrontPage";
		}
		else
		{
			alert("You are not verified yet!")
			sendEmailVerification().then(alert("Email verification sent!"));
			firebase.auth().signOut();
		}
	});
	promise.catch(e => alert(e.message));
}
