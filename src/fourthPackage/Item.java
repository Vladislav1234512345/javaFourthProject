package fourthPackage;

public class Item {
    protected Item next;
    protected ScientificBook data;

    public Item(ScientificBook data) {
        this.next= null;
        this.data = data;
    }
    public Item() {
        this.next = null;
        this.data = new ScientificBook();
    }
    @Override
    public String toString() {
        return this.data.toString();
    }
}
