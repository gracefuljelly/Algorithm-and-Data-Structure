package Graph;
/*
* You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.

Example 1:
Input: [4, 1, 8, 7]
Output: True
Explanation: (8-4) * (7-1) = 24
Example 2:
Input: [1, 2, 1, 2]
Output: False
Note:
The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.
*
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwentyFourPointsGame {
    boolean res = false;
    final double eps =0.001;//Why do we need this?

    public boolean judgePoint24(int[] nums) {
        List<Double> array = new ArrayList<>();
        for(int n: nums){
            array.add((double)n);
        }
        dfs(array);
        return res;
    }

    private void dfs(List<Double> array){
        if(res) return;
        if(array.size()==1){
            if(Math.abs(array.get(0)-24.0)<eps){
                res=true;
            }
            return;
        }
        for(int i=0; i<array.size();i++){
            for(int j=0; j<i;j++){
                List<Double> next= new ArrayList<>();
                Double p1= array.get(i);
                Double p2= array.get(j);
                next.addAll(Arrays.asList(p1+p2,p1-p2,p2-p1,p1*p2));
                if(Math.abs(p1)>eps){
                    next.add(p2/p1);
                }
                if(Math.abs(p2)>eps){
                    next.add(p1/p2);
                }
                array.remove(i);
                array.remove(j);

                for(Double n: next){
                    array.add(n);
                    dfs(array);
                    array.remove(array.size()-1);
                }
                //Why the sequence the other way lead to Out-of-Bound?
                array.add(j,p2);
                array.add(i,p1);

            }
        }

    }
}
