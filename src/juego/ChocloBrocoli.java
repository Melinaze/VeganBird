package juego;



import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class ChocloBrocoli {
	double x;
	double y;
	double angulo;
	static Image choclo;
	static Image brocoli;
	Color c= new Color(0,0,0,0);


	public ChocloBrocoli (double x, double y) {
		this.x = x;
		this.y = y;
		choclo = Herramientas.cargarImagen("choclo.png");
		brocoli = Herramientas.cargarImagen("brocoli1.png");
	}

	public  void dibujarse(Entorno entorno, double x2, double y2) {
		if (y2%2==0 ) { //Para intercambiar los vegetales, cuando y2 es par dibuja brocolis y cuando es impar choclos. 
			entorno.dibujarImagen(brocoli, x2, y2, y2);
			entorno.dibujarRectangulo(x2, y2, 30, 30, 0, this.c);
			//Cuando brocoli pasa  pajaro se incrementa  Y, entonces,  brocoli desaparece. 
		}
		else {
			if (y2> 250 ){
				entorno.dibujarRectangulo(x2+1, y2+0.5, 30, 30, 0,this.c);
				entorno.dibujarImagen(choclo, x2, y2+0.5, y2+0.5);
				//Cuando  choclo pasa  pajaro se incrementa  Y, entonces, choclo desaparece. 
			}
		}
	}
}
