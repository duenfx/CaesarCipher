import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class CLI {
    public void start(String[] args) {
        String command = args[0];
        String filePath = args[1];
        String key = args.length > 2 ? args[2] : null;
        Path path = Path.of(filePath);
        if (!Files.exists(path)) {
            System.out.println("Файл не знайдено!");
            return;
        }
        try {
            String content = FileService.readFile(path);
            if (command.equalsIgnoreCase("ENCRYPT")) {
                if (key == null) {
                    System.out.println("Відсутній ключ для ENCRYPT!");
                    return;
                } else {
                    int newKey = Integer.parseInt(key);
                    String encrypted = Encrypt.encryptText(content, newKey);
                    FileService.writeFile(path, encrypted, "ENCRYPT");
                    System.out.println("Текст зашифровано. Перевірте створений файл.");
                }
            } else if (command.equalsIgnoreCase("DECRYPT")) {
                if (key == null) {
                    System.out.println("Відсутній ключ для DECRYPT!");
                    return;
                } else {
                    int newKey = Integer.parseInt(key);
                    String decrypted = Decrypt.decryptText(content, newKey);
                    FileService.writeFile(path, decrypted, "DECRYPT");
                    System.out.println("Текст розшифровано. Файл збережено.");
                }
            } else if (command.equalsIgnoreCase("BRUTE_FORCE")) {
                BruteForce bruteForce = new BruteForce();
                String result = bruteForce.bruteForceDecrypt(content);
                FileService.writeFile(path, result, "BRUTE_FORCE");
                System.out.println("Brute force виконано. Перевірте створений файл.");
            } else {
                System.out.println("невідома команда: " + command);
            }
        } catch (NumberFormatException e) {
            System.out.println("Ключ має бути цілим числом: " + key);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
