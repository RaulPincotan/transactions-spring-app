function addNew(){
const product=$('#modal-transaction-product').val();
const amount=$('#modal-transaction-amount').val();
const type=$('#modal-transaction-type').val();


fetch('/api/transactions', {
method:'POST',
body:JSON.stringify({
product:product,
amount:amount,
type:type
}),
headers:{
'Content-Type':'application/json'
}

}).then(response=>location.reload());
}



function editTransaction(transactionIdToEdit){
const product=$('#modal-transaction-product').val();
const amount=$('#modal-transaction-amount').val();
const type=$('#modal-transaction-type').val();




fetch('/api/transactions/'+transactionIdToEdit, {
method:'PUT',
body:JSON.stringify({
product:product,
amount:amount,
type:type
}),
headers:{
'Content-Type':'application/json'
}

}).then(response=>location.reload());
}




$(document).ready(() => {
let transactionIdToEdit=null;

$('#add-transaction-button').click(function () {
if(transactionIdToEdit){
editTransaction(transactionIdToEdit);
}else{
addNew();
}
});

    $('.fa-edit').click(function () {
        transactionIdToEdit = this.parentElement.id;

        const row = this.parentElement.parentElement;
        const product = row.children[0].innerText;
        const type = row.children[1].innerText;
        const amount = row.children[2].innerText;

        $('#modal-transaction-product').val(product);
        $('#modal-transaction-type').val(type);
        $('#modal-transaction-amount').val(amount);

    });

    $('.fa-trash-alt').click(function(){
    const toDelete=this.parentElement.id;
    fetch('/api/transactions/'+toDelete,{
    method:'DELETE'
    }).then(response=>location.reload());
    });
});













