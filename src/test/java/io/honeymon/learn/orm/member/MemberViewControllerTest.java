package io.honeymon.learn.orm.member;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import io.honeymon.learn.orm.OrmLearnApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { OrmLearnApplication.class })
@WebAppConfiguration
@Transactional
public class MemberViewControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .alwaysExpect(handler().handlerType(MemberViewController.class)).alwaysDo(print()).build();
    }

    /**
     * <code>/members</code> 로 GET 요청을 날렸을 경우 템플릿 엔진에 의해 members/main 템플릿 파일이
     * 정상적으로 동작하는지 확인
     * 
     * @throws Exception
     */
    @Test
    public void testRequestGetMembers() throws Exception {
        mockMvc.perform(get("/members")).andExpect(view().name("members/main")).andExpect(status().is2xxSuccessful());
    }

}
