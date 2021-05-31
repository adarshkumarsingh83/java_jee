package com.adarsh.web.construct;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$.
 */
public class Request {

    private String view = "";
    private String link = "";
    private String className = "";
    private String method = "";
    private String success = "";
    private String fail = "";

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getFail() {
        return fail;
    }

    public void setFail(String fail) {
        this.fail = fail;
    }

    @Override
    public String toString() {
        return "Request{" +
                "view='" + view + '\'' +
                ", link='" + link + '\'' +
                ", className='" + className + '\'' +
                ", method='" + method + '\'' +
                ", success='" + success + '\'' +
                ", fail='" + fail + '\'' +
                '}';
    }
}
