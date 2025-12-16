import java.io.*;

class Babilonese {
  public static void main(String args[]) throws IOException {
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

    numInit = rad/2;

    do {
      numSec =  (0.5f) * (numInit + (rad / numInit));
      theshold = Math.abs(numSec - numInit);
      System.out.println("calcolo: " + numSec + " || ciclo n: " + counter);
      counter++;
      numInit = numSec;
    } while (accuracy < theshold);
    System.out.println("risultato: "+ numSec + " soglia: " + theshold);
  }
}