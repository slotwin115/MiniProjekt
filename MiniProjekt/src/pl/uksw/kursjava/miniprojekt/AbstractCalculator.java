package pl.uksw.kursjava.miniprojekt;

import java.util.Scanner;

/**
 * Implementuje statyczny skaner i dodaje metody symuluj�ce kolejno�� wykonywania dzia�a�.
 * 
 * @author Micha� S�otwi�ski
 *
 */
abstract class AbstractCalculator
{
	static Scanner input = new Scanner(System.in);

	/**
	 * Wykonuje wszystkie dzia�ania mno�enia i dzielenia w r�wnaniu, pozostawiaj�c jedynie sum� i r�nic�.
	 * 
	 * @param parsed tablica r�wna�
	 * @return String[], tablice r�wna� bez operator�w: *, /
	 */
	protected abstract String[] multiplicateDevide(String[] parsed);

	/**
	 * Wykonuje wszystkie pozosta�e dzia�ania w r�wnaniu tj. sumuje i r�nicuje.
	 * 
	 * @param parsed tablica r�wna� bez mno�enia i dzielenia.
	 * @return double, policzone r�wnanie.
	 */
	protected abstract double addSubstract(String[] parsed);
}
