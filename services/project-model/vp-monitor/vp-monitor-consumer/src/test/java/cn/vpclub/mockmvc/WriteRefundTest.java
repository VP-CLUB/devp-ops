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
 * Created by WeiPin on 2016/3/22.
 */
public class WriteRefundTest extends BaseMockMvcTest {


    //注入 被测试 controller
    @Autowired
    private WriteRefundController writeRefundController;

    @Mock
    private WriteRefundCommonService writeRefundCommonService;

    @Test
    public void writeRefund() throws Exception {
        String url = "/finance/writeRefund";
        RequestTransactionRefund requestTransactionRefund = new RequestTransactionRefund();
        requestTransactionRefund.setAppid(4);
        requestTransactionRefund.setMerchOrderno("56356434");
        requestTransactionRefund.setPayTradeno("4444444444444444444");
        requestTransactionRefund.setPayTitle("退款");
        requestTransactionRefund.setPayAmount(500);
        requestTransactionRefund.setPayRemark("haha");
        requestTransactionRefund.setPayMethod(14);
        //requestTransactionRefund.setRefundCompleteTime(DateUtils.parseDate("2016-03-22 20:24:16","yyyy-MM-dd HH:mm:ss"));
        requestTransactionRefund.setRefundOrderno("4444444444444444444444444444");
        requestTransactionRefund.setRefundAmount(5200);
        requestTransactionRefund.setBuyerName("王五");
        requestTransactionRefund.setBuyerEmail("473073956@qq.com");
        requestTransactionRefund.setBuyerTelephone("4153131531");
        String inputJson = JsonUtil.objectToJson(requestTransactionRefund);
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
