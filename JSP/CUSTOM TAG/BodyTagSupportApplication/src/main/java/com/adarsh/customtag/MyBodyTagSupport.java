package com.adarsh.customtag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

import static java.lang.System.out;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyBodyTagSupport extends BodyTagSupport {

    private static int counter;
    private String bodyData = "";
    private PageContext pageContext;
    private BodyContent bodyContent;

    static {
        out.println(" MyBodyTagSupport static blcok ");
    }

    {
        out.println(" MyBodyTagSupport instance blcok ");
    }

    public MyBodyTagSupport() {
        out.println(" MyBodyTagSupport constructor");
    }

    public void setCounter(int counter) {
        out.println(" MyBodyTagSupport setCounter()");
        this.counter = counter;
    }

    @Override
    public int doStartTag() throws JspException {
        out.println(" MyBodyTagSupport doStartTag()");
        return EVAL_BODY_BUFFERED;
    }

    @Override
    public void setBodyContent(BodyContent bodyContent) {
        out.println(" MyBodyTagSupport setBodyContent()");
        this.bodyContent = bodyContent;
    }

    @Override
    public void doInitBody() throws JspException {
        out.println(" MyBodyTagSupport doInitBody()");
    }


    @Override
    public int doAfterBody() throws JspException {
        bodyData += "<br/>" + bodyContent.getString().toUpperCase();
        out.println(" MyBodyTagSupport doAfterBody()");
        counter--;
        if (counter > 0) {
            return EVAL_BODY_AGAIN;
        } else {
            return SKIP_BODY;
        }
    }

    @Override
    public int doEndTag() throws JspException {
        out.println(" MyBodyTagSupport doEndTag()");
        try {
            bodyContent.getEnclosingWriter().println(bodyData);
        } catch (IOException exceptionObject) {
            exceptionObject.printStackTrace();
        }
        return EVAL_PAGE;
    }


    @Override
    public void release() {
        out.println(" MyBodyTagSupport release()");
    }

}
