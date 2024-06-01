# Sistem de Gestiune Înscrieri

## Introducere
Acest proiect implementează un sistem backend pentru gestionarea înscrierilor participanților la diverse evenimente educaționale. Aplicația permite gestionarea eficientă a participanților, oferind funcționalități pentru adăugarea, verificarea, actualizarea, și eliminarea participanților, precum și gestionarea unei liste de așteptare.

## Structura Proiectului
Proiectul este structurat în trei clase principale:
1. **Guest**: Reprezintă un participant la eveniment.
2. **GuestsList**: Gestiunea listei de participanți.
3. **Main**: Interfața principală a aplicației pentru interacțiunea cu utilizatorul.

### Class 'Guest'
Un invitat este definit prin următoarele atribute:
- last name
- first name
- email
- phone number

### Class 'GuestsList'
Clasa `GuestsList` gestionează înscrierile la un eveniment, incluzând:
- Numărul de locuri disponibile
- Lista de participanți
- Lista de așteptare

#### Funcționalități:
- Adăugarea unei persoane noi
- Verificarea dacă o persoană este înscrisă
- Eliminarea unei persoane
- Actualizarea detaliilor unei persoane
- Obținerea listei de participanți
- Obținerea listei de așteptare
- Obținerea numărului de locuri disponibile
- Obținerea numărului de participanți
- Obținerea numărului de persoane din lista de așteptare
- Obținerea numărului total de persoane înscrise
- Căutarea parțială după un subșir de caractere

### Class 'Main'
Clasa `Main` gestionează interacțiunea cu utilizatorul prin linia de comandă și apelează metodele din `GuestsList` pentru a îndeplini cerințele utilizatorului.

#### Setul de Comenzi:
- `help`: Afișează lista de comenzi disponibile
- `add`: Adaugă o nouă persoană
- `check`: Verifică dacă o persoană este înscrisă
- `remove`: Șterge o persoană existentă
- `update`: Actualizează detaliile unei persoane
- `guests`: Afișează lista de participanți
- `waitlist`: Afișează lista de așteptare
- `available`: Afișează numărul de locuri disponibile
- `guests_no`: Afișează numărul de persoane care participă la eveniment
- `waitlist_no`: Afișează numărul de persoane din lista de așteptare
- `subscribe_no`: Afișează numărul total de persoane înscrise
- `search`: Caută invitații după un subșir de caractere
- `quit`: Închide aplicația

