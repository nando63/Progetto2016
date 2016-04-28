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
        <div>
            <form method="post" action="autoinvendita.html">
                <div>
                    <label>Marca</label>
                    <input type="text" value="${auto.getMarca()}"/>
                </div>
                <div>
                    <label>Modello</label>
                    <input type="text" value="${auto.getModello()}"/>
                </div>
                <div>
                    <label>Categoria</label>
                    <input type="text" value="${auto.getCategoria()}"/>
                </div>
                <div>
                    <label>Carburante</label>
                    <input type="text" value="${auto.getCarburante()}"/>
                </div>
                <div>
                    <label>Descrizione</label>
                    <textarea cols="40" rows="4">${auto.getDescrizione()}</textarea>
                </div>
                <div>
                    <label>Prezzo</label>
                    <input type="text" value="${auto.getPrezzo()}"/>
                </div>
            </form>
        </div>
    </body>
</html>
