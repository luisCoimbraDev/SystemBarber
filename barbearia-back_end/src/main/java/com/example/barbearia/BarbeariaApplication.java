package com.example.barbearia;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.example.barbearia",
		"com.example.barbeariafront_end"
})
public class BarbeariaApplication  {

	public static void main(String[] args){
		SpringApplication.run(BarbeariaApplication.class, args);

	}


}
