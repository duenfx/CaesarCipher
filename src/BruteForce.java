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
}
