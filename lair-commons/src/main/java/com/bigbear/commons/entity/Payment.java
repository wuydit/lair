package com.bigbear.commons.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wuyd
 * 2021/9/18 16:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private long id;

    private String serial;

    public Payment(String serial) {
        this.serial = serial;
    }
}
