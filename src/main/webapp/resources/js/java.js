/**
 * 
 */
 
const del = document.getElementById("del");
const frm = document.getElementById("frm");
const up = document.getElementById("up");

up.addEventListener("click",function(){
    frm.setAttribute("action","update");
    frm.setAttribute("method","get")
    frm.submit();
   //let id =  up.getAttribute("data-region-id");

   // location.href="./update?region_id="+id;

});


del.addEventListener("click",function(){

    let result = confirm("정말 지우겠습니까?");

    if(result){
        frm.submit();
    }

 });
 
