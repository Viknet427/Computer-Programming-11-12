public class Word {

    private final String word;

    Word(String word) {

        this.word = removeNonLetters(word.toLowerCase());

    }

    public String getWord() {

        return word;

    }

    @Override
    public String toString() {

        return word;

    }

    public String removeNonLetters(String s) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            if (i == 0 && !Character.isAlphabetic(s.charAt(i))) {

                i++;

            }

            if (i <= s.length()-2) {

                if (s.substring(i, i+2).equals("'s")) {

                    stringBuilder.append(s.substring(i, i+2));
                    break;

                }

            }

            if (Character.isAlphabetic(s.charAt(i))) {

                stringBuilder.append(s.charAt(i));

            }

        }

        return stringBuilder.toString();

    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Word) {

            Word thisWord = new Word(removeNonLetters(this.word.toLowerCase()));
            Word otherWord = new Word(removeNonLetters(((Word)obj).toString().toLowerCase()));

            if (thisWord.toString().toLowerCase().equals(otherWord.toString().toLowerCase())) {

                return true;

            }

        }

        return false;

    }

    @Override
    public int hashCode() {

        return this.word.hashCode();

    }

}
