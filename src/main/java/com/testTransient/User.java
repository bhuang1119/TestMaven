package com.testTransient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in
 * @Modified By:
 */

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    public String username;
    private transient String passwd;


    public  String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
