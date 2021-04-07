
public class Client {
	public static void main(String args[]) {
		try {
			Log log;
			LogFactory lf;
			lf = (LogFactory)XMLUtil.getBean();
			log = lf.createLog();
			log.writeLog();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
interface Log{
	public void writeLog();
}
class FileLog implements Log{
	public void writeLog() {
		System.out.println("write filelog...");
	}
}
class DatabaseLog implements Log{
	public void writeLog() {
		System.out.println("write databaselog...");
	}
}

interface LogFactory{
	public Log createLog();
}
class FileLogFactory implements LogFactory{
	public Log createLog() {
		System.out.println("create log in filelogfactory");
		return new FileLog();
	}
}
class DatabaseLogFactory implements LogFactory{
	public Log createLog() {
		System.out.println("create log in databaselogfactory");
		return new DatabaseLog();
	}
}