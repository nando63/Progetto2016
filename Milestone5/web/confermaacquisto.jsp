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
            <span>Cliente: ${cliente.getNome()}</span>
            <br/>
            <c:set var="nuovosaldo" value="${cliente.getSaldo() - auto.getPrezzo()}"/>
            <span>saldo: € ${cliente.getSaldo()}</span>
            <div id="confermaacquisto">
                <div>
                    <c:if test="${nuovosaldo >= 0}">
                        ${cliente.setSaldo(nuovosaldo)} <!-- messo solo per prova -->
                        <span>Complimenti, hai appena acquistato una ${auto.getMarca()}&nbsp;${auto.getModello()}</span>
                    </c:if>
                    <c:if test="${nuovosaldo < 0}">
                        <span>Peccato, non hai abbastanza soldi per comprarti una ${auto.getMarca()}&nbsp;${auto.getModello()}</span>
                    </c:if>
                </div>
            </div>
        </c:if>
        <jsp:include page="common/footer.jsp"/>
    </body>
</html>
