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
function tb(){
	//返回按钮的位置
	var tb=$('table').width();
	$('.fh').css('width',tb);
	//新增/修改页面弹窗高度
	var h0=$(window).height()-200;
	$('.xz_div_z').css('height',h0);
	var h1=h0/2
	$('.xz_div_z').css('margin-top',-h1);
	var h2=h0-30;
	$('.xz_div0').css('height',h2);
}
tb();

/*$('.button_sh').toggle(function(){
	$('.button_sh img').attr('src','img/sousuo_x1.png');
	$('.main').slideUp();	
},function(){
	$('.button_sh img').attr('src','img/sousuo_s1.png');
	$('.main').slideDown();	
})
*/
//新增，修改，查看弹窗
$('#xzwxjh,.xg').click(function(){
	$('.zx_yy').show();		
})
$('#close,#xz_close_img').click(function(){
	$('.zx_yy').hide();
})

$('.ck').each(function() {
    $(this).click(function(){
		$('.ck_yy').show();	
	})
});
$('#close,#ck_close_img').click(function(){
	$('.ck_yy').hide();
})

//tr点击背景色
$('.ma_ta tr').click(function(){
	$('.ma_ta tr').removeClass('tr_bg');
	$("[name=check_qx]:checkbox").removeAttr("checked");
	$(this).addClass('tr_bg');
	$(this).find("[name=check_qx]:checkbox").prop("checked",true);		
})


$('#iu_position').toggle(function(){
//	$('.xz_xl').slideDown();
//	$('.xz_xl span').toggle(function(){
//		$('.xz_xl li').removeClass('click_bg');
//		$(this).parent('li').addClass('click_bg');
//		$(this).parent('li').children('ul').slideDown();	
//	},function(){
//		$(this).parent('li').removeClass('click_bg');
//		$(this).parent('li').children('ul').slideUp();		
//	})			
},function(){
	$('.xz_xl').slideUp();	
})
$('.xz_xl div').each(function() {
	$(this).click(function(){
		$('.xz_xl').slideUp();
		var ht=$(this).html();
		$('#qqz').val(ht);
	})
});
