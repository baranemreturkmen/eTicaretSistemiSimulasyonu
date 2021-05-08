package eTicaretSistemiOdev5.business.concretes;

import eTicaretSistemiOdev5.business.abstracts.MemberService;
import eTicaretSistemiOdev5.dataAccess.abstracts.MemberDao;
import eTicaretSistemiOdev5.entities.abstracts.Entity;

public class MemberManager implements MemberService{
	
	//Bu class'ın altında üyelik ile ilgili işlemleri gerçekleştirdik ve üyelikle ilgili metodları yazdık.
	//Üyelikle ilgili metodlar Entity tipinde bir Member sınıfına ve MemberDao tipinde bir veritabanı işi
	//yapan sınıfa ihtiyaç duyuyordu. Bu 2 sınıf olmadan üyelikle ilgili işlemlerin yapılması mümkün 
	//olmadığıdan Main'de MemberManager newlenirken bu 2 sınıfın zorunlu olarak istenmesini constructor
	//injection ile mümkün kıldık.
	
	//Protected özelliği atanan bir değişken veya metot, sadece bulunduğu sınıf içerisinden veya bulunduğu sınıfı 
	//extend eden sınıf içerisinden erişilebilir. Bu sınıfı extend eden GoogleAccountManagerAdapter sınıfı başka 
	//bir paketin altında olduğu için bu parametreleri protected yapmak zorunda kaldık.
	protected Entity member;
	protected MemberDao hibernateMemberDao;
	
	public MemberManager(Entity member, MemberDao hibernateMemberDao) {
		super();
		this.member = member;
		this.hibernateMemberDao = hibernateMemberDao;
	}
	
	//ÇOK ÖNEMLİ
	//Login işlemlerini login metodumla yapıyorum. En içteki lojiklerle(if else if else) kullancının login olurken 
	//doğru şifre ve mail adresi girip girmediğini kontrol ediyorum. Kullancı doğru mail adresini ve şifreyi 
	//girdiğinde kullancı başarılı bir şekilde login işlemini gerçekleştirmiş oluyor. Kullanıcının veritabanına 
	//eklenmeden login olamamasını sağlamak adına dıştaki if'de ise kullancının veritabanına eklenmesi dahilinde
	//kullanıcının doğru bir şekilde login olup olmadığının testinin yapılmasını sağladım. Yani kullancı veritabanına
	//eklenmediyse üye olmadıysa girilen mail ve şifrenin doğruluğunu test etmeden böyle bir kullanıcı yok sistemde
	//kayıtlı değil uyarısı veriyorum. Bu durumu hibernateMemberDao.add metodunun altında yapmamın sebebi şu hibernateMemberDao.add
	//metodunun altında kullanıcı başarılı bir şekilde kayıt olduysa true , olamadıysa false dönen işlemler yapmıştım.
	//Bu işlemleri add metodunun altında yapmamın sebebi elimizde bir veritabanı olmaması ve burada tasarlanan sistemin
	//bir simülasyon olması eğer elimizde bir veri olsaydı HibernateMemberDao'da veritabanın içersinden kullancı şifrelerini
	//ve mail adreslerini çeken ve burada gönderdiğim parametrelere göre kıyaslayıp burada gönderdiğim parametrelerin 
	//veritabanında olması dahilinde true dönen , olmaması durumunda false dönüp en dıştakıi else'deki uyarıyı veren 
	//bir metod tasarlayacaktım.(hibernateMemberDao.add(member) yerine benimyazdigimmetod(member) olacaktı.) 
	//Simülasyon yapmamımız ve elimde veritabanı olmaması böyle bir durumu ortaya çıkardı. Elimizde
	//gerçek bir veri tabanı olsaydı eğer bu yöntem yanlış olacaktı çünkü ben her login işleminde yanlışlıkla ve veritabanına
	//kullanıcıyı eklemiş olacaktım. Bu da gerçek bir sistem için çok saçma ve çok büyük bir hata.
	@Override
	public void login(String mailAddress,String password) {
		// TODO Auto-generated method stub
	if(hibernateMemberDao.add(member)) {
		if(password.equals(member.getPassword()) && mailAddress.equals(member.getMailAddress())) {
			System.out.println("Kullanıcı başarılı bir şekilde login oldu.");
		}
		else if(!password.equals(member.getPassword()) && !mailAddress.equals(member.getMailAddress())) {
			System.out.println("Login işlemi sırasında mail adresi ve şifre yanlış girildi!");
		}
		else if(!password.equals(member.getPassword())){
			System.out.println("Login işlemi sırasında şifre yanlış girildi!");
		}
		else if(!mailAddress.equals(member.getMailAddress())){
			System.out.println("Login işlemi sırasında mail adresi yanlış girildi!");
		}
	}
	else {
		System.out.println("Sistemde kayıtlı böyle bir kullanıcı yok!");
	}
	
	}
	
	//Kullanıcı şifresini değiştirmek isterse eğer eski şifresini girmeli. Girdiği değer ile 
	//güncel şifresi uyumlu ise şifre değiştime işlemeni gerçekleştirmek için veritabanında güncelleme işlemlerini
	//yapan metodu çağırıyorum bu metodun altında. Parametre olarak bu işlemi gerçekleştirmek isteyen üyenin objesini
	//yolluyorum.
	@Override
	public void changePassword(String password) {
		if(password.equals(member.getPassword())) {
			hibernateMemberDao.update(member);
		}
		
	}
	
	//Kullanıcı mail adresini değiştirmek isterse eğer eski mail adresini girmeli. Girdiği değer ile 
	//güncel mail adresi uyumlu ise mail adresi değiştime işlemeni gerçekleştirmek için veritabanında 
	//güncelleme işlemlerini yapan metodu çağırıyorum bu metodun altında. Parametre olarak bu işlemi 
	//gerçekleştirmek isteyen üyenin objesini yolluyorum.
	@Override
	public void changeMailAddress(String mailAddress) {
		if(mailAddress.equals(member.getMailAddress())) {
			hibernateMemberDao.update(member);
		}
		
	}

}
