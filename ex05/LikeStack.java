package ex05;

import static ex05.LikeList.head;

public class LikeStack {

    // ex04에서 만든 LikeList 사용
    private LikeList list;
	private LikeList.Node top;

    // 추가
    public void push(int value) {
        LikeList.Node newNode = new LikeList.Node(value);
        newNode.next = head;
        head = newNode;
    }
    // 삭제
    public void pop() {
		head = head.next;
    }
    // 스택의 마지막 값 조회
    public int peek() {
        return head.data;
    }

    // 스택이 비어있다면 true
    public boolean isEmpty() {
        if(head == null) return true;
        else return false;
    }

    // 전체 노드 출력 메서드
    public void print() {
        LikeList.Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LikeStack stack = new LikeStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.print();

        stack.pop();
        System.out.println("top = " + stack.peek());
        stack.pop();
        System.out.println("top = " + stack.peek());

        stack.print();

        System.out.println("empty = " + stack.isEmpty());
        stack.pop();
        System.out.println("empty = " + stack.isEmpty());
    }
}
