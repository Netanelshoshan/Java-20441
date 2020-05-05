

public class BinaryNode {
    private int value;
    private BinaryNode leftChild;
    private BinaryNode rightChild;

    public BinaryNode(int value, BinaryNode leftChild, BinaryNode rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryNode rightChild) {
        this.rightChild = rightChild;
    }

    //left,right,and then father
    public static void printTreePostOrder(BinaryNode current) {
        if (current.getLeftChild() != null)
            printTreePostOrder(current.getLeftChild());
        if (current.getRightChild() != null)
            printTreePostOrder((current.getRightChild()));
        System.out.println(current.getValue());
    }

    //left, father, right
    public static void printTreeInOrder(BinaryNode current) {
        if (current.getLeftChild() != null)
            printTreeInOrder(current.getLeftChild());
        System.out.println(current.getValue());
        if (current.getRightChild() != null)
            printTreeInOrder((current.getRightChild()));
    }

    public static void printTreePreOrder(BinaryNode current) {
        System.out.println(current.getValue());
        if (current.getLeftChild() != null)
            printTreePreOrder(current.getLeftChild());
        if (current.getRightChild() != null)
            printTreePreOrder(current.getRightChild());
    }

    //the number of NODES!!!!
    public static int countNodes(BinaryNode node) {
        if (node == null)
            return 0;
        return (1 + countNodes(node.getLeftChild()) + countNodes(node.getRightChild()));
    }

    public static int treeDepth(BinaryNode node) {
        if (node == null)
            return 0;
        else {
            int leftDepth = treeDepth(node.getLeftChild());
            int rightDepth = treeDepth(node.getRightChild());
            if (leftDepth > rightDepth)
                return (leftDepth + 1);
            else
                return (rightDepth + 1);
        }
    }

    /* Finding maximum number on a BINARY TREE . (right side always holds the big ones).*/
    public static BinaryNode g(BinaryNode root) {
        if (root == null)
            return null;
        if (root.getRightChild() == null)
            return null;
        return g(root.getRightChild());
    }

    /*
    This method will return the biggest value below num.
    if there ins't one , will return -1
     */
    public static int something(BinaryNode root, int num) {
        if (root == null)
            return -1;
        if (root.getValue() == num) {
            if (root.getLeftChild() == null)
                return -1;
            else
                return (g(root.getRightChild())).getValue();
        } else if (root.getValue() < num) {
            int k = something(root.getRightChild(), num); //25,37
            if (k == -1)
                return root.getValue();
            else
                return k;
        } else if (root.getValue() > num)
            return something(root.getLeftChild(), num);

        return -1;
    }

    public static boolean f(BinaryNode root, int num) {
        if (root == null) return false;
        if (root.getValue() == num) return true;
        return f(root.getLeftChild(), num) || f(root.getRightChild(), num);
    }

    public static int what(BinaryNode root, int x) {
        if (f(root, x))
            return secret(root, x);
        return 0;
    }

    public static int secret(BinaryNode root, int x) {
        if (root == null) return 0;

        if (
                (root.getLeftChild() != null && (root.getLeftChild()).getValue() == x)
                        || (root.getRightChild() != null && (root.getRightChild()).getValue() == x)) {
            return root.getValue() + secret(root.getLeftChild(), x) + secret(root.getRightChild(), x);
        }
        return secret(root.getLeftChild(), x) + secret(root.getRightChild(), x);
    }

    public static BinaryNode abc(BinaryNode root, BinaryNode p, BinaryNode q) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;
        BinaryNode left = abc(root.getLeftChild(), p, q);
        BinaryNode right = abc(root.getRightChild(), p, q);

        if (left != null && right != null)
            return root;
        if (left != null && right == null)
            return left;
        return right;
    }

    public static void w17ver90(BinaryNode node, int num) {
        if (node != null) {
            if (node.getValue() > num) {
                w17ver90(node.getLeftChild(), num);
                System.out.println(node.getValue());
                w17ver90(node.getRightChild(), num);
            }
            if (node.getValue() <= num)
                w17ver90(node.getRightChild(), num);
        }
    }

    public static void main(String[] args) {
        BinaryNode root;
        root = new BinaryNode(300,
                new BinaryNode(125,
                        new BinaryNode(100,
                                new BinaryNode(50,
                                        null, null),
                                null),
                        new BinaryNode(200,
                                new BinaryNode(150,
                                        null, new BinaryNode(170,
                                        null, null)),
                                new BinaryNode(250,
                                        null, null))),
                new BinaryNode(400,
                        null, new BinaryNode(450,
                        null, null)));
        System.out.println("The tree depth is: " + treeDepth(root));
        System.out.println("The number of nodes is: " + countNodes(root));
        w17ver90(root, 150);
    }


}