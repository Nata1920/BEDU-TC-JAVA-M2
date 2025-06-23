package com.bedu.inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductoRepository repository, ProductoRepository productoRepo, MarcaRepository marcaRepo) {
		return (args) -> {
			//marcas
			Marca apple = marcaRepo.save(new Marca("Apple"));
			Marca samsung = marcaRepo.save(new Marca("Samsung"));
			Marca logitech = marcaRepo.save(new Marca("Logitech"));



			productoRepo.save(new Producto("MacBook Pro", "laptop de 16 pulgadas", 2500.00, apple));
			productoRepo.save(new Producto("iPhone 15", "Smartphone flagship", 1200.00, apple));
			productoRepo.save(new Producto("Galaxy S23", "Smartphone Android", 1000.00, samsung));
			productoRepo.save(new Producto("Smart TV QLED", "TV 55 pulgadas", 1500.00, samsung));
			productoRepo.save(new Producto("Teclado mecánico", "Switch azul", 800.00, logitech));
			productoRepo.save(new Producto("Mouse MX Master", "Ergonomico inalambrico", 100.00, logitech));


			// Mostrar productos por marca
			System.out.println("📚 Productos por marca:");
			marcaRepo.findAll().forEach(marca -> {
				System.out.println("🏷️ " + marca.getNombre() + ":");
				productoRepo.findAll().stream()
						.filter(p -> p.getMarca().getId().equals(marca.getId()))
						.forEach(p -> System.out.println("   - " + p.getNombre()));
			});

		};
	}
}