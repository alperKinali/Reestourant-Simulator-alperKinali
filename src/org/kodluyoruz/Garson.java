package org.kodluyoruz;

public class Garson implements Runnable{
    // musteri de garson da şef de birer thread olsun diye düşündüm.
    private final Restorant restorant;
    private  int garsonId;
    Musteri musteri;

    // yapıcısını ekleyelim..
    public Garson(Restorant restorant,int garsonId) {
        this.restorant = restorant;
        this.garsonId=garsonId;
    }

    public void siparisiHazirla() throws InterruptedException {
        synchronized (restorant){
            System.out.println((garsonId + 1) + ".garson yemek siparişini aldı");
            restorant.wait();
        }

    }
    @Override
    public void run() {

            try {
                siparisiHazirla();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println((garsonId + 1) + ".garson aşçıdan aldığı yemeği servis etti.");
            restorant.notifyAll();





    }

}
