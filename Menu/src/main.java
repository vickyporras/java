import java.util.Scanner;

public class main {
	
	
	
	

	public static void main(String[] args) {
		
	
		Scanner scanner = new Scanner(System.in);
		int opcion;
		Funciones funcion = new Funciones();
		
		do {
			System.out.println("-- MENU --");
			System.out.println("1: CREAR TAREA ");
			System.out.println("2: BORRAR TAREA ");
			System.out.println("3: EDITAR TAREA  ");
			System.out.println("4: ACTUALIZAR TAREA");
			System.out.println("5: SALIR ");
			
			opcion = scanner.nextInt();
			scanner.nextLine();

			
			switch(opcion) {
				case 1:
					System.out.println("HAS ELEGIDO LA OPCIÓN 1 ");
					System.out.println("ESCRIBE QUE TAREA QUIERES CREAR");
					String tarea = scanner.nextLine();
					funcion.crearTarea(tarea);
					break;
				case 2:
					System.out.println("HAS ELEGIDO LA OPCIÓN 2 ");
					System.out.println("ESTAS SON LAS TAREAS QUE HAY, ESCRIBE CUAL QUIERES BORRAR: "+ funcion.lista);
					tarea=scanner.nextLine();
					funcion.borrarTarea(tarea);
					break;
				case 3:
					System.out.println("HAS ELEGIDO LA OPCIÓN 3 ");
					System.out.println("ESTAS SON LAS TAREAS QUE HAY, ESCRIBE CUAL QUIERES EDITAR: "+ funcion.lista);
					tarea=scanner.nextLine();
					System.out.println("QUE NUEVA TAREA QUIERES PONER EN SU LUGAR? ESCRIBELA");
					String nuevaTarea=scanner.nextLine();
					funcion.editarTarea(nuevaTarea);
					break;
				case 4:
					System.out.println("HAS ELEGIDO LA OPCIÓN 4 ");
					/*NS QUE QUIERE DECIR CON ACTUALIZAR*/
					tarea=scanner.nextLine();
					funcion.actualizarTarea(tarea);
					break;
				default:
					System.out.println("ADIOS :)");
			}
			
		} while(opcion != 5);
		
		

	}

}
