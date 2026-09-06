package tema3;

import ed.Menu;
import ed.Datos;

public class PilaTrasStackP
{
	public static void main(String[] args)
	{
		int op, op2;
		Datos obd = new Datos();
		Menu obm = new Menu("PIla Dinamica Stack Trabajador",
				new String[] { "insertar", "extraer", "recorrido", "buscar", "modificar", "borrar" });
		PilaTrasStack obp = new PilaTrasStack();

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
					do
						op2 = obd.Entero("Que buscas modificar 1)nt 2)nombre o apellido 3)Rango de sueldo: ");
					while (op2 < 1 || op2 > 3);
					obp.Buscar(op2);
					break;
				case 5:
					obp.Modificar();
					break;
				case 6:
					obp.Borrar();
					break;
			}
		while (op != obm.Salir());
	}
}
