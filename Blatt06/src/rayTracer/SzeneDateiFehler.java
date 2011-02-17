package rayTracer;

public class SzeneDateiFehler extends Exception
{
    public SzeneDateiFehler(int zeile, String s)
    {
     super("Fehler in Szenedatei Zeile (" + zeile + ") : " + s);    
    }
}
