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

//日期
function getNow(){
	var now=new Date();
	var year=now.getYear()+1900;
	var month=now.getMonth()+1;
	var date=now.getDate();
	var day=now.getDay();
	var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
	var week=arr_week[day];
	var hours=now.getHours();
	var minutes=now.getMinutes();
	var seconds=now.getSeconds();
	var time=year+"年"+month+"月"+date+"日";
	$(".week").html(week)
	$(".day").html(time)
	
}
getNow();

//标签栏
function tb(){
	var tb=$(window).width()-100;
	$('.right_tb,.right').css('width',tb);		
}
tb();

$(".tb_gb").each(function(){
	$(this).mouseenter(function(){
		$(this).attr('src','img/u122_6.png')
		$(this).css({"top":"6px","right":"4px"})
	})
	$(this).mouseleave(function(){
		$(this).attr('src','img/u122_5.png')
		$(this).css({"top":"8px","right":"6px"})
	})
	$(".tb_gb").click(function(){
		$(".tb_gb").index(this)
		$(this).parent(this).remove()
	})
});
		
$(".top_logo").click(function(){
	var n=($('.right_tb').width()-120)/120
	if($(".right_tb li").length <=n){			
		$(".right_tb").append('<li class="right_zm2"><a title="资产">资产</a><img class="tb_gb" src="img/u122_5.png"/></li>')
	}else{
		alert("标签太多了，可以先删除一些！")
	}
			
	$(".tb_gb").click(function(){
		$(".tb_gb").index(this)
		$(this).parent(this).remove()
	})	
	
	$(".tb_gb").each(function(){
		$(this).mouseenter(function(){
			$(this).attr('src','img/u122_6.png')
			$(this).css({"top":"6px","right":"4px"})
		})
		$(this).mouseleave(function(){
			$(this).attr('src','img/u122_5.png')
			$(this).css({"top":"8px","right":"6px"})
		})
	});
	
	/*$('.right_zm2 a').each(function() {
        $(this).toggle(function(){
			$('.right_zm2').css('background-color','#edf1f2');	
		},function(){
			$('.right_zm2').css('background-color','#20b7ff');	
		})
    });*/
	
})

