package repository.view;

import repository.OrderService;
import repository.orderRepository.*;
import repository.Commands;
import repository.Order;
import repository.OrderItem;
import repository.product.Product;
import repository.productRepository.ProductRepository;
import repository.productRepository.SQLiteProductRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ConsoleViewImpl {
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    private List<Product> allProducts;

    public ConsoleViewImpl(String connectiondbString, String databaseUrl) throws SQLException {
        this.productRepository = new SQLiteProductRepository(connectiondbString);
        this.orderRepository = new OrderRepositoryImpl(databaseUrl);
        this.allProducts = productRepository.getAll();
    }

    private void showGreetings() {
        System.out.println("Добро пожаловать в магазин сладостей.\n");
    }

    public void showOrder(Order order) {
        List<OrderItem> allOrderedProducts = order.getItems();
        System.out.println("\nВаша корзина:");
        for (OrderItem orderItem : allOrderedProducts) {
            System.out.println("Продукт: " + orderItem.getProduct().getName()
                    + ". Количество: " + orderItem.getQuantity()
                    + ". Цена - " + orderItem.getProduct().getPrice()*orderItem.getQuantity()
                    + " руб. ");
        }
        System.out.println("\nОбщая цена: " + order.getTotalPrice() + " руб.");
    }

    public void showProductList() {
        System.out.println("Список товаров:");
        for (Product product : allProducts) {
            System.out.println(product.getId() + " - Продукт: " + product.getName());
        }
    }


    public void run() throws SQLException {

        OrderService service = new OrderService(orderRepository);

        showGreetings();

        Order order = new Order();
        Commands com;

        while (true) {
            showProductList();
            String command = prompt("Выберите товар или команду (BUY, EXIT): ");

            try {
                int num = Integer.parseInt(command);
                System.out.println(allProducts.get(num - 1).getName());
                try {
                    int amount = Integer.parseInt(prompt("Введите количество: "));
                    OrderItem orderItem = new OrderItem(allProducts.get(num - 1), amount);
                    order.addItem(orderItem);
                    showOrder(order);
                } catch (NumberFormatException r) {
                }
            } catch (NumberFormatException e) {
                try {
                    com = Commands.valueOf(command);
                    if (com == Commands.EXIT)
                        return;
                    if (com == Commands.BUY) {
                        service.createOrder(order);
                        System.out.println("\nЗаказ создан\n");
                    }
                    if (com == Commands.SHOW) {
                        Order lastOrder = service.getLastOrder();
                        showOrder(lastOrder);
                    }

                } catch (IllegalArgumentException f) {
                }
            }



        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        String data = in.nextLine();
        return data;
    }




}
