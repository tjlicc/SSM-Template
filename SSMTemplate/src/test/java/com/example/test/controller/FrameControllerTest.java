package com.example.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.test.basic.BaseSpringTest;

public class FrameControllerTest extends BaseSpringTest {

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void getAccount() throws Exception {
		MockHttpServletRequestBuilder mock = get("/index");
		/*mock.param("username", "20")
    	 .param("old_password", "123")
        .param("new_password", "dieboldArriveCallServlet");*/
		 mockMvc.perform(mock).andDo(print())
	 		.andExpect(status().isOk());
	 		//.andExpect(content().string("{\"success\":false,\"msg\":\"用户名或密码错误\",\"data\":null,\"extras\":null}"));
	}
}
