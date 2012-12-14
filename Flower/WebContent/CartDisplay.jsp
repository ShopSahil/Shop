<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="content-language" content="EN" />
<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
<link type="text/css" href="css/template.css" rel="stylesheet" />
<link type="text/css" href="css/menu.css" rel="stylesheet" />
<script type="text/javascript" src="js/menu.js"></script>	
<meta http-equiv="expires" content="now" >
<meta http-equiv="pragma" content="no-cache" >
<meta http-equiv="Cache-Control" content="no-cache" >
 	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<style>
#footerLink a {
	text-align:right;
	color:#333;
	text-decoration:none;
	font-size:11px
}
#footerLink {
	position:relative;
	top:10px;
	right:-35px
}
</style>


<style>
body {
	background: url(images/common/images/iflorist/pagebackground.jpg) repeat-x #f7f7f7 top center !important;
	margin-top: 0px;
}
.ih_accountlinks {
	font: normal 13px Arial;
	color: #000000;
}
.ih_accountlinks a:link {
	color: #4a4a4a;
	font-weight:bold;
	text-decoration: none;
}
.ih_accountlinks a:visited {
	color: #4a4a4a;
	font-weight:bold;
	text-decoration: none;
}
.ih_accountlinks a:hover {
	color: #a3bf29;
	font-weight:bold;
	text-decoration: underline;
}
#cart_empty{font-size:16px; text-align:center; font-weight:bold}
#cal {
	font-size:11px;
	width:200px;
	padding:0px;
	margin:0
}
#shopping-basket {
	font-size:12px;
	border:#e1e1e1 1px solid;
	margin-bottom:20px;
	border-bottom:#BEBEBE 1px solid
}
#shopping-basket th {
	background:#757575;
	padding:10px;
	color:#fff;
	font-weight:bold;
	font-size:12px;
	text-align:left;
}
#shopping-basket tbody tr {
	padding:10px;
	background-image:url(images/bg_bottom.jpg);
	background-repeat:repeat-x;
	background-position:109% 114%;
}
#shopping-basket tbody td {
	border-bottom:#e1e1e1 1px solid;
	padding:20px
}
#cal1 tbody td {
	padding:0;
	border:0
}
#cal1 tbody tr {
	padding:0;
	border:0;
	background:none
}
#cal1 th {
	padding:0;
	border:0;
	background:#fff;
	font-size:10px
}
.shopping_basket_total {
	border-top:#e1e1e1 1px solid
}
#product_options {
	float:left;
	font-size:11px;
	width:200px;
	padding:0px;
	margin:0
}

