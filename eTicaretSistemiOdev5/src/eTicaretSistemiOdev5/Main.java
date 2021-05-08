package eTicaretSistemiOdev5;

import eTicaretSistemiOdev5.business.abstracts.MemberService;
import eTicaretSistemiOdev5.business.abstracts.ValidationService;
import eTicaretSistemiOdev5.business.concretes.MemberManager;
import eTicaretSistemiOdev5.business.concretes.ValidationManager;
import eTicaretSistemiOdev5.core.concretes.GoogleAccountManagerAdapter;
import eTicaretSistemiOdev5.dataAccess.abstracts.MemberDao;
import eTicaretSistemiOdev5.dataAccess.concretes.HibernateMemberDao;
import eTicaretSistemiOdev5.entities.abstracts.Entity;
import eTicaretSistemiOdev5.entities.concretes.Member;

public class Main {

	public static void main(String[] args) {
		
		//Bu kısımda kullanıcı herhangi bir hesapla sisteme kayıt olabiliyor.
		
		//Entity tipinde yeni bir üye oluşturuldu.
		Entity memberEmre = new Member("Baran Emre","Türkmen","123456","baranemre1997@hotmail.com",true);
		
		//Kullancının üye olurken mail adresi ,ismi ve soyismi gibi şartları sağlayıp sağlamadığını
		//ValidationService tipinde bir ValidationManager class'ı ile anlıyoruz. Bu class'ı veritabanı işlerimizi yapan
		//MemberDao tipindeki HibernateMemberDao sınıfımız constructor'ında parametre olarak alıyor çünkü ValidationManager
		//sınıfı HibernateMemberDao'nun içerisinde constructor injection yöntemi ile kullanıldı.
		ValidationService validationManager = new ValidationManager();
		MemberDao hibernateMemberDao = new HibernateMemberDao(validationManager);
		
		//MemberService tipindeki MemberManager sınıfım ise parametre olarak üye sınıfını ve veritabanı işlerinin yapıldığı sınıfı
		//alıyor çünkü Member sınıfım ve HibernateMemberDao sınıfım MemberManager içerisinde constructor injeciton yöntemi ile
		//kullanıldı.
		MemberService memberService = new MemberManager(memberEmre,hibernateMemberDao);
		
		//Kullannıcı login olmak için MemberManager sınıfının login metodunu kullanıyor. Login olurken kullanıcıdan mail adresi ve
		//şifre isteniyor. Buradaki parametreleri kullanıcının login sayfasından girdiğini düşünebilirsiniz. Hatta Scanner sınıfı
		//ile yine bu kodlar üzerinden kendinizde girdi yollayabilirsiniz.
		memberService.login("baranemre1997@hotmail.com","123456");
		
		System.out.println("-------------------------------");
		
		//Bundan sonraki kısımda kullanıcı sisteme google hesabıyla kayıt oluyor. Buradaki kodların yukarıdaki kodlardan tek farkı
		//Kendi sistemizde kayıt olan kullanıcı ve login işlemini gerçekleştiren kullanıcı google mail adresini ve google şifresi
		//kullanarak sistemimize kayıt oluyor ve login işlemini gerçekleştiriyor.
		
		Entity memberEnes = new Member("Enes Malik","Türkmen","123456enes","enesmalik2006@gmail.com",true);
		MemberService memberServiceGoogle = new GoogleAccountManagerAdapter(memberEnes, hibernateMemberDao);
		memberServiceGoogle.login("enesmalik2006@gmail.com", "123456enes");
		
		
	}

}
