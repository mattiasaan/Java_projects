import java.io.BufferedReader;
import java.io.InputStreamReader;

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
			int operazione= 0;


			System.out.print("menu principale calcolatrice: \n 1)calcolatrice normale. \n 2)calcolatrice scentifica. \n ctrl + c per uscire. \n cosa scegli: ");
			try {
				valoreLetto = tastiera.readLine();
				scelta = Integer.parseInt(valoreLetto);
			} catch(Exception e) {
				System.out.println("errore");
			}

			if(scelta == 1) {
				operazione = calc.menu();
			} else if(scelta == 2) {
				operazione = calcScientifica.menu();
			} else {
				System.out.println("errore");
			}

			switch (operazione) {
				case 1:
					calc.addizione();
					break;
				case 2:
					calc.sottrazione();
					break;
				case 3:
					calc.moltiplicazione();
					break;
				case 4:
					calc.divisione();
					break;
				case 5:
					calc.mostraCronologia();
					break;
				case 6:
					calcScientifica.potenza();
					break;
				case 7:
					calcScientifica.radq();
					break;
			
				default:
					break;
			}
		} while (negro !=1);
			
		


	//	

	//	int scelta = calc.menu();
	//	calc.addizione();
	//	calc.mostraCronologia();
	//	calc.radq();

	//	int scelta = calcScientifica.menu();
	//	calcScientifica.addizione();
	//	calcScientifica.addizione(2, 5);
	//	calcScientifica.mostraCronologia();
	//	calcScientifica.radq();
	
	}
}