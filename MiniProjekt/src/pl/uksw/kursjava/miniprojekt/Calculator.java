package pl.uksw.kursjava.miniprojekt;

import java.util.Arrays;
import java.util.StringTokenizer;
import org.apache.commons.lang3.StringUtils;

/**
 * Dziedziczy po AbstractCalculator i implementuje CalculatorInterface.
 * 
 * @author Micha³ S³otwiñski
 *
 */
public class Calculator extends AbstractCalculator implements CalculatorInterface
{

	@Override
	public String menu()
	{
		// struktura menu
		String[] options = { "KALKULATOR\n", "1. Tryb obliczen z konsoli", "2. Tryb obliczen z pliku", "3. Wyjscie" };

		// wyswietlenie menu
		for (String s : options)
			System.out.println(s);
		System.out.println();

		// wybor
		System.out.print("Twoj wybor: ");
		String option = input.next();

		return option;
	}

	@Override
	public void commandLine()
	{
		System.out.println("\nTRYB OBLICZEN Z KONSOLI");
		String equation;

		// prosi uzytkownika o podanie rownania(bez spacji), wyswietla je razem z wynikiem,
		// az do momentu gdy uzytkownik wprowadzi "koniec".
		while (true)
		{
			System.out.print("\nPodaj rownanie(bez spacji): ");

			equation = input.next();

			if (StringUtils.contains(equation, "koniec"))
			{
				System.out.println();
				break;
			}

			if (Character.isDigit(equation.charAt(0)) && Character.isDigit(equation.charAt(equation.length() - 1)))
				System.out.println(equation + "=" + calculate(equation));
			else
				System.out.println("Rownanie nie moze zaczynac lub konczyc sie operatorem.");
		}
	}

	@Override
	public void fileLine()
	{
		System.out.println("\nTRYB OBLICZEN Z PLIKU");

		// prosi o podanie nazwy pliku z równaniami, wyswietla je razem z wynikami.
		// gdy plik jest niepoprawny, wraca do menu.
		System.out.print("\nPodaj nazwe pliku: ");
		String fileName = input.next();

		String[] equations = FileService.file(fileName);

		if (!StringUtils.isEmpty(equations[0]))
		{
			for (String equation : equations)
			{
				if (Character.isDigit(equation.charAt(0)) && Character.isDigit(equation.charAt(equation.length() - 1)))
					System.out.println(equation + "=" + calculate(equation));
				else
					System.out.println("Rownanie nie moze zaczynac lub konczyc sie operatorem.");
			}
			System.out.println();
		}
		else
			System.out.println("Pliku nie znaleziono...\n");
	}

	@Override
	protected String[] multiplicateDevide(String[] parsed)
	{
		for (int k = 0; k < parsed.length; k++)
		{
			if (parsed[k].equals("*") || parsed[k].equals("/"))
			{
				double pom3;
				double pom1 = Double.parseDouble(parsed[k - 1]);
				double pom2 = Double.parseDouble(parsed[k + 1]);

				if (parsed[k].equals("*"))
					pom3 = pom1 * pom2;
				else
					pom3 = pom1 / pom2;

				for (int p = k - 1; p < parsed.length - 2; p++)
				{
					if (p == k - 1)
						parsed[p] = Double.toString(pom3);
					else
					{
						parsed[p] = parsed[p + 2];
					}
				}

				parsed = Arrays.copyOfRange(parsed, 0, parsed.length - 2);
				k--;
			}
		}

		return parsed;
	}

	@Override
	protected double addSubstract(String[] parsed)
	{
		double result = 0.0;
		if (parsed.length == 1)
			return Double.parseDouble(parsed[0]);

		for (int k = 0; k < parsed.length; k++)
		{
			if (parsed[k].equals("+") || parsed[k].equals("-"))
			{
				double pom1 = Double.parseDouble(parsed[k - 1]);
				double pom2 = Double.parseDouble(parsed[k + 1]);

				if (parsed[k].equals("+"))
					result = pom1 + pom2;
				else
					result = pom1 - pom2;

				for (int p = k - 1; p < parsed.length - 2; p++)
				{
					if (p == k - 1)
						parsed[p] = Double.toString(result);
					else
					{
						parsed[p] = parsed[p + 2];
					}
				}

				parsed = Arrays.copyOfRange(parsed, 0, parsed.length - 2);
				k = 0;
			}
		}

		return result;
	}

	@Override
	public double calculate(String equation)
	{
		double result = 0.0;

		// parsuje, zlicza ile jest elementów w równaniu i zapisuje je w tablicy String'ów(parsed), string na jeden element.
		String delims = "[+\\-*/]";
		String[] pom = equation.split(delims);
		String[] parsed = new String[(pom.length * 2) - 1];
		StringTokenizer tokens = new StringTokenizer(equation, "+-*/", true);

		int i = 0;
		while (tokens.hasMoreTokens())
			parsed[i++] = tokens.nextToken();

		parsed = multiplicateDevide(parsed);
		result = addSubstract(parsed);

		return result;
	}
}