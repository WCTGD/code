// JavaScript Document
//删除
function sc(){
	$('table .sc').click(function(){
		var that=this;
		$('.sc_yy').show();
		$('.qr').click(function(){
			$(that).parent().parent().parent().remove();
			$('.sc_yy').hide();
		})
		$('.qx').click(function(){
			$('.sc_yy').hide();
		})	
	})	
	$('#sc_close_img').click(function(){
		$('.sc_yy').hide();	
	})
};
sc();
function hidedelete() {
	 $('.sc_yy').hide();
}
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
//点击tr
function click1(t) {
	$(".data").removeAttr("style");
	$(".check_qx").removeAttr("checked");
	$(t).attr("style", "background-color: #ffff99");
	$("input[type=checkbox]", t).prop("checked", "checked");
}

