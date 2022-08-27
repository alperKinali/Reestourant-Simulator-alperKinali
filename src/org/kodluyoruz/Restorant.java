package org.kodluyoruz;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Restorant {
    // burada threadleri oluşturacağız
    // burada 2 tane şef, 3 tane garson ve 5 tane de masa bulunaca
    // her masada 1 tane müş denildiği için musteri sayısnı tablo olarak düşüneceğiz.
    // threadi oluşturuken bu şekilde düşüneceğiz.
    //estoranda 2 tane şef, 3 tane garson ve 5 tane de masa bulunuyor.

    int yemekSec;
    int yemekSec2;
    int YenilecekYemekS;


    String[] foods = {"Salata","Çorba","Köfte","Makarna","Tavuk Kanat","Hamburger","Paella",
            "Pizza","Baklava","Fanta"};
    int[] hazirlanmaS={200,250,250,150,250,300,500,350,100,25};
    int[]TuketilmeSuresi={300,300,400,250,300,500,400,500,200,100};


    ExecutorService customerEx= Executors.newFixedThreadPool(5 );
    // her masasda bir tane musteri oturtuldugu icin masa musteri olarak dusundum
    ExecutorService sefEx=Executors.newFixedThreadPool(2);
    ExecutorService garsonEx= Executors.newFixedThreadPool(3);
    Random rnd = new Random();
    public void restorantOlustur() throws InterruptedException{

        for (int i = 0; i < 6; i++) {
            YenilecekYemekS =rnd.nextInt((2 - 1) + 1) + 1;
            if (YenilecekYemekS==1) {
                yemekSec = rnd.nextInt(10);
                Thread.sleep(100);
                customerEx.execute(new Musteri(this, i, TuketilmeSuresi[yemekSec], foods[yemekSec]));
                Thread.sleep(200);
                garsonEx.execute(new Garson(this, i));
                Thread.sleep(300);
                sefEx.execute(new Sef(this, i, hazirlanmaS[yemekSec]));
                Thread.sleep(400);
            }
            if (YenilecekYemekS == 2){
                yemekSec = rnd.nextInt(10);
                yemekSec2 = rnd.nextInt(10);
                Thread.sleep(100);
                customerEx.execute(new Musteri(this, i, TuketilmeSuresi[yemekSec],TuketilmeSuresi[yemekSec2], foods[yemekSec],foods[yemekSec2]));
                Thread.sleep(200);
                garsonEx.execute(new Garson(this, i));
                Thread.sleep(300);
                sefEx.execute(new Sef(this, i, hazirlanmaS[yemekSec]));
                Thread.sleep(400);
            }


        }
        customerEx.shutdown();
        sefEx.shutdown();
        garsonEx.shutdown();










    }
}

