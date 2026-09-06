package tema1;

public class Tiempo
{
	private int ind, vec[];

	public void Aleatorios()
	{
		java.util.Random obr = new java.util.Random();
		for (ind = 0; ind < vec.length; ind++)
			vec[ind] = obr.nextInt(100);
	}

	public int Pares()
	{
		int con = 0;
		for (ind = 0; ind < vec.length; ind++)
			if (vec[ind] % 2 == 0)
				con++;
		return con;
	}

	public int Factorial()
	{
		int fact = 1, num;
		ed.Datos obd = new ed.Datos();
		num = obd.Entero("Escribe el numero: ");

		for (ind = 1; ind <= num; ind++)
			fact *= num;
		return fact;
	}

	public int Fact()
	{
		int fact = 1, num;
		ed.Datos obd = new ed.Datos();
		num = obd.Entero("Escribe el numero: ");

		for (ind = num; ind > 1 ; ind--)
			fact *= num;
		return fact;

	}
}
