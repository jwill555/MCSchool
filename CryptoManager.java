package BobsCircus;

/**
 * This class provides methods to encrypt and decrypt strings using the
 * Vigenere, Playfair, and Caesar ciphers. It also checks whether a string
 * contains characters within the allowed range.
 * 
 * **@author** wonder **@version** 1.0
 */
public class CryptoManager {

	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';

	// Use a 64-character alphabet to create an 8x8 matrix for the Playfair cipher
	private static final String alphebet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !\"#$%&'()*+,-./:;<=>?@[\\]^_";

	/**
	 * Checks whether every character in the given string is between the lower and
	 * upper character limits, inclusive.
	 * 
	 * **@param** plainText the string to check **@return** true if every character
	 * is within the allowed range; false otherwise
	 */
	public static boolean isStringInBounds(String plainText) {
		for (int i = 0; i < plainText.length(); i++) {
			if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string using the Vigenere cipher and the provided key. The key is
	 * repeated as needed to match the plaintext length.
	 * 
	 * **@param** plainText the string to encrypt **@param** key the key used to
	 * encrypt the plaintext **@return** the encrypted string
	 */
	public static String vigenereEncryption(String plainText, String key) {
		String encryptedWord = "";

		while (key.length() != plainText.length()) {
			if (key.length() < plainText.length()) {
				for (int i = 0; i < key.length(); i++) {
					key += key.charAt(i);
					if (key.length() == plainText.length()) {
						break;
					}
				}
			} else {
				break;
			}
		}
		String newKey = "";
		if (key.length() > plainText.length()) {
			for (int i = 0; i < plainText.length(); i++) {
				newKey += key.charAt(i); 
				if (newKey.length() == plainText.length()) {
					key = newKey;
					break;
				}
			}
		}

		for (int i = 0; i < plainText.length(); i++) {
			int plainIndex = plainText.charAt(i) - 32;
			int keyIndex = key.charAt(i) - 32;
			encryptedWord += (char) ((plainIndex + keyIndex) % 64 + 32);
		}

		return encryptedWord;
	}

	/**
	 * Decrypts a string encrypted with the Vigenere cipher using the provided key.
	 * The key is repeated or adjusted to match the encrypted text length.
	 * 
	 * **@param** encryptedText the string to decrypt **@param** key the key used to
	 * decrypt the text **@return** the decrypted string
	 */
	public static String vigenereDecryption(String encryptedText, String key) {
		String decryptedWord = "";

		while (key.length() != encryptedText.length()) {
			if (key.length() < encryptedText.length()) {
				for (int i = 0; i < key.length(); i++) {
					key += key.charAt(i);
					if (key.length() == encryptedText.length()) {
						break;
					}
				}
			} else {
				break;
			}
		}
		String newKey = "";
		if (key.length() > encryptedText.length()) {
			for (int i = 0; i < encryptedText.length(); i++) {
				newKey += key.charAt(i); 
				if (key.length() == encryptedText.length()) {
					key = newKey;
					break;
				}
			}
		}

		for (int i = 0; i < encryptedText.length(); i++) {
			int encryptedIndex = encryptedText.charAt(i) - 32;
			int keyIndex = key.charAt(i) - 32;
			int decryptedIndex = (encryptedIndex - keyIndex) % 64;

			if (decryptedIndex < 0) {
				decryptedIndex += 64;
			}

			decryptedWord += (char) (decryptedIndex + 32);
		}

		return decryptedWord;
	}

	/**
	 * Encrypts a string using the Playfair cipher and the provided key. Creates an
	 * 8x8 key matrix from the key and the allowed alphabet. If the plaintext has an
	 * odd length, an X is added to make its length even.
	 * 
	 * **@param** plainText the string to encrypt **@param** key the keyword used to
	 * construct the Playfair matrix **@return** the encrypted string
	 */
	public static String playfairEncryption(String plainText, String key) {
		String disallowedChars = "";
		String startOfArray = "";
		String encryptedWord = "";

		String inArraylphebet = "";
		int indexInAlpha = 0;

		for (int i = 0; i < key.length(); i++) {
			if (disallowedChars.indexOf(key.charAt(i)) == -1) {
				startOfArray += key.charAt(i);
				disallowedChars += key.charAt(i);
			}
		}

		String[][] keyArray = new String[8][8];

		inArraylphebet = startOfArray;

		for (int i = 0; i < 64; i++) {
			if (startOfArray.indexOf(alphebet.charAt(i)) == -1) {
				inArraylphebet += alphebet.charAt(i);
			}
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				keyArray[i][j] = Character.toString(inArraylphebet.charAt(indexInAlpha));
				indexInAlpha++;
			}
		}

		if (plainText.length() % 2 == 1) {
			plainText += "X";
		}

		for (int i = 1; i < plainText.length(); i += 2) {
			int rowOfFirstChar = inArraylphebet.indexOf(plainText.charAt(i - 1)) / 8;
			int columnOfFirstChar = inArraylphebet.indexOf(plainText.charAt(i - 1)) % 8;
			int rowOfSecondChar = inArraylphebet.indexOf(plainText.charAt(i)) / 8;
			int columnOfSecondChar = inArraylphebet.indexOf(plainText.charAt(i)) % 8;

			if (rowOfFirstChar == rowOfSecondChar) {
				encryptedWord += keyArray[rowOfFirstChar][(columnOfFirstChar + 1) % 8];
				encryptedWord += keyArray[rowOfFirstChar][(columnOfSecondChar + 1) % 8];
			} else if (columnOfFirstChar == columnOfSecondChar) {
				encryptedWord += keyArray[(rowOfFirstChar + 1) % 8][columnOfFirstChar];
				encryptedWord += keyArray[(rowOfSecondChar + 1) % 8][columnOfSecondChar];
			} else {
				encryptedWord += keyArray[rowOfFirstChar][columnOfSecondChar];
				encryptedWord += keyArray[rowOfSecondChar][columnOfFirstChar];
			}
		}

		return encryptedWord;
	}

	/**
	 * Decrypts a string using the Playfair cipher and the provided key.
	 * Reconstructs the same 8x8 key matrix used during encryption. Removes a
	 * trailing X from the decrypted text if one is present.
	 * 
	 * **@param** encryptedText the string to decrypt **@param** key the keyword
	 * used to construct the Playfair matrix **@return** the decrypted string
	 */
	public static String playfairDecryption(String encryptedText, String key) {
		String disallowedChars = "";
		String startOfArray = "";
		String decryptedWord = "";

		String inArraylphebet = "";
		int indexInAlpha = 0;

		for (int i = 0; i < key.length(); i++) {
			if (disallowedChars.indexOf(key.charAt(i)) == -1) {
				startOfArray += key.charAt(i);
				disallowedChars += key.charAt(i);
			}
		}

		String[][] keyArray = new String[8][8];

		inArraylphebet = startOfArray;

		for (int i = 0; i < 64; i++) {
			if (startOfArray.indexOf(alphebet.charAt(i)) == -1) {
				inArraylphebet += alphebet.charAt(i);
			}
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				keyArray[i][j] = Character.toString(inArraylphebet.charAt(indexInAlpha));
				indexInAlpha++;
			}
		}

		for (int i = 1; i < encryptedText.length(); i += 2) {
			int rowOfFirstChar = inArraylphebet.indexOf(encryptedText.charAt(i - 1)) / 8;
			int columnOfFirstChar = inArraylphebet.indexOf(encryptedText.charAt(i - 1)) % 8;
			int rowOfSecondChar = inArraylphebet.indexOf(encryptedText.charAt(i)) / 8;
			int columnOfSecondChar = inArraylphebet.indexOf(encryptedText.charAt(i)) % 8;

			if (rowOfFirstChar == rowOfSecondChar) {
				decryptedWord += keyArray[rowOfFirstChar][(columnOfFirstChar + 7) % 8];
				decryptedWord += keyArray[rowOfFirstChar][(columnOfSecondChar + 7) % 8];
			} else if (columnOfFirstChar == columnOfSecondChar) {
				decryptedWord += keyArray[(rowOfFirstChar + 7) % 8][columnOfFirstChar];
				decryptedWord += keyArray[(rowOfSecondChar + 7) % 8][columnOfSecondChar];
			} else {
				decryptedWord += keyArray[rowOfFirstChar][columnOfSecondChar];
				decryptedWord += keyArray[rowOfSecondChar][columnOfFirstChar];
			}
		}

		String newDecryptedWord = "";

		if (decryptedWord.endsWith("X")) {
			for (int i = 0; i < decryptedWord.length() - 1; i++) {
				newDecryptedWord += decryptedWord.charAt(i);
			}
		} else {
			newDecryptedWord = decryptedWord;
		}

		return newDecryptedWord;
	}

