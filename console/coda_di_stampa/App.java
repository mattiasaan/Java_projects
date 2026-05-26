import Apps.ProgStampante;

/**
 * Punto d'ingresso del sistema di gestione stampanti.
 * Avvia il menu principale di ProgStampante.
 */
public class App {
  public static void main(String[] args) {
    ProgStampante prog = new ProgStampante();
    prog.menu();
  }
}
