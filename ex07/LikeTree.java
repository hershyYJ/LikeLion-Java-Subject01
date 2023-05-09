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

    // 삽입 메서드
    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;

                // 삽입할 값이 현재 노드보다 작은 경우
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        newNode.parent = parent;
                        return;
                    }
                }
                // 삽입할 값이 현재 노드보다 큰 경우
                else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        newNode.parent = parent;
                        return;
                    }
                }
            }
        }
    }



    // 삭제 메서드
    public void delete(int data) {
        Node current = root;
        while (current != null && current.data != data) {
            if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (current == null) {
            return;
        }
        Node parent = current.parent;
        if (current.left == null && current.right == null) {
            if (parent == null) {
                root = null;
            } else if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.left == null) {
            if (parent == null) {
                root = current.right;
                current.right.parent = null;
            } else if (parent.left == current) {
                parent.left = current.right;
                current.right.parent = parent;
            } else {
                parent.right = current.right;
                current.right.parent = parent;
            }
        } else if (current.right == null) {
            if (parent == null) {
                root = current.left;
                current.left.parent = null;
            } else if (parent.left == current) {
                parent.left = current.left;
                current.left.parent = parent;
            } else {
                parent.right = current.left;
                current.left.parent = parent;
            }
        } else {
            Node next = current.right;
            while (next.left != null) {
                next = next.left;
            }
            current.data = next.data;
            Node nextParent = next.parent;
            if (nextParent.left == next) {
                nextParent.left = next.right;
                if (next.right != null) {
                    next.right.parent = nextParent;
                }
            } else {
                nextParent.right = next.right;
                if (next.right != null) {
                    next.right.parent = nextParent;
                }
            }
        }
    }

    // 전체 노드 출력 메서드
    public void print(Node node) {
        if (node == null) {
            return;
        }
        print(node.left);
        System.out.print(node.data + " ");
        print(node.right);
    }

    public static void main(String[] args) {
        LikeTree tree = new LikeTree();

        tree.insert(15);
        tree.insert(20);
        tree.insert(13);
        tree.insert(11);
        tree.insert(17);
        tree.insert(23);
        tree.insert(33);
        tree.insert(25);
        tree.insert(8);

        tree.print(tree.root);
        System.out.println();

        tree.delete(23);
        tree.delete(13);
        tree.print(tree.root);
    }
}
