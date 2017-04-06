package cn.vpclub.mockmvc;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Created by Administrator on 2016/3/14.
 */
public class ReportDayServicechargeTest extends BaseMockMvcTest {

    private Gson gson = new Gson();

    //注入 被测试 controller
    @Autowired
    private ReportDayServicechargeController reportDayServicechargeController;

    @Mock
    private ReportDayServicechargeService reportDayServicechargeService;

    @Test
    public void serviceChargeByDay() throws Exception {
        String url = "/finance/serviceCharge";
        ReportDayServicecharge reportDayServicecharge = new ReportDayServicecharge();
        reportDayServicecharge.setDateStr("2016-03-17");
        reportDayServicecharge.setAppid(4);
        logger.info("ReportDayServicecharge: " + gson.toJson(reportDayServicecharge));
        String inputJson = gson.toJson(reportDayServicecharge);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(inputJson))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();
        logger.info("content: " + content);
        Assert.assertEquals("failure - expected HTTP status", 200, status);
        Assert.assertTrue(
                "failure - expected HTTP response body to have a value",
                content.trim().length() > 0);


    }

    @Test
    public void serviceChargeByMonth() throws Exception {
        String url = "/finance/serviceCharge";
        ReportDayServicecharge reportDayServicecharge = new ReportDayServicecharge();
        reportDayServicecharge.setAppid(4);
        reportDayServicecharge.setDateStr("2016-03");
        logger.info("ReportDayServicecharge: " + gson.toJson(reportDayServicecharge));
        String inputJson = gson.toJson(reportDayServicecharge);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(inputJson))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();
        logger.info("content: " + content);
        Assert.assertEquals("failure - expected HTTP status", 200, status);
        Assert.assertTrue(
                "failure - expected HTTP response body to have a value",
                content.trim().length() > 0);
    }
}
