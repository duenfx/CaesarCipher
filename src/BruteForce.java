public class BruteForce {
    private boolean isReadable(String text) {
        text = text.toLowerCase();
        String[] commonWords = {" the ", " and ", " is ", " of ", " to ", " in ", " it ", " that ", " was "};
        int matches = 0;
        for (String word : commonWords) {
            if (text.contains(word)) {
                matches++;
            }
        }
        return matches >= 3;
    }
    public String bruteForceDecrypt(String encryptedText) {
        char[] alphabet = Encrypt.getAlphabet();
        for (int key = 1; key < alphabet.length; key++) {
            String decrypted = Decrypt.decryptText(encryptedText, key);
            if (isReadable(decrypted)) {
                System.out.println("Знайдено можливий ключ: " + key);
                return decrypted;
            }
        }
        return "Brute force не зміг знайти зрозумілий текст.";
    }
}
