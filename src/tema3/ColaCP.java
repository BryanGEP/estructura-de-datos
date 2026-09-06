package tema3;

import ed.Menu;

public class ColaCP
{
	public static void main(String[] args)
	{
		int op;
		Menu obm = new Menu("Cola dinamica producto",
				new String[] { "insertar", "extraer", "recorrido", "buscar", "borrar" });
		ColaC obc = new ColaC();
		do
			switch (op = obm.Opcion())
			{
				case 1:
					obc.Insertar();
					break;
				case 2:
					obc.Extraer();
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
