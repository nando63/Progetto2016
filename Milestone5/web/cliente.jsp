<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <jsp:include page="common/head.jsp?title=Cliente"/>
    <body>
        <jsp:include page="common/header.jsp?page=cliente"/>
        <h1>La vetrina</h1>
        <c:if test="${cliente == null}">
            <span>Accesso non autorizzato</span>
        </c:if>
        <c:if test="${cliente != null}">
            <div id="tabclient">
                <span>Cliente: ${cliente.getNome()}</span>
                <br/>
                <span>saldo: € ${cliente.getSaldo()}</span>
                <div id="sezione_filtro">
                    <input type="text" id="filtro"/>
                    <button onclick="filtra();">Filtra</button>
                </div>
                <table>
                    <tr class="intestazione">
                        <th>Marca e modello</th>
                        <th>Immagine</th>
                        <th>Anno immatricolazione</th>
                        <th>Descrizione</th>
                        <th>Prezzo</th>
                        <th></th>
                    </tr>
                    <c:set var="i" value="1"/>
                    <c:forEach var="auto" items="${listAuto}">
                        <c:if test="${i == 1}">
                            <c:set var="riga" value="rigadispari"/>
                        </c:if>
                        <c:if test="${i == 0}">
                            <c:set var="riga" value="rigapari"/>
                        </c:if>
                        <c:set var="i" value="${1 - i}"/>
                        <tr class="${riga}">
                            <td class="modello">${auto.getMarca()}&nbsp;${auto.getModello()}</td>
                            <td>
                                <c:if test="${auto.getImage() != null}">
                                    <img width="100" src="${auto.getImage()}" alt="${auto.getMarca()}&nbsp;${auto.getModello()}" title="${auto.getMarca()}&nbsp;${auto.getModello()}"/>
                                </c:if>
                            </td>
                            <td class="center">${auto.getAnnoImmatricolazione()}</td>
                            <td>${auto.getDescrizione()}</td>
                            <td class="center">€ ${auto.getPrezzo()}</td>
                            <td class="aggiungi"><a href="carrello.html?id=${auto.getId()}">Aggiungi al carrello</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </c:if>
        <jsp:include page="common/footer.jsp"/>
    </body>
</html>
