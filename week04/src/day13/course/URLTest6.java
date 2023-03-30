package day13.course;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class URLTest6 {

	public static void main(String[] args) {
		try {

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1171062000");
			// parse 메서드: 인자로 지정된 웹사이트에 대한 응답을 받아서 DOM 객체를 만듦
			// html의 구조 그대로 자바 객체를 만들어줌. (최상위 객체는 Document 객체)

			System.out.println(document.getElementsByTagName("title").item(0).getTextContent());
			// title 태그를 찾아서 컨텐트만 꺼내온 것

			NodeList nameList = document.getElementsByTagName("wfKor");
			// wfKor 태그를 찾아오라는 것. 찾아와서 노드 리스트 객체로 리턴.
			// 노드리스트는 ArrayList와 유사.

			Node name = nameList.item(0);
			String textContent = name.getTextContent();
			System.out.println(textContent);

		} catch (Exception e) {
			System.out.println("오류 : " + e.getMessage());
		}

	}

}
