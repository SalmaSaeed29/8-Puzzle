import java.util.List;


public class Result {

    public Result() {

    }

    //the path from start state to the goal
    private List<Node> path;

    //number of node expanded
    private int nofNodes;


    private int MaxDepth;

    private long time;


    /*public Result(int nodesExpanded, long time, List<Node> path) {
        this.nofNodes = nodesExpanded;
        this.time = time;
        this.path = path;

    }*/

    public int getNofNodes() {
        return nofNodes;
    }

    public void setNofNodes(int nofNodes) {
        this.nofNodes = nofNodes;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }


    public int Cost() {
        return path.size() - 1;
    }


    public List<Node> getPath() {
        return path;
    }

    public void setPath(List<Node> path) {
        this.path = path;
    }

    public int getMaxDepth() {
        return MaxDepth;
    }

    public void setMaxDepth(int MaxDepth) {
        this.MaxDepth = MaxDepth;
    }
}
