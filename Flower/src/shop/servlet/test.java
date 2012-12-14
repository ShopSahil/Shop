package shop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public test() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("here" + request.toString());
		System.out
				.println("request printed" + request.getParameter("cartSize"));

		for (int i = 0; i < new Integer(request.getParameter("cartSize")); i++) {
			Integer count= new Integer(i) +1;	 
			String statusCount="_"+count.toString(); 
System.out.println(request.getParameter("productUniqueID"+statusCount));

System.out.println(request.getParameter("recipient"+statusCount));

System.out.println(request.getParameter("phone"+statusCount));

System.out.println(request.getParameter("street"+statusCount));

System.out.println(request.getParameter("street2"+statusCount));

System.out.println(request.getParameter("city"+statusCount));

System.out.println(request.getParameter("pincode"+statusCount));

System.out.println(request.getParameter("message"+statusCount));

System.out.println(request.getParameter("no_message_box"+statusCount));

System.out.println(request.getParameter("datepicker"+statusCount));
			

System.out.println(request.getParameter("alt_delivery_date"+statusCount));



			/*
			 * 
			 * productUniqueID_${status.count} basket_id_${product.uniqueID}
			 * value="${product.uniqueID}" id="productUniqueID_${status.count}"
			 * id="recipient_${status.count}" id="phone_${status.count}
			 * id="street_${status.count} name="street2_${status.count}
			 * id="city_${status.count} id="pincode_${status.count}"
			 * id="message_${status.count} id="no_message_box_${status.count}"
			 * value="${status.count}" id="datepicker_${status.count}"
			 * value="${product.deliveryDate}
			 * id="alt_delivery_date_${status.count}" id id="cartSize"
			 * name="cartSize" value="${cartSize} "
			 */

		}

	}

}
