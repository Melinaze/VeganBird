package juego;

import javax.sound.sampled.Clip;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Pajaro pajaro;
	private Arraytuberias tuberiasArriba;
	private Arraytuberias tuberiasAbajo;
	private Disparador disparador;
	private Hamburguesas hamburguesas;
	private Pantalla pantalla;
	private Puntaje puntaje;
	private Vegetales vegetales;
	Boolean vegetal=false;
	


	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Vegan Bird- V0.01", 800, 600);
		pajaro = new Pajaro (150,300);
		disparador = new Disparador (150,260);
		tuberiasArriba = new Arraytuberias (4);
		tuberiasAbajo = new Arraytuberias (4);
		tuberiasArriba.llenarTuberiasArriba();  // LLENO LAS TUBERIAS ASI NO SE REGENERAN CONSTANTEMENTE EN TICK
		tuberiasAbajo.llenarTuberiasArriba();
		hamburguesas = new Hamburguesas (1);
		hamburguesas.cargarHamburguesas();
		vegetales = new Vegetales (5);
		vegetales.cargarVegetales();
		pantalla = new Pantalla (410,320);
		puntaje = new Puntaje(550, 40);
		Clip fondo= Herramientas.cargarSonido("sonidos/fondo.wav");
		fondo.start();
		fondo.loop(Clip.LOOP_CONTINUOUSLY);  // reproduce el sonido una y otra vez sin parar
		

		// Inicia el juego!
		this.entorno.iniciar();


	}
	public final char TECLA_s = 115;
	public final char TECLA_w = 119
			;

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		// ...
		pantalla.dibujarFondo(entorno);
		pajaro.dibujarse(entorno);
		vegetales.dibujarVegetales(entorno);
		vegetales.moverVegetales();
		tuberiasArriba.dibujarTuberiasArriba(entorno);
		tuberiasAbajo.dibujarTuberiasAbajo(entorno);
		tuberiasArriba.moverTuberiasArriba();
		tuberiasAbajo.moverTuberiasAbajo();
		disparador.dibujarse(entorno);
		hamburguesas.dibujarHamburguesas(entorno);
		hamburguesas.moverHamburguesas();

		if (!pajaro.estaMuerto()) {
			if (entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
				pajaro.mover();
				disparador.mover();
			} else if (entorno.estaPresionada(TECLA_s)){
				disparador.girar(Herramientas.radianes(2));
			} else if (entorno.estaPresionada(TECLA_w)) {
				disparador.girar(Herramientas.radianes(-2));
			} else if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {
				disparador.llenarDisparo();
				Clip disparo= Herramientas.cargarSonido("sonidos/disparo.wav");
				disparo.start();
			} else {
				pajaro.caer();
				disparador.caer();
			}

			if (disparador.disparos.size() > 0) {
				disparador.dibujarDisparos(entorno);
				disparador.moverDisparos();
				if (disparador.colisionConHamburguesas(hamburguesas.getHamburguesas())) {
					vegetal=true;
					puntaje.sumarPuntosHamburguesaTransformada();
					disparador.sacarDisparo(0);
					Clip explosion= Herramientas.cargarSonido("sonidos/explosion.wav");
					explosion.start();
					System.out.println("TRANSFORMAR A VEGETAL");
				}
				
			}


			if (tuberiasArriba.colisionArriba(pajaro.x, pajaro.y) || tuberiasAbajo.colisionAbajo(pajaro.x, pajaro.y)) {
				pajaro.setEstaMuerto(true);
				Clip bum= Herramientas.cargarSonido("sonidos/golpe1.wav");
				bum.start();
			}

			if (hamburguesas.colisionesHamburguesas(entorno, pajaro.x, pajaro.y)) {
				if(vegetal) {
					puntaje.sumarPuntosVegetalComido();
					vegetal=false;}
				else {
					Clip error= Herramientas.cargarSonido("sonidos/error.wav");
					error.start();
					puntaje.restarPuntosHamburguesaComida();
					System.out.println("comer hambur");}
			} else if (vegetales.colisionesVegetales(pajaro.x, pajaro.y)){
				Clip bien= Herramientas.cargarSonido("sonidos/correcto.wav");
				bien.start();
				puntaje.sumarPuntosVegetalComido();
				System.out.println("comer vegetal");
			}

		}	
		else {
			pantalla.dibujarse(entorno);
			if (entorno.estaPresionada(entorno.TECLA_ENTER)) {
					pajaro = new Pajaro (150,300);
					disparador = new Disparador(150,260);
					puntaje.puntajeVolverAcero();
					hamburguesas = new Hamburguesas (2);
					vegetales = new Vegetales (5);
					tuberiasArriba = new Arraytuberias (4);
					tuberiasAbajo = new Arraytuberias (4);
					vegetales.cargarVegetales();
					hamburguesas.cargarHamburguesas();
					tuberiasArriba.llenarTuberiasArriba();  // LLENO LAS TUBERIAS ASI NO SE REGENERAN CONSTANTEMENTE EN TICK
					tuberiasAbajo.llenarTuberiasArriba();
			}
		}
		puntaje.dibujarPuntaje(entorno, "PUNTAJE", puntaje.getPuntaje() );
	
	}

	



	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}





		

						