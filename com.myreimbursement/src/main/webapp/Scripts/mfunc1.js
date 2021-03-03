function userReimReq(requestId, reimbursementId, reasonId, 
    uploadTypeId, upload, amount, isAwarded, requestDate){
this.requestId = requestId;
this.reimbursementId = reimbursementId;
this.reasonId = reasonId;
this.uploadTypeId = uploadTypeId;
this.upload = upload;
this.amount = amount;
this.isAwarded = isAwarded;
this.requestDate = requestDate;

}

function updateEmpReq(){
    let url = "http://localhost:8088/com.myreimbursement/Dispatcher/api/mfunc1";

    let xhr = new XMLHttpRequest();

    let requestId = document.getElementById('requestId').value
    let reimbursementId = document.getElementById('reimbursementId').value
    let reasonId = document.getElementById('reasonId').value
    let uploadTypeId = document.getElementById('uploadTypeId').value
    let upload = document.getElementById('upload').value
    let amount = document.getElementById('amount').value
    let isAwarded = document.getElementById('isAwarded');
    let requestDate = document.getElementById('requestDate').value

    let newUserReimReq = new userReimRequests(requestId, reimbursementId, reasonId, uploadTypeId,
        upload, amount, isAwarded, requestDate);
    xhr.onreadystatechange = function() {
        if(xhr.status === 200 && xhr.readyState === 4) {
            console.log("Object successfully sent")
        }
    }
    xhr.open("POST", url);
    xhr.send(JSON.stringify(newUserReimReq));

}
let submissionButton = document.querySelector("button");
submissionButton.addEventListener("click", updateEmpReq);