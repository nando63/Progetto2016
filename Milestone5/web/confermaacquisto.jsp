<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <jsp:include page="common/head.jsp?title=Cliente"/>
    <body>
        <jsp:include page="common/header.jsp?page=cliente&set=true"/>
        <h1>Conferma acquisto</h1>
        <c:if test="${cliente == null}">
            <span>Accesso non autorizzato</span>
        </c:if>
        <c:if test="${cliente != null}">
            <jsp:include page="common/datiuser.jsp"/>
            <div id="confermaacquisto">
                <div>
                    <span>${messaggio}</span>
                </div>
            </div>
        </c:if>
        <jsp:include page="common/footer.jsp"/>
    </body>
</html>
