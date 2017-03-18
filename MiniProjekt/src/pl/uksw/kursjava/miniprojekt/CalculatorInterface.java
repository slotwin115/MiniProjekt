package pl.uksw.kursjava.miniprojekt;

/**
 * Deklaruje podstawowe metody: menu, tryb w konsoli, tryb z pliku, obliczaj�ca.
 * 
 * @author Micha� S�otwi�ski
 *
 */
interface CalculatorInterface
{
	// metody publiczne i abstrakcyjne
	/**
	 * Wy�wietla menu i daje mo�liwo�� wyboru.
	 * 
	 * @return String, wyb�r elementu menu, do konwersji p�niej na int.
	 */
	String menu();

	/**
	 * Pobiera z klawiatury r�wnanie, zapisuje je jako String, oblicza je i wy�wietla.
	 * 
	 */
	void commandLine();

	/**
	 * Wy�wietla r�wnania zawarte w pliku i je oblicza.
	 * 
	 */
	void fileLine();

	/**
	 * Oblicza r�wnanie.
	 * 
	 * @param equation r�wnanie (np.2+3*5).
	 * 
	 * @return double, obliczone r�wnanie.
	 */
	double calculate(String equation);
}
