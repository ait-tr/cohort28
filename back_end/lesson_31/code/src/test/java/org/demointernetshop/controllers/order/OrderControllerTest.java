package org.demointernetshop.controllers.order;

import org.demointernetshop.configuration.security.SecurityConfig;
import org.demointernetshop.model.dto.order.OrderDto;
import org.demointernetshop.model.dto.order.OrderRequestDto;
import org.demointernetshop.services.OrderService;
import org.demointernetshop.services.auth.CustomUserDetailService;
import org.demointernetshop.services.auth.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
@Import(SecurityConfig.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;
    @MockBean
    private JwtTokenProvider jwtTokenProvider;
    @MockBean
    private CustomUserDetailService customUserDetailService;


    @Test
    @WithMockUser(username = "AlexUser", roles = ("USER"))
    void createOrder() throws Exception {
        OrderRequestDto requestDto = new OrderRequestDto();
        OrderDto responseDto = new OrderDto();

        given(orderService.createOrder(requestDto)).willReturn(responseDto);

        mockMvc.perform(post("/api/orders")
                        .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"key\" : \"value\"}"))
                .andExpect(status().isOk());

    }

    @Test
    @WithMockUser(roles = "USER")
    void createOrderWithUserRole() throws Exception {
        OrderRequestDto requestDto = new OrderRequestDto();
        OrderDto responseDto = new OrderDto();

        given(orderService.createOrder(requestDto)).willReturn(responseDto);

        mockMvc.perform(post("/api/orders")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"key\" : \"value\"}"))
                .andExpect(status().isOk());

    }

    @Test
    @WithMockUser(roles = "CLIENT")
    void createOrderWithClientRoleShouldFail() throws Exception {
        OrderRequestDto requestDto = new OrderRequestDto();
        OrderDto responseDto = new OrderDto();

        given(orderService.createOrder(requestDto)).willReturn(responseDto);

        mockMvc.perform(post("/api/orders")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"key\" : \"value\"}"))
                .andExpect(status().isForbidden());

    }


    //@WithUserDetails
    //@WithMockAdmin - можно создать свою собственную аннотацию которую будете использовать в проекте
    //@WithMockUser
    //@WithAnonymousUser



}
