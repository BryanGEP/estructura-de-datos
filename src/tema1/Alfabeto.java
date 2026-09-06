package tema1;

public class Alfabeto
{
	private int di, dir, pos;
	private String cad = "AMRGHO";
	private char vec[] = new char[26];

	private ed.Datos obd = new ed.Datos();

	public Alfabeto()
	{
		do
			di = obd.Entero("Direccion inicial: ");
		while (di < 1);
		for (pos = 0; pos < vec.length; pos++)
			vec[pos] = (char) (65 + pos);
	}

	public void Direcciones()
	{

		for (pos = 0; pos < vec.length; pos++)
		{
			if (cad.indexOf(vec[pos]) != -1)
				dir = di + pos * 2;
			else
				dir = 0;
			this.Mostrar();
		}
	}

	private void Mostrar()
	{
		System.out.println(pos + "\t" + vec[pos] + "\t" + (dir != 0 ? dir : ""));
	}
}
