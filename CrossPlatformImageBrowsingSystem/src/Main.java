class JPGImage extends Main{
	public void parseFile(String fileName) {
		System.out.printf("JPG can be used ");
	}
}
class GIFImage extends Main{
	public void parseFile(String fileName) {
		System.out.printf("GIF can be used ");
	}
}
class BMPImage extends Main{
	public void parseFile(String fileName) {
		System.out.printf("BMP can be used ");
	}
}
class PNGImage extends Main{
	public void parseFile(String fileName) {
		System.out.printf("JPG can be used ");
	}
}
abstract class Image {
	protected ImageImp imp;
	public void setImageImp(ImageImp imp) {
		this.imp = imp;
	}
	public void parseFile(String fileName) {
		
	}
}
public class Main{
	public static void main(String args[]) {
		Matrix m = null;
		String n = null;
		WindowsImp wimp = new WindowsImp();
		
		PNGImage pimg = new PNGImage();
		pimg.parseFile(n);
		wimp.doPaint(m);
	}
}
interface ImageImp{
	public void doPaint(Matrix m);
}
class WindowsImp implements ImageImp{
	public void doPaint(Matrix m) {
		System.out.println("on Windows System.");
	}
}
class UnixImp implements ImageImp{
	public void doPaint(Matrix m) {
		System.out.println("on Unix System.");
	}
}
class LinuxImp implements ImageImp{
	public void doPaint(Matrix m) {
		System.out.println("on Linux System.");
	}
}
class Matrix{
	
}


