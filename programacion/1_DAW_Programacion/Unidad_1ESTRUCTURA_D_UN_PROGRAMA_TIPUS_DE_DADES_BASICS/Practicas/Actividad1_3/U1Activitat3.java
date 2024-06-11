public class U1Activitat3 {
	public static void main(String[] args){
	final double  QUILOMETRES = 14;
	final double  MINUTS = 45;
	final double SEGONS = 30;
	double milles = (QUILOMETRES*1.6);
	double velocitaMitjaMillesPerHora= ((milles/((MINUTS*60) + SEGONS)*3600));

	System.out.println("DISTÀNCIA I TEMPS (km/h)");
	System.out.println("----------------------------");
	System.out.printf("%.0f quilòmetres %.0f' %.0f''\n\n" , QUILOMETRES , MINUTS , SEGONS);            //(QUILOMETRES + "quilòmetres (" + MINUTS + "(')" + SEGONS +"('')");
	System.out.println("VELOCITAT MITJANA (mph)");
	System.out.println("----------------------------");
	System.out.printf("\n%.2f",  velocitaMitjaMillesPerHora);

  } 
}