package juego;
import java.util.*;
import entorno.Entorno;


public class Vegetales{
	ChocloBrocoli [] vegetales;
	double x;
	double y;

	public Vegetales(int n) {
		vegetales = new ChocloBrocoli[n];
	}

	public ChocloBrocoli[] getVegetales() {
		return vegetales;
	}

	public void cargarVegetales() { //carga los vegetales en arreglo 
		Random random = new Random ();
		this.x=215;
		for (int i=0 ; i<vegetales.length; i++) {
			this.y= Math.random() * 103+ 274;
			if (this.y==300) {
				this.y= random.nextInt(250);
			}//le doy Y aca para que esten en distinta posicion
			vegetales[i] = new ChocloBrocoli (this.x, this.y);
			this.x += 200;			
		}		
	}

	public void dibujarVegetales(Entorno entorno) {
		for (int i=0; i < vegetales.length; i++) {
			vegetales[i].dibujarse(entorno, vegetales[i].x, vegetales[i].y);

		}
	}

	public void moverVegetales() {
		for (int i=0; i<vegetales.length; i++) {
			vegetales[i].x-=2;
			if (vegetales[i].x == 0 ) {
				vegetales[i].x=800;
			}
		}
	}

	public boolean colisionesVegetales( double pajarox, double pajaroy) {
		boolean colision=false;
		for (int i=0; i< vegetales.length; i++) {
			if (vegetales[i].x-15> pajarox+25 || vegetales[i].x+15< pajarox-25) {
				colision= false;
			}
			else {	
				if (pajaroy+25 >= vegetales[i].y-15 & pajaroy-25 <= vegetales[i].y-15) {
					colision = true;
					vegetales[i].x=875;
					return colision;
				}
				if (pajaroy-25 <= vegetales[i].y+15 & pajaroy+25 >= vegetales[i].y+15) {
					colision = true;
					vegetales[i].x=875;
					return colision;
				}
				else {
					colision=false;
				}
			}
		}
		return colision;
	}
}
	
	
	

	
		
	


	
		
	


	
	

	
		
	

