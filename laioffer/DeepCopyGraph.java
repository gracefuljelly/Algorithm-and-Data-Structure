package laioffer;
import java.util.*;

public class DeepCopyGraph {
    public List<GraphNode>  copy(List<GraphNode> graph){
        if(graph == null || graph.size()==0){
            return null;
        }
        Map<GraphNode, GraphNode> lookup = new HashMap<>();
        for(GraphNode node : graph){
            if(!lookup.containsKey(node)) {
                lookup.put(node,new GraphNode(node.key));
                helper(node,lookup);
            }
        }
        return new ArrayList<GraphNode>(lookup.values());
    }
    private void helper(GraphNode node, Map<GraphNode, GraphNode> lookup){
      GraphNode copy = lookup.get(node);
      for(GraphNode nei : node.neighbors){
          if(!lookup.containsKey(nei)){
              lookup.put(nei,new GraphNode(nei.key));
              helper(nei, lookup);
          }
          copy.neighbors.add(lookup.get(nei));
      }
    }
}
