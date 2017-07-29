import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReadWriteTest {

    String inputFile = "C:/Users/Gamer/Desktop/input.txt";
    String outputFile = "C:/Users/Gamer/Desktop/output.txt";

    @Test
    public void ReadAndWriteTest() throws Exception {

// JAVA 8
        try (Stream<String> input = Files.lines(Paths.get(inputFile))) {
            input.forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String output = "Dummy Text..";

        Files.write(Paths.get(outputFile),output.getBytes());

// JAVA 7
        try (BufferedReader br = new BufferedReader(new FileReader(outputFile))){
            List<String> inputLines = new ArrayList<>();
            String inputLine;
            while((inputLine = br.readLine()) != null){
                inputLines.add(inputLine);
            }
            inputLines.forEach(System.out::println);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }


}
