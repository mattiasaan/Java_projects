# Java Projects

Raccolta di progetti Java sviluppati per esercitazioni scolastiche. Il codice e i messaggi a schermo sono in italiano.

---

## Struttura del repository

```
Java_projects/
│
├── console/                     # Programmi da terminale
│   ├── Babilonese.java          # Radice quadrata con metodo babilonese
│   ├── Genpass.java             # Generatore di password casuale
│   ├── IMC.java                 # Calcolo dell'indice di massa corporea
│   ├── media/
│   │   ├── media.java           # Media di 3 età (con variabili separate)
│   │   └── media_arr.java       # Media di 3 età (con array)
│   ├── cript/
│   │   └── Cifratura.java       # Cifrario di Cesare (shift +3 ASCII)
│   ├── superenalotto/
│   │   └── Superenalotto.java   # Simulazione lotteria Superenalotto
│   ├── calcolatrice/
│   │   ├── Calc.java            # Classe con i metodi aritmetici
│   │   └── MenuCalc.java        # Calcolatrice con menù e cronologia
│   ├── calcolatrice_brutta/     # Calcolatrice stile shell (versione 1)
│   │   ├── AppCalcolatrice.java
│   │   ├── Calcolatrice.java
│   │   └── CalcolatriceScientifica.java
│   ├── calcolatrice_sigma/      # Calcolatrice con OOP/ereditarietà (versione 2)
│   │   ├── AppCalcolatrice.java
│   │   ├── Calcolatrice.java
│   │   └── CalcolatriceScientifica.java
│   ├── stampante/               # Simulazione stampante (versione base)
│       ├── Documento.java
│       ├── Stampante.java
│       └── ProgStampante.java
│
├── GUI/                         # Programmi con interfaccia grafica Swing
│   ├── pulsanti_base/           # Prima finestra Swing con pulsanti
│   │   ├── Vuota.java
│   │   ├── GestoreFinestra.java
│   │   ├── GestorePulsante.java
│   │   └── Pulsanti.java
│   ├── convertitore_gradi/      # Convertitore di temperature GUI
│   │   ├── Main.java
│   │   ├── App.java
│   │   └── Convertitore.java
│   ├── calcolatrice_gui/        # Calcolatrice grafica con pattern MVC
│   │   ├── Main.java
│   │   ├── App.java
│   │   └── ModelloCalcolatrice.java
│   └── indovina_numero/         # Gioco "indovina il numero" GUI
│       └── IndovinaNumero.java
│
│
└── Monitor/                     # Esercizi su concorrenza e thread safety
    ├── Counter.java
    ├── MessageBuffer.java
    └── ResourcePool.java
```

---

## Progetti Console

### `Babilonese.java`
**Consegna:** Implementare il metodo babilonese (Newton-Raphson) per calcolare la radice quadrata senza usare `Math.sqrt()`. L'utente inserisce il numero e una soglia di accuratezza; il programma itera finché la differenza tra due approssimazioni successive non scende sotto la soglia.

**Formula:** `x_(n+1) = 0.5 * (x_n + N / x_n)`

**Compilazione ed esecuzione:**
```sh
cd console
javac Babilonese.java
java Babilonese
```

---

### `Genpass.java`
**Consegna:** Creare un generatore di password casuale. L'utente specifica la lunghezza (massimo 100 caratteri); il programma genera caratteri casuali nell'intervallo ASCII 65–122 (lettere maiuscole, minuscole e alcuni simboli intermedi).

**Compilazione ed esecuzione:**
```sh
cd console
javac Genpass.java
java Genpass
```

---

### `IMC.java`
**Consegna:** Calcolare l'Indice di Massa Corporea (BMI) a partire da altezza (in metri) e peso (in kg). Il risultato deve essere classificato in: sottopeso, normopeso, sovrappeso, obesità di I, II e III grado. Il programma deve validare l'input e permettere di rieseguire il calcolo.

**Formula:** `IMC = peso / altezza²`

**Classificazioni:**
| IMC | Categoria |
|-----|-----------|
| < 18.5 | Sottopeso |
| 18.5 – 24.9 | Normopeso |
| 25 – 29.9 | Sovrappeso |
| 30 – 34.9 | Obesità I grado |
| 35 – 39.9 | Obesità II grado |
| ≥ 40 | Obesità III grado |

**Compilazione ed esecuzione:**
```sh
cd console
javac IMC.java
java IMC
```

---

### `media/`
**Consegna:** Leggere l'età di tre persone e calcolarne la media aritmetica. L'esercizio viene riproposto in due versioni per confronto:
- `media.java` — usa tre variabili distinte
- `media_arr.java` — usa un array per rendere il codice più scalabile

