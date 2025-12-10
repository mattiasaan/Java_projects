import java.io.*;

class MenuCalc {
		public static void main(String args[]) throws IOException {
				int opzione = 0;
				String numeroLetto;
				float num1 = 0;
				float num2 = 0;
				boolean haveNumbers = false;

				float[] numeri = new float[2];
				float[] risultati = new float[5];
				int nextResult = 0;
				int countResults = 0;

				InputStreamReader input = new InputStreamReader(System.in);
				BufferedReader tastiera = new BufferedReader(input);
				Calc calcola = new Calc();
				System.out.println("bella gianda");

				while(true) {
						System.out.println("\nScegli operazione:");
						System.out.println("1) somma \n2) sottrazione \n3) moltiplicazione \n4) divisione \n5) mostra cronologia (ultimi 5) \n6) cambia numeri \n7) esplodi");

						try {
								numeroLetto = tastiera.readLine();
								opzione = Integer.parseInt(numeroLetto.trim());
						} catch (Exception e) {
								System.out.println("Input non valido: " + e.getMessage());
								continue;
						}

						if(opzione == 7) {
								System.out.println("addio");
								break;
						}

						if(opzione == 6) {
								try {
										System.out.print("Inserisci primo numero: ");
										numeroLetto = tastiera.readLine();
										num1 = Float.parseFloat(numeroLetto.trim());
										System.out.print("Inserisci secondo numero: ");
										numeroLetto = tastiera.readLine();
										num2 = Float.parseFloat(numeroLetto.trim());
										numeri[0] = num1;
										numeri[1] = num2;
										haveNumbers = true;
								} catch (Exception e) {
										System.out.println("Input non valido: " + e.getMessage());
								}
								continue;
						}

						if(opzione == 5) {
								if(countResults == 0) {
										System.out.println("Nessun risultato salvato");
								} else {
										System.out.println("Ultimi risultati:");
										for(int i=0; i<countResults; i++) {
												int idx = (nextResult - 1 - i + risultati.length) % risultati.length;
												System.out.println((i+1) + ") " + risultati[idx]);
										}
								}
								continue;
						}

						if(opzione >=1 && opzione <=4) {
								if(!haveNumbers) {
										try {
												System.out.print("Primo numero: ");
												numeroLetto = tastiera.readLine();
												num1 = Float.parseFloat(numeroLetto.trim());
												System.out.print("Secondo numero: ");
												numeroLetto = tastiera.readLine();
												num2 = Float.parseFloat(numeroLetto.trim());
												numeri[0] = num1;
												numeri[1] = num2;
												haveNumbers = true;
										} catch (Exception e) {
												System.out.println("Input non valido: " + e.getMessage());
												continue;
										}
								} else {
										System.out.println("Vuoi usare gli stessi numeri? \n1)si \n2)no");
										try {
												numeroLetto = tastiera.readLine();
												int scelta = Integer.parseInt(numeroLetto.trim());
												if(scelta == 2) {
														try {
																System.out.print("Primo numero: ");
																numeroLetto = tastiera.readLine();
																num1 = Float.parseFloat(numeroLetto.trim());
																System.out.print("Secondo numero: ");
																numeroLetto = tastiera.readLine();
																num2 = Float.parseFloat(numeroLetto.trim());
																numeri[0] = num1;
																numeri[1] = num2;
														} catch (Exception e) {
																System.out.println("Input non valido: " + e.getMessage());
																continue;
														}
												} else {
														num1 = numeri[0];
														num2 = numeri[1];
												}
										} catch (Exception e) {
												System.out.println("Scelta non valida uso numeri salvati");
												num1 = numeri[0];
												num2 = numeri[1];
										}
								}

								float risultato = 0.0f;
								boolean validOperation = true;
								switch(opzione) {
										case 1:
												risultato = calcola.addizione(num1, num2);
												System.out.println("Risultato addizione: " + risultato);
												break;
										case 2:
												risultato = calcola.sottrazione(num1, num2);
												System.out.println("Risultato sottrazione: " + risultato);
												break;
										case 3:
												risultato = calcola.moltiplicazione(num1, num2);
												System.out.println("Risultato moltiplicazione: " + risultato);
												break;
										case 4:
												if(num2 == 0.0f) {
														System.out.println("NON PUOI DIVIDERE PER 0");
														validOperation = false;
												} else {
														risultato = calcola.divisione(num1, num2);
														System.out.println("Risultato divisione: " + risultato);
												}
												break;
										default:
												System.out.println("OPZIONE NON VALIDA");
												validOperation = false;
								}

								if(validOperation) {
										risultati[nextResult] = risultato;
										nextResult = (nextResult + 1) % risultati.length;
										if(countResults < risultati.length) countResults++;
								}
								continue;
						}

						System.out.println("Opzione non riconosciuta. Riprova.");
				}
		}
}
