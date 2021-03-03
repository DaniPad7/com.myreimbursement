function getPersonalInformation() {
    let url = "http://18.216.101.201:8088/com.myreimbursement/Dispatcher/api/efunc5";
    let xhr = new XMLHttpRequest();
    let tbody = document.getElementById('infoHere');
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            console.log("Object successfully retrieved");
            let personalInformation = JSON.parse(xhr.responseText);
                let tr = document.createElement('tr');
                
                let userId = document.createElement('td');
                let firstName = document.createElement('td');
                let lastName = document.createElement('td');
                let email = document.createElement('td');
                let phoneNumber = document.createElement('td');
                let city = document.createElement('td');
                let state = document.createElement('td');
                let country = document.createElement('td');

                userId.innerHTML = personalInformation["userId"];
                firstName.innerHTML = personalInformation["firstName"];
                lastName.innerHTML = personalInformation["lastname"];
                email.innerHTML = personalInformation["email"];
                phoneNumber.innerHTML = personalInformation["phoneNumber"];
                city.innerHTML = personalInformation["city"];
                state.innerHTML = personalInformation["state"];
                country.innerHTML = personalInformation["country"];
console.log(userId.innerText);
console.log(firstName.innerText);
console.log(lastName.innerText);
console.log(email.innerText);
console.log(phoneNumber.innerText);
console.log(city.innerText);
console.log(state.innerText);
console.log(country.innerText);
                tr.append(userId);
                tr.append(firstName);
                tr.append(lastName);
                tr.append(email);
                tr.append(phoneNumber);
                tr.append(city);
                tr.append(state);
                tr.append(country);
                tbody.append(tr);

            
        }
    }
    xhr.open('GET', url);
    xhr.send();
    
}

let efunc5View = document.getElementById("efunc5View");
efunc5View.addEventListener("click", getPersonalInformation);