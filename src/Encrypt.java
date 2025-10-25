public class Encrypt {
    private static final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.,:!?«»\" ".toCharArray();
    public static char[] getAlphabet() {
        return alphabet;
    }
    public static String encryptText(String text, int key) {
        char[] symbol = text.toCharArray();
        for (int i = 0; i < symbol.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (symbol[i] == alphabet[j]) {
                    symbol[i] = alphabet[(j + key) % alphabet.length];
                    break;
                }
            }
        }
        return new String(symbol);
    }
}
