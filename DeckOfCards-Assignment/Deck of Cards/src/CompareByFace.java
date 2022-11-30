import java.util.Comparator;

public class CompareByFace implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {

        if (o1 instanceof FaceCard && o2 instanceof NumberCard) {

            return -1;

        }

        else if (o2 instanceof FaceCard && o1 instanceof NumberCard) {

            return 1;

        }

        return 0;

    }

}
