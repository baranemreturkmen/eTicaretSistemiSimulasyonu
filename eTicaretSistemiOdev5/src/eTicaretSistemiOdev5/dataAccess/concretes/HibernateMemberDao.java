package eTicaretSistemiOdev5.dataAccess.concretes;

import eTicaretSistemiOdev5.business.abstracts.ValidationService;
import eTicaretSistemiOdev5.dataAccess.abstracts.MemberDao;
import eTicaretSistemiOdev5.entities.abstracts.Entity;

public class HibernateMemberDao implements MemberDao{
	
	//Kendine kural edin bağımlılıktan kurtulmak adına soldaki referans tutucu parametreler interface olsun!
	//Objen bir bilgi tutan sınıf olsun , bir veritabanı işi yapan class olsun, sisteme yönelik iş kodlarını
	//içeren bir sınıf olsun yada validation doğrulama yapan bir class olsun özetle ne olursa olsun bu kuraldan
	//kaçma ileride kodumuza eklenecek durumlarda bağımlılıkları gidermek adına.
	
	//Kullancının üye olurken girdiği parolayı mail adresini ismini ve soy ismini doğrulamadan veri tabanına 
	//kaydetme işleri yapmamalıyım. Bu doğrulama işini oluşturduğum validation sınıfı ile yapıyorum. Veri tabanı
	//işlerinde doğrulama işini aktif bir şekilde kullanacağım için doğrulama sınıfını kullanmadan kullanıcıyı 
	//veritabanına kaydetmemek adına constructor injection yöntemi ile veritabanı işlerini yaptığım HibernateMemberDao
	//sınıfının ValidationManager sınıfını kullanmasını zorunlu kıldım. Main'de HibernateMemberDao newlendiği anda
	//parametre olarak ValidationService tipinde bir Validation sınıfı isteyecek.
	ValidationService validationManager;
	
	public HibernateMemberDao(ValidationService validationManager) {
		super();
		this.validationManager = validationManager;
	}
	
	//ÇOK ÖNEMLİ
	//Bu fonksiyonun boolean deger dondurmesinin sebebi şu benim kullanıcım sisteme başarılı bir şekilde üye olup kayıt olabildiyse
	//eğer true dönüyor, olamadıysa mail adresi, ismi, soyisimi, parolası istenilen şartları sağlamadıysa eğer kullancı üye
	//olamayor ve ben bu kullanıcıyı veritabanıba eklemiyorum. Değer döndürmemde ki amaç Mainde veritabanına eklenmeyen kullancının 
	//login olmamasını sağlamak. Buradan dönen değerleri ben MemberManager içerisinde ki login metodunda kullanıp üye olamamış 
	//kullanıcının simülasyonda login olmasını engelleyeceğim. Bunu veritabanından ekleme yağtığım yerde yapmak zorundayım çünkü
	//elimde gerçek bir veri yok tamamen simülasyon yapıyorum. Eğer elimde gerçek veri olsaydı bu class'ın altında bir metod
	//oluşturup veritabanın içersinden kullancı şifrelerini ve mail adreslerini çeken ve kullanıcının girdiği parametrelere göre 
	//kıyaslayıp burada gönderdiğim parametrelerin veritabanında olması dahilinde true dönen , olmaması durumunda false dönen bir
	//metod tasarlardım. Bu metoddan dönen değeri de MemberManager altında ki login fonksiyonunun altında değerlendirip üye olmayan
	//kullanıcının login olmasını engellerdim. Simülasyon yaptğımız için ve elimizde gerçek bir veri olmadığı için böyle bir yönteme
	//gidildi. Gerçek bir sistemde elimizde veri varken veritabanı varken böyle bir yol izlemek çok büyük ve saçma bir hataya sebebiyet
	//verirdi çünkü ben bu yöntemle her login işleminde add metodunun altında kullanıcı ekleyerek login olmak isteyen kullanıcının veritabanında
	//olup olmadığını yokluyorum. Elimizde veri olmadığı için ve simülasyon yaptığımız için bu yöntem tercih edildi. Aşağıdaki ifler göze
	//spagetti gibi gelebilir ama bundan başka yol yok kullanıcı üye olurken 4 farklı parametreyi doğru girdiyse veritabanına eklenmeli.
	//Tek bir if'in altında yapılabilirdi ama kullanıcı hangi parametreyi yanlış giriyorsa o yönde bilgilendirme alsın istedim.
	@Override
	public boolean add(Entity member) {
		
		if(!validationManager.validateName(member.getName())) {
			System.out.println("Kullanıcı adı 2 karakterden fazla olmalı!");
			return false;
		}
		else if(!validationManager.validatePassword(member.getPassword())) {
			System.out.println("Kullanıcı şifresi en az 6 karakterden oluşmalı!");
			return false;
		}
		else if(!validationManager.validateSurname(member.getSurname())) {
			System.out.println("Kullanıcı soyadı 2 karakterden fazla olmalı!");
			return false;
		}
		else if(!validationManager.validateMailAddress(member.getMailAddress())) {
			System.out.println("Geçersiz mail adresi!");
			return false;
		}
		else if(validationManager.validateIsClicked(!member.isClicked())) {
			System.out.println("Kullanıcı e-posta doğrulama linkine tıklamadı!");
			return false;
		}
		else {
			//Yukarıdaki tüm şartlar sağlanmıyorsa eğer kullanıcı parolasını mail adresini , ismini ve soyismini 
			//sistemde istenilen şekilde girmiş demektir. Bu durumda ben veri tabanına kullanıcımı kaydetme işlerini burada yapacağım.
			
			System.out.println("Veri tabanına eklendi : "+member.getName());
			return true;
		}
		
	}
	
	//Veritabanında güncelleme işleri bu metodun altında yapılacak.
	@Override
	public void update(Entity member) {
		
		System.out.println("Veri tabanında güncellendi : "+member.getName());
	}
	
	//Veritabanından kullanıcı silme işleri bu metodun altında yapılacak.
	@Override
	public void delete(Entity member) {
		
		System.out.println("Veri tabanından silindi : "+member.getName());
	}

}
