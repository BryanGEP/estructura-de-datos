package tema1;

public class Inventario
{
	private int clv, exi, pg;
	private String nom;
	private double pre, pv, pg2;
	private ed.Datos obd = new ed.Datos();

	public Inventario(int clv)
	{
		System.out.println("\nEscribe los sigientes datos...");
		this.clv = clv;
		nom = obd.Cadena("Nombre del producto: ").toUpperCase();
		do
			exi = obd.Entero("Existencia: ");
		while (exi < 0);
		do
			pre = obd.Doble("Precio de compra: ");
		while (pre < 1);
		do
			pg = obd.Entero("Porcentaje de ganacia (20 a 50%): ");
		while (pg < 20 || pg > 50);

	}

	public void Mostrar()
	{
		this.Calcular();
		ed.Formato obf = new ed.Formato();
		System.out.println(obf.Izquierda(clv + "", 15) + " | " + obf.Izquierda(nom, 15) + " | "
				+ obf.Izquierda(exi + "", 15) + " | " + obf.Izquierda(pv + "", 15));
	}

	private void Calcular()
	{
		pg2 = pg / 10;
		pv = pre * ((pg2 / 10) + 1);
	}

	public void Modificar()
	{
		int op;
		ed.Menu obm = new ed.Menu("Modificaciones",
				new String[] { "Nombre", "Existencia", "Precio", "Porcentaje de ganacia" });
		do
			switch (op = obm.Opcion())
			{
				case 1:
					System.out.println("\nNombre Actual " + nom);
					nom = obd.Cadena("Nuevo:").toUpperCase();
					break;
				case 2:
					System.out.println("\nExistencia Actual " + exi);
					do
						exi = obd.Entero("Nuevo:");
					while (exi < 0);
					break;
				case 3:
					System.out.println("\nPrecio Actual " + pre);
					do
						pre = obd.Entero("Nuevo: ");
					while (pre < 1);
					this.Calcular();
					break;
				case 4:
					System.out.println("\nPorcentaje de ganacia actual: " + pg);
					do
						pg = obd.Entero("Nuevo: ");
					while (pg < 20 || pg > 50);
					this.Calcular();
					break;
			}
		while (op != obm.Salir());
	}

	public String Clave()
	{

		return clv + "";
	}

	public int Existencia()
	{
		return exi;
	}
}
