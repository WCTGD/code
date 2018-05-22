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
function bb(){
	var div_tb0=$('.div_tb0').width();
	$('.bb_top').css("width",div_tb0);
}
bb();

$('div[class="div_tb"]').eq(0).show();
$('.bb_top a').each(function() {
	var n=$('.bb_top a').index(this);
    $(this).click(function(){
		$('.bb_top a,#bb_a0').removeClass('a_bg');
		$(this).addClass('a_bg');
		$('div[class="div_tb1"],.bb_ul').hide();
		$('div[class="div_tb"]').hide();
		$('div[class="div_tb"]').eq(n).show();
		if($(this).html()=="资产"){
			$('#bb_ul3').show();
		}else if($(this).html()=="位置"){
			$('#bb_ul4').show();
		}
	});
});
$('#bb_a0').click(function(){
	$('.bb_ul').hide();
	$('.bb_top a').removeClass('a_bg');
	$(this).addClass('a_bg');
	$(".gd_yy").show();	
	
	$("#bb_tj").click(function(){
		$('div[class="div_tb0"],div[class="div_tb"]').hide();
		$(".gd_yy").hide();
		var m=$("#sele").val();
		if(m=="1"){
			$('#bb_ul2').hide();
			$('#bb_ul1').show();
			$('#tb1_work').show();
			$('#tb1_time').hide();
		}
		else if(m=="2"){
			$('#bb_ul1').hide();
			$('#bb_ul2').show();
			$('#tb1_work').hide();
			$('#tb1_time').show();
		}
		//$('div[class="div_tb1"]').show();
	});
});

//tr点中切换背景色

/*$('.div_tb tr').click(function(){
	$('.div_tb tr').removeClass('tr_bg');
	$(this).addClass('tr_bg');
	$('#yl1').click(function(){
		window.open('5tianyishanggongdan.html');
	});
});*/
//获取项目
var pathName = getContextPath();
function getContextPath() {
	var pathName = document.location.pathname;
	var index = pathName.substr(1).indexOf("/");
	var result = pathName.substr(0, index + 1);
	return result;
}
$(document).ready(function() {
	$(".input-daterange").datepicker({
		format : "yyyy-mm-dd",
		language : "zh-CN",
		keyboardNavigation : false,
		forceParse : false,
		autoclose : true,
	});
	$(".input-date-time").datetimepicker({
		format : "yyyy-mm-dd",
		language : "zh-CN",
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		forceParse : 0,
		showMeridian : 1,
		minuteStep : 10
	});
	$(".input-date-time-h").datetimepicker({
		format : "yyyy-mm-dd",
		language : "zh-CN",
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		forceParse : 0,
		showMeridian : 1,
		minuteStep : 1
	});
});
//日期转化
Date.prototype.Format = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1, //月份 
		"d+" : this.getDate(), //日 
		"h+" : this.getHours(), //小时 
		"m+" : this.getMinutes(), //分 
		"s+" : this.getSeconds(), //秒 
		"q+" : Math.floor((this.getMonth() + 3) / 3), //季度 
		"S" : this.getMilliseconds()
	//毫秒 
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}

//位置结构下拉
$('#wz_w').toggle(function(){
	var wz_w=$('#wz_w').offset().left;
	$('.bb_wz').css('left',wz_w);
	$('.bb_wz').slideDown();
	$('.bb_wz span').toggle(function(){
		$('.bb_wz li').removeClass('click_bg');
		$(this).parent('li').addClass('click_bg');
		$(this).parent('li').children('ul').slideDown();	
	},function(){
		$(this).parent('li').removeClass('click_bg');
		$(this).parent('li').children('ul').slideUp();		
	})	
},function(){
	$('.bb_wz').slideUp();	
});
$('.bb_wz div').each(function(){
	$(this).click(function(){
		$('.bb_wz').slideUp();
		
		var ht1=$(this).html();
		$('#wz_w').val(ht1);
	});
});
/*$('#yl1,#yl2').click(function(){
	$('#yl_yy1').show();
	$('.ck_close_img').click(function(){
		$('#yl_yy1').hide();
	})
});
$('#yl3').click(function(){
	$('#yl_yy2').show();
	$('.ck_close_img').click(function(){
		$('#yl_yy2').hide();
	})
});
$('#yl4').click(function(){
	$('#yl_yy3').show();
	$('.ck_close_img').click(function(){
		$('#yl_yy3').hide();
	})
});
$('#yl5').click(function(){
	$('#yl_yy4').show();
	$('.ck_close_img').click(function(){
		$('#yl_yy4').hide();
	})
});
$('#yl6').click(function(){
	$('#yl_yy5').show();
	$('.ck_close_img').click(function(){
		$('#yl_yy5').hide();
	})
});
$('#yl7').click(function(){
	$('#yl_yy6').show();
	$('.ck_close_img').click(function(){
		$('#yl_yy6').hide();
	})
});*/