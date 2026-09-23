package utility;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private static final AtomicLong currTime = new AtomicLong(System.currentTimeMillis());

    public static String generateTimestampId() {
        return Long.toString(currTime.incrementAndGet(), Character.MAX_RADIX);
    }
}
