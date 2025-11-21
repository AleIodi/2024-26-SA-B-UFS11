public class Transazione {
    private String data;
    private int importo;
    private int voto;

    public Transazione(String data, int importo, int voto) {
        this.data = data;
        this.importo = importo;
        this.voto = voto;
    }

    public String getData() {
        return data;
    }

    public int getImporto() {
        return importo;
    }

    public int getVoto() {
        return voto;
    }
}