**Compilazione ed esecuzione:**
```sh
cd console/media
javac media.java && java Media
javac media_arr.java && java Media_arr
```

---

### `cript/Cifratura.java`
**Consegna:** Implementare il cifrario di Cesare con shift di +3 in ASCII. Il programma legge una stringa, converte ogni carattere nel suo valore ASCII, aggiunge 3 e riconverte in carattere.

**Compilazione ed esecuzione:**
```sh
cd console/cript
javac Cifratura.java
java Cifratura
```

---

### `superenalotto/Superenalotto.java`
**Consegna:** Simulare una giocata al Superenalotto semplificato. Il programma genera 6 numeri vincenti unici tra 1 e 20, poi chiede all'utente 6 numeri unici nello stesso intervallo. Alla fine confronta i due set e mostra il punteggio (quanti numeri indovinati).

**Requisiti:** nessun duplicato né nei numeri generati né in quelli inseriti dall'utente; validazione completa dell'input.

**Compilazione ed esecuzione:**
```sh
cd console/superenalotto
javac Superenalotto.java
java Superenalotto
```

---

### `calcolatrice/`
**Consegna:** Implementare una calcolatrice da terminale con menù interattivo. La logica aritmetica è separata in `Calc.java`. `MenuCalc.java` gestisce l'interfaccia, la cronologia circolare degli ultimi 5 risultati, e permette di riutilizzare gli stessi numeri tra un'operazione e l'altra.

**Operazioni disponibili:** somma, sottrazione, moltiplicazione, divisione, cronologia ultimi 5 risultati.

**Compilazione ed esecuzione:**
```sh
cd console/calcolatrice
javac *.java
java MenuCalc
```

---

### `calcolatrice_brutta/`
**Consegna:** Realizzare una calcolatrice con interfaccia stile shell/terminale: l'utente digita comandi testuali (`calc`, `scalc`, `exit`) invece di scegliere numeri da un menù. Le operazioni si invocano con sintassi tipo `addiction 5 3`. Supporta una variabile speciale `ans` per riutilizzare l'ultimo risultato come operando.

**Comandi principali:**
- `calc` → apre la calcolatrice standard
- `scalc` → apre la calcolatrice scientifica (con `pow` e `sqrt`)
- `addiction / difference / multiply / division / module [a] [b]`
- `history show / flush / ans -s [pos] / ans -r`
- `back` → torna al menu, `exit` → esce

**Nota:** usa la ricorsione al posto di un loop — sessioni molto lunghe potrebbero causare StackOverflow.

**Compilazione ed esecuzione:**
```sh
cd console/calcolatrice_brutta
javac *.java
java AppCalcolatrice
```

---

### `calcolatrice_sigma/`
**Consegna:** Progettare una calcolatrice applicando correttamente i principi OOP: ereditarietà, polimorfismo e visibilità dei membri. La classe base `Calcolatrice` gestisce le 4 operazioni standard e la cronologia. `CalcolatriceScientifica` estende la base aggiungendo potenza (`Math.pow`) e radice quadrata (metodo babilonese), sovrascrivendo il menù con `@Override`.

**Requisiti da rispettare:**
- `tastiera` e `input` devono essere `protected` per essere accessibili dalla sottoclasse
- `inserimento()` è `private` in `Calcolatrice`: nella sottoclasse è un nuovo metodo (non un override)
- La cronologia usa uno shift degli elementi (non un indice circolare)

**Compilazione ed esecuzione:**
```sh
cd console/calcolatrice_sigma
javac *.java
java AppCalcolatrice
```

---

### `stampante/`
**Consegna (versione base):** Modellare una stampante con stato on/off e menù di gestione. I metodi devono permettere di creare documenti, stampare, accendere/spegnere, visualizzare coda e lavori completati. È la versione iniziale — la versione avanzata con packages si trova nella cartella `coda di stampa` (non inclusa in questa organizzazione perché incompleta).

**Compilazione ed esecuzione:**
```sh
cd console/stampante
javac *.java
java ProgStampante
```

---

### `coda_di_stampa/`
**Consegna:** Riscrivere la gestione stampanti usando i **packages Java** (`Apps`, `Managers`, `Modelli`). Il progetto applica una separazione netta delle responsabilità: i modelli (`Documento`, `Stampante`) contengono solo dati e getter/setter; `InputManager` centralizza la lettura da tastiera; `ProgStampante` gestisce tutta la logica applicativa. Rispetto alla versione base, la stampante ora ha i livelli di ogni inchiostro, l'IP di rete e la coda di stampa come `Vector<Documento>`.

**Struttura packages:**
```
coda_di_stampa/
├── App.java                  ← entry point
├── Apps/ProgStampante.java   ← logica menù e operazioni
├── Managers/InputManager.java ← utility input centralizzata
└── Modelli/
    ├── Documento.java
    └── Stampante.java
```

