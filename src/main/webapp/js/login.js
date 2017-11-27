$().ready(function () {
    $("#login").validate({
        rules: {
            email: {
                required: true,
                email: true
            }
        }
    })
});