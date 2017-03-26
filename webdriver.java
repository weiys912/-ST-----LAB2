package webdrivertest;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class webdriver {
	public static Map<String, String> read() throws FileNotFoundException {
        File file = new File("/D:/»Ìº˛≤‚ ‘/inputgit.csv");

        Scanner scanner = new Scanner(file);
        Map<String, String> map = new HashMap<String, String>();
        String oneline;
        String[] words;
        while (scanner.hasNextLine()) {
            oneline = scanner.nextLine();
            words = oneline.split(",");
            map.put(words[0], words[2]);
        }
        scanner.close();
        return map;
    }
}
