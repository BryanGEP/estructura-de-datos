package tema4;

import ed.Menu;

public class ArbolCueP
{
	public static void main(String[] args)
	{
		int op;
		Menu obm = new Menu("Arbol", new String[] { "insertar", "deposito ", "retiro", "eliminar fusion",
				"recorrido amplitud", "busqueda", "balanceo" });
		ArbolCue obc = new ArbolCue();
		do
			switch (op = obm.Opcion())
			{
				case 1:
					obc.Insertar();
					break;
				case 2:
					obc.Deposito();
					break;
				case 3:
					obc.Retiro();
					break;
				case 4:
					obc.EliminarFusion();
					break;
				case 5:
					obc.RecorridoAmplitud();
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
