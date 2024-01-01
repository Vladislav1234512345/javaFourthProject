package fourthPackage;

import java.util.Optional;

public class ScientificLibraryHall  {
    protected LinkedList list = new LinkedList();
    protected String hallName;
    public ScientificLibraryHall(String hallName, int booksQty) {
        this.hallName = hallName;
        this.list = new LinkedList();
        for(int i = 0; i < booksQty; ++i) {
            this.list.addLast(new Item());
        }
    }
    public ScientificLibraryHall(String hallName, ScientificBook[] books) {
        this.hallName = hallName;
        for(int i = 0; i < books.length; ++i) {
            this.list.addLast(new Item(books[i]));
        }
    }
    public int getBooksQty() {
        return list.length();
    }
    public String getBooksNames() {
        return "Список названий всех книг в зале:\n" + list.toString();
    }
    public double getGeneralCost() {
        double generalCost = 0;
        for(int i = 0; i < list.length(); ++i) {
            generalCost += getBook(i).getCost();
        }
        return generalCost;
    }
    public ScientificBook getBook(int index) {
        return list.getItem(index).get().data;
    }
    public void changeBook(Item other, int index) {
        list.deleteItem(index);
        list.addItem(index, other);
    }
    public void addBook( int index, Item other) {
        list.addItem(index, other);
    }
    public void deleteBook(int index) {
        list.deleteItem(index);
    }
    public ScientificBook getBestBook() {
        if(list.isEmpty()) return null;
        ScientificBook bestBook = getBook(0);
        for(int i = 0; i < list.length(); ++i) {
            if(bestBook.getCost() < getBook(i).getCost()) bestBook = getBook(i);
        }
        return bestBook;
    }
    @Override
    public String toString() {
        return "\nВсе книги в зале:" + this.list.toString();
    }
}
