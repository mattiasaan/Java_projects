import java.io.*;

/**
 * Esercizio: Calcolo della Media (versione con variabili separate)
 *
 * Consegna: Leggere l'età di tre persone e calcolarne la media aritmetica.
 * Questa versione usa tre variabili distinte per le età.
 * Versione alternativa con array: vedere media_arr.java.
 *
 * Concetti applicati: input da tastiera, variabili float, gestione eccezioni,
 * operatori aritmetici di base.
 */
class Media {
  public static void main(String args[]) {
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader tastiera = new BufferedReader(input);

    float eta1, eta2, eta3;
    float media;

    System.out.println("persona1");
    System.out.print("età: ");
    try {
      String numeroLetto = tastiera.readLine();
      eta1 = Integer.valueOf(numeroLetto).intValue();
    } catch (Exception e) {
      System.out.println("\n numero sbagliato ");
      return;
    }

    System.out.println("persona2");
    System.out.print("età: ");
    try {
      String numeroLetto = tastiera.readLine();
      eta2 = Integer.valueOf(numeroLetto).intValue();
    } catch (Exception e) {
      System.out.println("\n numero sbagliato ");
      return;
    }

    System.out.println("persona3");
    System.out.print("età: ");
    try {
      String numeroLetto = tastiera.readLine();
      eta3 = Integer.valueOf(numeroLetto).intValue();
    } catch (Exception e) {
      System.out.println("\n numero sbagliato ");
      return;
    }

    media = (eta1 + eta2 + eta3) / 3;
    System.out.println("\n età media: " + media);
  }
}
