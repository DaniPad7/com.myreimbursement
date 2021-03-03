function getEmployeesAndManagers() {
    let url = "http://18.216.101.201:8088/com.myreimbursement/Dispatcher/api/mfunc5";
    let xhr = new XMLHttpRequest();
    let tbody = document.getElementById('infoHere');
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            console.log("Objects retrieved successfully");
            let businessInfo = JSON.parse(xhr.responseText);
            for(let pr of businessInfo){
                let tr = document.createElement('tr');
                
                let businessId = document.createElement('td');
                let userId = document.createElement('td');
                let departmentName = document.createElement('td');
                let position = document.createElement('td');
                let reportsTo = document.createElement('td');
                let managerFN = document.createElement('td');
                let managerLN = document.createElement('td');
                
                businessId.innerHTML = pr.businessId;
                userId.innerHTML = pr.userId.userId;
                departmentName.innerHTML = pr.departmentName;
                position.innerHTML = pr.position;
                reportsTo.innerHTML = pr.reportsTo.userId;
                managerFN.innerHTML = pr.reportsTo.firstName;
                managerLN.innerHTML = pr.reportsTo.lastname;
                console.log(businessId.innerText);
                console.log(userId.innerText);
                console.log(departmentName.innerText);
                console.log(position.innerText);
                console.log(reportsTo.innerText);
                 tr.append(businessId);
                tr.append(userId);
                tr.append(departmentName);
                tr.append(position);
                tr.append(reportsTo);
                tr.append(managerFN);
                tr.append(managerLN);
                tbody.append(tr);
            }
        }
    }
    xhr.open('GET', url);
    xhr.send();

}

let mfunc5View = document.getElementById("mfunc5View");
mfunc5View.addEventListener("click", getEmployeesAndManagers);