package pl.uksw.kursjava.miniprojekt;

/**
 * Deklaruje podstawowe metody: menu, tryb w konsoli, tryb z pliku, obliczaj¹ca.
 * 
 * @author Micha³ S³otwiñski
 *
 */
interface CalculatorInterface
{
	// metody publiczne i abstrakcyjne
	/**
	 * Wyœwietla menu i daje mo¿liwoœæ wyboru.
	 * 
	 * @return String, wybór elementu menu, do konwersji póŸniej na int.
	 */
	String menu();

	/**
	 * Pobiera z klawiatury równanie, zapisuje je jako String, oblicza je i wyœwietla.
	 * 
	 */
	void commandLine();

	/**
	 * Wyœwietla równania zawarte w pliku i je oblicza.
	 * 
	 */
	void fileLine();

	/**
	 * Oblicza równanie.
	 * 
	 * @param equation równanie (np.2+3*5).
	 * 
	 * @return double, obliczone równanie.
	 */
	double calculate(String equation);
}
