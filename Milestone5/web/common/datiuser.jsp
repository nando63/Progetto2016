<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${venditore != null || cliente != null}">
    <div id="datiuser">
        <c:if test="${venditore != null}">
            <span>Venditore: ${venditore.getNome()}</span>
            <br/>
            <span>saldo: &euro; ${venditore.getSaldo().intValue()}</span>
        </c:if>
        <c:if test="${cliente != null}">
            <span>Cliente: ${cliente.getNome()}</span>
            <br/>
            <span>saldo: &euro; ${cliente.getSaldo().intValue()}</span>
        </c:if>
        <br/>
        <form id="logout" action="logout.html" method="post">
            <input type="submit" name="azione" value="Logout"/>
        </form>
    </div>
</c:if>