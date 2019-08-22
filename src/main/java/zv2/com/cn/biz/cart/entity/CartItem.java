package zv2.com.cn.biz.cart.entity;

import zv2.com.cn.biz.product.entity.Product;

import java.math.BigDecimal;

/**
 * @author lb
 * @date 2019/8/18 2:26
 */
public class CartItem {
    private Integer quantity;
    private BigDecimal price = new BigDecimal(0);
    private Product product;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        this.price = product.getSellingPrice().multiply(new BigDecimal(quantity));
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
