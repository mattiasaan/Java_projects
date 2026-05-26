/**
 * Esercizio: Monitor — Pool di Risorse
 *
 * Consegna: Implementare un pool di risorse condivise tra thread. Un thread
 * che vuole usare una risorsa chiama acquire() — se non ce ne sono disponibili
 * aspetta. Quando ha finito chiama release() per renderla disponibile ad altri.
 * Modella situazioni reali come pool di connessioni DB o slot di stampa.
 *
 * Concetti applicati: synchronized, wait(), notifyAll(), semaforo contatore.
 */
class ResourcePool {
  private int availableResources;

  public ResourcePool(int total) {
    this.availableResources = total;
  }

  /** Acquisisce una risorsa; attende finché non ce n'è una disponibile. */
  public synchronized void acquire() {
    while (availableResources <= 0) {
      try { wait(); } catch (InterruptedException e) {}
    }
    availableResources--;
  }

  /** Rilascia una risorsa e notifica eventuali thread in attesa. */
  public synchronized void release() {
    availableResources++;
    notifyAll();
  }
}
