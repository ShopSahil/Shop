<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Gift Message</title>
 <meta http-equiv="expires" content="now">
 <meta http-equiv="pragma" content="no-cache">
 <meta http-equiv="Cache-Control" content="no-cache">

</head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link type="text/css" href="css/jquery-ui-1.8.23.1.custom.css"
	rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.23.custom.min.js"></script>
<link type="text/css" href="css/menu.css" rel="stylesheet" />
<script type="text/javascript" src="js/menu.js"></script>	
	

<body>




	<style>

/* body {

    background: url("images/pagebackground.jpg") repeat-x scroll center top #F7F7F7 !important;
    font-family: Arial,Helvetica,sans-serif,"Lucida Sans Unicode";
    font-size: 12px;
    margin: 0 auto;
    width: 950px;
    font-weight: normal;
	
}

 */
body {
	width: 950px;
	font-weight: normal;
	font-size: 12px;
	margin: 0 auto;
	font-family: Arial;
	background: url(images/pagebackground.jpg) repeat-x #f7f7f7 top center
		!important;
	margin-top: 0px;
}

#main {
	background: none repeat scroll 0 0 #F3F4F5;
	border: 1px solid #E1E1E1;
	float: left;
	height: auto;
	margin-bottom: 10px;
	margin-left: 5px;
	padding: 10px;
	width: 910px;
}

#title1 {
	margin-top: 1px;
	position: relative;
	background: none repeat scroll 0 0 #868483;
	border: 1px solid #AAAAAA;
	color: #000000;
	font-weight: bold;
	text-align: center;
	border: medium none !important;
}

.titlelink {
	padding-left: 2.2em;
	display: block;
	font-size: 1.2em;
	line-height: 1.6;
	background: none repeat scroll 0 0 #868483;
	border-bottom: 1px solid #E1E1E1;
	color: #FFFFFF !important;
}

#data {
	background: url("images/template/ui-bg.png") repeat-x scroll 50% 50%
		#FFFFFF;
	border: 1px solid #AAAAAA;
	color: #222222;
	border-top: 0 none;
	margin-bottom: 2px;
	margin-top: -2px;
	overflow: auto;
	padding: 1em 2.2em;
	position: relative;
	top: 1px;
}

.logregButton{
background: #aac631;
color : #000;
cursor: pointer;
border: #aac631 1px solid;
}

.greenButtonEnabled{

padding: 5px;
font-size: 10px;
font-family: verdana, arial;
font-weight: bold;
margin-top: 10px;
background: #aac631;
color : #000;
cursor: pointer;
border: #aac631 1px solid;"
}


</style>
	<script type="text/javascript">


	function copy(status,productID){
		alert(status+productID);
		alert($('#cartSize').val());
		var current_recipient ='#recipient_'+status;
		var current_phone ='#phone_'+status;
		var current_street ='#street_'+status;
		var current_street2 ='#street2_'+status;
		var current_city ='#city_'+status;
		var current_pincode ='#pincode_'+status;
		
		$(current_recipient).val($("#recipient_1").val());
		$(current_phone).val($("#phone_1").val());
		$(current_street).val($("#street_1").val());
		$(current_street2).val($("#street2_1").val());
		$(current_city).val($("#city_1").val());
		$(current_pincode).val($("#pincode_1").val());

		return false;




	}

	function hideshow(which){
	if (!document.getElementById)
	return

	if (which.style.display == "block")
	{
		which.style.display="none";
		return;
	}

	if (which.style.display == "none")
	{
		which.style.display="block";
		return;
	}

	}

	function check_all_messages ()
	{
		var	div_count = 1;

		while (1)
		{
			var element = document.getElementById('message_' + div_count);

			if (!element)
			{
				break;
			}

			var element2 = document.getElementById('no_message_box_' + div_count);

			if (!element2)
			{
				break;
			}

			if (!element2.checked)
			{
				/* No message isn't checked, so we need the message to be defined */

				if (element.value == '')
				{
					/* No message */

					return false;
				}
	 
			}

			div_count++;
		}

		return true;
	}

	function message_toggle (which)
	{
		var element = document.getElementById('message_' + which);

		if (!element)
		{
			return 0;
		}

		var element2 = document.getElementById('no_message_box_' + which);

		if (!element2)
		{
			return 0;
		}

		if (element2.checked)
		{
			element.style.display = "none";
		}
		else
		{
			element.style.display = "block";
		}
	}

	function showdoc(which)
	{
		var element = document.getElementById(which);

		if (!element)
			return 0;

		element.style.display = "block";

		return 1;
	}

	var which_lookup;
	$(function() {
	
		
		for (  i=0; i<$('#cartSize').val();i++){
			var temp=parseInt(i) + 1;  		

			$('#datepicker_'+temp).datepicker({
							inline: true,	
							dateFormat: 'dd MM yy',
							numberOfMonths: 2,					
								
							maxDate: '+1M +10D',				
							altField: "#alt_delivery_date_"+temp,altFormat: "yy/mm/dd",
							//Set first selectable date based on cutoff and lead date

							//Month starts at 0

							minDate: "+2D"					
						});			
			
			
		}
		
	});



