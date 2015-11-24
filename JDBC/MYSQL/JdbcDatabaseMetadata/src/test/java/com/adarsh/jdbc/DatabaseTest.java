/*
 * Copyright © MeritTrac Services Pvt. Ltd.
 * All Rights Reserved.
 */

package com.adarsh.jdbc;
/*
 * {@inheritDoc}
*/

/**
 * @Product : DatabaseTest provide implementation of the specification
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
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * @author $CreatedBy Adarsh_K
 * @author $LastChangedBy: Adarsh_K
 * @version $Revision: 1.0 $, $Date:: 4/6/13 9:08 AM
 * @see
 */

public class DatabaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseTest.class);
    protected Connection connection = null;
    private String databaseInfoQuery = null;
    private String databaseTableInfoQuery = null;
    protected Statement statementSELECT = null;

    @Before
    public void init() throws Exception {
        connection = ConnectionFactory.getConnection();
        statementSELECT = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,
                             ResultSet.CONCUR_READ_ONLY);
        databaseInfoQuery = PropertiesReader.getProperty("dataSource.sqlDatabaseInfo") + "'"
                + PropertiesReader.getProperty("dataSource.database") + "'";
        databaseTableInfoQuery = PropertiesReader.getProperty("dataSource.sqlDatabaseTableInfo") + "'"
                + PropertiesReader.getProperty("dataSource.database") + "'";
    }


    @Test
    public void testDataBaseInfo() throws Exception {
        ResultSet resultSet = statementSELECT.executeQuery(databaseInfoQuery);
        if (resultSet != null) {
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                final int count = resultSetMetaData.getColumnCount();
                for (int i = 1; i <= count; i++) {
                    LOGGER.info(resultSetMetaData.getColumnName(i) + " = " + resultSet.getObject(i));
                }
            }
        }
    }

    @Test
    public void testDataBaseTableInfo() throws Exception {
        ResultSet resultSet = statementSELECT.executeQuery(databaseTableInfoQuery);
        if (resultSet != null) {
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                final int count = resultSetMetaData.getColumnCount();
                for (int i = 1; i <= count; i++) {
                    if(resultSetMetaData.getColumnName(i).equalsIgnoreCase("TABLE_CATALOG")){
                        System.out.println("\n");
                    }
                    LOGGER.info(resultSetMetaData.getColumnName(i) + " = " + resultSet.getObject(i));
                }
            }
        }
    }

    @After
    public void close() throws Exception {
        if (statementSELECT != null && !statementSELECT.isClosed()) {
            statementSELECT.close();
        }
        if (!connection.isClosed()) {
            connection.close();
        }
    }
}
