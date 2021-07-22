# RubricaJava
Software Java + Swing con connessione a Server Php + Database Mysql 

Descrizione:

Il programma presenta un interfaccia sviluppata con swing.
All'interno del programma e' possibile o inserire un contatto o visualizzare la lista dei contatti.
Per inserire dei contatti usiamo una classe specifica che contiene dei metodi per inviare una richiesta POST al server per inserire nel DB i dati.
Stessa cosa vale per la visione dei contatti, solo che ci viene restituita una stringa JSON che viene deserializzata sfruttando la libreria Gson.
Trasformiamo il JSON in una classe Contatti che contiene una lista di Contatto, sara' da qui che verranno recuperati i dati da inserire nella tabella.

Implementazioni Extra:
Sarebbe necessaria inserire un pulsante all'interno della view dei contatti che chiama una funzione per
effettuare il refresh dei dati tramite una nuova richiesta POST e aggiornamento della lista.


