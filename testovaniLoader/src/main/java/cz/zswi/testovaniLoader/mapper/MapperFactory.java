package cz.zswi.testovaniLoader.mapper;

import cz.zswi.testovaniLoader.DocType;

/**
 * Factory trida vrati mapper podle typu dat
 */
public class MapperFactory {
	
	/**
	 * Vytvori prislusny mapper
	 * @param typ dat
	 * @return prislusny mapper
	 */
	public static IMapper getMapper(DocType typ) {
		switch(typ) {	
		case MILNIK: 
			try {
				return new MapperMilnik();
			} catch (Exception e) {
				System.err.println("Error: chyba mapovani souboru");
			}
			break;
		case NAPLANOVANE:
			try {
				return new MapperNaplanovane();
			} catch (Exception e) {
				System.err.println("Error: chyba mapovani souboru");
			}
			break;
		case VYSLEDKY:
			try {
				return new MapperVysledky();
			} catch (Exception e) {
				System.err.println("Error: chyba mapovani souboru");
			}
			break;
		}
		return null;
	}
}