</script>

	<div id="main">
	<form name="CartMessage" action="test.do" method="get">
		<div id="title1">

			<span class="titlelink">Delivery Details</span>


		</div>
		<div id="data">
			<span style="padding-top: 8px; margin-top: 4px;"></span>
			<table width="100%" cellpadding="2" cellspacing="0" border="0">

				<!-- repeat loop from here -->

				<c:forEach var='products' items="${completeCart}" varStatus="status">
					<input type="hidden" class="status" value="${status.count}"  /> 
					<c:set var="product" value="${products.value}" />
					<tr>
						<td class="MultiShippingAddressHeaderLeft" height="15"
							bgcolor="#DDDDDD" align="left" valign="top" width="25%"><b>Item</b></td>
						<td class="MultiShippingAddressHeaderRight" height="15"
							bgcolor="#DDDDDD" align="left" valign="top" width="48%"><b>Deliver
								Item To:</b></td>
						<td class="MultiShippingAddressHeaderRight" height="15"
							bgcolor="#DDDDDD" align="left" valign="top" width="27%"><b>Gift
								Card Message</b></td>
					</tr>
					<tr>
						<td valign="top"><img src="${product.productImage}"
							width="100" /><br />${product.productName}<br />Quantity
							${product.productQuantity}<br /> <a
							href="${pageContext.request.contextPath}/CartDisplay.jsp">Edit</a>
							<b>Add ons</b> <c:if test="${not empty product.addOnDAO}">
								<c:forEach var="addOn" items="${product.addOnDAO}">
									</br>${addOn.productAddOnName}</br>
								</c:forEach>
							</c:if> <input type="hidden" value="${product.uniqueID}"
							name="basket_id_${product.uniqueID}"
							id="basket_id_${product.uniqueID}" />
							<input type="text" value ="${status.count}----   ${product.uniqueID}" />
							<input type="hidden" value="${product.uniqueID}" id="productUniqueID_${status.count}" name="productUniqueID_${status.count}" />
							 <br /></td>
							
						
						<td valign="top">
							<!-- This is the recipient address for one product -->
							<table width="100%">
								<tr>
									<td width="25%">*Recipient</td>
									<td width="75%"><input field="required" type="text"
										size="30" name="recipient_${status.count}"
										id="recipient_${status.count}" value=""></td>
								</tr>
								<tr>
									<td>Phone</td>
									<td><input type="text" size="30"
										name="phone_${status.count}"
										id="phone_${status.count}"></td>
								</tr>

																<tr>
									<td>*Line 1</td>
									<td><input field="required" type="text" size="30"
										name="street_${status.count}"
										id="street_${status.count}" value=""></td>
								</tr>
								<tr>
									<td> Line 2</td>
									<td><input type="text" size="30"
										name="street2_${status.count}"
										id="street2_${status.count}" value=""></td>
								</tr>
								<tr>
									<td>*City</td>
									<td><input field="required" type="text" size="30"
										name="city_${status.count}" id="city_${status.count}" value=""></td>
								</tr>
								<tr>
									<td>*Pincode</td>
									<td><input type="text" size="10"
										name="pincode_${status.count}"
										id="pincode_${status.count}" value=""></td>
								</tr>

								
								<tr>
									<td width="25%"></td>
									<td width="60%">
									<c:if test="${status.count > '1'}">
									<input type="button" id="copy_${status.count}"
										name="copy_${status.count}" value="Copy Recipient Details from first Product" onclick="copy('${status.count}', '${product.uniqueID}')"/>
										</c:if>
										 <%-- <input
										type="button" id="manual_${status.count}" name="manual_${status.count}"
										value="ENTER MANUALLY"
										onclick="hideshow(document.getElementById('mgdiv_${status.count}'));" /> --%>
										</td>
							</table>

							<div id="lookup_container"></div>
							<div id="address_container"></div>
						</td>
						<td valign="top"><textarea rows="8" name="message_${status.count}"
								id="message_${status.count}" cols="25"></textarea> <!-- Maximum 200 characters -->
							</br> <input type="checkbox" name="no_message_box_${status.count}"
							id="no_message_box_${status.count}" value="${status.count}" onclick="message_toggle(${status.count});">
							No Message Required <br /> <br /> <b>
							<div id="delivery_message_${status.count}">Select delivery date</div></b>
							<div id="delivery_calendar_${status.count}">
								<input type="text" id="datepicker_${status.count}" value="${product.deliveryDate}" />
								 <input	type="hidden" name="alt_delivery_date_${status.count}" id="alt_delivery_date_${status.count}" value="${product.deliveryDate}" />
							</div> <br /> <br />
<!-- 
							<div id="default_options_1" style="display: block">
								<input type="radio" name="delivery_method_1" value="0" />First
								Class Royal Mail [Free]<br /> <input type="radio"
									name="delivery_method_1" value="1" checked />Courier Track
								&amp; Trace [+&pound;2.90]<br /> <input type="radio"
									name="delivery_method_1" value="2" />Express Courier
								[+&pound;4.90]<br />
							</div>
 -->
		
					</tr>
				</c:forEach>

				<!-- Till here -->


			</table>


		</div>
<input type="hidden" id="cartSize"  name="cartSize" value="${cartSize}" />	
	   <input type="button" id="continue_checkout" class="greenButtonEnabled" style="position: relative; float: right;" value="Proceed with checkout &raquo;" class="button_checkout"  onclick="TosignIN();" />
 
	</form>
	</div>
	

	<div style="visibility: hidden">
 <br />
	
<script>

function TosignIN(){
	alert("cartSize"+$('#cartSize').val());
	alert($('#dataepicker_1'+"").val());
	
	document.CartMessage.submit();
	
}




</script>


 <a href="http://apycom.com/">Apycom jQuery Menus</a><br /></div>			
</body>
<%-- onclick="hideshow(document.getElementById('mgdiv_1'));" --%>

</html>