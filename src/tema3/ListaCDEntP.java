package tema3;

import ed.Menu;

public class ListaCDEntP
{
	public static void main(String[] args)
	{
		int op, op2;
		Menu obm = new Menu("Lista Doble", new String[] { "insertar", "extraer", "recorrido", "buscar", "borrar" });
		Menu obm2;
		ListaCDEnt obc = new ListaCDEnt();
		do
			switch (op = obm.Opcion())
			{
				case 1:
					obm2 = new Menu("Insertar", new String[] { "inicio", "posicion", "final" });
					do
						switch (op2 = obm2.Opcion())
						{
							case 1:
								obc.InsertarIni();
								break;
							case 2:
								obc.InsertarPos();
								break;
							case 3:
								obc.InsertarFin();
						}
					while (op2 != obm2.Salir());
					break;
				case 2:
					obm2 = new Menu("Extraer", new String[] { "inicio", "posicion", "final" });
					do
						switch (op2 = obm2.Opcion())
						{
							case 1:
								obc.ExtraerIni();
								break;
							case 2:
								obc.ExtraerPos();
								break;
							case 3:
								obc.ExtraerFin();
						}
					while (op2 != obm2.Salir());
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
