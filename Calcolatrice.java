import java.io.*;

public class Calcolatrice {
    protected InputStreamReader i = new InputStreamReader(System.in);
    protected BufferedReader tastiera = new BufferedReader(i);
    protected String testoLetto = "";
    protected String[] args = new String[3];
    protected double[] cronologia = new double[5];
    protected byte posizione = 0;
    protected String comando = "";
    protected String opzione = "";
    protected double num1 = 0.0;
    protected double num2 = 0.0;
    protected double ans = 0.0;


    public void app() {
        try {
            System.out.print("User/calc$ ");
            testoLetto = tastiera.readLine();
            if (testoLetto == null || testoLetto.trim().isEmpty()) {app(); return;}
            
            args = testoLetto.split(" ");
            comando = args[0].toLowerCase();
            opzione = (args.length >= 2) ? args[1].toLowerCase() : "";


            //help comands
            if (comando.equals("help") || comando.equals("?")) {
                help();
                return;
            }

            if (comando.equals("addiction") && opzione.equals("--help")) {
                System.out.println(" ");
                System.out.println("Sintassi: addiction [numero] [numero]");
                System.out.println("");
                System.out.println("Opzioni: non ci sono opzioni al momento.");
                app();
                return;
            }

            if (comando.equals("difference") && opzione.equals("--help")) {
                System.out.println(" ");
                System.out.println("Sintassi: difference [numero] [numero]");
                System.out.println("");
                System.out.println("Opzioni: non ci sono opzioni al momento.");
                app();
                return;
            }

            if (comando.equals("multiply") && opzione.equals("--help")) {
                System.out.println(" ");
                System.out.println("Sintassi: multiply [numero] [numero]");
                System.out.println("");
                System.out.println("Opzioni: non ci sono opzioni al momento.");
                app();
                return;
            }

            if (comando.equals("division") && opzione.equals("--help")) {
                System.out.println(" ");
                System.out.println("Sintassi: division [numero] [numero]");
                System.out.println("");
                System.out.println("Opzioni: non ci sono opzioni al momento.");
                app();
                return;
            }

            if (comando.equals("module") && opzione.equals("--help")) {
                System.out.println(" ");
                System.out.println("Sintassi: module [numero] [numero]");
                System.out.println("");
                System.out.println("Opzioni: non ci sono opzioni al momento.");
                app();
                return;
            }

            if (comando.equals("history")) {
                history();
                return;
            }

            if (comando.equals("back")) {
                return;
            }

            if(args.length < 3) {
                System.err.println("errore di sintassi, comando incompleto. Usa la seguente sintassi: [comando] [numero] [numero]");
                app();
                return;
            }

            try {
                if (args[1].equalsIgnoreCase("ans")) {
                    num1 = ans;
                } else {
                    num1 = Double.parseDouble(args[1]);
                }
                num2 = Double.parseDouble(args[2]);
            } catch (NumberFormatException e) {
                System.err.println("ERRORE: " + e.getMessage());
                app();
                return;
            }

            if (comando.equals("addiction")) {
                addiction(num1, num2);
            }
            else if (comando.equals("difference")) {
                difference(num1, num2);
            }
            else if (comando.equals("multiply")) {
                multiply(num1, num2);
            }
            else if (comando.equals("division")) {
                division(num1, num2);
            }
            else if (comando.equals("module")) {
                module(num1, num2);
            }
            else {
                System.err.println("ERROR: comando inesistente");
                app();
            }
            
        } catch(IOException e) {
            System.err.println("ERRORE: " + e.getMessage());
        }
    }

    protected void help() {
        System.out.println("ADDICTION     Permette di eseguire la somma tra due numeri");
        System.out.println("DIFFERENCE    Permette di eseguire la differenza tra due numeri");
        System.out.println("MULTIPLY      Permette di eseguire la moltiplicazione tra due numeri");
        System.out.println("DIVISION      Permette di eseguire la divisione tra due numeri");
        System.out.println("MODULE        Permette di eseguire il modulo tra due numeri");
        System.out.println("HISTORY       Permette di visualizzare la cronologia dei calcoli eseguiti");
        System.out.println("BACK          Torna indietro al menu");
        app();
        return;
    }

