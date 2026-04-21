package Apps;

import Managers.InputManager;
import Modelli.Stampante;
import java.util.Vector;

public class ProgStampante {
    private Vector<Stampante> stampanti = new Vector<>();
    private int ID = 0;
    private byte fogli, nero, magenta, ciano, giallo = 0;
    private String nome, marca, modello, collegamento, ip, subnet = "";
    private Stampante stampanteSelezionata;
    private String testoLetto = "";
    private boolean ripeti = false;

    public void menu() {
        boolean ripeti = true;
        
        do { 
            System.out.println("--------------------------------------------------");
            System.out.println("-               Gestione Stampanti               -");
            System.out.println("--------------------------------------------------");
            System.out.println("- 1) aggiungi una stampante                      -");
            System.out.println("- 2) visualizza le tue stampanti                 -");
            System.out.println("- 3) torna al menu principale                    -");
            System.out.println("--------------------------------------------------");
            System.out.print("scegliere un operazione da eseguire(1-6): ");
            testoLetto = InputManager.leggiRiga();
            byte opzione = Byte.parseByte(testoLetto);

            switch(opzione) {
                case 1:
                    aggiungiStampante();
                    break;
                case 2:
                    mostraStampanti();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("LOG: L'opzione inserita non esiste!");
                    break;
            }
        } while (ripeti);
    }

