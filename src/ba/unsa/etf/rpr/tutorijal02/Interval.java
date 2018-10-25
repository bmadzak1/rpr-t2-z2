package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

    double pocetnaTacka, krajnjaTacka;
    boolean pripadaPocetna, pripadaKrajnja;

    Interval(double pocetnaTacka, double krajnjaTacka, boolean pripadaPocetna, boolean pripadaKrajnja) throws IllegalArgumentException {
        if (krajnjaTacka < pocetnaTacka) {
            throw new IllegalArgumentException();
        }

        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.pripadaPocetna = pripadaPocetna;
        this.pripadaKrajnja = pripadaKrajnja;
    }

    Interval() {
        pocetnaTacka = 0;
        krajnjaTacka = 0;
        pripadaPocetna = false;
        pripadaKrajnja = false;
    }

    public boolean isNull() {
        if (pocetnaTacka == 0 && krajnjaTacka == 0)
            return true;
        else
            return false;
    }

    public boolean isIn(double v) {
        boolean pripadaPocetak = false;
        boolean pripadaKraj = false;
        if (v > pocetnaTacka)
            pripadaPocetak = true;
        if (v < krajnjaTacka)
            pripadaKraj = true;
        if (v == pocetnaTacka && pripadaPocetna)
            pripadaPocetak = true;
        if (v == krajnjaTacka && pripadaKrajnja)
            pripadaKraj = true;
        if (pripadaPocetak && pripadaKraj)
            return true;
        else
            return false;
    }

    public Interval intersect(Interval interval){
        return new Interval();
    }

    public static Interval intersect(Interval interval1, Interval interval2){
        return new Interval();
    }
}