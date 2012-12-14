package shop.servlet;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.client.sei.SEIStub;

import shop.POJO.CartPojo;
import shop.dao.AddOnDAO;
import shop.dao.ProductDAO;
import shop.database.GetAddons;
import shop.database.GetProduct;
import shop.flower.bean.Cart;
import shop.util.Utils;

/**
 * Servlet implementation class Cart
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession session= request.getSession();	
		HashMap<Integer,CartPojo> completeCart= new HashMap<Integer, CartPojo>();
		System.out.println("url--------"+request.getRequestURI());
		Integer counter;
		
		if(session.getAttribute("counter")!=null){
			counter=new Integer((Integer) session.getAttribute("counter"));
			counter++;	
			session.setAttribute("counter", counter);
			
		}else
		{
		counter = 1;	
		session.setAttribute("counter", counter);
		}
		
	
	
	
	
	
	String addOnID=Utils.isEmptyThenReturn(request.getParameter("addOnProdId"),"");
	int prodID=new Integer(request.getParameter("productID").trim());
	String prodName= Utils.isEmptyThenReturn(request.getParameter("productName"),""); 
	Integer priceAfterDiscount = new Integer(request.getParameter("price_original").trim());	
	Integer priceAfterAdd= new Integer(request.getParameter("priceAfterAdd").trim());
	int quantity =  new Integer(request.getParameter("quantity"));
	String Date = request.getParameter("datepicker");
	String productImagePath= request.getParameter("productImage");
	int priceWithoutDiscount=new Integer(request.getParameter("productwithoutdiscount").trim());
	int productTotalSaving= new Integer(request.getParameter("productTotalSaving").trim());
	
	GetAddons getAddOn= new GetAddons();
	ArrayList<AddOnDAO> addOns= (ArrayList<AddOnDAO>) getAddOn.getAddOnProdandAddIDCart(prodID, addOnID);
	CartPojo cartProd= new CartPojo();
	cartProd.setDeliveryDate(Date);
	cartProd.setProductID(prodID);
	cartProd.setProductName(prodName);
	cartProd.setProductImage(productImagePath);
	cartProd.setProductQuantity(quantity);
	cartProd.setAddOnDAO(addOns);
	cartProd.setTotalCost(priceAfterAdd);
	cartProd.setTotalSaving(productTotalSaving);
	
	
	int totalCartCost=0;
	int totalChargesAfterDelivery=0;
	int totalCartSaving=0;
	int totalDeliveryCharges=0;
	
	
			
	if(session.getAttribute("completeCart")!=null){
		
		if(request.getParameter("action").equalsIgnoreCase("add")){
		completeCart=(HashMap<Integer, CartPojo>) session.getAttribute("completeCart");
		cartProd.setUniqueID(counter);

		completeCart.put(cartProd.getUniqueID(), cartProd);
		}else{
		String prodToEdit=request.getParameter("prodCartNumber");
		cartProd.setUniqueID(new Integer(prodToEdit.trim()));
		completeCart=(HashMap<Integer, CartPojo>) session.getAttribute("completeCart");
		
		completeCart.put(new Integer(prodToEdit),cartProd);
			
		}
	
	for (CartPojo prod : completeCart.values()){
		totalCartCost+=prod.getTotalCost();
		totalCartSaving+=prod.getTotalSaving();
		}
	session.setAttribute("totalCartCost",totalCartCost);
	session.setAttribute("totalCartSaving", totalCartSaving);
	session.setAttribute("completeCart",completeCart);
	session.setAttribute("cartSize", completeCart.size() );
	}
	
		else
		{
			completeCart.put(cartProd.getUniqueID(), cartProd);
			totalCartCost =cartProd.getTotalCost();
			totalCartSaving=cartProd.getTotalSaving();
			session.setAttribute("totalCartCost",totalCartCost);
			session.setAttribute("totalCartSaving", totalCartSaving);
			session.setAttribute("completeCart",completeCart);
			session.setAttribute("cartSize", completeCart.size() );
		}


	
	
	
	
	
	
	
	
	/*List<String> prodID=Utils.delimitedStringToList(addOnID,"|");
	String [] prodIdString = prodID.toArray(new String[prodID.size()]);
	int prodId=new Integer(prodIdString[1]);
	*/	
	
	
	
	/*if(session.getAttribute("cartProds") !=null){
		
		prodList=(List<CartPojo>)session.getAttribute("cartProds");
	prodList.add(cartProd);
	*/
	/*Totalsum=(Integer)(session.getAttribute("Totalsum")) + new Integer (prod.getPriceAfterAdd());
	session.setAttribute("Totalsum", Totalsum);
	}
	else{
		prodList.add(prod);
		Totalsum +=new Integer (prod.getPriceAfterAdd());
		}	
	session.setAttribute("cartProds",prodList);
	session.setAttribute("Totalsum", Totalsum);
	*/
	
	
	System.out.println("session"+ request.getRequestURI()+"session ID"+session.getId());
	RequestDispatcher rd= request.getRequestDispatcher("controller");
	rd.forward(request,response);
	

	}

}
	
	


