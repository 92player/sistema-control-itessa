package upc.eda.siscon;

import java.util.Scanner;

public class Inventario {

	public static void main(String[] args) {

		Scanner opcionSeleccionMenu = new Scanner(System.in);

		int opcionMenu = 0;
		boolean condicionMenu = true;

		/* Datos del Producto */
		int producto = 0;
		String nombreProducto[] = new String[producto];
		String tipoProducto[] = new String[producto];
		String pesoProducto[] = new String[producto];
		String anchuraProducto[] = new String[producto];
		String composicionProducto[] = new String[producto];
		String unidadProducto[] = new String[producto];
		String colorProducto[] = new String[producto];

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
				break;

			case 2:
				System.out.println("[2]Productos");
				System.out.print("Cantidad de productos a ingresar: ");

				producto = opcionSeleccionMenu.nextInt();
				opcionSeleccionMenu.nextLine();

				nombreProducto = new String[producto];
				tipoProducto = new String[producto];
				pesoProducto = new String[producto];
				anchuraProducto = new String[producto];
				composicionProducto = new String[producto];
				unidadProducto = new String[producto];
				colorProducto = new String[producto];

				for (int i = 0; i < producto; i++) {

					System.out.println("-> Producto " + (i + 1));
					System.out.print("Nombre: ");
					nombreProducto[i] = opcionSeleccionMenu.next();
					System.out.print("Tipo: ");
					tipoProducto[i] = opcionSeleccionMenu.next();
					System.out.print("Peso: ");
					pesoProducto[i] = opcionSeleccionMenu.next();
					System.out.print("Anchura: ");
					anchuraProducto[i] = opcionSeleccionMenu.next();
					System.out.print("Composicion: ");
					composicionProducto[i] = opcionSeleccionMenu.next();
					System.out.print("Unidad: ");
					unidadProducto[i] = opcionSeleccionMenu.next();
					System.out.print("Color: ");
					colorProducto[i] = opcionSeleccionMenu.next();

				}

				break;

			case 3:
				System.out.println("[3]Stock");
				System.out.println("Cantidad de productos disponibles");

				for (int i = 0; i < producto; i++) {
					System.out.println("-> Producto " + (i + 1));
					System.out.println("Nombre: " + nombreProducto[i]);
					System.out.println("Tipo: " + tipoProducto[i]);
					System.out.println("Peso: " + pesoProducto[i]);
					System.out.println("Anchura: " + anchuraProducto[i]);
					System.out.println("Composicion: " + composicionProducto[i]);
					System.out.println("Unidad: " + unidadProducto[i]);
					System.out.println("Color: " + colorProducto);
				}

				break;

			case 4:
				System.out.println("[4]Generar Orden");
				break;

			case 5:
				System.out.println("[5]Info");
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

}
