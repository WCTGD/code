/**
 * 
 */

function fun(current,size){
	var no=$("#wh").val();
	var job=$("#zc").val();
	var name=$("#mc").val();
	var result;
	$.ajax({
		type:"post",
		url:"/asset/worker/list",
		dataType:"json",
		data:{"no":no,"job":job,"name":name,"current":current,"size":size},
		async:false,
		success:function(data){
			var str;
			result =data.data;
			//两次分页的数据连在一起,先将之前的删掉;
			$(".d").empty();
			for(var i in result){
				
				var w=result[i];
				str+="<tr class='d'><td><div>"+w.no+"</div></td><td><div>"+w.name+"</div></td>"+
    				 "<td><div>"+w.job+"</div></td><td><div>"+w.department.department+"</div></td>"+
    				 "<td><div class=\"tb_cz\"><a class=\"xg\">修改</a>"+
            		 "<a class=\"ck\">查看</a><a class=\"sc0\">删除</a></div></td></tr>"
			}
			
			$(".first_tr").after(str);
			
			//如果总记录数小于每页显示的条数,隐藏分页
			if(data.page.total<data.page.size){
				$(".t_div2").hide();
			}else{
				$(".t_div2").show();
			}
			
			//当前页
			$("#current").text(data.page.current);
			//总页数
			$("#pages").text(data.page.pages);
			//总记录数
			$("#total").text(data.page.total);
			//当前页显示数量的起始位置
			$("#start").text(data.page.start);
			//当前页显示数量的结束位置
			$("#end").text(data.page.end);
			
			update(result);
			del(result)
			
			
			$(".ck").each(function(i){
		$(this).click(function(){
			var worker=result[i];
			$(".ck_ul .ck_span2:eq(0)").text(worker.no);
			$(".ck_ul .ck_span2:eq(1)").text(worker.mobilePhone);
			$(".ck_ul .ck_span2:eq(2)").text(worker.name);
			$(".ck_ul .ck_span2:eq(3)").text(worker.email);
			$(".ck_ul .ck_span2:eq(4)").text(worker.department.department);
			$(".ck_ul .ck_span2:eq(5)").text(worker.homePhone);
			$(".ck_ul .ck_span2:eq(6)").text(worker.job);
			$(".ck_ul .ck_span2:eq(7)").text(worker.address);
			$(".ck_ul .ck_span2:eq(8)").text(worker.position.position);
			$(".ck_ul .ck_span2:eq(10)").text(worker.swc.information);
			$(".ck_yy").show()
		})
	})
		}
		
	}); 
}


function del(result){
	var id=0;
	$(".sc0").each(function(i){
		$(this).bind("click",function(){
			id=result[i].id;
			$(".sc_yy").show();
		});
	});
	
	
	$("#ok").click(function(){
		
		$.ajax({
			type:"post",
			url:"/asset/worker/del",
			dataType:"json",
			data:{"id":id},
			async:true,
			success:function(){
				$(".d").eq(1).remove();
				
			}
			
		}) 
		
		location.reload(true);
		
		$(".sc_yy").hide();
	})
	$("#cancle").click(function(){
		
		$(".sc_yy").hide();
	})
}


function update(result){
$(".xg").each(function(i){
		
		$(this).bind("click",function(){
			var worker=result[i];
			$("#update .xz_ul input:first").val(worker.no);
			$("#update .xz_ul input:eq(1)").val(worker.name);
			$("#update .xz_ul input:eq(2)").val(worker.email);
			$("#update .xz_ul input:eq(3)").val(worker.homePhone);
			$("#update .xz_ul input:eq(4)").val(worker.job);
			$("#update .xz_ul input:eq(5)").val(worker.mobilePhone);
			$("#update .xz_ul textarea:first").val(worker.address);
			
			
			$.ajax({
				type:"post",
				url:"/asset/worker/selectOptions",
				dataType:"json",
				async:true,
				success:function(data){

					var departments=data.list;
					var workerClass=data.workerClass;
					var locations=data.locations;
					var dep;
					var workerC;
					var location;
					var dep_index;
					var workerC_index;
					var location_index;
					
					for(var d in departments){
						dep+="<option value=\""+departments[d].id+"\">"+departments[d].department+"</option>";
						
						
						if(worker.department.id==departments[d].id){
							dep_index=d;
						}
					}
					for(var d in workerClass){
						workerC+="<option value=\""+workerClass[d].id+"\">"+workerClass[d].information+"</option>";
						
						
						if(worker.swc.id==workerClass[d].id){
							workerC_index=d;
						}
					}
					for(var d in locations){
						location+="<option value=\""+locations[d].id+"\">"+locations[d].position+"</option>";
						
						
						if(worker.position.id==locations[d].id){
							location_index=d;
						}
					}
					$("#update .xz_ul select:first").empty().append(dep);
					$("#update .xz_ul select:first option[value=\""+departments[dep_index].id+"\"]").attr({"selected":"selected"});
					
					$("#update .xz_ul select:eq(1)").empty().append(location);
					$("#update .xz_ul select:eq(1) option[value=\""+locations[location_index].id+"\"]").attr({"selected":"selected"});
					
					$("#update .xz_ul select:eq(2)").empty().append(workerC);
					$("#update .xz_ul select:eq(2) option[value=\""+workerClass[workerC_index].id+"\"]").attr({"selected":"selected"});
					$("#update").show();
					
					$("#update #save").click(function(){
						var current=parseInt($("#current").text());
						var size=parseInt($("#size").val())
						var options={
								url:"/asset/worker/update",
								
						};
						$("#myform_update").ajaxSubmit(options);
						
						$("#update").hide();
						fun(current,size)
					})
				}
			});
			
			
		})
		
		
	})
}


