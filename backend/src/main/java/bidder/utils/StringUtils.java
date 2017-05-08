package bidder.utils;

/** Created by gawa on 2017-05-08. */
public final class StringUtils {

	private StringUtils(){}

	public static boolean empty(String value) {
		return value == null || value.isEmpty();
	}
}
