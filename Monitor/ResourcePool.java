class ResourcePool {
    private int availableResources;

    public ResourcePool(int total) { this.availableResources = total; }

    public synchronized void acquire() {
        while(availableResources <= 0) {
            try { wait(); } catch (InterruptedException e) {}
        }
        availableResources--;
    }

    public synchronized void release() {
        availableResources++;
        notifyAll();
    }
}