function togglePasswordVisibility() {
    var passwordField = document.getElementById("adminPassword");
    if (passwordField.type === "password") {
        passwordField.type = "text";
    } else {
        passwordField.type = "password";
    }
}

