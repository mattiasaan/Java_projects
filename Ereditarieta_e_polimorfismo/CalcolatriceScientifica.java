
class CalcolatriceScientifica extends Calcolatrice {

	private double base, exp, radicando;

	public CalcolatriceScientifica() {

		// Chiamata super() implicita
		// System.out.println("Sono il costruttore di CalcolatriceScientifica");

		/*	NOTA BENE: Se creiamo un oggetto che è istanza della classe CalcolatriceScientifica:

			Viene allocata la memoria per l’oggetto (con tutti i campi, sia quelli della superclasse Calcolatrice che quelli della sottoclasse CalcolatriceScientifica).
			Viene eseguito il costruttore della superclasse "Calcolatrice()"", che inizializza i suoi attributi (cronologia, a, b, risultato, salvataggi)
			Poi viene eseguito il costruttore della sottoclasse "CalcolatriceScientifica()"", che inizializza i suoi campi (base, exp, radicando).

			QUINDI... Il costruttore della superclasse "Calcolatrice()" viene sempre eseguito quando creiamo un’istanza di una sottoclasse! Ciò accade perchè in Java,
			di default, il compilatore inserisce automaticamente super() come prima istruzione nel costruttore di una sottoclasse per chiamare il costruttore della 
			superclasse di appartenenza.

			Per convinversi che ciò è vero, basta provare a togliere il commento all'istruzione "System.out.println("chiamata super()");" che è stata inserita nel costruttore
			della superclasse Calcolatrice e poi istanziare un singolo oggetto della classe CalcolatriceScientifica all'interno del main() della classe AppCalcolatrice.
		*/
		
		base = 0;
		exp = 0;
		radicando = 0;
	}

	/* @Override -> è un’annotazione in Java che segnala al compilatore e ai lettori del codice che un metodo intende sovrascrivere (override) 
					un metodo della superclasse. Se utilizziamo @Override e il metodo dichiarato non corrisponde esattamente a un metodo ereditato 
					(nome sbagliato, parametri diversi),il compilatore segnala un errore. Menu() è un esempio di overriding
	*/
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

	public void potenza() {

		System.out.println("\nHai selezionato: POTENZA\n");
		inserimento(); // --> metodo inserimento() privato che appartiene esclusivamente a CalcolatriceScientifica
		// setRisultato(); --> NON posso usare il metodo setRisultato() perché è dichiarato private nella classe Calcolatrice. Devo renderlo protected!
		// salva();  --> NON posso usare il metodo salva() perchè è dichiarato private nella classe Calcolatrice. Devo renderlo protected!
	}

	public void radq() {

		System.out.println("\nHai selezionato: RADICE QUADRATA\n");	
		System.out.println("***** Metodo inserimento() della Calcolatrice SCIENTIFICA *****");

		boolean errore;
		String valoreLetto;

		do {
			errore = false;
			try {
				System.out.print("Inserisci numero: ");
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

	// Esempio di OVERLOADING: funzione addizione che ritorna un double e accetta parametri num1 e num2 in ingresso
	public void addizione(double num1, double num2) {

		System.out.println("\nHai selezionato: ADDIZIONE (metodo esclusivo di Calcolatrice Scientifica)\n");
		System.out.println("SOMMA = " + (num1 + num2));	
	}
}