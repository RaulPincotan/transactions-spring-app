function addNew(){
const product=$('#modal-transaction-product').val();
const amount=$('#modal-transaction-amount').val();
const type=$('#modal-transaction-type').val();
//aici mai sus folosim jquery. Luam elementele din pagina web (DOM). Deci am luat intro variabila valoarea de pe idul
//modal transaciton product care ii inputul din labelu ala sau ce ii

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
//cand punem header, ii zicem ca ii trimitem json
//location reload ala face refresh automat la pagina


function editTransaction(transactionIdToEdit){
const product=$('#modal-transaction-product').val();
const amount=$('#modal-transaction-amount').val();
const type=$('#modal-transaction-type').val();
//aici mai sus folosim jquery. Luam elementele din pagina web (DOM). Deci am luat intro variabila valoarea de pe idul
//modal transaciton product care ii inputul din labelu ala sau ce ii



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












//$(document).ready(()=>{ // aici facem ca pagina sa fie incarcata. adica incarcam pagina intai
//$('.fa-edit').click(function(){
//
//
//let transactionIdToEdit=this.parentElement.id;//parintele
//
//const row=this.parentElement.parentElement;//row
//const product= row.childred[0].innerText;// iau textul de pe product
//const type= row.childred[1].innerText;// iau textul de pe type
//const amount= row.childred[2].innerText;// iau textul de pe amount
//
//
//
////ca sa le incarcam in form
//$('#modal-transaction-product').val(product);
//$('#modal-transaction-type').val(type);
//$('#modal-transaction-amount').val(amount);
//});
//
//});



//ca sa ia valoarea de pe fiecare rand. Vom seta in HTML un id pe rand. adica fiecare icon dinala tre sa aiba un id. Iconul
//de pe randul 3 tre sa aiba idul corespunzator
