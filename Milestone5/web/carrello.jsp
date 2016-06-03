<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <jsp:include page="common/head.jsp?title=Cliente"/>
    <body>
        <jsp:include page="common/header.jsp?page=cliente&set=true"/>
        <h1>Carrello cliente</h1>
        <c:if test="${cliente == null}">
            <span>Accesso non autorizzato</span>
        </c:if>
        <c:if test="${cliente != null}">
            <span>Cliente: ${cliente.getNome()}</span>
            <br/>
            <span>saldo: € ${cliente.getSaldo().intValue()}</span>
            <div id="carrello">
                <c:if test="${auto.getImage() != null}">
                    <div class="immagine">
                        <img src="${auto.getImage()}" alt="${auto.getMarca()}&nbsp;${auto.getModello()}" title="${auto.getMarca()}&nbsp;${auto.getModello()}"/>
                    </div>
                </c:if>
                <div>
                    <label>Marca</label><input disabled type="text" value="${auto.getMarca()}"/>
                </div>
                <div>
                    <label>Modello</label><input disabled type="text" value="${auto.getModello()}"/>
                </div>
                <div>
                    <label>Anno immatricolazione</label><input disabled type="text" value="${auto.getAnnoImmatricolazione()}"/>
                </div>
                <div>
                    <label>Categoria</label><input disabled type="text" value="${auto.getCategoria()}"/>
                </div>
                <div>
                    <label>Carburante</label><input disabled type="text" value="${auto.getCarburante()}"/>
                </div>
                <div>
                    <label>Targa</label><input disabled type="text" value="${auto.getTarga()}"/>
                </div>
                <div>
                    <label>Descrizione</label><textarea disabled cols="40" rows="3">${auto.getDescrizione()}</textarea>
                </div>
                <div>
                    <label>Prezzo</label><input disabled type="text" value="€ ${auto.getPrezzo()}"/>
                </div>
                <div>
                    <form action="confermaacquisto.html" method="post">
                        <input type="hidden" name="idauto" value="${auto.getId()}"/>
                        <input type="submit" value="Conferma acquisto"/>
                    </form>
                </div>
            </div>
        </c:if>
        <jsp:include page="common/footer.jsp"/>
    </body>
</html>
