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

package com.adarsh.jdbc.properties;
/*
 * {@inheritDoc}
*/

/**
 * @Product : PropertiesReader provide implementation of the specification
 *                    provided for the reading the properties from the
 *                    property file.
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */

public class PropertiesReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesReader.class);
    private static final Properties PROPERTIES = new Properties();


    static {
        try {
            File file = getPropertyFile();
            FileInputStream fileInputStream = getFileInputStream(file);
            PROPERTIES.loadFromXML(fileInputStream);
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }
    }

    private static final File getPropertyFile() {
        try {
            File propertyFile = new File("src\\main\\resources\\application.xml");
            if (!propertyFile.canRead()) {
                throw new RuntimeException(propertyFile.getName() + " can't read ");
            }
            return propertyFile;
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }
        return null;
    }

    private static final FileInputStream getFileInputStream(final File fileObject) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileObject);
            return fileInputStream;
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }
        return null;
    }

    public static final String getProperty(final String key) {
        if (PROPERTIES.containsKey(key)) {
            return PROPERTIES.get(key) + "";
        }
        return null;
    }
}
