package pl.uksw.kursjava.miniprojekt;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * Wykonuje program.
 * 
 * @author Micha³ S³otwiñski
 *
 */
class MainCalculator
{
	/**
	 * Main.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Calculator calculator = new Calculator();

		while (true)
		{
			switch (NumberUtils.toInt(calculator.menu()))
			{
				case 1:
					calculator.commandLine();
					break;
				case 2:
					calculator.fileLine();
					break;
				case 3:
					System.out.println("Wyjscie");
					return;
				default:
					System.out.println("Zle wejscie");
					break;
			}
		}
	}
}
