public class Stampante {
  private int stato = 0;
  
  public void stampaDocumento() {
    System.out.println("che documento vuoi stampare??");
  }

  public void stato() {
    if (stato == 0) {
      System.out.println("la stampante è spenta, si sta accendendo");
      stato = 1;
    } else {
      System.out.println("la stampante è accesa, si sta spegnendo");
      stato = 0;
    }
  }

  public int statoAttualeStampante() {
    return stato;
  }

  public void mostraCoda() {
    System.out.println("coda stamapnte:");
  }

  public void mostraStampati() {
    System.out.println("files già stampati");
  }
}
