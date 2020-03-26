
package com.mybatis.util.enmu;

/**
 * @author liuliu
 * @version V1.0
 * @ClassName: RestCode
 * @Function: 统一返回前端的结果
 * @Date: 2020/3/10 14:55
 */
public enum RestCode {


    success(1,"success"),
    requestParamError(10,"请求参数错误"),
    systemError(11,"系统错误"),
    returnObjectIsNull(12,"返回对象为空"),
    objectIsNull(13,"对象不存在"),
    paramNotMatchingCode(14, "传入的参数不匹配"),
    incomingobjectIsNull(15,"传入对象为空"),
    incomingParamIsNull(16,"传入参数为空");

    public final Integer code;
    public final String msg;

    private RestCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}

