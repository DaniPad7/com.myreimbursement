function getAllReceipts() {
    let url = "http://localhost:8080/Dispatcher/api/mfunc3";
    let xhr = new XMLHttpRequest();
    let tbody = document.getElementById('infoHere');
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            let receipts = JSON.parse(xhr.responseText);
           /* for(let pr of receipts["value"]){
                let tr = document.createElement('tr');
                
                let requestId = document.createElement('td');
                let reimbursementId = document.createElement('td');
                let reasonId = document.createElement('td');
                let uploadTypeId = document.createElement('td');
                let upload = document.createElement('td');
                let amount = document.createElement('td');
                let isAwarded = document.createElement('td');
                let requestDate = document.createElement('td');

                requestId.innerHTML = pr["requestId"];
                reimbursementId.innerHTML = pr["reimbursementId"];
                reasonId.innerHTML = pr["reasonId"];
                uploadTypeId.innerHTML = pr["uploadTypeId"];
                upload.innerHTML = pr["upload"];
                amount.innerHTML = pr["amount"];
                isAwarded.innerHTML = pr["isAwarded"];
                requestDate.innerHTML = pr["requestDate"];

                tr.append(requestId);
                tr.append(reimbursementId);
                tr.append(reasonId);
                tr.append(uploadTypeId);
                tr.append(upload);
                tr.append(amount);
                tr.append(isAwarded);
                tr.append(requestDate);
                

             }*/
        }
    }
    xhr.open('GET', url);
    xhr.send();

}

let mfunc3View = document.getElementById("mfunc3View");
mfunc3View.addEventListener("click", getAllReceipts);