package com.example.Homework7;

import com.example.Homework7.controller.ProductController;
import com.example.Homework7.model.Product;
import com.example.Homework7.model.ProductType;
import com.example.Homework7.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.print.attribute.standard.Media;

import java.util.Arrays;
import java.util.List;

import static com.example.Homework7.model.ProductType.ELG;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @MockBean
    ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void it_should_save_product() throws Exception
    {
        String request = new String("{ \"type\" : \"ELG\", \"name\" : \"Televizor\", \"identificationCode\" : \"F111\", \"stock\" : \"45\",\"price\" : \"90\"}");

        mockMvc.perform(post("/product")
                .content(request)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void it_should_get_id_product() throws  Exception
    {
        Product product = new Product(1, ProductType.ELC, "Masina de spalat", "F243", 10, false,35);
        when(productService.getProductById(1)).thenReturn(product);
        mockMvc.perform(get("/product/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }
}
