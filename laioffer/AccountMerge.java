package laioffer;
import java.util.*;



public class AccountMerge {
    private class graphNode {
        String email;
        String user;
        List<graphNode> neighbors;
        graphNode(String email, String user){
            this.email=email;
            this.user=user;
            neighbors=new ArrayList<>();
        }
    }
/*
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        Map<String,graphNode> map= new HashMap<>();
        buildGraph(accounts,map);
        
        Set<String> visited = new HashSet<>();
        for(String e : map.keySet()){
            if(visited.add(e)){

            }
        }
    }
*/
    private void dfs(graphNode node, Set<String> visited, List<String> list) {
        for(graphNode n: node.neighbors ){
            if(visited.add(node.email)){
                list.add(node.email);
                dfs(node, visited,list);
            }
        }
    }

    private void buildGraph(List<List<String>> accounts, Map<String,graphNode> map) {
        for(List<String> list : accounts){
            for(int i=0; i<list.size(); i++){
                String email= list.get(i);
                if(!map.containsKey(email)){
                    graphNode node = new graphNode(email, list.get(0));
                    map.put(email,node);
                }
                map.get(list.get(i)).neighbors.add(map.get(email));
                map.get(email).neighbors.add(map.get(list.get(i)));
            }
        }
    }

    
}
