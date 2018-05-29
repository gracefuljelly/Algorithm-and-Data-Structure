package Microsoft;
import java.util.*;


    public class MaxWaterTrappedI{
        public int maxTrapped(int[] height){
           int result =0;
           for(int i =0; i< height.length-1;i++){
               int leftMax=0;
               int rightMax=0;
               for (int j=i; j>=0; j--){
                   leftMax=Math.max(leftMax,height[j]);
               }
               for(int j=i; j<height.length;j++){
                   rightMax=Math.max(rightMax,height[j]);
               }
               result +=Math.min(leftMax,rightMax)-height[i];
           }
           return result;
        }

        public int[] dedup(int[] array) {
            // Write your solution here.
            int end = -1;
            for(int i=0;i<array.length;i++){
                if(end==-1||array[i]!=array[end]){
                    array[++end]=array[i]; //stack.push
                } else {
                    while(i+1<array.length&&array[i+1]==array[end]) {//stack.peek() == array[i+1]
                        i++;
                    }
                    end--;//stack.pop
                }
            }
            return Arrays.copyOf(array,end+1);
        }
        public static void main(String[] args){
            MaxWaterTrappedI solution = new MaxWaterTrappedI();
            int[] array = {1,2,2,2,4,3,3,4,2};
            System.out.println(solution.dedup(array));
        }
    }

