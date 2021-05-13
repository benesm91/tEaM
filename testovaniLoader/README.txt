##############################################################
	UŽIVATELSKÁ PŘÍRUČKA testovaniLoader
##############################################################

--------------------------------------------------------------
SPUŠTĚNÍ PROGRAMU
--------------------------------------------------------------	
Pro spuštění je potřeba Java 11 a vyšší

1) Pro zobrazení nápovědy se program spustí z příkazové řádky bez parametru nebo s přepínačem -h nebo -help
	java -jar testovaniLoader.jar
    nebo
	java -jar testovaniLoader.jar -h
    nebo
	java -jar testovaniLoader.jar -help


2) Pro zápis csv souborů do databáze se program spustí z příkazové řádky příkazem
	java -jar testovaniLoader.jar -csv <milniky.csv> <naplanovaneTesty.csv> <vysledkyTestu.csv>

   	! Upozornění: Je nutné dodržet pořadí parametrů	


--------------------------------------------------------------
POPIS VSTUPNÍCH CSV SOUBORŮ
-------------------------------------------------------------- 
------------------------
SOUBOR milniky.csv
------------------------
soubor milniky.csv musí mít následující strukturu:

1) První řádek souboru je hlavička s názvy atributů (při čtení je ignorována)

2) Ostatní řádky představují jednotlivé záznamy, každý záznam musí být na samostatné řádce

3) Záznam se skládá z atributů oddělených čárkou a má následující strukturu:
	
	<ID_MILNIK>,<KOD>,<NAZEV>,<SYSTEM>,<DATUM_TERMIN>,<STAV_MILNIKU>,<CISLO_HLASENI>,<ROK_HLASENI>

4) Atributy budou mít následující datové typy
	ID_MILNIK 	- celé číslo
	KOD		- řetězec
	NAZEV		- řetězec
	SYSTEM		- řetězec
	DATUM_TERMIN	- datum ve formátu dd.MM.yyyy
	STAV_MILNIKU	- řetězec
	CISLO_HLASENI	- celé číslo
	ROK_HLASENI	- celé číslo	


------------------------
SOUBOR naplanovaneTest.csv
------------------------
soubor naplanovaneTest.csv musí mít následující strukturu:

1) První řádek souboru je hlavička s názvy atributů (při čtení je ignorována)

2) Ostatní řádky představují jednotlivé záznamy, každý záznam musí být na samostatné řádce

3) Záznam se skládá z atributů oddělených čárkou a má následující strukturu:
	
	<ID_TESTOVACIHO_PRIPADU>,<ID_MILNIK>,<PORADOVE_CISLO>

4) Atributy budou mít následující datové typy
	ID_TESTOVACIHO_PRIPADU 	- celé číslo
	ID_MILNIK		- celé číslo
	PORADOVE_CISLO		- celé číslo


------------------------
SOUBOR vysledkyTestu.csv
------------------------
soubor vysledkyTestu.csv musí mít následující strukturu:

1) První řádek souboru je hlavička s názvy atributů (při čtení je ignorována)

2) Ostatní řádky představují jednotlivé záznamy, každý záznam musí být na samostatné řádce

3) Záznam se skládá z atributů oddělených čárkou a má následující strukturu:
	
	<ID_VYSL_TESTOVACIHO_PRIPADU>,<ID_MILNIK>,<ID_TESTOVACIHO_PRIPADU>,<VYSLEDEK>,<KOD>,<NAZEV>,<PRIORITA>,<STAV>,<SYSTEM>,<TYP_TESTU>,<PRIZNAK_AN_UKONCEN>,<OTESTOVAL>,<ID_SKUPINY_VE_SKUPINE_TESTU>,<ID_SKUPINY_TESTU>,<DATUM_DOKONCENI_TESTU>

4) Atributy budou mít následující datové typy
	ID_VYSL_TESTOVACIHO_PRIPADU 	- celé číslo
	ID_MILNIK			- celé číslo
	ID_TESTOVACIHO_PRIPADU		- celé číslo
	VYSLEDEK			- řetězec
	KOD				- řetězec
	NAZEV				- řetězec
	PRIORITA			- celé číslo
	STAV				- řetězec	
	SYSTEM				- řetězec
	TYP_TESTU			- řetězec
	PRIZNAK_AN_UKONCEN		- řetězec
	OTESTOVAL			- řetězec
	ID_SKUPINY_VE_SKUPINE_TESTU	- celé číslo
	ID_SKUPINY_TESTU		- celé číslo
	DATUM_DOKONCENI_TESTU		- datum ve formátu dd.MM.yyyy HH:mm:ss