package es.iesmz.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompteTest {

    // ---------------- IBAN ----------------

    @Test
    void testCompruebaIBANTrue() {
        Compte c = new Compte("", "");
        assertTrue(c.compruebaIBAN("ES6621000418401234567891"));
        assertTrue(c.compruebaIBAN("ES6000491500051234567892"));
    }

    @Test
    void testCompruebaIBANFalse() {
        Compte c = new Compte("", "");
        assertFalse(c.compruebaIBAN("ES9420805801101234567891"));
        assertFalse(c.compruebaIBAN("ES7600246912501234567891"));
        assertFalse(c.compruebaIBAN("ES4721000418401234567891"));
        assertFalse(c.compruebaIBAN("ES8200491500051234567892"));
    }

    // ---------------- GENERAR IBAN ----------------

    @Test
    void testGeneraIBANCorrectes() {
        Compte c = new Compte("", "");

        assertEquals("ES7100302053091234567895",
                c.generaIBAN("0030","2053","09","1234567895"));

        assertEquals("ES1000492352082414205416",
                c.generaIBAN("0049","2352","08","2414205416"));

        assertEquals("ES1720852066623456789011",
                c.generaIBAN("2085","2066","62","3456789011"));
    }

    @Test
    void testGeneraIBANNulls() {
        Compte c = new Compte("", "");

        assertNull(c.generaIBAN("208","2066","62","3456789011"));
        assertNull(c.generaIBAN("2080","20A6","62","3456789011"));
        assertNull(c.generaIBAN("2080","2086","6","3456789011"));
        assertNull(c.generaIBAN("2080","2086","63","345678911"));
    }
}