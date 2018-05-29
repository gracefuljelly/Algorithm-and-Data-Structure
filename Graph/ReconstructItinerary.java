package Graph;

import java.util.*;

/*
* Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
Input:[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
output:["JFK","MUC","LHR","SFO","SJC"]

*/
public class ReconstructItinerary {
    private LinkedList<String> route = new LinkedList<>();
    private int numTickets=0;
    private int numTicketsUsed=0;

    public List<String> findItinerary(String[][] tickets){
        HashMap<String, List<String>> map = new HashMap<>();
        getMap(tickets,map);
        route.add("JFK");
        dfs("JFK",map);
        return route;
    }

    private void dfs(String v,HashMap<String, List<String>> map) {
        if(!map.containsKey(v)){
            return;
        }
        List<String> list = map.get(v);
        for(int i=0; i<list.size();i++){
            String nei= list.get(i);
            list.remove(i);
            route.add(nei);
            numTicketsUsed++;
            dfs(nei,map);
            if(numTickets==numTicketsUsed){
                return;
            }
            list.add(i,nei);
            route.removeLast();
            numTicketsUsed--;
        }
    }

    public void getMap(String[][] tickets,HashMap<String, List<String>> route) {
        if(tickets==null||tickets.length==0){
            return;
        }
        for(int i=0; i<tickets.length;i++){
            if(!route.containsKey(tickets[i][0])){
                List<String> list= new LinkedList<>();
                list.add(tickets[i][1]);
                route.put(tickets[i][0],list);
            } else {
                route.get(tickets[i][0]).add(tickets[i][1]);
            }
        }
        for(Map.Entry<String,List<String>> e: route.entrySet()){
            Collections.sort(e.getValue());
        }
        return;
    }

}
