package ex06;

public class LikeList {

    public static Node head;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // 삽입 메서드, index 위치에 노드 추가
    public static void insert(int index, int data) {
        Node newNode = new Node(data);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node prev = null;
            Node current = head;
            int i = 0;

            while (current != null && i < index) {
                prev = current;
                current = current.next;
                i++;
            }

            prev.next = newNode;
            newNode.next = current;
        }
    }


    // 삭제 메서드, index 위치에 노드 삭제
    public static void delete(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node prev = null;
            Node current = head;
            int i = 0;

            while (current != null && i < index) {
                prev = current;
                current = current.next;
                i++;
            }

            if (current != null) {
                prev.next = current.next;
            }
        }
    }


    // 전체 노드 출력 메서드
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LikeList list = new LikeList();

        list.insert(0, 1);
        list.insert(1, 3);
        list.insert(1, 2);

        list.print();

        list.delete(2);
        list.delete(0);

        list.print();
    }
}
