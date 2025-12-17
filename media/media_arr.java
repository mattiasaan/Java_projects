import java.io.*;

class Media_arr {
	public static void main(String args[]) {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tastiera = new BufferedReader(input);
		
		int[] eta = new int[3];
		float media;
		
		for(int i = 0; i<3; i++) {
			System.out.println("persona" + (i+1));
			System.out.print("età: ");

			try {
				String numeroLetto = tastiera.readLine();
				eta[i] = Integer.valueOf(numeroLetto).intValue();
				}
			catch(Exception e) {
				System.out.println("\n numero sbagliato ");
				return;
				}
		}
			
		media = (eta[0] + eta[1] + eta[2]) / 3;
		System.out.println("\n età media: " + media);
			
	}
}
