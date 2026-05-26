import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Esercizio: Calcolatrice con Ereditarietà e Menu Separati (versione sigma)
 *
 * Consegna: Progettare una calcolatrice OOP con ereditarietà, dove la classe
 * base Calcolatrice gestisce le operazioni standard (addizione, sottrazione,
 * moltiplicazione, divisione, cronologia) e la classe derivata
 * CalcolatriceScientifica aggiunge potenza e radice quadrata (metodo
 * babilonese). Il menu principale chiede prima il tipo di calcolatrice,
 * poi l'operazione, e infine l'esegue.
 *
 * Requisiti: applicare correttamente l'ereditarietà, il polimorfismo
 * (@Override sul menu), la visibilità protected per i membri condivisi,
 * e separare la logica di presentazione dalla logica di calcolo.
 *
 * Concetti applicati: classi e oggetti, ereditarietà, @Override,
 * protected vs private, do-while, metodi con stato (cronologia),
 * accesso tastiera condiviso tramite campo protected.
 */
public class AppCalcolatrice {

  public static void main(String[] args) {
    final InputStreamReader input = new InputStreamReader(System.in);
    final BufferedReader tastiera = new BufferedReader(input);
    Calcolatrice calc = new Calcolatrice();
    CalcolatriceScientifica calcScientifica = new CalcolatriceScientifica();

    int negro = 0;
    do {
      String valoreLetto;
      int scelta = 0;
      int operazione = 0;

      System.out.print("menu principale calcolatrice: \n 1)calcolatrice normale. \n 2)calcolatrice scentifica. \n ctrl + c per uscire. \n cosa scegli: ");
      try {
        valoreLetto = tastiera.readLine();
        scelta = Integer.parseInt(valoreLetto);
      } catch (Exception e) {
        System.out.println("errore");
      }

      // Mostra il menu specifico del tipo scelto e ottiene l'operazione
      if (scelta == 1) {
        operazione = calc.menu();
      } else if (scelta == 2) {
        operazione = calcScientifica.menu();
      } else {
        System.out.println("errore");
      }

      // Dispatch verso il metodo corretto in base all'operazione scelta
      switch (operazione) {
        case 1: calc.addizione(); break;
        case 2: calc.sottrazione(); break;
        case 3: calc.moltiplicazione(); break;
        case 4: calc.divisione(); break;
        case 5: calc.mostraCronologia(); break;
        case 6: calcScientifica.potenza(); break;
        case 7: calcScientifica.radq(); break;
        default: break;
      }
    } while (negro != 1);
  }
}
