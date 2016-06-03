<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array var="auto" items="${listaAuto}">
    <json:object>
        <json:property name="id" value="${auto.getId()}"/>
        <json:property name="marca" value="${auto.getMarca()}"/>
        <json:property name="modello" value="${auto.getModello()}"/>
        <json:property name="descrizione" value="${auto.getDescrizione()}"/>
        <json:property name="prezzo" value="${auto.getPrezzo()}"/>
        <json:property name="anno_immatricolazione" value="${auto.getAnnoImmatricolazione()}"/>
        <c:if test="${auto.getImage() != null}">
            <json:property name="image" value="${auto.getImage()}"/>
        </c:if>
    </json:object>
</json:array>
