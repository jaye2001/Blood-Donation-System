document.addEventListener('DOMContentLoaded', function(event) {
    function validateLoginForm() {
        var username = document.getElementById('username').value.trim();
        var password = document.getElementById('password').value.trim();

        if (username === "") {
            alert('Username is required.');
            return false; 
        }

        if (password === "") {
            alert('Password is required.');
            return false; 
        }

        return true;
    }
    // Attach the validateLoginForm function to the form's submit event or button click event as needed.
});
