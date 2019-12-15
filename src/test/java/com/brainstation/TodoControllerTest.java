package com.brainstation;

import com.brainstation.controller.TodoController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TodoController.class)
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomepage() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                get("/")
        ).andExpect(
                model().attribute("greetings", "Hello from Spring")
        ).andExpect(
                status().isOk()
        ).andExpect(
                view().name("home")
        );

        MvcResult mvcResult = resultActions.andReturn();
        ModelAndView mv = mvcResult.getModelAndView();
    }

}
