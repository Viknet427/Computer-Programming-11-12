public class Letter {

    char letter;

    Letter(char letter) {

        this.letter = letter;

    }

    @Override
    public int hashCode() {

        return (int) letter - 97;

    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Letter) {

            Letter other = (Letter) obj;
            if (this.letter == other.letter) {

                return true;

            }

        }

        return false;

    }

    @Override
    public String toString() {

        return String.valueOf(letter);

    }

}
