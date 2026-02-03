import java.io.*;

class Superenalotto {
	public static void main(String args[]) throws IOException {

		int[] numGiocati = new int[6];
		int[] numSorted = new int[6];
		int max = 20;
		int min = 1;
		int range = max - min + 1;
		int f = 0;
		int punteggio = 0;

		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tastiera = new BufferedReader(input);

		System.out.println("bella gianda");

		for (int i = 0; i < numSorted.length; i++) {
			boolean numeroUscValido = false;
			while (!numeroUscValido) {
				int rand = (int) (Math.random() * range) + min;
				boolean duplicato = false;

				for (int h = 0; h < i; h++) {
					if (numSorted[h] == rand) {
						duplicato = true;
						break;
					}
				}

				if (!duplicato) {
					numSorted[i] = rand;
					numeroUscValido = true;
				}
			}
		}

		System.out.println("Benvenuto al Superenalotto dove ti rubiamo i soldi, prego inserisci 6 numeri.");

		for (int i = 0; i < 6; i++) {
			boolean numeroValido = false;
			while (!numeroValido) {
				String numeroLetto = tastiera.readLine();
				int temp = Integer.valueOf(numeroLetto);

				// Controllo se il numero è tra 1 e 20
				if (temp < 1 || temp > 20) {
					System.out.println("Il numero deve essere tra 1 e 20 Riprova");
					continue;
				}

				// Controllo se il numero è già stato inserito
				boolean duplicato = false;
				for (int h = 0; h < i; h++) {
					if (numGiocati[h] == temp) {
						duplicato = true;
						break;
					}
				}

				if (duplicato) {
					System.out.println("Numero già inserito riprova");
				} else {
					numGiocati[i] = temp;
					numeroValido = true;
				}
			}
		}

		for (int i = 0; i < 6; i++) {
			for (int y = 0; y < 6; y++) {
				if (numGiocati[i] == numSorted[y]) {
					punteggio = punteggio + 1;
				}
			}
		}
		System.out.println("punteggio " + punteggio);
		System.out.println("i numeri furtunati erano: ");
		for (int i = 0; i < 6; i++) {
			System.out.println(numSorted[i]);
		}
		System.out.println("i tuoi numeri erano: ");
		for (int i = 0; i < 6; i++) {
			System.out.println(numGiocati[i]);
		}
	}
}
