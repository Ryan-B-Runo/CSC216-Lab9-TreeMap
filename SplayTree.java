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
        splay(find(root, data), data);
    }

    private Node<T> delete(Node<T> root, T data) {
        if (root == null) {
            return null;
        }
        splay(find(root, data), data);
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

    private Node<T> find(Node<T> root, T data) {//returns the node where the data exists
        if (root == null) {
            return null;
        }else if(root.getKey().equals(data)) {
            return root;
        }else if(data.compareTo(root.getKey()) < 0) {
            return find(root.getLeft(), data);
        }else{
            return find(root.getRight(), data);
        }
    }

     public Node<T> find(T data) {
        splay(find(root, data), data);
        return find(root, data);
     }

    public boolean contains(T data) {//for testing
        return find(root, data) != null;
    }

    private Node<T> rightRotate(Node<T> root) {
        Node<T> temp = root.getLeft();
        root.setLeft(temp.getRight());
        temp.setRight(root);
        return temp;
    }

    private Node<T> leftRotate(Node<T> root) {
        Node<T> temp = root.getRight();
        root.setRight(temp.getLeft());
        temp.setLeft(root);
        return temp;
    }

    private Node<T> splay(Node<T> root, T data) {
        if(root == null || root.getKey() == data){
            return root;
        }
        if(root.getKey().compareTo(data) > 0) {
            if(root.getLeft() == null){
                return root;
            }
            if(root.getLeft().getKey().compareTo(data) > 0){
                root.getLeft().setLeft(splay(root.getLeft().getLeft(), data));
                root = rightRotate(root);
            }else if(root.getLeft().getKey().compareTo(data) < 0){
                root.getLeft().setRight(splay(root.getLeft().getRight(), data));
                if(root.getLeft().getRight() != null){
                    root.setLeft(leftRotate(root.getLeft()));
                }
            }
            if(root.getLeft() == null){
                return root;
            }else{
                return rightRotate(root);
            }
        }else{
            if(root.getRight() == null){
                return root;
            }
            if(root.getRight().getKey().compareTo(data) > 0){
                root.getRight().setLeft(splay(root.getRight().getLeft(), data));
                if(root.getRight().getLeft() != null){
                    root.setRight(rightRotate(root.getRight()));
                }
            }else if (root.getRight().getKey().compareTo(data) < 0){
                root.getRight().setRight(splay(root.getRight().getRight(), data));
                root = leftRotate(root);
            }
            if(root.getRight() == null){
                return root;
            }else{
                return leftRotate(root);
            }
        }
    }

}
