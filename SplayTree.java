public class SplayTree {
    //Just a BST for now

    private Node root;

    public SplayTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    private Node insert(Node root, String data) {
        if (root == null) {
            root = new Node(data);
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

    public void insert(String data) {
        root = insert(root, data);
    }

    private Node delete(Node root, String data) {
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

    public void delete(String data) {
        root = delete(root, data);
    }

    private String min(Node root) {
        String min = root.getKey();
        while (root.getLeft() != null) {
            min = root.getLeft().getKey();
            root = root.getLeft();
        }
        return min;
    }

    private boolean find(Node root, String data) {
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

    public boolean search(String data) {
        return find(root, data);
    }

}
