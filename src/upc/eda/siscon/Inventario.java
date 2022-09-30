package upc.eda.siscon;

import java.util.LinkedList;
import java.util.Scanner;

public class Inventario {

	/* Datos del Producto */
	static LinkedList nombreProducto = new LinkedList();
	static LinkedList tipoProducto = new LinkedList();
	static LinkedList pesoProducto = new LinkedList();
	static LinkedList anchuraProducto = new LinkedList();
	static LinkedList composicionProducto = new LinkedList();
	static LinkedList colorProducto = new LinkedList();
	static LinkedList stockProducto = new LinkedList();

	public static void main(String[] args) {

		Scanner opcionSeleccionMenu = new Scanner(System.in);

		int opcionMenu = 0;
		boolean condicionMenu = true;

		agregarDummys();

		/* Datos de Solicitud de Productos */
		LinkedList solicitud = new LinkedList();

		/* Datos de Orden de Compra */
		LinkedList ordenCompra = new LinkedList();

		while (condicionMenu) {
			System.out.println(" -----------------");
			System.out.println("|[1]Menu");
			System.out.println("|[2]Productos");
			System.out.println("|[3]Stock");
			System.out.println("|[4]Generar Orden");
			System.out.println("|[5]Info");
			System.out.println("|[0]Salir");
			System.out.println(" -----------------");
			System.out.print("Seleccionar Opcion ---> ");
			opcionMenu = opcionSeleccionMenu.nextInt();

			switch (opcionMenu) {
			case 1:
				System.out.println("[1]Menu");
				System.out.println("Retornando al menu principal");
				break;

			case 2:
				System.out.println("[2]Productos");
				System.out.print("Cantidad de productos a ingresar: ");

				int producto = opcionSeleccionMenu.nextInt();
				opcionSeleccionMenu.nextLine();

				for (int i = 0; i < producto; i++) {

					System.out.println("-> Producto " + (i + 1));
					System.out.print("Nombre: ");
					nombreProducto.add(opcionSeleccionMenu.next());
					System.out.print("Tipo: ");
					tipoProducto.add(opcionSeleccionMenu.next());
					System.out.print("Peso: ");
					pesoProducto.add(opcionSeleccionMenu.next());
					System.out.print("Anchura: ");
					anchuraProducto.add(opcionSeleccionMenu.next());
					System.out.print("Composicion: ");
					composicionProducto.add(opcionSeleccionMenu.next());
					System.out.print("Color: ");
					colorProducto.add(opcionSeleccionMenu.next());
					System.out.print("Stock: ");
					stockProducto.add(opcionSeleccionMenu.nextInt());

				}

				break;

			case 3:
				System.out.println("[3]Stock");
				System.out.println("Cantidad de productos disponibles");

				for (int i = 0; i < nombreProducto.size(); i++) {
					System.out.println("-> Producto " + (i + 1));
					System.out.println("\t Nombre \t: " + nombreProducto.get(i));
					System.out.println("\t Tipo \t\t: " + tipoProducto.get(i));
					System.out.println("\t Peso \t\t: " + pesoProducto.get(i));
					System.out.println("\t Anchura \t: " + anchuraProducto.get(i));
					System.out.println("\t Composicion \t: " + composicionProducto.get(i));
					System.out.println("\t Color \t\t: " + colorProducto.get(i));
					System.out.println("\t Stock \t\t: " + stockProducto.get(i));
				}

				break;

			case 4:
				System.out.println("[4]Generar Orden");
				System.out.print("Nombre de producto: ");
				String nombre = opcionSeleccionMenu.next();

				// Validar si existen productos registrados
				if (nombreProducto.size() == 0) {
					System.out.println("No se tiene registrado ningun producto.");
				}

				int cantidadEncontrada = 0;

				for (int i = 0; i < nombreProducto.size(); i++) {
					if (nombreProducto.get(i).equals(nombre)) {

						System.out.print("Indicar cantidad de producto: ");
						int cantidadSolicitada = opcionSeleccionMenu.nextInt();
						int stockActual = Integer.parseInt(stockProducto.get(i).toString());

						if (cantidadSolicitada > stockActual) {
							System.out.println("No hay stock del producto solicitado. Se ha generado una OC.");
							ordenCompra.add(
									"Nombre producto: " + nombreProducto.get(i) + " - Cantidad: " + cantidadSolicitada);
						} else {
							solicitud.add(
									"Nombre producto: " + nombreProducto.get(i) + " - Cantidad: " + cantidadSolicitada);
							stockProducto.set(i, stockActual - cantidadSolicitada);
							System.out.println("Solicitud ha sido realizada con exito.");
						}
						cantidadEncontrada++;

					}
				}

				if (cantidadEncontrada == 0) {
					System.out.println("No se tiene registrado producto con ese nombre.");
				}

				break;

			case 5:
				System.out.println("[5]Info");
				System.out.println("*************** Integrantes Grupo 03 ***************");
				System.out.println("- Francisco Javier Espinoza");
				System.out.println("- Jhordan Soria Miranda");
				System.out.println("- Enrique Becerra");
				break;

			case 0:
				condicionMenu = false;
				System.out.println("Desea Salir del Programa");
				Scanner opcionSeleccionSalir = new Scanner(System.in);
				System.out.print("Ingrese ['Si' o 's' /'No' o 'n']: ");

				String opcionSalir = opcionSeleccionSalir.nextLine();
				if (opcionSalir.equals("Si") || opcionSalir.equals("s")) {
					condicionMenu = false;
					System.out.println("Salio con Exito");

				} else {
					condicionMenu = true;
					System.out.println("Regresando al Menu Principal");
				}

				break;

			default:
				System.out.println("Opcion no encontrada!!");
				break;
			}

		}
	}

	static void agregarDummys() {

		// Producto 01
		nombreProducto.add("Algodon");
		tipoProducto.add("Natural");
		pesoProducto.add("120g/m2");
		anchuraProducto.add("145cm");
		composicionProducto.add("100%Algodón");
		colorProducto.add("Blanco");
		stockProducto.add("20");

		// Producto 02
		nombreProducto.add("Seda");
		tipoProducto.add("Natural");
		pesoProducto.add("150g/m2");
		anchuraProducto.add("145cm");
		composicionProducto.add("100%Poliester");
		colorProducto.add("Verde");
		stockProducto.add("10");

	}

}
