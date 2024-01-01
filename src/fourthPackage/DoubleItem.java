package fourthPackage;

public class DoubleItem {
    protected DoubleItem next;
    protected DoubleItem prev;
    protected ScientificLibraryHall data;
    public DoubleItem(ScientificLibraryHall data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    public DoubleItem() {
        this.data = new ScientificLibraryHall("Не определено", 0);
        this.next = null;
        this.prev = null;
    }
    @Override
    public String toString() {
        return this.data.toString();
    }
}
