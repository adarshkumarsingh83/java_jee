/*
 * Copyright © MeritTrac Services Pvt. Ltd.
 * All Rights Reserved.
 */

package com.adarsh.jdbc.test;
/*
 * {@inheritDoc}
*/

/**
 * @Product : TestConnection provide implementation of the specification
 *                    provided for the ...    
 */


import com.adarsh.jdbc.database.ConnectionFactory;
import com.adarsh.jdbc.properties.PropertiesReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author $CreatedBy Adarsh_K
 * @author $LastChangedBy: Adarsh_K
 * @version $Revision: 1.0 $, $Date:: 3/6/13 12:03 PM
 * @see
 */

public class TestConnection {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestConnection.class);
    protected Connection connection = null;
    protected Statement statementSELECT = null;
    protected Statement statementDELETE = null;
    protected Statement statementCREATE = null;
    private String databaseExists = null;
    private String deleteDatabase = null;
    private String createDatabase = null;

    @Before
    public void init() {
        connection = ConnectionFactory.getConnection();
        databaseExists = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '"
                + PropertiesReader.getProperty("dataSource.database") + "'";
        deleteDatabase = "DROP DATABASE IF EXISTS " + PropertiesReader.getProperty("dataSource.database");
        createDatabase = " CREATE DATABASE IF NOT EXISTS " + PropertiesReader.getProperty("dataSource.database");
    }


    @Test
    public void testConnection() throws Exception {
        statementSELECT = connection.createStatement();
        ResultSet resultSet = statementSELECT.executeQuery(databaseExists);
        if (resultSet != null && resultSet.next()) {
            statementDELETE = connection.createStatement();
            statementDELETE.executeUpdate(deleteDatabase);
        }
        statementCREATE = connection.createStatement();
        int result = statementCREATE.executeUpdate(createDatabase);
        LOGGER.info("Updated " + result);
    }

    @After
    public void close() throws Exception {
        if (statementSELECT != null && !statementSELECT.isClosed()) {
            statementSELECT.close();
        }
        if (statementDELETE != null && !statementDELETE.isClosed()) {
            statementDELETE.close();
        }
        if (statementCREATE != null && !statementCREATE.isClosed()) {
            statementCREATE.close();
        }
        if (!connection.isClosed()) {
            connection.close();
        }
    }

}
