function getAwardedRequests4m() {
    let url = "http://localhost:8080/Dispatcher/api/efunc4";
    let xhr = new XMLHttpRequest();
    let tbody = document.getElementById('infoHere');
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            let awardedRequests4m = JSON.parse(xhr.responseText);
            for(let ar of awardedRequests4m["value"]){
                let tr = document.createElement('tr');
                
                let requestId = document.createElement('td');
                let reimbursementId = document.createElement('td');
                let reasonId = document.createElement('td');
                let uploadTypeId = document.createElement('td');
                let upload = document.createElement('td');
                let amount = document.createElement('td');
                let isAwarded = document.createElement('td');
                let requestDate = document.createElement('td');

                requestId.innerHTML = ar["requestId"];
                reimbursementId.innerHTML = ar["reimbursementId"];
                reasonId.innerHTML = ar["reasonId"];
                uploadTypeId.innerHTML = ar["uploadTypeId"];
                upload.innerHTML = ar["upload"];
                amount.innerHTML = ar["amount"];
                isAwarded.innerHTML = ar["isAwarded"];
                requestDate.innerHTML = ar["requestDate"];

                tr.append(requestId);
                tr.append(reimbursementId);
                tr.append(reasonId);
                tr.append(uploadTypeId);
                tr.append(upload);
                tr.append(amount);
                tr.append(isAwarded);
                tr.append(requestDate);


            }
        }
    }
    xhr.open('GET', url);
    xhr.send();

}

let efunc44mView = document.getElementById("efunc44mView");
efunc44mView.addEventListener("click", getAwardedRequests4m);