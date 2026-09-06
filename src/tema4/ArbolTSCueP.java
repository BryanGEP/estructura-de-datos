package tema4;

import ed.Menu;

public class ArbolTSCueP
{
	public static void main(String[] args)
	{
		int op;
		Menu obm = new Menu("Arbol cuenta",
				new String[] { "insertar", "eliminar", "recorrido", "busqueda", "borrar", "deposito", "retiro" });
		ArbolTSCue obc = new ArbolTSCue();
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
				case 6:
					obc.Deposito();
					break;
				case 7:
					obc.Retiro();
					break;

			}
		while (op != obm.Salir());

	}
}
