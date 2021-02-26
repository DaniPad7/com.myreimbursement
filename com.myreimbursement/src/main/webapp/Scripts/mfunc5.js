function getEmployeesAndManagers() {
    let url = "http://localhost:8080/Dispatcher/api/mfunc5";
    let xhr = new XMLHttpRequest();
    let tbody = document.getElementById('infoHere');
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            let businessInfo = JSON.parse(xhr.responseText);
            for(let pr of businessInfo["value"]){
                let tr = document.createElement('tr');
                
                let businessId = document.createElement('td');
                let userId = document.createElement('td');
                let departmentName = document.createElement('td');
                let position = document.createElement('td');
                let reportsTo = document.createElement('td');
                
                businessId.innerHTML = pr["businessId"];
                userId.innerHTML = pr["userId"];
                departmentName.innerHTML = pr["departmentName"];
                position.innerHTML = pr["position"];
                reportsTo.innerHTML = pr["reportsTo"];
                
                 tr.append(businessId);
                tr.append(userId);
                tr.append(departmentName);
                tr.append(position);
                tr.append(reportsTo);
                
            }
        }
    }
    xhr.open('GET', url);
    xhr.send();

}

let mfunc5View = document.getElementById("mfunc5View");
mfunc5View.addEventListener("click", getEmployeesAndManagers);