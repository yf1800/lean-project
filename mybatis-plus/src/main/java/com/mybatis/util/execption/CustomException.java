package com.mybatis.util.execption;

import com.mybatis.util.enmu.RestCode;
import lombok.Data;
import org.jetbrains.annotations.NotNull;


/**
 *  异常处理类
 */
@Data
public class CustomException extends RuntimeException {

    static final long serialVersionUID = -7034897190745766949L;

    private Integer code;


    public CustomException() {
        super();
    }

    public CustomException(Integer code) {
        this.code = code;
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public CustomException(@NotNull RestCode restCode) {
		this(restCode.code, restCode.msg);
    }

    protected CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
