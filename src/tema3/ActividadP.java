package tema3;

import ed.Menu;

public class ActividadP
{
	public static void main(String[] args)
	{
		int op;
		Menu obm = new Menu("Lista Dinamica",
				new String[] { "insertar", "extraer", "recorrido", "buscar", "modificar" });
		Actividad obc = new Actividad();
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
					obc.Modificar();
					break;
			}
		while (op != obm.Salir());
	}
}
