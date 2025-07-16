public class SplayTree {
    //Just a BST for now

    Node root;

    public SplayTree() {
        root = null;
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

}
