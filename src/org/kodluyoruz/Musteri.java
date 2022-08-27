package org.kodluyoruz;

public class Musteri implements  Runnable{
    // musteri de garson şef  da birer thread olsun diye düşündüm.
    private final Restorant restorant;
    private int musteriId;
    private int yemesuresi;
    private int yemesuresi2;
    private String yemek_adi;
    private String yemek_adi2;
    public int getYemesuresi() {
        return yemesuresi;
    }
    public void setYemesuresi(int yemesuresi) {
        this.yemesuresi = yemesuresi;
    }
    public int getMusteriId() {
        return musteriId;
    }

    public String getYemek_adi() {return yemek_adi;}
    public void setYemek_adi(String yemek_adi) {this.yemek_adi = yemek_adi;}
    // 1 secim
    public Musteri(Restorant restorant, int musteriId, int yemeSuresi, String yemek_adi) {
        this.restorant = restorant;
        this.musteriId = musteriId;
        this.yemesuresi = yemeSuresi;
        this.yemek_adi=yemek_adi;
    }
    // 2 secim
    public Musteri(Restorant restorant, int musteriId, int yemeSuresi,int yemesuresi2, String yemek_adi, String yemek_adi2) {
        this.restorant = restorant;
        this.musteriId = musteriId;
        this.yemesuresi = yemeSuresi;
        this.yemesuresi2=yemesuresi2;
        this.yemek_adi=yemek_adi;
        this.yemek_adi2=yemek_adi2;
    }

    public  void  yemekYe() throws  InterruptedException{
        // .. Yemek yeme süresi bu alanda olacak.
        //restorant.notifyAll();
        synchronized (restorant) {
            if (yemek_adi2!=null){
                // ikinci bir yemek var ise

                System.out.println((musteriId + 1) + " . musteri restorana geldi " + (musteriId + 1) % 6 + " .masaya oturdu");
                System.out.println((musteriId + 1) + " . musteri garsondan "+yemek_adi+"ve" +yemek_adi2+" yemeklerini istedi." );
                Thread.sleep(yemesuresi+yemesuresi2);

            }
            if (yemek_adi2==null){
                System.out.println((musteriId + 1) + " . musteri restorana geldi " + (musteriId + 1) % 6 + " .masaya oturdu");
                System.out.println((musteriId + 1) + " . musteri garsondan "+yemek_adi+" Yemeğini istedi." );
                Thread.sleep(yemesuresi);

            }

            //restorant.wait();

        }
    }
    @Override
    public void run() {
        //System.out.println((musteriId + 1) + " . musteri restorana geldi " + (musteriId + 1) % 6 + " .masaya oturdu");
        //System.out.println((musteriId + 1) + " . musteri garsondan "+yemek_adi+" Yemeğini istedi." );
        try {
            yemekYe();
            //restorant.wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //restorant.notifyAll();

    }

}
