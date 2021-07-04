package juego;

import java.awt.Color;
import java.awt.Image;


import entorno.Entorno;
import entorno.Herramientas;
import java.util.ArrayList;

public class Disparador {
	// Variables de instancia
	double x;
	double y;
	double angulo;
	Disparo disparo [];
	Image disparador;
	Image disparo1;
	ArrayList<Disparo> disparos = new ArrayList<>();
	Color c = new Color (0,0,0,0);
	

	public Disparador(int x, int y) {
		 this.x = x;
		this.y = y; 
		disparador= Herramientas.cargarImagen("pistola.png"); 
		disparo1= Herramientas.cargarImagen("bala.png");
		disparo = new Disparo [1];
	}

	public void dibujarse(Entorno entorno){
		entorno.dibujarTriangulo(this.x, this.y, 25, 32, this.angulo, this.c);
		entorno.dibujarImagen(disparador, x, y, this.angulo);

	}

	public void girar(double modificador) 
	{
		this.angulo = this.angulo + modificador;
	}

	public void mover() {
		if (this.y -15 == -15) {
			this.y += 0;
		}else {
			this.y -= 5;
		}
	}

	public void caer() {
		this.y += 3;
	}

	public void llenarDisparo () {
		Disparo disparo = new Disparo(this.x, this.y);
		disparos.add(disparo);
	}

	public void sacarDisparo(int index) {
		disparos.remove(index);
	}

	public void dibujarDisparos(Entorno entorno) {
		for (int i=0; i < disparos.size(); i++){
			Disparo disparo = disparos.get(i);
			entorno.dibujarImagen(disparo1, disparo.x, disparo.y, this.angulo, 0.3);
			//entorno.dibujarRectangulo(disparo.x, disparo.y, 30, 10,0, Color.pink);
		}
	}

	public void moverDisparos() {
		for (int i=0; i < disparos.size(); i++){
			disparos.get(i).x +=Math.cos(this.angulo)*2;
			disparos.get(i).y +=Math.sin(this.angulo)*2;
			//this.x += Math.cos(this.angulo)*2;
			//this.y += Math.sin(this.angulo)*2;
		}
	}

	public boolean colisionConHamburguesas(Hamburguesa[] hamburguesas) {
		boolean colision = false;
		
		for (int i=0; i< hamburguesas.length; i++) {
			for (int j=0; j< disparos.size(); j++) {
				Disparo disparo = disparos.get(j);

				if (hamburguesas[i].x-20> disparo.x +15 || hamburguesas[i].x+20 < disparo.x -15) {
					colision = false;
				}
				else {
					if (disparo.y+2.5 >= hamburguesas[i].y-15.5 && disparo.y-2.5 <= hamburguesas[i].y+15.5) {
						hamburguesas[i].transformarseAVegetal();
						colision = true;
						 
						return colision;
					}
					if (disparo.y-2.5 <= hamburguesas[i].y+15.5 && disparo.y+2.5 >= hamburguesas[i].y+15.5) {
						hamburguesas[i].transformarseAVegetal();
						colision = true;
						return colision;
					}
					else {
						colision=false;
					}
				}
			}
		}
		return colision;
	}



}



			
			
			
	
		
	
			
			
			

