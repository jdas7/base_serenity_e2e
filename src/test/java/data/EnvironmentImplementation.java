package data;

import com.automation.jdas7.exceptions.NotValidEnvironmentException;
import net.thucydides.core.annotations.Step;
import org.aeonbits.owner.ConfigFactory;

public class EnvironmentImplementation implements Environment {

    private Environment environment;

    @Step("Validar que existen datos de prueba para el ambiente especificado")
    public void initEnvironment() throws NotValidEnvironmentException {
        if (environment == null) {
            environment = ConfigFactory.create(Environment.class);
        }
        if (environment.toString().equals("{}")) {
            throw new NotValidEnvironmentException(
                "  Cause: Not a valid environment, or not specified. Please use -Denvironment=env_name to set a valid environment");
        }
    }

    @Override
    public String usuario() {
        return environment.usuario();
    }

}
