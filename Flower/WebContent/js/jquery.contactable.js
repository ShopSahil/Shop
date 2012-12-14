(function($){
	$.fn.contactable = function(options) {var defaults = {name: 'Name',	email: 'Email',	message : 'Message',subject : 'A contactable message',recievedMsg : 'Thankyou for your message',notRecievedMsg : 'Sorry but your message could not be sent, try again later',disclaimer: 'Please feel free to get in touch, we value your feedback',hideOnSubmit: true};
	var options = $.extend(defaults, options);
	return this.each(function(options) {$(this).html('<div id="contactable"></div><form id="contactForm" method="" action=""><div id="loading"></div><div id="callback"></div><div class="holder"><p><label for="name">Name <span class="red"> * </span></label><br /><input id="name" class="contact" name="name" /></p><p><label for="email">E-Mail <span class="red"> * </span></label><br /><input id="email" class="contact" name="email" /></p><p><label for="comment">Your Feedback <span class="red"> * </span></label><br /><textarea id="comment" name="comment" class="comment" rows="4" cols="30" ></textarea></p><p><input class="submit" type="submit" value="Send"/></p><p class="disclaimer">'+defaults.disclaimer+'</p></div></form>');
	$('div#contactable').toggle(function() {$('#overlay').css({display: 'block'});$(this).animate({"marginRight": "-=5px"}, "fast"); $('#contactForm').animate({"marginRight": "-=0px"}, "fast");$(this).animate({"marginRight": "+=387px"}, "slow"); $('#contactForm').animate({"marginRight": "+=390px"}, "slow");},function() {$('#contactForm').animate({"marginRight": "-=390px"}, "slow");$(this).animate({"marginRight": "-=387px"}, "slow").animate({"marginRight": "+=5px"}, "fast"); $('#overlay').css({display: 'none'});});
	$("#contactForm").validate({rules: {name: {required: true,minlength: 2},email: {required: true,email: true},comment: {required: true}},messages: {name: "",email: "",comment: ""},submitHandler: function() {$('.holder').hide();$('#loading').show();
	$.post('mail.php',{subject:defaults.subject, name:$('#name').val(), email:$('#email').val(), comment:$('#comment').val()},
			function(data){$('#loading').css({display:'none'});
			if( data == 'success') {
				$('#callback').show().append(defaults.recievedMsg);
			if(defaults.hideOnSubmit == true) {
	$('#contactForm').animate({dummy:1}, 2000).animate({"marginRight": "-=450px"}, "slow");
	$('div#contactable').animate({dummy:1}, 2000).animate({"marginRight": "-=447px"}, "slow").animate({"marginRight": "+=5px"}, "fast");
	$('#overlay').css({display: 'none'});}}
			else {$('#callback').show().append(defaults.notRecievedMsg);}});}});});};})(jQuery);