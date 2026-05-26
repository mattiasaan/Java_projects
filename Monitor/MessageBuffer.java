/**
 * Esercizio: Monitor — Buffer Produttore/Consumatore
 *
 * Consegna: Implementare un buffer di capacità 1 per la comunicazione tra
 * un thread produttore e uno consumatore. Il produttore aspetta se il buffer
 * è pieno; il consumatore aspetta se è vuoto. Usare wait()/notifyAll() per
 * coordinare i thread senza busy-waiting.
 *
 * Concetti applicati: synchronized, wait(), notifyAll(), pattern
 * produttore-consumatore, stato booleano come semaforo.
 */
class MessageBuffer {
  private String message;
  private boolean empty = true;

  /** Inserisce un messaggio nel buffer; attende se è già pieno. */
  public synchronized void put(String msg) {
    while (!empty) {
      try { wait(); } catch (InterruptedException e) {}
    }
    empty = false;
    this.message = msg;
    notifyAll();
  }

  /** Preleva il messaggio dal buffer; attende se è vuoto. */
  public synchronized String take() {
    while (empty) {
      try { wait(); } catch (InterruptedException e) {}
    }
    empty = true;
    notifyAll();
    return message;
  }
}
