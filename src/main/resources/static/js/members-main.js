console.log("members-main.js");

var bindClickBtnCreateMember = function() {
	$("#btn-create-member").on("click", function() {
		location.href = "members/create";
	});
}

$(document).ready(function() {
	bindClickBtnCreateMember();
});