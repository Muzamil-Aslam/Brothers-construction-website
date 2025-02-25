document.addEventListener("DOMContentLoaded", function () {
    // Form validation function
    function validateForm(form) {
        let valid = true;
        let inputs = form.querySelectorAll("input, select, textarea");
        
        inputs.forEach(input => {
            if (input.hasAttribute("required") && input.value.trim() === "") {
                valid = false;
                input.classList.add("error");
            } else {
                input.classList.remove("error");
            }
        });
        return valid;
    }

    // Handle form submission
    document.querySelectorAll("form").forEach(form => {
        form.addEventListener("submit", function (event) {
            event.preventDefault();
            if (validateForm(this)) {
                alert("Form submitted successfully!");
                this.reset();
            } else {
                alert("Please fill in all required fields.");
            }
        });
    });

    // Order Tracking Simulation
    const orderTrackingForm = document.getElementById("orderTrackingForm");
    if (orderTrackingForm) {
        orderTrackingForm.addEventListener("submit", function (event) {
            event.preventDefault();
            let trackingNumber = document.getElementById("trackingNumber").value.trim();
            let trackingStatus = document.getElementById("trackingStatus");
            
            if (trackingNumber === "") {
                alert("Please enter a tracking number.");
                return;
            }
            
            let statuses = ["Order Received", "Processing", "Dispatched", "Out for Delivery", "Delivered"];
            trackingStatus.innerHTML = "";
            
            statuses.forEach((status, index) => {
                setTimeout(() => {
                    trackingStatus.innerHTML = status;
                }, index * 2000);
            });
        });
    }
});
