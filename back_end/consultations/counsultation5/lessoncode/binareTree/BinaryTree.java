package binareTree;

public class BinaryTree {

    private Node root;

    public Node find(int key) {

        Node current = root;

        while (current.getKey() != key) {
            if (current.getKey() < key ) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null){
                return null;
            }
        }
        return current;
    }

    public void insert(int key, String value) {
        Node newNode = new Node();
        newNode.setKey(key);
        newNode.setValue(value);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent = null;

            while (true) {
                parent = current;
                if (key == current.getKey()) {
                    return;
                } else if (key < current.getKey()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(newNode);
                        return;
                    }

                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(newNode);
                        return;
                    }
                }
            }

        }
    }

    public void print(Node node) {
        if (node != null) {
            print(node.left);
            node.printNode();
            print(node.right);
        }
    }

    private void print(){

    }

}
