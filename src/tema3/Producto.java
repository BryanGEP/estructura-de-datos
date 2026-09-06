package tema3;

import ed.*;

public class Producto
{
	private int clv;
	private String nom;
	private double pre;
	Datos obd = new Datos();

	public Producto(int clv)
	{
		this.clv = clv;
		System.out.println("Datos del producto");
		System.out.println("Clave " + this.clv);
		nom = obd.Cadena("Nombre: ").toUpperCase();
		do
			pre = obd.Doble("Precio: ");
		while (pre < 1);

	}

	public void Mostrar()
	{
		Formato obf = new Formato();
		System.out.println(
				obf.Izquierda(clv + "", 5) + " | " + obf.Izquierda(nom, 25) + " | " + obf.Derecho(obf.Pesos(pre), 12));
	}

	public void Modificar()
	{
		int op;
		Menu obm = new Menu("Modificaciones", new String[] { "Nombre", "Precio" });
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
					System.out.println("Precio actual: " + new Formato().Pesos(pre));
					do
						pre = obd.Doble("Precio: ");
					while (pre < 1);
				}

			}
		while (op != obm.Salir());
	}

	public int Clave()
	{
		return clv;
	}
}
