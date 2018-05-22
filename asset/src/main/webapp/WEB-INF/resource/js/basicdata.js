	pathName = getContextPath();
	function getContextPath() {
		fullPath = document.location.pathname;
		var index = fullPath.substr(1).indexOf("/");
		var result = fullPath.substr(0, index + 1);
		return result;
	}

	//邮箱判断
	function EMail() {
		var email = $("#email").val();
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (filter.test(email))
			return true;
		else {
			alert('您的电子邮件格式不正确');
			$("#email").val("");
			return false;
		}
	}

	function telphoneJudge() {
		var telphone = $("#telphone").val();
		if (telphone == null || telphone == "") {
			alert('电话号码	');
		}
		if (!/^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/.test(telphone)) {
			alert('电话格式有误，请重填');
			$("#telphone").val("");
			return false;
		}
	}

	// 部门查询
	function select() {
		var pageCode = $("#pageCode").text();
		var pagesize = $("#pageSize").val();
		$.ajax({
			url : pathName + "/basicData/basicDataList",
			type : "post",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify({
				"pageCode" : pageCode,
				"pageSize" : pagesize
			}),
			success : function(data) {
				var p = data.page;
				$("#pageCode").html(p.pageCode);
				$("#totalRecord").html(p.totalRecord);
				$("#start").html(p.start + 1);
				$("#end").html(p.end);
				$("#totalPage").html(p.totalPage);
				var bDepartment = data.list;
				$("#tb").empty();
				for (var i = 0; i < bDepartment.length; i++) {
					var str = "";
					str += "<tr class='data' onclick=click1(this) id='" + bDepartment[i].no + "'>";
					str += "<td ><div class='main_div' ><input type='text' readonly value='"+bDepartment[i].no+"'/>" + bDepartment[i].no + "</div></td>";
					str += "<td><div class='main_div' value='"+bDepartment[i].department+"'><input type='text' readonly />" + bDepartment[i].department + "</div></td>";
					str += "</tr>";
					$("#tb").append(str);
				}
				if (bDepartment.length < Number(pagesize)) {
					$('#bm').val(pagesize - bDepartment.length);
					for (var i = 0; i < (pagesize - bDepartment.length); i++) {
						var str = "<tr class='trId'><td><div class='main_div'><input type='text' name='saveId' readonly/></div></td><td><div class='main_div'><input type='text' name='saveName' readonly /></div></td></tr>";
						$("#tb").append(str);
					}
				}
			}
		})
	}

	//部门添加按钮
	function addDepartment() {
		//$('input:text').attr("readonly","readonly");//设为只读
		$('.trId:first input').removeAttr("readonly");
	}

	//部门保存
	function saveDepartment() {
		var no = $("*[name='saveId']").val();
		var department = $("*[name='saveName']").val();
		$.ajax({
			url : pathName + "/basicData/saveDepartment",
			type : "post",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify({
				"no" : no,
				"department" : department
			}),
			success : function(data) {
				if (data.judge == "1") {
					$("*[name='saveId']").val("");
					$("*[name='saveName']").val("");
					alert("已存在！");
				}
				select();
			}
		})
	}

	//选中样式 给隐藏文本框赋值
	function click1(t) {
		$(".data").removeAttr("style");
		$(t).attr("style", "background-color: #ffff99");
		$('#hidId').val("");
		$('#hidId').val($(t).children("td").children('div').children('input').val());
	}
	//删除部门
	function deleteDepartment() {
		$('.sc_yy').show(); //从display:none还原元素默认或已设置的display属性
	}

	function decide() {
		var no = $('#hidId').val();
		var zcId = $('#zcId').val();
		var workerId = $('#workerId').val();
		var positionIds = $('#positionIds').val();
		var informationB = $('#swcId').val();
		var information = $('#satId').val();
		var sws = $('#swsId').val();
		var saw = $('#sawId').val();
		var sjp = $('#sjpId').val();
		var sul = $('#sulId').val();
		var troc = $('#trocId').val();
		var delectAc = $('#deleteAssetClassesId').val();
		var supplierOn = $('#supplierOn').val();
		var BaseContractorNo = $('#BaseContractorNo').val();
		if (no == "" && zcId == "" && workerId == "" && positionIds == "" && sws == "" && information == "" && informationB == "" && saw == "" && sjp == "" && sul == "" && troc == "" && delectAc == "" && supplierOn == "" && BaseContractorNo == "") {
			alert("请选中行!");
			$('.sc_yy').hide();
			return;
		}
	}

	$(function() {
		$("#yes").click(function() {
			var no = $('#hidId').val();
			decide();
			$.ajax({
				url : pathName + "/basicData/deleteDepartment",
				type : "post",
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify({
					"no" : no
				}),
				success : function(data) {
					if (data == 2) {
						alert("还有未清理数据！");
					} else if (data == 1) {
						$("tr[id='" + no + "']").remove();
						select();
					}

				}
			})
			$('#hidId').val("");
			select();
			$('.sc_yy').hide();
		});
		$("#cancle").click(function() {
			$('.sc_yy').hide();
			select();
		});
	})

	//前一页(部门查询)
	function before() {
		var a = $("#pageCode").html();
		if (a > 1) {
			$("#pageCode").html(a - 1);
			select();
		} else {
			alert("已经是第一页了")
		}
	}
	//后一页(部门查询)	
	function after() {
		var b = $("#totalPage").html();
		var a = $("#pageCode").html();
		if (a < b) {
			$("#pageCode").html(Number(a) + 1);
			select();
		} else {
			alert("已经是最后一页了");
		}

	}

	//跳转(部门查询)
	function skip() {
		var skipId = $(".skipId").val();
		var b = $("#totalPage").html();
		if (skipId <= b && skipId != 0 && !isNaN(b)) {
			$("#pageCode").html(skipId);
			select();
		} else {
			alert("不存在！");
			$('#skipId').val("");
		}
	}

	//每页显示的下拉框(部门查询)
	function strike() {
		var size = $("#pageSize").val();
		$("#pageSize").val(size);
		select();
	}

	//资产查询
	function selectAssets() {
		var pageCode_zc = $("#pageCode_zc").text();
		var pagesize_zc = $("#pageSize_zc").val();
		$.ajax({
			url : pathName + "/basicData/basicDataListAssets",
			type : "post",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify({
				"pageCode" : pageCode_zc,
				"pageSize" : pagesize_zc
			}),
			success : function(data) {
				var p = data.page;
				$("#pageCode_zc").html(p.pageCode);
				$("#totalRecord_zc").html(p.totalRecord);
				$("#start_zc").html(p.start + 1);
				$("#end_zc").html(p.end);
				$("#totalPage_zc").html(p.totalPage);
				var assets = data.list;
				$("#tb_zc").empty();
				for (var i = 0; i < assets.length; i++) {
					var str = "";
					str += "<tr class='data' onclick=click2(this) id='" + assets[i].no + "'>";
					str += "<td><div class='main_div'><input type='text' readonly value='"+assets[i].no+"'/>" + assets[i].no + "</div></td>";
					str += "<td><div class='main_div'>" + assets[i].assetDesc + "</div></td>";
					str += "</tr>";
					$("#tb_zc").append(str);
				}
				if (assets.length < Number(pagesize_zc)) {
					for (var i = 0; i < (pagesize_zc - assets.length); i++) {
						var str = "<tr><td><div class='main_div'></div></td><td><div class='main_div'></div></td></tr>";
						$("#tb_zc").append(str);
					}
				}
			}
		})
	}

	//前一页(资产)
	function before_zc() {
		var a = $("#pageCode_zc").html();
		if (a > 1) {
			$("#pageCode_zc").html(a - 1);
			selectAssets();
		} else {
			alert("已经是第一页了")
		}
	}
	//后一页(资产)
	function after_zc() {
		var b = $("#totalPage_zc").html();
		var a = $("#pageCode_zc").html();
		if (a < b) {
			$("#pageCode_zc").html(Number(a) + 1);
			selectAssets();
		} else {
			alert("已经是最后一页了");
		}

	}

	//跳转(资产)
	function skip_zc() {
		var skipId = $("#skipId_zc").val();
		var b = $("#totalPage_zc").html();
		if (skipId <= b && skipId != 0) {
			$("#pageCode_zc").html(skipId);
			selectAssets();
		} else {
			alert("不存在！");
		}
	}

	//每页显示的下拉框 (资产)
	function strike_zc() {
		var size = $("#pageSize_zc").val();
		$("#pageSize_zc").val(size);
		selectAssets();
	}

	//查询员工信息
	function selectworker(current, size) {
		//var pageCode_yg = $("#current").text();
		var pagesize_yg = $("#size").val();
		$.ajax({
			url : pathName + "/worker/list",
			type : "post",
			dataType : "json",
			data : {
				"current" : current,
				"size" : size
			},
			success : function(data) {
				// 				var str;
				var result = data.data;
				//两次分页的数据连在一起,先将之前的删掉;
				$(".d").empty();
				// 				for(var i in result){
				// 					var w=result[i];
				//         			str+= "<tr class='d'><td><div  class='main_div'>"+
				// 		            w.no+"</div></td><td><div  class='main_div'>"+w.name+"</div></td></tr>"
				// 				}
				for (var i = 0; i < result.length; i++) {
					var str = "";
					str += "<tr class='d' onclick=click3(this) id='" + result[i].no + "'>";
					str += "<td><div  class='main_div'><input type='text' readonly value='"+result[i].no+"'/>" + result[i].no + "</div></td>";
					str += "<td><div  class='main_div'>" + result[i].name + "</div></td>";
					str += "</tr>";
					$("#tb_yg").append(str);
				}
				if (result.length < Number(pagesize_yg)) {
					for (var j = 0; j < (pagesize_yg - result.length); j++) {
						var str = "<tr class='d'><td><div class='main_div'></div></td><td><div class='main_div'></div></td></tr>";
						$("#tb_yg").append(str);
					}
				}

				//如果总记录数小于每页显示的条数,隐藏分页
				if (data.page.total < data.page.size) {
					$(".t_div2").hide();
				} else {
					$(".t_div2").show();
				}
				//当前页
				$("#current").text(data.page.current);
				//总页数
				$("#pages").text(data.page.pages);
				//总记录数
				$("#total").text(data.page.total);
				//当前页显示数量的起始位置
				$("#start_yg").text(data.page.start);
				//当前页显示数量的结束位置
				$("#end_yg").text(data.page.end);
			}
		})
	}

	$(function() {
		var size = parseInt($("#size").val());
		//向左的箭头(上一页)
		var prev = $("#wo img:first");
		//向右的箭头(下一页)
		var next = $("#wo img:last");
		//点击向左的箭头;
		prev.click(function() {
			var current = parseInt($("#current").text());
			var size = parseInt($("#size").val())
			//当前页减去1(如果当前为第一页,当前页为1,不能在减1)
			if (current <= 1) {
				current = 1
			} else {
				current = current - 1;
			}
			selectworker(current, size);
		});
		//点击向右的箭头;
		next.click(function() {
			var current = parseInt($("#current").text());
			var size = parseInt($("#size").val())
			var pages = $("#pages").text();
			//当前页加上1(如果当前为最后一页,当前页为最后一页,不能在加1)
			if (current >= pages) {
				current = pages
			} else {
				current = current + 1;
			}
			selectworker(current, size);
		})

		//修改每页显示数量
		$("#size").change(function() {
			var size = $(this).val();
			selectworker(1, size);
		})

		$("#go").keypress(function(event) {
			if (event.keyCode == 13) {
				//跳转页码
				var go = $("#go").val();

				var reg = new RegExp("^[0-9]*$");
				//判断输入是否为数字
				if (!reg.test(go)) {
					alert("输入无效,请输入数字!");
					return;
				}

				var pages = parseInt($("#pages").text());
				//输入的页面大于总页数
				if (pages < go) {
					alert("输入无效!");
					return;
				}

				selectworker(go, size);
			}
		})
	})

	//选中样式 给隐藏文本框赋值（员工）
	function click3(t) {
		$(".d").removeAttr("style");
		$(t).attr("style", "background-color: #ffff99");
		$('#workerId').val("");
		$('#workerId').val($(t).children("td").children('div').children('input').val());
	}
	//删除员工
	function deleteWorker() {
		$('.sc_yy').show(); //从display:none还原元素默认或已设置的display属性
	}

	$(function() {
		$("#yes").click(function() {
			var no = $('#workerId').val();
			$.ajax({
				url : pathName + "/basicData/deleteWorkerByNo",
				type : "post",
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify({
					"no" : no
				})
			})
			$('#zcId').val("");
			selectworker();
			$('.sc_yy').hide();
		});
		$("#cancle").click(function() {
			$('.sc_yy').hide();
			selectworker();
		});
	})

	// 查询位置
	function selectPosition() {
		var pageCode = $("#pageCode_wz").text();
		var pagesize = $("#pageSize_wz").val();
		$.ajax({
			url : pathName + "/position/positionList",
			type : "post",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify({
				"pageCode" : pageCode,
				"pageSize" : pagesize
			}),
			success : function(data) {
				var p = data.page;
				$("#pageCode_wz").html(p.pageCode);
				$("#totalRecord_wz").html(p.totalRecord);
				$("#start_wz").html(p.start + 1);
				$("#end_wz").html(p.end);
				$("#totalPage_wz").html(p.totalPage);
				var position = data.list;
				$("#tb_wz").empty();
				for (var i = 0; i < position.length; i++) {
					var str = "";
					str += "<tr class='data' onclick=clickPosition(this) id='" + position[i].aNo + "'>";
					str += "<td><div class='main_div'><input type='text' readonly value='"+position[i].aNo+"'/>" + position[i].aNo + "</div></td>";
					str += "<td><div class='main_div'>" + position[i].position + "</div></td>";
					str += "</tr>";
					$("#tb_wz").append(str);
				}
				if (position.length < Number(pagesize)) {
					for (var j = 0; j < (pagesize - position.length); j++) {
						var str = "<tr><td><div  class='main_div'></div></td><td><div  class='main_div'></div></td></tr>";
						$("#tb_wz").append(str);
					}
				}
			}
		})
	}

	//选中样式 给隐藏文本框赋值（位置）
	function clickPosition(t) {
		$(".data").removeAttr("style");
		$(t).attr("style", "background-color: #ffff99");
		$('#positionIds').val("");
		$('#positionIds').val($(t).children("td").children('div').children('input').val());
	}

	//删除位置
	function deletePosition() {
		$('.sc_yy').show(); //从display:none还原元素默认或已设置的display属性
	}

	$(function() {
		$("#yes").click(function() {
			var no = $('#positionIds').val();
			$.ajax({
				url : pathName + "/basicData/deletePosition",
				type : "post",
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify({
					"no" : no
				}),
				success : function(data) {
					if (data == 1) {
						$("tr[id='" + no + "']").remove();
						selectPosition();
					} else if (data == 2) {
						alert("请先清除相关数据!");
					}
				}
			})
			$('#positionIds').val("");
			selectPosition();
			$('.sc_yy').hide();
		});
		$("#cancle").click(function() {
			$('.sc_yy').hide();
			selectPosition();
		});
	})

	//前一页(位置)
	function before_wz() {
		var a = $("#pageCode_wz").html();
		if (a > 1) {
			$("#pageCode_wz").html(a - 1);
			selectPosition();
		} else {
			alert("已经是第一页了")
		}
	}
	//后一页(位置)
	function after_wz() {
		var b = $("#totalPage_wz").html();
		var a = $("#pageCode_wz").html();
		if (a < b) {
			$("#pageCode_wz").html(Number(a) + 1);
			selectPosition();
		} else {
			alert("已经是最后一页了");
		}

	}

	//跳转(位置)
	function skip_wz() {
		var skipId = $("#skipId_wz").val();
		var b = $("#totalPage_wz").html();
		if (skipId <= b && skipId != 0) {
			$("#pageCode_wz").html(skipId);
			selectPosition();
		} else {
			alert("不存在！");
		}
	}

	//每页显示的下拉框 (位置)
	function strike_wz() {
		var size = $("#pageSize_wz").val();
		$("#pageSize_wz").val(size);
		selectPosition();
	}

	// 	//资产类别
	// 	function selectAssetClasses(){
	// 		var pageCode = $("#pageCode_ac").text();
	// 		var pagesize = $("#pageSize_ac").val();
	// 		$.ajax({
	// 			url : pathName + "/basicData/basicDataListAssetClass",
	// 			type : "post",
	// 			dataType : "json",
	// 			contentType : "application/json;charset=UTF-8",
	// 			data:JSON.stringify({
	// 				"pageCode":pageCode,
	// 				"pageSize":pagesize
	// 			}),
	// 			success : function(data) {
	// 				var p=data.page;
	// 				$("#pageCode_ac").html(p.pageCode);
	// 				$("#totalRecord_ac").html(p.totalRecord);
	// 				$("#start_ac").html(p.start+1);
	// 				$("#end_ac").html(p.end);
	// 				$("#totalPage_ac").html(p.totalPage);
	// 				var basicData = data.list;
	// 				$("#tb_ac").empty();
	// 				for (var i = 0; i < basicData.length; i++) {
	// 					var str = "";
	// 					str += "<tr class='data' onclick=clickAssetClasses(this) id='"+basicData[i].no+"'>";
	// 					str += "<td><div class='main_div'><input type='text' readonly value='"+basicData[i].no+"'/>"+basicData[i].no+"</div></td>";
	// 					str += "<td><div class='main_div' value='"+basicData[i].assetCategory+"'><input type='text' readonly />"+basicData[i].assetCategory+"</div></td>";
	// 					str += "</tr>";
	// 					$("#tb_ac").append(str);
	// 				}
	// 				if(basicData.length< Number(pagesize)){
	// 					for(var j=0; j<(pagesize-basicData.length);j++){
	// 						var str = "<tr class='acId'><td><div  class='main_div'><input type='text' name='saveAc' readonly/></div></td><td><div class='main_div'><input type='text' name='saveAcName' readonly /></div></td></tr>";
	// 						$("#tb_ac").append(str);
	// 					}
	// 				}
	// 			}
	// 		})
	// 	}

	// 	//前一页(资产类别)
	// 	function before_ac(){
	// 		var a = $("#pageCode_ac").html();
	// 		if(a>1){
	// 			$("#pageCode_ac").html(a-1);
	// 			selectAssetClasses();
	// 		}else{
	// 			alert("已经是第一页了")
	// 		}
	// 	}
	// 	//后一页(资产类别)
	// 	function after_ac(){
	// 		var b =$("#totalPage_ac").html();
	// 		var a=$("#pageCode_ac").html();
	// 		if(a<b){
	// 			$("#pageCode_ac").html(Number(a)+1);
	// 			selectAssetClasses();
	// 		}else{
	// 			alert("已经是最后一页了");
	// 		}

	// 	}

	// 	//跳转(资产类别)
	// 	function skip_ac(){
	// 		var skipId= $("#skipId_ac").val();
	// 		var b =$("#totalPage_ac").html();
	// 		if(skipId<=b && skipId != 0){
	// 			$("#pageCode_ac").html(skipId);
	// 			selectAssetClasses();
	// 		}else{
	// 			alert("不存在！");
	// 			$("#skipId_ac").val("");
	// 		}
	// 	}

	// 	//每页显示的下拉框 (资产类别)
	// 	function strike_ac(){
	// 		var size= $("#pageSize_ac").val();
	// 		$("#pageSize_ac").val(size);
	// 		selectAssetClasses();
	// 	}

	// 	//添加资产类别
	// 	function addAssetClasses(){
	// 		//$('input:text').attr("readonly","readonly");//设为只读
	// 		$('.acId:first input').removeAttr("readonly");
	// 	}

	// 	//保存 资产类别
	// 	function saveAssetClasses(){
	// 		var no=$("*[name='saveAc']").val();
	// 		var assetCategory=$("*[name='saveAcName']").val();
	// 		$.ajax({
	// 			url : pathName + "/basicData/saveAssetClasses",
	// 			type : "post",
	// 			dataType : "json",
	// 			contentType : "application/json;charset=UTF-8",
	// 			data:JSON.stringify({
	// 				"no":no,
	// 				"assetCategory":assetCategory
	// 			}),
	// 			success : function (data){
	// 				if(data.judge == "1" ){
	// 					$("*[name='saveAc']").val("");
	// 					$("*[name='saveAcName']").val("");
	// 					alert("已存在！");
	// 				}
	// 				selectAssetClasses();
	// 			}
	// 		})
	// 	}

	// 	//选中样式 给隐藏文本框赋值（资产类别）
	// 	function clickAssetClasses(t){
	// 		$(".data").removeAttr("style");
	// 		$(t).attr("style", "background-color: #ffff99");
	// 		$('#deleteAssetClassesId').val("");
	// 		$('#deleteAssetClassesId').val($(t).children("td").children('div').children('input').val());
	// 	}

	// 	//删除 资产类别
	// 	function deleteAssetClasses(){
	// 		$('.sc_yy').show(); //从display:none还原元素默认或已设置的display属性
	// 	}

	// 	$(function(){
	// 		$("#yes").click(function(){
	// 			var no = $('#deleteAssetClassesId').val();
	// 			$.ajax({
	// 				url : pathName + "/basicData/deleteAssetClasses",
	// 				type : "post",
	// 				dataType : "json",
	// 				contentType : "application/json;charset=UTF-8",
	// 				data:JSON.stringify({
	// 					"no":no
	// 				}),
	// 				success : function(data){
	// 					$("tr[id='"+no+"']").remove();
	// 				}
	// 			})
	// 			$('#deleteAssetClassesId').val(""); 
	// 			$('.sc_yy').hide();
	// 		});
	// 		$("#cancle").click(function(){
	// 			$('.sc_yy').hide();
	// 			selectPosition();
	// 		});
	// 	})

	//供应商
	function selectSupplier() {
		var pageCode = $("#pageCode_gys").text();
		var pagesize = $("#pageSize_gys").val();
		$.ajax({
			url : pathName + "/basicData/basicDataListSupplier",
			type : "post",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify({
				"pageCode" : pageCode,
				"pageSize" : pagesize
			}),
			success : function(data) {
				var p = data.page;
				$("#pageCode_gys").html(p.pageCode);
				$("#totalRecord_gys").html(p.totalRecord);
				$("#start_gys").html(p.start + 1);
				$("#end_gys").html(p.end);
				$("#totalPage_gys").html(p.totalPage);
				var basicData = data.list;
				$("#tb_gys").empty();
				for (var i = 0; i < basicData.length; i++) {
					var str = "";
					str += "<tr class='data' onclick=clickSupplier(this) id='" + basicData[i].no + "'>";
					str += "<td><div class='main_div'>" + basicData[i].no + "</div></td>";
					str += "<td><div class='main_div'>" + basicData[i].supplierName + "</div></td>";
					str += "</tr>";
					$("#tb_gys").append(str);
				}
				if (basicData.length < Number(pagesize)) {
					for (var j = 0; j < (pagesize - basicData.length); j++) {
						var str = "<tr><td><div  class='main_div'></div></td><td><div class='main_div'></div></td></tr>";
						$("#tb_gys").append(str);
					}
				}
				$('.gy_xg').bind("click", function() {
					$('.xgys_yy').show();
				})
			}
		})
	}

	//前一页(供应商)
	function before_gys() {
		var a = $("#pageCode_gys").html();
		if (a > 1) {
			$("#pageCode_gys").html(a - 1);
			selectSupplier();
		} else {
			alert("已经是第一页了")
		}
	}
	//后一页(供应商)
	function after_ac() {
		var b = $("#totalPage_gys").html();
		var a = $("#pageCode_gys").html();
		if (a < b) {
			$("#pageCode_gys").html(Number(a) + 1);
			selectSupplier();
		} else {
			alert("已经是最后一页了");
		}

	}

	//跳转(供应商)
	function skip_gys() {
		var skipId = $("#skipId_gys").val();
		var b = $("#totalPage_gys").html();
		if (skipId <= b && skipId != 0) {
			$("#pageCode_gys").html(skipId);
			selectSupplier();
		} else {
			alert("不存在！");
			$("#skipId_gys").val("");
		}
	}

	//每页显示的下拉框 (供应商)
	function strike_gys() {
		var size = $("#pageSize_gys").val();
		$("#pageSize_gys").val(size);
		selectSupplier();
	}

	//供应商  单机触发选中
	function clickSupplier(t) {
		$(".data").removeAttr("style");
		$(t).attr("style", "background-color: #ffff99");
		$('#supplierOn').val("");
		$('#supplierOn').val(t.id);
	}

	//删除 供应商
	function deleteSupplierByNo() {
		$('.sc_yy').show(); //从display:none还原元素默认或已设置的display属性
	}

	$(function() {
		$("#yes").click(function() {
			var no = $('#supplierOn').val();
			$.ajax({
				url : pathName + "/basicData/supplierDelectByNo",
				type : "post",
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify({
					"no" : no
				}),
				success : function(data) {
					if (data == 0) {
						alert("请先清除相关联数据!");
					} else if (data == 3) {
						$("tr[id='" + no + "']").remove();
					}

				}
			})
			$('#supplierOn').val("");
			$('.sc_yy').hide();
		});
		$("#cancle").click(function() {
			$('.sc_yy').hide();
			selectSupplier();
		});
	})

	//供应商 查看
	function supplierSelectByOn() {
		$(".ck_span2").empty();
		var no = $("#supplierOn").val();
		$.ajax({
			url : pathName + "/basicData/supplierSelectByOn",
			type : "post",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify({
				"no" : no
			}),
			success : function(data) {
				var data = data.supplier;//ck_span2
				if (data.no != null) {
					$(".ck_span2").eq(0).text(data.no);//编号
				} else {
					$(".ck_span2").eq(0).text();
				}
				if (data.supplierName != null) {
					$(".ck_span2").eq(1).text(data.supplierName);//供应商名称
				} else {
					$(".ck_span2").eq(1).text();
				}
				if (data.contactJob != null) {
					$(".ck_span2").eq(2).text(data.contactJob);//联系人职位
				} else {
					$(".ck_span2").eq(2).text();
				}
				if (data.contactName != null) {
					$(".ck_span2").eq(3).text(data.contactName);//联系人
				} else {
					$(".ck_span2").eq(3).text();
				}
				if (data.email != null) {
					$(".ck_span2").eq(4).text(data.email);//邮箱
				} else {
					$(".ck_span2").eq(4).text();
				}
				if (data.telphone != null) {
					$(".ck_span2").eq(5).text(data.telphone);//电话
				} else {
					$(".ck_span2").eq(5).text();
				}
				if (data.province != null) {
					$(".ck_span2").eq(6).text(data.province);//省
				} else {
					$(".ck_span2").eq(6).text();
				}
				if (data.city != null) {
					$(".ck_span2").eq(7).text(data.city);//市
				} else {
					$(".ck_span2").eq(7).text();
				}
				if (data.zipCode != null) {
					$(".ck_span2").eq(8).text(data.zipCode); //邮编
				} else {
					$(".ck_span2").eq(8).text();
				}
				if (data.country != null) {
					$(".ck_span2").eq(9).text(data.country);//国家
				} else {
					$(".ck_span2").eq(9).text();
				}
				if (data.fax != null) {
					$(".ck_span2").eq(10).text(data.fax);//传真号码
				} else {
					$(".ck_span2").eq(10).text();
				}
				$(".ck_span2").eq(11).text();
				if (data.contactAddress != null) {
					$(".ck_span2").eq(12).text(data.contactAddress);//联系人地址
				} else {
					$(".ck_span2").eq(12).text();
				}
				if (data.service != null) {
					$(".ck_span2").eq(13).text(data.service);//服务
				} else {
					$(".ck_span2").eq(13).text();
				}
			}
		})
	}

	//供应商 add
	function addSupplier() {
		supplierNull();
		$.ajax({
			url : pathName + "/basicData/addSupplier",
			type : "post",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				var data = data.stitchingNumber;
				$("#supplierNo").val(data.no);
			}
		})
	}

	function supplierNull() {
		$("#supplierNo").val("");
		$("#supplierName").val("");
		$("#country").val("");
		$("#province").val("");
		$("#city").val("");
		$("#zipCode").val("");
		$("#telphone").val("");
		$("#fax").val("");
		$("#email").val("");
		$("#contactName").val("");
		$("#contactJob").val("");
		$("#contactAddress").val("");
		$("#service").val("");
	}

	// 供应商添加提交
	function form_add_Supplier() {
		$("#formSupplier")[0].action = pathName + '/basicData/supplierInsert';
		$("#formSupplier")[0].submit();
	}

	// 供应商update提交
	function form_update_Supplier() {
		$("#formSupplierUpdate")[0].action = pathName + '/basicData/supplierUpdate';
		$("#formSupplierUpdate")[0].submit();
	}

	function shutDown() {
		$("#formSupplierUpdate")[0].action = pathName + '/basicData/supplierUpdate';
		$("#formSupplierUpdate")[0].submit();
	}

	function updateSupplier() {
		var no = $("#supplierOn").val();
		if (no != null && no != "") {
			$.ajax({
				url : pathName + '/basicData/supplierSelectByOn',
				type : "post",
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify({
					"no" : no
				}),
				success : function(data) {
					var data = data.supplier;
					$("#update_supplierNo").val(data.no);
					$("#update_supplierName").val(data.supplierName);
					$("#update_country").val(data.country);
					$("#update_province").val(data.province);
					$("#update_city").val(data.city);
					$("#update_zipCode").val(data.zipCode);
					$("#update_telphone").val(data.telphone);
					$("#update_fax").val(data.fax);
					$("#update_email").val(data.email);
					$("#update_contactName").val(data.contactName);
					$("#update_contactJob").val(data.contactJob);
					$("#update_contactAddress").val(data.contactAddress);
					$("#update_service").val(data.service);
				}
			})
			$('.gy_xg').bind("click", function() {
				$('.xgys_yy').show();
			})
		} else {
			alert("请选中！");
			$('.gy_xg').bind("click", function() {
				$('.xgys_yy').hide();
			})
		}
	}

	//承包商
	function selectBaseContractor() {
		var pageCode = $("#pageCode_bc").text();
		var pagesize = $("#pageSize_bc").val();
		$.ajax({
			url : pathName + "/basicData/basicDataListBaseContractor",
			type : "post",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify({
				"pageCode" : pageCode,
				"pageSize" : pagesize
			}),
			success : function(data) {
				var p = data.page;
				$("#pageCode_bc").html(p.pageCode);
				$("#totalRecord_bc").html(p.totalRecord);
				$("#start_bc").html(p.start + 1);
				$("#end_bc").html(p.end);
				$("#totalPage_bc").html(p.totalPage);
				var basicData = data.list;
				$("#tb_bc").empty();
				for (var i = 0; i < basicData.length; i++) {
					var str = "";
					str += "<tr class='data' onclick=clickBaseContractor(this) id='" + basicData[i].no + "'>";
					str += "<td><div class='main_div'>" + basicData[i].no + "</div></td>";
					str += "<td><div class='main_div'>" + basicData[i].name + "</div></td>";
					str += "</tr>";
					$("#tb_bc").append(str);
				}
				if (basicData.length < Number(pagesize)) {
					for (var j = 0; j < (pagesize - basicData.length); j++) {
						var str = "<tr><td><div  class='main_div'></div></td><td><div class='main_div'></div></td></tr>";
						$("#tb_bc").append(str);
					}
				}
				$('.cb_xg').bind("click", function() {
					$('.xgys_yy').show();
				})
			}
		})
	}

	//前一页(承包商)
	function before_bc() {
		var a = $("#pageCode_bc").html();
		if (a > 1) {
			$("#pageCode_bc").html(a - 1);
			selectBaseContractor();
		} else {
			alert("已经是第一页了")
		}
	}
	//后一页(承包商)
	function after_bc() {
		var b = $("#totalPage_bc").html();
		var a = $("#pageCode_bc").html();
		if (a < b) {
			$("#pageCode_bc").html(Number(a) + 1);
			selectBaseContractor();
		} else {
			alert("已经是最后一页了");
		}

	}

	//跳转(承包商)
	function skip_bc() {
		var skipId = $("#skipId_bc").val();
		var b = $("#totalPage_bc").html();
		if (skipId <= b && skipId != 0) {
			$("#pageCode_bc").html(skipId);
			selectBaseContractor();
		} else {
			alert("不存在！");
			$("#skipId_bc").val("");
		}
	}

	//每页显示的下拉框 (承包商)
	function strike_bc() {
		var size = $("#pageSize_bc").val();
		$("#pageSize_bc").val(size);
		selectBaseContractor();
	}

	//承包商  单机触发选中
	function clickBaseContractor(t) {
		$(".data").removeAttr("style");
		$(t).attr("style", "background-color: #ffff99");
		$('#BaseContractorNo').val("");
		$('#BaseContractorNo').val(t.id);
	}

	//删除 承包商
	function deleteBaseContractorByNo() {
		$('.sc_yy').show(); //从display:none还原元素默认或已设置的display属性
	}

	$(function() {
		$("#yes").click(function() {
			var no = $('#BaseContractorNo').val();
			$.ajax({
				url : pathName + "/basicData/updateBaseContractorByNo",
				type : "post",
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify({
					"no" : no
				}),
				success : function(data) {
					alert(data);
					if (data == 0) {
						alert("请先清理相关数据!");
					} else if (data == 1) {
						$("tr[id='" + no + "']").remove();
					}
				}
			})
			$('#BaseContractorNo').val("");
			$('.sc_yy').hide();
		});
		$("#cancle").click(function() {
			$('.sc_yy').hide();
		});
	})

	// 承包商  提交
	function form_insert_BaseContractor() {
		$("#formBaseContractor")[0].action = pathName + '/basicData/baseContractorInsert';
		$("#formBaseContractor")[0].submit();
	}
	// 承包商  提交
	function form_update_BaseContractor() {
		$("#formBaseContractorUpdate")[0].action = pathName + '/basicData/baseContractorUpdate';
		$("#formBaseContractorUpdate")[0].submit();
	}

	function shutDown_BaseContractor() {
		$("#formBaseContractorUpdate")[0].action = pathName + '/basicData/baseContractorUpdate';
		$("#formBaseContractorUpdate")[0].submit();
	}

	//承包商 add
	function addBaseContractorByNo() {
		$.ajax({
			url : pathName + "/basicData/addbaseContractor",
			type : "post",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				var data = data.baseContractor;
				$("#BContractorNo").val(data.no);
			}
		})
	}

	//承包商 查看
	function baseContractorSelectByOn() {
		$(".ck_span2").empty();
		var no = $("#BaseContractorNo").val();
		$.ajax({
			url : pathName + "/basicData/selectBaseContractorByNo",
			type : "post",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify({
				"no" : no
			}),
			success : function(data) {
				var data = data.list;
				if (data.no != null) {
					$(".ck_span2").eq(14).text(data.no);//编号
				} else {
					$(".ck_span2").eq(14).text();
				}
				if (data.name != null) {
					$(".ck_span2").eq(15).text(data.name);//供应商名称
				} else {
					$(".ck_span2").eq(15).text();
				}
				if (data.contactName != null) {
					$(".ck_span2").eq(16).text(data.contactName);//联系人
				} else {
					$(".ck_span2").eq(16).text();
				}
				if (data.email != null) {
					$(".ck_span2").eq(17).text(data.email);//邮箱
				} else {
					$(".ck_span2").eq(17).text();
				}
				if (data.telphone != null) {
					$(".ck_span2").eq(18).text(data.telphone);//电话
				} else {
					$(".ck_span2").eq(18).text();
				}
				if (data.province != null) {
					$(".ck_span2").eq(19).text(data.province);//省
				} else {
					$(".ck_span2").eq(19).text();
				}
				if (data.city != null) {
					$(".ck_span2").eq(20).text(data.city);//市
				} else {
					$(".ck_span2").eq(20).text();
				}
				if (data.fax != null) {
					$(".ck_span2").eq(21).text(data.fax);//传真号码
				} else {
					$(".ck_span2").eq(21).text();
				}
				$(".ck_span2").eq(11).text();
				if (data.address != null) {
					$(".ck_span2").eq(22).text(data.address);//地址
				} else {
					$(".ck_span2").eq(22).text();
				}
				if (data.service != null) {
					$(".ck_span2").eq(23).text(data.service);//服务
				} else {
					$(".ck_span2").eq(23).text();
				}
			}
		})
	}

	function updateBaseContractor() {
		var no = $('#BaseContractorNo').val();
		if (no != null && no != "") {
			$.ajax({
				url : pathName + '/basicData/selectBaseContractorByNo',
				type : "post",
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify({
					"no" : no
				}),
				success : function(data) {
					var data = data.list;

					$("#BContractorNo_update").val(data.no);
					$("#name_update").val(data.name);
					$("#province_update").val(data.province);
					$("#city_update").val(data.city);
					$("#telphone_update").val(data.telphone);
					$("#fax_update").val(data.fax);
					$("#email_update").val(data.email);
					$("#contactName_update").val(data.contactName);
					$("#address_update").val(data.address);
					$("#service_update").val(data.service);
				}
			})
			$('.gy_xg').bind("click", function() {
				$('.xgys_yy').show();
			})
		} else {
			alert("请选中！");
			$('.gy_xg').bind("click", function() {
				$('.xgys_yy').hide();
			})
		}
	}

	// 	function updateBaseContractorByNo() {
	// 		var no = $("#BaseContractorNo").val();
	// 		$.ajax({
	// 			url : pathName + "/basicData/updateBaseContractorByNo",
	// 			type : "post",
	// 			dataType : "json",
	// 			contentType : "application/json;charset=UTF-8",
	// 			data : JSON.stringify({
	// 				"no" : no
	// 			}),
	// 			success : function(data) {
	// 				if(data == 0){
	// 					alert("请先清理相关数据!");
	// 				}else if(data == 1){

	// 				}
	// 			}
	// 		})
	// 	}

	//工单状态列表
	function selectSWS() {
		$.ajax({
			url : pathName + "/basicData/sundryWokerorderStatesSelect",
			type : "post",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				var sws = data.list;//工单状态列表
				var swc = data.swc;//工单类型列表
				var troc = data.sundryWokerClass;//员工类别列表
				var sat = data.sat;//资产状态列表
				var saw = data.saw;//保修/外包
				var baseAssetClasses = data.baseAssetClasses;//资产类别
				var sundryUrgencyLevel = data.sundryUrgencyLevel;//工作类别
				var selectSundryJobPriority = data.selectSundryJobPriority;//工作优先级列表
				$("#sws").empty();
				var str = "";
				for (var i = 0; i < sws.length; i++) {
					str = "<li class='swsC' onclick=clickSWS(this) id='" + sws[i].information + "'><input type='text' readonly>" + sws[i].information + "</input></li>";
					$("#sws").append(str);
				}
				if (sws.length < 8) {
					for (var i = 0; i < (8 - sws.length); i++) {
						str = "<li class='swsC' onclick=clickSWS(this) ><input type='text' readOnly></input></li>";
						$("#sws").append(str);
					}
				}
				$('#swsNo').val(sws.length);
				$("#swsbutton").empty();
				str = "<button class='zh_sc' onclick='deleteSWS()'>删除</button><button class='zh_tj' onclick='addition()'>填加</button><button class='zh_bc' onclick='saveType()'>保存</button>";
				$("#swsbutton").append(str);
				

				var string = "";
				$("#swc").empty();
				for (var i = 0; i < swc.length; i++) {
					string = "<li class='swC' onclick=clickSWC(this) id='" + swc[i].information + "'><input type='text' readonly>" + swc[i].information + "</input></li>";
					$("#swc").append(string);
				}
				if (swc.length < 8) {
					for (var i = 0; i < (8 - swc.length); i++) {
						string = "<li class='swC' onclick=clickSWC(this) ><input type='text' readonly></input></li>";
						$("#swc").append(string);
					}
				}
				$('#swcNo').val(swc.length);
				$("#swcbutton").empty();
				string = "<button class='zh_sc' onclick='deleteSWS()'>删除</button><button class='zh_tj' onclick='artifact()'>填加</button><button class='zh_bc' onclick='saveTypeSwc()'>保存</button>";
				$("#swcbutton").append(string);

				//troc
				var strT = "";
				$("#troc").empty();
				for (var i = 0; i < troc.length; i++) {
					strT = "<li class='troc' onclick=clickTroc(this) id='" + troc[i].information + "'><input type='text' readonly>" + troc[i].information + "</input></li>";
					$("#troc").append(strT);
				}
				if (troc.length < 8) {
					for (var i = 0; i < (8 - troc.length); i++) {
						strT = "<li class='troc' onclick=clickTroc(this) ><input type='text' readonly></input></li>";
						$("#troc").append(strT);
					}
				}
				$('#trocNo').val(troc.length);
				$("#trocbutton").empty();
				strT = "<button class='zh_sc' onclick='deleteTroc()'>删除</button><button class='zh_tj' onclick='staff()'>填加</button><button class='zh_bc' onclick='saveTypeTroc()'>保存</button>";
				$("#trocbutton").append(strT);

				var strTo = "";
				$("#sat").empty();
				for (var i = 0; i < sat.length; i++) {
					strTo = "<li class='sat' onclick=clickSat(this) id='" + sat[i].information + "'><input type='text' readonly>" + sat[i].information + "</input></li>";
					$("#sat").append(strTo);
				}
				if (sat.length < 8) {
					for (var i = 0; i < (8 - sat.length); i++) {
						strTo = "<li class='sat' onclick=clickSat(this) ><input type='text' readonly></input></li>";
						$("#sat").append(strTo);
					}
				}
				$('#satNo').val(sat.length);
				$("#satbutton").empty();
				strTo = "<button class='zh_sc' onclick='deleteSat()'>删除</button><button class='zh_tj' onclick='states()'>填加</button><button class='zh_bc' onclick='saveTypeSat()'>保存</button>";
				$("#satbutton").append(strTo);

				var strSaw = "";
				$("#saw").empty();
				for (var i = 0; i < saw.length; i++) {
					strSaw = "<li class='saw' onclick=clickSaw(this) id='" + saw[i].information + "'><input type='text' readonly>" + saw[i].information + "</input></li>";
					$("#saw").append(strSaw);
				}
				if (saw.length < 8) {
					for (var i = 0; i < (8 - saw.length); i++) {
						strSaw = "<li class='saw' onclick=clickSaw(this) ><input type='text' readonly></input></li>";
						$("#saw").append(strSaw);
					}
				}
				$('#sawNo').val(saw.length);
				$("#sawbutton").empty();
				strSaw = "<button class='zh_sc' onclick='deleteSaw()'>删除</button><button class='zh_tj' onclick='warranty()'>填加</button><button class='zh_bc' onclick='saveTypeSaw()'>保存</button>";
				$("#sawbutton").append(strSaw);

				var strSul = "";
				$("#sul").empty();
				for (var i = 0; i < sundryUrgencyLevel.length; i++) {
					strSul = "<li class='sul' onclick=clickSul(this) id='" + sundryUrgencyLevel[i].information + "'><input type='text' readonly>" + sundryUrgencyLevel[i].information + "</input></li>";
					$("#sul").append(strSul);
				}
				if (sundryUrgencyLevel.length < 8) {
					for (var i = 0; i < (8 - sundryUrgencyLevel.length); i++) {
						strSul = "<li class='sul' onclick=clickSul(this) ><input type='text' readonly></input></li>";
						$("#sul").append(strSul);
					}
				}
				$('#sulNo').val(sundryUrgencyLevel.length);
				$("#sulbutton").empty();
				strSul = "<button class='zh_sc' onclick='deleteSul()'>删除</button><button class='zh_tj' onclick='urgency()'>填加</button><button class='zh_bc' onclick='saveTypeSul()'>保存</button>";
				$("#sulbutton").append(strSul);

				var strSjp = "";
				$("#sjp").empty();
				for (var i = 0; i < selectSundryJobPriority.length; i++) {
					strSjp = "<li class='sjp' onclick=clickSjp(this) id='" + selectSundryJobPriority[i].information + "'><input type='text' readonly>" + selectSundryJobPriority[i].information + "</input></li>";
					$("#sjp").append(strSjp);
				}
				if (selectSundryJobPriority.length < 8) {
					for (var i = 0; i < (8 - selectSundryJobPriority.length); i++) {
						strSjp = "<li class='sjp' onclick=clickSjp(this) ><input type='text' readonly></input></li>";
						$("#sjp").append(strSjp);
					}
				}
				$('#sjpNo').val(selectSundryJobPriority.length);
				$("#sjpbutton").empty();
				strSjp = "<button class='zh_sc' onclick='deleteSjp()'>删除</button><button class='zh_tj' onclick='priority()'>填加</button><button class='zh_bc' onclick='saveTypeSjp()'>保存</button>";
				$("#sjpbutton").append(strSjp);

				var zclb = "";
				$("#zclb").empty();
				for (var i = 0; i < baseAssetClasses.length; i++) {
					zclb = "<li class='zclb' onclick=clickZclb(this) id='" + baseAssetClasses[i].assetCategory + "'><input type='text' readonly>" + baseAssetClasses[i].assetCategory + "</input></li>";
					$("#zclb").append(zclb);
				}
				if (baseAssetClasses.length < 8) {
					for (var i = 0; i < (8 - baseAssetClasses.length); i++) {
						zclb = "<li class='zclb' onclick=clickZclb(this) ><input type='text' readonly></input></li>";
						$("#zclb").append(zclb);
					}
				}
				$('#zclbNo').val(baseAssetClasses.length);
				$("#zclbbutton").empty();
				zclb = "<button class='zh_sc' onclick='deleteZclb()'>删除</button><button class='zh_tj' onclick='addAsseteClass()'>填加</button><button class='zh_bc' onclick='saveTypeZclb()'>保存</button>";
				$("#zclbbutton").append(zclb);

			}
		})
	}

	//添加按钮(工单状态列表)
	function addition() {
		// 		var note = $('<li />');
		// 		note.append("<input type : 'text' class='information' />");
		// 		$('#liA').before($(note));
		//$("*[name='swsName']").removeAttr("readonly");
		if($("#swsNo").val()<8){
			$("#sws li[class='swsC']").each(function() {
				var temp = this.childNodes[1];
				if (temp == undefined) {
					this.childNodes[0].readOnly = false;
					this.childNodes[0].id='tempid';
					return false;
				}
			});
		}else{
			var str = "<li class='swsC' onclick=clickSWS(this) ><input type='text' ></input></li>";
			$("#sws").append(str);
			$("#sws li[class='swsC']").each(function() {
				var temp = this.childNodes[1];
				if (temp == undefined) {
					this.childNodes[0].readOnly = false;
					this.childNodes[0].id='tempid';
					return false;
				}
			});
		}
	}

	//保存(工单状态列表)
	function saveType() {
		var note =$('#tempid').val();
		$.ajax({
			url : pathName + "/basicData/sundryWokerorderStatesInsert",
			type : "post",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify({
				"information" : note
			}),
			success : function(data) {
				if (data == 1) {
					alert("已存在！请重新输入");
					$("li [id=" + note + "]").remove();
				}
				selectSWS();
			}
		});
		//$('#tempid').attr("readonly", "readonly");//设为只读
		
	}

	//选中样式 给隐藏文本框赋值（工单状态列表）
	function clickSWS(t) {
		$(".swsC").removeAttr("style");
		$(t).attr("style", "background-color: #ffff99");
		$(".swC").removeAttr("style");
		$(".troc").removeAttr("style");
		$(".sat").removeAttr("style");
		$(".saw").removeAttr("style");
		$(".sul").removeAttr("style");
		$(".sjp").removeAttr("style");
		$(".zclb").removeAttr("style");
		$('#swsId').val("");
		$('#swsId').val(t.id);
	}

	//删除工单状态列表
	function deleteSWS() {
		$('.sc_yy').show(); //从display:none还原元素默认或已设置的display属性
	}

	$(function() {
		$("#yes").click(function() {
			var information = $('#swsId').val();
			$.ajax({
				url : pathName + "/basicData/sundryWokerorderStatesDelete",
				type : "post",
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify({
					"information" : information
				}),
				success : function(data) {
					if (data != "1") {
						$("li [id=" + information + "]").remove();
					}
					if (data == "1") {
						alert("还有未清理数据！");
					}
				}
			})
			$('#swsId').val("");
			$('.sc_yy').hide();
		});
		$("#cancle").click(function() {
			$('.sc_yy').hide();
		});
	})

	//添加按钮(工单类型列表)
	function artifact() {
		if($("#swcNo").val()<8){
			$("#swc li[class='swC']").each(function() {
				var temp = this.childNodes[1];
				if (temp == undefined) {
					this.childNodes[0].readOnly = false;
					this.childNodes[0].id='tempid_swC';
					return false;
				}
			});
		}else{
			var str = "<li class='swC' onclick=clickSWC(this) ><input type='text' ></input></li>";
			$("#swc").append(str);
			$("#swc li[class='swC']").each(function() {
				var temp = this.childNodes[1];
				if (temp == undefined) {
					this.childNodes[0].readOnly = false;
					this.childNodes[0].id='tempid_swC';
					return false;
				}
			});
		}
	}

	//保存(工单类型列表)
	function saveTypeSwc() {
		var note = $('#tempid_swC').val();
		$.ajax({
			url : pathName + "/basicData/sundryWokerorderClassInsert",
			type : "post",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify({
				"information" : note
			}),
			success : function(data) {
				if (data == 1) {
					alert("已存在！请重新输入");
					$('.inform:last').val("");
				}
				selectSWS();
			}
		})
		//$('#tempid_swC').attr("readonly", "readonly");//设为只读
// 		$(".tempid").attr({
// 			"disabled" : "disabled"
// 		}); //置灰
// 		$('.tempid').css("color", "#000"); // 颜色样式
	}

	//选中样式 给隐藏文本框赋值（工单类型列表）
	function clickSWC(t) {
		$(".swC").removeAttr("style");
		$(t).attr("style", "background-color: #ffff99");
		$(".swsC").removeAttr("style");
		$(".troc").removeAttr("style");
		$(".sat").removeAttr("style");
		$(".saw").removeAttr("style");
		$(".sul").removeAttr("style");
		$(".sjp").removeAttr("style");
		$(".zclb").removeAttr("style");
		$('#swcId').val("");
		$('#swcId').val(t.id);
	}

	//删除工单类型列表
	function deleteSWC() {
		$('.sc_yy').show(); //从display:none还原元素默认或已设置的display属性
	}

	$(function() {
		$("#yes").click(function() {
			var information = $('#swcId').val();
			$.ajax({
				url : pathName + "/basicData/sundryWokerorderClassDelete",
				type : "post",
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify({
					"information" : information
				}),
				success : function(data) {
					if (data != "1") {
						$("li [id=" + information + "]").remove();
					}
					if (data == "1") {
						alert("还有未清理数据！");
					}
				}
			})
			$('#swcId').val("");
			$('.sc_yy').hide();
		});
		$("#cancle").click(function() {
			$('.sc_yy').hide();
		});
	})

	//添加按钮(员工类列表)
	function staff() {
		if($("#trocNo").val()<8){
			$("#troc li[class='troc']").each(function() {
				var temp = this.childNodes[1];
				if (temp == undefined) {
					this.childNodes[0].readOnly = false;
					this.childNodes[0].id='tempid_troc';
					return false;
				}
			});
		}else{
			var str = "<li class='troc' onclick=clickTroc(this) ><input type='text' ></input></li>";
			$("#troc").append(str);
			$("#troc li[class='troc']").each(function() {
				var temp = this.childNodes[1];
				if (temp == undefined) {
					this.childNodes[0].readOnly = false;
					this.childNodes[0].id='tempid_troc';
					return false;
				}
			});
		}
	}

	//保存(员工类别表)
	function saveTypeTroc() {
		var note = $('#tempid_troc').val();
		$.ajax({
			url : pathName + "/basicData/sundryWokerClassInsert",
			type : "post",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify({
				"information" : note
			}),
			success : function(data) {
				if (data == 1) {
					alert("已存在！请重新输入");
					$('.inform:last').val("");
				}
				selectSWS();
			}
		})
		//$('#tempid_troc').attr("readonly", "readonly");//设为只读
	}

	//选中样式 给隐藏文本框赋值（员工类列表）
	function clickTroc(t) {
		$(".troc").removeAttr("style");
		$(t).attr("style", "background-color: #ffff99");
		$(".swsC").removeAttr("style");
		$(".swC").removeAttr("style");
		$(".sat").removeAttr("style");
		$(".saw").removeAttr("style");
		$(".sul").removeAttr("style");
		$(".sjp").removeAttr("style");
		$(".zclb").removeAttr("style");
		$('#trocId').val("");
		$('#trocId').val(t.id);
	}

	//删除员工类别列表
	function deleteTroc() {
		$('.sc_yy').show(); //从display:none还原元素默认或已设置的display属性
	}

	$(function() {
		$("#yes").click(function() {
			var information = $('#trocId').val();
			$.ajax({
				url : pathName + "/basicData/sundryWokerClassDelete",
				type : "post",
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify({
					"information" : information
				}),
				success : function(data) {
					if (data != "1") {
						$("li [id=" + information + "]").remove();
					}
					if (data == "1") {
						alert("还有未清理数据！");
					}
				}
			})
			$('#trocId').val("");
			$('.sc_yy').hide();
		});
		$("#cancle").click(function() {
			$('.sc_yy').hide();
		});
	})

	//添加按钮(资产状态列表)
	function states() {
		if($("#satNo").val()<8){
			$("#sat li[class='sat']").each(function() {
				var temp = this.childNodes[1];
				if (temp == undefined) {
					this.childNodes[0].readOnly = false;
					this.childNodes[0].id='tempid_sat';
					return false;
				}
			});
		}else{
			var str = "<li class='sat' onclick=clickSat(this) ><input type='text' ></input></li>";
			$("#sat").append(str);
			$("#sat li[class='sat']").each(function() {
				var temp = this.childNodes[1];
				if (temp == undefined) {
					this.childNodes[0].readOnly = false;
					this.childNodes[0].id='tempid_sat';
					return false;
				}
			});
		}
	}

	//保存(资产状态列表)
	function saveTypeSat() {
		var note = $('#tempid_sat').val();
		$.ajax({
			url : pathName + "/basicData/sundryAssetsStateInsert",
			type : "post",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify({
				"information" : note
			}),
			success : function(data) {
				if (data == 1) {
					alert("已存在！请重新输入");
					$('.inform:last').val("");
				}
				selectSWS();
			}
		})
		//$('#tempid_sat').attr("readonly", "readonly");//设为只读
	}

	//选中样式 给隐藏文本框赋值（资产状态列表）
	function clickSat(t) {
		$(".sat").removeAttr("style");
		$(t).attr("style", "background-color: #ffff99");
		$(".swsC").removeAttr("style");
		$(".swC").removeAttr("style");
		$(".troc").removeAttr("style");
		$(".saw").removeAttr("style");
		$(".sul").removeAttr("style");
		$(".sjp").removeAttr("style");
		$(".zclb").removeAttr("style");
		$('#satId').val("");
		$('#satId').val(t.id);
	}

	//删除资产状态列表
	function deleteSat() {
		$('.sc_yy').show(); //从display:none还原元素默认或已设置的display属性
	}

	$(function() {
		$("#yes").click(function() {
			var information = $('#satId').val();
			$.ajax({
				url : pathName + "/basicData/sundryAssetsStateDelete",
				type : "post",
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify({
					"information" : information
				}),
				success : function(data) {
					if (data != "1") {
						$("li [id=" + information + "]").remove();
					}
					if (data == "1") {
						alert("还有未清理数据！");
					}
				}
			})
			$('#satId').val("");
			$('.sc_yy').hide();
		});
		$("#cancle").click(function() {
			$('.sc_yy').hide();
		});
	})

	//添加按钮(保修/外包)
	function warranty() {
// 		var note = $('<li />');
// 		note.append("<input type : 'text' class='saveTypeSaw' />");
// 		$('#liE').before($(note));		
					if($("#sawNo").val()<8){
						$("#saw li[class='saw']").each(function() {
							var temp = this.childNodes[1];
							if (temp == undefined) {
								this.childNodes[0].readOnly = false;
								this.childNodes[0].id='tempid_saw';
								return false;
							}
						});
					}else{
						var str = "<li class='saw' onclick=clickSaw(this) ><input type='text' ></input></li>";
						$("#saw").append(str);
						$("#saw li[class='saw']").each(function() {
							var temp = this.childNodes[1];
							if (temp == undefined) {
								this.childNodes[0].readOnly = false;
								this.childNodes[0].id='tempid_saw';
								return false;
							}
						});
					}
	}

	//保存(保修/外包)
	function saveTypeSaw() {
		var note = $('#tempid_saw').val();
		$.ajax({
			url : pathName + "/basicData/sundryAssetsWayInsert",
			type : "post",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify({
				"information" : note
			}),
			success : function(data) {
				if (data == 1) {
					alert("已存在！请重新输入");
					$('.inform:last').val("");
				}
				selectSWS();
			}
		})
		//$('#tempid_saw').attr("readonly", "readonly");//设为只读
	}

	//选中样式 给隐藏文本框赋值（保修/外包）
	function clickSaw(t) {
		$(".saw").removeAttr("style");
		$(t).attr("style", "background-color: #ffff99");
		$(".swsC").removeAttr("style");
		$(".swC").removeAttr("style");
		$(".troc").removeAttr("style");
		$(".sat").removeAttr("style");
		$(".sul").removeAttr("style");
		$(".sjp").removeAttr("style");
		$(".zclb").removeAttr("style");
		$('#sawId').val("");
		$('#sawId').val(t.id);
	}

	//删除 保修/外包
	function deleteSaw() {
		$('.sc_yy').show(); //从display:none还原元素默认或已设置的display属性
	}

	$(function() {
		$("#yes").click(function() {
			var information = $('#sawId').val();
			$.ajax({
				url : pathName + "/basicData/sundryAssetsWayDelete",
				type : "post",
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify({
					"information" : information
				}),
				success : function(data) {
					if (data != "1") {
						$("li [id=" + information + "]").remove();
					}
					if (data == "1") {
						alert("还有未清理数据！");
					}
				}
			})
			$('#sawId').val("");
			$('.sc_yy').hide();
		});
		$("#cancle").click(function() {
			$('.sc_yy').hide();
		});
	})

	//添加按钮(工作类别)
	function urgency() {
						if($("#sulNo").val()<8){
							$("#sul li[class='sul']").each(function() {
								var temp = this.childNodes[1];
								if (temp == undefined) {
									this.childNodes[0].readOnly = false;
									this.childNodes[0].id='tempid_sul';
									return false;
								}
							});
						}else{
							var str = "<li class='sul' onclick=clickSul(this) ><input type='text' ></input></li>";
							$("#sul").append(str);
							$("#sul li[class='sul']").each(function() {
								var temp = this.childNodes[1];
								if (temp == undefined) {
									this.childNodes[0].readOnly = false;
									this.childNodes[0].id='tempid_sul';
									return false;
								}
							});
						}
	}

	//保存(工作类别)
	function saveTypeSul() {
		var note = $('#tempid_sul').val();
		$.ajax({
			url : pathName + "/basicData/sundryUrgencyLevelInsert",
			type : "post",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify({
				"information" : note
			}),
			success : function(data) {
				if (data == 1) {
					alert("已存在！请重新输入");
					$('.inform:last').val("");
				}
				selectSWS();
			}
		})
		//$('#tempid_sul').attr("readonly", "readonly");//设为只读
	}

	//选中样式 给隐藏文本框赋值（工作类别）
	function clickSul(t) {
		$(".sul").removeAttr("style");
		$(t).attr("style", "background-color: #ffff99");
		$(".swsC").removeAttr("style");
		$(".swC").removeAttr("style");
		$(".troc").removeAttr("style");
		$(".sat").removeAttr("style");
		$(".saw").removeAttr("style");
		$(".sjp").removeAttr("style");
		$(".zclb").removeAttr("style");
		$('#sulId').val("");
		$('#sulId').val(t.id);
	}

	//删除 工作类别
	function deleteSul() {
		$('.sc_yy').show(); //从display:none还原元素默认或已设置的display属性
	}

	$(function() {
		$("#yes").click(function() {
			var information = $('#sulId').val();
			$.ajax({
				url : pathName + "/basicData/sundryUrgencyLevelDelete",
				type : "post",
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify({
					"information" : information
				}),
				success : function(data) {
					if (data == 1) {
						$("li [id=" + information + "]").remove();
					}
				}
			})
			$('#sulId').val("");
			$('.sc_yy').hide();
		});
		$("#cancle").click(function() {
			$('.sc_yy').hide();
		});
	})

	//添加按钮(工作优先级列表)
		function priority() {
			if($("#sjpNo").val()<8){
				$("#sjp li[class='sjp']").each(function() {
					var temp = this.childNodes[1];
					if (temp == undefined) {
						this.childNodes[0].readOnly = false;
						this.childNodes[0].id='tempid_sjp';
						return false;
					}
				});
			}else{
				var str = "<li class='sjp' onclick=clickSjp(this) ><input type='text' ></input></li>";
				$("#sjp").append(str);
				$("#sjp li[class='sjp']").each(function() {
					var temp = this.childNodes[1];
					if (temp == undefined) {
						this.childNodes[0].readOnly = false;
						this.childNodes[0].id='tempid_sjp';
						return false;
					}
				});
			}
		}

	//保存(工作优先级列表)
	function saveTypeSjp() {
		var note = $('#tempid_sjp').val();
		$.ajax({
			url : pathName + "/basicData/sundryJobPriorityInsert",
			type : "post",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify({
				"information" : note
			}),
			success : function(data) {
				if (data == 1) {
					alert("已存在！请重新输入");
					$('.inform:last').val("");
				}
				selectSWS();
			}
		})
		//$('#tempid_sjp').attr("readonly", "readonly");//设为只读
	}

	//选中样式 给隐藏文本框赋值（优先级）
	function clickSjp(t) {
		$(".sjp").removeAttr("style");
		$(t).attr("style", "background-color: #ffff99");
		$(".swsC").removeAttr("style");
		$(".swC").removeAttr("style");
		$(".troc").removeAttr("style");
		$(".sat").removeAttr("style");
		$(".saw").removeAttr("style");
		$(".sul").removeAttr("style");
		$(".zclb").removeAttr("style");
		$('#sjpId').val("");
		$('#sjpId').val(t.id);
	}

	//删除 优先级
	function deleteSjp() {
		$('.sc_yy').show(); //从display:none还原元素默认或已设置的display属性
	}

	$(function() {
		$("#yes").click(function() {
			var information = $('#sjpId').val();
			$.ajax({
				url : pathName + "/basicData/sundryJobPriorityDelete",
				type : "post",
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify({
					"information" : information
				}),
				success : function(data) {
					if (data != "1") {
						$("li [id=" + information + "]").remove();
					}
					if (data == "1") {
						alert("还有未清理数据！");
					}
				}
			})
			$('#sjpId').val("");
			$('.sc_yy').hide();
		});
		$("#cancle").click(function() {
			$('.sc_yy').hide();
		});
	})

	//添加按钮(资产类型)
	function addAsseteClass() {
		if($("#zclbNo").val()<8){
			$("#zclb li[class='zclb']").each(function() {
				var temp = this.childNodes[1];
				if (temp == undefined) {
					this.childNodes[0].readOnly = false;
					this.childNodes[0].id='tempid_zclb';
					return false;
				}
			});
		}else{
			var str = "<li class='zclb' onclick=clickZclb(this) ><input type='text' ></input></li>";
			$("#zclb").append(str);
			$("#zclb li[class='zclb']").each(function() {
				var temp = this.childNodes[1];
				if (temp == undefined) {
					this.childNodes[0].readOnly = false;
					this.childNodes[0].id='tempid_zclb';
					return false;
				}
			});
		}
	}

	//保存(资产类别)
	function saveTypeZclb() {
		var note = $('#tempid_zclb').val();
		$.ajax({
			url : pathName + "/basicData/saveAssetClasses",
			type : "post",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			data : JSON.stringify({
				"assetCategory" : note
			}),
			success : function(data) {
				if (data.judge == 1) {
					alert("已存在！请重新输入");
					$("li [id=" + note + "]").remove();
				}
			}
		})
		$('#tempid_zclb').attr("readonly", "readonly");//设为只读

	}

	//选中样式 给隐藏文本框赋值（）
	function clickZclb(t) {
		$(".zclb").removeAttr("style");
		$(t).attr("style", "background-color: #ffff99");
		$(".swsC").removeAttr("style");
		$(".swC").removeAttr("style");
		$(".troc").removeAttr("style");
		$(".sat").removeAttr("style");
		$(".saw").removeAttr("style");
		$(".sul").removeAttr("style");
		$(".sjp").removeAttr("style");
		$('#deleteAssetClassesId').val("");
		$('#deleteAssetClassesId').val(t.id);
	}

	//删除
	function deleteZclb() {
		$('.sc_yy').show(); //从display:none还原元素默认或已设置的display属性
	}

	$(function() {
		$("#yes").click(function() {
			var assetCategory = $('#deleteAssetClassesId').val();
			$.ajax({
				url : pathName + "/basicData/deleteAssetClasses",
				type : "post",
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify({
					"assetCategory" : assetCategory
				}),
				success : function(data) {
					if (data == 1) {
						$("li [id=" + assetCategory + "]").remove();
					}
				}
			})
			$('#swsId').val("");
			$('.sc_yy').hide();
		});
		$("#cancle").click(function() {
			$('.sc_yy').hide();
		});
	})

	//以下    资 产
	//选中样式 给隐藏文本框赋值（资产）
	function click2(t) {
		$(".data").removeAttr("style");
		$(t).attr("style", "background-color: #ffff99");
		$('#zcId').val("");
		$('#zcId').val($(t).children("td").children('div').children('input').val());
	}
	//删除资产
	function deleteAssets() {
		$('.sc_yy').show(); //从display:none还原元素默认或已设置的display属性
	}

	$(function() {
		$("#yes").click(function() {
			var no = $('#zcId').val();
			$.ajax({
				url : pathName + "/basicData/deleteAssetsByNo",
				type : "post",
				dataType : "json",
				contentType : "application/json;charset=UTF-8",
				data : JSON.stringify({
					"no" : no
				})
			})
			$('#zcId').val("");
			selectAssets();
			$('.sc_yy').hide();
		});
		$("#cancle").click(function() {
			$('.sc_yy').hide();
			selectAssets();
		});
	})

	//检查资产编号
	function checkno(node) {
		if ($("#iu_no").val() == "" || $("#iu_no").val() == null) {
			$("#iu_no_check").attr("src", "/asset/img/shoptmsc3.png");
			$("#add").attr("disabled", "disabled");
		} else if (escape($("#iu_no").val()).indexOf("%u") >= 0) {
			$("#iu_no_check").attr("src", "/asset/img/shoptmsc4.png");
			$("#add").attr("disabled", "disabled");
		} else {
			$.ajax({
				url : pathName + "/assets/checkno",
				data : {
					no : $("#iu_no").val()
				},
				type : "get",
				dataType : "json",
				async : false,
				contentType : "application/json;charset=UTF-8",
				success : function(data1) {
					if (data1) {
						$("#iu_no_check").attr("src", "/asset/img/ddcxsh1.png");
						$("#add").removeAttr("disabled");
						$("#iu_no_text").html("");
						$("#iu_no_check").show();
					} else {
						$("#iu_no_check").attr("src", "/asset/img/shoptmsc2.png");
						$("#add").attr("disabled", "disabled");
						$("#iu_no_check").show();
					}
					node.blur();
				}
			});
		}
	}

	//添加按钮
	function add() {
		clear();
		$("#iu_no_check").attr("src", "");
		$("#iu_no").removeAttr("readonly");
		$("#iu_no").attr("onblur", "checkno(this)");
		$("#add").show();
		$("#save").hide();
		$('.zxzc_yy').show();
	}

	//真添加
	function realadd() {
		if (check()) {
			$.ajax({
				url : pathName + "/assets/add",
				data : JSON.stringify({
					no : $("#iu_no").val(),
					assetDesc : $("#iu_desc").val(),
					publicProperty : $("#iu_public").val(),
					departmentId : $("#iu_department").val(),
					positionId : $("#iu_position").val(),
					classId : $("#iu_assets_class").val(),
					stateId : $("#iu_assets_state").val(),
					wokerId : $("#iu_worker").val(),
					type : $("#iu_type").val(),
					serialNo : $("#iu_serial").val(),
					manufacturer : $("#iu_manufacturer").val(),
					contractorId : $("#iu_contractor").val(),
					wayId : $("#iu_way").val(),
					warrantyDeadline : $("#iu_enddate").val(),
					wayNote : $("#iu_way_note").val(),
					assetNote : $("#iu_asset_note").val(),
					supplierId : $("#iu_supplier").val(),
					startDate : $("#iu_start").val(),
					assetValue : $("#iu_value").val(),
					purchaserPrice : $("#iu_price").val(),
					lifeSpan : $("#iu_life").val(),
					clearDate : $("#iu_clear").val(),
					note : $("#iu_note").val()
				}),
				type : "post",
				dataType : "json",
				async : false,
				contentType : "application/json;charset=UTF-8"
			})
			alert("添加成功");
			selectAssets();
			$('.zxzc_yy').hide();
		}
	}

	//获取所有承包商
	function selectallbasecontractor() {
		var data
		$.ajax({
			url : pathName + "/assets/selectallbasecontractor",
			type : "get",
			dataType : "json",
			async : false,
			contentType : "application/json;charset=UTF-8",
			success : function(data1) {
				data = data1;
			}
		})
		return data;
	}

	//获取所有供应商
	function selectallsupplier() {
		var data
		$.ajax({
			url : pathName + "/assets/selectallsupplier",
			type : "get",
			dataType : "json",
			async : false,
			contentType : "application/json;charset=UTF-8",
			success : function(data1) {
				data = data1;
			}
		})
		return data;
	}

	//获取保修外包
	function selectallsundryassetsway() {
		var data
		$.ajax({
			url : pathName + "/assets/selectallsundryassetsway",
			type : "get",
			dataType : "json",
			async : false,
			contentType : "application/json;charset=UTF-8",
			success : function(data1) {
				data = data1;
			}
		})
		return data;
	}

	//获取资产类型
	function getallassetsclass() {
		var data
		$.ajax({
			url : pathName + "/assets/selectallbaseassetclass",
			type : "get",
			dataType : "json",
			async : false,
			contentType : "application/json;charset=UTF-8",
			success : function(data1) {
				data = data1;
			}
		})
		return data;
	}

	//获取资产状态
	function getallsundryassetsstate() {
		var data
		$.ajax({
			url : pathName + "/assets/selectallsundryassetsstate",
			type : "get",
			dataType : "json",
			async : false,
			contentType : "application/json;charset=UTF-8",
			success : function(data1) {
				data = data1;
			}
		})
		return data;
	}

	//获取所有部门
	function selectallbasedepartment() {
		var data
		$.ajax({
			url : pathName + "/assets/selectallbasedepartment",
			type : "get",
			dataType : "json",
			async : false,
			contentType : "application/json;charset=UTF-8",
			success : function(data1) {
				data = data1;
			}
		})
		return data;
	}

	//获取所有位置
	function selectallposition() {
		var data
		$.ajax({
			url : pathName + "/position/positionList",
			type : "get",
			dataType : "json",
			async : false,
			contentType : "application/json;charset=UTF-8",
			success : function(data1) {
				data = data1;
			}
		})
		return data;
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

	//公共财产切换
	function pubchannge() {
		if ($("#iu_public").val() == 1) {
			$(".xz_sel1").val("");
			$(".xz_sel1").attr("disabled", "disabled");
			$(".public").html("");
			$(".xz_inp2").val("");
		} else {
			$(".xz_sel1").removeAttr("disabled");
			$(".public").html("*");
		}
	}

	//部门改了
	function changedepartment(id) {
		$.ajax({
			url : pathName + "/assets/changedepartment",
			data : {
				id : id
			},
			type : "get",
			dataType : "json",
			async : false,
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				$("#iu_worker").html("");
				$("#iu_position").html("");
				var worker = data.worker;
				var position = data.position;
				for (var i = 0; i < worker.length; i++) {
					var a = $("<option>", {
						text : worker[i].name,
						value : worker[i].id
					});
					$("#iu_worker").append(a);
				}
				$("#iu_worker").val("");
				for (var i = 0; i < position.length; i++) {
					var a = $("<option>", {
						text : position[i].position,
						value : position[i].id
					});
					$("#iu_position").append(a);
				}
				$("#iu_position").val("");
				$("#iu_position_no").val("");
				$("#iu_department_no").val(data.no);
			}
		})
	}

	//只改部门
	function changedepartment1(id) {
		if (id == "全部") {
			$("#bmbh").val("");
		} else {
			$.ajax({
				url : pathName + "/assets/onlychangedepartment",
				data : {
					id : id
				},
				type : "get",
				dataType : "json",
				async : false,
				contentType : "application/json;charset=UTF-8",
				success : function(data) {
					$("#bmbh").val(data.no);
					$("#department").val(data.id);
				}
			})
		}
	}

	//位置改了
	function changeposition(id) {
		$.ajax({
			url : pathName + "/assets/changeposition",
			data : {
				id : id
			},
			type : "get",
			dataType : "json",
			async : false,
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				$("#iu_position_no").val(data.no);
			}
		})
	}

	$(function() {
		// 部门查询
		var department = selectallbasedepartment();
		for (var i = 0; i < department.length; i++) {
			var a = $("<option>", {
				text : department[i].department,
				value : department[i].id
			});
			var b = $("<option>", {
				text : department[i].department,
				value : department[i].id
			});
			$("#iu_department").append(a);
			$("#department").append(b);
		}
		$("#iu_department").val("");

		//资产类型查询
		var assetsclass = getallassetsclass();
		for (var i = 0; i < assetsclass.length; i++) {
			var a = $("<option>", {
				text : assetsclass[i].assetCategory,
				value : assetsclass[i].assetCategory
			});
			var b = $("<option>", {
				text : assetsclass[i].assetCategory,
				value : assetsclass[i].id
			});
			$("#assetsclass").append(a);
			if (assetsclass[i].assetCategory != "全部") {
				$("#iu_assets_class").append(b);
			}
		}

		//资产状态查询
		var assetsstate = getallsundryassetsstate();
		for (var i = 0; i < assetsstate.length; i++) {
			var a = $("<option>", {
				text : assetsstate[i].information,
				value : assetsstate[i].information
			});
			var b = $("<option>", {
				text : assetsstate[i].information,
				value : assetsstate[i].id
			});
			if (assetsstate[i].information != "全部") {
				$("#iu_assets_state").append(b);
			}
			$("#assetsstate").append(a);
		}

		//供应商
		var supplier = selectallsupplier();
		$("#iu_supplier").empty();
		for (var i = 0; i < supplier.length; i++) {
			var a = $("<option>", {
				text : supplier[i].supplierName,
				value : supplier[i].id
			});
			$("#iu_supplier").append(a);
		}

		//承包商
		$("#iu_contractor").empty();
		var contractor = selectallbasecontractor();
		for (var i = 0; i < contractor.length; i++) {
			var a = $("<option>", {
				text : contractor[i].name,
				value : contractor[i].id
			});
			$("#iu_contractor").append(a);
		}

		//保修/外包
		var assetsway = selectallsundryassetsway();
		for (var i = 0; i < assetsway.length; i++) {
			var a = $("<option>", {
				text : assetsway[i].information,
				value : assetsway[i].id
			});
			$("#iu_way").append(a);
		}
	})

	function realupdate() {
		if (check()) {
			$.ajax({
				url : pathName + "/assets/update",
				data : JSON.stringify({
					id : $("#iu_id").val(),
					no : $("#iu_no").val(),
					assetDesc : $("#iu_desc").val(),
					publicProperty : $("#iu_public").val(),
					departmentId : $("#iu_department").val(),
					positionId : $("#iu_position").val(),
					classId : $("#iu_assets_class").val(),
					stateId : $("#iu_assets_state").val(),
					wokerId : $("#iu_worker").val(),
					type : $("#iu_type").val(),
					serialNo : $("#iu_serial").val(),
					manufacturer : $("#iu_manufacturer").val(),
					contractorId : $("#iu_contractor").val(),
					wayId : $("#iu_way").val(),
					warrantyDeadline : $("#iu_enddate").val(),
					wayNote : $("#iu_way_note").val(),
					assetNote : $("#iu_asset_note").val(),
					supplierId : $("#iu_supplier").val(),
					startDate : $("#iu_start").val(),
					assetValue : $("#iu_value").val(),
					purchaserPrice : $("#iu_price").val(),
					lifeSpan : $("#iu_life").val(),
					clearDate : $("#iu_clear").val(),
					note : $("#iu_note").val()
				}),
				type : "post",
				dataType : "json",
				async : false,
				contentType : "application/json;charset=UTF-8"
			})
			alert("修改成功");
			selectAssets();
			$('.zx_yy').hide();
		}
	}

	//检查更新和新加的必填字段
	function check() {
		if ($("#iu_no").val() == null || $("#iu_no").val() == "" || $("#iu_desc").val() == null || $("#iu_desc").val() == "" || $("#iu_public").val() == null || $("#iu_public").val() == "" || $("#iu_assets_class").val() == null || $("#iu_assets_class").val() == "" || $("#iu_assets_state").val() == null || $("#iu_assets_state").val() == "" || $("#iu_way").val() == null || $("#iu_way").val() == "" || $("#iu_supplier").val() == null || $("#iu_supplier").val() == "" || $("#iu_start").val() == null
				|| $("#iu_start").val() == "" || $("#iu_price").val() == null || $("#iu_price").val() == "") {
			alert("必填数据没填完1");
			return false;
		}
		if ($("#iu_public").val() == 0) {
			if ($("#iu_department").val() == null || $("#iu_department").val() == "" || $("#iu_position").val() == null || $("#iu_position").val() == "" || $("#iu_worker").val() == null || $("#iu_worker").val() == "") {
				alert("必填数据没填完");
				return false;
			}
		}
		return true;
	}
	//以上  资 产

	// 添加位置  查询部门
	function newlocation() {
		var id = $('#departmentTo').val(); // 选中的部门id
		judge(id);
		$.ajax({
			url : pathName + "/position/selectDepartment",
			type : "GET",
			dataType : "json",
			contenType : 'application/json;charset=UTF-8',
			success : function(data) {
				var depa = data.departments;
				var name = "全部";
				$('#departmentTo').empty();
				var str = "<option value=''>" + name + "</option>";
				// 循环出部门列表
				for (var i = 0; i < depa.length; i++) {
					str += "<option value='"+depa[i].id+"'>" + depa[i].department + "</option> ";
				}
				$('#departmentTo').append(str);
			}
		})
	}

	//添加判断座位编号是否空
	function judge(id) {
		if (id == '' || id == null) {
			//$('#position').removeAttr("disabled");
			$("#deptId").val("");
			$("#position").attr({
				"disabled" : "disabled"
			}); //  位置编号置灰
			$('#position').css("background-color", "#ccc"); // 颜色样式
			$('#position').css("width", "195px"); // 宽
			$('#position').css("float", "left"); // 左
			$('#position').css("height", "22px"); // 高
			$('#position').attr("placeholder", "请选择部门"); // 提示
			$("#position").val("");
			$("#no").val("");
		}
	}

	//座位编号不为空解除置灰
	function judgeFure() {
		$("#position").removeAttr("disabled"); //去除置灰
		$('#position').attr("placeholder", "请输入位置编号"); // 提示
		$('#position').css("background-color", "#FFF"); // 颜色样式
	}

	//部门发生改变时
	function alterDepartment() {
		var id = $('#departmentTo').val(); // 选中的部门id
		judge(id);
		if (id != "") {
			judgeFure();
			$.ajax({
				url : pathName + "/position/alterDepartment",
				type : "GET",
				dataType : "json",
				data : {
					"dId" : id
				},
				success : function(data) {
					var depa = data.noId;
					$("#deptId").val(depa.bNo); //部门编号
				}
			})
		}
	}

	//查询位置编号
	function locationNumber() {
		var id = $('#departmentTo').val(); // bid 部门id
		var position = $('#position').val(); //座位编号
		if (id == '' || id == null) {
			$("#deptId").val("");
		}
		if (id != "" && !isNaN(position) && position != "") {
			$.ajax({
				url : pathName + "/position/departmentId",
				type : "GET",
				dataType : "json",
				contenType : 'application/json;charset=UTF-8',
				data : {
					"dId" : id,
					"aNo" : position
				},
				success : function(data) {
					var no = data.lc;
					if (no.judge == "1") {
						$('#position').val("");
						alert("已存在!");
					}
					$('#no').val(no.aNo);
					$('#positionTwo').val(no.position);
				}
			})
		} else {
			$('.xz_inp1').val('');
			$("#position").val("");
		}

	}

	// 添加提交
	function form_add_positon() {
		$("#forms")[0].action = pathName + '/position/insert';
		$("#forms")[0].submit();
	}