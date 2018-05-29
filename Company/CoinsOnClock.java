package Company;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CoinsOnClock {
char[] coins = {'P','N','D'};
int[]  steps={1,5,10};
int notInit =-1;
int clock=12;

    public void nextStep(Map<String, String> res, String s, int pcount, int ncount, int dcount){
        int[] visited= new int[12];
        Arrays.fill(visited,notInit);
        if(isValid(res,s,pcount,ncount,dcount,visited)){
            if(s.length()==12){
                StringBuilder sb= new StringBuilder();
                for(int i=0; i<12;i++){
                    sb.append(coins[visited[i]]);
                }
                res.put(s,sb.toString());
            }
            nextStep(res,s+"P",pcount-1,ncount,dcount);
            nextStep(res,s+"N",pcount,ncount-1,dcount);
            nextStep(res,s+"D",pcount,ncount,dcount-1);
        }
    }

    private boolean isValid(Map<String,String> res, String s, int pcount, int dcount,int ncount, int[] visited){
        if(pcount<0||ncount<0||dcount<0){
            return false;
        }
        char[] sArray= s.toCharArray();
        int n=sArray.length;
        int index=0;
        int curCoin=0;
        for(int i=0; i<n;i++){
            if(sArray[i]=='P'){
                index+=1;
                curCoin=0;
            }else if(sArray[i]=='N'){
                index+=5;
                curCoin=1;
            }else if(sArray[i]=='D'){
                index+=10;
                curCoin=2;
            }
            if(visited[index%12]==-1){
                visited[index%12]=curCoin;
            }else{
                return false;
            }
        }
        return true;
    }
}
