package models;

/**
 class of entity for dish objects
 contains a unique identifier: id, name, price
 */

public class Dish  {

    private int id;

    private String name;

    private double price;

    public Dish() {
    }

    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice ( double price ) {
        this.price = price;
    }

    @Override
    public String toString () {
        return
                "name= " + name + '\'' +
                ", price=" + price +
                '}';
    }
}
