DROP TABLE AUTO;
DROP TABLE VENDITORE;
DROP TABLE CLIENTE;
DROP TABLE UTENTE;
DROP TABLE CARBURANTE;
DROP TABLE CATEGORIA;
CREATE TABLE "UTENTE" (
    "ID" INTEGER not null primary key GENERATED ALWAYS AS IDENTITY,
    "NOME" VARCHAR(30),
    "COGNOME" VARCHAR(30),
    "CODFISC" CHAR(16),
    "USERNAME" VARCHAR(30),
    "PASSWORD" VARCHAR(30),
    "SALDO" DOUBLE
);
CREATE TABLE "VENDITORE" (
    "ID" INTEGER not null primary key GENERATED ALWAYS AS IDENTITY,
    "UTENTE_ID" INTEGER,
    FOREIGN KEY (UTENTE_ID) REFERENCES UTENTE(ID)
);
CREATE TABLE "CLIENTE" (
    "ID" INTEGER not null primary key GENERATED ALWAYS AS IDENTITY,
    "UTENTE_ID" INTEGER,
    FOREIGN KEY (UTENTE_ID) REFERENCES UTENTE(ID)
);
CREATE TABLE "CARBURANTE" (
    "ID" INTEGER not null primary key GENERATED ALWAYS AS IDENTITY,
    "NOME" VARCHAR(30)
); 
CREATE TABLE "CATEGORIA" (
    "ID" INTEGER not null primary key GENERATED ALWAYS AS IDENTITY,
    "CATEGORIA" VARCHAR(30),
    "DESCRIZIONE" CLOB(1500)
); 
CREATE TABLE "AUTO" (
    "ID" INTEGER not null primary key GENERATED ALWAYS AS IDENTITY,
    "MARCA" VARCHAR(30),
    "MODELLO" VARCHAR(30),
    "CATEGORIA_ID" INTEGER,
    "CARBURANTE_ID" INTEGER,
    "PROPRIETARIO_ID" INTEGER,
    "ANNO_IMMATRICOLAZIONE" INTEGER,
    "DESCRIZIONE" VARCHAR(255),
    "TARGA" CHAR(7),
    "PREZZO" INTEGER,
    "IMAGE" VARCHAR(30),
    FOREIGN KEY (CATEGORIA_ID) REFERENCES CATEGORIA(ID),
    FOREIGN KEY (CARBURANTE_ID) REFERENCES CARBURANTE(ID),
    FOREIGN KEY (PROPRIETARIO_ID) REFERENCES UTENTE(ID)
);