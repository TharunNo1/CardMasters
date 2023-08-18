function Validate() {
    var username = document.getElementById("userid").value;
    var password = document.getElementById("password").value;
    var role = document.getElementById("role").value;
    console.log(username + " " + password + " " + role);

    if (username === "Cardmasters" && password === "cardmasters" && role === "admin") {
        console.log("Admin page");
        window.location.href = "./admin/admin.html";
    } else if (username === "Cardmasters" && password === "cardmasters" && role === "user") {
        console.log("User page");
        window.location.href = "./user/user.html"; 
    } else {
        alert("Invalid credentials"); // Show an error message
    }
}

function register() {
    var firstName = document.getElementById("first_name").value;
    var lastName = document.getElementById("last_name").value;
    var dob = document.getElementById("DOB").value;
    var gender = document.getElementById("gender").value;
    var nationalId = document.getElementById("national_id").value;
    var jobTitle = document.getElementById("job-title").value;
    var cardType = document.getElementById("card-type").value;
    var securityPIN = document.getElementById("security_PIN").value;

    var userData = {
        "first_name": firstName,
        "last_name": lastName,
        "date_of_birth": dob,
        "gender": gender,
        "national_id": nationalId,
        "job_title": jobTitle,
        "card_type": cardType,
        "security_pin": securityPIN
    };



    console.log(userData);

    // Assuming you have an API endpoint to send the data to
    var apiUrl = "http://localhost:8080/creditcard/registeration";

    fetch(apiUrl, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(userData)
    })
        .then(data => {
            console.log("Registration successful!", data);
            // You can redirect the user to a success page here if needed
        })
        .catch(error => {
            console.error("Error registering:", error);
            // Handle the error, maybe show an error message to the user
        });
}

function cancelCreditCard() {
    var cardNumber = document.getElementById("card_number").value;
    var securityPIN = document.getElementById("security_pin").value;



    // Assuming you have an API endpoint to send the data to
    var apiUrl = "http://localhost:8080/creditcard/cancellation/" + cardNumber + "-" + securityPIN;

    fetch(apiUrl, {
        method: "DELETE",
    })
        .then(data => {
            console.log("Cancelled the credit card!", data);
            // You can redirect the user to a success page here if needed
        })
        .catch(error => {
            console.error("Error deactivating:", error);
            // Handle the error, maybe show an error message to the user
        });
}

function viewCreditCardDetails() {
    var cardNumber = document.getElementById("card_number").value;
    var securityPIN = document.getElementById("security_pin").value;



    // Assuming you have an API endpoint to send the data to
    var apiUrl = "http://localhost:8080/creditcard/getDetailsByCardNumber/" + cardNumber + "-" + securityPIN;

    fetch(apiUrl, {
        method: "GET",
    })
        .then(response => response.json())
        .then(jsonData => {
            console.log("Got the credit card!", jsonData);
            var container = document.getElementById("dataContainer");
            container.setAttribute("class","table");
            var tbody = document.createElement("tbody")
            for (var key in jsonData) {
                if (jsonData.hasOwnProperty(key)) {
                    var row = document.createElement("tr");

                    var label = document.createElement("th");
                    label.setAttribute("scope","row")
                    label.textContent = key.replace("_", " ").toUpperCase();

                    var value = document.createElement("td");
                    value.textContent = jsonData[key];

                    row.appendChild(label);
                    row.appendChild(value);

                    tbody.appendChild(row);
                }
            }
            container.appendChild(tbody)

            // You can redirect the user to a success page here if needed
        })
        .catch(error => {
            console.error("Error accesssing data:", error);
            // Handle the error, maybe show an error message to the user
        });

}