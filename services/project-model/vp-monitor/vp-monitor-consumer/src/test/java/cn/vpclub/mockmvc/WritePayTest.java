package cn.vpclub.mockmvc;

import cn.vpclub.upload.manager.common.utils.JsonUtil;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


/**
 * Created by Administrator on 2016/3/21.
 */
public class WritePayTest extends BaseMockMvcTest {


    //注入 被测试 controller
    @Autowired
    private WritePayController writePayController;

    @Mock
    private WritePayCommonService writePayCommonService;


    /**
     * 支付写入(插入交易明细表,更新资金账户)
     *
     * @return
     */
    @Test
    public void WritePay() throws Exception {
        String url = "/finance/writePay";
        RequestTransactionRecord requestTransactionRecord = new RequestTransactionRecord();
        requestTransactionRecord.setAppid(4);
        requestTransactionRecord.setPayPlatform(3);
        requestTransactionRecord.setPayMethod(14);
        requestTransactionRecord.setMerchOrderno("85858585");
        requestTransactionRecord.setPayTradeno("6666666666666");
        requestTransactionRecord.setPayTitle("《暗黑破坏神3:凯恩之书》");
        requestTransactionRecord.setPayRemark("支付宝支付测试");
        requestTransactionRecord.setCreateTime(DateUtils.parseDate("2016-03-17 16:10:24","yyyy-MM-dd HH:mm:ss"));
        logger.info("CreateTime: "+requestTransactionRecord.getCreateTime());
        requestTransactionRecord.setPayTime(DateUtils.parseDate("2016-03-17 19:53:15","yyyy-MM-dd HH:mm:ss"));
        requestTransactionRecord.setStatus(2);
        requestTransactionRecord.setModifyTime(DateUtils.parseDate("2016-03-17 19:53:15","yyyy-MM-dd HH:mm:ss"));
        requestTransactionRecord.setIsDelete(0);
        requestTransactionRecord.setBackTradeno("201603177167275175");
        requestTransactionRecord.setBuyerName("张三");
        requestTransactionRecord.setBuyerEmail("1531351351");
        requestTransactionRecord.setBuyerTelephone("1533135153531");
        requestTransactionRecord.setServiceCharge(10);
        requestTransactionRecord.setTransactionFee(10);
        requestTransactionRecord.setTradeAmount(1000);
        String inputJson = JsonUtil.objectToJson(requestTransactionRecord);
        logger.info("inputJson: "+inputJson);
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
