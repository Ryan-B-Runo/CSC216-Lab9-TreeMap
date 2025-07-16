public class Driver {
    public static void main(String[] args) {

        SplayTree s = new SplayTree();
        s.insert("a");
        s.insert("b");
        s.insert("c");

        s.delete("a");
        s.delete("b");

        System.out.println(s.search("a"));
        System.out.println(s.search("b"));
        System.out.println(s.search("c"));
        System.out.println(s.search("d"));

//        TreeMap map = new TreeMap();
//
//        // Insert a number of key-value pairs into the tree map
//        map.insert("keyOne", "valueOne");
//        map.insert("keyTwo", "valueTwo");
//        map.insert("keyThree", "valueThree");
//
//        // Prints out valueOne
//        System.out.println(map.get("keyOne"));
//
//        // Prints out valueThree
//        System.out.println(map.get("keyThree"));
//
//        // Prints out an empty string or some default value of your choice
//        System.out.println(map.get("keyDoesNotExist"));
//
//        // Deletes the key-value pair from the tree map
//        System.out.println(map.delete("keyOne"));
    }
}
