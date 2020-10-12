package com.example.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Http返回的对象模型
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class R<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体数据
     */
    private T data;
}
