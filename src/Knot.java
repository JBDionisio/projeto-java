public class Knot {
    private Client cli;
    private Knot next;
    
    public Knot(String name, int age) {
        cli = new Client(name, age);
        next = null;
    }

    public Client getCli() {
        return cli;
    }

    public Knot getNext() {
        return next;
    }

    public void setNext(Knot next) {
        this.next = next;
    }

}