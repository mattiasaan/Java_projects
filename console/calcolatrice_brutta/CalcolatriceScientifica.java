import java.io.*;

/**
 * Calcolatrice Scientifica — estende Calcolatrice con potenza e radice
 *
 * Aggiunge i comandi "pow" (potenza, calcolata manualmente con ciclo) e
 * "sqrt" (radice quadrata tramite metodo babilonese) alla calcolatrice base.
 * Ridefinisce app() e help() con @Override per adattarli al contesto
 * scientifico.
 *
 * Concetti applicati: ereditarietà (extends Calcolatrice), @Override,
 * polimorfismo, metodo babilonese integrato, riuso del modulo history().
 */
public class CalcolatriceScientifica extends Calcolatrice {
  private String[] argomenti = new String[4];

  @Override
  public void app() {
    try {
      System.out.print("User/scalc$ ");
      testoLetto = tastiera.readLine();

      if (testoLetto == null || testoLetto.trim().isEmpty()) { app(); return; }

      argomenti = testoLetto.split(" ");
      comando = argomenti[0].toLowerCase();
      opzione = (argomenti.length >= 2) ? argomenti[1].toLowerCase() : "";

      if (comando.equals("help") || comando.equals("?")) { help(); return; }
      if (comando.equals("history")) { history(); return; }

      if (comando.equals("pow") && opzione.equals("--help")) {
        System.out.println("\nSintassi: pow [base] [esponente]\n");
        app(); return;
      }
      if (comando.equals("sqrt") && opzione.equals("--help")) {
        System.out.println("\nSintassi: sqrt [radicando] [soglia di accettazione]\n");
        app(); return;
      }
      if (comando.equals("back")) { return; }

      if (comando.equals("pow")) {
        if (argomenti.length < 3) {
          System.err.println("errore di sintassi comando incompleto");
          app();
        } else {
          double base = argomenti[1].equalsIgnoreCase("ans") ? ans : Double.parseDouble(argomenti[1]);
          double esponente = Double.parseDouble(argomenti[2]);
          potenza(base, esponente);
        }
      }

      if (comando.equals("sqrt")) {
        if (argomenti.length < 3) {
          System.err.println("errore di sintassi comando incompleto");
          app();
        } else {
          double radicando = argomenti[1].equalsIgnoreCase("ans") ? ans : Double.parseDouble(argomenti[1]);
          double sogliaAccettazione = Double.parseDouble(argomenti[3]);
          radiceBabilonese(radicando, sogliaAccettazione);
        }
      }

    } catch (IOException e) {
      System.err.println("ERRORE: " + e.getMessage());
    }
  }

  @Override
  protected void help() {
    System.out.println("POW           Permette di eseguire una potenza");
    System.out.println("SQRT          Permette di risolvere una radice quadrata, sfruttando il metodo babilonese");
    System.out.println("HISTORY       Permette di visualizzare la cronologia dei calcoli eseguiti");
    System.out.println("BACK          Torna indietro al menu");
    app();
  }

  // Nota: history() è definito privato in Calcolatrice — qui viene ridefinito
  // come metodo locale (non è un override, è un nuovo metodo privato)
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
          ans = 0; System.out.println("ANS resettato."); history();
        } else if (opzione.equals("-s") && arguments.length >= 3) {
          try {
            int pos = Integer.parseInt(arguments[2]);
            ans = cronologia[pos];
            System.out.println("ANS impostato a: " + ans);
          } catch (Exception e) { System.err.println("Posizione non valida"); }
          history();
        } else {
          System.err.println("Sintassi: ans -s [pos] o ans -r"); history();
        }
        return;
      } else {
        System.err.println("ERROR: comando incompleto o inesistente"); history();
      }

    } catch (IOException e) {
      System.err.println("ERRORE: " + e.getMessage());
    }
  }

  /**
   * Calcola a^b con un ciclo (senza Math.pow), per mostrare il funzionamento
   * dell'elevamento a potenza in modo esplicito.
   */
  private void potenza(double a, double b) {
    double risultato = a;
    for (byte y = 0; y < b - 1; y++) risultato *= a;
    System.out.println(risultato);

    if (posizione < 5) { cronologia[posizione] = risultato; posizione++; }
    else { posizione = 0; cronologia[posizione] = risultato; posizione++; }
    app();
  }

  /** Metodo babilonese per la radice quadrata (stesso algoritmo di Babilonese.java). */
  private void radiceBabilonese(double a, double b) {
    double confronto = 0.0;
    double iterazione = 0.0;
    byte contatore = 0;
    double secondaIterazione = 0.0;

    do {
      iterazione = a / 2;
      secondaIterazione = (0.5f) * (iterazione + (a / iterazione));
      confronto = Math.abs(secondaIterazione - iterazione);
      System.out.println("calcolo: " + secondaIterazione + " || ciclo n: " + contatore);
      contatore++;
      iterazione = secondaIterazione;
    } while (confronto > b);

    System.out.println("risultato: " + secondaIterazione + " soglia: " + confronto);

    if (posizione < 5) { cronologia[posizione] = secondaIterazione; posizione++; }
    else { posizione = 0; cronologia[posizione] = secondaIterazione; posizione++; }
    app();
  }
}
