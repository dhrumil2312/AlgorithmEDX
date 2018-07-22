package Trees;


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
        left = right = null;
    }
}


class BinarySearchTree{

    TreeNode root;

    public BinarySearchTree(){
        this.root = null;
    }

    void addNode(int val){
        root = addNodeHelper(root,val);
    }

    private TreeNode addNodeHelper( TreeNode node, int val){
        TreeNode newNode = new TreeNode(val);

        if(node == null){
            node = newNode;
            return node;
        }
        //System.out.println(node.val);
        if(node.val > val){
            node.left = addNodeHelper(node.left , val);
        }
        else if(node.val < val){
            node.right = addNodeHelper(node.right ,val);
        }
        return node;
    }


    private boolean contains(int val){
        if(root.val == val) return true;
        else{
            if(root.val < val){
                if(root.left != null) root = root.left;
                else return false;
            }
            else {
                if(root.right != null) root = root.right;
                else return false;
            }
        }
        return true;
    }



    void preOrderTraversal(){
        preOrderTraversalhelper(root);
    }

    private void preOrderTraversalhelper(TreeNode node){
        if(node != null) {
            System.out.println(node.val);
            if(root.left != null) preOrderTraversalhelper(node.left);
            if(root.right != null) preOrderTraversalhelper(node.right);
        }
    }

    void inOrderTraversal(){
        inOrderTraversalhelper(root);
    }

    void inOrderTraversalhelper(TreeNode node){
        if(node.left != null) inOrderTraversalhelper(node.left);
        System.out.println(node.val);
        if(node.right != null) inOrderTraversalhelper(node.right);
    }

    void postOrderTraversal(){
        postOrderTraversalhelper(root);
    }


     void postOrderTraversalhelper(TreeNode node){
        if(node.left != null) postOrderTraversalhelper(node.left);
        if(node.right != null) postOrderTraversalhelper(node.right);
        System.out.println(node.val);
    }


}

public class BinaryTree {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();


        tree.addNode(50);
        System.out.println("--------------------");
        tree.addNode(30);
        System.out.println("--------------------");
        tree.addNode(20);
        System.out.println("--------------------");
        tree.addNode(40);
        System.out.println("--------------------");
        tree.addNode(70);
        System.out.println("--------------------");
        tree.addNode(60);
        System.out.println("--------------------");
        tree.addNode(80);
//        System.out.println("--------------------");
//        tree.addNode(5);
//        System.out.println("--------------------");
//        tree.addNode(4);
//        System.out.println("--------------------");
//        tree.addNode(8);
//        System.out.println("--------------------");
//        tree.addNode(3);
//        System.out.println("--------------------");




        tree.preOrderTraversal();
        System.out.println("----------------------------");
        tree.inOrderTraversal();
        System.out.println("----------------------------");
        tree.postOrderTraversal();
    }


}
