package data;
import com.automation.jdas7.exceptions.NotValidEnvironmentException;
import com.automation.jdas7.exceptions.UserNotFoundException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.HashMap;
import java.util.Optional;

public class DataProvider {
    @Steps(shared = true)
    private EnvironmentImplementation environment;

    JsonObject userData;

    @Step("Verificar si el rol tiene data de prueba")
    public void setUserRole(String clientType)
        throws UserNotFoundException, NotValidEnvironmentException {
        environment.initEnvironment();
        JsonParser parser = new JsonParser();
        String data = null;
        HashMap<String, String> userScenario = new HashMap<>();
        userScenario.put("usuario de gmail", environment.usuario());

        data = userScenario.get(clientType);
        Optional<String> dataOptional = Optional.ofNullable(data);
        String dataVerified = dataOptional
            .orElseThrow(() -> new UserNotFoundException("Type of user does not exist in the system"));
        this.userData = parser.parse(dataVerified).getAsJsonObject();
    }

    public JsonObject getUserData() {
        return this.userData;
    }
}
