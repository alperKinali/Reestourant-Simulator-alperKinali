
# Java Bootcamp Restorant Simülasyon Ödevi

Ödev bir restoran simulasyonu. Restoranda 2 tane şef, 3 tane garson ve 5 tane de masa bulunuyor. Restoran sürekli açık ve
müşteriler restorana gelip boş masalara oturup garsonlara sipariş veriyor. Garsonlar da siparişleri şeflere iletip daha 
sonra hazır olan siparişleri masalara dağıtıyor. Her müşterinin verdigi siparise gore masada belli bir süre oturma hakkı olduğunu düşünelim.
Vakti dolan müşteri masadan kalkar ve yeni müşteriler restorana girer. Her masada bir müşteri oturabildiğini ve müşterilerin 
teker teker restorana geldiğini varsayalım. Her müşteri en az 1 en fazla 2 yemek siparişi verebilir ve siparisi aldiktan sonra
siparis ettigi tüm yemeklerin toplam tüketilme süresi kadar masada oturabilir. Sefler yemekleri siparislerin kendilerine ulaşma 
sirasina göre hazırlar ve her bir şef ayni anda tek bir yemek pişirebilir. Her bir yemegin pisme suresi onun hazirlanma suresi kadardir.


Yemek listesi
	| ID | Isim | Hazirlanma Suresi | Tuketilme Suresi |
| ----------- | ----------- | ------------ | ----------- |
| 1 | Salata | 200ms | 300ms |
| 2 | Çorba | 250ms | 300ms |
| 3 | Köfte | 250ms | 400ms |
| 4 | Makarna | 150ms | 250ms |
| 5 | Tavuk Kanat | 250ms | 300ms |
| 6 | Hamburger | 300ms | 500ms
| 7 | Paella | 500ms | 400ms |
| 8 | Pizza | 350ms | 500ms |
| 9 | Baklava | 100ms | 200ms |
| 10 | Fanta | 25ms | 100ms |

Burada önemli olan gerçek hayatta olduğu gibi masalarda oturan müşterilerin, sipariş alan garsonların ve siparişleri hazırlayan
şeflerin gerçekten olduğu gibi birbirlerinden bağımsız çalışabilmesi ve her işlem sırasında ve sonrasında simulasyonun doğru
çalıştığını anlayabilmemiz için uygun logların ekrana basılması gerekir.

Ödev tamamen java dilinde multithread özelliğinin kullanılma yeteneğini ölçmeye yöneliktir. Her bir müşteriyi, garsonu ve şefi
birer thread her bir görevi de bir task olarak düşünebilirsiniz.


