// JavaScript Document
$("div[class='ma_ta']").hide();
$("div[class='ma_ta']").eq(0).show();
$(".nav a").click(function(){
	$("input[type='checkbox']").removeAttr('checked');
	var n=$(".nav a").index(this);
	$(".nav a").removeClass("b");
	$(this).addClass("b");	
	$("div[class='ma_ta']").hide();
	$("div[class='ma_ta']").eq(n).show();
	$('#zh_close_img').click(function(){
		$("div[class='ma_ta']").eq(n).hide();
		$(".nav a").removeClass("b");
		$(".nav a").eq(0).addClass("b");
		$("div[class='ma_ta']").eq(0).show();	
	});
});

function tb(){
	//返回按钮的位置
	var tb = $('table').width();
	$('.fh,.nav').css('width',tb);
	//新增/修改页面弹窗高度
	//var h=$(window).height()-154;
	//$('.xcbs_yy,.zh_yy,.sc_yy,.gyck_yy,.zxzc_yy,.xyg_yy,.xwz_yy,.xgys_yy,.cbck_yy').css('height',h);
	var h0=$(window).height()-200;
	$('.xz_div_z,.zh_div_z,.xcbs_div_z').css('height',h0);
	var h1=h0/2;
	$('.xz_div_z,.zh_div_z,.xcbs_div_z').css('margin-top',-h1);
	var h2=h0-30;
	$('.xz_div0,.zh_div0,.xcbs_div').css('height',h2);
}
tb();
//新承包商/修改
$('#xcbs,#cb_xg').click(function(){
	$('.xcbs_yy').show();
	$('.xz_close,.xz_save,.xz_close_img').click(function(){
		$('.xcbs_yy').hide();
	});
});
//查看
$('#cb_ck').click(function(){
	$('.cbck_yy').show();
	$('.ck_close_img').click(function(){
		$('.cbck_yy').hide();
	});
});
//增加
function hh(){
	/*$('.fh_zj').click(function(){
		$('.main_div').append('<input class="main_text" type="text"/>')
	})	
	$('.fh_bc').click(function(){
		$('.main_text').remove();
	})*/
	$('.fh_zj').click(function(){
		$('.main_div input').removeAttr('readonly');
	});
	$('.fh_bc').click(function(){
		$('.main_div input').attr('readonly',true);
	});
}
hh();


//tr点击背景色
$('.ma_ta tr').click(function(){
	$('.ma_ta tr').removeClass('tr_bg');
	$(this).addClass('tr_bg');
	$('.sc').click(function(){
		$('.sc_yy').show();
		$('.qr').click(function(){
			$('.sc_yy').hide();		
		});	
		$('.qx').click(function(){
			$('.sc_yy').hide();	
		});
		$('#sc_close_img').click(function(){
			$('.sc_yy').hide();	
		});
	});
});	
//新资产
$('#xzc').click(function(){
	$('.zxzc_yy').show();
	$('.xz_close_img,.xz_close,.xz_save').click(function(){
		$('.zxzc_yy').hide();	
	});
});
//新员工
$('#xyg').click(function(){
	$('.xyg_yy').show();
	$('.xz_close_img,.xz_close,.xz_save').click(function(){
		$('.xyg_yy').hide();	
	});
});
//新位置
$('#xwz').click(function(){
	$('.xwz_yy').show();
	$('.xz_close_img,.xz_close,.xz_save').click(function(){
		$('.xwz_yy').hide();	
	});	
});
//新供应商/修改
$('#xgys,#gy_xg').click(function(){
	$('.xgys_yy').show();
	$('.xz_close_img,.xz_close,.xz_save').click(function(){
		$('.xgys_yy').hide();	
	});	
});
//新供应商查看
$('#gy_ck').click(function(){
	$('.gyck_yy').show();
	$('.ck_close_img').click(function(){
		$('.gyck_yy').hide();
	});
});
//综合
$('.zh_tj').click(function(){
	//$(this).parent().before('<li><input type="text"/></li>');
	$(this).parent().siblings('.zh_ul1_div').children().append('<li><input type="text"/></li>')
	$('.zh_bc').click(function(){
		$('.zh_ul1 li input').attr("readonly",true);
		$('.zh_ul1 li').click(function(){
			$('.zh_ul1 li').removeClass('tr_bg');
			$(this).addClass('tr_bg');
		});	
	});
});

$('.zh_ul1 li').not('.zh_li2').click(function(){
	$('.zh_ul1 li').removeClass('tr_bg');
	$(this).addClass('tr_bg');
	$('.zh_sc').click(function(){
			$('.sc_yy').show();
		$('.qr').click(function(){
			$('.sc_yy').hide();		
		});	
		$('.qx').click(function(){
			$('.sc_yy').hide();	
		});
		$('#sc_close_img').click(function(){
			$('.sc_yy').hide();	
		});
	});	
});	


