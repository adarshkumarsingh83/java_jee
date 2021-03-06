package com.adarsh.wrapper.response;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyResponseWrapper extends HttpServletResponseWrapper {

    static {
        out.println("MyResponseWrapper static blcok");
    }

    {
        out.println("MyResponseWrapper instance blcok");
    }

    public MyResponseWrapper(ServletResponse response) {
        super((HttpServletResponse) response);
        out.println("MyResponseWrapper constructor");
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        out.println("MyResponseWrapper getWriter()");
        return super.getWriter();
    }
}
