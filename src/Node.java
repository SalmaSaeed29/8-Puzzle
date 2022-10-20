import java.util.LinkedList;
import java.util.List;

public class Node {
    int state = 0;
    double totalCost ;
    int cost = 0 ;
    Node parent ;
    static final int dimension = 3;
    public void setCost (int cost){
        this.cost = cost ;
    }
    public void setState (int state){
        this.state = state ;
    }
    public void setTotalCost (double totalCost){
        this.totalCost = totalCost ;
    }
    public void setParent (Node parent){
        this.parent = parent ;
    }
    public int getCost (){
        return this.cost ;
    }
    public int getState (){
        return this.state ;
    }
    public double getTotalCost (){
        return this.totalCost ;
    }
    public Node getParent (){
        return this.parent ;
    }

    public void swapIndexes (int first , int second){
        int[] stateArray = new int[9] ;
        String stateString = Integer.toString(this.state) ;
        if (stateString.length() != 9){
            stateString = '0' + stateString ;
        }
        for (int i=0 ; i<stateString.length() ; i++) {
            stateArray[i] = stateString.charAt(i) - '0';
        }
        int temp = stateArray[first] ;
        stateArray[first] = stateArray[second] ;
        stateArray[second] = temp ;
        int result = 0 ,count = 0 ;
        for (int i=stateArray.length-1 ; i>=0 ; i--) {
            result += stateArray[i] * Math.pow(10,count);
            count++;
        }
        this.state = result ;
    }
    public List<Node> children (){
        LinkedList<Node> children = new LinkedList<>() ;
        int[] stateArray = new int[9] ;
        String stateString = String.valueOf(getState()) ;
        if (stateString.length() != 9){
            stateString = '0' + stateString ;
        }
        int indexOfZero = -1 ;
        for (int i=0 ; i<stateString.length() ; i++){
            stateArray[i] = stateString.charAt(i) - '0' ;
            if (stateArray[i] == 0){
                indexOfZero = i ;
            }
        }
        if (indexOfZero > 2){     //can go up
            Node child = new Node() ;
            child.setState(this.state);
            child.swapIndexes(indexOfZero , indexOfZero - dimension);
            children.add(child);
        }
        if (indexOfZero < 6){     //can go down
            Node child = new Node() ;
            child.setState(this.state);
            child.swapIndexes(indexOfZero , indexOfZero + dimension);
            children.add(child);
        }
        if (indexOfZero % dimension == 0 || indexOfZero % dimension == 1){     //can go right
            Node child = new Node() ;
            child.setState(this.state);
            child.swapIndexes(indexOfZero , indexOfZero + 1);
            children.add(child);
        }
        if (indexOfZero % dimension == 1 || indexOfZero % dimension == 2){     //can go left
            Node child = new Node() ;
            child.setState(this.state);
            child.swapIndexes(indexOfZero , indexOfZero - 1);
            children.add(child);
        }
        return children;
    }
}
