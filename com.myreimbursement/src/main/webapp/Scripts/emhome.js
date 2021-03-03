function logout(){
    let url = "http://3.142.80.3:8088/com.myreimbursement/Dispatcher/api/logout";

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if(xhr.status === 200 && xhr.readyState === 4) {
            console.log("Logout successfully sent")
        }
    }
    xhr.open('GET', url);
    xhr.send();
}

let logout1 = document.getElementById("logoutButton");
logout1.addEventListener("click", logout);