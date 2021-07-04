
package juego;
import java.awt.Color;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;


public class Hamburguesa {
	double x;
	double y;
	private Image hamburguesa;
	Color c= new Color(0,0,0,0);

	public Hamburguesa (double x, double y) {
		this.x= x;
		this.y=y;
		hamburguesa = Herramientas.cargarImagen("hamburguesa.png");
	}

	public void setHamburguesa(Image hamburguesa) {
		this.hamburguesa = hamburguesa;
	}

	public void transformarseAVegetal() {
		this.setHamburguesa(Herramientas.cargarImagen("brocoli1.png"));
	}

	public void transformarseAHamburguesa() {
		this.setHamburguesa(Herramientas.cargarImagen("hamburguesa.png"));
	}

	public void dibujarse(Entorno entorno, double x2, double y2) {
		if (y2> 160 && y2< 330) {
			entorno.dibujarImagen(hamburguesa, x2, y2, 0);
		}
	}
}		

			
			
			




		

		
		
		






