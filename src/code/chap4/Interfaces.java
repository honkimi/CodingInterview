package code.chap4;


public class Interfaces {
    public interface GraphIterator {
        boolean hasNext();
        GraphNode next();
    }

    public interface GraphIteratable {
        GraphIterator graphIterator();
    }


}
