<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="home" class="shop.flower.bean.Index" scope="request" />

<c:set var="prod" value="${home.homepageList}" scope="page" />
<html>
<head>
<title>VAS</title>

<%
	session = request.getSession(true);
    if(null == session.getAttribute("userID")) {
    
    	session.setAttribute("userID","Guest");
    	home.setUserID(session.getAttribute("userID").toString());
    
    }
    else if(session.getAttribute("userID") != null || session.getAttribute("userID") !="" ){ 
    	
    	home.setUserID(session.getAttribute("userID").toString());
    
    }
%>

<link rel="stylesheet" href="themes/default/default.css" type="text/css"
	media="screen" />
<link href="css/styles.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/nivo-slider.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="css/style1.css" type="text/css"
	media="screen" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	

<style type="text/css">

body {
width:950px;
	text-align:center; 
margin:0 auto;
	font-family: arial;
	font-weight: normal;
	background: url(images/pagebackground.jpg) repeat-x #f7f7f7 top center	!important;
	margin-top: 0px;
}

.productbackground1 {
	width: 217px;
	height: 8px;
	background-image: url("images/productbackground1.gif");
}

.buy_price {
	padding-top: 3px;
	padding-bottom: 3px;
	font-family: Arial;
	font-size: 20px;
	letter-spacing: -1px;
	line-height: 120%;
	color: #444444;
	font-weight: normal;
}

.orginial_price {
	color: #7b7b7b;
	font-size: 20px;
	letter-spacing: -1px;
	line-height: 120%;
	text-decoration: line-through;
}

.product_border {
	width: 215px;
	height: auto;
	border-left: solid 1px #c3c3c3;
	background: #FFFFFF;
	border-right: solid 1px #c3c3c3;
}

.product_text {
	overflow: hidden;
	font-size: 13px;
	color: #444444;
	line-height: 130%;
}
.product {
    float: left;
    height: 370px;
    margin-bottom: 0;
    margin-top: 5px;
    padding: 0;
    text-align: center;
    width: 232px;
}

.grid{
text-align:center; 
margin:0 auto;
width: 936px;
height:auto;
align: center;

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

/* 
width:215px; 
height:auto;  overflow:hidden; 
padding-left:10px; padding-right:10px; font-size:13px;" */
</style>

</head>
<body >
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
				<div id='cssmenu'>
					<ul>
						<li class='active '><a href='login.html'><span>Home</span></a></li>
						<li class='has-sub '><a href='#'><span>Same Day</span></a>
							<ul>
								<li><a href='#'><span>Same Day Flowers</span></a></li>
								<li><a href='#'><span>Designer Flowers</span></a></li>
							</ul></li>
						<li class='has-sub '><a href='#'><span>Boutique</span></a>
							<ul>
								<li><a href='#'><span>Boutique Flowers</span></a></li>
								<li><a href='#'><span>Simply Beautiful Flowers</span></a></li>
							</ul></li>
						<li class='has-sub '><a href='#'><span>Gifts</span></a>
							<ul>
								<li><a href='#'><span>Wine Gift Sets</span></a></li>
								<li><a href='#'><span>3-Bottle Wine Cases</span></a></li>
							</ul></li>
						<li class='has-sub '><a href='#'><span>Funeral
									Flowers</span></a>
							<ul>
								<li><a href='#'><span>Casket Tributes</span></a></li>
								<li><a href='#'><span>Funeral Wreath</span></a></li>
							</ul></li>
						<li class='has-sub '><a href='#'><span>Plants</span></a>
							<ul>
								<li><a href='#'><span>Special Occasions</span></a></li>
								<li><a href='#'><span>Get Well Soon</span></a></li>
							</ul></li>
						<li class='has-sub '><a href='#'><span>Special
									Occasions</span></a>
							<ul>
								<li><a href='#'><span>Get Well Soon</span></a></li>
								<li><a href='#'><span>Happy Anniversary</span></a></li>
							</ul></li>
						<li class='has-sub '><a href='#'><span>Flower
									Offers</span></a>
							<ul>
								<li><a href='#'><span>Free Flower Delivery</span></a></li>
							</ul></li>
						<li><a href='#'><span>Contact</span></a></li>
						<li><a href='#'><span>About</span></a></li>
					</ul>
				</div>
			</td>
		</tr>
	</table>
	<div class="slider-wrapper" style="padding-top: 5px;">
		<div id="slider1" class="nivoSlider">
			<img src="images/Feat-Botanics.jpg" alt="" /> <img
				src="images/Feat-Gorgeous.jpg" alt="" />

		</div>

	</div>
<div class="grid" align="center">
<c:forEach items="${prod}" var="HomepageDAO" varStatus="status">
	<div class="product" style="padding-top: 40px; text-align: center;" align="center" >

		<div style="width: 217px; height: 8px;">
			<img src="images/productbackground1.gif" width="217" height="8">
		</div>
		<div class="product_border">
			<a href="${pageContext.request.contextPath}/product/bouquet.jsp?id=${HomepageDAO.productID}"> 
			<img src="${HomepageDAO.productImage}" width="215"
				height="215" border="0" /></a>
		</div>
		<div class="product_border product_text">
			<a href="#" style="font-size: 15px; color: #444444;">${HomepageDAO.productName}</a>
		</div>
		<div class="buy_price product_border">
			<span class="orginial_price">Rs${HomepageDAO.productOrigPrice}</span> Rs${HomepageDAO.productDiscPrice}
		</div>

		<div class="product_border product_text">${HomepageDAO.productShortDescrip}</div>
		<div class="product_border">
			<a href="#"><img src="images/shopnow.gif" width="93" height="22"
				vspace="5" border="0" /></a>
		</div>

		<div style="width: 215px; height: 8px;">
			<img src="images/productbackground3.gif" width="215" height="8">
		</div>

	</div>
</c:forEach>
	
</div>

	<script type="text/javascript" src="js/jquery.nivo.slider.js"></script>
	<script type="text/javascript">
		$(window).load(function() {
		
			$('#slider1').nivoSlider();
		});
	</script>
</body>

</html>