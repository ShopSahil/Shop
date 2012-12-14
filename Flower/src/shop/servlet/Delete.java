package shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.POJO.CartPojo;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
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
	Integer removeProduct= new Integer(request.getParameter("id"));
	CartPojo cartPojo=new CartPojo();
	cartPojo=completeCart.get(removeProduct);
	Integer productCost=cartPojo.getTotalCost();
	Integer totalCartCost= (Integer) session.getAttribute("totalCartCost");	
	totalCartCost -=productCost;
	Integer productSaving=cartPojo.getTotalSaving();
	Integer totalCartSaving= (Integer) session.getAttribute("totalCartSaving");
	totalCartSaving -= productSaving;
	completeCart.remove(removeProduct);
	session.setAttribute("completeCart", completeCart);
	boolean blnExists = completeCart.containsKey(removeProduct);

	session.setAttribute("totalCartCost",totalCartCost);
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	if(blnExists){
		out.println("{\"error\":");
		
		out.println("\"true \"}");}
	
		else{
		out.println("{\"success\":");
		out.println("\"true \", ");
	session.setAttribute("totalCartCost", totalCartCost);
	session.setAttribute("totalCartSaving", totalCartSaving);
	out.println("\"totalCartCost\":");
	out.println(totalCartCost+" ,");
	out.println("\"totalCartSaving\":");
	out.println(totalCartSaving+"}");
		}
	}
	
    /*function navigate(result){  
        if(result.responseText){  
                    document.location = "menu.xml";  
                }else{  
                    alert("Falscher Benutzername oder Passwort eingegeben!");  
                }  
        }  */


	
	}


