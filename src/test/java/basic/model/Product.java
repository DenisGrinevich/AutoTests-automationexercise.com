package basic.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Product {
    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
