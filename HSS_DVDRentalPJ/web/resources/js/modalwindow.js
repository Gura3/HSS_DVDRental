
$(function () {
    $("#protect").click(function () {
        swal({
            title: "いえええええええええええ",
            text: "プロテクト処理が実行されると処理されたDVDの情報は消去されます。\n本当に実行しますか？",
            icon: "warning",
            buttons: true,
            dangerMode: true
        });
    });
});

function MoveCheck (){
    //var res = confirm("プロテクト処理が実行されると処理されたDVDの情報は消去されます。\n本当に実行しますか？");
    alert('あいうえお');
    var res = confirm('さｄさ');
    if( res === true ) {
        // OKなら移動
    }else {
        // キャンセルならアラートボックスを表示
    }
}

//ボタンを押すスクリプト
