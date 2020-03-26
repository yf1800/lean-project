package com.mybatis.util.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.mybatis.util.enmu.RestCode;
import lombok.Data;
import lombok.ToString;


//返回的对象
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@ToString
public class ResponseObject<T> {

    /**
     * 结果码
     */
    private int code;
    /**
     * 信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    public ResponseObject() {
        this(RestCode.success);
    }

    public ResponseObject(T result) {
        this(RestCode.success);
        this.data = result;
    }

    public ResponseObject(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseObject(RestCode restCode)
    {
        this(restCode.code,restCode.msg);
    }

    public ResponseObject(RestCode restCode, T result) {
        this(restCode);
        this.data = result;
    }
    public ResponseObject(int code, String msg, T result) {
        this(code,msg);
        this.data = result;
    }

    /**
     * 饭后成功
     * @param <T>
     * @return
     */
    public static <T> ResponseObject<T> success() {
        return new ResponseObject<T>();
    }
    /**
     *
     */
    public static  <T> ResponseObject<T> success(T result){
        return new ResponseObject(result);
    }


    /**
     * 返回对象的时候返回 code msg 对象
     */
    public static <T> ResponseObject<T> error(RestCode code, T result) {
        ResponseObject<T> response = new ResponseObject<T>(code.code, code.msg, result);
        return response;
    }

    public static <T> ResponseObject<T> error(int code, String message, T result) {
        return new ResponseObject<>(code, message, result);
    }

    public static ResponseObject error(Integer code, String message) {
        return new ResponseObject(code,message);
    }

    public static ResponseObject error() {
        return new ResponseObject(RestCode.systemError);
    }
}

