// JavaScript Document

$('.bm_con_div1 a').click(function(){
	$('.bm_ul').hide();
	$(this).parent().children('ul').slideDown();
});

$('.bm_ul li').click(function(){
	$('.bm_ul li,.bm_con_div2 li').removeClass('tr_bg');
	$(this).addClass('tr_bg');
});
$('.bm_con_div2 li').click(function(){
	$('.bm_con_div2 li,.bm_ul li').removeClass('tr_bg');
	$(this).addClass('tr_bg');
});
$('#tpId').click(function(){
	$('#divId').hide();
});