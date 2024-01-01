package fourthPackage;

public class Book {
    protected String author ;
    protected String name ;
    protected double cost ;
    protected int year ;
    public Book() {
        this.author = "Не определено";
        this.name = "Не определено";
        this.cost = 0.0;
        this.year = 0;
    }

    public Book(String author, String name, double cost, int year) {
        this.author = author;
        this.name = name;
        this.cost = cost;
        this.year = year;
    }
    public Book(String author, int year) {
        this();
        this.author = author;
        this.year = year;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getAuthor() {
        return author;
    }
    public String getName() {
        return name;
    }
    public double getCost() {
        return cost;
    }
    public int getYear() {return year;}
    @Override
    public String toString() {
        return "\nАвтор: " + getAuthor()
                + "\nИмя: " + getName()
                + "\nСтоимость: " + getCost()
                + "\nГод: " + getYear();
    }
}
