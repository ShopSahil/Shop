package shop.dao;

import java.util.List;

import shop.dao.SubMenuPage;

public class MenuPage {

	private int subLink;
	private String menuName;
	private List<SubMenuPage> subMenuPageList;
	
	public int getSubLink() {
		return subLink;
	}
	public void setSubLink(int subLink) {
		this.subLink = subLink;
	}
	public List<SubMenuPage> getSubMenuPageList() {
		return subMenuPageList;
	}
	public void setSubMenuPageList(List<SubMenuPage> subMenuPageList) {
		this.subMenuPageList = subMenuPageList;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
}
