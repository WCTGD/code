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

$('#close,#xz_close_img').click(function(){
	$('.zx_yy').hide();
})


$('#close,#ck_close_img').click(function(){
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
