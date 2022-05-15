

**İÇİNDEKİLER**

ÖZET	3

UYGULAMA BİLGİSİ	3

KULLANILAN TEKNOLOJİLER	3

HOME ACTİVİTY	4

`  `1. Home Fragment	4

`  `2. Info Fragment	4

LİST ACTİVİTY	5

PLANT INFO ACTIVITY	6

`  `1. Genel Fragment	6

`  `2. Habitus Fragment	7

`  `3. Çiçek Fragment	7

`  `4. Yaprak Fragment	8

`  `5. Meyve Fragment	8

`  `6. Kullanım Alanları Fragment	9

`  `7. Kullanım Amacı Fragment	9

`  `8. Yetişme İsteği Fragment	10

`  `9. Diğer Bilgiler Fragment	10

KAYNAKLAR	11









**Bitki Bilgi Sistemi Mobil**

Uygulama 395 adet bitkinin bilgilerinin gösterildiği bir mobil projedir . Uygulama apk olarak kullanılabilmektedir. Google play store’ a yüklenmeye hazır bir projedir.



**ÖZET**

`	`Genel olarak uygulama java ile android studio ortamında yazılmıştır. Dizayn işlemleri Adobe Photoshop ve Xd proğramlarından faydalanılarak tasarlanmış olup xml ile uygulamada gösterilmiştir. Uygulama java  opp prensiplerinde yazılmış olup son derece dinamik bir şekilde çalışmaktadır. Veri tabanı php bot yöntemiyle *bitkivt.itu.edu.tr* web adresinden mysql sunucumuza çekilerek tek tek eksiksiz bir şekilde bitkilerin bilgileri alınmıştır. Veri tabanındaki tablolar 9 tanedir ve  bir bitkinin sahip olabileceği tüm bilgiler mevcuttur. Bunlar genel, habitus ,çiçek, yaprak ,meyve, kullanım alanları , kullanım amacı ,yetişme isteği ve diğer bilgiler olmak üzere 9 tane tablo yapısı bulunmaktadır. Uygulama telefonda son derece akıcı bir şekilde kullanılabilmektedir. Fragment yapıları ve navigation yapısı kullanılmıştır. Bu sayede bilgilere erişim oldukça hızlıdır ve uygulama son derece akıcıdır. 





**KULLANILAN TEKNOLOJİLER VE ARAÇLAR**

`	`**Yazılım Dilleri :** Java, Php, Sql ,Xml 

`  	`**Kullanılan Proğramlar :** Android Studio ,Visual Studio Code ,Adobe  PhotoShop ,Adobe Xd ,Zeplin ,DB Browser Sqlite ,PhpMyAdmin	



**Home Activity**

1. **Home Fragment**

- Bu aktivite navigation yapısını barındırır. 2 tane fragment kullanıldı 1. home fragment , 2. İnfo fragment.
- Bu aktivite uygulama ilk açıldığı zaman karşımıza gelen aktivitedir.
- Ağaç resmi bir .gif yapısı olarak tasarlanmıştır.
- Bitkiler butonu basıldığında bir sonraki bitkilerin listelendiği aktivite açılmaktadır.
- Qr kod butonu ise bitkilerin bilgileri göstermek için qr code okuyucu kameranın açılıp okunan bilgilere göre bitkinin gösterilmesi için düşünüldü . (Henüz aktif değil sebebi qr code bilgilerinin elime daha ulaşmaması.)
- İnfo butonu ise uygulama hakkında bilgilerin gösterildiği butondur.



1. Info Fragment 

- Bu fragment ise bilgilerim ,uygulama bilgileri ve derse ait bilgiler bulunuyor.
- Kaynak özellikle belirttim çünkü veri tabanı bilgilerini bitkivt.itu.edu.tr den faydalanıldı.
- Kendi linkedin hesabım ve github hesabımı bir button olarak koydum. Github hesabımda projenin kaynak kodları son hali ile yüklendi ve güncel hali devamlı bulunuyor.
- Sol üstte bulunun ise back butonu bir önceki home fragmenta tekrar dönmek için kullanıldı.



**List Activity**

- En başta bulunan yine home aktiviteye dönüş butonudur.
- Hemen sağında ise search view olarak kullanılan bitki arama için tasarlanmış bir arama bölümü bulunuyor.
- List view yapısı olarak alt bölümde bir listeleme bulunuyor.
- Bu listede 395 tane bitkinin veri tabanında bulunan latin name türündeki tablosundan veriler listeleniyor.
- Bu listede görünen bilgiler bitkilerin latince isimleridir. 
- Göstermek istediğimiz biktiye tıklamamız yeterli olacaktır bizi direk o bitkinin bilgilerini görebilileceğimiz plant info aktivitesine yönlendirecektir.








- Search bar a herhangi bir metin girdiğimizde bize tekrardan bir liste oluşturuyor. 
- Bu arama veri tabanından dinamik olarak sorgularla yapılıyor.
- Girilen metne göre latince ismin içinde geçmesi yeterli olacaktır bize direk o bitkiyi getiriyor.
- Aynı şekilde listede herhangi bir bitkiye tıkladığımız da bize onun bilgilerini getiriyor. 