$(function(){
	
	var size=parseInt($("#size").val());
	
	fun(1,size);
	
	$("#xzyg").click(function(){
		$("#add :input").val("");
		$.ajax({
			type:"post",
			url:"/asset/worker/selectOptions",
			dataType:"json",
			async:true,
			success:function(data){

				var departments=data.list;
				var workerClass=data.workerClass;
				var locations=data.locations;
				var dep;
				var workerC;
				var location;
				
				for(var d in departments){
					dep+="<option value=\""+departments[d].id+"\">"+departments[d].department+"</option>";
				}
				for(var d in workerClass){
					workerC+="<option value=\""+workerClass[d].id+"\">"+workerClass[d].information+"</option>";
				}
				for(var d in locations){
					location+="<option value=\""+locations[d].id+"\">"+locations[d].position+"</option>";
				}
				$("#add .xz_ul select:first").empty().append(dep);
				
				$("#add .xz_ul select:eq(1)").empty().append(location);
				
				$("#add .xz_ul select:eq(2)").empty().append(workerC);
				$("#add").show();
			}
		});
		
		
		$("#add #save").click(function(){
			var current=parseInt($("#current").text());
			var size=parseInt($("#size").val())
			var options={
					url:"/asset/worker/insert",
			};
			$("#myform_add").ajaxSubmit(options);
			
			$("#add").hide();
			location.reload(true);
		})
		
	})
	
	
	//向左的箭头(上一页)
	var prev=$(".t_div2 img:first");
	//向右的箭头(下一页)
	var next=$(".t_div2 img:last");
	 
	
	//点击向左的箭头;
	prev.click(function(){
		var current=parseInt($("#current").text());
		var size=parseInt($("#size").val())
		//当前页减去1(如果当前为第一页,当前页为1,不能在减1)
		if(current<=1){
			current=1
		}else{
			current=current-1;
		}
		fun(current,size);
	});
	//点击向右的箭头;
	next.click(function(){
		var current=parseInt($("#current").text());
		var size=parseInt($("#size").val());
		var pages=$("#pages").text();
		//当前页加上1(如果当前为最后一页,当前页为最后一页,不能在加1)
		if(current>=pages){
			current=pages
		}else{
			current=current+1;
		}
		fun(current,size);
	})
	
	
	//修改每页显示数量
	$("#size").change(function(){
		var size=$(this).val();
		fun(1,size);
	})
	
	
	$("#go").keypress(function(event){
		if(event.keyCode==13){
			
			//跳转页码
			var go=parseInt($("#go").val()); 
			var reg = new RegExp("^[0-9]*$");  
			//判断输入是否为数字
			if(!reg.test(go)){
				alert("页码输入无效,请重新输入!");
				$("#go").select();
				return ;
			}
			
			var pages=parseInt($("#pages").text());
			//输入的页面大于总页数
			if(pages<go){
				alert("页码输入无效,请重新输入!");
				$("#go").select();
				return;
			}
			
			fun(go,size);
		}
	})
	
	$("#query").click(function(){
		var size=parseInt($("#size").val());
		fun(1,size)
	});
	
	
	$("#all").click(function(){
		$(".main input").val('');
		var size=parseInt($("#size").val());
		
		fun(1, size);
		
	})
	
})