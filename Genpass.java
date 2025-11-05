import java.io.*;

class Genpass {
    public static void main(String args[]) throws IOException {
    	int lunghezza = 0;
    	int[] numSorted = new int[100];
    	int max = 122;
      int min = 65;
      int range = max - min + 1;
      boolean f = false;
      int punteggio = 0;
  	
		  InputStreamReader input = new InputStreamReader(System.in);
			BufferedReader tastiera = new BufferedReader(input);
			
			System.out.println("bella gianda");
			while(f == false) {
				try {
					System.out.print("quanto lunga vuoi la password? (al massimo 100): ");
					String numeroLetto = tastiera.readLine();
		   		lunghezza = Integer.valueOf(numeroLetto);
		   		if (lunghezza > 100) {
		   			System.out.println("numero troppo alto");
		   			continue;
		   		}
		   		break;
				} catch (Exception e) {
						System.out.println("input non valido" + e.getMessage());
						System.out.println("generazione passwordd fallita!!");
						continue;
				}
			}
			
			
     	
			
			
	    for (int i = 0; i < numSorted.length; i++) {
					int rand = (int)(Math.random() * range) + min;
					numSorted[i] = rand;
				}
				
			//lunghezza = lunghezza+1;
			System.out.print("la password è: ");
			for(int i = 0; i<lunghezza; i++) {
				System.out.print((char) numSorted[i]);
			}

			}
		}
			

			
