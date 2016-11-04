/*
 * Copyright (c) 2015 Espark And ©Adarsh Development Services @copyright All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Espark nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.espark.adarsh;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = {"/myServletMultipleUrl", "*.do", "/myServlet/myServlet"}
        , name = "MyServlet"
        , description = "My Annotation Servlet"
        , displayName = "MyServlet"
        , loadOnStartup = 1
        , initParams = {
        @WebInitParam(name = "param1", value = "value1"),
        @WebInitParam(name = "param2", value = "value2")
}
)
/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
public class MyServletMultipleUrl extends HttpServlet {


    private static final Logger log = LoggerFactory.getLogger(MyServletMultipleUrl.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("MyServlet doGet()");
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("MyServlet doPost()");
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletConfig servletConfig = super.getServletConfig();
        String paramValue1 = servletConfig.getInitParameter("param1");
        String paramValue2 = servletConfig.getInitParameter("param2");
        response.setContentType("text/plain");
        response.getWriter().write(new Date().toString() + " Param1 " + paramValue1 + "  Param2 " + paramValue2);
    }

}