public class Cameriere extends Dipendente{
    public Cameriere(String nome, String cognome) {
        super(nome, cognome);
    }

    @Override
    public int calcStipendioGiornaliero(ChiusuraCassa chiusuraCassa) {
        float stipendioGiornaliero = getPAGA_FISSA()/100f;
        int num_Dipendenti = 0;

        for(Dipendente d : chiusuraCassa.getDipendenti()){
            if(d.getClass().getSimpleName().equals("Cameriere") || d.getClass().getSimpleName().equals("Chef")){
                num_Dipendenti++;
            }
        }

        stipendioGiornaliero += ((((float)chiusuraCassa.getTotGiornaliero())/100)*0.05f) / num_Dipendenti;

        stipendioGiornaliero *= 100;
        return (int)stipendioGiornaliero;
    }
}
