var connexion;
var deconnexion;
var message;

function initLoginout() {
	connexion = document.getElementById("connexion");
	deconnexion = document.getElementById("deconnexion");
	if (connexion !== null)
		connexion.addEventListener('click', displayFormLogin);
	else if (deconnexion !== null)
		deconnexion.addEventListener('click', logout);
}

function processAnswer(answer) {
	if (answer.status == "ok")
		return answer.result;
	else
		throw new Error(answer.message);
}

function displayFormLogin() {
	let section = this.parentNode;
	section.removeChild(this);
	let form = document.createElement('form');
	form.setAttribute("id", "form_login");
	form.setAttribute("action", "services/login.php");
	form.setAttribute("method", "post");
	form.innerHTML = '<fieldset><legend>Connexion</legend><label>login :<input type="text" name="login" required="" /></label><label>Mot de passe :<input type="password" name="password" required="" /></label></fieldset>';
	let confirmLogin = document.createElement('button');
	confirmLogin.setAttribute("type", "submit");
	confirmLogin.setAttribute("name", "confirmLogin");
	confirmLogin.setAttribute("value", "");
	confirmLogin.textContent = 'Valider';
	form.appendChild(confirmLogin);
	section.appendChild(form);
	if (message === undefined) {
		message = document.createElement('p');
		message.className = "error";
	}
	message.textContent = '';
	section.appendChild(message);
	document.forms.form_login.addEventListener("submit", sendFormLogin);
}

function sendFormLogin(ev) {
	ev.preventDefault();
	let args = new FormData(this);
	fetchFromJson("services/login.php", { method: 'post', body: args })
		.then(processAnswer)
		.then(updatePageAfterLogin, tryAgain);
}

function updatePageAfterLogin(result) {
	let section = document.getElementById('user');
	let userInfos = document.createElement('p');
	userInfos.setAttribute("id", "userInfos");
	userInfos.innerHTML = "Bienvenue <em>" + result.nom + ' ' + result.prenom + "</em>, <strong>" + result.login + "</strong>";

	if (deconnexion === null) {
		deconnexion = document.createElement('button');
		deconnexion.setAttribute("id", "deconnexion");
		deconnexion.setAttribute("type", "button");
		deconnexion.textContent = "Deconnexion";
	}
	section.innerHTML = '';
	section.appendChild(userInfos);
	section.appendChild(deconnexion);
	deconnexion.addEventListener("click", logout);
}

function tryAgain(error) {
	message.textContent = error.message;
}

function logout() {
	fetchFromJson('services/logout.php', { 'method': 'post' })
		.then(processAnswer)
		.then(updatePageAfterLogout);
}


function updatePageAfterLogout(result) {
	let section = document.getElementById('user');
	section.innerHTML = '';
	if (connexion === null) {
		connexion = document.createElement('button');
		connexion.setAttribute("id", "connexion");
		connexion.setAttribute("type", "button");
		connexion.textContent = "Connexion";
	}
	let link = document.createElement('a');
	link.setAttribute("href", "register.php");
	link.textContent = "Pas encore inscrit?";
	section.appendChild(connexion);
	section.appendChild(link);
	connexion.addEventListener("click", displayFormLogin);
}

window.addEventListener('load', initLoginout);
