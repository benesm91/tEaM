##############################################################
	UŽIVATELSKÁ PŘÍRUČKA vykazyLoader
##############################################################

--------------------------------------------------------------
SPUŠTĚNÍ PROGRAMU
--------------------------------------------------------------	
Pro spuštění je potřeba Java 11 a vyšší

1) Pro zobrazení nápovědy se program spustí z příkazové řádky bez parametru nebo s přepínačem -h nebo -help
	java -jar vykazyLoader.jar
    nebo
	java -jar vykazyLoader.jar -h
    nebo
	java -jar vykazyLoader.jar -help


2) Pro zápis csv souborů do databáze se program spustí z příkazové řádky příkazem
	java -jar vykazyLoader.jar -csv <vykazy.csv> <zamestnanci.csv>

   	! Upozornění: Je nutné dodržet pořadí parametrů	


--------------------------------------------------------------
POPIS VSTUPNÍCH CSV SOUBORŮ
-------------------------------------------------------------- 
------------------------
SOUBOR vykazy.csv
------------------------
soubor vykazy.csv musí mít následující strukturu:

1) První řádek souboru je hlavička s názvy atributů (při čtení je ignorována)

2) Ostatní řádky představují jednotlivé záznamy, každý záznam musí být na samostatné řádce

3) Záznam se skládá z atributů oddělených čárkou a má následující strukturu:
	
	<ID_ZAZNAMU>,<DATUM_CINNOSTI>,<OSOBNI_CISLO>,<KOD_PRACOVNIKA>,<ZAKAZKA>,<POLOZKA>,<POZICE>,<POCET_VYKAZANE_HODINY>,<POPIS_CISLO_HLASENI>,<POPIS_CISLO_UKOL>,<POPIS_CINNOSTI>

4) Atributy budou mít následující datové typy
	ID_ZAZNAMU 		- celé číslo
	DATUM_CINNOSTI		- datum ve formátu dd.MM.yyyy
	OSOBNI_CISLO		- celé číslo
	KOD_PRACOVNIKA		- řetězec
	ZAKAZKA			- řetězec
	POLOZKA			- celé číslo
	POZICE			- celé číslo
	POCET_VYKAZANE_HODINY 	- desetinné číslo
	POPIS_CISLO_HLASENI	- řetězec
	POPIS_CISLO_UKOL	- řetězec
	POPIS_CINNOSTI		- řetězec


------------------------
SOUBOR zamestnanci.csv
------------------------
soubor zamestnanci.csv musí mít následující strukturu:

1) První řádek souboru je hlavička s názvy atributů (při čtení je ignorována)

2) Ostatní řádky představují jednotlivé záznamy, každý záznam musí být na samostatné řádce

3) Záznam se skládá z atributů oddělených čárkou a má následující strukturu:
	
	<ICP>,<JMENO>,<ZKRATKA>,<CISLO_KARTY>,<RODNE_CISLO>,<POMER_OD>,<POMER_DO>,<STREDISKO>,<UVAZEK>,<FUNKCE>,<ICP_VED>

4) Atributy budou mít následující datové typy
	ICP 		- celé číslo
	JMENO		- řetězec
	ZKRATKA		- řetězec
	CISLO_KARTY	- řetězec
	RODNE_CISLO	- řetězec
	POMER_OD	- datum ve formátu dd.MM.yyyy
	POMER_DO 	- datum ve formátu dd.MM.yyyy
	STREDISKO	- řetězec
	UVAZEK		- celé číslo
	FUNKCE		- řetězec
	ICP_VED		- celé číslo