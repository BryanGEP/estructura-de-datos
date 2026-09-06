package tema3;

import ed.Menu;

public class TareaP
{
	public static void main(String[] args)
	{
		int op;
		Menu obm = new Menu("Banco", new String[] { "Crear cuenta", "consultar cuenta", "deposito", "retiro" });
		TareaPilaCola obp = new TareaPilaCola();

		do
			switch (op = obm.Opcion())
			{
				case 1:
					obp.Insertar();
					break;
				case 2:
					obp.Consultar();
					break;
				case 3:
					obp.Operacion(3);
					break;
				case 4:
					obp.Operacion(4);
					break;
			}
		while (op != obm.Salir());
	}
}
