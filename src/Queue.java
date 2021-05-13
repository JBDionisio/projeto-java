public class Queue {
    private Knot start;
    private Knot end;

    private int size;
    private int lastIndex;

    public Queue(int size) {
        start = end = null;

        this.size = size;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public boolean isFull() {
        return size == lastIndex;
    }

    public boolean enqueue(Knot value) {
        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            start = end = value;
        } else {
            end.setNext(value);
            end = value;
        }

        lastIndex++;
        return true;
    }

    public Knot dequeue() {
        if (isEmpty()) {
            return null;
        }

        Knot buffer = start;
        start = start.getNext();

        if (start == null) {
            end = null;
        }

        return buffer;
    }

    public Knot peek() {
        if (!isEmpty()) {
            return start;
        }
        return null;
    }

    public int size() {
        return lastIndex;
    }

    public String show() {
        String output = "";
        Knot buffer = start;

        if (!isEmpty()) {
            for (int i = 0; i < lastIndex; i++) {
                Client c = buffer.getCli();
                output += c.getName() + ":" + c.getAge();

                if (i > 0 && i < lastIndex) {
                    output += "-";
                }
            }
        } else {
            output = "vazia";
        }

        return output;
    }
}