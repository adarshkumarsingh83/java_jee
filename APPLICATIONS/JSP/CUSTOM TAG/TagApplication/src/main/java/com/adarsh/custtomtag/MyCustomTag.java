package com.adarsh.custtomtag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import static java.lang.System.out;
/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyCustomTag implements Tag {

    private String userName;
    private PageContext pageContext;

    static {
        out.println("MyCustomTag static block");
    }

    {
        out.println("MyCustomTag instance block");
    }

    public MyCustomTag() {
        out.println("MyCustomTag cosntructor");
    }

    @Override
    public void setPageContext(PageContext pageContext) {
        out.println("MyCustomTag setPageContext()");
        this.pageContext = pageContext;
    }

    @Override
    public void setParent(Tag parentTag) {
        out.println("MyCustomTag setParent()");
    }

    public void setUserName(String userName) {
        this.userName = userName;
        out.println("MyCustomTag setUserName()");
    }

    @Override
    public int doStartTag() throws JspException {
        out.println("MyCustomTag doStartTag()");
        try {
            this.pageContext.getOut().println("<br/><h1>" + this.userName.toUpperCase() + "</h1>");
        } catch (Exception exceptionObject) {
            exceptionObject.printStackTrace();
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        out.println("MyCustomTag doEndTag()");
        return EVAL_PAGE;
    }

    @Override
    public Tag getParent() {
        out.println("MyCustomTag getParent()");
        return null;
    }


    @Override
    public void release() {
        out.println("MyCustomTag release()");
    }

}
