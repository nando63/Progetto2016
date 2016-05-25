/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function filtra() {
    var filtro = document.getElementById("filtro").value;
    $.ajax({
        url: "filter.json",
        data: { q: filtro.trim() },
        contentType: 'application/json',
        success : function(result) {
            alert('Result:'+result);
        },
        error : function(exception, textStatus){
            alert('Exeption:'+exception);
            alert(textStatus);
            console.log(exception);
        }
    });
}

