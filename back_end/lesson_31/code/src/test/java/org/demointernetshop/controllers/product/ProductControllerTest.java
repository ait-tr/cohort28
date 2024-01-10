package org.demointernetshop.controllers.product;

import org.demointernetshop.model.dto.product.ProductDto;
import org.demointernetshop.services.ProductService;
import org.demointernetshop.services.auth.CustomUserDetailService;
import org.demointernetshop.services.auth.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private JwtTokenProvider jwtTokenProvider;
    @MockBean
    private CustomUserDetailService customUserDetailService;



    @Test
    @WithMockUser(username = "AlexUser", roles = ("USER"))
    void getProductById() throws Exception {
        int productId = 1;
        when(productService.getProductById(productId)).thenReturn(new ProductDto()); // Replace with your expected return object

        mockMvc.perform(MockMvcRequestBuilders.get("/api/products/{product_id}", productId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists()); // Validate the response structure
    }



}