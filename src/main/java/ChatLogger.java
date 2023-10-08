import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ChatLogger {

    private StringBuilder sB;

    public static void logToFile (String textForLog) {
        try(FileWriter writer = new FileWriter("log.txt", true))
        {
            writer.write(textForLog);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public String logReader () {
        try(FileReader reader = new FileReader("log.txt"))
        {
            sB = new StringBuilder();
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                sB.append(sc.nextLine()).append("\n");
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        if (sB != null) {
            return sB.toString();
        }
        return "";
    }
}
