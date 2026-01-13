  import java.io.*;

  class Cifratura {
    public static void main(String args[]) throws IOException {
      InputStreamReader input = new InputStreamReader(System.in);
      BufferedReader tastiera = new BufferedReader(input);

      String text;
      String criptedText = "";

      System.out.println("bella gianda \n dammi un testo da cifrare");
      text = tastiera.readLine();

      char[] charText = text.toCharArray();
      int[] asciiText = new int[charText.length];
      int[] criptedAsciiText = new int[charText.length];
      System.out.println(charText.length + "----" + asciiText.length + "----" + criptedAsciiText.length);

      for(int i = 0; i<charText.length; i++) {
        asciiText[i] = ((int)charText[i]);
        System.out.println(asciiText[i]);
        criptedAsciiText[i] = asciiText[i] + 3;
        System.out.println((char)criptedAsciiText[i]);
        criptedText += (char)criptedAsciiText[i];

      }
      
      System.out.println("Il testo cifrato è: " + criptedText);
  }
}