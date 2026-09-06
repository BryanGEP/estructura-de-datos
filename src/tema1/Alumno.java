package tema1;

public class Alumno
{
	private String nc, nom;
	private int edad;
	private char sexo;

	public Alumno()
	{
		ed.Datos obd = new ed.Datos();
		System.out.println("Escribe los sigientes datos...");
		nc = obd.Cadena("No. Control");
		nom = obd.Cadena("Nombre").toUpperCase();
		edad = obd.Entero("Edad");
		sexo = obd.Caracter("Sexo (F/M)");
	}

	public void Mostrar()
	{
		ed.Formato obf = new ed.Formato();
		System.out.println(obf.Izquierda(nc, 10) + obf.Izquierda(nom, 25) + obf.Derecho(edad + "", 5)
				+ obf.Izquierda(sexo + "", 3).toUpperCase());
	}

	public String NoControl()
	{
		return nc;
	}

	public String Nombre()
	{
		return nom;
	}
}
