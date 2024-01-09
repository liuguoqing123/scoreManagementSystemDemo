package com.demo.common;


import com.demo.common.DateUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Generic Response Results
 *
 * @author Lewis
 */
@ToString
@Setter
@Getter
public class BaseResult implements Serializable {
    private static final long serialVersionUID = -3995201059328602867L;

    public static final int RESULT_CODE_OK = 200;
    public static final int RESULT_CODE_TOKEN = 401;
    /**
     * error
     */
    public static final int RESULT_CODE_ERROR = 500;
    public static final int RESULT_CODE_SUCCESS = 0;

    private int code;
    private String msg;
    private Object data;
    private String completedTime;

    public BaseResult() {
    }

    public BaseResult(int errCode, String msg, Object data) {
        this.code = errCode;
        this.msg = msg;
        this.data = data;
        this.completedTime = DateUtil.getCurrentDateWithYYYYMMDDHHMMSS2(new Date());
    }


    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }
}