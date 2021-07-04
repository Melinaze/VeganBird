package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Pantalla {
	double x;
	double y;
	double angulo;
	Image gameOver;
	Image fondo;
	Image principal;
	Image boton;
	Image boton2;
	public Pantalla(int x, int y) {
		this.x = x;
		this.y = y;

		gameOver= Herramientas.cargarImagen("gameOver.png"); //Cuando toca una tuberia se imprimira esta img.
		fondo= Herramientas.cargarImagen("fondo.png");
		principal= Herramientas.cargarImagen("pantalla.png");
		boton= Herramientas.cargarImagen("boton1.png");
		boton2= Herramientas.cargarImagen("boton2.png");
	}



	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(gameOver, x, y, angulo);
	}

	public void dibujarFondo(Entorno entorno) {
		entorno.dibujarImagen(fondo, x, y, angulo);
	}
	public void inicio(Entorno entorno) {
		entorno.dibujarImagen(principal, x, y, angulo);
}
	public void boton(Entorno entorno) {
		entorno.dibujarImagen(boton, x, y, angulo);
}
	public void boton2(Entorno entorno) {
		entorno.dibujarImagen(boton2, x, y, angulo);
}
}

