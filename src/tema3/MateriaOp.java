package tema3;

import ed.*;

public class MateriaOp
{
	private Materia2 mat;
	private Datos obd = new Datos();
	private Formato obf = new Formato();

	public MateriaOp(int clv)
	{
		mat = new Materia2();
		mat.setClave(clv);
		System.out.println("Escribe los datos de la materia...");
		System.out.println("Clave " + mat.getClave());
		mat.setNombre(obd.Cadena("Nombre").toUpperCase());
		do
			mat.setHorasTeo(obd.Entero("Cantidad de horas teóricas"));
		while (mat.getHorasTeo() < 1);
		do
			mat.setHorasPrac(obd.Entero("Cantidad de horas prácticas"));
		while (mat.getHorasPrac() < 1);
		mat.setCreditos(mat.getHorasTeo() + "-" + mat.getHorasPrac() + "-" + (mat.getHorasTeo() + mat.getHorasPrac()));
		System.out.println("Creditos " + mat.getCreditos());
		do
			mat.setPlan(obd.Entero("Plan de estudios"));
		while (mat.getPlan() < 1);
	}

	public void Mostrar()
	{
		System.out.println(obf.Izquierda(mat.getClave() + "", 10) + " | " + obf.Izquierda(mat.getNombre(), 25) + " | "
				+ obf.Izquierda(mat.getHorasTeo() + "", 5) + " | " + obf.Izquierda(mat.getHorasPrac() + "", 5) + " | "
				+ obf.Izquierda(mat.getCreditos() + "", 10) + " | " + obf.Izquierda(mat.getPlan() + "", 10));
	}

	public int Clave()
	{
		return mat.getClave();
	}

	public int Plan()
	{
		return mat.getPlan();
	}

	public void Modificar()
	{
		int op;
		Menu obm = new Menu("Modificaciones", new String[] { "Nombre", "Creditos", "Plan" });
		do
			switch (op = obm.Opcion())
			{
				case 1:
					mat.setNombre(obd.Cadena(mat.getNombre() + "Nuevo nombre").toUpperCase());
					break;

				case 2:
					mat.setCreditos(obd.Cadena(mat.getCreditos() + "Nuevos creditos").toUpperCase());
					break;

				case 3:
					mat.setPlan(obd.Entero(mat.getPlan() + "Nuevos creditos"));

					break;
			}

		while (op != obm.Salir());
	}

	public String Nombre()
	{
		return mat.getNombre();
	}
}
