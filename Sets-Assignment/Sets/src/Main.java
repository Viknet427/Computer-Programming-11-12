import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(new File("src/illiad.txt"));
        HashSet<Word> wordSet = new HashSet<>();
        while (scan.hasNext()) {

            wordSet.add(new Word(scan.next()));

        }

        for (Word word : wordSet) {

            System.out.println(word);

        }

        System.out.println("Number of Unique Words: " + wordSet.size());

    }

}
