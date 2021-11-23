package com.jerv.gendra_pt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@EnableAsync
@OpenAPIDefinition(info = @Info(title = "GendraPt API", version = "0.1", description = "Gendra Prueba Tecnica", 
contact = @Contact(email = "josue.riveravr@gmail.com",name = "Josue Rivera", url = "https://github.com/J0Z88/gendra_pt"))
,servers = @Server(url = "https://gendrapt.uc.r.appspot.com/",description = "Servidor Pruebas")

)
public class GendraPtApplication {

	public static void main(String[] args) {
		SpringApplication.run(GendraPtApplication.class, args);
	}
	

}
