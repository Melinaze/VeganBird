package juego;
import entorno.Entorno;
import entorno.Herramientas;

import java.awt.Color;
import java.awt.Image;


public class Obstaculo {
	double x;
	double y;
	double area;
	static Image tuberiaArriba;
	static Image tuberiaAbajo;
	Color c = new Color (0,0,0,0);

	public Obstaculo(double posicionX, double posicionY) {
		this.x = posicionX;
		this.y = posicionY;
		this.area= this.x*this.y;
		tuberiaArriba = Herramientas.cargarImagen("tuberiaarriba.png");
		tuberiaAbajo = Herramientas.cargarImagen("tuberiaabajo1.png");
	}

	public void dibujarTuberiaArriba(Entorno entorno, double x, double y) {
		//entorno.dibujarRectangulo(x, y, 40, 404, 0, Color.pink);
	//entorno.dibujarRectangulo(x, y, 100, 404, 0, this.c);
		entorno.dibujarImagen(tuberiaArriba, x, y, 0, 0.70);
	}	

	public  void dibujarTuberiaAbajo(Entorno entorno, double x, double y) {
		//entorno.dibujarRectangulo(x, y, 40, 404, 0, Color.pink);
		//entorno.dibujarRectangulo(x, y, 100, 404, 0, this.c);
		entorno.dibujarImagen(tuberiaAbajo, x, y, 0, 0.70);
	}
}