**Plant Info Activity**

- Burada örnek arama yaptığımızda ve Chorisia speciosa bitkisine tıkladığımızda bize Plant Info Activity 

açılacaktır.

- Tıklananan bitkiye ait bilgiler ise plant info activitesinde gözükmektedir.


- Bu aktivitede back butonu list activitesine geri dönüp bitki araması yapmak için kullanılıyor.
- Bitkinin adı üst başlık olarak aktarılıyor ve gösteriliyor.
- Tap Layout bulunuyor burda bitkiye ait özellikler mevcut bunlar sıralanırsa : 
- Genel, Habitus, Çiçek, Yaprak, Meyve,Kullanım Alanları, Kullanım Amacı, Yetişme isteği, Diğer Bilgiler
- Bunlar veri tabanında ayrı olarak 9 tane tablo olarak tutuluyor.
- Her tablonun kendisine ait özellikleri bulunuyor. Ve bunlar özenle doğru bir şekilde listeleniyor.
- Horizontal Scrool View içerisinde bu 9 tane tablo listelendi bunlar kaydırılarak geçilebiliyor.
- Bunlara tıklandığında alt bölümde yine o tabloya ait fragmentlar bulunuyor. Fragmentlar  9 tane tablolara eş değer bir şekilde oluşturuldu. Bunun yanında Manager sınıflarıyla veriler OOP prensipleriyle dinamik olarak çekildi ve uygulamada gösterildi.

**Genel**

- Genel tablosunda  fotoğraftaki örnek bitkideki bilgiler bulunuyor.
1. Latince İsmi
1. Türkçe İsmi
1. Büyüme Formu
1. Anavatanı
1. Yetiştiği Bölge
1. Ailesi
1. Genel Hakkında Notlar 

**Habitus**

- Örnek aramada habitus alanına geçiş yaptığımızda bitkinin habitusuna ait bilgiler dinamik olarak gösteriliyor.
1. Bitkinin Şekli
1. Bitkinin Boyu
1. Bitkinin Çapı
1. Bitkinin Dokusu
1. Habitus Hakkında Notlar










**Çiçek**

- Çiçek bölümünde çiçek tablosunda bilgiler gösteriliyor.
1. Çiçek Durumu
1. Çiçek Büyüklüğü
1. Çiçek Kokusu
1. Çiçek Rengi
1. Çiçeklenme Zamanı








**Yaprak**

- Yaprak bölümüne tıklandığında yaprak tablosundaki veriler listelenmekte
1. Yaprak Dökme
1. Yaprak Tipi
1. Yaprak şekli
1. Yaprak Büyüklüğü
1. Yaprak Kokusu
1. Yaprak Dokusu
1. Yaprak Rengi
1. Yaprak Güz Rengi
1. Yaprak Hakkında Notlar







**Meyve**

- Meyve bölümüne geçtiğimizde burada meyveye ait bilgiler gösteriliyor.
1. Meyve Durumu
1. Meyve Tipi
1. Meyve Büyüklüğü
1. Meyve Rengi
1. Meyve Yenilebilirliği
1. Meyve Zamanı








**Kullanım Alanları**

- Kullanım Alanları bölümüne geçildiğinde bitkiye ait kullanım alanları bilgisi gözükmekte.
1. Kırsal Kullanım Alanları
1. Kentsel Kullanım Alanları
1. Diğer Kullanım Alanları
1. Peyzaj Tarzı
1. Kullanıma İlişkin Notlar








**Kullanım Amacı**

- Kullanım amacında ise kullanım amacı bilgileri gözükmekte bunlar,
1. Bitkinin Mühendislik İşlevleri
1. Bitkinin Mimarlık İşlevleri
1. Bitkinin Ek Özellikleri












**Yetişme İsteği**

- Yetişme isteği bölümüne tıklandığında bitkinin hangi şartlar altında yetişmek istediği bilgileri gözükmekte.
1. Gün Işığı İsteği
1. Su İsteği
1. Besin Gereksinimi
1. Toprak İsteği
1. Toprak Drenajı













**Diğer Bilgiler**

- Diğer bilgiler bölümünde ise bitkinin diğer önemli olan özellikleri bulunuyor.
1. Büyüme Hızı
1. Bakım İhtiyacı
1. Zehirlilik
1. Üretimi











**KAYNAKLAR**

*Uygulamanın Kaynak Kodları*

- [*https://github.com/aozkan9/Bitki_Bilgi_Sistemi_AndroidStudio*](https://github.com/aozkan9/Bitki_Bilgi_Sistemi_AndroidStudio)

*PHP Bot Kaynak Kodları (Veri Tabanı İşlemlerinde Kullanıldı.)*

- [*https://github.com/aozkan9/Php_Bot_BitkiDB-*](https://github.com/aozkan9/Php_Bot_BitkiDB-)

*Bitkilerin Bilgilerinin Çekildiği Web Adresi* 

- [*https://www.bitkivt.itu.edu.tr/en/*](https://www.bitkivt.itu.edu.tr/en/)

