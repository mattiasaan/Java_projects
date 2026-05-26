/**
 * Modello della calcolatrice GUI — logica di valutazione espressioni.
 * Applica il pattern MVC: questa classe è il "Model", separato dalla View (App).
 * Valuta espressioni semplici del tipo "a op b" (senza precedenza degli operatori).
 */
public class ModelloCalcolatrice {

  /**
   * Valuta un'espressione aritmetica semplice come stringa.
   * Supporta +, -, *, /. Non gestisce la precedenza degli operatori.
   *
   * @param espressione es. "3+5", "10/2", "7*3-1"
   * @return il risultato numerico, o 0 in caso di errore
   */
  public double risolviEspressione(String espressione) {
    try {
      String exp = espressione.replace(" ", "");
      // Split che mantiene gli operatori come token separati
      String[] numeri = exp.split("(?<=[-+*/])|(?=[-+*/])");
      if (numeri.length < 3) return Double.parseDouble(exp);

      double risultato = Double.parseDouble(numeri[0]);
      for (int i = 1; i < numeri.length; i += 2) {
        String op = numeri[i];
        double prossimo = Double.parseDouble(numeri[i + 1]);
        switch (op) {
          case "+": risultato += prossimo; break;
          case "-": risultato -= prossimo; break;
          case "*": risultato *= prossimo; break;
          case "/": if (prossimo != 0) risultato /= prossimo; break;
        }
      }
      return risultato;
    } catch (Exception e) {
      return 0;
    }
  }
}
