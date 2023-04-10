import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }


    public void changeHamletToLeon(){
        Pattern pattern = Pattern.compile("HAMLET");
        Matcher matcher = pattern.matcher(hamletData);
        StringBuffer sb = new StringBuffer();
        String replacementText = "LEON";
        while(matcher.find()){
            matcher.appendReplacement(sb, replacementText);
                    }
    matcher.appendTail(sb);
        hamletData = sb.toString();

        Pattern pattern2 = Pattern.compile("Hamlet");
        Matcher matcher2 = pattern2.matcher(hamletData);
        StringBuffer sb2 = new StringBuffer();
        String replacementText2 = "Leon";
        while(matcher2.find()){
            matcher2.appendReplacement(sb2, replacementText2);
        }
        matcher2.appendTail(sb2);
        hamletData = sb2.toString();
    }

    public void changeHoratioToTariq() {
    }

    public int findHoratio() {
        return -1;
    }

    public int findHamlet() {
        return -1;
    }
}
