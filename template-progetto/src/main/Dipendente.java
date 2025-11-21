public class Dipendente {
    private String nome;
    private String cognome;
    private final int PAGA_FISSA = 10000;

    public Dipendente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public int calcStipendioGiornaliero(ChiusuraCassa chiusuraCassa) {
        return PAGA_FISSA;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getPAGA_FISSA() {
        return PAGA_FISSA;
    }
}
