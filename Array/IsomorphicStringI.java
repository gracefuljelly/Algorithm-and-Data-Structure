package Array;

import java.io.Console;
import java.util.Arrays;

/**
 * String 1:            A B E A C D B
 index pattern:         0 1 2 0 4 5 1
 String 2:              X Y I X H K Y
 index pattern:         0 1 2 0 4 5 1
 */


public class IsomorphicStringI {
    public boolean isIsomorphic(String s, String t){
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] ms = new int[256];
        int[] mt = new int[256];
        Arrays.fill(ms, -1);
        Arrays.fill(mt, -1);

        for(int i =  0; i < sc.length; i++){
            int is = sc[i];
            int it = tc[i];
            System.out.println(ms[is]);
            System.out.println(mt[it]);
            if(ms[is] != mt[it]) return false;
            ms[is] = i;
            mt[it] = i;
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStringI solution= new IsomorphicStringI();
        solution.isIsomorphic("egg","add");
    }
}
