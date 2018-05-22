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


//新安全指导
$('.xj').click(function(){
	$('.aqzd_yy').show();
	$('#aqzd_qr,#aqzd_qx').click(function(){
		$('.aqzd_yy').hide();
	});
});
$('.in_file').change(function(){
	var v=$(this).val();
	$('.div1_sc input').val(v);
});