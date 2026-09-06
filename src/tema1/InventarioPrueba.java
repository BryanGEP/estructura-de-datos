package tema1;

public class InventarioPrueba
{
	public static void main(String[] args)
	{
		int ind, op,clv=0;
		String ncn;
		boolean ban;
		ed.Datos obd = new ed.Datos();
		ed.Formato obf = new ed.Formato();
		java.util.Vector<Inventario> inv = new java.util.Vector<Inventario>(10, 3);
		ed.Menu obm = new ed.Menu("Control de inventario",
				new String[] { "Insertar", "consultar", "modificar", "buscar", "eliminar" });

		do
			switch (op = obm.Opcion())
			{
				case 1:
					if (inv.add(new Inventario(++clv)))
						System.out.println("Articulo almacenado con exito\n");
					else
						System.out.println("El articulo no se puede almacenar\n");
					break;
				case 2:
					if (!inv.isEmpty())
					{
						System.out.println("\nLista productos...\n" + obf.Izquierda("CLAVE", 15) + " | "
								+ obf.Izquierda("NOMBRE", 15) + " | " + obf.Izquierda("EXISTENCIA", 15) + " | "
								+ obf.Izquierda("PRECIO", 15));
						for (ind = 0; ind < inv.size(); ind++)
							inv.get(ind).Mostrar();
						System.out.println("Fin de la lista...\n");
					}
					else
						System.out.println("No hay datos en la lista...\n");
					break;
				case 3:
					if (!inv.isEmpty())
					{
						ban = true;
						ncn = obd.Cadena("\nClave del producto a Modificar: ").toUpperCase();
						for (ind = 0; ind < inv.size(); ind++)
							if (inv.get(ind).Clave().equals(ncn))
							{
								inv.get(ind).Modificar();
								System.out.println("Producto MOdificado...\n");
								ban = false;
								break;
							}
						if (ban)
							System.out.println("El producto no existe...\n");
					}
					else
						System.out.println("No hay datos en la lista...\n");
					break;
				case 4:
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
					break;
				case 5:
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
			}
		while (op != obm.Salir());
	}
}
