package juego;
import entorno.Entorno;


public class Hamburguesas {
	Hamburguesa [] hamburguesas;
	double x;
	double y;

	public Hamburguesas(int n) {
		hamburguesas = new Hamburguesa[n];
	}

	public Hamburguesa[] getHamburguesas() {
		return hamburguesas;
	}

	public void cargarHamburguesas() { //carga los vegetales en arreglo
		double posicionX = 250;
		double posicionY = 300;
		for (int i=0 ; i < hamburguesas.length; i++) {
			hamburguesas[i] = new Hamburguesa(posicionX, posicionY);
			posicionX +=350;			
		}	
	}

	public void dibujarHamburguesas(Entorno entorno) {
		for (int i=0; i < hamburguesas.length; i++) {
			hamburguesas[i].dibujarse(entorno, hamburguesas[i].x, hamburguesas[i].y);
		}
	}

	public void moverHamburguesas (){
		for (int i = 0; i < hamburguesas.length; i++) {
			hamburguesas[i].x -= 2;
			if (hamburguesas[i].x == 0 ) {
				hamburguesas[i].x=800;
			}
		}		
	}

	public boolean colisionesHamburguesas(Entorno entorno, double pajarox, double pajaroy) {
		boolean colision=false;
		for (int i=0; i < hamburguesas.length; i++) {
			if (hamburguesas[i].x-20> pajarox+25 || hamburguesas[i].x+20< pajarox-25) {
				colision= false;
			}
			else {	
				if (pajaroy+25 >= hamburguesas[i].y-15.5 && pajaroy-25 <= hamburguesas[i].y-15.5) {
					colision= true;
					hamburguesas[i].x=800 + pajarox;
					hamburguesas[i].transformarseAHamburguesa();
					return colision;
				}
				if (pajaroy-25 <= hamburguesas[i].y+15.5 && pajaroy+25 >= hamburguesas[i].y+15.5) {
					colision = true;
					hamburguesas[i].x=800 + pajarox;
					hamburguesas[i].transformarseAHamburguesa();
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







		

			
		
			



		
