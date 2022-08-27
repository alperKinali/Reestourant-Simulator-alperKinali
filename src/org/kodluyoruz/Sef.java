package org.kodluyoruz;

public class Sef implements Runnable {

    // musteri de garson  şef da birer thread olsun diye düşündüm.
    // bu nedenle runnable sınıfından alındı.
    private int hazirlamaSürsi;
    private  int hazirlamaSürsi2;

    public int getHazirlamaSürsi() {
        return hazirlamaSürsi;
    }

    public void setHazirlamaSürsi(int hazirlamaSürsi) {
        this.hazirlamaSürsi = hazirlamaSürsi;
    }

    private final Restorant restorant;
    private int sefId;


    //1 yemek için yapici
    public Sef(Restorant restorant, int sefId, int hazirlamaSürsi) {
        this.restorant = restorant;
        this.sefId = sefId;
        this.hazirlamaSürsi = hazirlamaSürsi;
    }
    // 2 yemek için yapici
    /*
    public Sef(Restorant restorant, int sefId, int hazirlamaSürsi,int hazirlamaSürsi2) {
        this.restorant = restorant;
        this.sefId = sefId;
        this.hazirlamaSürsi = hazirlamaSürsi;

    }

     */

    public void yemekYap() throws InterruptedException {

        synchronized (restorant){
            Thread.sleep(hazirlamaSürsi);
            //restorant.wait();
        }

    }

    @Override
    public void run() {
        System.out.println("Şef "+ (sefId+1)+"garsondan aldığı yemeği hazırlıyor.");
        try {
            yemekYap();
            //restorant.wait();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        //restorant.notifyAll();
        System.out.println("Şef "+ (sefId+1)+"yemeği hazırladı servise hazır.");




    }
}
