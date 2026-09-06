package tema1;

public class VectorDinamico
{
	public static void main(String[] args)
	{
		int op, pos, num;
		ed.Menu obm = new ed.Menu("Vector Dinámico",
				new String[] { "Insertar", "Consultar", "Modificar", "Buscar", "Eliminar" });
		java.util.Vector<Integer> vec = new java.util.Vector<Integer>(5, 2);

		do
			switch (op = obm.Opcion())
			{
				case 1:
					vec.add(obm.obd.Entero("Escribe un número entero: "));
					break;
				case 2:
					if (!vec.isEmpty())
					{
						System.out.println("\nContenido del vector");
						/*for (pos = 0; pos < vec.size(); pos++)
							System.out.print(vec.get(pos));*/
						for (Integer ele : vec)
							System.out.print(ele);
					}
					else
						System.out.println("No hay datos en el vestor...");
					break;
				case 3:
					if (!vec.isEmpty())
					{
						num = obm.obd.Entero("Nuevo Numero: ");
						do
							pos = obm.obd.Entero("Posicion: ");
						while (pos < 1 || pos > vec.size());
						vec.set(--pos, num);
					}
					else
						System.out.println("No hay datos en el vestor...");
					break;
				case 4:
					if (!vec.isEmpty())
					{
						num = obm.obd.Entero("Numero a buscar: ");
						pos = vec.indexOf(num);
						if (pos != -1)
							System.out.println("Numero encontrado en la posicion " + (++pos));
						else
							System.out.println("El numero no se encuentra en el vector..");
					}
					else
						System.out.println("No hay datos en el vestor...");
					break;
				case 5:
					if (!vec.isEmpty())
					{
						do
							pos = obm.obd.Entero("Posicion: ");
						while (pos < 1 || pos > vec.size());
						num = vec.remove(--pos);
						System.out.println("Numero eliminados " + num);
					}
					else
						System.out.println("No hay datos en el vestor...");
			}
		while (op != obm.Salir());
	}
}
