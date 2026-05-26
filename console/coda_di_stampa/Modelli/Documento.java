package Modelli;

import java.time.LocalDateTime;

/**
 * Modello Documento — rappresenta un file da stampare.
 * Memorizza il nome, l'estensione e la data di creazione automatica.
 */
public class Documento {
  private String nomeFile = "";
  private String estensioneFile = "";
  private LocalDateTime dataDiCreazione;

  public Documento(String nomeFile, String estensioneFile) {
    this.nomeFile = nomeFile;
    this.estensioneFile = estensioneFile;
    this.dataDiCreazione = LocalDateTime.now();
  }

  public String getNomeFile() { return nomeFile; }
  public String getEstensioneFile() { return estensioneFile; }
  public LocalDateTime getDataDiCreazione() { return dataDiCreazione; }
}
