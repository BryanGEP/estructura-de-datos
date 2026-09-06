package tema1;

public class Nomina
{
	private int ht, clv;
	private String nom;
	private double ph, sue, ret, suet;

	public Nomina()
	{
		ed.Datos obd = new ed.Datos();
		System.out.println("\nEscribe los sigientes datos...");
		do
			clv = obd.Entero("Clave: ");
		while (clv < 1);
		nom = obd.Cadena("Nombre: ").toUpperCase();
		do
			ht = obd.Entero("Horas trabajadas: ");
		while (ht < 8 || ht > 45);
		ph = obd.Doble("Precio por hora: ");
	}

	public void Mostrar()
	{
		this.Calcular();
		ed.Formato obf = new ed.Formato();
		System.out.println(obf.Izquierda(clv + "", 15) + obf.Izquierda(nom, 15) + obf.Izquierda(sue + "", 15)
				+ obf.Izquierda(ret + "", 15) + obf.Izquierda(suet + "", 15));
	}

	private void Calcular()
	{
		sue = ht * ph;
		ret = sue * .17;
		suet = sue - ret;
	}

	public String Nombre()
	{
		return nom;
	}
}
