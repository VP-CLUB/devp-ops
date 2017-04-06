package cn.vpclub.mockmvc;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Created by XiongShi on 2016/3/23.
 */
public class QueryFnanceAccountTest extends BaseMockMvcTest {

    //注入 被测试 controller
    @Autowired
    private QueryFnanceAccountController queryFnanceAccountController;

    @Mock
    private QueryFnanceAccountService queryFnanceAccountService;

    @Test
    public void queryBalance() throws Exception {
        String url = "/finance/queryBalance";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON).param("appids", "4")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        logger.info("content: "+content);
        int status = result.getResponse().getStatus();
        Assert.assertEquals("failure - expected HTTP status", 200, status);
        Assert.assertTrue(
                "failure - expected HTTP response body to have a value",
                content.trim().length() > 0);
        logger.info(content);
    }

}
