// JavaScript Document
//tr点击背景色
//$('.ul_tb1 li').click(function() {
//	$('.ul_tb1 li').removeClass('tr_bg');
//	$(this).addClass('tr_bg');
//});
// 获取权限菜单
function getSysMenu() {
	$.ajax({
		url : pathName + "/sysMenu/getSysMenu",
		type : "get",
		async : false,
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		success : function(data) {
			$(".ul_tb2").children("a").remove();
			var s = "";
			for (var i = 0; i < data.length; i++) {
				s += "<a id='menu" + data[i].id + "' onclick=detail('menu"
						+ data[i].id + "')>" + data[i].menuName + "</a>";
			}
			for (var i = 0; i < (11 - data.length); i++) {
				s += "<a></a>";
			}
			$(".ul_tb2").append(s);
		}
	});
}

// $(document).ready(function() {
// getSysMenu();
// });

$("div[class='sz_div']").hide();
// $('.ul_tb2 a').click(function() {
// var n = $('.ul_tb2 a').index(this);
// alert(n);
// $('.ul_tb2 a').removeClass('tr_bg');
// $(this).addClass('tr_bg');
// $("div[class='sz_div']").hide();
// $("div[class='sz_div']").eq(n).show();
// });

// 点击权限菜单后，生成对应的权限列表
function detail(data) {
	var menuId = data.replace("menu", "");
	var n = $("#" + data);
	var m = $('.ul_tb2 a').index(n);
	$('.ul_tb2 a').removeClass('tr_bg');
	n.addClass('tr_bg');
	$("div[class='sz_div']").hide();
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
	getRoleHasAuthority($("#roleId").val(), menuId);
}
// 保存
function saveAuthority() {
	var array = "{";
	var roleId = $("#roleId").val();
	$(".sz_div input[type='checkbox']").each(function() {
		if ($(this).attr("id") != undefined) {
			array += "\"" + $(this).attr("id") + "\":\"";
			if ($(this).is(":checked") == true) {
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
		url : pathName + "/authority/saveAuthority",
		type : "post",
		async : false,
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify({
			"aid" : array,
			"rid" : roleId
		}),
		success : function(data) {
			alert(data.message);
		}
	});
}

function save() {
	saveAuthority();
}

function getRoleHasAuthority(rid, menuId) {
	$.ajax({
		url : pathName + "/authority/getRoleAuthority",
		type : "post",
		async : false,
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify({
			"id" : rid,
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
}

// 判断字符串是否以某个字符串结尾
String.prototype.endWith = function(endStr) {
	var d = this.length - endStr.length;
	return (d >= 0 && this.lastIndexOf(endStr) == d);
}

// 获取菜单对应的权限数据
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

pathName = getContextPath();
function getContextPath() {
	fullPath = document.location.pathname;
	var index = fullPath.substr(1).indexOf("/");
	var result = fullPath.substr(0, index + 1);
	return result;
}

//$(document).ajaxError(function() {
//	alert("没有权限");
//	location.href = "/asset/login.html";
//});

$(document).ready(function() {
	getRoleData(1, 10)
});
// 获取权限组信息
function getRoleData(page, pageSize) {
	$.ajax({
		url : pathName + "/authority/getAllRole",
		type : "post",
		async : false,
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify({
			"page" : page,
			"pageSize" : pageSize
		}),
		success : function(data) {
			$("#total").text(data.total);
			$("#currentPage").text(page + "/" + getTotalPage());
			$("#start").text(getStart());
			$("#end").text(getEnd());
			removeLi();
			roleData(data.list);
		}
	});
}
// 获取总页数
function getTotalPage() {
	var total = $("#total").text();
	var pageSize = $("#pageSize").val();
	var totalPage = total / pageSize;
	totalPage = parseInt(totalPage);
	if (totalPage < 1) {
		return 1;
	} else if (total % pageSize == 0) {
		return totalPage;
	} else {
		return totalPage + 1;
	}
}
// 获取当前页
function getCurrentPage() {
	var currentPageStr = $("#currentPage").text();
	var currentPage = (currentPageStr.split("/"))[0];
	return currentPage;
}

// 获取起始行
function getStart() {
	var currentPage = getCurrentPage();
	return (currentPage - 1) * $("#pageSize").val() + 1;
}
// 获取结束行
function getEnd() {
	var currentPage = getCurrentPage();
	var end = currentPage * $("#pageSize").val();
	var total = $("#total").text();
	if (end > total) {
		return total;
	}
	return end;
}
// 跳转页面
$(document).keypress(function(e) {
	// 回车键事件
	if (e.which == 13) {
		var totalPage = getTotalPage();
		var value = $("#jumpPage").val();
		if (value == null || value == "") {
			return;
		}
		if (value > totalPage) {
			value = totalPage;
		}
		getRoleData(value, $("#pageSize").val());
		$("#jumpPage").val('');
	}
});
// 页面大小发生改变时触发一次查询
$("#pageSize").change(function() {
	var pageSize = $("#pageSize").val();
	getRoleData(1, pageSize);
});

// 上一页
function previous() {
	var currentPage = getCurrentPage();
	var pageSize = $("#pageSize").val();
	if (currentPage == 1) {
		alert("已经是第一页了");
		return;
	}
	getRoleData(parseInt(currentPage) - 1, pageSize);
	$("#currentPage").text(parseInt(currentPage) - 1 + "/" + getTotalPage());
}
// 下一页
function next() {
	var currentPage = getCurrentPage();
	var pageSize = $("#pageSize").val();
	var totalPage = getTotalPage();
	if (currentPage == totalPage) {
		alert("已经是最后一页了");
		return;
	}
	getRoleData(parseInt(currentPage) + 1, pageSize);
	$("#currentPage").text(parseInt(currentPage) + 1 + "/" + getTotalPage());
}

// 移除ul_tb1下的11个li标签
function removeLi() {
	var liArray = $(".ul_tb1").children("li");
	for (var i = 0; i < 11; i++) {
		liArray[i].remove();
	}
}
// 拼接ul_tb1下的字符串
function roleData(data) {
	var liArray = $(".td_zg");
	var str = "<li>权限组列表</li>";
	for (var i = 0; i < data.length; i++) {
		str += "<li id='role" + data[i].id + "' onclick='roleLiClickStyle("
				+ data[i].id + ")'>" + data[i].information + "</li>";
	}
	for (var i = 0; i < (10 - data.length); i++) {
		str += "<li></li>";
	}
	liArray.before(str);
}
// 权限组li的点击样式
function roleLiClickStyle(id) {
	$("div[class='sz_div']").hide();
	var liObject = $("#role" + id);
	$("#roleId").val(id);
	$('.ul_tb1 li').removeClass('tr_bg');
	liObject.addClass('tr_bg');
	getSysMenu();
}
