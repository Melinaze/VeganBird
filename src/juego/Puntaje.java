package juego;

import java.awt.Color;

import entorno.Entorno;

public class Puntaje {
	private double x;
	private double y;
	private int puntaje;

	public Puntaje (double x, double y) {
		this.x = x;
		this.y = y;
		this.setPuntaje(0);
	}

	public void sumarPuntosVegetalComido (){
		this.setPuntaje(this.getPuntaje() + 5);
	}

	public void sumarPuntosHamburguesaTransformada(){
		this.setPuntaje(this.getPuntaje() + 3);
	}

	public void restarPuntosHamburguesaComida(){
		this.setPuntaje(this.getPuntaje() - 5);
		System.out.println(puntaje);
	}

	public void puntajeVolverAcero() {
		this.setPuntaje(0);
	}

	public void dibujarPuntaje (Entorno entorno , String string, int puntaje) {
		string = "Puntaje :  " + Integer.toString(puntaje);
		entorno.cambiarFont("Bernard MT Condensed", 40, Color.white);
		entorno.escribirTexto( string, x, y );
	}


	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

}
