package patternbased.Intervals;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFreeTime {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule){
        List<Interval> intervals = new ArrayList<>();

        // Step 1: Flatten all employee schedules
        for(List<Interval> employee : schedule ){
            intervals.addAll(employee);
        }

        // Step 2: Sort by start time
        intervals.sort((a,b) -> Integer.compare(a.start,b.start));

        List<Interval> merged = new ArrayList<>();
        // Step 3: Merge intervals
        merged.add(intervals.get(0));

        for(int i = 1; i < intervals.size() ; i++){
            Interval current = intervals.get(i);
            Interval lastMerged = intervals.get(merged.size() -1);

            if(current.start <= lastMerged.end){
                lastMerged.end = Math.max(current.end, lastMerged.end);
            } else {
                merged.add(current);
            }
        }
        // Step 4: Find gaps
        List<Interval> freeTime = new ArrayList<>();
        for(int i = 1; i < merged.size(); i++){
            freeTime.add(new Interval(
                    merged.get(i-1).end,
                    merged.get(i).start
            ));
        }

        return freeTime;
    }
}
