<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
<header>
    <nav>
        <ul>
            <c:if test="${param.page.equals('descrizione')}">
                 <li class="checked"><span>Descrizione</span></li>
            </c:if>
            <c:if test="${!param.page.equals('descrizione')}">
                 <li><a href="descrizione.html">Descrizione</a></li>
            </c:if>
            <c:if test="${param.page.equals('login')}">
                <li class="checked"><span>Login</span></li>
            </c:if>
            <c:if test="${!param.page.equals('login')}">
                <li><a href="login.html">Login</a></li>
            </c:if>
            <c:if test="${param.page.equals('cliente')}">
                <li class="checked">
                    <c:if test="${param.set != null}">
                        <a href="cliente.html">Cliente</a>
                    </c:if>
                    <c:if test="${param.set == null}">
                        <span>Cliente</span>
                    </c:if>
                </li>
            </c:if>
            <c:if test="${!param.page.equals('cliente')}">
                 <li><a href="cliente.html">Cliente</a></li>
            </c:if>
            <c:if test="${param.page.equals('venditore')}">
                <li class="checked">
                    <c:if test="${param.set != null}">
                        <a href="listaautovenditore.html">Venditore</a>
                    </c:if>
                    <c:if test="${param.set == null}">
                        <span>Venditore</span>
                    </c:if>
                </li>
            </c:if>
            <c:if test="${!param.page.equals('venditore')}">
                 <li><a href="listaautovenditore.html">Venditore</a></li>
            </c:if>
            <%--
            <c:choose>
                <c:when test="${param.page.equals('cliente')}">
                    <li><a href="login.jsp">Login</a></li>
                    <li class="checked"><span>Cliente</span></li>
                    <li><a href="venditore.jsp">Venditore</a></li>
                    <li><a href="descrizione.jsp">Descrizione</a></li>
                </c:when>
                <c:when test="${param.page.equals('login')}">
                    <li class="checked">Login</a></li>
                    <li><a href="cliente.jsp">Cliente</a></li>
                    <li><a href="venditore.jsp">Venditore</a></li>
                    <li><a href="descrizione.jsp">Descrizione</a></li>
                </c:when>
                <c:when test="${param.page.equals('descrizione')}">
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="cliente.jsp">Cliente</a></li>
                    <li><a href="venditore.jsp">Venditore</a></li>
                    <li class="checked">Descrizione</a></li>
                </c:when>
                <c:when test="${param.page.equals('venditore')}">
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="cliente.jsp">Cliente</a></li>
                    <li class="checked">Venditore</a></li>
                    <li><a href="descrizione.jsp">Descrizione</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="cliente.jsp">Cliente</a></li>
                    <li><a href="venditore.jsp">Venditore</a></li>
                    <li><a href="descrizione.jsp">Descrizione</a></li>
                </c:otherwise>
            </c:choose>
            --%>
        </ul>
    </nav>
</header>
