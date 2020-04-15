package com.adarsh.simpletag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

import static java.lang.System.out;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyWish extends SimpleTagSupport {

    private String userName;

    static {
        out.println("MyWish static block");
    }

    {
        out.println("MyWish instance block");
    }

    public MyWish() {
        out.println("MyWish constructor");
    }

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().write(userName);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
