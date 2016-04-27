package vn.creative.instagram.photoviewer.common;

/**
 * Created by tanlnm on 3/14/2016.
 */
public class TimeUtils {
    private static final long MINUTE = 60;
    private static final long HOUR = 60 * MINUTE;
    private static final long DAY = 24 * HOUR;
    private static final long WEEK = 7 * DAY;

    public static String calculateTime(long time) {
        long curTime = System.currentTimeMillis() / 1000L;
        long gapTime = curTime - time;

        if (gapTime < MINUTE) {
            return "a minute ago";

        } else if (gapTime < HOUR) {
            return gapTime / MINUTE + "min ago";

        } else if (gapTime < DAY) {
            return gapTime / HOUR + "h ago";

        } else if (gapTime < WEEK) {
            return gapTime / DAY + "d ago";

        } else {
            return gapTime / WEEK + "w ago";

        }
    }
}
