function confirmation() {
    var answer = confirm("你确定要删除此课程吗?——————三思而后行！！！");
    var urlParams = new URLSearchParams(window.location.search);
    var idc = urlParams.get('id');
    if (answer) {
        window.location.href = "/course/delete_solve?id=idc"; // replace with the URL of the page you want to redirect to
    } else {
        return false;
    }
}