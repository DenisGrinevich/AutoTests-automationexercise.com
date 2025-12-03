package basic.base;

import basic.tools.Logging;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public abstract class BaseProduct extends BaseModel{

    private int id;
    private String name;
    private int price;
    private Integer quantity;

    public BaseProduct(WebDriver driver) {
        super(driver);
    }

    protected abstract void parseData();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof BaseProduct)) return false;
        BaseProduct other = (BaseProduct) o;

        boolean baseMatch = this.getId() == other.getId() &&
                this.getPrice() == other.getPrice() &&
                Objects.equals(this.getName(), other.getName());

        if (this.getQuantity() != null && other.getQuantity() != null) {
            Logging.info("Id товара в листинге = " + this.getId() + ". Id товара в корзине = " + other.getId() + System.lineSeparator() +
                    "Имя товара в листинге = " + this.getName() + ". Имя товара в корзине = " + other.getName() + System.lineSeparator() +
                    "Цена товара в листинге = " + this.getPrice() + ". Цена товара в корзине = " + other.getPrice() + System.lineSeparator() +
                    "Количество товара в листинге = " + this.getQuantity() + ". Количество товара в корзине = " + other.getQuantity());

            return baseMatch && this.getQuantity().equals(other.getQuantity());
        } else {
            Logging.info("Id товара в листинге = " + this.getId() + ". Id товара в корзине = " + other.getId() + System.lineSeparator() +
                    "Имя товара в листинге = " + this.getName() + ". Имя товара в корзине = " + other.getName() + System.lineSeparator() +
                    "Цена товара в листинге = " + this.getPrice() + ". Цена товара в корзине = " + other.getPrice());

            return baseMatch;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, quantity);
    }
}