    private void aggiungiStampante() {
        

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("-                          Aggiungi Stampante                         -");
        System.out.println("-----------------------------------------------------------------------");
        
        ID = (int) (Math.random() * 999) + 1;

        System.out.println("- Che nome vuoi dare alla tua stampante?(es: pippo): ");
        nome = InputManager.leggiRiga().toLowerCase();

        System.out.println("- Inserisci la marca della tua stampante(es: Epson): ");
        marca = InputManager.leggiRiga().toLowerCase();

        System.out.println("- Inserisci il modello della tua stampante(es: XP-245): ");
        modello = InputManager.leggiRiga().toLowerCase();

        do { 
            System.out.println("- Come desideri connettere la tua stampante(cavo/rete): ");
            testoLetto = InputManager.leggiRiga().toLowerCase();

            switch(testoLetto) {
                case "cavo":
                    System.out.println("- Stampante rilevata con successo!");
                    break;
                case "rete":
                    System.out.println("- Inserisci l'indirizzo IP della stampante(es: 192.168.3.56): ");
                    ip = InputManager.leggiRiga();
                    System.out.println("- Inserisci la subnet mask della stampante(es: 255.255.255.0): ");
                    subnet = InputManager.leggiRiga();
                    System.out.println("- Stampante in rete rilevata con successo!");
                    break;
                default:
                    System.out.println("- LOG: Metodo di connessione non valido!");
                    ripeti = true;
                    break;
            }
        } while (ripeti);

        ripeti = false;

        do {
            System.out.println("- Quanti fogli di carta vuoi inserire nella tua stampante(max 20): ");
            testoLetto = InputManager.leggiRiga();
            fogli = Byte.parseByte(testoLetto);
            if(fogli < 1) {
                System.out.println("- LOG: Quantità di fogli indecente!!");
                ripeti = true;
            }
            else if (fogli > 20) {
                System.out.println("- LOG: Quantità di fogli esagerata!!");
                ripeti = true;
            } else {
                System.out.println("- LOG: Fogli inseriti correttamente!");
            }
        } while (ripeti);

        ripeti = false;

        do { 
            System.out.println("- Desideri inserire una cartuccia di tutti colori necessari(S/n): ");
            testoLetto = InputManager.leggiRiga().toLowerCase();

            if(testoLetto.equals("s")) {
                nero = 100;
                magenta = 100;
                ciano = 100;
                giallo = 100;
                System.out.println("- LOG: Cartucce inserite con successo!");
            } else if (testoLetto.equals("n")) {
                System.out.println("- LOG: Nessuna cartuccia inserita!");
            } else {
                System.out.println("- LOG: non ho capito, riprova!");
                ripeti = true;
            }
        } while (ripeti);

        System.out.println("-----------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("-                        Riepilogo informazioni                       -");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("- ID: " + ID);
        System.out.println("- Nome: " + nome);
        System.out.println("- Marca: " + marca);
        System.out.println("- Modello: " + modello);
        switch(testoLetto) {
            case "cavo":
                System.out.println("- Connessione: cavo");
                break;
            case "rete":
                System.out.println("- Connessione: rete");
                System.out.println("- IP: " + ip);
                System.out.println("- Subnet: " + subnet);
                break;
        }
        System.out.println("- Fogli: " + fogli);
        System.out.println("- Cartuccia nera: " + nero + "%");
        System.out.println("- Cartuccia magenta: " + magenta + "%");
        System.out.println("- Cartuccia ciano: " + ciano + "%");
        System.out.println("- Cartuccia gialla: " + giallo + "%");
        System.out.println("-----------------------------------------------------------------------");
        
        ripeti = false;

        do { 
            System.out.print("Sei sicuro di voler aggiungere la stampante '" + nome + "'(S/n): ");
            testoLetto = InputManager.leggiRiga().toLowerCase();

            switch(testoLetto) {
                case "s":
                    System.out.println("LOG: Stampante aggiunta con successo!");
                    Stampante nuovaStampante = new Stampante(
                        ID, 
                        nome, 
                        marca, 
                        modello, 
                        "pronta", 
                        collegamento, 
                        ip, 
                        subnet, 
                        fogli, 
                        nero, 
                        magenta, 
                        ciano, 
                        giallo
                    );
                    stampanti.add(nuovaStampante);
                    break;
                case "n":
                    ID = 0;
                    nome = "";
                    marca = "";
                    modello = "";
                    collegamento = "";
                    ip = "";
                    subnet = "";
                    fogli = 0;
                    nero = 0;
                    magenta = 0;
                    ciano = 0;
                    giallo = 0;
                    System.out.println("LOG: Ok! Configurazione stampante eliminata!");
                    break;
                default:
                    System.out.println("LOG: Non ho capito!");
                    ripeti = true;
                    break;
            }
        } while (ripeti);
    }

    private void mostraStampanti() {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("-                              Stampanti                              -");
        System.out.println("-----------------------------------------------------------------------");
        if(stampanti.isEmpty()) {
            System.out.println("LOG: Nessuna stampante aggiunta!");
        }
        else {
            for(Stampante s : stampanti) {
                System.out.println("-   " + s.getNome());
                System.out.println("-       Marca: " + s.getMarca());
                System.out.println("-       Modello: " + s.getModello());
                if(s.getCollegamento().equals("cavo")) {
                    System.out.println("-       Collegamento: " + s.getCollegamento());
                } else if(s.getCollegamento().equals("rete")) {
                    System.out.println("-       Collegamento: " + s.getCollegamento());
                    System.out.println("-       IP: " + s.getIP());
                    System.out.println("-       Subnet mask: " + s.getSubnet());
                }
                System.out.println("-       Quantità di Carta: " + s.getCarta());
                System.out.println("-       Colori: ");
                System.out.println("-           Nero: " + s.getNero() + "%");
                System.out.println("-           Magenta: " + s.getMagenta() + "%");
                System.out.println("-           Ciano: " + s.getCiano() + "%");
                System.out.println("-           Giallo: " + s.getGiallo() + "%");
                System.out.println("-----------------------------------------------------------------------");
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        
        ripeti = false;
        
        do { 
            System.out.println("--------------------------------------------------");
            System.out.println("-                   Operazioni                   -");
            System.out.println("--------------------------------------------------");
            System.out.println("- 1) Seleziona una stampante                     -");
            System.out.println("- 2) Elimina stampante selezionata               -");
            System.out.println("- 3) Ricarica le cartucce della stampante        -");
            System.out.println("- 4) Rifornisci la carta alla stampante          -");
            System.out.println("- 5) Visualizzare coda di stampa                 -");
            System.out.println("- 6) Non voglio fare nulla al momento            -");
            System.out.println("--------------------------------------------------");
            System.out.print("Che operazione desidere eseguire(1-5): ");
            testoLetto = InputManager.leggiRiga();
            byte scelta = Byte.parseByte(testoLetto);

            switch(scelta) {
                case 1:
                    selezionaStampante();
                    break;
                case 2:
                    eliminaStampante();
                    break;
                case 3:
                    ricaricaCartucce();
                    break;
                case 4:
                    ricaricaCarta();
                    break;
                case 5:
                    visualizzaCodaDiStampa();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("LOG: Non ho capito!!");
                    ripeti = true;
                    break;
            }
        } while (ripeti);
    }

    private void selezionaStampante() {
        System.out.println("Inserire il nome della stampante su cui operare(es: pippo): ");
        testoLetto = InputManager.leggiRiga().toLowerCase();

        for(Stampante s : stampanti) {
            if(s.getNome().equalsIgnoreCase(testoLetto)) {
                this.stampanteSelezionata = s;
                System.out.println("Hai selezionato la stampante '" + testoLetto + "'!");
                return;
            }
        }
        System.out.println("ERRORE: Stampante non trovata;");
    }

    private void eliminaStampante() {
        if(this.stampanteSelezionata != null) {
            stampanti.remove(this.stampanteSelezionata);
            this.stampanteSelezionata = null;
            System.out.println("LOG: Stampante eliminata con successo!");
        }
        System.out.println("ERRORE: Nessuna stampante selezionata!");
    }

    private void visualizzaCodaDiStampa() {

    }

    private void ricaricaCartucce() {
        if(this.stampanteSelezionata != null) {
            ripeti = false;

            do {
                System.out.println("- Quanti fogli di carta vuoi inserire nella tua stampante(max 20): ");
                testoLetto = InputManager.leggiRiga();
                byte quantità = Byte.parseByte(testoLetto);
                if(quantità < 1) {
                    System.out.println("- LOG: Quantità di fogli indecente!!");
                    ripeti = true;
                }
                else if (quantità > 20) {
                    System.out.println("- LOG: Quantità di fogli esagerata!!");
                    ripeti = true;
                } else {
                    stampanteSelezionata.setCarta(quantità);
                    System.out.println("LOG: Stampante ricaricata con successo!");
                }
            } while (ripeti);
        }
        System.out.println("ERRORE: Nessuna stampante selezionata!");
    }

    private void ricaricaCarta() {
        if(this.stampanteSelezionata != null) {
            ripeti = false;

            do {
                System.out.println("- Quanti fogli di carta vuoi inserire nella tua stampante(max 20): ");
                testoLetto = InputManager.leggiRiga();
                byte quantità = Byte.parseByte(testoLetto);
                if(quantità < 1) {
                    System.out.println("- LOG: Quantità di fogli indecente!!");
                    ripeti = true;
                }
                else if (quantità > 20) {
                    System.out.println("- LOG: Quantità di fogli esagerata!!");
                    ripeti = true;
                } else {
                    stampanteSelezionata.setCarta(quantità);
                    System.out.println("LOG: Stampante ricaricata con successo!");
                }
            } while (ripeti);
        }
        System.out.println("ERRORE: Nessuna stampante selezionata!");
    }
}