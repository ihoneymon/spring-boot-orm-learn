package io.honeymon.learn.orm.view;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import io.honeymon.learn.orm.view.MemberViewController;

@RunWith(SpringRunner.class)
@SpringBootTest
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
