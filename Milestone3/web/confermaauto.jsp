<%-- 
    Document   : venditore
    Created on : 23-apr-2016, 16.49.28
    Author     : Nando
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="common/head.jsp?title=Venditore"/>
    <body>
        <jsp:include page="common/header.jsp?page=venditore&set=true"/>
        <h1>Auto in vendita</h1>
        <c:if test="${venditore == null}">
            <span>Accesso non autorizzato</span>
        </c:if>
        <c:if test="${venditore != null}">
            <div id="autoinvendita">
                <div>
                    <span>La tua auto è stata messa in vendita</span>
                </div>
                <div id="riepilogo">
                    <div>riepilogo:</div>
                    <div>
                        <label>Marca</label>
                        <input disabled type="text" value="${auto.getMarca()}"/>
                    </div>
                    <div>
                        <label>Modello</label>
                        <input disabled type="text" value="${auto.getModello()}"/>
                    </div>
                    <div>
                        <label>Anno immatricolazione</label>
                        <input disabled type="text" value="${auto.getAnnoImmatricolazione()}"/>
                    </div>
                    <div>
                        <label>Categoria</label>
                        <input disabled type="text" value="${auto.getCategoria()}"/>
                    </div>
                    <div>
                        <label>Carburante</label>
                        <input disabled type="text" value="${auto.getCarburante()}"/>
                    </div>
                    <div>
                        <label>Descrizione</label>
                        <textarea disabled cols="40" rows="4">${auto.getDescrizione()}</textarea>
                    </div>
                    <div>
                        <label>Prezzo</label>
                        <input disabled type="text" value="${auto.getPrezzo()}"/>
                    </div>
                </div>
            </div>
        </c:if>
    </body>
</html>
