package eTicaretSistemiOdev5.entities.concretes;

import eTicaretSistemiOdev5.entities.abstracts.Entity;

public class Member implements Entity{
	
	//Sisteme üye olacak kullanıcının özelliklerini ve özelliklerin getterlarını içerkmektedir.
	//Entity interface'ini implemente edip ileride doğacak olan bağımlılık problemlerinin önüne 
	//geçtik. Member class'ının kullanıldığı tüm classlarda Member sınıfının referansını Entity 
	//interface'i tutmakta. Bu sayede ileride Entity sınıfını implemente eden farklı classlar 
	//kodlarımızda bulunan tüm classlarda rahatlıkla kullanılabilecek ve kod değişikliğine gidilmeyecek
	//Yapılması gereken tek değişiklik Main'de Member class'ını newlemek yerine Entity interface'ini
	//implemente eden farklı bir sınıfı newlemek olacak. Farklı bir Member class'ıdan kast edilen 
	//şu anki Member class'ım ile aynı özelliklere sahip bir class. Peki bunu neden yapıyoruz 
	//aynı özelliklere sahipse eğer benim yeni Member class'ım ? Şundan dolayı yeni Member class'ı 
	//kendi içinde ekstra özelliklere veya özelliklerden bağımsız metodlara sahip olabilir.
	//Ortak metodları Entity'i implemente ederek override etmek zorunda kalıcak. Ortak metodları
	//unutmak gibi bir durum olmayacak ve ben interface'imle ortak metodları gruplamış olacağım.
	//Her yeni bir Member class'ı türediğinde Entity'i implemente ederek ortak metodları kullanması
	//kaçınılmaz olacak ve dahada önemlisi tek değişiklik Main'de gerçekleşecek. Diğer classlarda
	//Entity tipinde kullanıldığı için Member classlarım ve yeni Member class'ımda Entity'i implemente
	//ederek Entity tipinde olacağından diğer classlarda değişikliğe gidilmeyecek sadece Mainde eski
	//Member class'ını newlemek yerine yeni Member class'ı newlenecek.
	
	//Burada isClicked özelliğine dikkat çekmek istiyorum. Çünkü kullanıcı doğrulama linkine tıkladığı
	//zaman üye olma durumunun gerçekleştiğini söyleyen bir şartımız var. Şuan elimizde gerçek bir
	//veri ve kullanıcı aksiyonu olmadığı için kullanıcının doğrulama linkine tıklama durumunu burada
	//bir özellik olarak verdim. Mainde yapacağımız çeşitli senaryolara göre bu özelliğe true
	//değeri gönderdiğimizde kullanıcının linke tıkladığını , false değeri gönderdiğimizde linke tıklamadığını
	//düşünüp buna göre diğer classlarda kodlarımı tasarladım.
	
	private String name;
	private String surname;
	private String password;
	private String mailAddress;
	private boolean isClicked;
	
	public Member(String name, String surname, String password, String mailAddress, boolean isClicked) {
		
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.mailAddress = mailAddress;
		this.isClicked = isClicked;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getPassword() {
		return password;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public boolean isClicked() {
		return isClicked;
	}

	

}
