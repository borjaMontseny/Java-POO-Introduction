
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Reloj reloj1 = new Reloj(50, 15, 59);

		System.out.println("Mètode toString(): " + reloj1.toString());

		System.out.println("\nMètode modificarHora(): " + reloj1.modificarHora(60, 25, 15));
		System.out.println("Si retorna false, no s'haurà cambiat l'hora: " + reloj1.toString());

		reloj1.sumarSegon();

		System.out.println("\ntoString desprès de sumarSegon(): " + reloj1.toString());

		reloj1.modificarHora(00, 00, 00);

		reloj1.sumarSegons(7200);

		System.out.println("\n" + reloj1.toString());

		Reloj reloj2 = new Reloj();
		System.out.println("\nConstructor por defecto: " + reloj2.toString());

	}

}
