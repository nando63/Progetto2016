<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <jsp:include page="common/head.jsp?title=${param.tipo.equals('v')?'Venditore':'Cliente'}"/>
    <body>
        <jsp:include page="common/header.jsp?page=${param.tipo.equals('v')?'venditore':'cliente'}"/>
        <h1>Accesso non valido</h1>
        <span>Accesso non autorizzato</span>
        <jsp:include page="common/footer.jsp"/>
    </body>
</html>
