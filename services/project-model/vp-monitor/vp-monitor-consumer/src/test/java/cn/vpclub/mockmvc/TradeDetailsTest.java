package cn.vpclub.mockmvc;

import cn.vpclub.upload.manager.common.utils.JsonUtil;
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

public class TradeDetailsTest extends BaseMockMvcTest {

    private Gson gson = new Gson();

    //注入 被测试 controller
    @Autowired
    private TradeDetailsController tradeDetailsController;

    @Mock
    private TradeDetailsService tradeDetailsService;

    /**
     * 账务明细
     *
     * @throws IOException
     * @throws ParseException
     */
    @Test
    public void tradeDetailsAll() throws Exception {
        String url = "/finance/tradeDetailsAll";
        TradeDetails tradeDetails = new TradeDetails();
        tradeDetails.setAppid(4);
        tradeDetails.setDateStr("2016-03-18 00:54:43");
        tradeDetails.setDateLastStr("2016-03-19 23:54:43");
        tradeDetails.setPageNumber(1);
        tradeDetails.setPageSize(4);
        tradeDetails.setTransAmount(Long.valueOf(100));
        tradeDetails.setTransAmountLast(Long.valueOf(20000));
        /*tradeDetails.setDirectionType(0);
        tradeDetails.setBusinessOrderno("0002162562326266523623");
        tradeDetails.setTransPhone("13632816003");
        tradeDetails.setPayMethod(14);*/
        JsonUtil.objectToJson("TradeDetails: " + gson.toJson(tradeDetails));
        String inputJson = gson.toJson(tradeDetails);
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
