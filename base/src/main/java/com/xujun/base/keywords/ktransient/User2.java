package com.xujun.base.keywords.ktransient;

import java.io.Serializable;

/**
 * @todo
 * @author xujun
 * @version 1.0
 * @date 2018年4月8日 下午2:33:20
 */

public class User2 implements Serializable {

    private static final long serialVersionUID = -5830664130075189270L;
    private static String username;
    private transient String password;

    public User2() {}

    /**
     * @param username
     * @param password
     */
    public User2(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }



}
