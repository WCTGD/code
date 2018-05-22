// JavaScript Document
//角色/用户组信息
$('div[class="gl_1_div2"]').hide();
$('.qx_bc').hide();
$('div[class="gl_1_div2"]').eq(0).show();
$('.gl_1_div1 a').click(function() {
	$('.gl_2').hide();
	$('.qx_bc').hide();
	var n = $('.gl_1_div1 a').index(this);
	$('.gl_1_div1 a').removeClass('a_bg');
	$(this).addClass('a_bg');
	$('div[class="gl_1_div2"]').hide();
	$('div[class="gl_1_div2"]').eq(n).show();
	$('.gl_1_div1 div').hide();
	$('.gl_1_div1 div').eq(n).show();
})
function g() {
	$('.gl_1_div2 li').not(':first').click(function() {
		var li0 = $(this);
		var roleId = li0.attr("id");
		roleId = roleId.replace("workerRole", "");
		$('.gl_1_div2 li').removeClass('tr_bg');
		li0.addClass('tr_bg');
		// 删除
		if (li0 == null || li0 == undefined) {
			return;
		}
		$('.gl_sc').click(function() {
			$('.sc_yy').show();
			$('.qr').click(function() {
				li0.remove();
				$.ajax({
					url : pathName + "/role/deleteWorkerRole",
					type : "post",
					async : false,
					dataType : "json",
					contentType : "application/json;charset=UTF-8",
					data : JSON.stringify({
						"workerId" : $("#workerId").val(),
						"roleId" : roleId
					})
				// ,
				// success : function(data) {
				// alert(data.message);
				// }
				});
				$('.sc_yy').hide();
			});
			$('.qx').click(function() {
				$('.sc_yy').hide();
			});
		});
	});
}

function saveUserAuthority() {
	var array = "{";
	var workerId = $("#workerId").val();
	$(".sz_div input[type='checkbox']").each(
			function() {
				if ($(this).attr("id") != undefined) {
					array += "\"" + $(this).attr("id") + "\":\"";
					if ($(this).is(":checked") == true
							&& $(this).is(":disabled") == false) {
						array += "true\",";
					} else {
						array += "false\",";
					}
				}
			});
	array = array.substring(0, array.length - 1);
	array += "}";
	if (array.length == 1) {
		return;
	}
	$.ajax({
		url : pathName + "/authority/saveUserAuthority",
		type : "post",
		async : false,
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify({
			"aid" : array,
			"uid" : workerId
		}),
		success : function(data) {
			alert(data.message);
		}
	});
}

function save() {
	saveUserAuthority();
}

// 角色用户添加一行
function add(data) {
	var roleId = (data.id).replace("role", "");
	$('#gl_js li').removeClass('tr_bg');
	$(data).addClass('tr_bg');
	$(data).unbind('click');
	var j = $(data).html();
	var lis = $('#gl_li1 ul').children('li');
	for (var i = 0; i < lis.length; i++) {
		if ($(lis[i]).html() == j) {
			return;
		}
	}
	$('#gl_li1 ul').append("<li id='workerRole" + roleId + "'>" + j + "</li>");
	$.ajax({
		url : pathName + "/role/addWorkerRole",
		type : "post",
		async : false,
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify({
			"workerId" : $("#workerId").val(),
			"roleId" : roleId
		})
	});
	g();
}

// $('#gl_js li').click(
// function() {
// $('#gl_js li').removeClass('tr_bg');
// $(this).addClass('tr_bg');
// $(this).unbind('click')
// var j = $(this).html();
// $('#gl_li1 ul').append(
// "<li><input type='text' value=" + j + " readonly></li>");
// g();
// });

// $('#gl_yh li').click(
// function() {
// $('#gl_yh li').removeClass('tr_bg');
// $(this).addClass('tr_bg');
// $(this).unbind('click')
// var j = $(this).html();
// $('#gl_li2 ul').append(
// "<li><input type='text' value=" + j + " readonly></li>");
//
// g();
// });

