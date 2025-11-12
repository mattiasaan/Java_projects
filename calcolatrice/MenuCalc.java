import java.io.*;

class MenuCalc {


    public static void main(String args[]) throws IOException {
    	int opzione = 0;
    	String numeroLetto;
			float num1 = 0;
			float num2 = 0;
			InputStreamReader input = new InputStreamReader(System.in);
			BufferedReader tastiera = new BufferedReader(input);
			Calc calcola = new Calc();
			System.out.println("bella gianda");
			
    	while(opzione != 5) {
				System.out.println("scegli operazione: ");
				System.out.println("1) somma \n2) sottrazione \n3) moltiplicazione \n4) divisione \n5) esci");
				
				try {
					numeroLetto = tastiera.readLine();
					opzione = Integer.valueOf(numeroLetto);
				} catch (Exception e) {
						System.out.println("input non valido" + e.getMessage());
						System.out.println("operazione fallita!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
						continue;
				}
				
				if(opzione == 5) {
					System.out.println("addio");
					break;
				}
				
				
				try {
					System.out.print("primo numero: ");
					numeroLetto = tastiera.readLine();
					num1 = Float.valueOf(numeroLetto);
				} catch (Exception e) {
						System.out.println("input non valido" + e.getMessage());
						System.out.println("operazione fallita!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
						continue;
				}
				
				
				try {
					System.out.print("secondo numero: ");
					numeroLetto = tastiera.readLine();
					num2 = Float.valueOf(numeroLetto);
				} catch (Exception e) {
						System.out.println("input non valido" + e.getMessage());
						System.out.println("operazione fallita!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
						continue;
				}
				
				switch(opzione) {
					case 1:
						System.out.println("risultato addizione: " + calcola.addizione(num1, num2));
						break;
				case 2:
						System.out.println("risultato sottrazione: " + calcola.sottrazione(num1, num2));
						break;
				case 3:
						System.out.println("risultato moltiplicazione: " + calcola.moltiplicazione(num1, num2));
						break;
				case 4:
						if(num2 == 0) {
							System.out.println("NON PUOI DIVIDERE PER 0");
							continue;
						}
						System.out.println("risultato divisione: " + calcola.divisione(num1, num2));
						break;
				default:
					System.out.println("OPZIONE NON VALIDA");
					continue;
				}
			}
			}
		}
			

			
