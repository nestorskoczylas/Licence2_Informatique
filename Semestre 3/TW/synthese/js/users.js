window.addEventListener("load", initForm);
var div;

function initForm() {
	div = document.getElementById('message');
	document.forms.form_user.addEventListener('submit', sendForm);
}

function processAnswer(answer) {
	if (answer.status == "ok")
		return answer.result;
	else
		throw new Error(answer.message);
}

function sendForm(ev) {
	ev.preventDefault();
	let args = new FormData(this);
	fetchFromJson('services/createUser.php', { 'method': 'post', 'body': args })
		.then(processAnswer)
		.then(userCreated, userNotCreated);
	div.textContent = "Patientez...";
}

function userCreated(result) {
	div.textContent = "Votre utilisateur a été créé !";
}

function userNotCreated(result) {               
	div.textContent = "Cet utilisateur existe déjà (ou paramètre manquand)";
}
