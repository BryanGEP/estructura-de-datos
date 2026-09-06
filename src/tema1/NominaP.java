package tema1;

public class NominaP
{
	public static void main(String[] args)
	{
		int can, op, pos;
		String db;
		boolean ban;
		Nomina lista[];
		ed.Datos obd = new ed.Datos();
		ed.Menu obm = new ed.Menu("Control de empleados", new String[] { "Nuevo", "Consulta", "Buscar" });

		do
			can = obd.Entero("Cantidad de Empleados: ");
		while (can < 1);
		lista = new Nomina[can];
		can = -1;
		do
			switch (op = obm.Opcion())
			{
				case 1:
					if (can + 1 < lista.length)
						lista[++can] = new Nomina();
					else
						System.out.println("No hay espacio para otro empleado...");
					break;
				case 2:
					if (can != -1)
					{
						System.out.println("\nLista de empleados...");
						for (pos = 0; pos <= can; pos++)
							lista[pos].Mostrar();
					}
					else
						System.out.println("No hay datos en la lista...");
					break;
				case 3:
					ban = true;
					if (can != -1)
					{
						db = obd.Cadena("Nombre o Apellido a buscar: ").toUpperCase();
						for (pos = 0; pos <= can; pos++)
							if (lista[pos].Nombre().contains(db))
							{
								if (ban)
									System.out.println("Empleado encontrado...");
								lista[pos].Mostrar();
								ban = false;
							}
						if (ban)
							System.out.println("El empleado no esta en la lista...");
					}
					else
						System.out.println("No hay datos en la lista...");

			}
		while (op != obm.Salir());
	}
}
