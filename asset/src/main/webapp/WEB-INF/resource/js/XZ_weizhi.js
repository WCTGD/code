// JavaScript Document
// JavaScript Document
$.fn.toggle = function( fn, fn2 ) {
    var args = arguments,guid = fn.guid || $.guid++,i=0,
    toggle = function( event ) {
      var lastToggle = ( $._data( this, "lastToggle" + fn.guid ) || 0 ) % i;
      $._data( this, "lastToggle" + fn.guid, lastToggle + 1 );
      event.preventDefault();
      return args[ lastToggle ].apply( this, arguments ) || false;
    };
    toggle.guid = guid;
    while ( i < args.length ) {
      args[ i++ ].guid = guid;
    }
    return this.click( toggle );
}

//返回按钮的位置
function tb(){
	/*var all0 = 0;
	var a = $('.content_li').children('ul');
	for(var i=0;i<=a.length;i++){
		all0+=a.eq(i).width()+1;
	}
	$('.content_ul,.content_li,.fh').css('width',all0);
	var all1=$('.content_ul').width()-2;
	$('.t_li').css('width',all1);*/
	//返回按钮的位置
	var tb=$('table').width();
	$('.fh').css('width',tb);
	//新增/修改页面弹窗高度
	var h=$(window).height()-154;
	$('.zx_yy,.sc_yy,.ck_yy').css('height',h);
	var h0=$(window).height()-268;
	$('.xz_div_z').css('height',h0);
	var h1=h0/2
	$('.xz_div_z').css('margin-top',-h1);
	var h2=h0-30;
	$('.xz_div0').css('height',h2);
}
tb();

//展开按钮切换
$('.button_sh').toggle(function(){
	$('.button_sh img').attr('src','img/sousuo_x1.png');
	$('.main').slideUp();	
},function(){
	$('.button_sh img').attr('src','img/sousuo_s1.png');
	$('.main').slideDown();	
})

//新增，修改，查看弹窗
$('#xzwz,.xg').click(function(){
	$('.zx_yy').show();		
})
$('#save,#close,#xz_close_img').click(function(){
	$('.zx_yy').hide();
})

$('.ck').each(function() {
    $(this).click(function(){
		$('.ck_yy').show();	
	})
});
$('#save,#close,#ck_close_img').click(function(){
	$('.ck_yy').hide();
})

//tr点击背景色
$('.div_tb tr').click(function(){
	$('.div_tb tr').removeClass('tr_bg');
	$("#qx").removeAttr("checked");
	$("[name=check_qx]:checkbox").removeAttr("checked");
	$(this).addClass('tr_bg');
	$(this).find("[name=check_qx]:checkbox").prop("checked",true);		
})
