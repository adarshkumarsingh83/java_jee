/*
 * Copyright © MeritTrac Services Pvt. Ltd.
 * All Rights Reserved.
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
import java.util.Properties;

/**
 * @author $CreatedBy Adarsh_K
 * @author $LastChangedBy: Adarsh_K
 * @version $Revision: 1.0 $, $Date:: 3/6/13 11:51 AM
 * @see
 */

public class ConnectionFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionFactory.class);
    private static Connection connection = null;
    private static final String driverClass = PropertiesReader.getProperty("dataSource.driverClass");
    private static final String url = PropertiesReader.getProperty("dataSource.url");
    private static final String hostname = PropertiesReader.getProperty("dataSource.hostname");
    private static final String portNumber = PropertiesReader.getProperty("dataSource.portNumber");
    private static final String username = PropertiesReader.getProperty("dataSource.username");
    private static final String password = PropertiesReader.getProperty("dataSource.password");

    public static final Connection getConnection() {
        final String databaseUrl = url + hostname + portNumber;
        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(databaseUrl, username, password);
            return connection;
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }
        return null;
    }

}
