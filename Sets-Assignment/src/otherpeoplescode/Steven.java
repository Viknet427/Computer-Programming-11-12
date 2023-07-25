package otherpeoplescode;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Steven {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("src/xilliad.txt"));
        HashSet<String> tempStrings = new HashSet<>();
        HashSet<StevenWord> stevenWordSet = new HashSet<>();
        while (scan.hasNext()) {
            tempStrings = new HashSet(Arrays.asList(scan.nextLine().split(" ")));
            for (String s : tempStrings) {
                stevenWordSet.add(new StevenWord(s));
            }
        }

        Iterator<StevenWord> iter = stevenWordSet.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("Total unique words: " + stevenWordSet.size());
    }
}
