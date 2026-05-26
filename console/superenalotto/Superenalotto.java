import java.io.*;

/**
 * Esercizio: Simulazione Superenalotto
 *
 * Consegna: Simulare una giocata al Superenalotto semplificato. Il programma
 * genera 6 numeri vincenti casuali unici nell'intervallo 1–20, poi chiede
 * all'utente di inserire 6 numeri unici nello stesso intervallo. Alla fine
 * confronta i due set e mostra il punteggio (numero di indovinati).
 *
 * Requisiti: i numeri non devono essere duplicati né tra quelli generati, né
 * tra quelli inseriti dall'utente; validare l'input (range e duplicati).
 *
 * Concetti applicati: array, cicli annidati, controllo duplicati, 
 * generazione di numeri casuali senza ripetizione, confronto tra array.
 */
class Superenalotto {
  public static void main(String args[]) throws IOException {

    int[] numGiocati = new int[6];
    int[] numSorted = new int[6];   // numeri vincenti generati casualmente
    int max = 20;
    int min = 1;
    int range = max - min + 1;
    int punteggio = 0;

    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader tastiera = new BufferedReader(input);

    System.out.println("bella gianda");

    // Genera 6 numeri vincenti casuali unici tra 1 e 20
    for (int i = 0; i < numSorted.length; i++) {
      boolean numeroUscValido = false;
      while (!numeroUscValido) {
        int rand = (int)(Math.random() * range) + min;
        boolean duplicato = false;

        for (int h = 0; h < i; h++) {
          if (numSorted[h] == rand) {
            duplicato = true;
            break;
          }
        }

        if (!duplicato) {
          numSorted[i] = rand;
          numeroUscValido = true;
        }
      }
    }

    System.out.println("Benvenuto al Superenalotto dove ti rubiamo i soldi, prego inserisci 6 numeri.");

    // Raccoglie i 6 numeri dell'utente con validazione
    for (int i = 0; i < 6; i++) {
      boolean numeroValido = false;
      while (!numeroValido) {
        String numeroLetto = tastiera.readLine();
        int temp = Integer.valueOf(numeroLetto);

        if (temp < 1 || temp > 20) {
          System.out.println("Il numero deve essere tra 1 e 20 Riprova");
          continue;
        }

        // Controlla duplicati tra i numeri già inseriti dall'utente
        boolean duplicato = false;
        for (int h = 0; h < i; h++) {
          if (numGiocati[h] == temp) {
            duplicato = true;
            break;
          }
        }

        if (duplicato) {
          System.out.println("Numero già inserito riprova");
        } else {
          numGiocati[i] = temp;
          numeroValido = true;
        }
      }
    }

    // Confronto: conta quanti numeri dell'utente corrispondono ai vincenti
    for (int i = 0; i < 6; i++) {
      for (int y = 0; y < 6; y++) {
        if (numGiocati[i] == numSorted[y]) {
          punteggio++;
        }
      }
    }

    System.out.println("punteggio " + punteggio);
    System.out.println("i numeri furtunati erano: ");
    for (int i = 0; i < 6; i++) System.out.println(numSorted[i]);
    System.out.println("i tuoi numeri erano: ");
    for (int i = 0; i < 6; i++) System.out.println(numGiocati[i]);
  }
}
