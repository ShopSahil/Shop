<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="home" class="shop.flower.bean.Index" scope="request" />
<jsp:useBean id="xmlParser" class="shop.flower.bean.XmlParser" scope="session" />
<c:set var="menuList" value="${xmlParser.menuLinkList}" scope="session" />
<c:set var="submenuList" value="${xmlParser.menuPageList}" scope="session" />
<c:set var="submenuList1" value="${xmlParser.subMenuPageList}" scope="session" />

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

<link type="text/css" href="css/everyPage.css" rel="stylesheet" />
<link rel="stylesheet" href="css/nivo-slider.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="css/style1.css" type="text/css"
	media="screen" />
<link type="text/css" href="css/menu.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>	
<script type="text/javascript" src="js/jquery.validate.pack.js"></script>
<script type="text/javascript" src="js/jquery.contactable.js"></script>
<link rel="stylesheet" href="css/contactable.css" type="text/css" />

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
								Welcome, please <a href="login/index.html">sign-in</a> or <a
									href="login/index.html">register</a>
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
						<c:choose>
						<c:when test="${MenuLink eq 'Same Day' }" >
						<li class="current">
						
							<a href="#" class="current"><span>${MenuLink}</span></a>
							</c:when>
						<c:when test="${MenuLink eq 'About Us' }" >
						<li class="last">
						
							<a href="#" class="current"><span>${MenuLink}</span></a>
							</c:when>
								
							<c:otherwise>
							<li>
							<a href="#"><span>${MenuLink}</span></a>
							</c:otherwise>
							</c:choose>
						
						
							
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
	<div class="slider-wrapper" style="padding-top: 5px;">
		<div id="slider1" class="nivoSlider">
<img src="images/nivo1.jpg" alt="" /> <img
				src="images/nivo2.jpg" alt="" />

		</div>

	</div>
<div class="grid" align="center">
	
</div>

	<script type="text/javascript" src="js/jquery.nivo.slider.js"></script>
	<script type="text/javascript">
		$(window).load(function() {
		
			$('#slider1').nivoSlider();
		});
		
		$(function(){
			$('#Feedback').contactable({
		 		subject: 'A Feeback Message'
		 	});
		});
	</script>
<div id="Feedback">
</div>
<div style="visibility: hidden">
 <br />
 
 <a href="http://apycom.com/">Apycom jQuery Menus</a><br /></div>
</body>

</html>