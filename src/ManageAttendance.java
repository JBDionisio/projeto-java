public class ManageAttendance {
    private int sizeCurrent;
    private int maxSize;

    private int elderlyCount = 0;

    private Queue elderlyQueue, normalQueue;

    public ManageAttendance(int size) {
        // vector = new int[size];
        // start = end = null;
        // maxSize = maxSize + size;

        maxSize = size;
        elderlyQueue = new Queue(size);
        normalQueue = new Queue(size);
    }

    public boolean isEmpty() {
        if (elderlyQueue.isEmpty() && normalQueue.isEmpty()) {
            return true;
        }

        return false;
    }

    public int numClients() {
        int num = elderlyQueue.size() + normalQueue.size();
        return num;
    }

    public int numElderlyClients() {
        return elderlyQueue.size();
    }

    public void addClient(Client cli) {
        Knot newKnot = new Knot(cli.getName(), cli.getAge());

        // if (!isFull()) {
        // if (isEmpty()) {
        // start = end = newKnot;
        // } else {
        // end.setNext(newKnot);
        // end = newKnot;
        // }
        // sizeCurrent++;
        // } else {
        // System.out.println("Cliente nÃ£o adicionado pois a fila esta cheia!");
        // }

        boolean isSucess = false;
        if (cli.isElderly()) {
            isSucess = elderlyQueue.enqueue(newKnot);
        } else {
            isSucess = normalQueue.enqueue(newKnot);

        }

        if (!isSucess) {
            System.out.println("Fila cheia"); // #####
        }
    }

    public Client showNext() {
        if (!elderlyQueue.isEmpty()) {
            if (elderlyCount < 2) {
                // elderlyCount++;
                return elderlyQueue.peek().getCli();
            }
        }

        if (!normalQueue.isEmpty()) {
            // elderlyCount = 0;
            return normalQueue.peek().getCli();
        }

        return null;
    }

    public Client getNext() {
        if (!elderlyQueue.isEmpty()) {
            if (elderlyCount < 2) {
                elderlyCount++;
                return elderlyQueue.dequeue().getCli();
            }
        }

        if (!normalQueue.isEmpty()) {
            elderlyCount = 0;
            return normalQueue.dequeue().getCli();
        }

        return null;
    }

    public String showQueues() {
        String out = "idoso:" + elderlyQueue.show() + ";";
        out += "normal:" + normalQueue.show();
        return out;
    }


    public int numNormalClients() {
        return normalQueue.size();
    }

    public boolean isFull() {
        return (sizeCurrent == maxSize); // to do
    }

    public int getMaxSize() {
        return maxSize;
    }
}