$.ajaxSetup({
	error : function(jqXHR, textStatus, errorThrown) {
		if (jqXHR.status == 403) {
			alert("没有权限");
		}
		if (jqXHR.status == 401) {
			alert("登录超时，请重新登录");
		}
	}
})