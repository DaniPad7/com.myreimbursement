function userReimRequests(requestId, reimbursementId, reasonId, 
    uploadTypeId, amount, isAwarded, requestDate){
this.requestId = requestId;
this.reimbursementId = reimbursementId;
this.reasonId = reasonId;
this.uploadTypeId = uploadTypeId;

this.amount = amount;
this.isAwarded = isAwarded;
this.requestId = requestDate;

}

function submitReimbursementRequest(){
    let url = "http://localhost:8088/com.myreimbursement/Dispatcher/api/efunc1";

    let xhr = new XMLHttpRequest();
    let formData = new FormData();
    let receipt = document.getElementById('upload').files[0];

    let requestId = document.getElementById('requestId').value
    let reimbursementId = document.getElementById('reimbursementId').value
    let reasonId = document.getElementById('reasonId').value
    let uploadTypeId = document.getElementById('uploadTypeId').value
    
    let amount = document.getElementById('amount').value
    let isAwarded = false;
    let requestDate = document.getElementById('requestDate').value

    let newUserReimReq = new userReimRequests(requestId, reimbursementId, reasonId, uploadTypeId,
     amount, isAwarded, requestDate);
     
     formData.append('userReimRequest', JSON.stringify(newUserReimReq));
     formData.append('receipt', receipt);
    xhr.onreadystatechange = function() {
        if(xhr.status === 200 && xhr.readyState === 4) {
            console.log("Object successfully sent")
        }
    }
    xhr.open('POST', url);
    xhr.send(formData);

}
let submissionButton = document.querySelector("button");
submissionButton.addEventListener("click", submitReimbursementRequest);