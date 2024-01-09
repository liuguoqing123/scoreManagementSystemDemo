package com.demo.common;

import lombok.experimental.UtilityClass;

/**
 * Results tool class
 *
 * @author Lewis
 */
@UtilityClass
public class BaseResultUtil {
    public static BaseResult result(Object data) {
        return result(data, BaseResult.RESULT_CODE_OK, "success");
    }

    public static BaseResult resultError(ExceptionData data) {
        return resultError(MessageUtils.get(data.getErrCode()), data);
    }

    public static BaseResult resultError(String msg, ExceptionData data) {
        return result(data, BaseResult.RESULT_CODE_ERROR, msg);
    }

    public static BaseResult resultTokenError(String msg, Object data) {
        return result(data, BaseResult.RESULT_CODE_TOKEN, msg);
    }

    public static BaseResult result(Object data, int code, String msg) {
        return new BaseResult(code, msg, data);
    }
}
