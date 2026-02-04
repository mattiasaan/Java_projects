
import java.lang.Math;
class CalcolatriceScientifica extends Calcolatrice {

	private double base, exp, radicando;

	public CalcolatriceScientifica() {
		
		base = 0;
		exp = 0;
		radicando = 0;
	}

	@Override
	public int menu() {
		boolean errore;
		String valoreLetto;

		int scelta = 0;
		System.out.println("\n********** MENU' OPERAZIONI (calcolatrice SCIENTIFICA) **********\n");
		System.out.println("Scegli l'operazione che vuoi eseguire:\n");
		System.out.println("1) Addizione");
		System.out.println("2) Sottrazione");
		System.out.println("3) Moltiplicazione");
		System.out.println("4) Divisione");
		System.out.println("5) Mostra cronologia risultati");
		System.out.println("6) Elevamento a potenza");
		System.out.println("7) Radice quadrata (con metodo babilonese)");

		do {
			errore = false;
			try {
				System.out.print("\nRISPOSTA: ");
				valoreLetto = tastiera.readLine();
				scelta = Integer.parseInt(valoreLetto);

				if(scelta < 1 || scelta > 7) {
					System.out.println("\nLa risposta inserita NON è valida. Riprovare.");
					errore = true;
				}
			}
			catch(Exception e) {
				System.out.println("\nLa risposta inserita NON è valida. Riprovare.");
				errore = true;
			}
		}
		while(errore == true);

		return scelta;

		// tastiera.readLine() --> NON posso usarlo perché è dichiarato private nella classe Calcolatrice. Devo renderlo protected!
	}

	// NON c'è bisogno di @Override perchè inserimento() è private nella classe Calcolatrice, quindi NON
	// viene ereditato dalla superclasse (nessun overriding).
	private void inserimento() {

		System.out.println("***** Metodo inserimento() della Calcolatrice SCIENTIFICA *****");

		boolean errore;
		String valoreLetto;

		do {
			errore = false;
			try {
				System.out.print("Inserisci la base: ");
				valoreLetto = tastiera.readLine();
				base = Double.parseDouble(valoreLetto);
			}
			catch(Exception e) {
				
				System.out.println("ERRORE: " + e.getMessage());
				errore = true;
			}
		}
		while(errore == true);

		do {
			errore = false;
			try {
				System.out.print("esponente: ");
				valoreLetto = tastiera.readLine();
				exp = Double.parseDouble(valoreLetto);
			}
			catch(Exception e) {
				
				System.out.println("ERRORE: " + e.getMessage());
				errore = true;
			}
		}
		while(errore == true);

	}

	private double radiceBabilonese(double rad, double accuracy) {

    double numInit = rad / 2;
    double numSec;
    double threshold;
    int counter = 0;

    do {
        numSec = 0.5 * (numInit + (rad / numInit));
        threshold = Math.abs(numSec - numInit);
        System.out.println("calcolo: " + numSec + " || ciclo n: " + counter);
        counter++;
        numInit = numSec;
    } while (threshold > accuracy);

    return numSec;
}


	public void potenza() {

		System.out.println("\nHai selezionato: POTENZA\n");
		inserimento();
		System.out.print(Math.pow(base, exp));

		// --> metodo inserimento() privato che appartiene esclusivamente a CalcolatriceScientifica
		// setRisultato(); --> NON posso usare il metodo setRisultato() perché è dichiarato private nella classe Calcolatrice. Devo renderlo protected!
		// salva();  --> NON posso usare il metodo salva() perchè è dichiarato private nella classe Calcolatrice. Devo renderlo protected!
	}

	public void radq() {

    System.out.println("\nHai selezionato: RADICE QUADRATA (metodo babilonese)\n");

    boolean errore;
    String valoreLetto;
    double accuracy = 0;
    do {
        errore = false;
        try {
            System.out.print("Inserisci numero: ");
            valoreLetto = tastiera.readLine();
            valoreLetto = valoreLetto.replace(',', '.');
            base = Double.parseDouble(valoreLetto);
        }
        catch(Exception e) {
            System.out.println("ERRORE: valore non valido");
            errore = true;
        }
    } while(errore);

    do {
        errore = false;
        try {
            System.out.print("Inserisci accuracy (es. 0.00001): ");
            valoreLetto = tastiera.readLine();
            valoreLetto = valoreLetto.replace(',', '.');
            accuracy = Double.parseDouble(valoreLetto);
        }
        catch(Exception e) {
            System.out.println("ERRORE: valore non valido");
            errore = true;
        }
    } while(errore);

    double risultato = radiceBabilonese(base, accuracy);
    System.out.println("\nRISULTATO RADICE = " + risultato);
}


	// Esempio di OVERLOADING: funzione addizione che ritorna un double e accetta parametri num1 e num2 in ingresso
	public void addizione(double num1, double num2) {

		System.out.println("\nHai selezionato: ADDIZIONE (metodo esclusivo di Calcolatrice Scientifica)\n");
		System.out.println("SOMMA = " + (num1 + num2));	
	}
}