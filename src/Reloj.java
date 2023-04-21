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
		return String.format("%02d:%02d:%02d", this.horas, this.minutos, this.segundos);
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

		for (int i = 0; i < segons; i++) {
			sumarSegon();
		}

	}
}
