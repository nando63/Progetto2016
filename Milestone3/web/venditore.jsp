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
        <jsp:include page="common/header.jsp?page=venditore"/>
        <h1>Venditore</h1>
        <div>
            <span>Bentornato ${venditore.getNome()}</span>
            <form method="post" action="autoinvendita.html">
                <div>
                    <label for="marca">Marca</label>
                    <input type="text" id="marca" name="marca"/>
                </div>
                <div>
                    <label for="modello">Modello</label>
                    <input type="text" id="modello" name="modello"/>
                </div>
                <div>
                    <label for="categoria">Categoria</label>
                    <select name="categoria" id="categoria">
                        <c:forEach var="categoria" items="${categorieAuto}">
                            <option value="${categoria.getId()}">${categoria.getCategoria()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <label for="categoria">Carburante</label>
                    <select name="carburante" id="carburante">
                        <c:forEach var="carburante" items="${carburanti}">
                            <option value="${carburante.getId()}">${carburante.getNome()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <label for="descrizione">Descrizione</label>
                    <textarea id="descrizione" name="descrizione" cols="60" rows="4">

                    </textarea>
                </div>
                <div>
                    <label for="prezzo">Prezzo</label>
                    <input type="number" id="prezzo" name="prezzo"/>
                </div>
                <div>
                    <label for="quantita">Quantità</label>
                    <input type="number" id="quantita" name="quantita"/>
                </div>
                <div class="submit">
                    <input type="submit" value="Invia"/>
                </div>
            </form>
        </div>
    </body>
</html>
