class DoublyLinkedList<T> {
    private Element<T> head;
    private Element<T> tail;

    void push(T value) {
        Element<T> newHead = new Element<>(value, null, head);
        if (head != null) head.prev = newHead;
        this.head = newHead;
        if (tail == null) tail = newHead;
    }

    T pop() {
        if (head == null) return null;
        Element<T> oldHead = head;
        this.head = head.next;
        if (head == null) tail = null;
        return oldHead.value;
    }

    void unshift(T value) {
        Element<T> newTail = new Element<>(value, tail, null);
        if (tail != null) tail.next = newTail;
        this.tail = newTail;
        if (head == null) head = newTail;
    }

    T shift() {
        if (tail == null) return null;
        Element<T> oldTail = tail;
        this.tail = tail.prev;
        if (tail == null) head = null;
        return oldTail.value;
    }

    public static final class Element<T> {
        private final T value;
        private Element<T> prev;
        private Element<T> next;

        Element(T value, Element<T> prev, Element<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
