package code.chap4;

import java.util.LinkedList;
import java.util.List;

public class GraphNode {
    public List<GraphNode> toNodes;
    public Object data;

    public GraphNode(Object d) {
        toNodes = new LinkedList<GraphNode>();
        this.data = d;
    }

    public void addToNode(GraphNode d) {
        toNodes.add(d);
    }
}
