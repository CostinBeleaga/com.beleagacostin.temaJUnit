package com.example.Homework7;

import com.example.Homework7.model.Product;
import com.example.Homework7.model.ProductType;
import com.example.Homework7.model.ShoppingCart;
import com.example.Homework7.repository.ShoppingCartRepository;
import com.example.Homework7.service.ShoppingCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceTest {
    @Mock
    ShoppingCartRepository shoppingCartRepository;

    @InjectMocks
    ShoppingCartService shoppingCartService;

    @Test
    public void it_should_create_shoppingCart()
    {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(1);
        when(shoppingCartRepository.save(any(ShoppingCart.class))).thenReturn(new ShoppingCart());

        ShoppingCart createdShoppingCart = shoppingCartRepository.save(shoppingCart);

        assertThat(createdShoppingCart.getId()).isSameAs(shoppingCart.getId());
    }
}
