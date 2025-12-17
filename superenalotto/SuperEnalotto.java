import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;

public class SuperEnalotto {
    public static void main(String[] args) {
        boolean ripeti = true;

        while(ripeti) {
            try {byte
                InputStreamReader input = new InputStreamReader(System.in);
                BufferedReader o = new BufferedReader(input);

                byte[] numeriUtente = new byte[6];
                byte[] numeriVincita = new byte[6];
                byte numeriVincitoriContati = 0;
                String montepremio = "";

                System.out.println("Benvenuto al super enalotto!!");
                System.out.print("Configura la tua scheda:");
                System.out.print("Inserisci 6 numeri interi compresi tra 1 e 20: ");

                for(byte i = 0; i < 6; i++) {
                    String numeroLetto = o.readLine();
                    numeriUtente[i] = Byte.valueOf(numeroLetto).byteValue();
                }

                System.out.print("Sto ricevendo i tuoi numeri");
                for(byte i = 0; i < 3; i++) {
                    System.out.print(".");
                    Thread.sleep(300);
                }

                System.out.print("Sto cercando i numeri vincitori di oggi");
                for(byte i = 0; i < 3; i++) {
                    System.out.print(".");
                    Thread.sleep(300);
                }

                for(byte i = 0; i < 6; i++) {
                    numeriVincita[i] = (byte)(Math.random() * 20);

                    if(numeriVincita[i] == numeriVincita[i]){
                        numeriVincita[i] = (byte)(Math.random() * 20);
                    }
                    else {
                        System.out.println("Errore: c'è stato un errore nel sistema!!");
                    }
                }

                System.out.println("I numeri di oggi sono:");
                Thread.sleep(3000);

                for(byte i = 0; i < 6; i++) {
                    System.out.println("Rullo di tamburi");
                    for(byte a = 0; a < 3; a++) {
                        System.out.print(".");
                        Thread.sleep(300);
                    }
                    Thread.sleep(3000);
                    System.out.println(numeriVincita[i]);
                }

                Thread.sleep(3000);
                System.out.println("I tuoi numeri sono:");
                Thread.sleep(3000);

                for(byte i = 0; i < 6; i++) {
                    System.out.println("Rullo di tamburi...");
                    Thread.sleep(3000);
                    System.out.println(numeriUtente[i]);
                }

                for(byte i = 0; i < 6; i++) {
                    if(numeriUtente[i] == numeriVincita[i]) {
                        numeriVincitoriContati++;
                    }
                    else {
                        System.out.println("Errore: non sono riuscito a valutare...");
                    }
                }

                System.out.print("Hai azzeccato ");
                Thread.sleep(3000);
                System.out.print(numeriVincitoriContati);

                System.out.print("Sto contando le tue risposte e comparandole con la tabella del montepremio");
                for(byte i = 0; i < 3; i++) {
                    System.out.println(".");
                    Thread.sleep(300);
                }

                if(numeriVincitoriContati == 0) {
                    montepremio = "Nulla";
                }
                else if(numeriVincitoriContati == 1) {
                    montepremio = "500000$";
                }
                else if(numeriVincitoriContati == 2) {
                    montepremio = "1000000$";
                }
                else if(numeriVincitoriContati == 3) {
                    montepremio = "5000000$";
                }
                else if(numeriVincitoriContati == 4) {
                    montepremio = "10000000$";
                }
                else if(numeriVincitoriContati == 5) {
                    montepremio = "15000000$";
                }
                else if(numeriVincitoriContati == 6) {
                    montepremio = "20000000$";
                }
                else {
                    System.out.println("Non ho trovato un montepremio valido...");
                }

                System.out.print("E quindi hai vinto: ");
                Thread.sleep(3000);
                System.out.print(montepremio);

                System.out.print("Vuoi giocare dinuvo(s/n): ");
                String risposta = o.readLine();
                if(risposta.equals("s")) {
                    System.out.println("No perchè vuoi rovinarti giocando ancora???");
                }
                if(risposta.equals("n")) {
                    ripeti = false;
                    System.out.println("Arrivederci e alla prossima!!");
                    System.exit(0);
                }
                else {
                    System.out.println("Non ho capito...");
                    System.exit(1);
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
