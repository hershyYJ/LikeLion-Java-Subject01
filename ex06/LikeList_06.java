package ex06;

public class LikeList {
    private Node head;
    protected int size;

    private class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public Node findNode(int index) {
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int getData(int index) {
        if(index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void insert(int index, int data) {
        Node temp = head;
        if(index < 0) {
            throw new IndexOutOfBoundsException();
        }
        else if(index == 0) {
            if(temp == null) {
                Node newNode = new Node(data);
                if(isEmpty()) {
                    head = newNode;
                }
                else {
                    newNode.next = head;
                    head = newNode;
                }
            }
            else {
                Node preNode = findNode(index-1);
                Node newNode = new Node(data);
                newNode.next = preNode.next;
                preNode.next = newNode;
            }
        }
        else {
            Node preNode = findNode(index-1);
            Node newNode = new Node(data);
            newNode.next = preNode.next;
            preNode.next = newNode;
        }
        size++;
    }

    public void delete(int index) {
        if(index < 0) {
            throw new IndexOutOfBoundsException();
        }
        else if(index == 0) {
            head = head.next;
        }
        else {
            Node preNode = findNode(index-1);
            preNode.next = preNode.next.next;
        }
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        Node temp = head;
        System.out.print("[ ");
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        LikeList list = new LikeList();
        list.insert(0, 10);
        list.insert(1, 20);
        list.insert(2, 30);
        list.insert(3, 40);
        list.insert(4, 50);
        System.out.println("<  insert 결과 출력  >\n");
        list.print();
        System.out.println("\n==============================\n");
        list.delete(0);
        list.delete(1);
        System.out.println("<  delete 결과 출력  >\n");
        list.print();
    }

}
