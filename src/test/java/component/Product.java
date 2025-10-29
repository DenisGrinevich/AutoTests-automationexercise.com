package component;

import basic.BaseProduct;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class Product extends BaseProduct {

    private int id;
    private String name;
    private int price;
    private Integer quantity;


    public Product(WebDriver driver, int id, String name, int price, int quantity) {
        super(driver);
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(WebDriver driver, int id, String name, int price) {
        super(driver);
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product other = (Product) o;

        boolean baseMatch = this.id == other.id &&
                this.price == other.price &&
                Objects.equals(this.name, other.name);

        if (this.quantity != null && other.quantity != null) {
            System.out.println("Id товара в листинге = " + this.id + ". Id товара в корзине = " + other.id);
            System.out.println("Имя товара в листинге = " + this.name + ". Имя товара в корзине = " + other.name);
            System.out.println("Цена товара в листинге = " + this.price + ". Цена товара в корзине = " + other.price);
            System.out.println("Количество товара в листинге = " + this.quantity + ". Количество товара в корзине = " + other.quantity);
            return baseMatch && this.quantity.equals(other.quantity);
        } else {
            System.out.println("Id товара в листинге = " + this.id + ". Id товара в корзине = " + other.id);
            System.out.println("Имя товара в листинге = " + this.name + ". Имя товара в корзине = " + other.name);
            System.out.println("Цена товара в листинге = " + this.price + ". Цена товара в корзине = " + other.price);

            return baseMatch;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, quantity);
    }

}
