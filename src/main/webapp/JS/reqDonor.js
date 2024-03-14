document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('selectAll').onclick = function() {
        var checkboxes = document.getElementsByName('bloodType');
        for (var checkbox of checkboxes) {
            checkbox.checked = this.checked;
        }
    }
    
    document.getElementById('donorRequestForm').onsubmit = function() {
        // Add validation or AJAX submission logic here
        return false; // Prevent actual form submission for demonstration
    };
});
