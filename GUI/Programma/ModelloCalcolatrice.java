public class ModelloCalcolatrice {
    public double risolviEspressione(String espressione) {
        try {
            String exp = espressione.replace(" ", "");
            String[] numeri = exp.split("(?<=[-+*/])|(?=[-+*/])");
            if (numeri.length < 3) return Double.parseDouble(exp);

            double risultato = Double.parseDouble(numeri[0]);
            for (int i = 1; i < numeri.length; i += 2) {
                String op = numeri[i];
                double prossimo = Double.parseDouble(numeri[i + 1]);
                switch (op) {
                    case "+": risultato += prossimo; break;
                    case "-": risultato -= prossimo; break;
                    case "*": risultato *= prossimo; break;
                    case "/": if (prossimo != 0) risultato /= prossimo; break;
                }
            }
            return risultato;
        } catch (Exception e) {
            return 0;
        }
    }
}