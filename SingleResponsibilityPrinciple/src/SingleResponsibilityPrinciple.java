class DBUtil {
	public void getConnection(){
		//Connection
		System.out.println("Connection successful!");
	}
}
class UserDAO{
	private DBUtil db = new DBUtil();
	public boolean findUser(String userName,String userPassword){

		db.getConnection();
		if(userName == "admin" && userPassword == "123") {
		System.out.println("Database connection successful!");
		System.out.println(userName +" login successfully!");
		return true;
		}
		else return false;
	}
}
class LoginForm{
	private UserDAO dao = new UserDAO();
	public String username="admin";
	public String userpassword="123";
	public void init() {
		System.out.println("Initialization successful!");
	}
	public void display() {
		System.out.println("Display successful!");
	}
	public void validate() {
		dao.findUser(username,userpassword);
		System.out.println("Validate successful!");
	}
}
public class SingleResponsibilityPrinciple {
	public static void main(String[] args)
	{
		LoginForm loginform = new LoginForm();
		loginform.init();
		loginform.display();
		loginform.validate();
	}
}
