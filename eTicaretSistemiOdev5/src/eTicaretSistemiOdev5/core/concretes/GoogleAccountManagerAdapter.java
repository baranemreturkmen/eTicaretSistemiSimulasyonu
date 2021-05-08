package eTicaretSistemiOdev5.core.concretes;

import eTicaretSistemiOdev5.GoogleAccount.GoogleAccountManager;
import eTicaretSistemiOdev5.business.concretes.MemberManager;
import eTicaretSistemiOdev5.dataAccess.abstracts.MemberDao;
import eTicaretSistemiOdev5.entities.abstracts.Entity;

public class GoogleAccountManagerAdapter extends MemberManager{
	
	//Bu sınıf sayesinde dışarıdan sistemime eklemek zorunda olduğum, içerisinde değişiklik yaparak müdahale de
	//bulunamadığım GoogleAccountManager sınıfını sistemime entegre ediyorum.
	
	//GoogleAccountManager googleAccountManager;
	//Kodları yazarken yukarıda ki yoruma aldığım hatalı kullanımı yaptım. Bu hatalı bir kullanım senin burada bunu her türlü newlemen gerekir. 
	//Newlemeden kullanırsan null point exception hatası alırsın. Bu hatayı şundan dolayı alırsın aslında 
	//Sen bir GoogleAccountManager tipinde googleAccountManager objesi oluşturdun ama referans ataması yapmadın 
	//Aşağıdaki kodlarda hata yaşamanın sebebi bu class'ın altındaki login metodunun içersinde googleAccountManager.login(mailAddress, password);
	//dediğinde olmayan boş bir referans üzerinden gitmeye çalışman, null bir referans üzerinden ilerlemeye çalışman.
	//Şimdi bu hatayı aldıktan sonra GoogleAccountManager yerine yukarıda interface olsaydı constructor injection yaparken 
	//nasıl çalışıyordu gibisinden düşünebilirsin iyide orada da injection yaparken interface'in tuttuğu 
	//referansı Mainde vs. bir yerde newliyorsun. Mesela HibernateMemberDao class'ının altında ValidationService
	//tipindeki ValidationManager Main'de newleniyor. İstersen xml dosyasında newle, istersen Mainde istersen başka bir katmanda
	//bir class ne tipte olursa olsun yani isterse referansını bir interface tutsun isterse de kendisi isterse başka bir class
	//newlemezsen o class'ın referansını oluşturmazsın. Tipi ne olursa olsun(interface class vs.) boş referans tutar boş referans 
	//üzerinden gidersen null point exception hatasını yersin.
	
	//ÇOK ÖNEMLİ
	//GoogleAccountManager sınıfı dışarıdan kendi sistemime entegre ettiğim bir sınıf olduğu için bu sınıfın altında newlemekten 
	//çekinmiyorum. Normalde başka bir sınıfın altında newleme işlemi yapmak o sınıfı newlediğin sınıfa bağımlı yapmaktır. Ama ben
	//Ben sistemime dışarıdan birşey entegre ediyorsam o entegre ettiğim şeye zaten bağımlıyımdır. Bu durumda aşağıdaki newleme işi 
	//çok göze batmıyor.
	GoogleAccountManager googleAccountManager = new GoogleAccountManager();
	
	//GoogleAccountManagerAdapter sınıfım MemberManager ile aynı fonksiyonlara sahip olacağı için MemberManager sınıfını extend etti
	//Dolayısıyla MemberManager'da olan constructor yani MemberManager'ın constructor injection sayesinde sahip olduğu bağımlılıklar
	//burada da olmalı.
	public GoogleAccountManagerAdapter(Entity member, MemberDao hibernateMemberDao) {
		super(member, hibernateMemberDao);
		
	}
	
	//MemberManager'da ki login fonksiyonunu override etti sadece çünkü buradaki login işlemi farklı. Ben burada 
	//google hesabım ile login olduğum için sistem hem veritabanın da hem GoogleAccountManager tarafında böyle
	//bir hesabın olup olmadığını sorgulamalı. Bu sorgulama işlemi veritabanı tarafında hibernateMemberDao.add(member)
	//ile yapılırken(Bu sorgulama işleminin neden böyle yapıldığı HibernateManagerDao add ve MemberManager login metodu
	//üzerinde ayrıntılı bir açıklama ile yapıldı.) google tarafında böyle bir hesabın olup olmadığı googleAccountManager.login(mailAddress, password);
	//ile yapılıyor. 
	@Override
	public void login(String mailAddress, String password) {
		// TODO Auto-generated method stub
		
		if(hibernateMemberDao.add(member)) {
			googleAccountManager.login(mailAddress, password);
		}
		else {
			System.out.println("Sistemde kayıtlı böyle bir google hesabı yok!");
		}
		
		
	}	
	
	
	

}
