package tema1;

public class AlumnoDP
{
	private int pos;
	private String ncn;
	private boolean ban;
	private ed.Datos obd = new ed.Datos();
	private ed.Formato obf = new ed.Formato();
	private java.util.Vector<AlumnoD> alu = new java.util.Vector<AlumnoD>(5, 3);

	public void Insetar()
	{
		if (alu.add(new AlumnoD()))
			System.out.println("Alumno almacenado con exito\n");
		else
			System.out.println("El alumno no se puede almacenar\n");
	}

	public void Consultar()
	{

		if (!alu.isEmpty())
		{
			System.out.println("Lista alumnos...\n" + obf.Derecho("NO CTRL", 10) + " | " + obf.Izquierda("NOMBRE", 25)
					+ " | " + obf.Derecho("PROMEDIO", 5));
			for (AlumnoD a : alu)
				a.Mostrar();
			System.out.println("Fin de la lista...\n");
		}
		else
			System.out.println("No hay datos en la lista...\n");
	}

	public void Modificar()
	{
		if (!alu.isEmpty())
		{
			ban = true;
			ncn = obd.Cadena("No de Control del alumno a Modificar: ").toUpperCase();
			for (AlumnoD a : alu)
				if (a.NoControl().equals(ncn))
				{
					a.Modificar();
					System.out.println("Alumno MOdificado...\n");
					ban = false;
					break;
				}
			if (ban)
				System.out.println("El alumno no existe...\n");
		}
		else
			System.out.println("No hay datos en la lista...\n");
	}

	public void Buscar()
	{
		if (!alu.isEmpty())
		{
			ban = true;
			ncn = obd.Cadena("No de Control del alumno a Buscar: ").toUpperCase();
			for (AlumnoD a : alu)
				if (a.NoControl().equals(ncn))
				{
					System.out.println("Alumno encontrado...");
					a.Mostrar();
					ban = false;
					break;
				}
			if (ban)
				System.out.println("El alumno no existe...\n");
		}
		else
			System.out.println("No hay datos en la lista...\n");
	}

	public void Eliminar()
	{
		if (!alu.isEmpty())
		{
			ban = true;
			ncn = obd.Cadena("No de Control del alumno a Eliminar: ").toUpperCase();
			pos = 0;
			for (AlumnoD a : alu)
			{
				if (a.NoControl().equals(ncn))
				{
					System.out.println("Alumno encontrado...\n");
					a.Mostrar();
					System.out.println("Alumno eliminado..\n");
					alu.remove(pos);
					ban = false;
					break;
				}
				pos++;
			}
			if (ban)
				System.out.println("El alumno no existe...\n");
		}
		else
			System.out.println("No hay datos en la lista...\n");
	}

}
