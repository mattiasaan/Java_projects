import java.io.*;

/**
 * Esercizio: Calcolatrice CLI stile terminale — App principale (Mr. Math)
 *
 * Consegna: Creare un'applicazione a riga di comando che simuli un mini-shell
 * con comandi testuali (tipo "calc", "scalc", "exit"). L'utente digita comandi
 * invece di numeri di menu. Il programma deve distinguere tra la calcolatrice
 * standard (calc) e quella scientifica (scalc) e instradare i comandi.
 *
 * Concetti applicati: composizione di oggetti, input testuale, confronto
 * stringhe, architettura a livelli (app principale → sotto-app), ricorsione
 * per il loop del prompt.
 */
public class AppCalcolatrice {
  protected Calcolatrice calcolatrice;
  protected CalcolatriceScientifica clacs;
  private InputStreamReader i = new InputStreamReader(System.in);
  protected BufferedReader tastiera = new BufferedReader(i);
  protected String testoLetto = "";
  public String userName = "User";

  public static void main(String[] args) {
    AppCalcolatrice n = new AppCalcolatrice();
    n.calcolatrice = new Calcolatrice();
    n.clacs = new CalcolatriceScientifica();
    n.start();
  }

  private void start() {
    System.out.println("Mr. Math 1.0 LTS");
    System.out.println("Mr. Math ti da il benvenuto, quando te la senti scrivi 'help' o '?' per scoprire i comandi");
    System.out.println("");
    app();
  }

  public void app() {
    try {
      System.out.print("User$ ");
      testoLetto = tastiera.readLine().toLowerCase();

      if (testoLetto == null || testoLetto.trim().isEmpty()) {
        app();
      }

      if (testoLetto.equals("help")) {
        help();
      } else if (testoLetto.equals("?")) {
        help();
      } else if (testoLetto.equals("calc")) {
        calcolatrice.app();
        app();
      } else if (testoLetto.equals("scalc")) {
        clacs.app();
        app();
      } else if (testoLetto.equals("exit")) {
        System.exit(0);
      } else {
        System.err.println("ERRORE: '" + testoLetto + "' comando sbagliato o inesistente");
        app();
      }
    } catch (IOException e) {
      System.err.println("ERRORE: " + e.getMessage());
    }
  }

  protected void help() {
    System.out.println("CALC    Apre una sessione della calcolatrice, con la quale si possono eseguire");
    System.out.println("        i seguenti calcoli(+, -, *, / e %)");
    System.out.println("SCALC   Apre una sessione della calcolatrice scientifica, con la quale si possono eseguire");
    System.out.println("        i seguenti calcoli(pow e sqrt)");
    System.out.println("EXIT    Esce dal programma");
    app();
  }
}
