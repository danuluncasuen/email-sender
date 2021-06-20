$("#submit").on("click", () => {
    $.ajax({
        method: "POST",
        url: "/email/send",
        data: JSON.stringify(emailObj()),
        contentType: "application/json",
        success: response => {
            alert(`SUCCESS: ${response}`);
        },
        error: err => {
            let errorObj = err.responseJSON;
            alert(`ERROR: "${errorObj.message}" \nTIME: ${errorObj.time}`);
        }
    });
});

const emailObj = () => {
    return {
        title: $('#subject').val(),
        to: $('#to').val(),
        content: $('#text').val()
    }
}