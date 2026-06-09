/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.isEmpty()) {
            return 0;
        }
        // intervals.sort(Comparator.comparingInt(p -> p.start));
        int result = 0;
        int maxEnd = 0;
        for(Interval interval : intervals) {
            maxEnd = Math.max(maxEnd, interval.end);
        }
        int[] differenceArray = new int[maxEnd+1];
        Arrays.fill(differenceArray, 0);
        for(Interval interval : intervals) {
            int start = interval.start;
            int end = interval.end;
            differenceArray[start]++;
            differenceArray[end]--;
        }
        int temp = 0;
        for(int count : differenceArray) {
            temp += count;
            result = Math.max(result, temp);
        }
        return result;
    }
}
