package cz.zswi.vykazyLoader.mapper;

import cz.zswi.vykazyLoader.DocType;


/**
 *Factory trida na vraceni mapperu podle typu dat
 *
 */
public class MapperFactory {
	
	/**
	 * vytvoreni prislusneho mapperu
	 * @param typ dat
	 * @return prislusny mapper
	 */
	public static IMapper getMapper(DocType typ) {
		switch(typ) {	
		case VYKAZY: 
			try {
				return new MapperVykazy();
			} catch (Exception e) {
				System.err.println("Error: chyba mapovani souboru");
				return null;
			}
		case ZAMESTNANCI:
			try {
				return new MapperZamestnanci();
			} catch (Exception e) {
				System.err.println("Error: chyba mapovani souboru");
				return null;
			}
		default:
			return null;
		}
	}
}

