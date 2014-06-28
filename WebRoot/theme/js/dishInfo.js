$(function(){
	var $img = $("#img");
	var $dishName = $("#dishName");
	var $price = $("#price");
	var $type = $("#type");
	var $textarea = $("#textarea");
	var $doc = $("#doc");
	var $upimg = $("#upimg");

//alert($doc.attr("value"));
//alert($doc.val());
	if($dishName.val() == "null" || $dishName.val() == "") {
		$dishName.val("");
		$price.val("");
		$textarea.val("");
	}else {
		$dishName.attr("readOnly","true");
	}
	$("#sub").click(function(){
//		alert($img.text());\
//		alert("333"+$doc);
		if($doc.attr("value")=="null") {
			if($doc.val() == "") {
				alert("请上传图片！");
				return false;
			}else {
				$doc.attr("value",$doc.val());
				$img.val($doc.val());
				//$dishName.attr("disabled","false");
			}
		}
//		alert(1);
		if($dishName.val().length == 0
				||$textarea.val().length == 0) {
			alert("请填写完整信息！");
			return false;
		}
		
	})
	
	$dishName.blur(function(){
		if($dishName.val().length == 0) {
			$("#derror").show();
		}else {
			$("#derror").hide();
		}
	})
	
	$price.blur(function(){
		if($price.val().length == 0) {
			$("#perror").show();
		}else {
			$("#perror").hide();
		}
	})
	
	$textarea.blur(function(){
		if($textarea.val().length == 0) {
			$("#terror").show();
		}else {
			$("#terror").hide();
		}
	})
	
	
  
})