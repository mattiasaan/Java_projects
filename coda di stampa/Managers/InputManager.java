package Managers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputManager {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String leggiRiga() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("ERRORE: " + e.getMessage());
            return "";
        }
    }
}
