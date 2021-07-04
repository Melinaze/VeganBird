package juego;



import entorno.Entorno;


public class Arraytuberias {	
	Obstaculo [] tuberiasArriba;
	Obstaculo [] tuberiasAbajo;



	public Arraytuberias (int n) {
		tuberiasArriba = new Obstaculo [n];
		tuberiasAbajo = new Obstaculo [n];
	}

	public void llenarTuberiasArriba() {
		double posicionX = 100;
		double posicionY = -50;
		for (int i=0 ; i<tuberiasArriba.length; i++) {
			posicionY = posicionY*(-1);
			tuberiasArriba[i] = new Obstaculo (posicionX, posicionY);
			posicionX +=200;	
		}

		double posicionX2 = 100;
		double posicionY2 = 600;
		double signo = -100;
		for (int j=0 ; j<tuberiasAbajo.length; j++) {
			signo = signo*(-1);
			posicionY2 = posicionY2 + signo;    //le doy Y aca para que esten las 4 en distinta posicion
			tuberiasAbajo[j] = new Obstaculo (posicionX2, posicionY2);
			posicionX2 +=200;
		}
		}

	public void dibujarTuberiasArriba(Entorno entorno ) {
		for (int i=0 ; i<tuberiasArriba.length; i++) {
			tuberiasArriba[i].dibujarTuberiaArriba(entorno, tuberiasArriba[i].x, tuberiasArriba[i].y);	
		}
	}

	public void dibujarTuberiasAbajo (Entorno entorno) {
		for (int i=0 ; i<tuberiasAbajo.length; i++) {
			tuberiasAbajo[i].dibujarTuberiaAbajo(entorno, tuberiasAbajo[i].x, tuberiasAbajo[i].y); 
		}
	}

	public void moverTuberiasArriba () {
		for (int i = 0; i< tuberiasArriba.length; i++) { //recorre el arreglo y le resta a cada x 1
			tuberiasArriba[i].x -= 2;
			if (tuberiasArriba[i].x == 0) {    //pregunta si esa x es igual a 0 , en tal caso la ubica en x=800(fondo de la pantalla)
				tuberiasArriba[i].x=800;
			}
		}
	}
	public void moverTuberiasAbajo (){
		for (int i = 0; i< tuberiasAbajo.length; i++) {
			tuberiasAbajo[i].x -= 2;
			if (tuberiasAbajo[i].x == 0 ) {
				tuberiasAbajo[i].x=800;
			}
		}		
	}

	public boolean colisionArriba(double pajarox , double pajaroy){
		boolean colision = false;
		for (int i =0; i<tuberiasArriba.length; i++) {
			if (tuberiasArriba[i].x-20 > pajarox + 25 || tuberiasArriba[i].x +20 < pajarox - 25) {
				colision = false;
			}
			else {
				if (pajaroy - 25 <= tuberiasArriba[i].y + 202) {
					colision = true;
					return colision;
				}
				else colision = false;
			}
		}
		return colision;
	}

	public boolean colisionAbajo(double pajarox , double pajaroy){
		boolean colision = false;
		for (int i =0; i<tuberiasAbajo.length; i++) {
			if (tuberiasAbajo[i].x-20 > pajarox + 25 || tuberiasAbajo[i].x +20 < pajarox - 25) {
				colision = false;
			}
			else {
				if (pajaroy + 25 >= tuberiasAbajo[i].y -202) {
					colision = true;
					return colision;
				}
				else{
					colision = false;
				}
			}
		}
		return colision;
	}
}


