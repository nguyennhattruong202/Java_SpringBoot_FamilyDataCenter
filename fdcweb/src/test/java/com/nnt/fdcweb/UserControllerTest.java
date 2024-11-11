package com.nnt.fdcweb;

import com.nnt.fdcweb.controllers.UserApiController;
//import com.nnt.fdcweb.model.User;
//import com.nnt.fdcweb.services.UserService;
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.List;
import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import static org.mockito.Mockito.when;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Disabled
@WebMvcTest(UserApiController.class)
public class UserControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private UserService userService;
//    @Test
//    public void testGetUserSuccess() throws Exception {
//        User user = new User();
//        user.setUserId(1L);
//        user.setFullname("Nguyen Nhat Truong");
//        user.setGender("Nam");
//        user.setDateOfBirth(LocalDate.now());
//        user.setPhone("0987665761");
//        user.setPassword("123456");
//        List<User> userList = Arrays.asList(user);
//        Page<User> userPage = new PageImpl<>(userList, PageRequest.of(0, 10), userList.size());
//        when(userService.findAll(0)).thenReturn(userPage);
//        mockMvc.perform(get("/api/users").param("page", "0")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.content[0].fullname").value("Nguyen Nhat Truong"));
//
//    }
}
