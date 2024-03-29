// (1) 회원정보 수정
function update(userId, event) {
    event.preventDefault(); // 폼태그 액션 막기 (validation check)

    let data = $("#profileUpdate").serialize();

    console.log(data);

    $.ajax({
        type: "PUT",
        url : `/api/user/${userId}`,
        data: data,
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        dataType: "json"
    }).done(res=>{
        console.log("성공", res);
        location.href = `/user/${userId}`;
    }).fail(error=>{ //상태코드 200번대가 아닐 때
        if(error.data == null){
            alert(error.responseJSON.message);
        }else{
            alert(JSON.stringify(error.responseJSON.data));
        }
    });
}