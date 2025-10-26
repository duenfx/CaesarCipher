public class Decrypt {
    public static String decryptText(String text, int key) {
        char[] symbol = text.toCharArray();
        char[] alphabet = Encrypt.getAlphabet();
        for (int i = 0; i < symbol.length; i++) {
            boolean found = false;
            for (int j = 0; j < alphabet.length; j++) {
                if (symbol[i] == alphabet[j]) {
                    symbol[i] = alphabet[((j - key) + alphabet.length) % alphabet.length];
                    found = true;
                    break;
                }
            }
            if (!found) {
                symbol[i] = symbol[i];
            }
        }
        return new String(symbol);
    }
}
