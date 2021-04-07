import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtil {
	static Object getBean() {
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
			NodeList nList = doc.getElementsByTagName("className");
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
}