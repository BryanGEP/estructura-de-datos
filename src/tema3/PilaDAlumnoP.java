package tema3;

import ed.Menu;

public class PilaDAlumnoP
{
	public static void main(String[] args)
	{
		int op;
		Menu obm = new Menu("Pila dinamica alumno",
				new String[] { "insertar", "extrarer", "recorrido", "buscar", "eliminar", "modificar" });
		PilaDAlumno obp = new PilaDAlumno();

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
					obp.Borrar();
					break;
				}
				case 6:
				{
					obp.Modificar();
					break;
				}
			}
		while (op != obm.Salir());
	}
}
