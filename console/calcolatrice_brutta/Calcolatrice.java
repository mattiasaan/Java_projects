import java.io.*;

/**
 * Calcolatrice standard — stile shell con comandi testuali
 *
 * Gestisce le operazioni aritmetiche di base (addiction, difference, multiply,
 * division, module) con sintassi tipo "addiction 5 3". Mantiene una cronologia
 * degli ultimi 5 risultati e supporta la variabile speciale "ans" per
 * riutilizzare l'ultimo risultato come operando.
 *
 * Nota: questa classe usa la ricorsione al posto del loop per gestire il
 * prompt, il che può causare StackOverflow su sessioni molto lunghe.
 *
 * Concetti applicati: array circolare per cronologia, parsing di argomenti
 * testuali (split), ereditarietà (estesa da CalcolatriceScientifica),
 * variabile "ans" come stato persistente.
 */
public class Calcolatrice {
  protected InputStreamReader i = new InputStreamReader(System.in);
  protected BufferedReader tastiera = new BufferedReader(i);
  protected String testoLetto = "";
  protected String[] args = new String[3];
  protected double[] cronologia = new double[5];
  protected byte posizione = 0;
  protected String comando = "";
  protected String opzione = "";
  protected double num1 = 0.0;
  protected double num2 = 0.0;
  protected double ans = 0.0;  // Variabile speciale: ultimo risultato usabile come operando

  public void app() {
    try {
      System.out.print("User/calc$ ");
      testoLetto = tastiera.readLine();
      if (testoLetto == null || testoLetto.trim().isEmpty()) { app(); return; }

      args = testoLetto.split(" ");
      comando = args[0].toLowerCase();
      opzione = (args.length >= 2) ? args[1].toLowerCase() : "";

      if (comando.equals("help") || comando.equals("?")) { help(); return; }

      // Comandi --help per singola operazione
      if (comando.equals("addiction") && opzione.equals("--help")) {
        System.out.println("\nSintassi: addiction [numero] [numero]\n");
        app(); return;
      }
      if (comando.equals("difference") && opzione.equals("--help")) {
        System.out.println("\nSintassi: difference [numero] [numero]\n");
        app(); return;
      }
      if (comando.equals("multiply") && opzione.equals("--help")) {
        System.out.println("\nSintassi: multiply [numero] [numero]\n");
        app(); return;
      }
      if (comando.equals("division") && opzione.equals("--help")) {
        System.out.println("\nSintassi: division [numero] [numero]\n");
        app(); return;
      }
      if (comando.equals("module") && opzione.equals("--help")) {
        System.out.println("\nSintassi: module [numero] [numero]\n");
        app(); return;
      }

      if (comando.equals("history")) { history(); return; }
      if (comando.equals("back")) { return; }

      if (args.length < 3) {
        System.err.println("errore di sintassi, comando incompleto. Usa la seguente sintassi: [comando] [numero] [numero]");
        app(); return;
      }

      try {
        // "ans" come primo operando usa il valore dell'ultimo risultato
        num1 = args[1].equalsIgnoreCase("ans") ? ans : Double.parseDouble(args[1]);
        num2 = Double.parseDouble(args[2]);
      } catch (NumberFormatException e) {
        System.err.println("ERRORE: " + e.getMessage());
        app(); return;
      }

      if (comando.equals("addiction"))       { addiction(num1, num2); }
      else if (comando.equals("difference")) { difference(num1, num2); }
      else if (comando.equals("multiply"))   { multiply(num1, num2); }
      else if (comando.equals("division"))   { division(num1, num2); }
      else if (comando.equals("module"))     { module(num1, num2); }
      else { System.err.println("ERROR: comando inesistente"); app(); }

    } catch (IOException e) {
      System.err.println("ERRORE: " + e.getMessage());
    }
  }

  protected void help() {
    System.out.println("ADDICTION     Permette di eseguire la somma tra due numeri");
    System.out.println("DIFFERENCE    Permette di eseguire la differenza tra due numeri");
    System.out.println("MULTIPLY      Permette di eseguire la moltiplicazione tra due numeri");
    System.out.println("DIVISION      Permette di eseguire la divisione tra due numeri");
    System.out.println("MODULE        Permette di eseguire il modulo tra due numeri");
    System.out.println("HISTORY       Permette di visualizzare la cronologia dei calcoli eseguiti");
    System.out.println("BACK          Torna indietro al menu");
    app();
  }

  // Salva il risultato nella cronologia circolare e aggiorna la posizione
  private void salvaInCronologia(double valore) {
    if (posizione < 5) {
      cronologia[posizione] = valore;
      posizione++;
    } else {
      posizione = 0;
      cronologia[posizione] = valore;
      posizione++;
    }
  }

  private void addiction(double a, double b) {
    double somma = a + b;
    salvaInCronologia(somma);
    System.out.println(somma);
    app();
  }

  private void difference(double a, double b) {
    double differenza = a - b;
    salvaInCronologia(differenza);
    System.out.println(differenza);
    app();
  }

  private void multiply(double a, double b) {
    double moltiplicazione = a * b;
    salvaInCronologia(moltiplicazione);
    System.out.println(moltiplicazione);
    app();
  }

  private void division(double a, double b) {
    double divisione = 0.0;
    if (b == 0) System.err.println("Divisione per zero");
    else { divisione = a / b; System.out.println(divisione); }
    salvaInCronologia(divisione);
    app();
  }

  private void module(double a, double b) {
    double mod = a % b;
    salvaInCronologia(mod);
    System.out.println(mod);
    app();
  }

  private void history() {
    try {
      System.out.print("User/calc/history$ ");
      testoLetto = tastiera.readLine();
      if (testoLetto == null || testoLetto.trim().isEmpty()) { history(); }

      String[] arguments = testoLetto.split(" ");
      comando = arguments[0].toLowerCase();
      opzione = (arguments.length >= 2) ? arguments[1].toLowerCase() : "";

      if (comando.equals("help") || comando.equals("?")) {
        System.out.println("SHOW     Mostra la cronologia delle ultime 5 espressioni eseguite dall'utente");
        System.out.println("ANS      Permette di prendere un risultato dalla cronologia come numero per una prossima espressione");
        System.out.println("FLUSH    Azzera la cronologia");
        System.out.println("ESC      torna indietro");
        history();
      }

      if (comando.equals("flush")) {
        for (byte a = 0; a < 5; a++) cronologia[a] = 0.0;
        history();
      }

      if (comando.equals("show")) {
        for (byte a = 0; a < 5; a++) {
          System.out.println(cronologia[a] == 0.0 ? "vuoto" : cronologia[a]);
        }
        history();
      }

      if (comando.equals("esc")) { app(); }

      if (comando.equals("ans")) {
        if (opzione.equals("-r")) {
          ans = 0;
          System.out.println("ANS resettato.");
          history();
        } else if (opzione.equals("-s") && arguments.length >= 3) {
          try {
            int pos = Integer.parseInt(arguments[2]);
            ans = cronologia[pos];
            System.out.println("ANS impostato a: " + ans);
          } catch (Exception e) { System.err.println("Posizione non valida"); }
          history();
        } else {
          System.err.println("Sintassi: ans -s [pos] o ans -r");
          history();
        }
        return;
      } else {
        System.err.println("ERROR: comando incompleto o inesistente");
        history();
      }

    } catch (IOException e) {
      System.err.println("ERRORE: " + e.getMessage());
    }
  }
}
