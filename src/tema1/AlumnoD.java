package tema1;

public class AlumnoD
{
	private String nc, nom;
	private int pro;
	private ed.Datos obd = new ed.Datos();
	private ed.Formato obf = new ed.Formato();

	public AlumnoD()
	{
		System.out.println("Escribe los datos del alumno...");
		nc = obd.Cadena("NO.Control: ").toUpperCase();
		nom = obd.Cadena("Nombre: ").toUpperCase();
		do
			pro = obd.Entero("Promedio: ");
		while (pro < 0 || pro > 100);
	}

	public void Mostrar()
	{
		System.out.println(obf.Derecho(nc, 10) + " | " + obf.Izquierda(nom, 25) + " | " + obf.Derecho(pro + "", 5));
	}

	public void Modificar()
	{
		int op;
		ed.Menu obm = new ed.Menu("Modificaciones", new String[] { "No Control", "NOmbre", "Promedio" });
		do
			switch (op = obm.Opcion())
			{
				case 1:
					System.out.println("No control Actual " + nc);
					nc = obd.Cadena("Nuevo:").toUpperCase();
					break;
				case 2:
					System.out.println("Nombre Actual " + nom);
					nom = obd.Cadena("Nuevo:").toUpperCase();
					break;
				case 3:
					System.out.println("Promedio Actual " + pro);
					do
						pro = obd.Entero("Nuevo: ");
					while (pro < 0 || pro > 100);
			}
		while (op != obm.Salir());
	}

	public String NoControl()
	{
		return nc;
	}

	public String NOmbre()
	{
		return nom;
	}

	public int Promedio()
	{
		return pro;
	}
}
