package com.adarsh.customtag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

import static java.lang.System.out;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyIteratoinTag implements IterationTag {

    private PageContext pageContext;
    private static int counter;
    private String name;


    static {
        counter = 0;
        out.println("MyIteratoinTag static block");
    }

    {
        name = "";
        out.println("MyIteratoinTag instance block");
    }

    public MyIteratoinTag() {
        out.println("MyIteratoinTag constructor");
    }


    @Override
    public void setPageContext(PageContext pageContext) {
        out.println("MyIteratoinTag setPageContext()");
        this.pageContext = pageContext;
    }

    @Override
    public void setParent(Tag arg0) {
        out.println("MyIteratoinTag setParent()");
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int doStartTag() throws JspException {
        out.println("MyIteratoinTag doStartTag()");
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doAfterBody() throws JspException {
        out.println("MyIteratoinTag doAfterBody()");
        counter--;
        try {
            this.pageContext.getOut().println("<br/><h1>" + this.name + "</h1>");
        } catch (Exception exceptionObject) {
            exceptionObject.printStackTrace();
        }
        if (counter > 0) {
            return EVAL_BODY_AGAIN;
        } else {
            return SKIP_BODY;
        }
    }

    @Override
    public int doEndTag() throws JspException {
        out.println("MyIteratoinTag doEndTag()");
        return EVAL_PAGE;
    }

    @Override
    public Tag getParent() {
        out.println("MyIteratoinTag getParent()");
        return null;
    }

    @Override
    public void release() {
        out.println("MyIteratoinTag release()");
    }

}
