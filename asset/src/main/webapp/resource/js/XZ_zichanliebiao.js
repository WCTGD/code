// JavaScript Document
function tb(){
	//返回按钮的位置
	var tb=$('table').width();
	$('.fh').css('width',tb);
}
tb();
//tr点击背景色
$('.ma_ta tr').click(function(){
	$('.ma_ta tr').removeClass('tr_bg');
	$(this).addClass('tr_bg');	
})