package zv2.com.cn.biz.cart.service;

import zv2.com.cn.biz.cart.entity.Cart;
import zv2.com.cn.biz.cart.entity.CartItem;
import zv2.com.cn.biz.product.entity.Product;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

/**
 * @author lb
 * @date 2019/8/18 2:43
 */
public class CartService {

    public void addCartItem(Cart cart, CartItem cartItem) {
        Map<Long, CartItem> cartItemMap = cart.getCartItemMap();
        Product product = cartItem.getProduct();
        Long productId = product.getId();
        if (cartItemMap.containsKey(productId)) {
            // 购物车中购物项已存在，修改数量
            CartItem _cartItem = cartItemMap.get(productId);
            _cartItem.setQuantity(_cartItem.getQuantity() + cartItem.getQuantity());
        } else {
            // 新增购物项
            cartItemMap.put(productId, cartItem);
        }
        // 计算总计，小计累加
        Collection<CartItem> cartItemCollection = cartItemMap.values();
        for (CartItem cartItem_ : cartItemCollection) {
            cart.setPrice(cart.getPrice().add(cartItem.getPrice()));
        }
    }

    public void removeCartItem(Cart cart, Long productId) {
        CartItem cartItem = cart.getCartItemMap().remove(productId);
        cart.setPrice(cart.getPrice().subtract(cartItem.getPrice()));
    }

    public void clear(Cart cart) {
        cart.getCartItemMap().clear();
        cart.setPrice(new BigDecimal(0));
    }
}
