package tema4;

import ed.Datos;
import ed.Menu;

public class GrafoP
{
	public static void main(String[] args)
	{
		Datos obd = new Datos();

		int op, op2;
		Menu obm = new Menu("Grafo", new String[] { "Añadir", "Mostrar", "Conexo", "Grado", "Camino", });
		Grafo obg = new Grafo();
		do
			switch (op = obm.Opcion())
			{
				case 1:
					obg.Añadir();
					break;
				case 2:
					obg.Mostrar();
					break;
				case 3:
					obg.Conexo();
					break;
				case 4:
					obg.Grado();
					break;
				case 5:
					do
						op2 = obd.Entero("Desea buscar un camino en este grafo \n1.-SI\n2.-NO");
					while (op2 < 1 || op2 > 2);
					if (op2 == 1)
					{
						int ren = obd.Entero("De el vertice de partida:");
						int col = obd.Entero("De el vertice a llegar: ");
						obg.Camino(ren, col);
						System.out.println("*GRAFO EVALUADO*");
					}
					
			}
		while (op != obm.Salir());
	}
}
