function getAwardedRequestsAndManagers() {
    let url = "http://localhost:8088/com.myreimbursement/Dispatcher/api/mfunc4";
    let xhr = new XMLHttpRequest();
    let tbody = document.getElementById('infoHere');
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            let awardedRequests = JSON.parse(xhr.responseText);
            for(let pr of awardedRequests["value"]){
                let tr = document.createElement('tr');
               
                let awardId = document.createElement('td');
                let requestId = document.createElement('td');
                let awardAmount = document.createElement('td');
                let awardedBy = document.createElement('td');
                let awardDate = document.createElement('td');

                awardId.innerHTML = pr["awardId"]
                requestId.innerHTML = pr["requestId"];
                awardAmount.innerHTML = pr["awardAmount"];
                awardedBy.innerHTML = pr["awardedBy"];
                awardDate.innerHTML = pr["awardDate"];

                tr.append(awardId);
                tr.append(requestId);
                tr.append(awardAmount);
                tr.append(awardedBy);
                tr.append(awardDate);
                

            }
        }
    }
    xhr.open('GET', url);
    xhr.send();

}

let mfunc4View = document.getElementById("mfunc4View");
mfunc4View.addEventListener("click", getAwardedRequestsAndManagers);