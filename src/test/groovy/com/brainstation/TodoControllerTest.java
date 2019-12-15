package com.brainstation

import com.brainstation.controller.TodoController
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

@RunWith(SpringRunner)
@WebMvcTest(TodoController)
//@SpringBootTest
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc
    @Test
    void testHomepage() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk())
    }

}
