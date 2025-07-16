public class Node<T> {
    private T key;
    private Node<T> left, right;

    public Node(T key){
        this.key = key;
        left = right = null;
    }

    public T getKey() {
        return key;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}
