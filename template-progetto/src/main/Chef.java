public class Chef extends Dipendente{
    public Chef(String nome, String cognome) {
        super(nome, cognome);
    }

    @Override
    public int calcStipendioGiornaliero(ChiusuraCassa chiusuraCassa) {
        float stipendioGiornaliero = getPAGA_FISSA()/100f;

        int num_Dipendenti = 0;
        int num_Chef = 0;

        for(Dipendente d : chiusuraCassa.getDipendenti()){
            if(d.getClass().getSimpleName().equals("Cameriere") || d.getClass().getSimpleName().equals("Chef")){
                num_Dipendenti++;
            }
            if(d.getClass().getSimpleName().equals("Chef")){
                num_Chef++;
            }
        }

        stipendioGiornaliero += ((((float)chiusuraCassa.getTotGiornaliero())/100)*0.05f) / num_Dipendenti;

        stipendioGiornaliero += ((((float)chiusuraCassa.getTotVoto8())/100)*0.05f) / num_Chef;

        stipendioGiornaliero *= 100;
        return (int)stipendioGiornaliero;
    }
}
