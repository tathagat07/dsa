package patternbased.BinarySearch;

public class PaintersPartition {

    public int paint(int[] boards, int painters){
        int left = 0;
        int right = 0;

        for(int board : boards){
            left = Math.max(left,board);
            right += board;
        }

        while(left < right){
            int mid = left + (right - left) / 2;

            if(canPaint (boards, painters, mid)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canPaint(int [] boards, int painters, int maxWork){
        int painterCount = 1;
        int currentWork = 0;

        for(int board: boards){
            if(currentWork + board > maxWork){
                painterCount++;
                currentWork = 0 ;
            }
            currentWork +=board;
        }

        return painterCount <= painters;
    }

    public static void main(String[] args) {
        PaintersPartition partition = new PaintersPartition();
        int[] arr = {5, 10, 30, 20, 15};
        int k = 3;
        int result = partition.paint(arr, k);
        System.out.println(result);
    }
}
