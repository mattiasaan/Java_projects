import java.io.*;

class Media {
	public static void main(String args[]) {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tastiera = new BufferedReader(input);
		
		float eta1, eta2, eta3;
		float media;
		
		System.out.println("persona1");
		System.out.print("età: ");
		
		try {
			String numeroLetto = tastiera.readLine();
			eta1 = Integer.valueOf(numeroLetto).intValue();
			}
		catch(Exception e) {
			System.out.println("\n numero sbagliato ");
			return;
			}
			
		System.out.println("persona2");
		System.out.print("età: ");
		
		try {
			String numeroLetto = tastiera.readLine();
			eta2 = Integer.valueOf(numeroLetto).intValue();
			}
		catch(Exception e) {
			System.out.println("\n numero sbagliato ");
			return;
			}
			
		System.out.println("persona3");
		System.out.print("età: ");
		
		try {
			String numeroLetto = tastiera.readLine();
			eta3 = Integer.valueOf(numeroLetto).intValue();
			}
		catch(Exception e) {
			System.out.println("\n numero sbagliato ");
			return;
			}
			
		media = (eta1 + eta2 + eta3) / 3;
		System.out.println("\n età media: " + media);
			
	}
}
