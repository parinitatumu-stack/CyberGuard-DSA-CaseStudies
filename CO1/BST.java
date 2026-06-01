class BSTNode {
    int key;
    BSTNode left, right;

    BSTNode(int item) {
        key = item;
        left = right = null;
    }
}

public class Main {

    BSTNode root;

    BSTNode insert(BSTNode root, int key) {
        if (root == null)
            return new BSTNode(key);

        if (key < root.key)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);

        return root;
    }

    BSTNode search(BSTNode root, int key) {
        if (root == null || root.key == key)
            return root;

        if (key < root.key)
            return search(root.left, key);

        return search(root.right, key);
    }

    void inorder(BSTNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {

        Main tree = new Main();

        int arr[] = {50, 30, 70, 20, 40, 60, 80};

        for (int x : arr)
            tree.root = tree.insert(tree.root, x);

        tree.inorder(tree.root);

        System.out.println("\nSearch 60 = "
                + (tree.search(tree.root, 60) != null));
    }
}
