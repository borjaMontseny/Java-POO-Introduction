
public class Reloj {

	// Propiedades
	private int horas;
	private int minutos;
	private int segundos;

	// Constructores
	public Reloj() { // por defecto
	}

	public Reloj(int horas, int minutos, int segundos) {
		this.horas = ajustarDatos(horas, 24);
		this.minutos = ajustarDatos(minutos, 60);
		this.segundos = ajustarDatos(segundos, 60);
	}

	// Métodos

	// pasamos H || M || S y ajustamos para que entre en el rango deseado
	public int ajustarDatos(int dato, int maximo) {
		if (dato < 0) {
			do {
				dato++;
			} while (dato < 0);
		}

		if (dato >= maximo) {
			do {
				dato--;
			} while (dato >= maximo);
		}

		return dato;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	// toString
	@Override
	public String toString() {
		String horasString = Integer.toString(horas);
		String minutosString = Integer.toString(minutos);
		String segundosString = Integer.toString(segundos);

		if (horas < 10) {
			horasString = "0" + horasString;
		}

		if (minutos < 10) {
			minutosString = "0" + minutosString;
		}

		if (segundos < 10) {
			segundosString = "0" + segundosString;
		}

		return horasString + ":" + minutosString + ":" + segundosString;
	}

	// Funció per a poder modificar l’hora sencera.
	// Ha de retornar true si l’hora és correcta i false si no ho és.
	public boolean modificarHora(int hora, int minutos, int segundos) {

		if (!(hora < 24 && hora >= 0)) {
			return false;
		} else if (!(minutos < 60 && minutos >= 0)) {
			return false;
		} else if (!(segundos < 60 && segundos >= 0)) {
			return false;
		} else {
			this.horas = hora;
			this.minutos = minutos;
			this.segundos = segundos;
			return true;
		}
	}

	// Funció per a poder sumar un segon a l’hora actual
	public void sumarSegon() {
		this.segundos++;
		if (this.segundos > 59) {
			this.minutos++;
			this.segundos = 0;
			if (this.minutos > 59) {
				this.horas++;
				this.minutos = 0;
				if (this.horas > 23) {
					this.horas = 0;
				}
			}
		}

	}

	// Funció per a poder sumar un nombre determinat de segons a l’hora actual.
	public void sumarSegons(int segons) {
		// acumulem els segons
		this.segundos += segons;

		if (this.segundos >= 60) { // si pasen de 60
			// els que es poden dividir els pasem a minuts
			this.minutos += this.segundos / 60;
			// els que no arriben a 60 es queden en segons
			this.segundos %= 60;
		}
		if (this.minutos >= 60) {
			this.horas += this.minutos / 60;
			this.minutos %= 60;
		}
		this.horas %= 24; // si se pasa de 24, es un dia, solo queremos horas
	}
}
