package repository;

import repository.product.Product;

public class OrderItem {

    private Product product;

    private int quantity;

    /**
     * Конструктор, создающий элемент заказа на основе продукта и его количества.
     *
     * @param product  Продукт, который необходимо добавить в заказ
     * @param quantity Количество продукта в заказе
     */
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Геттер для получения продукта, связанного с данным элементом заказа.
     *
     * @return продукт, связанный с элементом заказа
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Сеттер для установки продукта для данного элемента заказа.
     *
     * @param product Продукт, который необходимо связать с элементом заказа
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Геттер для получения количества продукта в данном элементе заказа.
     *
     * @return количество продукта в элементе заказа
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Сеттер для установки количества продукта в элементе заказа.
     *
     * @param quantity Количество продукта, которое необходимо установить для элемента заказа
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}