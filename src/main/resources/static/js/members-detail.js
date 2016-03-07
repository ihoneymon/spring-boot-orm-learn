var bindClickBtnSubmit = function() {
	var $memberForm = $("#member-form");
	$("#btn-submit").on("click", function() {
		// TODO 검증하기
		$memberForm.submit();
	});
};

var bindClickBtnCancel = function() {
	$("#btn-cancel").on("click", function() {
		location.href = "/members";
	});
};

var bindClickBtnDelete = function() {
	var $btnDelete = $("#btn-delete");
	if($btnDelete.length) {
		$btnDelete.on("click", function() {
			var memberId = $("#member-id").val();
			$.ajax({
				url: "/members/" + memberId,
				method: "DELETE",
				success: function() {
					location.href="/members";
				},
				error: function() {
					console.log("error");
				}
			});
		});
	}
}

$(function() {
	console.log("ready");
	bindClickBtnCancel();
	bindClickBtnSubmit();
	bindClickBtnDelete();
});