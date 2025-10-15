import java.io.*;

class IMC {
    public static void main(String args[]) throws IOException {
    	int loop = 0;
    	while(loop < 1) {
		    InputStreamReader input = new InputStreamReader(System.in);
		    BufferedReader tastiera = new BufferedReader(input);

		    float altezza, peso, imc;
		    
				while (true) {
				  System.out.print("dammi l'altezza in metri se no ti picchio: ");
				  String inputAltezza = tastiera.readLine();
					inputAltezza = inputAltezza.replace(',', '.');
					
					try {
						altezza = Float.parseFloat(inputAltezza);
						
					}
					catch(Exception e) {
						System.out.println("input non valido");
						continue;
					}
					
					if (altezza < 0) {
						System.out.println("inserire  numero ositivo mona");
						continue;
					}
					break;
				}


				while(true) {
				  System.out.print("dammi il peso in kg se no ti picchio: ");
				  String inputPeso = tastiera.readLine();
					inputPeso = inputPeso.replace(',', '.');
					
					try {
						peso = Float.parseFloat(inputPeso);
					}
					catch(Exception e) {
						System.out.println("input non valido");
						continue;
					}
					
					if (peso < 0) {
						System.out.println("inserire  numero positivo mona");
						continue;
					}
					break;
				}

		    imc = peso / (float) Math.pow(altezza, 2);

		    System.out.println("il tuo IMC è: " + imc);

		    if (imc < 18.5) {
		        System.out.println("sei uno stuzzicadente sottopeso");
		    } else if (imc < 25) {
		        System.out.println("Normopeso");
		    } else if (imc < 30) {
		        System.out.println("sovrappeso");
		    } else if (imc < 35) {
		        System.out.println("obeso al primo grado");
		    } else if (imc < 40) {
		        System.out.println("obeso di secondo grado");
		    else {
		        System.out.println("sei una palla da basket di terzo grado");
		    }
		    
		    int numlet = 0;
		    
		    do {
				  System.out.println("vuoi far ripartire il programma?");
				  System.out.println("se si premi 1 se no 2");
				  String numeroLetto = tastiera.readLine();
				  
				  try {
				  	numlet = Integer.valueOf(numeroLetto).intValue();
				  	}
				  catch(Exception e) {
				  		System.out.println("input non valido");
				  		continue;
				  }
				  
				  if(numlet == 1) {
				  	loop = 0;
				  }
				  else if(numlet == 2) {
				  	loop = 1;
				  } else {
				  	System.out.println("numero non valido");
				  }
		    } while(numlet != 1 && numlet != 2);
		}
	}
}
