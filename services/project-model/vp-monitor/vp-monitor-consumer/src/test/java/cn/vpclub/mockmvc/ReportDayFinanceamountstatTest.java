package cn.vpclub.mockmvc;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by Administrator on 2016/3/14.
 */
public class ReportDayFinanceamountstatTest extends BaseMockMvcTest {

    private Gson gson = new Gson();


    //注入 被测试 controller
    @Autowired
    private ReportDayFinanceamountstatController reportDayFinanceamountstatController;

    @Mock
    private ReportDayFinanceamountstatService reportDayFinanceamountstatService;

    /**
     * 对账-账务汇总(按天)
     *
     * @throws IOException
     * @throws ParseException
     */
    @Test
    public void reportDayFinanceamountstatGatherByDay() throws Exception {
        String url = "/finance/reportDayFinanceamountstatGather";
        ReportDayFinanceamountstat reportDayFinanceamountstat = new ReportDayFinanceamountstat();
        reportDayFinanceamountstat.setAppid(4);
        reportDayFinanceamountstat.setDateStr("2016-03");
        logger.info("ReportDayFinanceamountstat: " + gson.toJson(reportDayFinanceamountstat));
        String inputJson = gson.toJson(reportDayFinanceamountstat);
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

    /**
     * 对账-账务汇总(按月)
     *
     * @throws IOException
     * @throws ParseException
     */
    @Test
    public void reportDayFinanceamountstatGatherByMonth() throws Exception {
        String url = "/finance/reportDayFinanceamountstatGather";
        ReportDayFinanceamountstat reportDayFinanceamountstat = new ReportDayFinanceamountstat();
        reportDayFinanceamountstat.setAppid(4);
        reportDayFinanceamountstat.setDateStr("2016");
        logger.info("ReportDayFinanceamountstat: " + gson.toJson(reportDayFinanceamountstat));
        String inputJson = gson.toJson(reportDayFinanceamountstat);
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
