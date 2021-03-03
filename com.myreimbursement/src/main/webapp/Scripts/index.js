/*function userCorpInfo(username, userId, password, isManager
    ){
this.username = username;
this.userId = userId;
this.password = password;
this.isManager = isManager;

}

function submitLogin(){
    let url = "http://3.142.80.3:8088/com.myreimbursement/Dispatcher/api/login";

    let xhr = new XMLHttpRequest();

    let username1 = document.getElementById('username').value
    let userId1 = 0;
    let password1 = document.getElementById('password').value
    let isManager1 = false;

    let newUserCorpInfo = new userCorpInfo(username1, userId1, password1, isManager1);
    xhr.onreadystatechange = function() {
        if(xhr.status === 200 && xhr.readyState === 4) {
            console.log("Object successfully sent")
        }
    }
    xhr.open("POST", url);
    xhr.send(JSON.stringify(newUserCorpInfo));

}
let submissionButton = document.querySelector("button");
submissionButton.addEventListener("click", submitLogin);*/