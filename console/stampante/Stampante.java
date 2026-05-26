/**
 * Esercizio: Simulazione Stampante (versione base)
 *
 * Consegna: Modellare una stampante con stato on/off, una coda di stampa e
 * una lista dei file già stampati. Creare i metodi per accendere/spegnere,
 * stampare documenti, mostrare la coda e i lavori completati.
 * Questa è la versione semplificata — vedere "coda di stampa" per la
 * versione più completa con OOP avanzata.
 *
 * Concetti applicati: classi, stato interno (campo privato), metodi pubblici
 * per modificare lo stato, incapsulamento base.
 */
public class Stampante {
  private int stato = 0; // 0 = spenta, 1 = accesa

  public void stampaDocumento() {
    System.out.println("che documento vuoi stampare??");
  }

  /** Alterna lo stato accesa/spenta. */
  public void stato() {
    if (stato == 0) {
      System.out.println("la stampante è spenta, si sta accendendo");
      stato = 1;
    } else {
      System.out.println("la stampante è accesa, si sta spegnendo");
      stato = 0;
    }
  }

  public int statoAttualeStampante() {
    return stato;
  }

  public void mostraCoda() {
    System.out.println("coda stamapnte:");
  }

  public void mostraStampati() {
    System.out.println("files già stampati");
  }
}
