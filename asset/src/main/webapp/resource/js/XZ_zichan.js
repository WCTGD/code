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
	var h=$(window).height()-154;
	$('.zx_yy,.sc_yy,.ck_yy').css('height',h);
	var h0=$(window).height()-268;
	$('.xz_div_z').css('height',h0);
	var h1=h0/2
	$('.xz_div_z').css('margin-top',-h1);
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
//$('#xzzc,.xg').click(function(){
//	$('.zx_yy').show();	
//		
//})
$('#close,#xz_close_img').click(function(){
	$('.zx_yy').hide();
})

$('.ck').each(function() {
    $(this).click(function(){
		$('.ck_yy').show();	
	})
});
$('#ck_close_img').click(function(){
	$('.ck_yy').hide();
})


