package TopologySort;
import java.util.*;
public class AlineDictionary {


    /**
     * by Li Jie
     *
     * comment: 问题还是出在你对java core API的不熟悉以及使用前没有仔细考虑或查证具体API的含义
     */
    public class AlienDictionary {

        public String alienOrder(String[] words) {
            Map<Character, Set<Character>> graph = buildGraph(words);
            List<Character> res = new ArrayList<>();
            Set<Character> visited= new HashSet<>();
            Set<Character> visiting = new HashSet<>();
            for (Character cur : graph.keySet()){
                DFS(cur,res,visited,visiting, graph);
            }
             Collections.reverse(res);
             return res.toString();
        }

        private Map<Character, Set<Character>> buildGraph(String[] words){
            //sanity check
            Map<Character, Set<Character>> map = new HashMap<>();
            for(int i=0; i< words.length-1; i++){
                String a = words[i];
                String b = words[i+1];
                for(int j=0; j< Math.min(a.length(),b.length()); j++){
                    if (a.charAt(j)!=b.charAt(j)){
                        addNextCharInMap(map, a.charAt(j), b.charAt(j));
                        break;
                    }
                }
            }
            return map;
        }

        private void addNextCharInMap(Map<Character, Set<Character>> map, char c, char c1) {
            if (map.containsKey(c)){
                Set<Character> values = map.get(c);
                values.add(c1);
            }else{
            /* -> bug_1
             * 没有 new HashSet<>(char c) 这个API
             * 只有 new HashSet<>(int initialCapacity), 所以你这里传进来的参数 c 会被当作一个int使用
             */
                //Set<Character> processors = new HashSet<>(c1);
            /* -> fix bug_1
             */
                Set<Character> processors = new HashSet<>();
                processors.add(c1);


                map.put(c,processors);
            }
        }

        private boolean DFS(Character c, List<Character> res, Set<Character> visited, Set<Character> visiting, Map<Character,Set<Character>> graph){
            if(visited.contains(c)){
                return true;
            } else if (visiting.contains(c)) {
                return false;
            }
            visiting.add(c);
            if (graph.containsKey(c)) { /* -> bug_2: graph 里面可能没有 c */
                for (Character cc : graph.get(c)){
                    if(!DFS(cc,res,visited,visiting,graph)){
                        return false;
                    }
                }
            }
            visited.add(c);
            res.add(c);
            return true;
        }

        public void main(String[] args){
            String[] input={"wrt", "wrf", "er", "ett", "rftt"};
            AlienDictionary ad = new AlienDictionary();
            String output = ad.alienOrder(input);
            System.out.println(output);
        }

    }
}
