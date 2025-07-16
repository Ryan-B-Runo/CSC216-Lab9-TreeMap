public class SplayTree<T extends Comparable<T>> {
    //Just a BST for now

    private Node<T> root;

    public SplayTree() {
        root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    private Node<T> insert(Node<T> root, T data) {
        if (root == null) {
            root = new Node<>(data);
            return root;
        }else{
            if(data.compareTo(root.getKey()) < 0) {
                root.setLeft(insert(root.getLeft(), data));
            }else if(data.compareTo(root.getKey()) > 0) {
                root.setRight(insert(root.getRight(), data));
            }
            return root;
        }
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> delete(Node<T> root, T data) {
        if (root == null) {
            return root;
        }
        if (data.compareTo(root.getKey()) < 0) {
            root.setLeft(delete(root.getLeft(), data));
        }else if(data.compareTo(root.getKey()) > 0) {
            root.setRight(delete(root.getRight(), data));
        }else{
            if(root.getLeft() == null){
                return root.getRight();
            }else if(root.getRight() == null){
                return root.getLeft();
            }
            root.setKey(min(root.getRight()));
            root.setRight(delete(root.getRight(), data));
        }
        return root;
    }

    public void delete(T data) {
        root = delete(root, data);
    }

    private T min(Node<T> root) {
        T min = root.getKey();
        while (root.getLeft() != null) {
            min = root.getLeft().getKey();
            root = root.getLeft();
        }
        return min;
    }

    private boolean find(Node<T> root, T data) {
        if (root == null) {
            return false;
        }else if(root.getKey().equals(data)) {
            return true;
        }else if(data.compareTo(root.getKey()) < 0) {
            return find(root.getLeft(), data);
        }else{
            return find(root.getRight(), data);
        }
    }

    public boolean search(T data) {
        return find(root, data);
    }

}
