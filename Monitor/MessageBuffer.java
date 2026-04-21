class MessageBuffer {
    private String message;
    private boolean empty = true;

    public synchronized void put(String msg) {
        while (!empty) {
            try { wait(); } catch(InterruptedException e) {}
        }
        empty = false;
        this.message = msg;
        notifyAll();
    }

    public synchronized String take() {
        while(empty) {
            try { wait(); } catch (InterruptedException e) {}
        }
        empty = true;
        notifyAll();
        return message;
    }
}
