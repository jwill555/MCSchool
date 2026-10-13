package BobsCircus;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CryptoManagerTestStudent {

    /* =======================
       isStringInBounds Tests
       ======================= */

    @Test
    public void testIsStringInBoundsLowerBoundary() {
        assertFalse(CryptoManager.isStringInBounds("p"));
        assertTrue(CryptoManager.isStringInBounds("_"));
        assertTrue(CryptoManager.isStringInBounds(" "));
        assertFalse(CryptoManager.isStringInBounds("`"));
    }
    /* =======================
       Caesar Cipher Test
       ======================= */

    @Test
    public void testCaesarEncryptionDecryption() {
    	String text = "PHANTOM";
        String key = "KEY";
      
        String encrypted = CryptoManager.caesarEncryption(text, 2);
        
        assertEquals("RJCPVQO", encrypted);
        
        String decrypted = CryptoManager.caesarDecryption(encrypted, 2);
        
        assertEquals(text, decrypted);
        
    }

    /* =======================
       Vigenere Cipher Tests
       ======================= */

    @Test
    public void testVigenereEncryptionDecryption() {
        String text = "PHANTOM";
        String key = "KEY";
      
        String encrypted = CryptoManager.vigenereEncryption(text, key);
        
        assertEquals(";-:99H8", encrypted);
        
        String decrypted = CryptoManager.vigenereDecryption(encrypted, key);
        
        assertEquals(text, decrypted);
    }

    /* =======================
       Playfair Cipher Test
       ======================= */
    @Test
    public void testPlayfairSymbolsMixed() {
    	
        String text = "PHANTOM";
        String key = "KEY";
      
        String encrypted = CryptoManager.playfairEncryption(text, key);
        
        assertEquals("QGDJWLG3", encrypted);
        
        String decrypted = CryptoManager.playfairDecryption(encrypted, key);
        
        assertEquals(text, decrypted);
    }

}
