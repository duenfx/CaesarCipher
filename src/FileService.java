import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {
    public static String readFile(Path path) throws IOException {
        return Files.readString(path);
    }
    public static void writeFile(Path originalPath, String text, String mode) throws IOException {
        String fileName = originalPath.getFileName().toString();
        int index = fileName.lastIndexOf(".");
        String name = (index != -1) ? fileName.substring(0, index) : fileName;
        String extension = (index != 1) ? fileName.substring(index) : "";
        String suffix = "";
        if (mode.equalsIgnoreCase("ENCRYPT")) {
            suffix = "[ENCRYPTED]";
        } else if (mode.equalsIgnoreCase("DECRYPT")) {
            suffix = "[DECRYPTED]";
        } else if (mode.equalsIgnoreCase("BRUTE_FORCE")) {
            suffix = "[BRUTE_FORCED]";
        }
    }
}
