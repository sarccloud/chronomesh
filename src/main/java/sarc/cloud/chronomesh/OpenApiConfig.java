
package sarc.cloud.chronomesh;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers = {
        @Server(url = "https://improved-waddle-4p6w99xp4fjr49-8080.app.github.dev/") }, info = @Info(title = "the title", version = "v1", description = "My API", license = @License(name = "Apache 2.0", url = "http://foo.bar"), contact = @Contact(url = "http://gigantic-server.com", name = "Fred", email = "Fred@gigagantic-server.com")))
public class OpenApiConfig {

}