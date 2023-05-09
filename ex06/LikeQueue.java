package ex06;

public class LikeQueue {
    private static LikeList list;

    public void enqueue(int value) {
        if(list == null) {
            list = new LikeList();
        }
        list.insert(list.size, value);
    }

    public void dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("큐가 비어있습니다.");
        }
        list.delete(0);
    }

    public int peek() {
        if(isEmpty()) {
            throw new IllegalStateException("큐가 비어있습니다.");
        }
        return list.getData(0);
    }

    public boolean isEmpty() {
        return (list.size == 0);
    }

    public void print() {
        list.print();
    }

    public static void main(String[] args) {
        LikeQueue queue = new LikeQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println("<  enqueue 결과 출력  >\n");
        queue.print();
        System.out.println("\n==============================\n");
        queue.dequeue();
        queue.dequeue();
        System.out.println("<  dequeue 결과 출력  >\n");
        queue.print();
        System.out.println("\n==============================\n");
        System.out.println("<  peek 결과 출력  >\n");
        System.out.println("peek = " + queue.peek());
    }

}
