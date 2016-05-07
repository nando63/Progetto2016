DELETE FROM CLIENTE;
DELETE FROM VENDITORE;
DELETE FROM UTENTE;
DELETE FROM AUTO;
DELETE FROM CATEGORIA;
DELETE FROM CARBURANTE;
INSERT INTO UTENTE(NOME,COGNOME,CODFISC,USERNAME,PASSWORD,SALDO)
    VALUES ('Mauro','Pilia','GGHWWT83G32H645G','cli1','pwd1',5000.0),
        ('Gianni','Fenu','FNEGNN62A11B354O','cli2','pwd2',15000.0),
        ('Alberto','Atzori','TZRABR77G01T555H','cli3','pwd3',7500.0),
        ('Roberto','Formica','FMCRRT76G12B345J','ven1','pwd1',0),
        ('Luigi','Zucca','ZCCLGU74T12H559F','ven2','pwd2',0),
        ('Tiziano','Ferro','FRRTZN86R42Y534L','ven3','pwd3',0);
INSERT INTO CLIENTE(UTENTE_ID) VALUES(1),(2),(3);
INSERT INTO VENDITORE(UTENTE_ID) VALUES(4),(5),(6);
INSERT INTO CATEGORIA(CATEGORIA,DESCRIZIONE)
    VALUES('Citycar','Un tempo una specialità del tutto italiana e una tipologia di vettura prevalentemente diffusa in Italia, le superutilitarie iniziano a diffondersi globalmente verso gli anni ottanta e novanta fino a essere presenti in quasi tutto il mondo e nei listini di quasi tutte le maggiori case automobilistiche. La vettura racchiude concetti strettamente legati alle esigenze delle città, ovvero ridotte dimensioni e praticità, nonché grande manovrabilità. In Europa le vetture di questo tipo vengono spesso classificate come appartenenti al segmento A, mentre nel mercato nord americano sono quasi del tutto assenti, anche nelle grandi città, salvo esperimenti recenti come la FIAT 500, Smart Fortwo e Mini.'),
        ('Berlina','Per berlina si intende la carrozzeria d''autovettura con tetto fisso, generalmente dotata di 4 o 5 porte e principalmente realizzata nelle configurazioni a due, tre o due volumi e mezzo. Il termine berlina indicava, in origine, un particolare tipo di carrozza.'),
        ('Coupé','Viene definita coupé la tipologia di auto con carrozzeria chiusa a 2 porte e tetto non rimovibile.');
INSERT INTO CARBURANTE(NOME) VALUES('Benzina'),('Diesel'),('Gpl');
INSERT INTO AUTO(MARCA,MODELLO,CATEGORIA_ID,CARBURANTE_ID,ANNO_IMMATRICOLAZIONE,TARGA,DESCRIZIONE,PREZZO,IMAGE)
    VALUES('FIAT','Panda',1,1,1995,'GF635FD','Modello semi nuovo',2050,null),
        ('Renault','Twingo',1,1,2001,'TT636HH','Incidentata',1900,null),
        ('Opel','Aygo',1,1,2011,'GT453DD','Nuova',4500,null),
        ('Fiat','Panda',1,2,1999,'AA998GB','Molto vecchia',1500,null),
        ('Renault','Twingo',1,2,2003,'AF884HH','Occasione',3100,'images/image4.jpg'),
        ('Renault','Clio',1,2,2004,'BA998LL','Di terza mano',1100,null),
        ('Opel','Adam',1,2,2011,'EA888JU','Chilometri zero',8000,null),
        ('Chevrolet','Matiz',1,3,2006,'CZ897HL','Con fendinebbia',900,'images/image5.jpg'),
        ('Peugeot','106',1,3,2000,'HY637XX','Cambio automatico',1700,null),
        ('Fiat','500',2,1,2012,'EE777FR','Piccola',4400,'images/image1.jpg'),
        ('Renault','Clio',2,1,2010,'DE536GG','Tetto apribile',5100,null),
        ('Ford','Fiesta',2,2,2010,'AA000AA','Tetto apribile',2100,'images/image2.jpg'),
        ('Volkswagen','Polo',2,2,2014,'ER432TK','Bicolore',4100,null),
        ('Peugeot','407',2,3,2015,'FA378JJ','Da rottamare',200,null),
        ('Citroen','C2',2,3,2011,'CD436HH','Cerchi in lega',3500,null),
        ('Volkswagen','Golf',3,1,2011,'KI220KO','Cerchi in lega',5500,'images/image3.jpg');