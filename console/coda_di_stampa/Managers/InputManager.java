package Managers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Utility per la lettura da standard input.
 *
 * Centralizza la gestione del BufferedReader in un metodo statico,
 * evitando di creare un nuovo reader in ogni classe che ne ha bisogno.
 * Gli errori di I/O vengono loggati e restituisce una stringa vuota
 * invece di propagare l'eccezione.
 */
public class InputManager {
  private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public static String leggiRiga() {
    try {
      return reader.readLine();
    } catch (IOException e) {
      System.err.println("ERRORE: " + e.getMessage());
      return "";
    }
  }
}
