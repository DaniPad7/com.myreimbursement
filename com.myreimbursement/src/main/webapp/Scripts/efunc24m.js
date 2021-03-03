/*function userReimRequests(requestId, reimbursementId, reasonId, 
    uploadTypeId, upload, amount, isAwarded, requestDate){
this.requestId = requestId;
this.reimbursementId = reimbursementId;
this.reasonId = reasonId;
this.uploadTypeId = uploadTypeId;
this.upload = upload;
this.amount = amount;
this.isAwarded = isAwarded;
this.requestId = requestDate;

}

function submitReimbursementRequest(){
    let url = "http://3.142.80.3:8088/Dispatcher/api/efunc2";

    let xhr = new XMLHttpRequest();

    let param1 = document.getElementById('requestId').value
    let param2 = document.getElementById('reimbursementId').value
    let param3 = document.getElementById('reasonId').value
    let param4 = document.getElementById('uploadTypeId').value
    let param5 = document.getElementById('upload').value
    let param6 = document.getElementById('amount').value
    let param7 = document.getElementById('isAwarded').value
    let param8 = document.getElementById('requestDate').value

    let newUserReimReq = new userReimRequests(param1, param2, param3, param4,
        param5, param6, param7, param8);
    xhr.onreadystatechange = function() {
        if(xhr.status === 200 && xhr.readyState === 4) {
            console.log("Object successfully sent")
        }
    }
    xhr.open("POST", url);
    xhr.send(JSON.stringify(newUserReimReq));

}
let submissionButton = document.querySelector("button");
submissionButton.addEventListener("click", submitReimbursementRequest);*/