package com.robson_gds.appContato;

import com.robson_gds.appContato.dto.ContatoMinDTO;
import com.robson_gds.appContato.projections.ContatoMinProjection;
import com.robson_gds.appContato.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class AppContatoApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppContatoApplication.class, args);
	}
}
