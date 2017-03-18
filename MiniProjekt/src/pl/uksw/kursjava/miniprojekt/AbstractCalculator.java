package pl.uksw.kursjava.miniprojekt;

import java.util.Scanner;

/**
 * Implementuje statyczny skaner i dodaje metody symuluj¹ce kolejnoœæ wykonywania dzia³añ.
 * 
 * @author Micha³ S³otwiñski
 *
 */
abstract class AbstractCalculator
{
	static Scanner input = new Scanner(System.in);

	/**
	 * Wykonuje wszystkie dzia³ania mno¿enia i dzielenia w równaniu, pozostawiaj¹c jedynie sumê i ró¿nicê.
	 * 
	 * @param parsed tablica równañ
	 * @return String[], tablice równañ bez operatorów: *, /
	 */
	protected abstract String[] multiplicateDevide(String[] parsed);

	/**
	 * Wykonuje wszystkie pozosta³e dzia³ania w równaniu tj. sumuje i ró¿nicuje.
	 * 
	 * @param parsed tablica równañ bez mno¿enia i dzielenia.
	 * @return double, policzone równanie.
	 */
	protected abstract double addSubstract(String[] parsed);
}
