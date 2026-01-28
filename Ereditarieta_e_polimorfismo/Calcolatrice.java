import java.io.BufferedReader;
import java.io.InputStreamReader;

class Calcolatrice {

	private double a, b;
	private int salvataggi;
	private final double[] cronologia;	// NOTA BENE: final impedisce la riassegnazione del riferimento all'array, ma non impedisce di modificare gli elementi dell'array.
	protected final InputStreamReader input = new InputStreamReader(System.in);
	protected final BufferedReader tastiera = new BufferedReader(input);	// final impedisce la riassegnazione del riferimento della tastiera (impedendo anche la riassegnazione tastiera = null).
	private double risultato;

	public Calcolatrice() {

		// System.out.println("Sono il costruttore di Calcolatrice");
		cronologia = new double[5];
		a = 0;
		b = 0;
		risultato = 0;
		salvataggi = 0;
	}

	public int menu() {

		boolean errore;
		String valoreLetto;
		int scelta = 0;

		System.out.println("\n********** MENU' OPERAZIONI (calcolatrice STANDARD) **********\n");
		System.out.println("Scegli l'operazione che vuoi eseguire:\n");
		System.out.println("1) Addizione");
		System.out.println("2) Sottrazione");
		System.out.println("3) Moltiplicazione");
		System.out.println("4) Divisione");
		System.out.println("5) Mostra cronologia risultati");

		do {
			errore = false;
			try {
				System.out.print("\nRISPOSTA: ");
				valoreLetto = tastiera.readLine();
				scelta = Integer.parseInt(valoreLetto);

				if(scelta < 1 || scelta > 5) {
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
	}

	private void setRisultato(double ris) {

		this.risultato = ris;
	}

	private void inserimento() {

		System.out.println("***** Metodo inserimento() della Calcolatrice STANDARD *****\n");

		boolean errore;
		String valoreLetto;

		do {
			errore = false;
			try {
				System.out.print("Inserisci il primo numero: ");
				valoreLetto = tastiera.readLine();
				a = Double.parseDouble(valoreLetto);
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
				System.out.print("Inserisci il secondo numero: ");
				valoreLetto = tastiera.readLine();
				b = Double.parseDouble(valoreLetto);
			}
			catch(Exception e) {
				
				System.out.println("ERRORE: " + e.getMessage());
				errore = true;
			}
		}
		while(errore == true);


	}

	private void salva() {

		for(int i=4; i>0; i--) {
				cronologia[i] = cronologia[i-1];
		}

		cronologia[0] = risultato;

		if(salvataggi < 5) {
			salvataggi++;	
		}
	}

	public void mostraCronologia() {

		System.out.print("\nCRONOLOGIA RISULTATI:");

		if(salvataggi == 0) 
		{
			System.out.print(" non è ancora stata eseguita nessuna operazione.");
		}
		else if(salvataggi < 5) 
		{
			for(int i=0; i<salvataggi; i++) {
				System.out.print(" | " + cronologia[i] + " | ");
			}
		}
		else 
		{
			for(int i=0; i<5; i++) {
				System.out.print(" | " + cronologia[i] + " | ");
			}
		}

		System.out.println();
	}

	public void addizione() {

		System.out.println("\nHai selezionato: ADDIZIONE\n");
		inserimento();	// metodo inserimento() privato che appartiene esclusivamente a Calcolatrice 
		setRisultato(a + b);
		System.out.println("\nSomma = " + risultato);
		salva();
	}

	public void sottrazione() {
		
		System.out.println("\nHai selezionato: SOTTRAZIONE\n");
		inserimento();
		setRisultato(a - b);
		System.out.println("\nDifferenza = " + risultato);
		salva();
	}

	public void moltiplicazione() {
		
		System.out.println("\nHai selezionato: MOLTIPLICAZIONE\n");
		inserimento();
		setRisultato(a * b);
		System.out.println("\nProdotto = " + risultato);
		salva();
	}

	public void divisione() {
		
		System.out.println("\nHai selezionato: DIVISIONE\n");
		inserimento();

		if(b != 0) {
			setRisultato(a / b);
			System.out.println("\nQuoziente = " + risultato);
			salva();
		}
			
		else {
			System.out.println("\nERRORE: impossibile dividere per 0.");
		}
	}
}