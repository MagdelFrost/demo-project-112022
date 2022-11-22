package market.plati.config.platimarket;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/platimarket/app.properties"
})
public interface AppConfig extends Config {

    String webUrl();
    String apiUrl();
    String userLogin();
    String userPassword();

}
