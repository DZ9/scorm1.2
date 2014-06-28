$(function(){
	
	//计算总价
	
	var $totalPrice = $("#price");
	var $totalPriceShow = $("span.price");
	var $price = $("td.price");
	var money = 0;
	count();
//alert($totalPrice.text());
	function count() {
		$price.each(function() {
//alert($(this).text());
        money = money + parseFloat($(this).text());
//alert(money);
		$totalPrice.val(money);
		$totalPriceShow.text(money);
        });
	}
	
	//提交后台
	if($price.length == 0) {	//为空判断
		$sub.disabled();
	}
	var $sub = $("#sub");
	var $form = $("#priceForm"); 
	$sub.click(function(){
		$form.submit();
	})
	
})