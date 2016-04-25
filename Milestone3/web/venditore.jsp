<%-- 
    Document   : venditore
    Created on : 23-apr-2016, 16.49.28
    Author     : Nando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="common/head.jsp?title=Venditore"/>
    <body>
        <jsp:include page="common/header.jsp?page=venditore"/>
        <h1>Venditore</h1>
        <div>
            <span>Bentornato ${venditore.getNome()}</span>
            <form method="post" action="#">
                <div>
                    <label for="modello">Marca e modello</label>
                    <input type="text" id="modello" name="modello"/>
                </div>
                <div>
                    <label for="foto">Foto</label>
                    <input type="text" id="foto" name="foto"/>
                </div>
                <div>
                    <label for="descrizione">Descrizione</label>
                    <textarea id="descrizione" name="descrizione" cols="60" rows="4">

                    </textarea>
                </div>
                <div>
                    <label for="prezzo">Prezzo</label>
                    <input type="number" id="prezzo" name="prezzo"/>
                </div>
                <div>
                    <label for="quantita">Quantità</label>
                    <input type="number" id="quantita" name="quantita"/>
                </div>
                <div class="submit">
                    <input type="submit" value="Invia"/>
                </div>
            </form>
        </div>
    </body>
</html>