.button_remove{
	padding:2px;
	font-size:10px;
	border:#e1e1e1 1px solid;
	font-weight:bold;
	cursor:pointer;
	padding-left:5px;
	padding-right:5px;
	margin-top:10px;
	background:#3f3f3f;
	color:#f0f0f0;!important}

 #addons {float:left;width:75px; text-align:center;padding:5px}
</style>


</head>

<body>

<form name="cartDisplay" action="CartDisplay.do" method="post">
		<table width="950" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td style="padding: 0px; border: 0px solid #CCCCCC;">
				<table width="930" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="150" style="padding: 0px; border: 0px solid #CCCCCC;">
							<a href="#"> <img src="images/SiteIcon.png"
								alt="Click here to go Home" height="90px" width="90px" />
						</td>
						<td width="150" style="padding: 0px; border: 0px solid #CCCCCC;">
							<h1>VAS</h1> Everybody's local florist </a>
						</td>
						<td width="325" align="right" valign="bottom"
							style="padding: 0px; border: 0px solid #CCCCCC;">
							
						<td width="370" align="right" valign="bottom">
							<div class="ih_accountlinks" style="margin: 0px 3px 7px 0px;">
								Welcome, please <a href="signin_1.shtm">sign-in</a> or <a
									href="abcd">register</a>
							</div>
							<table width="195" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="41"><a href="/basket_1.shtm"><img
											src="images/basket1.gif" width="41" height="40"
											border="0" /></a></td>
									<td width="70" align="center"
										background="images/basket2.gif"
										style="font-size: 12px; font-family: arial; font-weight: normal; color: #0000000;">
										<a href="/basket_1.shtm"
										style="color: #444444; text-decoration: none;">0 item(s)</a>
									</td>
									<td width="84" align="center"
										background="images/basket3.gif"
										style="font-size: 14px; font-family: arial; font-weight: bold; color: #0000000;"><a
										href="/basket_1.shtm"
										style="color: #444444; text-decoration: none;">Rs 0.00</a></td>
								</tr>
								<tr>
									<td><img src="images/basketshadow1.gif"
										width="41" height="14" /></td>
									<td><img src="images/basketshadow2.gif"
										width="70" height="14" /></td>
									<td><img src="images/basketshadow3.gif"
										width="84" height="14" /></td>
								</tr>
							</table>
						</td>
					</tr>
				</table> 
			</td>
		</tr>
		<tr>
			<td>
				<div id="menu" class="menu">
					<ul class="menu">
						<c:forEach items="${menuList}" var="MenuLink" varStatus="status">					
						<li>
							<a href="#"><span>${MenuLink}</span></a>
							
								<c:forEach items="${submenuList}" var="SubMenuLink" varStatus="status">								
									<c:if test="${SubMenuLink.menuName eq MenuLink}">						
										<c:if test="${SubMenuLink.subLink eq 1}">
														<div>
															<ul>			
															<c:forEach items="${SubMenuLink.subMenuPageList}" var="SubMenuLink1" varStatus="status">	
											
																<li><a href="#" onclick="openLink('${SubMenuLink1.subLinkValue}')"><span>${SubMenuLink1.subLinkName}</span></a></li>
															</c:forEach>
															</ul>
														</div>				
										</c:if>	
										</c:if>		
								</c:forEach>									
						</li>
					</c:forEach>
					</ul>
				</div>			
			</td>
		</tr>
	</table>

<table id="shopping-basket" width="97%" border="0" cellspacing="0" cellpadding="5" align="center" style="padding-top: 5px">
  <thead>
    <tr>
      <th width="21%"><div align="center" >Product</div></th>
      <th width="56%"><div align="center"></div></th>
      <th width="12%"><div align="center">Quantity</div></th>
      <th width="11%"><div align="center">Total</div></th>
    </tr>
  </thead>
   <tbody>  
 <input type="hidden" id="addOnProdId" value="0" />
 <c:forEach  var='products' items="${completeCart}" >
 	<c:set var="product" value="${products.value}" />
 
 
 
 <tr id="${product.uniqueID}">
      <td ><img src="${product.productImage}" width="180"></td>
      	<td >
      		<div align="left" style="width:400px; float:left; text-align:left">
          		<div >
          			<a href="${pageContext.request.contextPath}/product/bouquet.jsp?id=${product.productID}" style="color:#77c200; text-decoration:none; font-weight:bold; text-align:left">${product.productName}</a>
         			 <br />
          			<strong>CODE: </strong>BQF-3023<br />
          
         
        		</div>
       		<div style="clear:both"></div>
          
			 <c:if test="${not empty product.addOnDAO}">
				<c:forEach var="addOn" items="${product.addOnDAO}" >
 						<c:if test="${addOn.cartSelectedFlag == 1}" >
 
				   <div id="addons" style="border:0"><img src="${addOn.productAddOnImage}"  width="60"/><br />
				  		 <input type="checkbox" id="addONs${addOn.productAddOnId}" value="${addOn.productAddOnPrice}" name="addON${addOn.productAddOnId}" checked/><br />
			  			 <span><b>${addOn.productAddOnName}</b><br /> [Rs ${addOn.productAddOnPrice}]</span>
				  	</div> 
				  	</c:if>
				  	<c:if test="${addOn.cartSelectedFlag == 0}" >
 
				   <div id="addons" style="border:0"><img src="${addOn.productAddOnImage}"  width="60"/><br />
				  		 <input type="checkbox" id="addONs${addOn.productAddOnId}" value="${addOn.productAddOnPrice}" name="addON${addOn.productAddOnId}" /><br />
			  			 <span><b>${addOn.productAddOnName}</b><br /> [Rs ${addOn.productAddOnPrice}]</span>
				  	</div> 
				  	</c:if>
				  	
 				</c:forEach>
                  
             </c:if>     

        </div>
       </td>
     	 <td><div  align="center">
          ${product.productQuantity}
          <input type="button" value="remove" id="${product.uniqueID}" class="button_remove" />
        </div></td>
      <td><div align="right"><span class="row${product.uniqueID}">Rs ${product.totalCost}</span>
      						<input type="hidden" id="priceAfterAdd${product.uniqueID}"	value="${product.totalCost}" />
      </div></td>
    </tr>
    
    
</c:forEach>
 
    <!-- 
    <tr>
      <td>
      <img src="images/BQF-3023.jpg" width="180"></td>
      <td>
      <div align="left" style="width:400px; float:left; text-align:left">
          <div id=""><a href="floral-quartet-designer-flowers-EN.html" style="color:#77c200; text-decoration:none; font-weight:bold; text-align:left">Floral Quartet</a>
          <br />
          <strong>CODE: </strong>BQF-3023<br />
          <strong>Size:</strong> Medium
         
        </div>
       <div style="clear:both"></div>
          
                           
			   <div id="addons" style="border:0"><img src="/images/GF001.jpg"  width="60"/><br /><input type="checkbox" id="1" name="1" checked/><br /><span><b>Vase</b><br /> +[&pound;14.90]</span></div> 
                   
        </div>
       
      
              
       
        </td>
      <td><div align="center">
          1
          <input type="button" value="remove" class="button_remove" />
        </div></td>
      <td><div align="right">&pound;69.80 (GBP)</div></td>
    </tr>
	 -->
	</tbody>
		<tfoot>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;
	<!-- 			<div align="right"><strong>Sub-total: </strong>Rs 219.40</div>
	 -->		</td>
			<td>
				<div align="right"><strong>Saving: </strong> <span id="totalCartsaving">Rs ${totalCartSaving}</span>  </div>
 			</td>
			<td>
				<div align="center"><b>Total: </b><span id="totalCartCost">Rs ${totalCartCost}</span></div>
			</td>
		</tr>
	</tfoot>
		
</table>
<!--<hr />-->
<div>
  <div style="width:500px;float:left">
  <form name="voucher_code_form" id="voucher_code_form" action="voucher.do"  method="get">

    <input type="text" name="voucher" style=" padding-left: 5px; margin-left: 20px;"/>
   
    <input type="button" value="Apply voucher code" class="buy_button" onClick="applyVoucher()" />

    </form>

    <div id="voucher_info"></div>
  </div>
  <div style="float:right ; padding-right: 5px;margin-right: 20px;">
    <input type="button" value="Continue Shopping" class="buy_button" onclick="${pageContext.request.contextPath}/index.jsp"/>
 
    <input type="button" id="continue_checkout" value="Proceed with checkout &raquo;" class="button_checkout"  onclick="cartMessage();" />
 
  </div>
</form>
</div>

<script type="text/javascript">

$(document).ready(function() {
	// $('#load').hide(); 
	

	$(".button_remove").click(function() {
			var string = 'sahil' ;
			var a= $(this);
			var b=a.attr("id");	
			var productCost=".row"+b;
			alert("string"+string);
			$.ajax({
			   type: "POST",
			   url: "delete.do?id="+b,
			   data: {RowID : b },
			   dataType: "json",
			      
			   cache: false,
			   success: function(result){
				   		 if(result.success){
				 a.closest('tr').remove();
				 $("#totalCartsaving").html('Rs' +result.totalCartSaving);
				 $("#totalCartCost").html('Rs'+  result.totalCartCost);
				   		 
				   		 }	
			   }
			 });
		return false;
		});


	
	
	$('input[type="checkbox"]').bind('click', function() {

		if ($(this).is(':checked')) {
			var addOnProduct = new Array();
			alert($(this).val());
			var addOnID = $(this).get(0).id;
			alert(addOnID);
			var prodID= $(this).closest('tr').attr('id');
			var priceAfterAddon="#priceAfterAdd"+prodID;
			
			var a = $(priceAfterAddon).val();
			var tempClass=".row"+prodID;
			a = parseInt(a) + parseInt($(this).val());
			$(tempClass).html('Rs' + a);
			$(priceAfterAddon).val(a);
			var totalCost= $(priceAfterAddon).val();
			var addOnPrice=$(this).val();
			addOnProduct.push(addOnID.substring(6));
			$("#addOnProdId").val(addOnProduct);
			var addONID= $("#addOnProdId").val();
			alert(addONID);
			alert("reached");
			$.ajax({
				   type: "POST",
				   url: "updateCartProductDisplay.do?id="+prodID+"&action=add",
				   data: {RowID: prodID, action : "add", totalRowCost : totalCost, addOnId: addONID, addonPrice: addOnPrice  },
				   dataType: "json",
				   cache: false,
				   success: function(result){
					   if(result.success){
						   
						   //$("#totalCartsaving").html('Rs' +result.totalCartSaving);
							 $("#totalCartCost").html('Rs'+  result.totalCartCost);
							 		   
					   }
				   }
				   
				 });

			
		}
		if ((this.checked == false)) {
			var addOnProduct = new Array();
			var addOnID = $(this).get(0).id;
			
			var prodID= $(this).closest('tr').attr('id');
			var priceAfterAddon="#priceAfterAdd"+prodID;
			
			var a = $(priceAfterAddon).val();
			var tempClass=".row"+prodID;
			a = parseInt(a) - parseInt($(this).val());
			$(tempClass).html('Rs' + a);
			$(priceAfterAddon).val(a);
			var totalCost= $(priceAfterAddon).val();
			
			addOnProduct.push(addOnID.substring(6));
			$("#addOnProdId").val(addOnProduct);
			var addONID= $("#addOnProdId").val();
			var addOnPrice=$(this).val();
			
			alert("reached");
			$.ajax({
				   type: "POST",
				   url: "updateCartProductDisplay.do?id="+prodID+"&action=delete",
				   data: {RowID: prodID, action : "delete", totalRowCost : totalCost, addOnId: addONID , addonPrice: addOnPrice },
				   dataType: "json",
				   cache: false,
				   success: function(result){
					   if(result.success){
						   //$("#totalCartsaving").html('Rs' +result.totalCartSaving);
							 $("#totalCartCost").html('Rs'+  result.totalCartCost);
							 
						   
					   }
				   }
				   
				 });

		}
	});
	
	
	
	
	
});
/* 
function abc(data)
{
	alert(data);
	var a= data;
	$.getJSON("verify.do", {
		action : "1",
		emailID : data
	}, displayUserExist);

}

function displayUserExist(data){
	
	alert(data);
	
	
}

$.ajax({
	   type: "POST",
	   url: "delete.do?id="+string,
	   data: { name: "John", location: "Boston" },

	   cache: false,
	   success: function(){
		   alert("sahil");		 
		 a.closest('tr').remove();}	
	  
	   
	 });


*
*
*/
function cartMessage(){
	
	document.cartDisplay.submit();
	
}
</script>
<div style="visibility: hidden">
 <br />
 <a href="http://apycom.com/">Apycom jQuery Menus</a><br /></div>			

</body>
</html>
<!-- Localized -->