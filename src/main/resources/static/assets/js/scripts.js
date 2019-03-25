
jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
    
    /*
        Form validation
    */
    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    $('.login-form').on('submit', function(e) {
    	
    	$(this).find('input[type="text"], input[type="password"], textarea').each(function(){
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
    	
    });
    
    
});
function openShutManager(oSourceObj,oTargetObj,shutAble,oOpenTip,oShutTip){
	var sourceObj = typeof oSourceObj == "string" ? document.getElementById(oSourceObj) : oSourceObj;
	var targetObj = typeof oTargetObj == "string" ? document.getElementById(oTargetObj) : oTargetObj;
	var openTip = oOpenTip || "";
	var shutTip = oShutTip || "";
	if(targetObj.style.display!="none"){
		if(shutAble) return;
		targetObj.style.display="none";
		if(openTip  &&  shutTip){
			sourceObj.innerHTML = shutTip;
		}
	} else {
		targetObj.style.display="block";
		if(openTip  &&  shutTip){
			sourceObj.innerHTML = openTip;
		}
	}
}

$(function(){

	// 循环轮播到某个特定的帧
	$(".slide-one").click(function(){
		$("#myCarousel").carousel(0);
	});
	$(".slide-two").click(function(){
		$("#myCarousel").carousel(1);
	});
	$(".slide-three").click(function(){
		$("#myCarousel").carousel(2);
	});
});

	// 选择图片显示
function imgChange1(obj) {
		//获取点击的文本框
	var file =document.getElementById("file1");
	var imgUrl =window.URL.createObjectURL(file.files[0]);
	var img =document.getElementById('img1');
	img.setAttribute('src',imgUrl); // 修改img标签src属性值
};
function imgChange2(obj) {
	//获取点击的文本框
	var file =document.getElementById("file2");
	var imgUrl =window.URL.createObjectURL(file.files[0]);
	var img =document.getElementById('img2');
	img.setAttribute('src',imgUrl); // 修改img标签src属性值
};
function imgChange3(obj) {
	//获取点击的文本框
	var file =document.getElementById("file3");
	var imgUrl =window.URL.createObjectURL(file.files[0]);
	var img =document.getElementById('img3');
	img.setAttribute('src',imgUrl); // 修改img标签src属性值
};
function imgChange8(obj) {
	//获取点击的文本框
	var files = document.getElementById("file8").files;
	if(files.length>=3){
		alert("最多上传两张思维导图!请重新选择图片!");
		window.location.href="xinxi2";
	}
	var file =document.getElementById("file8");
	var imgUrl =window.URL.createObjectURL(file.files[0]);
	var img =document.getElementById('img8');
	img.setAttribute('src',imgUrl); // 修改img标签src属性值
	var imgUrl1 =window.URL.createObjectURL(file.files[1]);
	var img =document.getElementById('img8.1');
	img.setAttribute('src',imgUrl1); // 修改img标签src属性值

};
function imgChange4(obj) {
	//获取点击的文本框
	var file =document.getElementById("file4");
	var imgUrl =window.URL.createObjectURL(file.files[0]);
	var img =document.getElementById('img4');
	img.setAttribute('src',imgUrl); // 修改img标签src属性值
};
function imgChange5(obj) {
	//获取点击的文本框
	var file =document.getElementById("file5");
	var imgUrl =window.URL.createObjectURL(file.files[0]);
	var img =document.getElementById('img5');
	img.setAttribute('src',imgUrl); // 修改img标签src属性值
};
function imgChange6(obj) {
	//获取点击的文本框
	var file =document.getElementById("file6");
	var imgUrl =window.URL.createObjectURL(file.files[0]);
	var img =document.getElementById('img6');
	img.setAttribute('src',imgUrl); // 修改img标签src属性值
};
function imgChange7(obj) {
	//获取点击的文本框
	var file =document.getElementById("file7");
	var imgUrl =window.URL.createObjectURL(file.files[0]);
	var img =document.getElementById('img7');
	img.setAttribute('src',imgUrl); // 修改img标签src属性值
};