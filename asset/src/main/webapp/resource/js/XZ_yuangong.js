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
//新增，修改，查看弹窗
$('#xzyg,.xg').click(function(){
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

//删除
function sc(){
	for(var i = 0;i < $('table .sc0').length; i++){
		$('table .sc0').eq(i).click(function(){
			var that=this;
			$('.sc_yy').show();
			$("input[type='radio']").removeAttr('checked');
			$("input[type='radio']").click(function(){
				var v=$(this).val();
				if(v == "1"){
					$('.sc_li3 button').click(function(){
						$('.sc_yy').hide();
						$(that).parent().parent().parent().remove();
					});	
				}else if(v == "2"){
					$('.sc_li3 button').click(function(){
						$('.sc_yy').hide();
					});	
				};
			});
		});
	};
};
sc();

$('#sc_close_img').click(function(){
	$('.sc_yy').hide();	
})
//tr点击背景色
$('.ma_ta tr').click(function(){
	$('.ma_ta tr').removeClass('tr_bg');
	$("[name=check_qx]:checkbox").removeAttr("checked");
	$(this).addClass('tr_bg');
	$(this).find("[name=check_qx]:checkbox").prop("checked",true);		
})
