public class Stack {
    
    // Anfang Attribute
    private Node head;
    // Ende Attribute

    public Stack() {
        this.head = null;
    }

    // Anfang Methoden
    public void push(double value) {
        Node newNode = new Node(value);
        newNode.setNextNode(head);
        head = newNode;
    }

    public double pop() {
        double value = head.getValue();
        head = head.getNextNode();
        return value;
    }
}
