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
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
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
