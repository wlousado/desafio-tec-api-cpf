package br.com.sicred.cpfvalidator;

import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CpfValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CpfValidatorApplication.class, args);
	}

	@GetMapping("/users/{cpf}")
	public ResponseEntity<CpfResponse> getUsers(@PathVariable String cpf){
		var response = CpfResponse.builder().build();
		var random = (int)Math.floor(Math.random() * (100 + 1) + 0);
		if (random % 2 == 0) {
			response.setStatus(StatusEnum.ABLE_TO_VOTE);
		} else {
			response.setStatus(StatusEnum.UNABLE_TO_VOTE);
		}
		return ResponseEntity.ok(response);
	}
}
