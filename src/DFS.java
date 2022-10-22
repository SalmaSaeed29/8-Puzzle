import java.util.*;

public class DFS extends Solver {
    Stack<Node> frontier;
    HashSet<Integer> frontierSet;
    Node state;
    public DFS(){
        super();
        frontier=new Stack<>();
        frontierSet = new HashSet<>();
    }
    /**
     * Search for the goal state using DFS algorithm.
     * @param initialState
     * starting state.
     * @param result
     * result object to store number of expanded
     * nodes in it.
     * @return
     * true if goal state is reached.
     * false otherwise.
     */
    @Override
    boolean search(Node initialState, Result result) {
        frontier.push(initialState);
        frontierSet.add(initialState.getState());
        //initialState.setDepth(0);
        //result.setMaxDepth(0);

        while(!frontier.isEmpty()){
            state=frontier.pop();
            frontierSet.remove(state.getState());
            explored.add(state.getState());
            if(goalTest(state)){
                getGoalNode().setParent(state.getParent());
                result.setNofNodes(explored.size());
                return true;
            }
            for(Node neighbor : state.children(true)){
                if(!explored.contains(neighbor.getState()) && !frontierSet.contains(neighbor.getState())) {
                    neighbor.setParent(state);
                    neighbor.setDepth(state.getDepth()+1);
                    frontier.add(neighbor);
                    frontierSet.add(neighbor.getState());
                    if(neighbor.getDepth()>result.getMaxDepth()){
                        result.setMaxDepth(neighbor.getDepth());
                    }
                }
            }
        }
        result.setNofNodes(explored.size());
        return false;
    }

}