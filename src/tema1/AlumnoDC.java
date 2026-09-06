package tema1;

public class AlumnoDC
{
	public static void main(String[] args)
	{
		int op;
		ed.Menu obm = new ed.Menu("Control de alumnos",
				new String[] { "Insertar", "consultar", "modificar", "buscar", "eliminar" });
		AlumnoDP obv = new AlumnoDP();

		do
			switch (op = obm.Opcion())
			{
				case 1:
					obv.Insetar();
					break;
				case 2:
					obv.Consultar();
					break;
				case 3:
					obv.Modificar();
					break;
				case 4:
					obv.Buscar();
					break;
				case 5:
					obv.Eliminar();

			}
		while (op != obm.Salir());
	}
}
