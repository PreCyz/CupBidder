package bidder.generators;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/** Created by Gawa on 18/06/17.*/
public final class IdGenerator {

    private IdGenerator() {}

    public static String generateId() {
        int value;
        SecureRandom random;
        try {
            random = SecureRandom.getInstance("SHA1PRNG");
            value = random.nextInt();
        } catch (NoSuchAlgorithmException e) {
            sun.security.provider.SecureRandom r = new sun.security.provider.SecureRandom();
            byte [] b = new byte[4];
            r.engineNextBytes(b);
            value = ((0xFF & b[0]) << 24) | ((0xFF & b[1]) << 16) |
                    ((0xFF & b[2]) << 8) | (0xFF & b[3]);
            System.out.println("Using a newly created SecureRandom object to generate tokens for captcha sessions: SHA1PRNG instance of SecureRandom was not found!");

        }
        value = Math.abs(value);
        return Integer.toString(value);
    }
}
