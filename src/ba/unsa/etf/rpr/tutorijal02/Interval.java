package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private  double pocetnaTacka, krajnjaTacka;
    private boolean sadrziLiPrvu, sadrziLiDrugu;

    public double getPocetnaTacka() {
        return pocetnaTacka;
    }

    public double getKrajnjaTacka() {
        return krajnjaTacka;
    }

    public boolean isSadrziLiPrvu() {
        return sadrziLiPrvu;
    }

    public boolean isSadrziLiDrugu() {
        return sadrziLiDrugu;
    }
    public void setPocetnaTacka(double pocetnaTacka) {
        this.pocetnaTacka = pocetnaTacka;
    }

    public void setKrajnjaTacka(double krajnjaTacka) {
        this.krajnjaTacka = krajnjaTacka;
    }

    public void setSadrziLiPrvu(boolean sadrziLiPrvu) {
        this.sadrziLiPrvu = sadrziLiPrvu;
    }

    public void setSadrziLiDrugu(boolean sadrziLiDrugu) {
        this.sadrziLiDrugu = sadrziLiDrugu;
    }

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean sadrziLiPrvu, boolean sadrziLiDrugu) {
        if(pocetnaTacka >  krajnjaTacka) {
            throw new IllegalArgumentException("Pocetna tacka ispred krajnje");
        }
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.sadrziLiPrvu = sadrziLiPrvu;
        this.sadrziLiDrugu = sadrziLiDrugu;
    }



    public Interval(){
        pocetnaTacka=0;
        krajnjaTacka=0;
        sadrziLiPrvu=false;
        sadrziLiDrugu=false;
    }
    boolean isNull(){

        return  pocetnaTacka==0 && krajnjaTacka==0;
    }
    boolean isIn(double tacka){
        if(sadrziLiPrvu==true &&  sadrziLiDrugu==true)         return (tacka>=pocetnaTacka) &&  (tacka<=krajnjaTacka);
        if(sadrziLiPrvu==true && sadrziLiDrugu==false)    return (tacka>=pocetnaTacka) &&  (tacka<krajnjaTacka);;
        if(sadrziLiDrugu==true && sadrziLiPrvu==false)    return  (tacka>pocetnaTacka) &&  (tacka<=krajnjaTacka);
        if(sadrziLiPrvu==false &&  sadrziLiDrugu==false)  return (tacka>pocetnaTacka) &&  (tacka<krajnjaTacka);
        return  false;
    }
    public Interval intersect(Interval novi){
        Interval presjek = new Interval();
        if(novi.getKrajnjaTacka() < pocetnaTacka) return  presjek;
        if(pocetnaTacka > novi.getPocetnaTacka()){
            presjek.setPocetnaTacka(pocetnaTacka);
            presjek.setSadrziLiPrvu(sadrziLiPrvu);
        }else{
            presjek.setPocetnaTacka(novi.getPocetnaTacka());
            presjek.setSadrziLiPrvu(novi.isSadrziLiPrvu());
        }
        if(krajnjaTacka < novi.getKrajnjaTacka()){
            presjek.setKrajnjaTacka(krajnjaTacka);
            presjek.setSadrziLiDrugu(sadrziLiDrugu);
        }else{
            presjek.setKrajnjaTacka(novi.getKrajnjaTacka());
            presjek.setSadrziLiDrugu(novi.isSadrziLiDrugu());
        }
        return presjek;
    }

    public static Interval intersect(Interval prvi, Interval drugi){
        Interval presjek = new Interval();
            if(drugi.getKrajnjaTacka() < prvi.getPocetnaTacka()) return  presjek;
          if(prvi.getPocetnaTacka() > drugi.getPocetnaTacka()){
                presjek.setPocetnaTacka(prvi.getPocetnaTacka());
                presjek.setSadrziLiPrvu(prvi.isSadrziLiPrvu());
            }else{
                presjek.setPocetnaTacka(drugi.getPocetnaTacka());
                presjek.setSadrziLiPrvu(drugi.isSadrziLiPrvu());
            }
            if(prvi.getKrajnjaTacka() < drugi.getKrajnjaTacka()){
                presjek.setKrajnjaTacka(prvi.getKrajnjaTacka());
                presjek.setSadrziLiDrugu(prvi.isSadrziLiDrugu());
            }else{
                presjek.setKrajnjaTacka(drugi.getKrajnjaTacka());
                presjek.setSadrziLiDrugu(drugi.isSadrziLiDrugu());
            }
//        if(prvi.getKrajnjaTacka() >  drugi.getPocetnaTacka() &&  prvi.getPocetnaTacka()< drugi.getKrajnjaTacka()){
//            presjek.setKrajnjaTacka(prvi.getKrajnjaTacka());
//            presjek.setSadrziLiDrugu(false);
//            if(prvi.getPocetnaTacka() > drugi.getPocetnaTacka()){
//                presjek.setPocetnaTacka(prvi.getPocetnaTacka());
//                presjek.setSadrziLiPrvu(false);
//            }else{
//                presjek.setPocetnaTacka(drugi.getPocetnaTacka());
//                presjek.setSadrziLiPrvu(false);
//            }
//        }
//        if(drugi.getKrajnjaTacka() >  prvi.getPocetnaTacka() &&  drugi.getPocetnaTacka()< prvi.getKrajnjaTacka()){
//            presjek.setKrajnjaTacka(drugi.getKrajnjaTacka());
//            presjek.setSadrziLiDrugu(false);
//            if(drugi.getPocetnaTacka() > prvi.getPocetnaTacka()){
//                presjek.setPocetnaTacka(drugi.getPocetnaTacka());
//                presjek.setSadrziLiPrvu(false);
//            }else{
//                presjek.setPocetnaTacka(prvi.getPocetnaTacka());
//                presjek.setSadrziLiPrvu(false);
//            }
//        }




        return presjek;
    }


    @Override
    public String toString() {
        if(sadrziLiPrvu==true && sadrziLiDrugu==true ) return "["+pocetnaTacka+","+krajnjaTacka+ "]";
        if(sadrziLiPrvu==true  && sadrziLiDrugu==false) return "[" + pocetnaTacka + "," + krajnjaTacka + ")";
        if(sadrziLiPrvu==false && sadrziLiDrugu==true) return "(" + pocetnaTacka + "," + krajnjaTacka + "]";
        return "()";
    }

    @Override
    public boolean equals(Object obj) {
        Interval novi = (Interval) obj;
        return (novi.getPocetnaTacka()==pocetnaTacka && novi.getKrajnjaTacka()==krajnjaTacka
        && novi.isSadrziLiPrvu()==sadrziLiPrvu && novi.isSadrziLiDrugu()==sadrziLiDrugu);
    }
}
