package Graph;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 1;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0; i<size;i++) {
                String cur = queue.poll();
                for (String w : wordList) {
                    if (!visited.contains(w) && isNextWord(cur, w)) {
                        if (w.equals(endWord)) {
                            return res+1;
                        }
                        queue.add(w);
                        visited.add(w);
                    }
                }
            }
            res++;
        }
        return 0;
    }


    public boolean isNextWord(String source, String target){
        for (int i = 0; i < source.length(); i++) {
            char[] chars = source.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;
                String candidate = new String(chars);

                if (candidate.equals(target)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        String[] words ={"a","b","c"};//{"hot","dot","dog","lot","log","cog"};;
        List<String> wordlist = new ArrayList<>(Arrays.asList(words));
        int ans=solution.ladderLength("a","c",wordlist);
        System.out.println(ans);
    }
}
