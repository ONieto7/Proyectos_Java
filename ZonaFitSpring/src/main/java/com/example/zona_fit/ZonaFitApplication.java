package com.example.zona_fit;

import com.example.zona_fit.servicio.IClienteServicio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {

	@Autowired
	private IClienteServicio clienteServicio;

	private static final Logger logger =
            LoggerFactory.getLogger(ZonaFitApplication.class);

	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicación");
		//Levantar la fabrica de Spring
		SpringApplication.run(ZonaFitApplication.class, args);
		logger.info("Aplicación Finalizada");

	}

	@Override
	public void run(String... args) throws Exception {
		zonaFitApp();
	}

	private void zonaFitApp() {
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir){
			var opcion = mostraMenu(consola);
			//salir = ejecutarOciones(consola, opcion);
			logger.info(nl);
		}
	}

	private int mostraMenu(Scanner consola) {
		logger.info("""
				\n*** Aplicación Zona Fit ***
					1.Listar Clientes
					2.Buscar Cliente
					3.Agregar Cliente
					4.Modifcar Claiente
					5.Eliminar Cliente
					6.Salir
				Elige una opcion:\s""");
		var opcion = Integer.parseInt(consola.nextLine());
		return opcion;
	}
}
