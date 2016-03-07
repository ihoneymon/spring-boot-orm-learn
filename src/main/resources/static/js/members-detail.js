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
}

$(function() {
	console.log("ready");
	bindClickBtnCancel();
	bindClickBtnSubmit();
});