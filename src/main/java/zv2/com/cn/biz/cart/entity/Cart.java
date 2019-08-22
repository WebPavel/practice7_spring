package zv2.com.cn.biz.cart.entity;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lb
 * @date 2019/8/18 2:26
 */
public class Cart {
    private BigDecimal price = new BigDecimal(0);
    private Map<Long, CartItem> cartItemMap = new HashMap<>();

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Map<Long, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public Collection<CartItem> getCartItemCollection() {
        return cartItemMap.values();
    }
}
