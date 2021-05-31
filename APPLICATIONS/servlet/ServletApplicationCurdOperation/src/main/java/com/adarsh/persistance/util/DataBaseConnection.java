package com.adarsh.persistance.util;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */

import java.io.FileInputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataBaseConnection implements Cloneable, Serializable {

    private static String dbUrl = null;
    private static String userName = null;
    private static String userPwd = null;
    private static String dbDriverClass = null;
    private static Connection connectionObject = null;

    static {
        try {
            Properties propertiesFile = new Properties();
            propertiesFile.loadFromXML(new FileInputStream("src\\main\\resources\\MsSqlDataBaseProperties.xml"));
            dbDriverClass = propertiesFile.getProperty("db-driver-class");
            dbUrl = propertiesFile.getProperty("db-url");
            userName = propertiesFile.getProperty("db-user");
            userPwd = propertiesFile.getProperty("db-user-pwd");
        } catch (Exception exceptionObject) {
            exceptionObject.printStackTrace();
        }
    }

    public static Connection getDataBaseConnection() {
        try {
            Class.forName(dbDriverClass);
            connectionObject = DriverManager.getConnection(dbUrl, userName, userPwd);
        } catch (Exception exceptionObject) {
            exceptionObject.printStackTrace();
        } finally {
            return connectionObject;
        }
    }
}
