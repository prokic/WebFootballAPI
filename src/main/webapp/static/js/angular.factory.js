WebFootballAPI = angular.module('WebFootballAPI.factory', []);

WebFootballAPI.factory('ChangingURL', function() {
    var savedURL = {}
    function set(data) {
        savedURL = data;
    }
    function get() {
        return savedURL;
    }

    return {
        set: set,
        get: get
    }

});