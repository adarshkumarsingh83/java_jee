package com.adarsh.web.construct;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$.
 */
public class XmlReader {

    public Map<String, Request> loadData() throws Exception {
        Map<String, Request> requestMap = new HashMap<String, Request>();

        XStream xstream = new XStream(new DomDriver());
        xstream.alias("resource", Resource.class);
        xstream.alias("request", Request.class);
        xstream.useAttributeFor(Request.class, "view");
        xstream.aliasField("view", Request.class, "view");
        xstream.aliasField("link", Request.class, "link");
        xstream.aliasField("className", Request.class, "className");
        xstream.aliasField("method", Request.class, "method");
        xstream.aliasField("success", Request.class, "success");
        xstream.aliasField("fail", Request.class, "fail");

        xstream.addImplicitCollection(Resource.class, "request");
        Resource resource = (Resource) xstream.fromXML(
                new FileInputStream(new File("src\\main\\resources\\application.xml")));

        List<Request> requestList = resource.getRequest();
        for (int i = 0; i < requestList.size(); i++) {
            Request request = (Request) requestList.get(i);
            requestMap.put(request.getLink(), request);
        }
        return requestMap;
    }
}
