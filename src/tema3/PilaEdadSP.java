package tema3;

import ed.Menu;

public class PilaEdadSP
{
	public static void main(String[] args)
	{
		int op;
		Menu obm = new Menu("PIla Dinamica Stack",
				new String[] { "insertar", "extraer", "recorrido", "buscar", "borrar" });
		PilaEdadS obp = new PilaEdadS();

		do
			switch (op = obm.Opcion())
			{
				case 1:
					obp.Insertar();
					break;
				case 2:
					obp.Extraer();
					break;
				case 3:
					obp.Recorrido();
					break;
				case 4:
					obp.Buscar();
					break;
				case 5:
					obp.Borrar();
					break;
			}
		while (op != obm.Salir());
	}
}
