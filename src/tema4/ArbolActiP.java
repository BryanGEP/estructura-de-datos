package tema4;

import ed.Menu;

public class ArbolActiP
{
	public static void main(String[] args)
	{
		int op;
		Menu obm = new Menu("Arbol Articulos",
				new String[] { "insertar", "eliminar fusion", "recorrido amplitud", "busqueda", "borrar" });
		ArbolActi obc = new ArbolActi();
		do
			switch (op = obm.Opcion())
			{
				case 1:
					obc.Insertar();
					break;
				case 2:
					obc.EliminarFusion();
					break;
				case 3:
					obc.RecorridoAmplitud();
					break;
				case 4:
					obc.Búsqueda();
					break;
				case 5:
					obc.Borrar();
					break;

			}
		while (op != obm.Salir());

	}
}
