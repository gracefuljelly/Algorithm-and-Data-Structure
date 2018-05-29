package laioffer.ArrayAndSortingAlgorithms;

import laioffer.GraphNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

public class SearchNDistance {
    //To do: build the graph

    public Deque<GraphNode> findAllVertexBFS (HashMap<GraphNode, List<GraphNode>> graph, GraphNode start, int targetdistance){
        //To do: sanity check
        Deque<GraphNode> queue = new LinkedList<>();
        queue.offer(start);
        int curdistance =0;
        while(!queue.isEmpty()){
            if(curdistance==targetdistance){
                return queue;
            }
            int size = queue.size();
            for(int i=0; i<size; i++){
                GraphNode cur = queue.poll();
                for(GraphNode node: cur.neighbors) {
                    queue.offer(node);
                }
            }
            curdistance++;
        }
        return null;
    }

    private class GraphNode {
        public int key;

        public List<GraphNode> neighbors;
        public GraphNode(int key) {
            this.key = key;
            this.neighbors = new ArrayList<GraphNode>();
        }
    }
}
