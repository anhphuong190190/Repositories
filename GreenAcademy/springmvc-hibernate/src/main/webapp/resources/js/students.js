(function($) {
	function sendRequest(url, data, method, callback) {
		$.ajax({
			url : url,
			type : method,
			contentType: 'application/json',
			success : callback,
			error : function(request, msg, error) {
				// handle failure
			}
		});
	};
	function sendGetRequest(url, callback) {
		sendRequest(url, "", 'GET', callback);
	};
	
	function sendPostRequest(url, data, callback) {
		sendRequest(url, data, 'POST', callback);
	};
	
	function sendPutRequest(url, data, callback) {
		sendRequest(url, data, 'PUT', callback);
	};
	
	function sendDeleteRequest(url, data, callback) {
		sendRequest(url, data, 'DELETE', callback);
	};
	
	function viewStudent(id) {
		sendGetRequest('/' + id, function(result) {
			location.reload(true);
		})
	};
	
	function editStudent(id) {
		sendPutRequest('/' + id, id, function(result) {
			location.reload(true);
		})
	};
	
	function deleteStudent(id) {
		sendDeleteRequest('/' + id, id, function(result) {
			location.reload(true);
		})
	};
})(jQuery);