// 角色添加/修改
function js0() {
	if ($('.gl_1_div1 a').eq(0).hasClass('a_bg')) {
		$('#gl_tj1').click(
				function() {
					$.ajax({
						url : pathName + "/authority/getAllRole",
						type : "post",
						async : false,
						dataType : "json",
						contentType : "application/json;charset=UTF-8",
						data : JSON.stringify({
							"page" : 1,
							"pageSize" : 10000
						}),
						success : function(data) {
							var str = "";
							for ( var i in data.list) {
								str += "<li id='role" + (data.list)[i].id
										+ "' onclick='add(this)'>"
										+ (data.list)[i].information + "</li>"
							}
							$('#gl_js').empty();
							$('#gl_js').append(str);
							$('#gl_js,.gl_2,.qx_bc').show();
							$('#gl_js2').hide();
						}
					});
				});

		// $('#gl_xg1').click(function(){
		// $('#gl_js2,.gl_2').show();
		// $('#gl_js').hide();
		// $("#gl_js2 li").click(function(){
		// $('#gl_js2 li').removeClass('tr_bg');
		// $(this).addClass('tr_bg');
		// });
		// });
	}
}
js0();
$('.gl_1_div1 a').eq(0).click(function() {
	$('#gl_tj1,#gl_xg1').click(function() {
		$('#gl_yh,#gl_qx').hide();
		$('#gl_js,.gl_2,.qx_bc').show();
	});
});
// 拥有权限
$('#yyqx').click(
		function() {
			$('#gl_js,#gl_yh').hide();
			$("div[class='sz_div']").hide();
			$.ajax({
				url : pathName + "/sysMenu/getSysMenu",
				type : "get",
				async : false,
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				success : function(data) {
					var str = "<span>权限菜单</span>";
					for ( var i in data) {
						str += "<a id='menu" + data[i].id
								+ "' onclick=menuDetail('menu" + data[i].id
								+ "')>" + data[i].menuName + "</a>";
					}
					$(".ul_tb2").empty();
					$(".ul_tb2").append(str);
				}
			});
			$('.gl_2,#gl_qx,.qx_bc').show();
		});

function menuDetail(data) {
	var menuId = data.replace("menu", "");
	var n = $("#" + data);
	var m = $('.ul_tb2 a').index(n);
	$('.ul_tb2 a').removeClass('tr_bg');
	n.addClass('tr_bg');
	$("div[class='sz_div']").hide();
	$("div[class='sz_div']").eq(m).show();
	var data = getDetailData(menuId);
	var authorityData = $("div[class='sz_div']").eq(m).empty();
	var str = "<table border='0' cellspacing='0' cellpadding='0'><tbody><tr><td width='10%'><div>菜单</div></td><td width='8%'><div>读取</div></td><td width='8%'><div>查看</div></td><td width='8%'><div>修改</div></td><td width='8%'><div>删除</div></td><td width='8%'><div>新增</div></td></tr>"
	var firstStr = "";
	var finallyStr = "";
	for ( var i in data) {
		if (i.endWith(".html")) {
			firstStr += "<tr><td width='10%'><div>" + data[i].detail.name
					+ "</div></td>";
			firstStr += "<td width='8%'><div><input type='checkbox' id='"
					+ data[i].detail.id + "' /></div></td>";
			firstStr += "<td width='8%'><div><input type='checkbox' disabled /></div></td><td width='8%'><div><input type='checkbox' disabled /></div></td><td width='8%'><div><input type='checkbox' disabled /></div></td><td width='8%'><div><input type='checkbox' disabled /></div></td></tr>"
		} else {
			finallyStr += "<tr>"
			for ( var j in data[i]) {
				finallyStr += "<td><div>" + data[i][j].name + "</div></td>";
				break;
			}
			if (data[i].detail != undefined) {
				finallyStr += "<td width='8%'><div><input type='checkbox' id='"
						+ data[i].detail.id + "' /></div></td>";
			} else {
				finallyStr += "<td width='8%'><div><input type='checkbox' disabled /></div></td>";
			}

			if (data[i].select != undefined) {
				finallyStr += "<td width='8%'><div><input type='checkbox' id='"
						+ data[i].select.id + "' /></div></td>";
			} else {
				finallyStr += "<td width='8%'><div><input type='checkbox' disabled /></div></td>";
			}

			if (data[i].update != undefined) {
				finallyStr += "<td width='8%'><div><input type='checkbox' id='"
						+ data[i].update.id + "' /></div></td>";
			} else {
				finallyStr += "<td width='8%'><div><input type='checkbox' disabled /></div></td>";
			}

			if (data[i].del != undefined) {
				finallyStr += "<td width='8%'><div><input type='checkbox' id='"
						+ data[i].del.id + "' /></div></td>";
			} else {
				finallyStr += "<td width='8%'><div><input type='checkbox' disabled /></div></td>";
			}
			if (data[i].insert != undefined) {
				finallyStr += "<td width='8%'><div><input type='checkbox' id='"
						+ data[i].insert.id + "' /></div></td>";
			} else {
				finallyStr += "<td width='8%'><div><input type='checkbox' disabled /></div></td>";
			}

			finallyStr += "</tr>";
		}
	}
	finallyStr += "</tbody></table>"
	authorityData.empty();
	authorityData.append(str + firstStr + finallyStr);
	authorityData.show();
	getWorkerHasAuthority($("#workerId").val(), menuId);
}

