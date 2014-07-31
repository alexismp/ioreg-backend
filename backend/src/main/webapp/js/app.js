function ready() {
    gapi.client.io14reg.get_attendee({'id': '007'}).execute(function(resp) {
        if (!resp.code) {
            alert(resp.result.first + " " + resp.result.last); // “Dr. James Bond”

            var element = document.createElement('div');
            element.innerHTML = JSON.stringify(resp.result);
            document.querySelector('#outputLog').appendChild(element);
        }
    });

}
function gapiIsLoaded() {
    gapi.client.load('io14reg', 'v1', ready, '//' + window.location.host + '/_ah/api');
}