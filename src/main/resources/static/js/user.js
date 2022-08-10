let index = {
    init: function () {
        $("#btn-save").on("click", ()=>{
            this.save();
        });

        $("#btn-login").on("click", ()=>{
            this.login();
        });
    },

    save:function (){
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };

        // console.log(data);

        $.ajax({
            type: "POST",
            url: "/blog/api/user",
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
            alert("회원가입이 완료되었습니다.");
            location.href="/blog";
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },

    login:function (){
        let data = {
            username: $("#username").val(),
            password: $("#password").val()
        };

        $.ajax({
            type: "POST",
            url: "/blog/api/user/login",
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
            alert("로그인이 완료되었습니다.");
            location.href="/blog";
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }
}

index.init();