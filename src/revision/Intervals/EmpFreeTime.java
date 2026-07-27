package revision.Intervals;

import java.util.ArrayList;
import java.util.List;

public class EmpFreeTime {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule){

        List<Interval> intervals = new ArrayList<>();
        // flatten
        for(List<Interval> employee : schedule){
            intervals.addAll(employee);
        }
        // sort by start time.
        intervals.sort((a,b) -> Integer.compare(a.start,b.start));

        List<Interval> merged = new ArrayList<>();
        merged.add(intervals.get(0));
        // Step 3: Merge intervals
        for(int i = 1; i < intervals.size(); i++){
            Interval current = intervals.get(i);

            Interval lastMerged = intervals.get(intervals.size() -1);

            if(current.start <= lastMerged.end){
                lastMerged.end = Math.max(current.end, lastMerged.end);
            } else {
                merged.add(current);
            }

        }

        // find gaps
        List<Interval> freeTime = new ArrayList<>();
        for(int i = 1 ; i < merged.size() ; i++){
            freeTime.add(new Interval(
                    merged.get(i-1).end,
                    merged.get(i).start
            ));
        }

        return freeTime;
    }
}
