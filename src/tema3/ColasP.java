package tema3;

import ed.Menu;

public class ColasP
{
	public static void main(String[] args)
	{
		int op;
		Menu obm = new Menu("Cola simple", new String[] { "insertar", "extraer", "recorrido", "buscar", "borrar" });
		Colas obc = new Colas();
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
