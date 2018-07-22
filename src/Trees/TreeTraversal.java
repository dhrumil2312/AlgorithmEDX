package Trees;

class Node{
    private int val;
    private Node left, right;
    public Node(int data){
        this.val = data;
    }

    public void insert(int val){
        if(val <= this.val) {
            if (left == null) {
                left = new Node(val);
            } else {
                left.insert(val);
            }
        } else{
            if(right == null){
                right = new Node(val);
            } else{
                right.insert(val);
            }
        }
    }

    public boolean contains(int val){
        if(this.val == val ) return true;
        if(val < this.val){
            if(left == null) return false;
            else left.contains(val);
        } else{
            if(right == null) return false;
            else right.contains(val);
        }
        return true;
    }

    public void preOrderTraversal(){
        System.out.println(this.val);
        if(left != null) left.preOrderTraversal();
        if(right != null) right.preOrderTraversal();
    }


    public void inOrderTraversal(){
        if(left != null) left.inOrderTraversal();
        System.out.println(this.val);
        if(right != null) right.inOrderTraversal();
    }

    public void postOrderTraversal(){
        if(left != null) left.postOrderTraversal();
        if(right != null) right.postOrderTraversal();
        System.out.println(this.val);
    }

}

public class TreeTraversal {
    public static void main(String[] args) {

    }

}
