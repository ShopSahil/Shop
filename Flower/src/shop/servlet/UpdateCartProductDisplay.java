package shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.POJO.CartPojo;
import shop.dao.AddOnDAO;

/**
 * Servlet implementation class UpdateCartDisplay
 */
public class UpdateCartProductDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartProductDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	HttpSession session= request.getSession();	
	HashMap<Integer,CartPojo> completeCart=(HashMap<Integer, CartPojo>) session.getAttribute("completeCart");

	Integer removeProduct= new Integer(request.getParameter("RowID"));
	CartPojo cartPojo=new CartPojo();
	cartPojo=completeCart.get(removeProduct);
	Integer totalCartCost= (Integer) session.getAttribute("totalCartCost");	
	System.out.println(request.getParameter("addOnId").toString());
	Integer addOnID= new Integer(request.getParameter("addOnId").toString());
	
	if(request.getParameter("action").equalsIgnoreCase("add")){
			
		Integer productCost=new Integer(request.getParameter("totalRowCost").toString());
		cartPojo.setProductPrice(productCost);
		Integer addOnPrice = new Integer(request.getParameter("addonPrice").toString());
		totalCartCost +=addOnPrice;
	/*	Integer productSaving = cartPojo.getTotalSaving();
		Integer totalCartSaving= (Integer) session.getAttribute("totalCartSaving");
		totalCartSaving += productSaving;
	*/	ArrayList<AddOnDAO> newAddOns=new ArrayList<AddOnDAO>();
		
		ArrayList<AddOnDAO> addOns =(ArrayList<AddOnDAO>)cartPojo.getAddOnDAO();	
		Iterator<AddOnDAO>  itr = addOns.iterator();
		while(itr.hasNext()){
			AddOnDAO addOn= (AddOnDAO)itr.next();
			if(addOn.getProductAddOnId() == addOnID){
			addOn.setCartSelectedFlag(1);}
			newAddOns.add(addOn);
		}
		cartPojo.setAddOnDAO(newAddOns);
		cartPojo.setTotalCost(productCost);
		completeCart.put(removeProduct, cartPojo);
		session.setAttribute("completeCart", completeCart);	
		session.setAttribute("totalCartCost", totalCartCost);
	/*	session.setAttribute("totalCartSaving", totalCartSaving);
	*/
	
	}
	else if(request.getParameter("action").equalsIgnoreCase("delete")){
		

		Integer productCost=new Integer(request.getParameter("totalRowCost").toString());
		cartPojo.setProductPrice(productCost);
			
		Integer addOnPrice = new Integer(request.getParameter("addonPrice").toString());
		totalCartCost -=addOnPrice;
	/*	Integer productSaving = cartPojo.getTotalSaving();
		Integer totalCartSaving= (Integer) session.getAttribute("totalCartSaving");
		totalCartSaving -= productSaving;
	*/	ArrayList<AddOnDAO> newAddOns=new ArrayList<AddOnDAO>();
		
		ArrayList<AddOnDAO> addOns =(ArrayList<AddOnDAO>)cartPojo.getAddOnDAO();	
		Iterator<AddOnDAO>  itr = addOns.iterator();
		while(itr.hasNext()){
			AddOnDAO addOn= (AddOnDAO)itr.next();
			if(addOn.getProductAddOnId() == addOnID){
			addOn.setCartSelectedFlag(0);}
			newAddOns.add(addOn);
		}
		cartPojo.setAddOnDAO(newAddOns);
		cartPojo.setTotalCost(productCost);
		completeCart.put(removeProduct, cartPojo);
		session.setAttribute("completeCart", completeCart);	
		
			
		session.setAttribute("totalCartCost", totalCartCost);
	/*	session.setAttribute("totalCartSaving", totalCartSaving);
	*/
	
		}
	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
		out.println("{\"success\":");
		out.println("\"true \", ");
	out.println("\"totalCartCost\":");
	out.println(totalCartCost+"}");
	/*out.println("\"totalCartSaving\":");
	out.println(totalCartSaving+"}");
*/

	}
	


}
