<script>
  // Wait for the DOM to be loaded before attaching the event handler
  document.addEventListener('DOMContentLoaded', function(event) {

    // Function to validate the login form
    function validateLoginForm() {
      // Get the values from the input fields
      var username = document.getElementById('username').value.trim();
      var password = document.getElementById('password').value.trim();


      if (username === "") {
        alert('Username is required.');
        return false; 
      }

      if (password === "") {
        alert('Password is required.');
        return false; // Prevent form submission
      }


      return true;
    }


</script>
