WebFootballAPI = angular.module('WebFootballAPI.factory', []);

WebFootballAPI.factory('ChangingURL', function() {
    var savedData = {}
    function set(data) {
        savedData = data;
    }
    function get() {
        return savedData;
    }

    return {
        set: set,
        get: get
    }

});