package tema1;

public class Trabajadores
{
	private Trabajador lista[];
	private int can, pos, nt;
	private boolean ban = true;

	private ed.Datos obd = new ed.Datos();
	private ed.Formato obf = new ed.Formato();

	public Trabajadores()
	{
		do
			can = obd.Entero("Cantidad de trabajadores: ");
		while (can < 1);
		lista = new Trabajador[can];
		can = -1;
	}

	private void NoTarjeta()
	{
		if (can != -1)
			nt = lista[can].getNoTarjeta() + 1;
		else
			nt = 1;
	}

	private void Mostrar()
	{
		System.out.println(obf.Izquierda(lista[pos].getNoTarjeta() + "", 4) + obf.Izquierda(lista[pos].getNombre(), 25)
				+ " " + obf.Izquierda(lista[pos].getPuesto(), 15) + obf.Derecho(obf.Pesos(lista[pos].getSueldo()), 15));
	}

	public void Nuevo()
	{
		if (can + 1 < lista.length)
		{
			this.NoTarjeta();
			lista[++can] = new Trabajador();
			System.out.println("Escribe los datos del trabajador..");
			lista[can].setNoTarjeta(nt);
			System.out.println("No. e Tarjeta " + lista[can].getNoTarjeta());
			lista[can].setNombre(obd.Cadena("Nombre: ").toUpperCase());
			lista[can].setPuesto(obd.Cadena("Puesto: ").toUpperCase());
			do
				lista[can].setSueldo(obd.Doble("Sueldo: "));
			while (lista[can].getSueldo() < 1);

		}
		else
			System.out.println("No hay espacio para otro trabajador..");
	}

	public void Lista()
	{
		if (can != -1)
		{
			System.out.println("Lista de trabajadores");
			for (pos = 0; pos <= can; pos++)
				this.Mostrar();
			System.out.println("Fin de la lisra...\n");

		}
		else
			System.out.println("No hat trabajadores registrados");
	}

	public void Buscar()
	{
		String bus;
		ban = true;
		if (can != -1)
		{
			bus = obd.Cadena("Nombre o Apellido a buscar: ").toUpperCase();
			for (pos = 0; pos <= can; pos++)
				if (lista[pos].getNombre().indexOf(bus) != -1)
				{
					if (ban)
						System.out.println("Lista de trabajadores encontrados...");
					this.Mostrar();
					ban = false;
				}
			if (ban)
				System.out.println("No hay trabajadorescon ese dato");
		}
		else
			System.out.println("No hay trabajadores registrados");
	}

	public void Modificar()
	{
		int op;
		ed.Menu obm = new ed.Menu("Modificiaciones", new String[] { "Nombre", "Puesto", "Sueldo" });
		if (can != -1)
		{
			do
				nt = obd.Entero("Escribe el número de tarjeta a modificar: ");
			while (nt < 1);
			for (pos = 0; pos <= can; pos++)
				if (lista[pos].getNoTarjeta() == nt)
				{
					System.out.println("Datos actuales");
					this.Mostrar();
					do
						switch (op = obm.Opcion())
						{
							case 1:
								lista[pos].setNombre(obd.Cadena("Nuevo Nombre: ").toUpperCase());
								break;
							case 2:
								lista[pos].setPuesto(obd.Cadena("Nuevo Puesto: ").toUpperCase());
								break;
							case 3:
								do
									lista[pos].setSueldo(obd.Doble("Nuevo sueldo: "));
								while (lista[pos].getSueldo() < 1);
						}
					while (op != obm.Salir());
					break;
				}
			if (pos < can)
				System.out.println("ElNo. de Tarjeta no existe....");
		}
		else
			System.out.println("No hay trabajadores registrados");
	}

	public void ELiminar()
	{
		ban = true;
		if (can != -1)
		{
			do
				nt = obd.Entero("Numero de tajeta deltabajadora aeliminar: ");
			while (nt < 1);
			for (pos = 0; pos <= can; pos++)
				if (lista[pos].getNoTarjeta() == nt)
				{
					System.out.println("Trabajador eliminado...");
					this.Mostrar();
					for (; pos < can; pos++)
					{
						/*
						 * lista[pos].setNoTarjeta(lista[pos + 1].getNoTarjeta());
						 * lista[pos].setNombre(lista[pos + 1].getNombre());
						 * lista[pos].setPuesto(lista[pos + 1].getPuesto());
						 * lista[pos].setSueldo(lista[pos + 1].getSueldo());
						 */
						lista[pos] = lista[pos + 1];
					}
					can--;
					ban = false;
					break;
				}
			if (ban)
				System.out.println("Elnúmero de tajerta no existe...");
		}
		else
			System.out.println("No hay trabajadores registrados");
	}
}
