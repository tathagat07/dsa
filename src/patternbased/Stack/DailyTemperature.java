package patternbased.Stack;

public class DailyTemperature {
    // brute
    public int[] dailyTemperature(int[] temperatures){
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i = 0 ; i< n ; i++){
            for (int j = i+1; j < n; j++){
                if(temperatures[j] > temperatures[i]){
                  ans[i] = j -i;
                  break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        DailyTemperature temperature = new DailyTemperature();

    }
}
