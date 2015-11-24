package com.adarsh.customtag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;

import static java.lang.System.out;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyBodyTag implements BodyTag {

    private static int counter;
    private PageContext pageContext;
    private BodyContent bodyContent;
    private String tagData;
    private JspWriter jspWriter;

    static {
        out.println("MyBodyTag static block");
        counter = 0;
    }

    {
        out.println("MyBodyTag instance block");
    }

    public MyBodyTag() {
        out.println("MyBodyTag constructor");
    }

    @Override
    public void setPageContext(PageContext pageContext) {
        out.println("MyBodyTag setPageContext()");
        this.pageContext = pageContext;
    }

    @Override
    public void setParent(Tag parentTag) {
        out.println("MyBodyTag setParent()");
    }

    @Override
    public int doStartTag() throws JspException {
        out.println("MyBodyTag doStartTag()");
        return EVAL_BODY_BUFFERED;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public void setBodyContent(BodyContent bodyContent) {
        this.bodyContent = bodyContent;
        out.println("MyBodyTag setBodyContent()");
    }

    @Override
    public void doInitBody() throws JspException {
        out.println("MyBodyTag doInitBody()");
    }

    @Override
    public int doAfterBody() throws JspException {
        tagData = "<br/>" + bodyContent.getString().toUpperCase();
        jspWriter = bodyContent.getEnclosingWriter();
        out.println("MyBodyTag doAfterBody()");
        counter--;
        try {
            jspWriter.println(tagData);
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
        out.println("MyBodyTag doEndTag()");
        return EVAL_PAGE;
    }

    @Override
    public Tag getParent() {
        out.println("MyBodyTag getParent()");
        return null;
    }

    @Override
    public void release() {
        out.println("MyBodyTag release()");
    }

}
