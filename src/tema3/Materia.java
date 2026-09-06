package tema3;

import ed.Datos;
import ed.Formato;
import ed.Menu;

public class Materia
{
	private int clv, cre, plan;
	private String nom;
	Datos obd = new Datos();

	public Materia(int clv)
	{
		this.clv = clv;
		System.out.println("Datos del producto");
		System.out.println("Clave " + this.clv);
		nom = obd.Cadena("Nombre: ").toUpperCase();
		do
			cre = obd.Entero("Creditos: ");
		while (cre < 1 || cre > 5);

		do
			plan = obd.Entero("Plan: ");
		while (plan < 1);

	}

	public void Mostrar()
	{
		Formato obf = new Formato();
		System.out.println(obf.Izquierda(clv + "", 5) + " | " + obf.Izquierda(nom, 25) + " | "
				+ obf.Derecho(cre + "", 12) + " | " + obf.Derecho(plan + "", 12));
	}

	public void Modificar()
	{
		int op;
		Menu obm = new Menu("Modificaciones", new String[] { "Nombre", "creditos", "plan" });
		do
			switch (op = obm.Opcion())
			{
				case 1:
				{
					System.out.println("Nombre actual: " + nom);
					nom = obd.Cadena("Nombre: ").toUpperCase();
					break;
				}
				case 2:
				{
					System.out.println("Creditos actuales: " + cre);
					do
						cre = obd.Entero("Creditos: ");
					while (cre < 1 || cre > 5);
					break;
				}
				case 3:
					System.out.println("Plan actual " + plan);
					do
						plan = obd.Entero("Plan: ");
					while (plan < 1);
			}
		while (op != obm.Salir());
	}

	public int Clave()
	{
		return clv;
	}

	public int Plan()
	{
		return plan;
	}
}
