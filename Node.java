public class Node {
    private String key;
    private Node left, right;

    public Node(String key){
        this.key = key;
        left = right = null;
    }

    public String getKey() {
        return key;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
