import java.io.*;

public class ProgStampante {
  public static void main(String args[]) throws IOException {
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader tastiera = new BufferedReader(input);

    int opzione = 0;
		String numeroLetto;
    int exit = 0;
    int statoStampante = 0;

    Documento doc = new Documento();
    Stampante stampante = new Stampante();

    statoStampante = stampante.statoAttualeStampante();

    if (statoStampante == 0) {
      System.out.println("la stamapnte attualemente è spenta");
    } else {
      System.out.println("la stamapnte attualemente è accesa");
    }


    

    System.out.print("menu stampante:\n 1. Crea documento\n 2. Stampa documento\n 3. Accendi / Spegni stampante\n 4. Mostra coda di stampa\n 5. Mostra lavori gia stampati\n 6. Esci\n Cosa scegli????????\n ->");

    do{
    try {
      numeroLetto = tastiera.readLine();
      opzione = Integer.parseInt(numeroLetto.trim());
      exit = 1;
    } catch (Exception e) {
      System.out.println("Input non valido: " + e.getMessage());
      continue;
    }

    if(opzione == 6) {
      System.out.println("addio");
      System.exit(0);
      break;

    }
    }while(exit != 1);
    System.out.println(opzione);

    switch (opzione) {
      case 1:
        doc.inserisciDocumento();
        break;
      case 2:
        stampante.stampaDocumento();
        break;
      case 3:
        stampante.stato();
        break;
      case 4:
        stampante.mostraCoda();
        break;
      case 5:
        stampante.mostraStampati();
        break;
      default:
        System.exit(0);
        break;
    }








  }

}
