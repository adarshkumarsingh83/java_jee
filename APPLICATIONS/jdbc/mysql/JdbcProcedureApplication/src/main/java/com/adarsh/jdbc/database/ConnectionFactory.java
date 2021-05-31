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

package com.adarsh.jdbc.database;
/*
 * {@inheritDoc}
*/

/**
 * @Product : database provide implementation of the specification
 *                    provided for the ...    
 */


import com.adarsh.jdbc.properties.PropertiesReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */

public class ConnectionFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionFactory.class);
    private static Connection connection = null;
    private static String databaseUrl = null;
    private static final String driverClass = PropertiesReader.getProperty("dataSource.driverClass");
    private static final String url = PropertiesReader.getProperty("dataSource.url");
    private static final String hostname = PropertiesReader.getProperty("dataSource.hostname");
    private static final String portNumber = PropertiesReader.getProperty("dataSource.portNumber");
    private static final String dbName = PropertiesReader.getProperty("dataSource.database");
    private static final String extraParam = PropertiesReader.getProperty("dataSource.extraParam");
    private static final String username = PropertiesReader.getProperty("dataSource.username");
    private static final String password = PropertiesReader.getProperty("dataSource.password");

    static {
        try {
            Class.forName(driverClass);
            databaseUrl = url + hostname + portNumber + dbName + extraParam;
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }
    }

    public static final Connection getConnection() {
        try {
            connection = DriverManager.getConnection(databaseUrl, username, password);
            if(connection== null || connection.isClosed()){
                throw new RuntimeException("Connection is Null or Closed");
            }
            return connection;
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }
        return null;
    }

    public static final void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }
    }
}
