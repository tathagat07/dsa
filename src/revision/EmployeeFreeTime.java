package revision;

import java.util.*;

public class EmployeeFreeTime {

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<Interval> findCommonFreeTime(
            List<List<Interval>> calendars,
            int startOfDay,
            int endOfDay,
            int duration) {

        List<Interval> busy = new ArrayList<>();

        // Collect all busy intervals
        for (List<Interval> employee : calendars) {
            busy.addAll(employee);
        }

        // Sort intervals
        busy.sort(Comparator.comparingInt(a -> a.start));

        // Merge intervals
        List<Interval> merged = new ArrayList<>();

        for (Interval interval : busy) {

            if (merged.isEmpty() ||
                    merged.get(merged.size() - 1).end < interval.start) {

                merged.add(new Interval(interval.start, interval.end));

            } else {

                merged.get(merged.size() - 1).end =
                        Math.max(merged.get(merged.size() - 1).end, interval.end);
            }
        }

        // Find free slots
        List<Interval> free = new ArrayList<>();

        int prev = startOfDay;

        for (Interval interval : merged) {

            if (interval.start - prev >= duration) {
                free.add(new Interval(prev, interval.start));
            }

            prev = Math.max(prev, interval.end);
        }

        // After last meeting
        if (endOfDay - prev >= duration) {
            free.add(new Interval(prev, endOfDay));
        }

        return free;
    }

    public static void main(String[] args) {

        List<List<Interval>> calendars = Arrays.asList(
                Arrays.asList(
                        new Interval(9,10),
                        new Interval(12,13),
                        new Interval(16,18)
                ),
                Arrays.asList(
                        new Interval(10,11),
                        new Interval(12,14),
                        new Interval(16,17)
                ),
                Arrays.asList(
                        new Interval(9,10),
                        new Interval(13,14),
                        new Interval(15,16)
                )
        );

        List<Interval> result =
                findCommonFreeTime(calendars, 9, 18, 1);

        for (Interval interval : result) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
    }
}