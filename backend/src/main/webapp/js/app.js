function ready() {
    gapi.client.io14reg.get_attendee({'id': '007'}).execute(function(resp) {
        var result;
        if (!resp.code) {
            result = resp.result.first + " " + resp.result.last; // “James Bond”
            var element = document.createElement('div');
            element.innerHTML = JSON.stringify(resp.result);
            document.querySelector('#outputLog').appendChild(element);
        } else {
            result = "Something is not right!";
        }
        alert(result);
    });

}
function gapiIsLoaded() {
    gapi.client.load('io14reg', 'v1', ready, '//' + window.location.host + '/_ah/api');
}