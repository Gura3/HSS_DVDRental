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