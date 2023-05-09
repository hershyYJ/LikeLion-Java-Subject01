package ex06;

import static ex06.LikeList.head;

public class LikeQueue {

    // ex04에서 만든 LikeList 사용
    private LikeList list;
    private LikeList.Node front = null;
    private LikeList.Node rear = null;
    int size = 0;

    // 추가
    public void enqueue(int value) {
        LikeList.Node newNode = new LikeList.Node(value);

        if(size == 0) {
            front = newNode;
        }
        else{
            rear.next = newNode;
        }

        rear = newNode;
        size++;
    }
    // 삭제
    public void dequeue() {
        if(isEmpty()) return;
        size--;
        front = front.next;
    }
    // 큐의 첫번쨰 값 조회
    public int peek() {
        return front.data;
    }
    // 큐가 비었는지 확인
    public boolean isEmpty() {
        if(size == 0) return true;
        else return false;
    }

    public void print() {
        LikeList.Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LikeQueue queue = new LikeQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.print();

        queue.dequeue();
        System.out.println("front = " + queue.peek());
        queue.dequeue();
        System.out.println("front = " + queue.peek());

        queue.print();

        System.out.println("empty = " + queue.isEmpty());
        queue.dequeue();
        System.out.println("empty = " + queue.isEmpty());
    }
}
