package com.mycompany.app;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {
    
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    
    @Test
    public void testCreaRistorante() {
        Ristorante r = new Ristorante("Pizza Bella", "Via Roma 1");
        assertEquals("Pizza Bella", r.getNome());
        assertEquals("Via Roma 1", r.getIndirizzo());
    }
    
    @Test
    public void testCreaDipendente() {
        Dipendente d = new Dipendente("Mario", "Rossi");
        assertEquals("Mario", d.getNome());
        assertEquals("Rossi", d.getCognome());
    }
    
    @Test
    public void testCreaCameriere() {
        Cameriere c = new Cameriere("Luca", "Bianchi");
        assertEquals("Luca", c.getNome());
        assertEquals("Bianchi", c.getCognome());
    }
    
    @Test
    public void testCreaChef() {
        Chef chef = new Chef("Giuseppe", "Verdi");
        assertEquals("Giuseppe", chef.getNome());
        assertEquals("Verdi", chef.getCognome());
    }
    
    @Test
    public void testPagaFissa() {
        Dipendente d = new Dipendente("Mario", "Rossi");
        assertEquals(10000, d.getPAGA_FISSA());
    }
    
    @Test
    public void testAggiuntaTransazione() {
        Ristorante r = new Ristorante("Pizza Bella", "Via Roma 1");
        r.paga("2025-01-15", 5000, 8);
        assertEquals(1, r.getTransazioni().size());
    }
    
    @Test
    public void testDatiTransazione() {
        Transazione t = new Transazione("2025-01-15", 5000, 8);
        assertEquals("2025-01-15", t.getData());
        assertEquals(5000, t.getImporto());
        assertEquals(8, t.getVoto());
    }
    
    @Test
    public void testAggiuntaDipendente() {
        Ristorante r = new Ristorante("Pizza Bella", "Via Roma 1");
        Dipendente d = new Dipendente("Mario", "Rossi");
        r.addDipendente(d);
        assertEquals(1, r.getDipendenti().size());
    }
    
    @Test
    public void testChiusuraCassaData() {
        Ristorante r = new Ristorante("Pizza Bella", "Via Roma 1");
        r.paga("2025-01-15", 5000, 8);
        ChiusuraCassa c = r.chiudiCassa("2025-01-15");
        assertEquals("2025-01-15", c.getData());
    }
    
    @Test
    public void testTotaleGiornaliero() {
        Ristorante r = new Ristorante("Pizza Bella", "Via Roma 1");
        r.paga("2025-01-15", 3000, 7);
        r.paga("2025-01-15", 2000, 8);
        ChiusuraCassa c = r.chiudiCassa("2025-01-15");
        assertEquals(5000, c.getTotGiornaliero());
    }
    
    @Test
    public void testTotaleVoto8() {
        Ristorante r = new Ristorante("Pizza Bella", "Via Roma 1");
        r.paga("2025-01-15", 3000, 7);
        r.paga("2025-01-15", 2000, 8);
        ChiusuraCassa c = r.chiudiCassa("2025-01-15");
        assertEquals(2000, c.getTotVoto8());
    }
    
    @Test
    public void testListaSvuotataDopoChiusura() {
        Ristorante r = new Ristorante("Pizza Bella", "Via Roma 1");
        r.paga("2025-01-15", 5000, 8);
        r.chiudiCassa("2025-01-15");
        assertEquals(0, r.getTransazioni().size());
    }
    
    @Test
    public void testStipendioBase() {
        Ristorante r = new Ristorante("Pizza Bella", "Via Roma 1");
        Dipendente d = new Dipendente("Mario", "Rossi");
        r.addDipendente(d);
        r.paga("2025-01-15", 10000, 5);
        ChiusuraCassa c = r.chiudiCassa("2025-01-15");
        
        int stipendio = d.calcStipendioGiornaliero(c);
        assertEquals(10000, stipendio);
    }
    
    @Test
    public void testCalcolaPagaRistorante() {
        Ristorante r = new Ristorante("Pizza Bella", "Via Roma 1");
        Dipendente d = new Dipendente("Mario", "Rossi");
        r.addDipendente(d);
        r.paga("2025-01-15", 10000, 5);
        r.chiudiCassa("2025-01-15");
        
        int paga = r.calcolaPaga(d, "2025-01-15");
        assertEquals(10000, paga);
    }
}