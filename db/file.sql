create table document (
    id number generated as identity primary key
    name varchar2(100) not null,
    type varchar2(100) not null, -- media type es: image/png
    data blob not null -- serve a salvare file nel db, blob = Binary Large Object
    -- i blob vengono utlizzati quando non si puo archiviare il file in semplici righe di testo
    -- come immagini, documenti, word...
    -- il blob e una sequenza di 0 e 1, l'applicazione quando estrarra ricomporra quei byte e ottera il file
);