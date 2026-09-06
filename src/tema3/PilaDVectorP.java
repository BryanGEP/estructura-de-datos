package tema3;

import ed.Menu;

public class PilaDVectorP
{
	public static void main(String[] args)
	{
		int op;
		Menu obm = new Menu("Pila dinamica del vector",
				new String[] { "insertar", "extrarer", "recorrido", "buscar", "modificar", "borrar" });
		PilaDVector obp = new PilaDVector();
		do
			switch (op = obm.Opcion())
			{
				case 1:
				{
					obp.Insertar();
					break;
				}
				case 2:
				{
					obp.Extraer();
					break;
				}
				case 3:
				{
					obp.Recorrido();
					break;
				}
				case 4:
				{
					obp.Buscar();
					break;
				}
				case 5:
				{
					obp.Modificar();
					break;
				}
				case 6:
				{
					obp.Borrar();
					break;
				}
			}
		while (op != obm.Salir());
	}
}
