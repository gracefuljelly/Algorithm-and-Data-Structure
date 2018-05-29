package Array;
/*
* find the minimum largest value for subarrays
*                            7
*                   7+2                            2
*             7+2+5           5               2+5                 5
*     7+2+5+10    10      5+10  10    2+5+10     10     5+10       10
* 7+2+5+10+8  8 10+8 8  5+10+8 8  2+5+10+8 8  10+8  8  5+10+8 8 10+8    8
*
*
*
*
*
* */

import java.util.Arrays;

public class SplitArrayLargestSum {
    int min=Integer.MAX_VALUE;
    public int splitArrayI(int[] nums, int M) {
        if(nums==null || nums.length==0){
            return 0;
        }
        dfs(nums,0,M,0,0);
        return min;
    }

    private void dfs(int[] nums, int index, int partition, int curMax, int curSum){
        if(index == nums.length && partition==0){
            //finished partition and update result
            min=Math.min(min,curMax);
            return;
        }
        if(index==nums.length){
            return;
        }
        //bug 1
        if(index>0){
            dfs(nums,index+1,partition,Math.max(curMax,curSum+nums[index]),curSum+nums[index]);
        }
        //bug 2
        if(partition>0){
            dfs(nums,index+1,partition-1,Math.max(curMax,nums[index]),nums[index]);
        }
    }

    public int splitArrayII(int[] nums, int M){
        if(nums==null || nums.length==0){
            return 0;
        }
        int[] preSum = new int[nums.length+1];
        for(int i=0; i<nums.length;i++){
            preSum[i+1]=preSum[i]+nums[i];
        }
        //state: dp[i][j] minimum of all max subarray sum for array end at nums[i] with j partitions
        int[][] dp = new int[nums.length+1][M+1];
        //bug:should prepopulate the max value
        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= M; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        /*transformation state: dp[i][j]= min{ dp[i][j],max(dp[k][j-1],preSum[i]-preSum[k]}}
        * base: dp[0][0]=0
        * result: dp[nums.length][M]
        * */
        dp[0][0]=0;
        for(int i=1;i<=nums.length;i++){
            for(int j=1; j<=M;j++){
                for(int k=0; k<i;k++){
                    dp[i][j]=Math.min(dp[i][j],Math.max(dp[k][j-1],preSum[i]-preSum[k]));
                }
            }
        }
        return dp[nums.length][M];
    }

    //the range is between largest element and total sum
    //when we try partition, if add the nums[i] make the subarray sum over the mid, then we cut it
    //if the partition is over what is allowed then we partitioned too much so this value tends to fall closer to the total sum
    //if the partition is less than what is allowed then we can partition more means this value should be closer to max element
    public int splitArrayIII(int[] nums, int M){
        if(nums==null || nums.length==0){
            return 0;
        }
        int maxElement = Integer.MIN_VALUE;
        int sum=0;

        for(int i=0; i<nums.length;i++){
            maxElement = Math.max(maxElement,nums[i]);
            sum +=nums[i];
        }
        int left=maxElement;
        int right=sum;
        int res=sum;
        while(left<=right){
            int mid = left+(right-left)/2;//this is the candidate for this round
            int runningTotal =0;
            int partition=1;
            for(int i=0; i<nums.length;i++){
                //Key: make sure all subarray sum is less than mid,our res candidate
                if(runningTotal+nums[i]>mid){
                    runningTotal=nums[i];
                    partition++;
                }else {
                    runningTotal+=nums[i];
                }
            }
            if(partition>M){
                left=mid+1;
            }else {
                res =Math.min(res,mid);
                right=mid-1;
            }
        }
       return res;
    }


    public static void main(String[] args) {
        int[] nums= {1,2147483647};
        SplitArrayLargestSum solution = new SplitArrayLargestSum();
        System.out.println(solution.splitArrayIII(nums,2));
    }
}
