/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function caricaElencoFiltrato() {
    var filtro = document.getElementById("filtro").value;
    caricaElenco(filtro.trim());
}
function caricaElenco(filtro) {
    $.ajax({
        url: "filter.json",
        data: { q: filtro },
        dataType: 'json',
        success : function(data) {
            console.log(data);
            var element = $('#listaAuto');
            if (element !== null) {
                element.empty();
                if (data.length > 0) {
                    var tr = document.createElement("tr");
                    tr.className = "intestazione";
                    var th = document.createElement("th");
                    th.innerHTML = "Marca e modello";
                    tr.appendChild(th);
                    th = document.createElement("th");
                    th.innerHTML = "Immagine";
                    tr.appendChild(th);
                    th = document.createElement("th");
                    th.innerHTML = "Anno immatricolazione";
                    tr.appendChild(th);
                    th = document.createElement("th");
                    th.innerHTML = "Descrizione";
                    tr.appendChild(th);
                    th = document.createElement("th");
                    th.innerHTML = "Prezzo";
                    tr.appendChild(th);
                    th = document.createElement("th");
                    tr.appendChild(th);
                    element.prepend(tr);
                    for (var i=0; i<data.length; i++) {
                        tr = document.createElement("tr");
                        if ((i % 2) === 1)
                            tr.className = "rigapari";
                        else
                            tr.className = "rigadispari";
                        var td = document.createElement("td");
                        td.className = "modello";
                        td.innerHTML = data[i].marca+" "+data[i].modello;
                        tr.appendChild(td);
                        td = document.createElement("td");
                        if (data[i].image != null && data[i].image != "") {
                            var img = document.createElement("img");
                            img.setAttribute("width","100px");
                            img.setAttribute("src",data[i].image);
                            img.setAttribute("alt",data[i].marca+" "+data[i].modello);
                            img.setAttribute("title",data[i].marca+" "+data[i].modello);
                            td.appendChild(img);
                        }
                        tr.appendChild(td);
                        td = document.createElement("td");
                        td.className = "center";
                        td.innerHTML = data[i].anno_immatricolazione;
                        tr.appendChild(td);
                        td = document.createElement("td");
                        td.innerHTML = data[i].descrizione;
                        tr.appendChild(td);
                        td = document.createElement("td");
                        td.className = "center";
                        td.innerHTML = "€ "+data[i].prezzo;
                        tr.appendChild(td);
                        td = document.createElement("td");
                        td.className = "aggiungi";
                        td.innerHTML = "<a href=\"cliente.html?id="+data[i].id+"\">Aggiungi al carrello</a>";
                        tr.appendChild(td);
                        element.append(tr);
                    }
                }
                else {
                    var tr = document.createElement("tr");
                    td = document.createElement("td");
                    td.innerHTML = "Nessun articolo trovato con questo filtro";
                    tr.appendChild(td);
                    element.append(tr);
                }
            }
        },
        error : function(data, stato) {
            var element = $('#listaAuto');
            if (element != null) {
                element.empty();
                var tr = document.createElement("tr");
                td = document.createElement("td");
                td.innerHTML = "Si è verificato un errore nel caricamento dei dati";
                tr.appendChild(td);
                element.append(tr);
            }
            console.log(data);
        }
    });
}