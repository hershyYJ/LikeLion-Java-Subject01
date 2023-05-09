package ex05;

public class LikeStack {
    private static LikeList list;

    public void push(int value) {
        if(list == null) {
            list = new LikeList();
        }
        list.insert(0, value);
    }

    public void pop() {
        if(isEmpty()) {
            throw new IllegalStateException("스택이 비어있습니다.");
        }
        list.delete(0);
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("스택이 비어있습니다.");
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
        LikeStack stack = new LikeStack();
        stack.push(10);
        stack.push(20);
        stack.push (30);
        stack.push(40);
        stack.push(50);
        System.out.println("<  insert 결과 출력  >\n");
        stack.print();
        System.out.println("\n==============================\n");
        stack.pop();
        stack.pop();
        System.out.println("<  delete 결과 출력  >\n");
        stack.print();
        System.out.println("\n==============================\n");
        System.out.println("<  peek 결과 출력  >\n");
        System.out.println("peek = " + stack.peek());
    }
}
