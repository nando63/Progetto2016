<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <jsp:include page="common/head.jsp?title=Venditore"/>
    <body>
        <jsp:include page="common/header.jsp?page=venditore"/>
        <h1>Venditore</h1>
        <c:if test="${venditore == null}">
            <span>Accesso non autorizzato</span>
        </c:if>
        <c:if test="${venditore != null}">
            <c:if test="${messaggio != null}">
                <div class="errore">
                    <span>(${messaggio})</span>
                </div>
            </c:if>
            <div>
                <span>Venditore: ${venditore.getNome()}</span>
                <form method="post" action="autoinvendita.html">
                    <div>
                        <label for="marca">Marca</label>
                        <input type="text" id="marca" name="marca" value="${auto.getMarca()}"/>
                    </div>
                    <div>
                        <label for="modello">Modello</label>
                        <input type="text" id="modello" name="modello" value="${auto.getModello()}"/>
                    </div>
                    <div>
                        <label for="categoria">Categoria</label>
                        <select name="categoria" id="categoria">
                            <c:forEach var="categoria" items="${categorieAuto}">
                                <option value="${categoria.getId()}" <c:if test="${categoria.getId() == auto.getIdCategoria()}">selected</c:if>>${categoria.getCategoria()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <label for="carburante">Carburante</label>
                        <%--
                        <c:forEach var="carburante" items="${carburanti}">
                            <label for="carb_${carburante.getId()}">${carburante.getNome()}</label>
                            <input type="radio" id="carb_${carburante.getId()}" name="carburante" value="${carburante.getId()}"/>
                        </c:forEach>
                        --%>
                        <select name="carburante" id="carburante">
                            <c:forEach var="carburante" items="${carburanti}">
                                <option value="${carburante.getId()}" <c:if test="${carburante.getId() == auto.getIdCarburante()}">selected</c:if>>${carburante.getNome()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <label for="anno">Anno immatricolazione</label>
                        <input type="number" id="anno" name="anno" value="${auto.getAnnoImmatricolazione()}"/>
                    </div>
                    <div>
                        <label for="targa">Targa</label>
                        <input type="text" id="targa" name="targa" value="${auto.getTarga()}"/>
                    </div>
                    <div>
                        <label for="image">Immagine</label>
                        <input type="text" id="image" name="image" value="${auto.getImage()}"/>
                    </div>
                    <div>
                        <label for="descrizione">Descrizione</label>
                        <textarea id="descrizione" name="descrizione" cols="60" rows="4">${auto.getDescrizione()}</textarea>
                    </div>
                    <div>
                        <label for="prezzo">Prezzo</label>
                        <input type="number" id="prezzo" name="prezzo" value="${auto.getPrezzo()}"/>
                    </div>
                    <div class="submit">
                        <input type="submit" value="Invia"/>
                    </div>
                </form>
            </div>
        </c:if>
        <jsp:include page="common/footer.jsp"/>
    </body>
</html>
