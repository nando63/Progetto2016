<%-- 
    Document   : cliente
    Created on : 23-apr-2016, 16.48.23
    Author     : Nando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="common/head.jsp?title=Cliente"/>
    <body>
        <jsp:include page="common/header.jsp?page=cliente"/>
        <h1>La tua vetrina</h1>
        <div id="tabclient">
            <span>Bentornato ${cliente.getNome()}</span>
            <table>
                <tr class="intestazione">
                    <th>Marca e modello</th>
                    <th>Immagine</th>
                    <th>Pezzi disponibili</th>
                    <th>Descrizione</th>
                    <th>Prezzo</th>
                    <th></th>
                </tr>
                <tr class="rigadispari">
                    <td class="modello">Fiat 500</td>
                    <td>
                        <img width="100" src="images/image1.jpg" alt="Fiat 500" title="Fiat 500"/>
                    </td>
                    <td class="center">1</td>
                    <td>Modello a benzina con climatizzatore automatico</td>
                    <td>€ 1500</td>
                    <td><a href="cliente.html">Aggiungi al carrello</a></td>
                </tr>
                <tr class="rigapari">
                    <td class="modello">Ford Fiesta</td>
                    <td>
                        <img width="100" src="images/image2.jpg" alt="Ford Fiesta" title="Ford Fiesta"/>
                    </td>
                    <td class="center">2</td>
                    <td>Modello a benzina, cerchi in lega e vernice metallizzata</td>
                    <td>€ 2000</td>
                    <td><a href="cliente.html">Aggiungi al carrello</a></td>
                </tr>
                <tr class="rigadispari">
                    <td class="modello">Volkswagen Golf</td>
                    <td>
                        <img width="100" src="images/image3.jpg" alt="Volkswagen Golf" title="Volkswagen Golf"/>
                    </td>
                    <td class="center">3</td>
                    <td>Modello a benzina, vetri azzurrati e tettuccio apribile</td>
                    <td>€ 3000</td>
                    <td><a href="cliente.html">Aggiungi al carrello</a></td>
                </tr>
                <tr class="rigapari">
                    <td class="modello">Renault Twingo</td>
                    <td>
                        <img width="100" src="images/image4.jpg" alt="Renault Twingo" title="Renault Twingo"/>
                    </td>
                    <td class="center">1</td>
                    <td>Modello diesel, vernice bicolore</td>
                    <td>€ 3100</td>
                    <td><a href="cliente.html">Aggiungi al carrello</a></td>
                </tr>
                <tr class="rigadispari">
                    <td class="modello">Daewoo Matiz</td>
                    <td>
                        <img width="100" src="images/image5.jpg" alt="Daewoo Matiz" title="Daewoo Matiz"/>
                    </td>
                    <td class="center">5</td>
                    <td>Modello GPL con fendinebbia</td>
                    <td>€ 1000</td>
                    <td><a href="cliente.html">Aggiungi al carrello</a></td>
                </tr>
            </table>
        </div>
    </body>
</html>
