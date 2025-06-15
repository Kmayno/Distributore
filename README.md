# Distributore Automatico

Un sistema di gestione per distributore automatico di bevande sviluppato in Java, che simula le operazioni di acquisto per i clienti e le funzionalità amministrative per la gestione dell'inventario.

## Descrizione

Il progetto implementa un distributore automatico che permette ai clienti di:
- Inserire credito
- Visualizzare l'inventario delle bevande
- Acquistare bevande tramite codice
- Ottenere il resto

Gli amministratori possono:
- Gestire l'inventario (aggiungere/rimuovere bevande)
- Modificare prezzi e quantità
- Monitorare incassi
- Rifornire il distributore

## Struttura del Progetto

```
distributore/
├── Admin.java                          # Gestione funzionalità amministrative
├── Bevanda.java                        # Classe modello per le bevande
├── Cliente.java                        # Interfaccia cliente
├── Distributore.java                   # Logica principale del distributore
├── EccezioneBevandaNonDisponibile.java # Gestione eccezioni personalizzate
└── MainDistributore.java               # Classe principale con menu
```

## Funzionalità

### Per i Clienti
- **Inserimento credito**: Aggiunta di denaro al distributore
- **Visualizzazione inventario**: Lista completa delle bevande disponibili con prezzi
- **Acquisto bevande**: Selezione tramite codice prodotto
- **Erogazione resto**: Recupero del credito residuo
- **Validazione credito**: Controllo credito sufficiente prima dell'acquisto

### Per gli Amministratori
- **Autenticazione**: Accesso protetto da password (default: `12345`)
- **Gestione inventario**:
  - Visualizzazione completa dell'inventario
  - Aggiunta di nuove bevande
  - Rimozione di bevande esistenti
  - Modifica dei prezzi
- **Rifornimento**: Aggiunta di quantità alle bevande esistenti
- **Monitoraggio finanziario**:
  - Visualizzazione incasso totale
  - Azzeramento incasso
  - Azzeramento credito cliente

## Tecnologie Utilizzate

- **Java SE**: Linguaggio di programmazione principale
- **Scanner**: Per l'input da console
- **ArrayList**: Per la gestione dinamica dell'inventario
- **Exception Handling**: Gestione personalizzata degli errori

##  Installazione e Avvio

### Prerequisiti
- Java JDK 8 o superiore
- IDE Java (Eclipse, IntelliJ IDEA, VS Code) o terminale

### Compilazione ed Esecuzione

1. **Clona il repository**:
   ```bash
   git clone https://github.com/tuousername/distributore-automatico.git
   cd distributore-automatico
   ```

2. **Compila il progetto**:
   ```bash
   javac -d bin src/distributore/*.java
   ```

3. **Esegui l'applicazione**:
   ```bash
   java -cp bin distributore.MainDistributore
   ```

### Esecuzione da IDE
1. Importa il progetto nel tuo IDE
2. Esegui la classe `MainDistributore.java`

## Utilizzo

### Menu Principale
All'avvio, il sistema mostra:
1. **Opzione 1**: Accesso come cliente
2. **Opzione 2**: Accesso come amministratore
3. **Opzione 3**: Uscita dal programma

### Bevande Predefinite
Il distributore viene inizializzato con:
- CocaCola (Codice: 01) - €2,50
- Fanta (Codice: 02) - €2,60  
- Sprite (Codice: 03) - €2,00
- Monster Ultra Violet (Codice: 04) - €3,00
- Birra (Codice: 05) - €3,50

### Esempio di Utilizzo Cliente
```
1. Seleziona "1" per accesso cliente
2. Inserisci credito (es. 5.00€)
3. Visualizza inventario per vedere i codici
4. Acquista una bevanda inserendo il codice (es. "01")
5. Eroga resto se necessario
```

### Esempio di Utilizzo Admin
```
1. Seleziona "2" per accesso admin
2. Inserisci password: 12345
3. Scegli un'operazione dal menu amministrativo
4. Gestisci inventario, prezzi o visualizza incassi
```

## Caratteristiche Tecniche

### Gestione degli Errori
- **EccezioneBevandaNonDisponibile**: Gestisce i casi di:
  - Bevanda esaurita
  - Codice prodotto non valido
  - Credito insufficiente

### Validazione Input
- Controllo degli importi negativi
- Gestione degli errori di input con `InputMismatchException`
- Validazione dei codici prodotto

### Architettura
- **Separazione delle responsabilità**: Ogni classe ha un ruolo specifico
- **Incapsulamento**: Uso di getter/setter per l'accesso ai dati
- **Gestione dello stato**: Mantenimento di credito e incasso

## Autori

- Carmine Nigro
- Valerio Piccolo
- Ludovica Colaci
- Salvatore Baiano
- Carmen Della Bruna
---

*Progetto sviluppato come esempio di sistema di gestione distributore automatico in Java.*
