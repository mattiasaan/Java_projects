public class Convertitore {
    private String unitàDiPartenza;
    private String unitàDaConvertire;
    private double temperaturaDiPartenza;
    private double temperaturaConvertita;
    
    public Convertitore(String unitàDiPartenza, String unitàDaConvertire, double temperaturaDiPartenza) {
        this.unitàDiPartenza = unitàDiPartenza;
        this.unitàDaConvertire = unitàDaConvertire;
        this.temperaturaDiPartenza = temperaturaDiPartenza;
    }
    
    public double convertFromTo() {
        if (unitàDiPartenza.equals(unitàDaConvertire)) {
            return temperaturaDiPartenza;
        }

        if (unitàDiPartenza.contains("°C") && unitàDaConvertire.contains("°F")) {
            temperaturaConvertita = (temperaturaDiPartenza * 1.8) + 32;
        }
        else if (unitàDiPartenza.contains("°C") && unitàDaConvertire.contains("°K")) {
            temperaturaConvertita = temperaturaDiPartenza + 273.15;
        }
        else if (unitàDiPartenza.contains("°F") && unitàDaConvertire.contains("°C")) {
            temperaturaConvertita = (temperaturaDiPartenza - 32) * (5.0 / 9.0);
        }
        else if (unitàDiPartenza.contains("°F") && unitàDaConvertire.contains("°K")) {
            temperaturaConvertita = ((temperaturaDiPartenza - 32) / 1.8) + 273.15;
        }
        else if (unitàDiPartenza.contains("°K") && unitàDaConvertire.contains("°C")) {
            temperaturaConvertita = temperaturaDiPartenza - 273.15;
        }
        else if (unitàDiPartenza.contains("°K") && unitàDaConvertire.contains("°F")) {
            temperaturaConvertita = (temperaturaDiPartenza * (9.0 / 5.0)) - 459.67;
        }

        return temperaturaConvertita;
    }
}