package data;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:pro.properties"})

public interface Environment extends Config {

    String usuario();

}
