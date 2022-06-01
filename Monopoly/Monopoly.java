import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Monopoly {
	public static Jugador decidirTurno(ArrayList<Jugador> jugadores) {
		int RNG = (int)Math.floor(Math.random()*(jugadores.size()-1+1)+1);
		System.out.println("Se ha tirado un dado de " + jugadores.size() + " caras y ha salido... " + RNG + "! por lo tanto, comienza el jugador " + RNG +": " + jugadores.get(RNG-1).getNombre());
		
		return jugadores.get(RNG-1);	
	}
	
	public static int tirarDados() {
		int dado1 = (int)Math.floor(Math.random()*(6-1+1)+1);
		System.out.println("Tiras el primer dado y sacas... " + dado1 + "!");
		int dado2 = (int)Math.floor(Math.random()*(6-1+1)+1);
		System.out.println("Tiras el segundo dado y sacas..." + dado2 + "!");
		
		return dado1+dado2;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calle[] listaCalles = Calle.values();
		String[] facciones = {"ALIANZA", "HORDA"};
		ArrayList<String> figurasAlianza = new ArrayList<String>(Arrays.asList("HUMANO", "ENANO", "ELFO NOCTURNO", "GNOMO"));
		ArrayList<String> figurasHorda = new ArrayList<String>(Arrays.asList("ORCO", "TROLL", "TAUREN", "NO-MUERTO"));
		int numJugadores;
		String nombre;
		String faccionElegida = null;
		String figuraElegida;
		boolean esCelia = false;
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		Jugador primerTurno;
		int posicionPrimerTurno;
		int jugadoresAlianza = 0;
		int jugadoresHorda = 0;
		double dineroAlianza = 0;
		double dineroHorda = 0;
		double sumaAlianza = 0;
		double sumaHorda = 0;
		int ronda = 1;
		int dados;
		int avance;
		int accion;
		
		
		// Creando el tablero
		Tablero miTablero = new Tablero(10, listaCalles);
		System.out.println(miTablero);
		
		// Creando jugadores.
		do {
			System.out.println("Selecciona el numero de jugadores (minimo 2; maximo 8): ");
			numJugadores = Integer.parseInt(sc.nextLine());
		} while (numJugadores < 2 || numJugadores > 8);
		for (int i = 1; i <= numJugadores; i++) {
			esCelia = false;
			System.out.println("Jugador " + i +", introduce tu nombre: ");
			nombre = sc.nextLine();
			if (nombre.equals("Celia") || nombre.equals("celia") || nombre.equals("CELIA")) {
				System.out.println("Asi que eres " + nombre + ", eh? Como se que vas a criticar este programa, empiezas la partida con 200 oros menos");
				esCelia = true;
			}
			if (i == 1) {
				System.out.println("Como eres el jugador 1, puedes elegir que bando quieres:\n1. Alianza\n2. Horda");
				faccionElegida = facciones[(Integer.parseInt(sc.nextLine())-1)];
			} else {
				if (faccionElegida == "ALIANZA") {
					faccionElegida = "HORDA";
					System.out.println("Te toca en el bando de la " + faccionElegida);
				} else {
					faccionElegida = "ALIANZA";
					System.out.println("Te toca en el bando de la " + faccionElegida);
				}	
			}
			if (faccionElegida == "ALIANZA") {
				System.out.println("Selecciona que figura deseas de las siguientes (selecciónala con un su número de orden):");
				for (int j = 1; j <= figurasAlianza.size(); j++) {
					System.out.println(j + "." +figurasAlianza.get(j-1));
				}
				figuraElegida = figurasAlianza.get(Integer.parseInt(sc.nextLine())-1);
				figurasAlianza.remove(figuraElegida);
			} else {
				System.out.println("Selecciona que figura deseas de las siguientes (selecciónala con un su número de orden):");
				for (int j = 1; j <= figurasHorda.size(); j++) {
					System.out.println(j + "." + figurasHorda.get(j-1));
				}
				figuraElegida = figurasHorda.get(Integer.parseInt(sc.nextLine())-1);
				figurasHorda.remove(figuraElegida);
			}
			jugadores.add(new Jugador(nombre, faccionElegida, figuraElegida));
			if (esCelia == true) {
				jugadores.get(i-1).setDinero(jugadores.get(i-1).getDinero()-200);
			}
		}
		
		// Sumando "los dineros" de los jugadores a su faccion:
		for (Jugador jugador : jugadores) {
			if (jugador.getFaccion() == "ALIANZA") {
				jugadoresAlianza += 1;
				dineroAlianza += jugador.getDinero();
			} else {
				jugadoresHorda +=1;
				dineroHorda += jugador.getDinero();
			}
		}
		System.out.println("Hay " + jugadoresAlianza + " jugadores de la alianza. En total suman un botin de " + dineroAlianza + " oros.");
		System.out.println("Hay " + jugadoresHorda + " jugadores de la horda. En total suman un botin de " + dineroHorda + " oros.");
		
		// Decidiendo el primer turno
		System.out.println("Se va a decidir quien comienza:");
		primerTurno = decidirTurno(jugadores);
		posicionPrimerTurno = jugadores.indexOf(primerTurno);
		jugadores.remove(posicionPrimerTurno);
		jugadores.add(0, primerTurno);
		
		// Jugando.
		while (dineroAlianza > 0 && dineroHorda > 0) {
			sumaAlianza = 0;
			sumaHorda = 0;
			System.out.println("Comienza la ronda " + ronda + ".");
			for (Jugador jugador : jugadores) {
				System.out.println("Es el turno de " + jugador.getNombre() + "!");
				dados = tirarDados();
				if (jugador.getPosicion()+dados > miTablero.getNumCalles()) {
					if ((jugador.getPosicion()+dados)%miTablero.getNumCalles() != 0) {
						avance = (jugador.getPosicion()+dados)%miTablero.getNumCalles();
					} else {
						avance = 1;
					}
					System.out.println("Has pasado por la casilla de inicio! Ganas 100 oros como recompensa");
					jugador.setDinero(jugador.getDinero()+100);
				} else {
					avance = jugador.getPosicion()+dados;
				}
				jugador.setPosicion(avance);
				System.out.println(jugador.getNombre() + " avanza hasta la casilla " + jugador.getPosicion());
				if (miTablero.getCalle(jugador.getPosicion()-1).getEnPropiedad() == false) {
					System.out.println("Esta casilla se corresponde con la calle " + miTablero.getCalle(jugador.getPosicion()-1) + ", la cual no tiene ningun propietario");
					do {
					System.out.println("¿Que quieres hacer?\n1. Comprar calle \n2. Ver precio de la calle\n3. Ver tu dinero\n4. Ver dinero de tu faccion\n5. Ver tus propiedades\n6. Pasar");
					accion = Integer.parseInt(sc.nextLine());
					switch(accion) {
						case 1:
							if (jugador.getDinero() > miTablero.getCalle(jugador.getPosicion()-1).getPrecioVenta()) {
								jugador.setDinero(jugador.getDinero()-miTablero.getCalle(jugador.getPosicion()-1).getPrecioVenta());
								jugador.aniadirPropiedad(miTablero.getCalle(jugador.getPosicion()-1));
								miTablero.getCalle(jugador.getPosicion()-1).setEnPropiedad(true);
								miTablero.getCalle(jugador.getPosicion()-1).setPropietario(jugador);
								System.out.println("Has comprado esta calle. Ahora te quedan " + jugador.getDinero() + "oros.");
							} else {
								System.out.println("No tienes dinero para comprar esta propiedad, pobreton");
							}
							break;
						case 2:
							System.out.println("Esta calle vale " + miTablero.getCalle(jugador.getPosicion()-1).getPrecioVenta() + " oros.");
							break;
						case 3:
							System.out.println("Tienes " + jugador.getDinero() + " oros.");
							break;
						case 4:
							if (jugador.getFaccion() == "ALIANZA") {
								System.out.println("La ALIANZA tiene " + dineroAlianza + " oros.");
							} else {
								System.out.println("La HORDA tiene " + dineroHorda + " oros.");
							}
							break;
						case 5:
							System.out.println("Tienes las siguientes calles en propiedad: " + jugador.getPropiedades());
							break;
						case 6:
							System.out.println("Pasas tu turno.");
							break;
						}
					} while (accion != 6 && miTablero.getCalle(jugador.getPosicion()-1).getPropietario() != jugador);
				} else {
					System.out.println("Esta casilla se corresponde con la calle " + miTablero.getCalle(jugador.getPosicion()-1) +", la cual pertenece a " + miTablero.getCalle(jugador.getPosicion()-1).getPropietario().getNombre() +".");
					if (miTablero.getCalle(jugador.getPosicion()-1).getPropietario() == jugador) {
						do {
							System.out.println("Esta calle es de tu propiedad. Que quieres hacer?\n1. Vender calle\n2. Ver precio de la calle\n3. Ver tu dinero\n4. Ver dinero de tu faccion\n5. Ver tus propiedadades\n6. Salir");
							accion = Integer.parseInt(sc.nextLine());
							switch(accion) {
							case 1:
								jugador.setDinero(jugador.getDinero()+(miTablero.getCalle(jugador.getPosicion()-1).getPrecioVenta())/2);
								jugador.retirarPropiedad(miTablero.getCalle(jugador.getPosicion()-1));
								miTablero.getCalle(jugador.getPosicion()-1).setEnPropiedad(false);
								System.out.println("Has vendido esta propiedad por " + (miTablero.getCalle(jugador.getPosicion()-1).getPrecioVenta())/2 + " oros.");
								break;
							case 2:
								System.out.println("Esta calle vale " + miTablero.getCalle(jugador.getPosicion()-1).getPrecioVenta() + " oros.");
								break;
							case 3:
								System.out.println("Tienes " + jugador.getDinero() + " oros.");
								break;
							case 4:
								if (jugador.getFaccion() == "ALIANZA") {
									System.out.println("La ALIANZA tiene " + dineroAlianza + " oros.");
								} else {
									System.out.println("La HORDA tiene " + dineroHorda + " oros.");
								}
								break;
							case 5:
								System.out.println("Tienes las siguientes calles en propiedad: " + jugador.getPropiedades());
								break;
							case 6:
								System.out.println("Pasas tu turno.");
								break;
							}
						} while (accion != 6 && miTablero.getCalle(jugador.getPosicion()-1).getEnPropiedad() == true);
					} else {
						if (miTablero.getCalle(jugador.getPosicion()-1).getPropietario().getFaccion() == jugador.getFaccion()) {
							System.out.println("Como pertenece a tu misma faccion, no tienes que pagar nada.");
						} else {
							System.out.println("Esta calle pertenece a la faccion contraria. Tienes que pagar un tributo de " + miTablero.getCalle(jugador.getPosicion()-1).getPrecioAlquiler() + "oros.");
							jugador.setDinero(jugador.getDinero()-miTablero.getCalle(jugador.getPosicion()-1).getPrecioAlquiler());
						}
					}
				}
			}
			System.out.println("Ha acabado la ronda " + ronda + ". Se va a proceder a recalcular los botines de faccion.");
			for (Jugador jugador : jugadores) {
				if (jugador.getFaccion() == "ALIANZA") {
					sumaAlianza += jugador.getDinero();
				} else {
					sumaHorda += jugador.getDinero();
				}
			}
			dineroAlianza = sumaAlianza;
			dineroHorda = sumaHorda;
			System.out.println("Hay " + jugadoresAlianza + " jugadores de la alianza. En total suman un botin de " + dineroAlianza + " oros.");
			System.out.println("Hay " + jugadoresHorda + " jugadores de la horda. En total suman un botin de " + dineroHorda + " oros.");
			ronda += 1;
			
				
		}
		
		if (dineroAlianza <= 0 && dineroHorda >= 0) {
			System.out.println("La HORDA a conquistado Azeroth. Lok'tar Ogar!!");
		} else if (dineroHorda <= 0 && dineroAlianza >= 0) {
			System.out.println("La ALIANZA se ha expandido por todo Azeroth. Por el rey!!");
		} else if (dineroHorda <= 0 && dineroAlianza >=0) {
			System.out.println("Tanto la ALIANZA como la HORDA estan en bancarrota. Es el comienzo de una tregua...");
		}
		
	}
}
