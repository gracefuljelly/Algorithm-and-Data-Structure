package Graph;
/*
Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression. You can always assume that the given expression is valid and only consists of digits 0-9, ?, :, T and F (T and F represent True and False respectively).

Input: "T?2:3" Output: "2"

Note:

The length of the given string is ≤ 10000.
Each number will contain only one digit.
The conditional expressions group right-to-left (as usual in most languages).
The condition will always be either T or F. That is, the condition will never be a digit.
The result of the expression will always evaluate to either a digit 0-9, T or F.
* */
public class TernaryExpressionParser {
   public String parseTernary(String expression){
       if(expression==null||expression.length()==0){
           return expression;
       }
       char[] exp = expression.toCharArray();
       return dfs(exp,0,exp.length-1)+"";
   }

   private char dfs(char[] exp, int left, int right) {
       if(left==right){
           return exp[left];
       }
       int count=0;
       //why we keep the i out of the for loop? because we need it to partition
       int i=left;
       for(;i<=right;i++){
           if(exp[i]=='?'){
               count++;
           } else if(exp[i]==':'){
               count--;
               if(count==0){
                   break;
               }
           }
       }
       //left+2 skip the first :, i-1 stop before the first ?
       //i+1 skip the fist ?,right stop at right
       return exp[left]=='T'? dfs(exp,left+2,i-1):dfs(exp,i+1,right);
    }

    public static void main(String[] args) {
        String input="F?1:T?4:5";
        TernaryExpressionParser tep= new TernaryExpressionParser();
        System.out.println(tep.parseTernary(input));
    }
}
