$(function(){
	var hash; 
	hash=(!window.location.hash)?"#flag0":window.location.hash; 
	window.location.hash=hash; 
	
	function flag() {
		$("#flag1").trigger("click");
		alert(1);
	}
	
	switch(hash) {
		case "#flag0":
			$("#tags a:first").tab("show");
			break;
		case "#flag1":
			$("#tags a:last").tab("show");
			break;
	}
	
	$("#flag0").click(function(){
		window.location.hash="#flag0";
	})
	$("#flag1").click(function(){
		window.location.hash="#flag1";
	})
	
	
})