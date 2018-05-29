package DFS;

import com.intellij.openapi.diff.impl.processing.Word;

import java.util.*;

/*
* K V to get all the dictionary into count and List<String>
* DFS travel level by level
*            abcdefg
*         /  ...|  ... \
*      abcdef   abcdefg  abcdef
*      / |    \
*  abcde abcef
*  .
*  .
*  /
*  a
* wordSearchII
 * */

public class LongestValidString {
    public String getLongestValidWord(Set<String> dict){
        if(dict==null || dict.size()==0){
            return "";
        }
        //add memorization
        Map<String, Boolean> path = new HashMap<>();
        String longestString = "";
        for(String s: dict){
            if(dfsHelper(s,dict,path) && longestString.length()<s.length()){
                longestString=s;
            }
        }
        return longestString;
    }

    private boolean dfsHelper(String s, Set<String> dict, Map<String,Boolean> path){
        if(path.containsKey(s)){
            return path.get(s);
        }
        if(s.length()==1){
            return dict.contains(s);
        }
        boolean result = false;
        for(String str: nextPossibleWord(s,dict)){
            //?? Is this necessary?
            if(path.containsKey(str)){
                result |=path.get(str);
            }
                if(dict.contains(str)){
                    result |= dfsHelper(str, dict,path);
                }
        }
        path.put(s,result);
        return result;
    }

    private List<String> nextPossibleWord(String s, Set<String> dict){
        List<String> res = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            String temp= "";
            if(i==0){
                temp=s.substring(1);
            }else if(i==s.length()-1){
                temp=s.substring(0,s.length()-1);
            }else{
                temp= s.substring(0,i-1)+s.substring(i+1,s.length()-1);
            }
            if(dict.contains(temp)){
                res.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>(Arrays.asList("A","AL", "AK", "AAK","ALK","ALKB","ALKBD","ABCDEFG"));
        LongestValidString solution = new LongestValidString();
        System.out.println(solution.getLongestValidWord(dict));
    }
}



