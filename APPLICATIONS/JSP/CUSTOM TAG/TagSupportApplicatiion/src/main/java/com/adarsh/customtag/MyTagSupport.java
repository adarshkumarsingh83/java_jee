package com.adarsh.customtag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import static java.lang.System.out;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyTagSupport extends TagSupport {

    private static int counter;
    private String name;

    static {
        out.println("MyTagSupport static blcok");
    }

    {
        out.println("MyTagSupport instacne blcok");
    }

    public MyTagSupport() {
        out.println("MyTagSupport constructor");
    }


    @Override
    public void setPageContext(PageContext pageContext) {
        out.println("MyTagSupport setPageContext()");
        super.setPageContext(pageContext);
    }

    @Override
    public void setParent(Tag t) {
        out.println("MyTagSupport setParent()");
        super.setParent(t);
    }

    public void setCounter(int counter) {
        out.println("MyTagSupport setCounter()");
        this.counter = counter;
    }

    public void setName(String name) {
        out.println("MyTagSupport setName()");
        this.name = name;
    }

    @Override
    public int doStartTag() throws JspException {
        out.println("MyTagSupport doStartTag()");
        return EVAL_BODY_INCLUDE;
    }


    @Override
    public int doAfterBody() throws JspException {
        out.println("MyTagSupport doAfterBody()");
        counter--;
        try {
            pageContext.getOut().println("<br/>" + name.toUpperCase() + "<br/>");
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
        out.println("MyTagSupport doEndTag()");
        return EVAL_PAGE;
    }

    @Override
    public Tag getParent() {
        out.println("MyTagSupport getParent()");
        return super.getParent();
    }

}
