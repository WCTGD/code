// JavaScript Document
function hs(){
	var hei=$(window).height();
	var win=$(window).width();
	var hei1=hei-90;
	$('.recover_left').css('height',hei1);
	var tb_wi=win-86;
	$('.div_tb').css('width',tb_wi);
}
hs();

$('.ck_close_img').click(function(){
	$('.gyck_yy').hide();
	$('.cbck_yy').hide();
})