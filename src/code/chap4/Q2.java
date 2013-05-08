package code.chap4;

import code.chap4.Interfaces.GraphIterator;

/**
 * 有向グラフが与えられたとき、2つのノード間に経路があるかどうかを見つけるアルゴリズムを設計してください。
 *
 * @author kiminari.homma
 *
 */
public class Q2 {

    public static boolean hasRootTo(GraphNode n1, GraphNode n2) {
        if (n1.data.equals(n2.data)) {
            return true;
        }

        n1.visited = true;
        GraphIterator iterator = n1.graphIterator();
        do {
            GraphNode next = iterator.next();
            if (!next.visited) {
                if (hasRootTo(next, n2))
                    return true;
            }
        } while (iterator.hasNext());
        return false;
    }

    enum State {
        Unvisited, Visited, Visiting;
    }

//    //BFS(breadth-first search)での回答例
//    public static boolean search(Graph g, Node start, Node end) {
//        LinkedList<Node> q = new LinkedList<Node>();
//        for (Node u : g.getNodes()) {
//            u.state = State.Unbvisited;
//        }
//        start.state = State.Visiting;
//        q.add(start);
//        Node u;
//        while(!q.isEmpty()) {
//            u = q.removeFirst();
//            if (u != null) {
//                for (Node v : u.getAdjacent()) {
//                    if (v.state == State.Unvisited) {
//                        if (v == end) {
//                            return true;
//                        } else {
//                            v.state = State.Visiting;
//                            q.add(v);
//                        }
//                    }
//                }
//                u.state = State.Visited;
//            }
//        }
//        return false;
//    }
}


/*
 * MEMO:
 * DFSの方が単純な再帰で書けるぶん、BFSと比べて少し実装が単純。
 * BFSは最短経路を見つけることもできる一方、DFSでは最初のノードに隣接するノードを探索する前に、
 * かなり遠くまで探索してしまう可能性がある。
*/