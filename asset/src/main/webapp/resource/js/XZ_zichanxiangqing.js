// JavaScript Document
//tr点击背景色
$('.ma_ta tr').click(function(){
	$('.ma_ta tr').removeClass('tr_bg');
	$("[name=check_qx]:checkbox").removeAttr("checked");
	$(this).addClass('tr_bg');
	$(this).find("[name=check_qx]:checkbox").prop("checked",true);		
})