
window.addEventListener('load', initForm);
function initForm() {
    fetchFromJson('services/getTerritoires.php')
        .then(processAnswer)
        .then(makeOptions);

    document.forms.form_communes.addEventListener("submit", sendForm);

    // décommenter pour le recentrage de la carte :
    //document.forms.form_communes.territoire.addEventListener("change",function(){
    //  centerMapElt(this[this.selectedIndex]);
    //});
}

function processAnswer(answer) {
    if (answer.status == "ok")
        return answer.result;
    else
        throw new Error(answer.message);
}


function makeOptions(tab) {
    for (let territoire of tab) {
        let option = document.createElement('option');
        option.textContent = territoire.nom;
        option.value = territoire.id;
        document.forms.form_communes.territoire.appendChild(option);
        for (let k of ['min_lat', 'min_lon', 'max_lat', 'max_lon']) {
            option.dataset[k] = territoire[k];
        }
    }
}


function sendForm(ev) { // form event listener
    ev.preventDefault();
    let args = new FormData(this);
    let queryString = new URLSearchParams(args).toString();
    let url = 'services/getCommunes.php?' + queryString;
    fetchFromJson(url)
        .then(processAnswer)
        .then(makeCommunesItems);
}


function makeCommunesItems(tab) {
    let list = document.getElementById('liste_communes');
    list.innerHTML = '';
    for (let commune of tab) {
        let elt = document.createElement('li');
        elt.textContent = commune.nom;
        list.appendChild(elt);
        for (let k of ['insee', 'lat', 'lon', 'min_lat', 'min_lon', 'max_lat', 'max_lon']) {
            elt.dataset[k] = commune[k];
        }
        elt.addEventListener("mouseover", recenter);
        elt.addEventListener("click", fetchCommune);
    }
}

function recenter() {
    centerMapElt(this);
}

function fetchCommune() {
    let url = 'services/getDetails.php?insee=' + this.dataset['insee'];
    fetchFromJson(url)
        .then(processAnswer)
        .then(displayCommune);
}

function displayCommune(commune) {
    let details = document.getElementById('details');
    details.innerHTML = '';
    let list = document.createElement('ul');
    details.appendChild(list);
    for (let k of ['insee', 'nom', 'nom_terr', 'lat', 'lon', 'surface', 'perimetre', 'pop2016']) {
        let elt = document.createElement('li');
        elt.textContent = k + ' : ' + commune[k];
        list.appendChild(elt);
    }
    createDetailMap(commune);
}

/**
 * Recentre la carte principale autour d'une zone rectangulaire
 * elt doit comporter les attributs dataset.min_lat, dataset.min_lon, dataset.max_lat, dataset.max_lon, 
 */
function centerMapElt(elt) {
    let ds = elt.dataset;
    map.fitBounds([[ds.min_lat, ds.min_lon], [ds.max_lat, ds.max_lon]]);
}