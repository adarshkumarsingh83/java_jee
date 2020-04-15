package com.adarsh.wrapper.httpresponse;

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
public class MyHttpServletResponseWrapper extends HttpServletResponseWrapper {

    static {
        out.println("MyHttpServletResponseWrapper static block ");
    }

    {
        out.println("MyHttpServletResponseWrapper instance block ");
    }

    public MyHttpServletResponseWrapper(HttpServletResponse response) {
        super(response);
        out.println("MyHttpServletResponseWrapper constructor ");
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        out.println("MyHttpServletResponseWrapper getWriter() ");
        return super.getWriter();
    }

}
