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
	public CommandLineRunner demo(ProductoRepository repository) {
		return (args) -> {
			System.out.println("guardar productos");
			repository.save(new Producto("Laptop", "Portátil de 16 pulgadas", 1200.00));
			repository.save(new Producto("Teclado mecánico", "Switch azul", 800.00));
			repository.save(new Producto("Mouse gamer", "Alta precisión", 600.00));
			repository.save(new Producto("Monitor", "Monitor 24 pulgadas 4K", 900.00));


			// Imprimir todos los productos con precio mayor a 500
			System.out.println("\nProductos con precio > $500:");
			repository.findByPrecioGreaterThan(500.00).forEach(System.out::println);

			// Imprimir productos que contengan "lap" en su nombre (case insensitive)
			System.out.println("\nProductos que contienen 'lap' en el nombre:");
			repository.findByNombreContainingIgnoreCase("lap").forEach(System.out::println);

			// Imprimir productos con precio entre 400 y 1000
			System.out.println("\nProductos con precio entre $400 y $1000:");
			repository.findByPrecioBetween(400.00, 1000.00).forEach(System.out::println);


			System.out.println("\nProductos que comienzan con 'M' o 'm':");
			repository.findByNombreStartingWithIgnoreCase("m").forEach(System.out::println);
		};
	}
}