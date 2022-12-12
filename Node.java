public class Node {
    
    // Anfang Attribute
    private double value;
    private Node nextNode;
    // Ende Attribute

    public Node(double value) {
        this.value = value;
        this.nextNode = null;
    }

    // Anfang Methoden
    public double getValue() {
        return value;
    }
    public Node getNextNode() {
        return nextNode;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
