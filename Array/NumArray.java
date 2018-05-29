package Array;

public class NumArray {
    private  int[] prefixSum;// here can not be changed to prefix=

    public NumArray(int[] nums) {
        for(int i=1; i<nums.length-1;i++){
            nums[i]+=nums[i-1];
        }
        prefixSum=nums;
    }

    public int sumRange(int i, int j) {
        return prefixSum[j]-prefixSum[i];
    }

}


