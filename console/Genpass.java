import java.io.*;

/**
 * Esercizio: Generatore di Password Casuale
 *
 * Consegna: Creare un programma che generi una password casuale di lunghezza
 * scelta dall'utente (massimo 100 caratteri). I caratteri devono essere
 * scelti casualmente nell'intervallo ASCII stampabile (lettere maiuscole A-Z
 * e minuscole a-z, codici ASCII 65–122).
 *
 * Concetti applicati: array, cicli, casting tra int e char, input validato
 * con try-catch, Math.random().
 */
class Genpass {
  public static void main(String args[]) throws IOException {
    int lunghezza = 0;
    int[] numSorted = new int[100];
    int max = 122; // ASCII 'z'
    int min = 65;  // ASCII 'A'
    int range = max - min + 1;
    boolean f = false;

    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader tastiera = new BufferedReader(input);

    System.out.println("bella gianda");

    // Validazione input: lunghezza deve essere un intero tra 1 e 100
    while (f == false) {
      try {
        System.out.print("quanto lunga vuoi la password? (al massimo 100): ");
        String numeroLetto = tastiera.readLine();
        lunghezza = Integer.valueOf(numeroLetto);
        if (lunghezza > 100) {
          System.out.println("numero troppo alto");
          continue;
        }
        break;
      } catch (Exception e) {
        System.out.println("input non valido" + e.getMessage());
        System.out.println("generazione passwordd fallita!!");
        continue;
      }
    }

    // Genera 100 valori ASCII casuali nell'intervallo [65, 122]
    for (int i = 0; i < numSorted.length; i++) {
      int rand = (int)(Math.random() * range) + min;
      numSorted[i] = rand;
    }

    // Stampa solo i primi 'lunghezza' caratteri
    System.out.print("la password è: ");
    for (int i = 0; i < lunghezza; i++) {
      System.out.print((char) numSorted[i]);
    }
  }
}
