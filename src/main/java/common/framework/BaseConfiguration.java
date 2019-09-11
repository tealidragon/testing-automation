package common.framework;

import java.util.Properties;

class BaseConfiguration {
    private Properties configFile;

    BaseConfiguration() {
        configFile = new Properties();

        try {
            configFile.load(this.getClass().getClassLoader().getResourceAsStream("base.properties"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    String getProperty(String key) {
        return this.configFile.getProperty(key);
    }
}
