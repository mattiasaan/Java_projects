package Modelli;

import java.time.LocalDateTime;

public class Documento {
    private String nomeFile = "";
    private String estensioneFile = "";
    private LocalDateTime dataDiCreazione;

    public Documento(String nomeFile, String estensioneFile) {
        this.nomeFile = nomeFile;
        this.estensioneFile = estensioneFile;
        this.dataDiCreazione = LocalDateTime.now();
    }
}
