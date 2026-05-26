import java.io.*;

/**
 * Esercizio: Radice Quadrata con Metodo Babilonese
 *
 * Consegna: Implementare il metodo babilonese (o metodo di Newton-Raphson) per
 * calcolare la radice quadrata di un numero senza usare Math.sqrt().
 * L'utente inserisce il numero e una soglia di accuratezza; il programma
 * itera fino a quando la differenza tra due approssimazioni successive è
 * inferiore alla soglia scelta.
 *
 * Concetti applicati: ciclo do-while, input da tastiera, variabili float,
 * metodo iterativo di approssimazione numerica.
 */
class Babilonese {
  public static void main(String[] args) throws IOException {
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader tastiera = new BufferedReader(input);

    String numeroLetto;
    float rad, accuracy, theshold, numInit, numSec;
    int counter = 0;
    
    System.out.println("bella gianda");
    System.out.println("dammi un numero a cui fare la radice");
    numeroLetto = tastiera.readLine();
    numeroLetto = numeroLetto.replace(',', '.');
    rad = Float.parseFloat(numeroLetto.trim());

    System.out.println("dammi l'accuracy tra 0.1 e 0.0000001");
    numeroLetto = tastiera.readLine();
    numeroLetto = numeroLetto.replace(',', '.');
    accuracy = Float.parseFloat(numeroLetto.trim());

    // Stima iniziale: metà del numero
    numInit = rad / 2;

    // Formula babilonese: x_n+1 = 0.5 * (x_n + rad / x_n)
    do {
      numSec = (0.5f) * (numInit + (rad / numInit));
      theshold = Math.abs(numSec - numInit);
      System.out.println("calcolo: " + numSec + " || ciclo n: " + counter);
      counter++;
      numInit = numSec;
    } while (accuracy < theshold);

    System.out.println("risultato: " + numSec + " soglia: " + theshold);
  }
}
