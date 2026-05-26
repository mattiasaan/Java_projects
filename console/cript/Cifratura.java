import java.io.*;

/**
 * Esercizio: Cifratura con Cifrario di Cesare
 *
 * Consegna: Implementare il cifrario di Cesare con uno shift di +3 posizioni
 * nel codice ASCII. Il programma legge una stringa in chiaro dall'utente,
 * converte ogni carattere nel suo valore ASCII, aggiunge 3, e riconverte
 * in carattere per ottenere il testo cifrato.
 *
 * Concetti applicati: array di char, casting char↔int, manipolazione ASCII,
 * ciclo for, concatenazione di stringhe.
 */
class Cifratura {
  public static void main(String args[]) throws IOException {
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader tastiera = new BufferedReader(input);

    String text;
    String criptedText = "";

    System.out.println("bella gianda \n dammi un testo da cifrare");
    text = tastiera.readLine();

    char[] charText = text.toCharArray();
    int[] asciiText = new int[charText.length];
    int[] criptedAsciiText = new int[charText.length];

    System.out.println(charText.length + "----" + asciiText.length + "----" + criptedAsciiText.length);

    // Per ogni carattere: leggi ASCII, aggiungi 3 (shift di Cesare), converti in char
    for (int i = 0; i < charText.length; i++) {
      asciiText[i] = ((int) charText[i]);
      System.out.println(asciiText[i]);
      criptedAsciiText[i] = asciiText[i] + 3;
      System.out.println((char) criptedAsciiText[i]);
      criptedText += (char) criptedAsciiText[i];
    }

    System.out.println("Il testo cifrato è: " + criptedText);
  }
}
