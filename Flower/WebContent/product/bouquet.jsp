<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="bouquet" class="shop.flower.bean.Bouquet" scope="page" />
<jsp:setProperty name="bouquet" property="productID" value="1" />

<c:out value="${pageContext.request.requestURI}" />
<c:out value="${header.referer}" />

  
<html>
<%-- ${param['id']} --%>
<title>Product</title>
<head>
<meta http-equiv="expires" content="now">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<link type="text/css" href="../css/menu.css" rel="stylesheet" />

<link type="text/css" href="../css/jquery-ui-1.8.23.custom.css"
	rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="../js/jquery-ui-1.8.23.custom.min.js"></script>
<link rel="stylesheet" href="../css/bouquet.css" type="text/css"
	media="screen" />
	<script type="text/javascript" src="../js/menu.js"></script>	
	

<style>
</style>
<script type="text/javascript">


	function doReset() {
		frmlen = document.forms.length;
		for (i = 0; i < frmlen; i++) {
			document.forms[i].reset();
		}
	}

	$(function() {

		// Tabs
		$('#tabs').tabs();

		$('#datepicker').datepicker({
			minDate : "+2D",
			maxDate : "+1M +10D",
			showOtherMonths : true,
			selectOtherMonths : true
		});

		// Datepicker
		//	$('#datepicker').datepicker({
		//	inline: true
		//});

		//hover states on the static widgets
		$('#dialog_link, ul#icons li').hover(function() {
			$(this).addClass('ui-state-hover');
		}, function() {
			$(this).removeClass('ui-state-hover');
		});

	});
</script>

<!--VARIABLE=!PAGE_META-->


</head>

