package otherpeoplescode;

import java.util.ArrayList;
import java.util.Arrays;

public class StevenWord {
    public String string;
    public ArrayList<String> punc = new ArrayList<>(Arrays.asList("!?,.\";:".split("")));

    StevenWord(String string) {
        this.string = removePunc(string);
    }

    public String removePunc(String s){
        String newS = "";
        s=s.toLowerCase();
        ArrayList<String> sList = new ArrayList<>(Arrays.asList(s.split("")));
        for (String p:punc){
            if (sList.contains(p)){
                sList.remove(sList.indexOf(p));
            }
        }
        for (String c:sList){
            newS+=c;
        }
        return newS;
    }


    @Override
    public int hashCode() {
        return string.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StevenWord) {
            StevenWord other = (StevenWord) obj;
            if (this.string.equals(other.string)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return string;
    }
}
