package com.gestionfinanciera.artigoajava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArtigoajavaApplication {

	public static int minValue(int n1, int n2){
		return (n1 < n2) ? n1 : n2;
	}
	public static void main(String[] args)
	{
		SpringApplication.run(ArtigoajavaApplication.class, args);
	}

}
