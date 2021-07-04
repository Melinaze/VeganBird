package juego;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Disparo {

	double x;
	double y;
	double angulo;
	Image disparo1;
	
	


	public Disparo (double x, double y) {
		this.x = x;
		this.y = y;
		disparo1= Herramientas.cargarImagen("bala.png");

	}

	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(disparo1, x, y, this.angulo, 0.3);
		//entorno.dibujarRectangulo(this.x+400, this.y, 30, 5, this.angulo, Color.pink);
	}

	public void girar(double modificador) 
	{
		this.angulo = this.angulo + modificador;
	}

	public void mover() {
		this.y -= 2;
	}

	public void caer() {
		this.y +=2; 
	}
	
	}	





