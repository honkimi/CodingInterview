package code.chap4;

import java.util.LinkedList;
import java.util.List;

import code.chap4.Interfaces.GraphIteratable;
import code.chap4.Interfaces.GraphIterator;

public class GraphNode implements GraphIteratable {


    public List<GraphNode> toNodes;
    public Object data;
    public boolean visited;

    public GraphNode(Object d) {
        toNodes = new LinkedList<GraphNode>();
        visited = false;
        this.data = d;
    }

    public void addToNode(GraphNode d) {
        toNodes.add(d);
    }

    @Override
    public GraphIterator graphIterator() {
        return new GraphIterator() {
            int index = 0;

            public boolean hasNext() {
                return index < toNodes.size();
            }

            public GraphNode next() {
                GraphNode next = toNodes.get(index);
                index++;
                return next;
            }
        };
    }
}
