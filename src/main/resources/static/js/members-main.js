console.log("members-main.js");

var bindClickBtnCreateMember = function() {
	$("#btn-create-member").on("click", function() {
		location.href = "members/create";
	});
}

var bindClickBtnDeleteMember = function() {
	$(".member-delete").click(function() {
		$this = $(this);
		var memberId = $this.data("member-id");
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

$(document).ready(function() {
	bindClickBtnCreateMember();
	bindClickBtnDeleteMember();
});