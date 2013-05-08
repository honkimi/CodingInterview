package code.chap4;

import code.chap4.Interfaces.GraphIterator;

/**
 * �L���O���t���^����ꂽ�Ƃ��A2�̃m�[�h�ԂɌo�H�����邩�ǂ�����������A���S���Y����݌v���Ă��������B
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

//    //BFS(breadth-first search)�ł̉񓚗�
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
 * DFS�̕����P���ȍċA�ŏ�����Ԃ�ABFS�Ɣ�ׂď����������P���B
 * BFS�͍ŒZ�o�H�������邱�Ƃ��ł������ADFS�ł͍ŏ��̃m�[�h�ɗאڂ���m�[�h��T������O�ɁA
 * ���Ȃ艓���܂ŒT�����Ă��܂��\��������B
*/