**Compilazione ed esecuzione:**
```sh
cd console/coda_di_stampa
javac -cp . Modelli/*.java Managers/*.java Apps/*.java App.java
java -cp . App
```

---

## Progetti GUI (Swing)

### `GUI/pulsanti_base/`
**Consegna:** Creare una finestra Swing con una griglia 2×2 di pannelli. Ogni pannello ha due pulsanti (Superiore e Inferiore) e un'area di testo non modificabile: premendo un pulsante, un messaggio appare nell'area di testo del suo pannello. La logica click è separata nella classe `GestorePulsante` (pattern Listener). `Vuota.java` è la finestra minimale usata come punto di partenza.

**Compilazione ed esecuzione:**
```sh
cd GUI/pulsanti_base
javac *.java
java Pulsanti        # finestra con pulsanti
java Vuota           # finestra vuota di base
```

---

### `GUI/convertitore_gradi/`
**Consegna:** Realizzare un convertitore di temperature con interfaccia grafica Swing. L'utente inserisce un valore numerico, sceglie l'unità di partenza e quella di destinazione tramite `JComboBox`, poi preme "Converti" per vedere il risultato in un dialogo. La logica di conversione è separata nella classe `Convertitore.java` (separazione GUI/logica).

**Unità supportate:** Celsius (°C), Fahrenheit (°F), Kelvin (°K)

**Compilazione ed esecuzione:**
```sh
cd GUI/convertitore_gradi
javac *.java
java Main
```

---

### `GUI/calcolatrice_gui/`
**Consegna:** Creare una calcolatrice grafica ispirata a quelle mobile (iOS/Android). La GUI deve avere: un display grande con l'espressione corrente, un'area cronologia con le operazioni passate, e un tastierino con tutti i tasti standard. La logica di valutazione delle espressioni è separata in `ModelloCalcolatrice.java` (pattern MVC).

**Tasti disponibili:** 0-9, `.`, `+`, `-`, `*`, `/`, `%`, `()`, `AC` (cancella tutto), `del` (cancella ultimo carattere), `=` (calcola)

**Nota:** il parser di espressioni non gestisce la precedenza degli operatori (es. 2+3*4 viene valutato da sinistra a destra).

**Compilazione ed esecuzione:**
```sh
cd GUI/calcolatrice_gui
javac *.java
java Main
```

---

### `GUI/indovina_numero/`
**Consegna:** Creare un gioco grafico "Indovina il numero" con tre livelli di difficoltà. Il programma genera un numero segreto casuale; l'utente ha un numero limitato di tentativi per indovinarlo. Opzione attivabile per ricevere suggerimenti (troppo alto/basso). La UI deve aggiornare dinamicamente lo stato del gioco, abilitare/disabilitare i componenti in base alla fase (pre-gioco / in-gioco), e permettere il reset.

**Livelli:**
| Livello | Range | Tentativi |
|---------|-------|-----------|
| FACILE | 1–10 | 5 |
| MEDIO | 1–50 | 10 |
| DIFFICILE | 1–100 | 15 |

**Compilazione ed esecuzione:**
```sh
cd GUI/indovina_numero
javac IndovinaNumero.java
java IndovinaNumero
```

---

## Monitor (Concorrenza)

**Consegna:** Implementare le strutture dati fondamentali del pattern Monitor per la programmazione concorrente. Ogni classe usa `synchronized` e `wait()`/`notifyAll()` per garantire la thread safety.

| File | Descrizione |
|------|-------------|
| `Counter.java` | Contatore thread-safe con `synchronized` su `increment()` e `getCount()` |
| `MessageBuffer.java` | Buffer produttore/consumatore di capacità 1; il produttore aspetta se pieno, il consumatore se vuoto |
| `ResourcePool.java` | Pool di N risorse condivise; `acquire()` attende se esaurite, `release()` notifica i thread in attesa |

Queste classi non hanno un `main` — sono pensate per essere usate in programmi multi-thread che le istanziano e le passano a `Thread` o `Runnable`.

---

## Compilazione ed esecuzione (riepilogo)

È necessario avere il JDK installato (versione 8 o superiore).

```sh
# File singolo nella root di console/
javac console/NomeFile.java
java -cp console NomeClasse

# Progetto con più file in una directory
cd console/calcolatrice
javac *.java
java MenuCalc

# Progetto GUI
cd GUI/convertitore_gradi
javac *.java
java Main

# GUIBuilder (con package helper_classes)
cd GUIBuilder
javac -cp . helper_classes/*.java WindowBuilder.java
java WindowBuilder
```

---

## Licenza

Questo progetto è distribuito sotto licenza MIT. Vedere il file [LICENSE](LICENSE) per i dettagli.
