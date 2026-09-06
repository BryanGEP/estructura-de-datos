package tema1;

import ed.*;

public class Prueba
{
	public static void main(String[] args)
	{
		int clv;
		String nom;
		double pre;
		Datos obd = new Datos();
		Formato obf = new Formato();

		clv = obd.Entero("Clave");
		nom = obd.Cadena("Nombre");
		pre = obd.Doble("Precio");

		System.out.println(
				obf.Derecho(clv + "", 10) + "\t" + obf.Izquierda(nom, 25) + "\t" + obf.Derecho(obf.Pesos(pre), 15));

	}
}
