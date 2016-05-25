<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="common/head.jsp?title=Descrizione"/>
    <body>
        <jsp:include page="common/header.jsp?page=descrizione"/>
        <!-- primo paragrafo -->
        <h1>Il mercato dell'auto</h1>
        <p>Nel nostro mercato on-line di autoveicoli puoi trovare auto usate o nuove in pochi clic, proprio con le caratteristiche che cercavi e sempre con un contatto diretto con venditori o concessionari. Il nostro motto è: sei tu a decidere quello che trovi! Il dove e il come cercare, sei sempre tu a stabilirlo, grazie ai criteri di ricerca che andrai a impostare, come la marca preferita, il modello, il tipo di carburante, il colore, gli interni, naturalmente il prezzo e tanto altro. Grazie al configuratore per auto nuove inoltre, potrai mettere insieme i criteri dell'auto che cerchi, che si tratti di un’auto nuova, km 0 o immatricolata da meno di un anno.</p>
        <div id="indice">
            <strong>Indice</strong>
            <ol>
                <c:forEach var="categoria" items="${listCategorieAuto}">
                    <li>
                        <a href="#${categoria.getCategoria()}">${categoria.getCategoria()}</a>
                        <ol>
                            <c:forEach var="carburante" items="${listCarburanti}">
                                <li><a href="#${carburante.getNome()}${categoria.getId()}">${carburante.getNome()}</a></li>
                            </c:forEach>
                        </ol>
                    </li>
                </c:forEach>
            </ol>
        </div>
        <div id="body">
            <c:forEach var="categoria" items="${listCategorieAuto}">
                <h2 id="${categoria.getCategoria()}">${categoria.getCategoria()}</h2>
                <p>${categoria.getDescrizione()}</p>
                <c:forEach var="carburante" items="${listCarburanti}">
                    <h3 id="${carburante.getNome()}${categoria.getId()}">${carburante.getNome()}</h3>
                    <ol>
                        <c:forEach var="auto" items="${listAuto}">
                            <c:if test="${auto.getIdCategoria().equals(categoria.getId())}">
                                <c:if test="${auto.getIdCarburante().equals(carburante.getId())}">
                                    <li>${auto.getMarca()}&nbsp;${auto.getModello()}</li>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </ol>
               </c:forEach>
            </c:forEach>
            <!--
            <h2 id="citycar">Citycar</h2>
            <p>Un tempo una specialità del tutto italiana e una tipologia di vettura prevalentemente diffusa in Italia, le superutilitarie iniziano a diffondersi globalmente verso gli anni ottanta e novanta fino a essere presenti in quasi tutto il mondo e nei listini di quasi tutte le maggiori case automobilistiche. La vettura racchiude concetti strettamente legati alle esigenze delle città, ovvero ridotte dimensioni e praticità, nonché grande manovrabilità. In Europa le vetture di questo tipo vengono spesso classificate come appartenenti al segmento A, mentre nel mercato nord americano sono quasi del tutto assenti, anche nelle grandi città, salvo esperimenti recenti come la FIAT 500, Smart Fortwo e Mini.</p>
            <h3 id="ccbenzina">Benzina</h3>
            <ol>
                <li>Fiat
                    <ul>
                        <li>Panda</li>
                    </ul>
                </li>
                <li>Renault
                    <ul>
                        <li>Twingo</li>
                    </ul>
                </li>
                <li>Opel
                    <ul>
                        <li>Aygo</li>
                    </ul>
                </li>
            </ol>
            <h3 id="ccdiesel">Diesel</h3>
            <ol>
                <li>Fiat
                    <ul>
                        <li>Panda</li>
                    </ul>
                </li>
                <li>Renault
                    <ul>
                        <li>Twingo</li>
                        <li>Clio</li>
                    </ul>
                </li>
                <li>Opel
                    <ul>
                        <li>Adam</li>
                    </ul>
                </li>
            </ol>
            <h3 id="ccgpl">GPL</h3>
            <ol>
                <li>Daewoo
                    <ul>
                        <li>Matiz</li>
                    </ul>
                </li>
                <li>Peugeot
                    <ul>
                        <li>1008</li>
                    </ul>
                </li>
                <li>Citroen
                    <ul>
                        <li>C1</li>
                    </ul>
                </li>
            </ol>
            <h2 id="berline">Berline</h2>
            <p>Per berlina si intende la carrozzeria d'autovettura con tetto fisso, generalmente dotata di 4 o 5 porte e principalmente realizzata nelle configurazioni a due, tre o due volumi e mezzo. Il termine berlina indicava, in origine, un particolare tipo di carrozza.</p>
            <h3 id="blbenzina">Benzina</h3>
            <ol>
                <li>Fiat
                    <ul>
                        <li>500</li>
                    </ul>
                </li>
                <li>Renault
                    <ul>
                        <li>Clio</li>
                        <li>Espace</li>
                    </ul>
                </li>
                <li>Volkswagen
                    <ul>
                        <li>Polo</li>
                    </ul>
                </li>
            </ol>
            <h3 id="bldiesel">Diesel</h3>
            <ol>
                <li>Fiat
                    <ul>
                        <li>Punto</li>
                    </ul>
                </li>
                <li>Renault
                    <ul>
                        <li>Megane</li>
                    </ul>
                </li>
                <li>Opel
                    <ul>
                        <li>Calibra</li>
                        <li>Passat</li>
                    </ul>
                </li>
            </ol>
            <h3 id="blgpl">GPL</h3>
            <ol>
                <li>Fiat
                    <ul>
                        <li>Tipo</li>
                    </ul>
                </li>
                <li>Peugeot
                    <ul>
                        <li>407</li>
                        <li>208</li>
                    </ul>
                </li>
                <li>Citroen
                    <ul>
                        <li>C2</li>
                        <li>C3</li>
                    </ul>
                </li>
            </ol>
            -->
        </div>
        <jsp:include page="common/footer.jsp"/>
    </body>
</html>
