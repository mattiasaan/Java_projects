import java.io.*;

/**
 * Classe Calc — Motore aritmetico della calcolatrice base
 *
 * Contiene i quattro metodi fondamentali di calcolo (addizione, sottrazione,
 * moltiplicazione, divisione). Viene istanziata e usata da MenuCalc.java.
 *
 * Concetti applicati: classi, metodi con parametri e valore di ritorno,
 * operatori aritmetici su float.
 */
class Calc {
  private float result;

  public float addizione(float num1, float num2) {
    result = num1 + num2;
    return result;
  }

  public float sottrazione(float num1, float num2) {
    result = num1 - num2;
    return result;
  }

  public float moltiplicazione(float num1, float num2) {
    result = num1 * num2;
    return result;
  }

  public float divisione(float num1, float num2) {
    result = num1 / num2;
    return result;
  }
}