    private void addiction(double a, double b) {
        double somma = a + b;
        
        if (posizione < 5) {
            cronologia[posizione] = somma;
            posizione++;
        }
        else {
            posizione = 0;
            cronologia[posizione] = somma;
            posizione++;
        }

        System.out.println(somma);
        app();
        return;
    }
    private void difference(double a, double b) {
        double differenza = a - b;
        
        if (posizione < 5) {
            cronologia[posizione] = differenza;
            posizione++;
        }
        else {
            posizione = 0;
            cronologia[posizione] = differenza;
            posizione++;
        }

        System.out.println(differenza);
        app();
        return;
    }
    private void multiply(double a, double b) {
        double moltiplicazione = a * b;
        
        if (posizione < 5) {
            cronologia[posizione] = moltiplicazione;
            posizione++;
        }
        else {
            posizione = 0;
            cronologia[posizione] = moltiplicazione;
            posizione++;
        }

        System.out.println(moltiplicazione);
        app();
        return;
    }
    private void division(double a, double b) {
        double divisione = 0.0;

        if(b == 0) System.err.println("Divisione per zero");
        else {
            divisione = a / b;
            System.out.println(divisione);
        }
        
        if (posizione < 5) {
            cronologia[posizione] = divisione;
            posizione++;
        }
        else {
            posizione = 0;
            cronologia[posizione] = divisione;
            posizione++;
        }
        app();
        return;
    }
    private void module(double a, double b) {
        double module = a % b;
        
        if (posizione < 5) {
            cronologia[posizione] = module;
            posizione++;
        }
        else {
            posizione = 0;
            cronologia[posizione] = module;
            posizione++;
        }

        System.out.println(module);
        app();
        return;
    }

    private void history() {
        try {
            System.out.print("User/calc/history$ ");
            testoLetto = tastiera.readLine();
            if (testoLetto == null || testoLetto.trim().isEmpty()) {history();}

            String[] arguments = testoLetto.split(" ");
            comando = arguments[0].toLowerCase();
            opzione = (arguments.length >= 2) ? arguments[1].toLowerCase() : "";

            if (comando.equals("help") || comando.equals("?")) {
                System.out.println("SHOW     Mostra la cronologia delle ultime 5 espressioni eseguite dall'utente");
                System.out.println("ANS      Permette di prendere un risultato dalla cronologia come numero per una prossima espressione");
                System.out.println("FLUSH    Permette di prendere un risultato dalla cronologia come numero per una prossima espressione");
                System.out.println("ESC      torna indietro");
                history();
            }

            if(comando.equals("ans") && opzione.equals("--help")) {
                System.out.println("Sintassi: answ [opzione] [dato]");
                System.out.println("ans -s [risultato]");
                System.out.println("Opzioni:");
                System.out.println("-s     L'opzione set serve per impostare la variabile ans con uno dei risultati della cronologia");
                System.out.println("-r     L'opzione reset reimposta il valore di ans a 0");
                history();
            }

            if (comando.equals("flush")) {
                for(byte a = 0; a < 5; a++) {
                    cronologia[a] = 0.0;
                }
                history();
            }

            if (comando.equals("show")) {
                for(byte a = 0; a < 5; a++) {
                    if(cronologia[a] == 0.0) {
                        System.out.println("vuoto");
                    } else {
                        System.out.println(cronologia[a]);
                    }
                }
                history();
            }

            if (comando.equals("esc")) {
                app();
            }

            if (comando.equals("ans")) {
                if (opzione.equals("-r")) {
                    ans = 0;
                    System.out.println("ANS resettato.");
                    history();
                } else if (opzione.equals("-s") && arguments.length >= 3) {
                    try {
                        int pos = Integer.parseInt(arguments[2]);
                        ans = cronologia[pos];
                        System.out.println("ANS impostato a: " + ans);
                    } catch (Exception e) { System.err.println("Posizione non valida"); }
                    history();
                } else {
                    System.err.println("Sintassi: ans -s [pos] o ans -r");
                    history();
                }
                return;
            }

            else {
                System.err.println("ERROR: comando incompleto o inesistente");
                history();
            }
            
        } catch(IOException e) {
            System.err.println("ERRORE: " + e.getMessage());
        }

    }
}