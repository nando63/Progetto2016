<%-- 
    Document   : cliente
    Created on : 23-apr-2016, 16.48.23
    Author     : Nando
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <th>Anno</th>
                    <th>Descrizione</th>
                    <th>Prezzo</th>
                    <th></th>
                </tr>
                <c:forEach var="auto" items="${listAuto}">
                    <c:if test="${auto.getImage() != null}">
                        <tr class="rigadispari">
                            <td class="modello">${auto.getMarca()} ${auto.getModello()}</td>
                            <td>
                                <img width="100" src="${auto.getImage()}" alt="${auto.getMarca()} ${auto.getModello()}" title="${auto.getMarca()} ${auto.getModello()}"/>
                            </td>
                            <td class="center">${auto.getAnnoFabbricazione()}</td>
                            <td>${auto.getDescrizione()}</td>
                            <td>€ ${auto.getPrezzo()}</td>
                            <td><a href="cliente.html?id=${auto.getId()}">Aggiungi al carrello</a></td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
