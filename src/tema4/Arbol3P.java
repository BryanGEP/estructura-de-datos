package tema4;

import ed.Menu;

public class Arbol3P
{
	public static void main(String[] args)
	{
		int op;
		Menu obm = new Menu("Arbol", new String[] { "insertar", "eliminar fusion", "eliminar copiado",
				"recorrido amplitud", "recorrido profundidad", "busqueda", "balanceo" });
		Arbol3 obc = new Arbol3();
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
					obc.EliminarCopiado();
					;
					break;
				case 4:
					obc.RecorridoAmplitud();
					break;
				case 5:
					obc.RecorridoProfundidad();
					break;
				case 6:
					obc.Búsqueda();
					break;
				case 7:
					obc.Balanceo();
					break;
				case 8:
					obc.Borrar();
			}
		while (op != obm.Salir());

	}
}
