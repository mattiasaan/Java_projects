package Modelli;

import java.util.Vector;

public class Stampante {
    private int ID = 0;
    private String nome = "";
    private String marca = "";
    private String modello = "";
    private String stato = "";

    private String collegamento = "";
    private String ip = "";
    private String subnet = "";

    private byte carta = 0;
    private byte nero = 0;
    private byte magenta = 0;
    private byte ciano = 0;
    private byte giallo = 0;

    private Vector<Documento> codaDiStampa = new Vector<>();

    public Stampante(
        int ID, 
        String nome, 
        String marca, 
        String modello, 
        String stato, 
        String collegamento, 
        String ip, 
        String subnet,
        byte carta,
        byte nero,
        byte magenta,
        byte ciano,
        byte giallo
    ) {
        this.ID = ID;
        this.nome = nome;
        this.marca = marca;
        this.modello = modello;
        this.stato = stato;
        this.collegamento = collegamento;
        this.ip = ip;
        this.subnet = subnet;
        this.carta = carta;
        this.nero = nero;
        this.magenta = magenta;
        this.ciano = ciano;
        this.giallo = giallo;
    }

    public int getID() {return ID;}
    public String getNome() {return nome;}
    public String getMarca() {return marca;}
    public String getModello() {return modello;}
    public String getStato() {return stato;}
    public String getCollegamento() {return collegamento;}
    public String getIP() {return ip;}
    public String getSubnet() {return subnet;}
    public byte getCarta() {return carta;}
    public byte getNero() {return nero;}
    public byte getMagenta() {return magenta;}
    public byte getCiano() {return ciano;}
    public byte getGiallo() {return giallo;}

    public void setCarta(byte quantità) {carta = quantità;}
    public void setNero(byte quantità) {nero = quantità;}
    public void setMagenta(byte quantità) {magenta = quantità;}
    public void setCiano(byte quantità) {ciano = quantità;}
    public void setGiallo(byte quantità) {giallo = quantità;}
}