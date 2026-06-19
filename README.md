Descrizione:

Il progetto permette di gestire un catalogo di libri e riviste, con la possibilità di registrare utenti e gestire i prestiti.

Entità:

ElementoCatalogo: classe padre con gli attributi comuni (ISBN, titolo, anno, numero pagine)
Libro: estende ElementoCatalogo, aggiunge autore e genere
Rivista: estende ElementoCatalogo, aggiunge la periodicità
Utente: chi prende in prestito gli elementi
Prestito: collega un utente a un elemento del catalogo

Scelta:

Ho scelto la strategia SINGLE_TABLE per gestire l'ereditarietà tra ElementoCatalogo, Libro e Rivista.
Tutte le entità vengono salvate in un'unica tabella elementocatalogo, distinguendo i tipi tramite una colonna tipo (DiscriminatorColumn).

Ho scelto SINGLE_TABLE perché:
È più semplice da gestire (una sola tabella invece di tre)
Le query sono più veloci perché non servono JOIN tra tabelle
Per questo progetto le entità Libro e Rivista hanno pochi attributi extra, quindi le colonne NULL non sono un problema
Lo svantaggio è la presenza di colonne che restano vuote (NULL) quando un attributo appartiene solo a Libro o solo a Rivista ( periodicita è NULL per i libri) però è un compromesso accettabile.

Relazioni:

Un Utente può avere molti Prestiti (1:N)
Un ElementoCatalogo può essere in molti Prestiti (1:N)

Operazioni implementate:

Aggiunta di un elemento al catalogo
Rimozione di un elemento dato l'ISBN
Ricerca per ISBN
Ricerca per anno di pubblicazione
Ricerca per autore
Ricerca per titolo o parte di esso
Ricerca dei prestiti di un utente dato il numero di tessera
Ricerca dei prestiti scaduti e non ancora restituiti

Nota su drawSQL:

Nel diagramma iniziale avevo previsto Genere ed Editore come entità separate.
Durante lo sviluppo ho deciso di gestire il genere come enum (Genere) direttamente
dentro la classe Libro, perché i generi sono valori fissi e predefiniti, quindi non
serve una tabella separata nel database.

pgAdmin ERD:

L'ERD di pgAdmin mostra le 3 tabelle create da Hibernate:
elementocatalogo: contiene libri e riviste insieme (per via del SINGLE_TABLE) la colonna tipo dice se la riga è un libro o una rivista.
utente: i dati degli utenti (nome, cognome, data di nascita, numero tessera).
prestito: contiene le date del prestito e due foreign key (utente_id e elementocatalogo_codiceisbn) che collegano il prestito all'utente e all'elemento.
Le foreign key sono state create automaticamente da Hibernate grazie alle annotazioni @ManyToOne.


