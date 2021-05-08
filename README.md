# eTicaretSistemiSimulasyonu
Engin Demiroğun düzenlemiş olduğu (Java &amp; React) Yazılım Geliştirici Yetiştirme Kampında verilen ödev5'i içermektedir. Ödev içeriği gereği bir e ticaret sitesinin çalışma prensibleri simüle edilmiştir. Kodlar yazılırkın katmanlı mimariler oluşturulmuş ve solid prensiblerine uyulmuştur. Ödevde istenilen şartlar başarı ile yerine getirilmiştir.
Ödevde istenilen şartlar ;

1-Kullanıcılar sisteme bilgilerini girerek üye olabilmelidir.
Sisteme temel kullanıcı bilgileri , e-posta ve parolayla üye olunabilmelidir. 
Temel kullanıcı bilgileri : ad, soyad, e-posta, parola. Temel bilgilerin tamamı zorunludur.
Parola en az 6 karakterden oluşmalıdır.
E-posta alanı e-posta formatında olmalıdır. (Regex ile yapınız. Araştırma konusu)
E-Posta daha önce kullanılmamış olmalıdır.
Ad ve soyad en az iki karakterden oluşmalıdır.
Üyelik sonucu kullanıcıya doğrulama e-postası gönderilmelidir. (Simulasyon)
Doğrulama linki tıklandığında üyelik tamamlanmalıdır. (Simulasyon)
Hatalı veya başarılı durumda kullanıcı bilgilendirilmelidir.

2-Kullanıcılar sisteme Google hesapları ile üye olabilmelidir. (Simulasyon)
İlerleyen zamanlarda başka yetkilendirme servisleri de kullanılabilir. (Sistemi dış servis entegrasyonu olacak şekilde yapılandırınız.)
Hatalı veya başarılı durumda kullanıcı bilgilendirilmelidir.

3-Kullanıcılar e-posta ve parola bilgisiyle sisteme giriş yapabilmelidir.
E-posta ve parola zorunludur
Hatalı veya başarılı durumda kullanıcı bilgilendirilmelidir

Yukarıdaki şartlara bakıldığında google hesapları ile üye olunabilmesi için dışarıdan eklenen sınıfımız GoogleAccount paketinin içerisinde bulunan GoogleAccountManager sınıfıdır. Ödevde belirtilen isterlerin dışında ben ekstra bir şekilde tasarladığımız sisteme başarılı bir şekilde üye olmayan kullanıcının sisteme login olamamasını 
denetleyen bir yapı daha kurdum. Kodlar ile ilgili detaylı açıklamalar java dosyalarının içerisinde bulunmaktadır. Bu çalışmayla ilgili aklınıza takılan herhangi bir şey olursa bana ulaşmaktan çekinmeyin lütfen.
