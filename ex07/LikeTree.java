package ex07;

public class LikeTree {
    private Node root;

    private class Node {
        int data;
        Node parent;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            parent = null;
            left = null;
            right = null;
        }
    }

    public void insert(int data) {
        if(root == null) {
            root = new Node(data);
        }
        else {
            insert(root, data);
        }
    }

    public void insert(Node temp, int data) {
        if(data < temp.data) {
            if(temp.left == null) {
                temp.left = new Node(data);
            }
            else {
                insert(temp.left, data);
            }
        }
        else if(data > temp.data) {
            if(temp.right == null) {
                temp.right = new Node(data);
            }
            else {
                insert(temp.right, data);
            }
        }
    }

    private Node findNode(Node temp, int data) {
        if(temp == null) return null;
        if(data < temp.data) {
            return findNode(temp.left, data);
        }
        else if(data > temp.data) {
            return findNode(temp.right, data);
        }
        else return temp;
    }

    public void delete(int data) {
        Node temp = findNode(root, data);
        if(temp == null) return;
        if(temp.left == null && temp.right == null) {
            deleteLeafNode(temp);
        }
        else if(temp.left != null && temp.right != null) {
            deleteTwoChildrenNode(temp);
        }
        else {
            deleteOneChildNode(temp);
        }
    }

    private Node deleteLeafNode(Node temp) {
        if(temp == root) root = null;
        else if(temp == temp.parent.left) {
            temp.parent.left = null;
        }
        else {
            temp.parent.right = null;
        }
        return temp;
    }

    private Node deleteOneChildNode(Node temp) {
        Node childNode;
        if(temp.left != null) childNode = temp.left;
        else childNode = temp.right;
        if(temp == root) root = childNode;
        else if(temp == temp.parent.left) {
            temp.parent.left = childNode;
        }
        else {
            temp.parent.right = childNode;
        }
        childNode.parent = temp.parent;

        return childNode;
    }

    private Node deleteTwoChildrenNode(Node temp) {
        Node successor = findMin(temp.right);
        temp.data = successor.data;
        if(successor == successor.parent.left) {
            successor.parent.left = successor.right;
        }
        else {
            successor.parent.right = successor.right;
        }
        if(successor.right != null) {
            successor.right.parent = successor.parent;
        }
        return successor;
    }

    private Node findMin(Node temp) {
        while(temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public void print() {
        System.out.print("[ ");
        if (root != null) {
            print(root);
        }
        System.out.println("]");
    }

    public void print(Node temp) {
        if(temp.left != null) {
            print(temp.left);
        }
        System.out.print(temp.data + " ");
        if(temp.right != null) {
            print(temp.right);
        }
    }

    public static void main(String[] args) {
        LikeTree tree = new LikeTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        System.out.println("<  insert 결과 출력  >\n");
        tree.print();
        System.out.println("\n==============================\n");
        tree.delete(10);
        tree.delete(20);
        System.out.println("<  delete 결과 출력  >\n");
        tree.print();
    }
}
