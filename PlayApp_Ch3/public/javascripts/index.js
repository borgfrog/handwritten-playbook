$(function(){
	$("#sendbtn").click(function(){
		var jsondata = {
			'input': $("#input").val()
		};
		$.post("/ajax",
			jsondata,
			function(result){
				var res = "Status: " + result.status + ", Message: " + result.message;
				$("#message").text(res);
			},
			"json"
		);
	})
})
