package tema3;

import ed.Menu;

public class BicolaNombresP
{
	public static void main(String[] args)
	{
		int op;
		Menu obm = new Menu("BICOLA",
				new String[] { "insertar", "extraer", "recorrido", "buscar", "modificar", "borrar" });
		BicolaNombres obc = new BicolaNombres();
		do
			switch (op = obm.Opcion())
			{
				case 1:
					obc.InsertarIni();
					break;
				case 2:
					obc.ExtraerIni();
					break;
				case 3:
					obc.Recorrido();
					break;
				case 4:
					obc.Buscar();
					break;
				case 5:
					obc.Recorrido();
					break;
				case 6:
					obc.Borrar();
					break;
			}
		while (op != obm.Salir());
	}
}
