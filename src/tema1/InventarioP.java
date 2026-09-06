package tema1;

public class InventarioP
{
	/*private int ind;
	private String ncn;
	private boolean ban;
	private ed.Datos obd = new ed.Datos();
	private ed.Formato obf = new ed.Formato();
	private java.util.Vector<Inventario> inv = new java.util.Vector<Inventario>(10, 3);

	public void Insertar()
	{
		if (inv.add(new Inventario()))
			System.out.println("Articulo almacenado con exito\n");
		else
			System.out.println("El articulo no se puede almacenar\n");
	}

	public void Consultar()
	{

		if (!inv.isEmpty())
		{
			System.out.println("\nLista alumnos...\n" + obf.Izquierda("CLAVE", 15) + " | " + obf.Izquierda("NOMBRE", 15)
					+ " | " + obf.Izquierda("EXISTENCIA", 15) + " | " + obf.Izquierda("PRECIO", 15));
			for (ind = 0; ind < inv.size(); ind++)
				inv.get(ind).Mostrar();
			System.out.println("Fin de la lista...\n");
		}
		else
			System.out.println("No hay datos en la lista...\n");
	}

	public void Modificar()
	{
		if (!inv.isEmpty())
		{
			ban = true;
			ncn = obd.Cadena("Clave del producto a Modificar: ").toUpperCase();
			for (ind = 0; ind < inv.size(); ind++)
				if (inv.get(ind).Clave().equals(ncn))
				{
					inv.get(ind).Modificar();
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
		if (!inv.isEmpty())
		{
			ban = true;
			ncn = obd.Cadena("Clave del producto a Buscar: ").toUpperCase();
			for (ind = 0; ind < inv.size(); ind++)
				if (inv.get(ind).Clave().equals(ncn))
				{
					System.out.println("Producto encontrado...");
					inv.get(ind).Mostrar();
					ban = false;
					break;
				}
			if (ban)
				System.out.println("El producto no existe...\n");
		}
		else
			System.out.println("No hay datos en la lista...\n");
	}

	public void Eliminar()
	{
		if (!inv.isEmpty())
		{
			ban = true;
			ncn = obd.Cadena("Clave del producto a Eliminar: ").toUpperCase();
			for (ind = 0; ind < inv.size(); ind++)
			{
				if (inv.get(ind).Clave().equals(ncn))
				{
					if (inv.get(ind).Existencia() == 0)
					{
						System.out.println("\nProducto encontrado...");
						inv.get(ind).Mostrar();
						System.out.println("Producto eliminado..\n");
						inv.remove(ind);
						ban = false;
						break;
					}
					else
					{
						System.out.println("\nAun hay existencia del producto...");
						ban = false;
					}
				}
			}
			if (ban)
				System.out.println("\nEl producto no existe...\n");
		}
		else
			System.out.println("\nNo hay datos en la lista...\n");
	}*/
}
