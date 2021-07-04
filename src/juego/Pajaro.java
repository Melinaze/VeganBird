package juego;
import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Pajaro {
	double x;
	double y;
	double angulo;
	Image pajaro;
	boolean estaMuerto;
	Color c = new Color (0,0,0,0);

	public boolean estaMuerto() {
		return this.estaMuerto;
	}

	public void setEstaMuerto(boolean estaMuerto) {
		this.estaMuerto = estaMuerto;
	}


	public Pajaro(int x, int y) {
		this.x = x;
		this.y = y;
		this.estaMuerto = false;
		pajaro= Herramientas.cargarImagen("pajaro.png");
		Rectangle pajaro = new Rectangle(x, y, 100, 100);
	}

	public void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, 135, 100, this.angulo, this.c);
		entorno.dibujarImagen(pajaro, this.x, this.y, this.angulo, 0.3);

	}

	public void mover() {
		if (this.y -30 == 0) {
			this.y += 10;
		}else {
			this.y -= 5;
		}
	}

	public void caer() {
		this.y += 3;
	}
}
