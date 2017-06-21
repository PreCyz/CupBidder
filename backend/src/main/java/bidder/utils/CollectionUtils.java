package bidder.utils;

import java.util.Collection;

/** Created by Gawa on 21/06/17.*/
public final class CollectionUtils {

    private CollectionUtils() {}

    public static boolean nullOrEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }
}
