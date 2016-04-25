<%-- 
    Document   : non_autorizzato
    Created on : 24-apr-2016, 16.45.52
    Author     : Nando
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="common/head.jsp?title=Login"/>
    <body>
        <jsp:include page="common/header.jsp?page=${param.page}"/>
        <h1>
            <c:if test="${param.page.equals('venditore')}">Venditore</c:if>
            <c:if test="${param.page.equals('cliente')}">Cliente</c:if>
        </h1>
        <span>Accesso non autorizzato</span>
    </body>
</html>
