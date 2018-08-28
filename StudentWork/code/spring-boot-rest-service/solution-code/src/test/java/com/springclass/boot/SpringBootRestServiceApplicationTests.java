package com.springclass.boot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import org.springframework.http.MediaType;
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
    public void userDoesNotExist() throws Exception {

        boolean existing = repository.exists(123L);
        assertFalse(existing);

        User user = repository.findUserByFirstName("Mick");

//        assertEquals("Mick", user.getFirstName());
//        assertEquals("Mick", repository.findUserByFirstNameAndLastName("Mick", "Knutson").getFirstName());

    }










	@Test
    public void should_return_Repository_Index() throws Exception {

        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._links.users").exists());
    }

    /**
     * @link {https://github.com/json-path/JsonPath}
     * @throws Exception
     */
	@Test
    public void add_user() throws Exception {

	    String userToPost = "{ \"firstName\" : \"Mick\", \"lastName\" : \"Knutson\" }";

        mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..users.length()").value(0));


        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(userToPost))
                .andExpect(status().is2xxSuccessful());


        mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$..users.length()").value(1))
                .andExpect(jsonPath("$..users[0].firstName").value("Mick"))
                .andExpect(jsonPath("$..users[0].lastName").value("Knutson"))
        ;


    }


}
