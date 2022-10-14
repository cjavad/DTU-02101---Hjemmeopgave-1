package Problem1;

public class Easter {

    public static String computeEaster(int y){
        String dato = "000" +y;
        dato = RigtigStørrelse(dato, 4);
        //Selve bergegningen
        int a,b,c,d,e,f,days;
        a = y % 4;
        b = y%7;
        c = y%19;
        d = (19*c+24)%30;
        e = (2*a+4*b+6*d+5)%7;
        f = (c+11*d+22*e)/451;
        days = 22+d+e-7*f;
        dato += toDate(days-2); //Tilføjer dagene til return strengen
        dato += toDate(days);
        dato += toDate(days+1);
        return dato;
    }

    public static String toDate(int x){ //funktionen konverterer "days" til en dato
        if(x>31){ //Tjekker om der er gået en måned
            String placeholder = " " + RigtigStørrelse("" + (x-31), 2) + ".04";
            return placeholder; 
        } else{
            String placeholder = " " + RigtigStørrelse("" + (x), 2) + ".03";
            return placeholder;
        }
    }

    public static String RigtigStørrelse(String x, int y){ //Sørger for at tilføje det korrekte antal "0" foran taller, eksempelvis "03"
        x = "000" + x; //sætter "000" foran input String
        x = x.substring(x.length()-y, x.length()); //Skærer strengen ned til at være den ønskede længde
        return x;
    }
}

