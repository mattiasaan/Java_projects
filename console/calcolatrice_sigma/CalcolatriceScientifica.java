import java.lang.Math;

/**
 * Calcolatrice Scientifica — estende Calcolatrice con potenza e radice quadrata
 *
 * Aggiunge potenza (con Math.pow) e radice quadrata (metodo babilonese).
 * Il metodo menu() è sovrascritto con @Override per includere le opzioni
 * extra (6 e 7). Il metodo inserimento() è ridefinito (non è @Override perché
 * quello originale è private) per richiedere base ed esponente invece di a e b.
 *
 * Nota didattica: il commento sul campo tastiera spiega perché è protected
 * nella superclasse — per permettere l'accesso qui senza ripetere il codice.
 *
 * Concetti applicati: @Override, metodo privato ridefinito (non override),
 * Math.pow(), metodo babilonese, accesso a campi protected ereditati.
 */
class CalcolatriceScientifica extends Calcolatrice {

  private double base, exp, radicando;

  public CalcolatriceScientifica() {
    base = 0;
    exp = 0;
    radicando = 0;
  }

  /** Menu esteso che include potenza (6) e radice quadrata (7). */
  @Override
  public int menu() {
    boolean errore;
    String valoreLetto;
    int scelta = 0;

    System.out.println("\n********** MENU' OPERAZIONI (calcolatrice SCIENTIFICA) **********\n");
    System.out.println("1) Addizione");
    System.out.println("2) Sottrazione");
    System.out.println("3) Moltiplicazione");
    System.out.println("4) Divisione");
    System.out.println("5) Mostra cronologia risultati");
    System.out.println("6) Elevamento a potenza");
    System.out.println("7) Radice quadrata (con metodo babilonese)");

    do {
      errore = false;
      try {
        System.out.print("\nRISPOSTA: ");
        valoreLetto = tastiera.readLine();
        scelta = Integer.parseInt(valoreLetto);
        if (scelta < 1 || scelta > 7) {
          System.out.println("\nLa risposta inserita NON è valida. Riprovare.");
          errore = true;
        }
      } catch (Exception e) {
        System.out.println("\nLa risposta inserita NON è valida. Riprovare.");
        errore = true;
      }
    } while (errore == true);

    return scelta;
  }

  // Non è @Override: inserimento() è private in Calcolatrice, quindi non viene
  // ereditato. Questo è un metodo nuovo con lo stesso nome, specifico per la
  // calcolatrice scientifica (legge base ed esponente).
  private void inserimento() {
    boolean errore;
    String valoreLetto;

    do {
      errore = false;
      try {
        System.out.print("Inserisci la base: ");
        valoreLetto = tastiera.readLine();
        base = Double.parseDouble(valoreLetto);
      } catch (Exception e) {
        System.out.println("ERRORE: " + e.getMessage());
        errore = true;
      }
    } while (errore == true);

    do {
      errore = false;
      try {
        System.out.print("esponente: ");
        valoreLetto = tastiera.readLine();
        exp = Double.parseDouble(valoreLetto);
      } catch (Exception e) {
        System.out.println("ERRORE: " + e.getMessage());
        errore = true;
      }
    } while (errore == true);
  }

  /** Metodo babilonese: itera fino a quando la variazione è sotto la soglia di accuratezza. */
  private double radiceBabilonese(double rad, double accuracy) {
    double numInit = rad / 2;
    double numSec;
    double threshold;
    int counter = 0;

    do {
      numSec = 0.5 * (numInit + (rad / numInit));
      threshold = Math.abs(numSec - numInit);
      System.out.println("calcolo: " + numSec + " || ciclo n: " + counter);
      counter++;
      numInit = numSec;
    } while (threshold > accuracy);

    return numSec;
  }

  public void potenza() {
    System.out.println("\nHai selezionato: POTENZA\n");
    inserimento();
    System.out.print(Math.pow(base, exp));
  }

  public void radq() {
    System.out.println("\nHai selezionato: RADICE QUADRATA (metodo babilonese)\n");

    boolean errore;
    String valoreLetto;
    double accuracy = 0;

    do {
      errore = false;
      try {
        System.out.print("Inserisci numero: ");
        valoreLetto = tastiera.readLine();
        valoreLetto = valoreLetto.replace(',', '.');
        base = Double.parseDouble(valoreLetto);
      } catch (Exception e) {
        System.out.println("ERRORE: valore non valido");
        errore = true;
      }
    } while (errore);

    do {
      errore = false;
      try {
        System.out.print("Inserisci accuracy (es. 0.00001): ");
        valoreLetto = tastiera.readLine();
        valoreLetto = valoreLetto.replace(',', '.');
        accuracy = Double.parseDouble(valoreLetto);
      } catch (Exception e) {
        System.out.println("ERRORE: valore non valido");
        errore = true;
      }
    } while (errore);

    double risultato = radiceBabilonese(base, accuracy);
    System.out.println("\nRISULTATO RADICE = " + risultato);
  }

  /** Overloading: versione di addizione che accetta i parametri direttamente. */
  public void addizione(double num1, double num2) {
    System.out.println("\nHai selezionato: ADDIZIONE (metodo esclusivo di Calcolatrice Scientifica)\n");
    System.out.println("SOMMA = " + (num1 + num2));
  }
}
