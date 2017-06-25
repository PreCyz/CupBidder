package bidder.model.comparator;

import bidder.model.Score;

import java.util.Comparator;

/** Created by Gawa on 24/06/17.*/
public class ScoreComparator implements Comparator<Score> {

    private static ScoreComparator INSTANCE;

    private ScoreComparator() {}

    public static ScoreComparator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ScoreComparator();
        }
        return INSTANCE;
    }

    @Override
    public int compare(Score o1, Score o2) {
        return o1.getGame().getStartDateTime().compareTo(o2.getGame().getStartDateTime());
    }
}