<body onload="doReset();">
		<table width="950" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td style="padding: 0px; border: 0px solid #CCCCCC;">
				<table width="930" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="150" style="padding: 0px; border: 0px solid #CCCCCC;">
							<a href="#"> <img src="../images/SiteIcon.png"
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
											src="../images/basket1.gif" width="41" height="40"
											border="0" /></a></td>
									<td width="70" align="center"
										background="../images/basket2.gif"
										style="font-size: 12px; font-family: arial; font-weight: normal; color: #0000000;">
										<a href="/basket_1.shtm"
										style="color: #444444; text-decoration: none;">0 item(s)</a>
									</td>
									<td width="84" align="center"
										background="../images/basket3.gif"
										style="font-size: 14px; font-family: arial; font-weight: bold; color: #0000000;"><a
										href="/basket_1.shtm"
										style="color: #444444; text-decoration: none;">Rs 0.00</a></td>
								</tr>
								<tr>
									<td><img src="../images/basketshadow1.gif"
										width="41" height="14" /></td>
									<td><img src="../images/basketshadow2.gif"
										width="70" height="14" /></td>
									<td><img src="../images/basketshadow3.gif"
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
	<table width="930" border="0" cellspacing="0" cellpadding="0"
		align="center">
		<tr>
			<td><div id="main">
					<table width="930" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="665" valign="top"><div
									style="width: 665px; height: 8px;">
									<img src="../images/buypage1top.gif" width="665" height="8">
								</div>
								<table width="665" border="0" cellspacing="0" cellpadding="0"
									style="border-left: 1px solid #C3C3C3; border-right: 1px solid #C3C3C3; background: #FFFFFF;">
									<tr>
										<td width="8" valign="top"><img
											src="../images/spacer.gif" width="8" height="10" /></td>
										<!-- 										<td width="72" valign="top"><img -->
										<!-- 											src="../images/spacer.gif" width="72" height="1" /><br /> <br /> -->
										<!-- 										</td> -->
										<td width="8" valign="top"><img
											src="../images/spacer.gif" width="8" height="10" /></td>
										<td width="300" valign="top"><div id="divProductPic">
												<img border="0" id="ProductPic" name="ProductPic"
													src="../${bouquet.bouquetDAO.productImage}" height="300"
													width="300" alt="" />

											</div></td>
										<td width="10" valign="top"><img
											src="../images/spacer.gif" width="10" height="10" /></td>
										<td width="255" valign="top"
											style="font-size: 12px; color: #0000000; line-height: 150%; padding-top: 8px;">
											<div
												style="font-size: 20px; color: #3c3c3c; line-height: 120%; margin-bottom: 5px;">
												${bouquet.bouquetDAO.productName}</div> <strong>Product
												code:</strong> BQR-1004 <c:if
												test="${bouquet.bouquetDAO.productQuantity le 0}">
												<br>
												<img src="../images/instock-no.png" align="absmiddle" />
												<br />
											</c:if> <br /> ${bouquet.bouquetDAO.productLongDesc} <br /> <!--Start Moved-->
											<form name="addProduct" id="addProduct" action="../Cart.do"
												method="post">
												<input type="hidden" name="action" id="action"
													value="add_to_basket" /> <input type="hidden"
													name="productID" id="productID"
													value="${bouquet.bouquetDAO.productID} " /> <input
													type="hidden" name="productName" id="productName"
													value="${bouquet.bouquetDAO.productName} " /> <input
													type="hidden" name="price_original" id="price_original"
													value="${bouquet.bouquetDAO.productPrice}" /> <input
													type="hidden" name="priceAfterAdd" id="priceAfterAdd"
													value="${bouquet.bouquetDAO.productPrice}" /> <input
													type="hidden" name="addOnProdId" id="addOnProdId" value="0" />
												<input type="hidden" name="productImage" id="productImage"
													value="${bouquet.bouquetDAO.productImage}" /> <input
													type="hidden" name="productwithoutdiscount"
													id="productwithoutdiscount"
													value="${bouquet.bouquetDAO.productOriginalPrice}" /> <input
													type="hidden" name="productTotalSaving"
													id="productTotalSaving"
													value="${bouquet.bouquetDAO.moneySaved}" />

												<!-- <input
													type="hidden" name="addOnProdId2" value="0" /> <input
													type="hidden" name="addOnProdId3" value="0" /> <input
													type="hidden" name="addOnProdId4" value="0" /> <input
													type="hidden" name="addOnProdId5" value="0" />
													<input type="hidden" name="deliverydate" id="deliverydate" value="" /> -->
												<!--End Moved-->

												<!--Addon-->
												<div id="addons-upsell">
													<br />
													<c:forEach items="${bouquet.addOnDAOs}" var="AddOnDAO"
														varStatus="status">

														<div id="option_image">
															<img src="../${AddOnDAO.productAddOnImage}"
																title="${AddOnDAO.prodcutAddOnDesc}"><br /> <input
																type="checkbox" name="addon"
																id="addons${AddOnDAO.productAddOnId}"
																value="${AddOnDAO.productAddOnPrice}"><br />${AddOnDAO.productAddOnName}
															+Rs${AddOnDAO.productAddOnPrice}
															<%-- <input type="hidden" name="addonProd${AddOnDAO.productAddOnId}"
																id="addprods${AddOnDAO.productAddOnId}" value="${AddOnDAO.productAddOnId}" /> --%>
														</div>

													</c:forEach>
												</div>
												<!--End Addon-->
										</td>
										<td width="10" valign="top"><img
											src="../images/spacer.gif" width="10" height="10" /></td>
									</tr>
								</table>
								<div style="width: 665px; height: 8px;">
									<img src="../images/buypage1bottom.gif" width="665" height="8">
								</div></td>
							<td valign="top"><img src="../images/spacer.gif" width="10"
								height="10" /></td>
							<td width="255" valign="top"><div
									style="width: 255px; height: 8px;">
									<img src="../images/buypage2top.gif" width="255" height="8">
								</div>
								<table width="255" height="300" border="0" cellspacing="0"
									cellpadding="0"
									style="border-left: 1px solid #C3C3C3; border-right: 1px solid #C3C3C3; background: #FFFFFF;">
									<tr>
										<td width="9" valign="top"><img
											src="../images/spacer.gif" width="9" height="10" /></td>
										<td width="235" valign="top"
											style="font-size: 12px; color: #0000000; line-height: 160%; padding-top: 15px;"><span
											class="buy_price">Rs${bouquet.bouquetDAO.productPrice}</span>
											&nbsp; <br /> <span class="orginial_price">Rs${bouquet.bouquetDAO.productOriginalPrice}</span>
											<span class="save_price">save
												Rs${bouquet.bouquetDAO.moneySaved}</span> <!--Start Basket Code-->
											<span class="sahil"></span> <!--Moved Start-->

											<div style="padding-top: 10px">
												<!-- 	<b>Choose Size</b><br /> <input type="radio" name="size"
													value="1"><b>Small</b> (&pound;19.90)<br /> <input
													type="radio" name="size" value="2" checked><b>Medium</b>
												(&pound;24.90)<br /> <input name="size" type="radio"
													value="3"><b>Large</b> (&pound;29.90)<br />
 -->
											</div>
											<div style="clear: both"></div> <c:if
												test="${bouquet.bouquetDAO.productQuantity le 0}">
												<br>
												<div
													style="font-size: 20px; color: #3c3c3c; line-height: 120%; margin-bottom: 5px;">Sorry,${bouquet.bouquetDAO.productName}
													is out of stock.</div>
												<br />
											</c:if> <c:if test="${bouquet.bouquetDAO.productQuantity gt 0}">


												<%-- 		<c:choose> --%>
												<%-- 	<c:when test="${bouquet.bouquetDAO.productQuantity <= 0} "> --%>
												<%-- 		<div>Sorry,${bouquet.bouquetDAO.productName} is out	of stock. --%>
												<!-- 		</div> -->
												<%-- 			</c:when> --%>


												<%-- 												<c:otherwise> --%>
												<div id="available">
													<div style="height: 8px; background-color:;"></div>
													<b>Please select a delivery date:</b>
													<!--Upcoming Dates Dropdown-->

													<p>
														Date: <input type="text"  name="datepicker" id="datepicker"
															required="required">
													</p>
								
													<div style="height: 10px; background-color:;"></div>
							<!--  						<b>Upcoming delivery dates:</b><br />
	<!-- 												<!--Upcoming delivery date links
													<div id="upcoming_dates">
														<a href="#"
															onclick="javascript:upcoming_date('31-07-2012')">Tuesday,
															31 July</a> | <a href="#"
															onclick="javascript:upcoming_date('01-08-2012')">Wednesday,
															1 August</a> | <a href="#"
															onclick="javascript:upcoming_date('02-08-2012')">Thursday,
															2 August</a> | <b><a href="same-day-flowers-EN.html"
															target="_blank">Need delivery today?</a></b>
													</div>
													End Upcoming delivery date links
 --> 
													<div style="height: 10px; background-color:;"></div>
													<span id="option_delivery_text2"><b>Delivery:</b> <!--Show Chosen Delivery Date-->
														<input type="text" id="show_date"
														style="border: none; background: transparent; width: 165px;">
														<!--End Show Chosen Delivery Date--> </span>
													<div style="height: 10px; background-color:;"></div>
													<!--Buy Button and Quantity-->
													<!--Button fix-->
													<div id="option_buy">
														<div style="float: right">

															<span></span> Quantity<input type="text" name="quantity"
																style="width: 16px" id="quanity" value="1" /><input type="button"
																class="product_buy_button" value="Add to Basket"
																onclick="addtobasket();" />



														</div>
														<%-- 			</c:otherwise> --%>
														<%-- 	</c:choose> <!--Buy Button and Quantity--></td> --%>
											</c:if>
										<td width="9" valign="top"><img
											src="../images/spacer.gif" width="9" height="10" /></td>
									</tr>
								</table>
								<div style="width: 255px; height: 8px;">
									<img src="../images/buypage2bottom.gif" width="255" height="8">
								</div></td>
						</tr>
					</table>