function getWorkerHasAuthority(uid, menuId) {
	$.ajax({
		url : pathName + "/authority/getUserAuthority",
		type : "post",
		async : false,
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify({
			"id" : uid,
			"menuId" : menuId
		}),
		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				id = data[i].id;
				var checkBoxObject = $('#' + id);
				checkBoxObject.attr("checked", true);
			}
		}
	});
	$.ajax({
		url : pathName + "/authority/getAuthority",
		type : "post",
		async : false,
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify({
			"id" : uid
		}),
		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				id = data[i].id;
				var checkBoxObject = $('#' + id);
				checkBoxObject.attr("checked", true);
				checkBoxObject.attr("disabled", true);
			}
		}
	});
}

String.prototype.endWith = function(endStr) {
	var d = this.length - endStr.length;
	return (d >= 0 && this.lastIndexOf(endStr) == d);
}

function getDetailData(id) {
	var authorityData;
	$.ajax({
		url : pathName + "/authority/getAuthorityByMenu",
		type : "post",
		async : false,
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify({
			"id" : id
		}),
		success : function(data) {
			authorityData = data;
		}
	});
	return authorityData;
}

$('.ul_tb2 a').click(
		function() {
			var n = $('.ul_tb2 a').index(this);
			$('.ul_tb2 a').removeClass('tr_bg');
			$(this).addClass('tr_bg');
			$("div[class='sz_div']").hide();
			$("div[class='sz_div']").eq(n).show();
			$('#gl_tj3,#gl_xg3').click(
					function() {
						$('#gl_js,#gl_yh').hide();
						$("div[class='sz_div']").eq(n).find(
								'input[type="checkbox"]').attr('disabled',
								false);
					});
		});
// gl_1，gl_2宽度
function ti() {
	var ti = ($(window) * 0.8) / 2;
	$('.gl_1,.gl_2').css('width', ti);
}
ti();

pathName = getContextPath();
function getContextPath() {
	fullPath = document.location.pathname;
	var index = fullPath.substr(1).indexOf("/");
	var result = fullPath.substr(0, index + 1);
	return result;
}

$(document).ready(function() {
	$.ajax({
		url : pathName + "/role/getWorkerId",
		type : "post",
		async : false,
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		success : function(data) {
			$("#workerId").val(data);
		}
	});
	$.ajax({
		url : pathName + "/role/getWorkerById",
		type : "post",
		async : false,
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify({
			"id" : $("#workerId").val()
		}),
		success : function(data) {
			$("#workerName").val(data.name);
			$("#workerNo").val(data.id);
			$("#department").val(data.department);
			$("#position").val(data.job);
			$("#workerClass").val(data.workerClass);
		}
	});
});

$(document).ready(
		function() {
			$.ajax({
				url : pathName + "/role/getSundryWorkerClass",
				type : "post",
				async : false,
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify({
					"workerId" : $("#workerId").val()
				}),
				success : function(data) {
					if (data.message != undefined) {
						return;
					}
					var str = "";
					for ( var i in data) {
						str += "<li id='workerRole" + data[i].id + "'>"
								+ data[i].information + "</li>";
					}
					$('#gl_li1 ul').append(str);
					g();
				}
			});
		});
