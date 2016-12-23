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
public class UserBankcardTest extends BaseMockMvcTest {

    private Gson gson = new Gson();

    //注入 被测试 controller
    @Autowired
    private UserBankcardController userBankcardController;

    @Mock
    private UserBankcardService userBankcardService;


    /**
     * 提现账户-显示用户绑定银行卡数据
     *
     * @throws IOException
     * @throws ParseException
     */
    @Test
    public void userBankcard() throws Exception {
        String url = "/finance/userBankcard";
        UserBankcard userBankcard = new UserBankcard();
        userBankcard.setAppid(4);
        logger.info("UserBankcard: " + gson.toJson(userBankcard));
        String inputJson = gson.toJson(userBankcard);
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
     * 解绑
     *
     * @throws IOException
     * @throws ParseException
     */
    @Test
    public void unbundlingBankAccount() throws Exception {
        String url = "/finance/unbundlingBankAccount";
        UserBankcard userBankcard = new UserBankcard();
        userBankcard.setId(2);
        logger.info("UserBankcard: " + gson.toJson(userBankcard));
        String inputJson = gson.toJson(userBankcard);
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
     * 查询用户是否绑定银行卡（账户-账号安全）
     *
     * @throws IOException
     * @throws ParseException
     */
    @Test
    public void selectBankAccount() throws Exception {
        String url = "/finance/selectBankAccount";
        UserBankcard userBankcard = new UserBankcard();
        userBankcard.setAppid(4);
        logger.info("UserBankcard: " + gson.toJson(userBankcard));
        String inputJson = gson.toJson(userBankcard);
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
     * 提现账户-未绑定页面
     *
     * @throws IOException
     * @throws ParseException
     */
    @Test
    public void insertuserBankcardUnbound() throws Exception {
        String url = "/finance/insertuserBankcardUnbound";
        UserBankcard userBankcard = new UserBankcard();
        userBankcard.setEnterpriseAccount("中兴微品有限公司");
        userBankcard.setAccountType(1);
        userBankcard.setUserguid("555555555");
        userBankcard.setBankAccount("555555555");
        userBankcard.setBankName("中国农业银行");
        userBankcard.setProvince("广东省");
        userBankcard.setCity("深圳市");
        userBankcard.setArea("南山区");
        userBankcard.setBankSubbranch("白石洲支行");
        userBankcard.setAppid(4);
        logger.info("UserBankcard: " + gson.toJson(userBankcard));
        String inputJson = gson.toJson(userBankcard);
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
     * 签约-绑定银行卡审核(显示全部的银行卡信息)
     *
     * @throws IOException
     * @throws ParseException
     */
    @Test
    public void showAllBankcode() throws Exception{
        String url = "/finance/showAllBankcode";
        UserBankcard userBankcard = new UserBankcard();
        userBankcard.setAppid(4);
        userBankcard.setPageNumber(1);
        userBankcard.setPageSize(2);
        logger.info("UserBankcard: " + gson.toJson(userBankcard));
        String inputJson = gson.toJson(userBankcard);
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
     * 签约-银行卡审核(改状态)
     *
     * @throws IOException
     * @throws ParseException
     */
    @Test
    public void updateBankAccountIsIdentity() throws Exception {
        String url = "/finance/updateBankAccountIsIdentity";
        UserBankcard userBankcard = new UserBankcard();
        userBankcard.setId(17);
        userBankcard.setIsIdentity(0);
        logger.info("UserBankcard: " + gson.toJson(userBankcard));
        String inputJson = gson.toJson(userBankcard);
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
