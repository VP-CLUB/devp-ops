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
public class WithdrawCashTest extends BaseMockMvcTest {

    private Gson gson = new Gson();

    //注入 被测试 controller
    @Autowired
    private WithdrawCashController withdrawCashController;

    @Mock
    private WithdrawCashService withdrawCashService;

    @Test
    public void Withdrawcash() throws Exception {
        String url = "/finance/withdrawcash";
        WithdrawCash withdrawcash = new WithdrawCash();
        withdrawcash.setAppid(4);
        withdrawcash.setPageNumber(2);
        withdrawcash.setPageSize(2);
        logger.info("WithdrawCash: " + gson.toJson(withdrawcash));
        String inputJson = gson.toJson(withdrawcash);
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
    public void insertWithdrawcash() throws Exception {
        String url = "/finance/insertWithdrawcash";
        WithdrawCash withdrawcash = new WithdrawCash();
        withdrawcash.setUserguid("77777");
        withdrawcash.setRealName("77777");
        withdrawcash.setCashMode(0);
        withdrawcash.setAppid(4);
        withdrawcash.setTransMoney(Long.valueOf(800));
        withdrawcash.setDescription("我正在提现");
        withdrawcash.setBankAccount("666666666666666");
        withdrawcash.setMerchantName("大熊");
        withdrawcash.setPassword("321321321");
        logger.info("withdrawcash: " + gson.toJson(withdrawcash));

        String inputJson = gson.toJson(withdrawcash);
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
    public void AdministratorWithdrawcash() throws Exception {
        String url = "/finance/administratorWithdrawcash";
        WithdrawCash withdrawcash = new WithdrawCash();
        withdrawcash.setPageSize(2);
        withdrawcash.setPageNumber(1);
        withdrawcash.setAppid(4);
        withdrawcash.setDateStr("2016-03-20 17:44:15");
        withdrawcash.setDateLastStr("2016-03-21 20:44:15");
        withdrawcash.setTransMoney(Long.valueOf(102));
        withdrawcash.setTransMoneyLast(Long.valueOf(1000002));
        //withdrawcash.setAuditstatus(0);
        //withdrawcash.setBankAccount("45454564645345");
        //withdrawcash.setStatus(1);
        //withdrawcash.setMerchantName("微");
        logger.info("withdrawcash: " + gson.toJson(withdrawcash));

        String inputJson = gson.toJson(withdrawcash);
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
    public void withdrawalProcessing() throws Exception {
        String url = "/finance/withdrawalProcessing";
        WithdrawCash withdrawcash = new WithdrawCash();
        withdrawcash.setId(54);
        withdrawcash.setStatus(2);
        withdrawcash.setWithdrawOrderno("00000000420160323115103757953682");
        withdrawcash.setHandler("大熊");
        withdrawcash.setHandlerDescription("不同意提现");
        logger.info("withdrawcash: " + gson.toJson(withdrawcash));

        String inputJson = gson.toJson(withdrawcash);
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
