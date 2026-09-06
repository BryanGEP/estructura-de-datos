package tema3;

import ed.Menu;

public class PilaProductoP
{
	public static void main(String[] args)
	{
		int op;
		Menu obm = new Menu("Pila de productos",
				new String[] { "Insertar", "Extraer", "Recorrido", "Buscar", "Modificar", "Eliminar" });
		PilaProducto obp = new PilaProducto();

		do
			switch (op = obm.Opcion())
			{
				case 1:
					obp.Insertar();
					break;

				case 2:
					obp.Extraer();
					break;
				case 3:
				case 4:
				case 5:
				case 6:
					obp.Operaciones(op);

			}
		while (op != obm.Salir());
	}
}
