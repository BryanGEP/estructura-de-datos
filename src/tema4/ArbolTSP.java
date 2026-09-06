package tema4;

import ed.Menu;

public class ArbolTSP
{
	public static void main(String[] args)
	{
		int op;
		Menu obm = new Menu("Arbol Articulos",
				new String[] { "insertar", "eliminar", "recorrido", "busqueda", "borrar" });
		ArbolTS obc = new ArbolTS();
		do
			switch (op = obm.Opcion())
			{
				case 1:
					obc.Insertar();
					break;
				case 2:
					obc.Eliminar();
					break;
				case 3:
					obc.Recorrido();
					break;
				case 4:
					obc.Buscar();
					break;
				case 5:
					obc.Borrar();
					break;

			}
		while (op != obm.Salir());

	}
}
