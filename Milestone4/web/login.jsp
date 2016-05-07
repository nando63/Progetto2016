<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <jsp:include page="common/head.jsp?title=Login"/>
    <body>
        <jsp:include page="common/header.jsp?page=login"/>
        <h1>Login</h1>
        <c:if test="${messaggio != null}">
            <div class="errore">
                <span>(${messaggio})</span>
            </div>
        </c:if>
        <form method="post" action="login.html">
            <div>
                <label for="username">Username</label>
                <input type="text" id="username" name="username" value="${username}"/>
            </div>
            <div>
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>
            </div>
            <div class="submit">
                <input name="submit" type="submit" value="Invia"/>
            </div>
        </form>
        <jsp:include page="common/footer.jsp"/>
    </body>
</html>
