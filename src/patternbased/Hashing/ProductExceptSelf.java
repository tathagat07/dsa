package patternbased.Hashing;

public class ProductExceptSelf {

    public static int[] productExceptSelfBrute(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0 ; i < n; i++){
            int product = 1;

            for(int j = 0 ; j< n; j++){
                if(i!=j){
                    product*=nums[j];
                }
            }
            result[i] = product;
        }

        return result;
    }

    public static int[] productExceptSelfOptimized(int[] nums){
        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] ans = new int[n];

        prefix[0] = 1;
        suffix[n-1] = 1;

        for(int i = 1; i< n; i++){
           prefix[i] = prefix[i-1] * nums[i-1];
        }

        for(int i = n-2; i >=0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for(int i = 0 ; i< n ; i++){
            ans[i] = prefix[i] * suffix[i];
        }

        return ans;
    }
    // TO-DO

    public static int[] productExceptSelfSpaceOptimized(int[] nums){
        int n = nums.length;

        int[] answer = new int[n];

        // Step 1: Store prefix products in answer
        answer[0] = 1;

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: Multiply by suffix products
        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {

            answer[i] *= suffix;

            suffix *= nums[i];
        }

        return answer;
    }


    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int[] result = new int[arr.length];
        //result = productExceptSelfBrute(arr);
        result = productExceptSelfOptimized(arr);
        for(int i = 0; i< result.length; i++){
            System.out.print(result[i]+" ");
        }
    }
}