</form>

<script type="text/javascript">

	var addOnProduct = new Array();
	
	$(document).ready(function() {
		$('input[type="checkbox"]').bind('click', function() {

			if ($(this).is(':checked')) {
				alert($(this).val());
				var addOnID = $(this).get(0).id;

				var a = $("#priceAfterAdd").val();
				a = parseInt(a) + parseInt($(this).val());
				$(".buy_price").html('Rs' + a);
				$("#priceAfterAdd").val(a);

				addOnProduct.push(addOnID.substring(6));
				$("#addOnProdId").val(addOnProduct);
			}
			if ((this.checked == false)) {
				alert("sahil");
				var a = $("#priceAfterAdd").val();
				a = parseInt(a) - parseInt($(this).val());
				$(".buy_price").html('Rs' + a);
				$("#priceAfterAdd").val(a);
				var addOnID = $(this).get(0).id;

				var index = $.inArray(addOnID.substring(6), addOnProduct);
				if (index != -1) {
					addOnProduct.splice(index, 1);
				}
				$("#addOnProdId").val(addOnProduct);

			}
		});
	});

	function addtobasket() {
		if ($("#datepicker").val() == "")
			{alert("please select");
			return fasle();
			}		
		$("#action").val('add');
		document.addProduct.submit();
		
	}
</script>
<div style="visibility: hidden">
 <br />
 <a href="http://apycom.com/">Apycom jQuery Menus</a><br /></div>			
</body>

</html>

