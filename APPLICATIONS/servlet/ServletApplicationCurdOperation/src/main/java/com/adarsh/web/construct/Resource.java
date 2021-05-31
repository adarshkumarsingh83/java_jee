package com.adarsh.web.construct;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$.
 */
public class Resource {

    private List<Request> request = new ArrayList<Request>();

    public Resource() {
    }


    public List<Request> getRequest() {
        return request;
    }

    public void setRequest(List<Request> request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "request=" + request +
                '}';
    }
}
