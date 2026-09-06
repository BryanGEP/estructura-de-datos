package tema3;

import ed.Menu;

public class ListaCDMatP
{
	public static void main(String[] args)
	{
		int op1, op2;
		Menu obm1 = new Menu("Lista Circular Doble de Materia ",
				new String[] { "Insertar", "Extaer", "Recorrido", "Buscar", "Modificar", "Borar" });
		Menu obm2;
		ListaCDMat obl = new ListaCDMat();
		do
			switch (op1 = obm1.Opcion())
			{
				case 1:
					obm2 = new Menu("Menu de insertar ", new String[] { "Inicio", "Posicion", "Final", });
					do
						switch (op2 = obm2.Opcion())
						{
							case 1:
								obl.InsertarIni();
								break;
							case 2:
								obl.InsertarPos();
								break;
							case 3:
								obl.InsertarFin();
						}
					while (op2 != obm2.Salir());
					break;
				case 2:
					obm2 = new Menu("Menu de insertar ", new String[] { "Inicio", "Posicion", "Final", });
					do
						switch (op2 = obm2.Opcion())
						{
							case 1:
								obl.ExtraerIni();
								break;
							case 2:
								obl.ExtraerPos();
								break;
							case 3:
								obl.ExtraerFin();
						}
					while (op2 != obm2.Salir());
					break;
				case 3:
					obl.Recorrido();
					break;
				case 4:
					obm2 = new Menu("Menu de buscar ", new String[] { "Clave", "Plan", });
					do
						switch (op2 = obm2.Opcion())
						{
							case 1:
								obl.BuscarMat();
								break;
							case 2:
								obl.BuscarPlan();
						}
					while (op2 != obm2.Salir());
					break;
				case 5:
					obl.Modificar();
					break;
				case 6:
					obl.Borrar();
					break;
			}
		while (op1 != obm1.Salir());
	}
}
