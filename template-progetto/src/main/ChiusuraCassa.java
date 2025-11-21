import java.util.ArrayList;

public class ChiusuraCassa {
    private String data;
    private ArrayList<Transazione> transazioni;
    private ArrayList<Dipendente> dipendenti;
    private int totGiornaliero;
    private int totVoto8;

    public ChiusuraCassa(String data, ArrayList<Transazione> transazioni, ArrayList<Dipendente> dipendenti) {
        this.data = data;
        this.transazioni = transazioni;
        this.dipendenti = dipendenti;

        for (Transazione t : transazioni) {
            if (t.getVoto() >= 8) {
                totVoto8 += t.getImporto();
            }
            totGiornaliero += t.getImporto();
        }
    }

    public String getData() {
        return data;
    }

    public ArrayList<Transazione> getTransazioni() {
        return transazioni;
    }

    public ArrayList<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public int getTotGiornaliero() {
        return totGiornaliero;
    }

    public int getTotVoto8() {
        return totVoto8;
    }
}
