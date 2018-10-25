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
        double prvaVrijednost = 0, drugaVrijednost = 0;
        boolean prvaUkljucena = false, drugaUkljucena = false;

        if(pocetnaTacka < interval.pocetnaTacka)
        {
            prvaVrijednost = interval.pocetnaTacka;
            if(interval.pripadaPocetna)
                prvaUkljucena = true;
            else
                prvaUkljucena = false;
        }

        if(interval.pocetnaTacka < pocetnaTacka)
        {
            prvaVrijednost = pocetnaTacka;
            if(pripadaPocetna)
                prvaUkljucena = true;
            else
                prvaUkljucena = false;
        }

        if(pocetnaTacka == interval.pocetnaTacka)
        {
            prvaVrijednost = pocetnaTacka;
            if(pripadaPocetna && interval.pripadaPocetna)
                prvaUkljucena = true;
            else
                prvaUkljucena = false;
        }

        if(krajnjaTacka < interval.krajnjaTacka)
        {
            drugaVrijednost = krajnjaTacka;
            if(pripadaKrajnja)
                drugaUkljucena = true;
            else
                drugaUkljucena = false;
        }

        if(interval.krajnjaTacka < krajnjaTacka)
        {
            drugaVrijednost = interval.krajnjaTacka;
            if(interval.pripadaKrajnja)
                drugaUkljucena = true;
            else
                drugaUkljucena = false;
        }

        if(krajnjaTacka == interval.krajnjaTacka)
        {
            drugaVrijednost = krajnjaTacka;
            if(pripadaKrajnja && interval.pripadaKrajnja)
                drugaUkljucena = true;
            else
                drugaUkljucena = false;
        }

        return new Interval(prvaVrijednost, drugaVrijednost, prvaUkljucena, drugaUkljucena);
    }

    public static Interval intersect(Interval interval1, Interval interval2){
        double prvaVrijednost = 0, drugaVrijednost = 0;
        boolean prvaUkljucena = false, drugaUkljucena = false;

        if(interval1.pocetnaTacka < interval2.pocetnaTacka)
        {
            prvaVrijednost = interval2.pocetnaTacka;
            if(interval2.pripadaPocetna)
                prvaUkljucena = true;
            else
                prvaUkljucena = false;
        }

        if(interval2.pocetnaTacka < interval1.pocetnaTacka)
        {
            prvaVrijednost = interval1.pocetnaTacka;
            if(interval1.pripadaPocetna)
                prvaUkljucena = true;
            else
                prvaUkljucena = false;
        }

        if(interval1.pocetnaTacka == interval2.pocetnaTacka)
        {
            prvaVrijednost = interval1.pocetnaTacka;
            if(interval1.pripadaPocetna && interval2.pripadaPocetna)
                prvaUkljucena = true;
            else
                prvaUkljucena = false;
        }

        if(interval1.krajnjaTacka < interval2.krajnjaTacka)
        {
            drugaVrijednost = interval1.krajnjaTacka;
            if(interval1.pripadaKrajnja)
                drugaUkljucena = true;
            else
                drugaUkljucena = false;
        }

        if(interval2.krajnjaTacka < interval1.krajnjaTacka)
        {
            drugaVrijednost = interval2.krajnjaTacka;
            if(interval2.pripadaKrajnja)
                drugaUkljucena = true;
            else
                drugaUkljucena = false;
        }

        if(interval1.krajnjaTacka == interval2.krajnjaTacka)
        {
            drugaVrijednost = interval1.krajnjaTacka;
            if(interval1.pripadaKrajnja && interval2.pripadaKrajnja)
                drugaUkljucena = true;
            else
                drugaUkljucena = false;
        }

        return new Interval(prvaVrijednost, drugaVrijednost, prvaUkljucena, drugaUkljucena);
    }

    @Override
    public String toString(){
        if(pocetnaTacka != 0 && krajnjaTacka != 0) {
            String string = new String();
            if (pripadaPocetna)
                string += "[";
            else
                string += "(";
            string += pocetnaTacka;
            string += ",";
            string += krajnjaTacka;
            if (pripadaKrajnja)
                string += "]";
            else
                string += ")";
            return string;
        }
        else return "()";
    }

    @Override
    public boolean equals(Object o){
        Interval interval = (Interval) o;
        if(pocetnaTacka == ((Interval) o).pocetnaTacka && krajnjaTacka == ((Interval) o).krajnjaTacka)
            if(pripadaPocetna == ((Interval) o).pripadaPocetna && pripadaKrajnja == ((Interval) o).pripadaKrajnja)
                return true;
        return  false;
    }
}