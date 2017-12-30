package com.ghip.aaa.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by jpedro on 07/12/2017.
 */
public class UsernamePasswordException  extends AuthenticationException{
    public UsernamePasswordException(String msg) {
        super(msg);
    }

    public UsernamePasswordException(String msg, Throwable t) {
        super(msg, t);
    }

}
