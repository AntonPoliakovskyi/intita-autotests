package core;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class IntitaProperties {

    private final static String PATH_TO_PROPERTIES = "properties" + File.separator + "intita.properties";
    private static Properties properties = new Properties();

    public static Properties getProperties() {
        try {
            InputStream inputStream = IntitaProperties.class.getClassLoader().getResourceAsStream(PATH_TO_PROPERTIES);
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

}