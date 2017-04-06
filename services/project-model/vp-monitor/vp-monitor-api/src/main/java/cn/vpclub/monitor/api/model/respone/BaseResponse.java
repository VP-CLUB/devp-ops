package cn.vpclub.monitor.api.model.respone;

import java.io.Serializable;

/**
 * 接口返回基类
 *
 * Created by admin on 2016/3/10.
 */
public class BaseResponse implements Serializable {
    /**
     * 请求结果
     * 1000:成功; 1001:无权限访问; 1004:服务器处理异常; 1005:失败; 1006:参数不全;
     * 2003:交易订单已经支付; 3001:支付方式错误
     */
    protected Integer returnCode;

    /**
     * 错误信息
     */
    protected String message;

    /**
     * Default Constructor
     */
    public BaseResponse() {
        super();
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
