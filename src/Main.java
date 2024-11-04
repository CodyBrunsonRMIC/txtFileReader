import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int startSubString = 0;
        int endSubString = 0;
        System.out.println("Put a file path to read.");
        Scanner inScanner = new Scanner(System.in);
        String fileToRead = inScanner.nextLine().replaceAll("\"", "");
        if (fileToRead.isEmpty()) {
            return;
        }
        while (true) {
            System.out.print("");
            System.out.println("To read characters from a start to EOL just put the start number.");
            System.out.println("To read characters from a start to a end point, but two numbers comma seperated.");
            System.out.println("Put nothing to exit.");
            String substringToRead = inScanner.nextLine();
            if (substringToRead.isEmpty()) return;
            if (substringToRead.indexOf(',') > 0) {
                String[] subStrings = substringToRead.split(",");
                startSubString = Integer.parseInt(subStrings[0]);
                endSubString = Integer.parseInt(subStrings[1]);
            } else {
                startSubString = Integer.parseInt(substringToRead);
                endSubString = -1;
            }
            try {
                File file = new File(fileToRead);
                BufferedReader br = new BufferedReader(new FileReader(fileToRead));
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.isEmpty()) continue;
                    if (endSubString != -1) {
                        System.out.println(line.substring(startSubString, endSubString));
                    } else {
                        System.out.println(line.substring(startSubString));
                    }
                }
                br.close();
            } catch (FileNotFoundException fnfe) {
                System.out.println("That file doesn't exist...");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}