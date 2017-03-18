package pl.uksw.kursjava.miniprojekt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Wczytuje linie z pliku i zapisuje je w tablicy.
 * 
 * @author Micha³ S³otwiñski
 *
 */
class FileService
{
	/**
	 * Wczytuje równania z pliku linijka po linijce i zapisuje do tablicy String'ów
	 * 
	 * @param fileName nazwapliku do wczytania
	 * 
	 * @return String[], tablica równañ z pliku
	 */
	static String[] file(String fileName)
	{
		File file = new File(fileName);
		String[] equations;

		try
		{
			Scanner sIn = new Scanner(file);

			int numberOfLines = 0;
			while (sIn.hasNextLine())
			{
				sIn.next();
				numberOfLines++;
			}
			sIn.close();

			equations = new String[numberOfLines];
			String equation;

			numberOfLines = 0;
			sIn = new Scanner(file);
			while (sIn.hasNextLine())
			{
				equation = sIn.next();
				equations[numberOfLines++] = equation;
			}
			sIn.close();
		}
		catch (FileNotFoundException e)
		{
			equations = new String[1];
			equations[0] = "";
		}

		return equations;
	}
}