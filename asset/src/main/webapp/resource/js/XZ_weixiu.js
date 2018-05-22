// JavaScript Document
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
$('#xzwx,.xg').click(function(){
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

//新建页面下拉
//请求者
$('.xz_qqz img').toggle(function(){
	$('.xz_xl').slideDown();
	$('.xz_xl span').toggle(function(){
		$('.xz_xl li').removeClass('click_bg');
		$(this).parent('li').addClass('click_bg');
		$(this).parent('li').children('ul').slideDown();	
	},function(){
		$(this).parent('li').removeClass('click_bg');
		$(this).parent('li').children('ul').slideUp();		
	})			
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
//位置编号	
$('.xl_inp').toggle(function(){
//	$('.xz_xl1').slideDown();
//	$('.xz_xl1 span').toggle(function(){
//		$('.xz_xl1 li').removeClass('click_bg');
//		$(this).parent('li').addClass('click_bg');
//		$(this).parent('li').children('ul').slideDown();	
//	},function(){
//		$(this).parent('li').removeClass('click_bg');
//		$(this).parent('li').children('ul').slideUp();		
//	})	
},function(){
	$('.xz_xl1').slideUp();	
})
$('.xz_xl1 div').each(function(){
	$(this).click(function(){
		$('.xz_xl1').slideUp();
		
		var ht1=$(this).html();
		$('.xl_inp').val(ht1);
	})
});

//删除
function sc(){
	for(var i = 0;i < $('table .sc').length; i++){
		$('table .sc').eq(i).click(function(){
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

//全选
/*$("#qx").click(function() {
    $("[name=check_qx]:checkbox").prop("checked",this.checked); 
	$('.div_tb tr').removeClass('tr_bg'); 
});*/

//tr点击背景色
$('.div_tb tr').click(function(){
	$('.div_tb tr').removeClass('tr_bg');
	$("#qx").removeAttr("checked");
	$("[name=check_qx]:checkbox").removeAttr("checked");
	$(this).addClass('tr_bg');
	$(this).find("[name=check_qx]:checkbox").prop("checked",true);		
})
/*$('.div_tb tr').toggle(function(){
	$('.div_tb tr').removeClass('tr_bg');
	$("[name=check_qx]:checkbox").removeAttr("checked");
	$(this).addClass('tr_bg');
	$(this).find("[name=check_qx]:checkbox").prop("checked",true);		
},function(){
	$("[name=check_qx]:checkbox").removeAttr("checked");
	$(this).removeClass('tr_bg');
	$(this).find("[name=check_qx]:checkbox").prop("checked",false);	
})*/

   