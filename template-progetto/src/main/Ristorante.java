import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Ristorante {
    private String nome;
    private String indirizzo;
    private ArrayList<Transazione> transazioni;
    private ArrayList<Dipendente> dipendenti;
    private ArrayList<ChiusuraCassa> chiusureCasse;

    public Ristorante(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        transazioni = new ArrayList<>();
        dipendenti = new ArrayList<>();
        chiusureCasse = new ArrayList<>();
    }

    public void paga(String data, int importo, int voto) {
        transazioni.add(new Transazione(data, importo, voto));
    }

    public void addDipendente(Dipendente d) {
        dipendenti.add(d);
    }

    public ChiusuraCassa chiudiCassa(String data) {
        ChiusuraCassa c = new ChiusuraCassa(data, (ArrayList<Transazione>) transazioni.clone(), (ArrayList<Dipendente>) dipendenti.clone());
        chiusureCasse.add(c);
        transazioni.clear();
        dipendenti.clear();
        return c;
    }

    public int calcolaPaga(Dipendente dip, String data) {
        for(ChiusuraCassa c : chiusureCasse) {
            if(c.getData().equals(data)) {
                return dip.calcStipendioGiornaliero(c);
            }
        }
        return 0;
    }

    public void cassaJSON(ChiusuraCassa c) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("cassa " + c.getData() + ".json"), c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Transazione> getTransazioni() {
        return transazioni;
    }

    public ArrayList<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public ArrayList<ChiusuraCassa> getChiusureCasse() {
        return chiusureCasse;
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

}

