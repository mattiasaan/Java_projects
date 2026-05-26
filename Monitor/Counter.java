/**
 * Esercizio: Monitor — Contatore Thread-Safe
 *
 * Consegna: Implementare strutture dati sincronizzate che possano essere
 * condivise tra più thread senza race condition. Questa classe mostra il
 * pattern "monitor" applicato a un semplice contatore: i metodi synchronized
 * garantiscono accesso atomico allo stato interno.
 *
 * Concetti applicati: synchronized, thread safety, pattern monitor.
 */
class Counter {
  private int count = 0;

  public synchronized void increment() {
    count++;
  }

  public synchronized int getCount() {
    return count;
  }
}
