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

//标签栏
function tb(){
	var tb=$(window).width()-100;
	var h=$(window).height()-136;
	$('.right_tb,.right').css('width',tb);	
	$('.right,.left').css('height',h);
	
	//$('.zx_yy,.sc_yy,.ck_yy').css('height',h);
}
tb();

function cli(){
	$('.right_tb li').click(function(){
		$(this).css({"background":"#dadada","color":"#333"}).siblings().css({"background":"#003333","color":"#fff"});	
	})
	
	$(".tb_gb").click(function(){
		$(this).parent(this).remove()
	})	
//	$('.left a').click(function(){
//		var n=($('.right_tb').width()-100)/120	
//		if($(".right_tb li").length <=n){
//			$('.right_tb li').css({"background":"#003333","color":"#fff"})
//			$(".right_tb").append('<li class="right_zm"><a title="资产" target="zm">资 产</a><img class="tb_gb" src="img/u122_6.png"/></li>')		
//			
//			$('.right_tb li').click(function(){
//				$(this).css({"background":"#dadada","color":"#333"}).siblings().css({"background":"#003333","color":"#fff"});	
//			})
//			$(".tb_gb").click(function(){
//				$(this).parent(this).remove()
//			})
//		}else{
//			alert("标签太多了，可以先删除一些！")	
//		}
//	})
}
cli();		
