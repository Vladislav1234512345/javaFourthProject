package fourthPackage;

public class ScientificLibrary {
    private DoubleLinkedList doubleList = new DoubleLinkedList();

    public ScientificLibrary(int hallsQty, int[] books) {
        this.doubleList = new DoubleLinkedList();
        for (int i = 0; i < hallsQty; ++i) {
            doubleList.addLast(new DoubleItem(new ScientificLibraryHall("Не определено", books[i])));
        }
    }

    public ScientificLibrary(ScientificLibraryHall[] halls) {
        for(int i = 0; i < halls.length; ++i) {
            doubleList.addLast(new DoubleItem(halls[i]));
        }
    }

    public int getHallsQty() {
        return doubleList.length();
    }

    public int getBooksQty() {
        int booksQty = 0;
        for (int i = 0; i < getHallsQty(); ++i) {
            booksQty += getHall(i).getBooksQty();
        }
        return booksQty;
    }

    public double getGeneralCost() {
        double generalCost = 0;
        for (int i = 0; i < getHallsQty(); ++i) {
            generalCost += getHall(i).getGeneralCost();
        }
        return generalCost;
    }

    public DoubleLinkedList getHallsArray() {
        return doubleList;
    }

    public ScientificLibraryHall getHall(int index) {
        return doubleList.getDoubleItem(index).get().data;
    }

    public ScientificBook getBook(int index) {
        for (int i = 0; i < getHallsQty(); ++i) {
            if (index < doubleList.getDoubleItem(i).get().data.getBooksQty())
                return doubleList.getDoubleItem(i).get().data.getBook(index);
            index -= doubleList.getDoubleItem(i).get().data.getBooksQty();
        }
        return null;
    }

    public ScientificBook[] getSortedBooks() {
        ScientificBook[] booksArray = new ScientificBook[getBooksQty()];
        for (int i = 0; i < booksArray.length; ++i) {
            booksArray[i] = getBook(i);
        }
        for (int i = 0; i < booksArray.length; ++i) {
            boolean isSorted = false;
            for (int j = 0; j < booksArray.length - 1; ++j) {
                if (booksArray[j].getCost() < booksArray[j + 1].getCost()) {
                    isSorted = true;
                    ScientificBook tmp = booksArray[j];
                    booksArray[j] = booksArray[j + 1];
                    booksArray[j + 1] = tmp;
                }
            }
            if (!isSorted) break;
        }
        return booksArray;
    }

    public String getHallsNames() {
        String result = "";
        for (int i = 0; i < getHallsQty(); ++i) {
            result += "\n\nЗал №" + i + ":\nИмя зала - "
                    + getHall(i).hallName + ", количество книг - "
                    + getHall(i).getBooksQty();
        }
        return result;
    }

    public void changeHall(int index, ScientificLibraryHall other) {
        doubleList.deleteItem(index);
        doubleList.addItem(index, new DoubleItem(other));
    }

    public void changeBook(int index, ScientificBook other) {
        for (int i = 0; i < getHallsQty(); ++i) {
            if (index < getHall(i).getBooksQty()) {
                getHall(i).deleteBook(index);
                getHall(i).addBook(index, new Item(other));
                break;
            }
            index -= getHall(i).getBooksQty();
        }
    }

    public void addBook(int index, ScientificBook other) {
        for (int i = 0; i < getHallsQty(); ++i) {
            if (index <= getHall(i).getBooksQty()) {
                getHall(i).addBook(index, new Item(other));
                return;
            }
            index -= getHall(i).getBooksQty();
        }
    }

    public void deleteBook(int index) {
        for (int i = 0; i < getHallsQty(); ++i) {
            if (index < getHall(i).getBooksQty()) {
                getHall(i).deleteBook(index);
                break;
            }
            index -= getHall(i).getBooksQty();
        }
    }

    public ScientificBook getBestBook() {
        if (doubleList.isEmpty()) return null;
        ScientificBook bestBook = getHall(0).getBestBook();
        for (int i = 0; i < getHallsQty(); ++i) {
            if (bestBook.getCost() < getHall(i).getBestBook().getCost())
                bestBook = getHall(i).getBestBook();
        }
        return bestBook;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < getHallsQty(); ++i) {
            result += "\nЗал №" + i + ":" + getHall(i).list.toString() + '\n';
        }
        return result;
    }
}
