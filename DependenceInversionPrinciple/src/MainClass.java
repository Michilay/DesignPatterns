import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

abstract class AbstractSource{
	public void display() {
	}
}
abstract class AbstractTransformer{
	public void display() {
	}
}
class DatabaseSource extends AbstractSource{
	public void display() {
		System.out.println("This is DatabaseSource.");
	}
}
class TextSource extends AbstractSource{
	public void display() {
		System.out.println("This is TextSource.");
	}
}
class XMLTransformer extends AbstractTransformer{
	public void display() {
		System.out.println("This is XMLTransformer.");
	}
}
class XLSTransformer extends AbstractTransformer{
	public void display() {
		System.out.println("This is XLSTransformer.");
	}
}

public class MainClass {
	static Object getBeans(String className) {
		try{
			//XML�ļ���ȡ��������
			//����һ��������
			DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
			//ͨ��������newһ��DocumentBuilder����
			DocumentBuilder db = df.newDocumentBuilder();
			//��XML�ļ���Ϊfile�����ȡ��������
			File file = new File("src/config.xml");
			//����Document���󣬲�ͨ��DocumentBuilder�е�parse������XML�ļ����������͵��½���Document������
			Document doc;
			doc = db.parse(file);
			
			//��ȡXML�ļ��д������Ϣ
			//����NodeList�� ��ͨ��XML�ļ��еı�ǩ���ֶ�ȡ�����ݴ�ŵ�nList��
			NodeList nList = doc.getElementsByTagName(className);
			//��ȡֵ
			Node node = nList.item(0).getFirstChild();
			//ֵת��Ϊ�ַ���
			String sourceName = node.getNodeValue();
			
			//java�������
			//����������
			Class c = Class.forName(sourceName);
			//�����¶���
			Object obj = c.newInstance();
			//������
			return obj;
		}
			//û�ҵ���ʱ���׳��쳣
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		//��������
		AbstractSource source = (AbstractSource)MainClass.getBeans("sourceName");
		XMLTransformer transformer= (XMLTransformer)MainClass.getBeans("transformerName");
		//���÷���
		source.display();
		transformer.display();
		
	}
}
