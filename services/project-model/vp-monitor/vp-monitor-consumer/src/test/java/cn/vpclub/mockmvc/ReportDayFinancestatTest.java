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
public class ReportDayFinancestatTest extends BaseMockMvcTest {

    private Gson gson = new Gson();

    //注入 被测试 controller
    @Autowired
    private ReportDayFinancestatController reportDayFinancestatController;

    @Mock
    private ReportDayFinancestatService reportDayFinancestatService;

    /**
     * 账户概况(按日)
     *
     * @throws IOException
     * @throws ParseException
     */
    @Test
    public void ReportDayFinancestatByparamsByDay() throws Exception {
        String url = "/finance/reportDayFinancestatByparams";
        ReportDayFinancestat reportDayFinancestat = new ReportDayFinancestat();
        reportDayFinancestat.setAppid(4);
        reportDayFinancestat.setDateStr("2016-03-07");
        logger.info(gson.toJson(reportDayFinancestat));
        String inputJson = gson.toJson(reportDayFinancestat);
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
     * 账户概况(按月)
     *
     * @throws IOException
     * @throws ParseException
     */
    @Test
    public void ReportDayFinancestatByparamsByMounth() throws Exception {
        String url = "/finance/reportDayFinancestatByparams";
        ReportDayFinancestat reportDayFinancestat = new ReportDayFinancestat();
        reportDayFinancestat.setAppid(4);
        reportDayFinancestat.setDateStr("2016-03-01");
        reportDayFinancestat.setDateLastStr("2016-03-08");
        logger.info(gson.toJson(reportDayFinancestat));
        String inputJson = gson.toJson(reportDayFinancestat);
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
