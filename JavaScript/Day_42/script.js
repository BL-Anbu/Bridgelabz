
let form = document.getElementById("myForm");
form.addEventListener("submit", function (e) {
    e.preventDefault();

    let name = document.getElementById("text").value.trim();
    let email = document.getElementById("email").value.trim();
    let password = document.getElementById("password").value.trim();
    let phoneNumber = document.getElementById("phone").value.trim();

    let isValid = true;

    // clear previous error
    document.getElementById("nameError").innerHTML = "";
    document.getElementById("emailError").innerHTML = "";
    document.getElementById("passwordError").innerHTML = "";
    document.getElementById("phoneError").innerHTML = "";

    // patterns
    let namePattern = /^[A-Za-z ]{3,}$/;
    let emailPattern = /^[a-zA-Z0-9._%+-]+@gmail\.com$/;
    var password_pattern  = /^[a-zA-Z0-9!@#$%^&*]{6,16}$/;
    let phonePattern = /^[6-9]\d{9}$/;

    // Name validation
    if (!namePattern.test(name)) {
        document.getElementById("nameError").innerText =
            "Name must contain only letters and minimum 3 characters";
        isValid = false;
    }

    // Email validation
    if (!emailPattern.test(email)) {
        document.getElementById("emailError").innerText =
            "Please enter a valid Gmail address";

        isValid = false;
    }

    // password validation
    if (password_pattern.test(password)) {
        document.getElementById("passwordError").innerText =
            "Password must be at least 8 characters with letters and numbers";

        isValid = false;
    }

    // phone number validation
    if (!phonePattern.test(phoneNumber)) {
        document.getElementById("phoneError").innerText =
            "phone number must be 10 characters and numbers only";

        isValid = false
    }

   alert("Login successfully......")

});