	/**
	 * Encrypts a string using the Caesar cipher by shifting each character forward
	 * by the given key within the allowed 64-character ASCII range.
	 * 
	 * **@param** plainText the string to encrypt **@param** key the number of
	 * positions to shift each character **@return** the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		String encryptedWord = "";

		for (int i = 0; i < plainText.length(); i++) {
			int plainIndex = (int) plainText.charAt(i) - 32;
			int encryptedIndex = (plainIndex + key) % 64 + 32;

			encryptedWord += Character.toString((char) encryptedIndex);
		}

		return encryptedWord;
	}

	/**
	 * Decrypts a string encrypted with the Caesar cipher by shifting each character
	 * backward by the given key within the allowed 64-character ASCII range.
	 * 
	 * **@param** encryptedText the string to decrypt **@param** key the number of
	 * positions to shift each character backward **@return** the decrypted string
	 */
	public static String caesarDecryption(String encryptedText, int key) {
		String decryptedWord = "";

		for (int i = 0; i < encryptedText.length(); i++) {
			int plainIndex = (int) encryptedText.charAt(i) - 32;
			int encryptedIndex = Math.floorMod(plainIndex - key, 64) + 32;

			decryptedWord += Character.toString((char) encryptedIndex);
		}

		return decryptedWord;
	}
}