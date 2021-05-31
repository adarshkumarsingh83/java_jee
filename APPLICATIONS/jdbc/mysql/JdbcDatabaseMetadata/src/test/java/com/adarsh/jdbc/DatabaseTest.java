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
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
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
