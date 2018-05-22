// JavaScript Document
var o=0;
var y=$('.content_ul a').length;
var l=$('.content_ul a').width();
var h=y*l-$('.content_div1').width();
$('.u_right').click(function(){
	if(o<h){
		o=o+l
		$('.content_ul').animate({marginLeft:-o});		
	}
})
$('.u_left').click(function(){
	if(o>0){
		o=o-l
		$('.content_ul').animate({marginLeft:-o});	
	}	
})	