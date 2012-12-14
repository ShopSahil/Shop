<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="content-language" content="EN" />
<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
<link type="text/css" href="css/template.css" rel="stylesheet" />



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



<table id="shopping-basket" width="100%" border="0" cellspacing="0" cellpadding="5">
  <thead>
    <tr>
      <th width="21%"><div align="left">Product</div></th>
      <th width="56%"><div align="center"></div></th>
      <th width="12%">Quantity</th>
      <th width="11%"><div align="right">Total</div></th>
    </tr>
  </thead>
   <tbody>  
 
 
 
 <tr id="sahil">
      <td ><img src="images/BQF-3023.jpg" width="180"></td>
      <td ><div align="left" style="width:400px; float:left; text-align:left">
          <div ><a href="floral-quartet-designer-flowers-EN.html" style="color:#77c200; text-decoration:none; font-weight:bold; text-align:left">Floral Quartet</a>
          <br />
          <strong>CODE: </strong>BQF-3023<br />
          <strong>Size:</strong> Medium
         
        </div>
       <div style="clear:both"></div>
          
			    
                   
        </div>
       
      
              
       
        </td>
      <td><div  align="center">
          1
          <input type="button" value="remove" class="button_remove" />
        </div></td>
      <td><div align="right">&pound;54.90 (GBP)</div></td>
    </tr>
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
	
</tbody><tfoot><tr><td>&nbsp;</td><td><div align="right"><strong>Sub-total: </strong>&pound;219.40</div></td><td><div align="right"><strong>Delivery: </strong>&pound;0.00</div></td><td><div align="center"><b>Total: </b>&pound;219.40</div></td></tr></tfoot>
</table>
<!--<hr />-->
<div>
  <div style="width:500px;float:left">
  <form name="voucher_code_form" id="voucher_code_form" action="/cgi-bin/basket.cgi" method="get">

  <input type="hidden" name="action" value="voucher" />

    <input type="text" name="voucher" />
    <input type="hidden" name="language" value="1" />

    <input type="button" value="Apply voucher code" class="buy_button" onClick="applyVoucher()" />

    </form>

    <div id="voucher_info"></div>
  </div>
  <div style="float:right">
    <input type="button" value="Continue Shopping" class="buy_button" onclick="self.location='/'"/>
    <input type="button" id="continue_checkout" value="Proceed with checkout &raquo;" class="button_checkout"  onclick="self.location='https://www.iflorist.co.uk/checkout_1.shtm'" />
  </div>
</div>

<script type="text/javascript">

$(document).ready(function() {
	// $('#load').hide(); 
	

	$(".button_remove").click(function() {
		

	var string = 'sahil' ;
		var a= $(this);
		alert("string"+string);
	

		$.ajax({
			   type: "POST",
			   url: "delete.do?id="+string,
			   data: { name: "John", location: "Boston" },

			   cache: false,
			   success: function(){
				   alert("sahil");		 
				 a.closest('tr').remove();}	
			  
			   
			 });
		

	return false;
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

</script>

</body>
</html>
<!-- Localized -->