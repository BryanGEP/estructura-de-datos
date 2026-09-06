package tema1;

public class Matriz
{
	private int di, ren, col, mat[][];
	private ed.Datos obd = new ed.Datos();

	public Matriz()
	{
		do
			ren = obd.Entero("Numero de renglones: ");
		while (ren < 2);
		do
			di = obd.Entero("Direccion inicial: ");
		while (di < 1);
		mat = new int[ren][ren];
	}

	public void Direccciones()
	{
		for (ren = 0; ren < mat.length; ren++)
			// for (col = 0; col < mat[ren].length; col++)
			mat[ren][ren] = di + (mat[0].length * ren + ren) * 4;
	}

	public void Mostrar()
	{
		System.out.println("Direcciones de memoria de la diagonal principal");
		for (ren = 0; ren < mat.length; ren++)
			// for (col = 0; col < mat[ren].length; col++)
			// if (ren == col)
			System.out.println(" [" + ren + "," + ren + "] " + mat[ren][ren]);
	}

	public void Mostrar2()
	{
		for (ren = 0; ren < mat.length; ren++)
		{
			for (col = 0; col < mat[ren].length; col++)
				System.out.print(mat[ren][col] + "\t");
			System.out.println();
		}
	}

	public void DirecccionesCol()
	{
		for (ren = 0; ren < mat.length; ren++)
			mat[ren][ren] = di + (mat.length * col + ren) * 4;
	}
}
