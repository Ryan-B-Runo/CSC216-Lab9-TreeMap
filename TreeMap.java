public class TreeMap {
    private SplayTree<KeyValuePair> tree;

    public TreeMap() {
        this.tree = new SplayTree<>();
    }

    public void insert(String key, String value) {
        tree.insert(new KeyValuePair(key, value));
    }

    private KeyValuePair get(Node<KeyValuePair> root, String key) {
        if(root == null) {
            return new KeyValuePair("[null]", "[null]");
        }else if(key.equals(root.getKey().getKey())) {
            return root.getKey();
        }else if(key.compareTo(root.getKey().getKey()) < 0) {
            return get(root.getLeft(), key);
        }else{
            return get(root.getRight(), key);
        }
    }

    public String get(String key) {
        return get(tree.getRoot(), key).getValue();
    }

    public KeyValuePair getPair(String key) {
        return get(tree.getRoot(), key);
    }
}