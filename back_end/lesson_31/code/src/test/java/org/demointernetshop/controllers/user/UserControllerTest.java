package org.demointernetshop.controllers.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.demointernetshop.anotations.WithMockAdmin;
import org.demointernetshop.configuration.security.SecurityConfig;
import org.demointernetshop.controllers.order.OrderController;
import org.demointernetshop.model.dto.user.UserDto;
import org.demointernetshop.model.dto.user.UserRegistrationDto;
import org.demointernetshop.services.OrderService;
import org.demointernetshop.services.UserService;
import org.demointernetshop.services.auth.CustomUserDetailService;
import org.demointernetshop.services.auth.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@Import(SecurityConfig.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @MockBean
    private JwtTokenProvider jwtTokenProvider;
    @MockBean
    private CustomUserDetailService customUserDetailService;

    @Test
    //@WithMockUser(username = "admin", roles = "ADMIN")
    @WithMockAdmin
    void testRegisterUser() throws Exception {

        UserRegistrationDto registrationDto = new UserRegistrationDto();
        UserDto userDto = new UserDto();

        given(userService.createUser(registrationDto)).willReturn(userDto);

        mockMvc.perform(post("/api/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(registrationDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userDto.getId()));

    }
}

