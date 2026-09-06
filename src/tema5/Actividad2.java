package tema5;

import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.EOFException;
import java.util.Random;

import ed.Datos;

public class Actividad2
{
	private String archivo = "archivo.ila", archivo1 = "archivo1.ila", archivo2 = "archivo2.ila";
	private RandomAccessFile oba, oba1, oba2;
	private Datos obd = new Datos();
	private Random obr = new Random();
	private int can;

	public Actividad2()
	{
		int con;
		String clv = "", permitido = "0123456789AEIOU";
		do
			can = obd.Entero("Ingrese la cantidad de claves a generar: ");
		while (can < 1);
		this.Borrar();
		for (con = 0; con < can; con++)
		{
			for (int x = 0; x < 6; x++)
			{
				do
				{
					int indiceAleatorio = this.NumeroAleatorioRango(0, permitido.length() - 1);
					char caracterAleatorio = permitido.charAt(indiceAleatorio);
					clv += caracterAleatorio;
				}
				while (this.Existe(clv));
			}
			try
			{
				oba = new RandomAccessFile(archivo, "rw");
				oba.seek(con * 8);
				oba.writeUTF(clv);
				clv = "";
				oba.close();
			}
			catch (IOException e)
			{
			}
		}
		this.Mostrar(archivo);
	}

	public int NumeroAleatorioRango(int min, int max)
	{
		return obr.nextInt(min, max + 1);
	}

	private boolean Existe(String clv)
	{
		int can, con;
		boolean ban = true;
		try
		{
			oba = new RandomAccessFile(archivo, "r");
			can = (int) oba.length() / 8;
			for (con = 1; con <= can; con++)
				if (oba.readUTF().equals(clv))
					break;
			oba.close();
			ban = con <= can;
		}
		catch (IOException e)
		{
		}
		return ban;
	}

	private void Borrar()
	{
		try (RandomAccessFile oba = new RandomAccessFile(archivo, "rw"))
		{
			oba.setLength(0);
		}
		catch (IOException e)
		{
		}
	}

	private void Mostrar(String archivo)
	{
		int con = 1;
		String clv = "";
		try
		{
			oba = new RandomAccessFile(archivo, "r");
			try
			{
				System.out.println("\nContenido del archivo");
				while (true)
				{
					clv = oba.readUTF();
					System.out.print(clv + "\t");
					if (con % 10 == 0)
						System.out.println();
					con++;
				}
			}
			catch (EOFException e)
			{
				oba.close();
			}
		}
		catch (IOException e)
		{
		}
	}

	public void MezclaNatural()
	{
		int can;
		do
		{
			can = this.Particion();
			if (can != 0)
				this.Fusion();
		}
		while (can != 0);
		this.Mostrar(archivo);
	}

	private int Particion()
	{
		int can = 0, con;
		String clv, clvant = "";
		boolean arch = true;
		try
		{
			oba = new RandomAccessFile(archivo, "r");
			can = (int) oba.length() / 8;
			oba1 = new RandomAccessFile(archivo1, "rw");
			oba1.setLength(0);
			oba2 = new RandomAccessFile(archivo2, "rw");
			oba2.setLength(0);
			for (con = 1; con <= can; con++)
			{
				clv = oba.readUTF();
				if (clv.compareTo(clvant) < 0)
					arch = !arch;
				if (arch)
					oba1.writeUTF(clv);
				else
					oba2.writeUTF(clv);
				clvant = clv;
			}
			can = (int) oba2.length() / 8;
			oba.close();
			oba1.close();
			oba2.close();
		}
		catch (IOException e)
		{
		}
		return can;
	}

	private void Fusion()
	{
		int con = 0;
		String clv1, clv2;
		try
		{
			oba = new RandomAccessFile(archivo, "rw");
			oba.setLength(0);
			oba1 = new RandomAccessFile(archivo1, "r");
			oba2 = new RandomAccessFile(archivo2, "r");
			clv1 = oba1.readUTF();
			clv2 = oba2.readUTF();
			try
			{
				while (true)
				{
					if (clv1.compareTo(clv2) < 0)
					{
						oba.writeUTF(clv1);
						con++;
						clv1 = oba1.readUTF();
					}
					else
					{
						oba.writeUTF(clv2);
						clv2 = oba2.readUTF();

					}
				}
			}
			catch (EOFException e)
			{
				if (con == oba1.length() / 8)
					try
					{
						while (true)
						{
							oba.writeUTF(clv2);
							clv2 = oba2.readUTF();
						}
					}
					catch (EOFException a)
					{
						oba1.close();
						oba2.close();
					}
				else
					try
					{
						while (true)
						{
							oba.writeUTF(clv1);
							clv1 = oba1.readUTF();
						}
					}
					catch (EOFException a)
					{
						oba1.close();
						oba2.close();
					}
				oba.close();
			}
		}
		catch (IOException e)
		{
		}
	}
}
