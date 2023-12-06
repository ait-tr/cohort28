package binareTree;

public class TreeDemo {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(1, "node 1");
        binaryTree.insert(4, "node 4");
        binaryTree.insert(3, "node 3");
        binaryTree.insert(2, "node 2");

        binaryTree.print(binaryTree.find(1));

    }
}
