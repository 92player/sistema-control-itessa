package upc.eda.siscon;

import java.util.LinkedList;
import java.util.Scanner;

public class Inventario {

	public static void main(String[] args) {

		Scanner opcionSeleccionMenu = new Scanner(System.in);

		int opcionMenu = 0;
		boolean condicionMenu = true;

		/* Datos del Producto */
		LinkedList nombreProducto = new LinkedList();
		LinkedList tipoProducto = new LinkedList();
		LinkedList pesoProducto = new LinkedList();
		LinkedList anchuraProducto = new LinkedList();
		LinkedList composicionProducto = new LinkedList();
		LinkedList unidadProducto = new LinkedList();
		LinkedList colorProducto = new LinkedList();		
		LinkedList stockProducto = new LinkedList();
		
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
					System.out.print("Unidad: ");
					unidadProducto.add(opcionSeleccionMenu.next());
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
					System.out.println("Nombre: " + nombreProducto.get(i));
					System.out.println("Tipo: " + tipoProducto.get(i));
					System.out.println("Peso: " + pesoProducto.get(i));
					System.out.println("Anchura: " + anchuraProducto.get(i));
					System.out.println("Composicion: " + composicionProducto.get(i));
					System.out.println("Unidad: " + unidadProducto.get(i));
					System.out.println("Color: " + colorProducto.get(i));
					System.out.println("Stock: " + stockProducto.get(i));
				}

				break;

			case 4:
				System.out.println("[4]Generar Orden");
				System.out.print("Nombre de producto: ");
				String nombre = opcionSeleccionMenu.next();
				
				if(nombreProducto.size() == 0) {
					System.out.println("No se tiene registrado ningun producto.");
				}
				
				boolean existe = false;
				
				for (int i = 0; i < nombreProducto.size(); i++) {
					if(nombreProducto.get(i).equals(nombre)) {
						
						System.out.print("Indicar cantidad de producto: ");
						int cantidadSolicitada = opcionSeleccionMenu.nextInt();
						int stockActual = Integer.parseInt(stockProducto.get(i).toString());
						
						if(cantidadSolicitada > stockActual) {
							System.out.println("No hay stock del producto solicitado. Se ha generado una OC.");
							ordenCompra.add("Nombre producto: "+nombreProducto.get(i)+" - Cantidad: "+cantidadSolicitada);
						} else {
							solicitud.add("Nombre producto: "+nombreProducto.get(i)+" - Cantidad: "+cantidadSolicitada);
							stockProducto.set(i, stockActual - cantidadSolicitada);
							System.out.println("Solicitud ha sido realizada con exito.");
						}
						existe = true;
					}
				}
				
				if(!existe){
					System.out.println("Producto no encontrado.");					
				} else {
					existe = false;
				}
				
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
