package cn.vpclub.mockmvc;

import cn.vpclub.monitor.consumer.main.MonitorConsumerApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Administrator on 2016/3/11.
 * 基础测试 抽象类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MonitorConsumerApplication.class)
@WebAppConfiguration
public abstract class BaseMockMvcTest {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext context;

    @Before
    public void setupMockMvc() {
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
}
