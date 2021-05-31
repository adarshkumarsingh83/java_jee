package com.adarsh.simpletag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

import static java.lang.System.out;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyWish implements SimpleTag {

    private String userName;
    protected JspTag jspTag = null;
    protected JspContext jspContext = null;
    protected JspFragment jspFragment = null;

    static {
        out.println("MyWish static blcok");
    }

    {
        out.println("MyWish instance blcok");
    }

    public MyWish() {
        out.println("MyWish constructor");
    }

    @Override
    public void setParent(JspTag jspTag) {
        this.jspTag = jspTag;
    }

    @Override
    public JspTag getParent() {
        return jspTag;
    }

    @Override
    public void setJspContext(JspContext jspContext) {
        this.jspContext = jspContext;
    }

    @Override
    public void setJspBody(JspFragment jspFragment) {
        this.jspFragment = jspFragment;
    }

    @Override
    public void doTag() throws JspException, IOException {
        jspContext.getOut().write(userName);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
