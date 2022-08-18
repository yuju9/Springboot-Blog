let index = {
    init: function () {
        // jQuery 사용
        $("#btn-save").on("click", () => {
            this.save(); // save함수 이벤트로 호출
        });
    },

    save: function () {
        let data = {
            title: $("#title").val(),
            content: $("#content").val(),
            category: $("#category").val(),
        }

        $.ajax({
            // 회원가입 수행 요청
            type: "POST",
            url: "/api/board",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp) {
            alert("글쓰기가 완료되었습니다.");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });

    },
}

index.init();