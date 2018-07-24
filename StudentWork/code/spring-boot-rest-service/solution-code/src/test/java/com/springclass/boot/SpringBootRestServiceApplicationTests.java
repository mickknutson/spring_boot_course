package com.springclass.boot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.springclass.boot.domain.User;
import com.springclass.boot.domain.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {
        TestJavaConfig.class,
        TestJpaConfiguration.class,
        TestRestConfiguration.class
        })
public class SpringBootRestServiceApplicationTests {

	private static final Logger LOG = LoggerFactory.getLogger(SpringBootRestServiceApplicationTests.class);

	@SuppressWarnings("SpringJavaAutowiringInspection")
	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	private UserRepository repository;
	
	private User user;
	
	@Before
    public void deleteAllBeforeTests() throws Exception {
		repository.deleteAll();
    }
	
	@Test
    public void should_return_Repository_Index() throws Exception {

        mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
                jsonPath("$._links.users").exists());
    }

}
