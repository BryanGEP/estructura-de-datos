package tema1;

public class AlumnoPX
{

	public static void main(String[] args)
	{
		int can, op, pos, op1;
		boolean ban;
		String db;
		Alumno lista[];
		ed.Datos obd = new ed.Datos();
		ed.Menu obm = new ed.Menu("Control de alumnos", new String[] { "Nuevo", "Lista", "Buscar" });
		ed.Menu obm1 = new ed.Menu("Busquedas", new String[] { "No. Control", "Nombre o apellido" });
		do
			can = obd.Entero("Cantidad de alumnos");
		while (can < 1);
		lista = new Alumno[can];
		can = -1;
		do
			switch (op = obm.Opcion())
			{
				case 1:
					if (can + 1 < lista.length)
						lista[++can] = new Alumno();
					else
						System.out.println("No hay espacio para otro alumno...");
					break;
				case 2:
					if (can != -1)
					{
						System.out.println("Lista de alumnos...");
						for (pos = 0; pos <= can; pos++)
							lista[pos].Mostrar();
					}
					else
						System.out.println("No hay datos en la lista...");
					break;
				case 3:
					do
						switch (op1 = obm1.Opcion())
						{
							case 1:
								if (can != -1)
								{
									db = obd.Cadena("No. de control a Buscar");
									for (pos = 0; pos <= can; pos++)
										if (lista[pos].NoControl().equals(db))
										{
											System.out.println("Alumno encontrado...");
											lista[pos].Mostrar();
											break;
										}
									if (pos > can)
										System.out.println("El alumno no esta en la lista...");
								}
								else
									System.out.println("No hay datos en la lista...");
								break;
							case 2:
								ban = true;
								if (can != -1)
								{
									db = obd.Cadena("Nombre o Apellido a Buscar").toUpperCase();
									for (pos = 0; pos <= can; pos++)
										if (lista[pos].Nombre().contains(db))
										{
											if (ban)
												System.out.println("Alumno encontrado...");
											lista[pos].Mostrar();
											ban = false;
										}
									if (ban)
										System.out.println("El alumno no esta en la lista...");
								}
								else
									System.out.println("No hay datos en la lista...");
						}
					while (op1 != obm1.Salir());
			}
		while (op != obm.Salir());
	}
}
