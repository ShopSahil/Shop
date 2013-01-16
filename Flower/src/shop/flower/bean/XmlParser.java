package shop.flower.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import shop.dao.MenuPage;
import shop.dao.SubMenuPage;
 
public class XmlParser {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static List<String> menuLinkList;
	private static List<MenuPage> menuPageList;
	private static List<SubMenuPage> subMenuPageList;
	

	public List<String> getMenuLinkList() {
		if (menuLinkList == null || menuLinkList.isEmpty()){
			
		this.getAllMenuList("c:\\MenuLinks.xml");
		}
		return menuLinkList;
	}

	public void setMenuLinkList(List<String> menuLinkList) {
		this.menuLinkList = menuLinkList;
	}

	public List<MenuPage> getMenuPageList() {
		return menuPageList;
	}

	public void setMenuPageList(List<MenuPage> menuPageList) {
		this.menuPageList = menuPageList;
	}
	
	public List<SubMenuPage> getSubMenuPageList() {
		return subMenuPageList;
	}

	public void setSubMenuPageList(List<SubMenuPage> subMenuPageList) {
		this.subMenuPageList = subMenuPageList;
	}
 
    public void getAllMenuList(String fileName) {
        try {
        	
        	menuLinkList = new ArrayList<String>();
        	menuPageList = new ArrayList<MenuPage>();
        	String menuName = "";
        	String menuValue = "";
        	
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File(fileName);
            
            if (file.exists()) {
                Document doc = db.parse(file);
                Element docEle = doc.getDocumentElement();
 
                // Print root element of the document
     
                NodeList menuList = docEle.getElementsByTagName("MenuLink");
 
                // Print total MenuLink elements in document
     
                if (menuList != null && menuList.getLength() > 0) {
                    for (int i = 0; i < menuList.getLength(); i++) {
 
                    	MenuPage menuPage = new MenuPage();
                        Node node = menuList.item(i);
 
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
 
                            Element e = (Element) node;
                            NodeList nodeList = e.getElementsByTagName("MenuName");
                            menuName = nodeList.item(0).getChildNodes().item(0)
                                    .getNodeValue();
                            System.out.println("MenuName: "
                                    + menuName);
                            menuLinkList.add(nodeList.item(0).getChildNodes().item(0)
                                    .getNodeValue());
                            System.out.println("No of menu items===="+menuLinkList.size());
                            
                            nodeList = e.getElementsByTagName("MenuValue");
                            menuValue = nodeList.item(0).getChildNodes().item(0)
                                    .getNodeValue();
                            System.out.println("MenuValue: "
                                    + menuValue);
 
                            nodeList = e.getElementsByTagName("SubMenuLink");
            
            
                            if (nodeList != null && nodeList.getLength() > 0) {
                            	
                            	subMenuPageList = new ArrayList<SubMenuPage>();
                            	NodeList submenuList = e.getElementsByTagName("SubMenuLink");
                            	
                            	 System.out.println("Total Sub Menu=="+submenuList.getLength());
                            	 
                                for (int j = 0; j < submenuList.getLength(); j++) {
             
                                	SubMenuPage subMenuPage = new SubMenuPage();
                                    Node subnode = submenuList.item(j);
             
                                    if (subnode.getNodeType() == Node.ELEMENT_NODE) {
             
                                        System.out.println("=====================");
             
                                        Element e1 = (Element) subnode;
                                        NodeList subnodeList = e1.getElementsByTagName("Name");
                                        System.out.println("Name: "
                                                + subnodeList.item(0).getChildNodes().item(0)
                                                        .getNodeValue());
                                        
                                        subMenuPage.setSubLinkName(subnodeList.item(0).getChildNodes().item(0)
                                                .getNodeValue());
             
                                        subnodeList = e1.getElementsByTagName("Value");
                                        
                                        subMenuPage.setSubLinkValue(subnodeList.item(0).getChildNodes().item(0)
                                                .getNodeValue());
                                        
                                        subMenuPageList.add(subMenuPage);
                                        
                                    }
                                }
                                menuPage.setSubLink(1);
                                menuPage.setMenuName(menuName);
                                menuPage.setSubMenuPageList(subMenuPageList);
                                menuPageList.add(menuPage);
                            }else {
                            	
                                menuPage.setSubLink(-1);
                                menuPage.setMenuName(menuName);
                                menuPage.setSubMenuPageList(null);
                                menuPageList.add(menuPage);
                            }
                        }
                    }
                } else {
                    System.exit(1);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}