package zv2.com.cn.biz.order.entity;

import zv2.com.cn.biz.product.entity.Product;

import java.math.BigDecimal;

/**
 * @author lb
 * @date 2019/8/18 23:50
 */
public class OrderItem {
    private Long id;
    private Integer quantity;
    private BigDecimal price;
    private Product product;
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
