package tema1;

public class TrabajadoresP
{
	public static void main(String[] args)
	{
		int op;
		ed.Menu obm = new ed.Menu("Control de trabajadores", new String[] { "Nuevo", "Lista", "Buscar", "Modificar","Eliminar" });
		Trabajadores obt = new Trabajadores();
		do
			switch (op = obm.Opcion())
			{
				case 1:
				{
					obt.Nuevo();
					break;
				}
				case 2:
				{
					obt.Lista();
					break;
				}
				case 3:
				{
					obt.Buscar();
					break;
				}

				case 4:
				{
					obt.Modificar();
					break;
				}
				case 5:
				{
					obt.ELiminar();
					break;
				}
			}
		while (op < obm.Salir());
	}
}
