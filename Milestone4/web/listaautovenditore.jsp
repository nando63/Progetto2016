<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <jsp:include page="common/head.jsp?title=Venditore"/>
    <body>
        <jsp:include page="common/header.jsp?page=venditore"/>
        <h1>Le tue auto in vendita</h1>
        <c:if test="${venditore == null}">
            <span>Accesso non autorizzato</span>
        </c:if>
        <c:if test="${venditore != null}">
            <div id="tabclient">
                <span>Venditore: ${venditore.getNome()}</span>
                <br/>
                <span>saldo: € ${venditore.getSaldo()}</span>
                <c:if test="${listAuto.size() == 0}">
                    <div id="nessunaauto">
                        <span>Non hai nessuna auto in vendita</span>
                        <br/>
                        <a href="venditore.html">Aggiungi auto</a>
                    </div>
                </c:if>
                <c:if test="${listAuto.size() > 0}">
                    <table>
                        <tr class="intestazione">
                            <th>Marca e modello</th>
                            <th>Immagine</th>
                            <th>Anno immatricolazione</th>
                            <th>Descrizione</th>
                            <th>Prezzo</th>
                            <th></th>
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
                                <td class="modifica"><a href="formmodifica.html?id=${auto.getId()}"><img alt="modifica" title="modifica" src="images/modify.png"/></a></td>
                                <td class="elimina"><a href="formcancellazione.html?id=${auto.getId()}"><img alt="elimina" title="elimina" src="images/delete.png"/></a></td>
                            </tr>
                        </c:forEach>
                        <tr id="aggiungiauto"><td colspan="7"><a href="venditore.html">Aggiungi auto</a></td></tr>
                    </table>
                </c:if>
            </div>
        </c:if>
        <jsp:include page="common/footer.jsp"/>
    </body>
</html>
