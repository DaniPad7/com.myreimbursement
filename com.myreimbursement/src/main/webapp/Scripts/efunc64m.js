function userPersonalInfo(userId, firstName, lastName, 
    email, phoneNumber, city, state, country){
this.userId = userId;
this.firstName = firstName;
this.lastName = lastName;
this.email = email;
this.phoneNumber = phoneNumber;
this.city = city;
this.state = state;
this.country = country;

}

function updatePersInfo(){
    let url = "http://3.142.80.3:8088/com.myreimbursement/Dispatcher/api/efunc6";

    let xhr = new XMLHttpRequest();

    let param1 = document.getElementById('userId').value
    let param2 = document.getElementById('firstName').value
    let param3 = document.getElementById('lastName').value
    let param4 = document.getElementById('email').value
    let param5 = document.getElementById('phoneNumber').value
    let param6 = document.getElementById('city').value
    let param7 = document.getElementById('state').value
    let param8 = document.getElementById('country').value

    let newUserPersInfo = new userPersonalInfo(param1, param2, param3, param4,
        param5, param6, param7, param8);
    xhr.onreadystatechange = function() {
        if(xhr.status === 200 && xhr.readyState === 4) {
            console.log("Object successfully sent")
        }
    }
    xhr.open("POST", url);
    xhr.send(JSON.stringify(newUserPersInfo));

}
let submissionButton = document.querySelector("button");
submissionButton.addEventListener("click", updatePersInfo);