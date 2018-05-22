// JavaScript Document
$("div[class='ma_ta']").hide()
$("div[class='ma_ta']").eq(0).show()
$(".nav a").click(function(){
	var n=$(".nav a").index(this)
	$(".nav a").removeClass("b")
	$(this).addClass("b")	
	$("div[class='ma_ta']").hide()
	$("div[class='ma_ta']").eq(n).show()
	$('#zh_close_img').click(function(){
		$("div[class='ma_ta']").eq(n).hide()
		$(".nav a").removeClass("b")
		$(".nav a").eq(0).addClass("b")
		$("div[class='ma_ta']").eq(0).show()	
	})
})

function tb(){
	//新增/修改页面弹窗高度
	var h=$(window).height()-154;
	$('.zx_yy,.zh_yy,.ck_yy').css('height',h);
	var h0=$(window).height()-268;
	$('.xz_div_z,.zh_div_z').css('height',h0);
	var h1=h0/2
	$('.xz_div_z,.zh_div_z').css('margin-top',-h1);
	var h2=h0-30;
	$('.xz_div0,.zh_div0').css('height',h2);
}
tb();
//新增/修改
$('#xgys,#gy_xg').click(function(){
	$('.zx_yy').show();
	$('#close,#xz_close_img').click(function(){
		$('.zx_yy').hide();
	});
});
//查看
$('#gy_ck').click(function(){
	$('.ck_yy').show();
	$('#close,#ck_close_img').click(function(){
		$('.ck_yy').hide();
	});
});

//全选
$("#qx").click(function() {
    $("[name=check_qx]:checkbox").prop("checked",this.checked);  
});

$("[name=check_qx]:checkbox").each(function() {
	$("[name=check_qx]:checkbox").click(function(){
		var n=$("[name=check_qx]:checkbox").index(this);
		if(n==$("[name=check_qx]:checkbox").length-1){
			$("#qx").prop("checked",true);
		}else {
			$("#qx").prop("checked",false);
		}
	});
});