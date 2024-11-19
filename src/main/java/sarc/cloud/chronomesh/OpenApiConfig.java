
package sarc.cloud.chronomesh;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        servers = {
        @Server(url = "https://improved-waddle-4p6w99xp4fjr49-8080.app.github.dev/"),
        @Server(url = "https://localhost:8080")}, 
        info = @Info(title = "Chronomesh", version = "v1", description = "Chronomesh is a Proxy for OpenSARC", 
        license = @License(name = "MIT License", url = "https://mit-license.org/"), 
        contact = @Contact(url = "http://github.com/sarccloud", name = "Mangan", email = "marco.mangan@pucrs.br")))
public class OpenApiConfig {

}