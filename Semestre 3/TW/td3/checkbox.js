var setupListeners = function () {

    var checkBox = document.getElementById("myCheck");

    checkBox.addEventListener("change", check);
}

var check = function () {

    var checkBox = document.getElementById("myCheck");

    if (checkBox.checked == true) {
        checkBox.form.bg.setAttribute("disabled", "true");
    }
    else {
        checkBox.form.bg.removeAttribute("disabled");
    }
}

window.addEventListener("load", setupListeners);