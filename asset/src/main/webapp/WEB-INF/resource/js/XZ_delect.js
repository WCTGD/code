// JavaScript Document
//删除
function sc(){
	$('table .sc').click(function(){
		var that=this;
		$('.sc_yy').show();
		$('.qr').click(function(){
			$(that).parent().parent().parent().remove();
			$('.sc_yy').hide();
		})
		$('.qx').click(function(){
			$('.sc_yy').hide();
		})	
	})	
	$('#sc_close_img').click(function(){
		$('.sc_yy').hide();	
	})
};
sc();