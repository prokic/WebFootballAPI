WebFootballAPI = angular.module('WebFootballAPI.factory', []);

WebFootballAPI.factory('ChangingURL', function() {
    var savedURL = {};
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

WebFootballAPI.factory('TableResolve', function() {
    var compare;
    function set(data) {
        compare = data;
    }
    function get() {
        return compare;
    }

    return {
        set: set,
        get: get
    }

});

WebFootballAPI.factory('setYearFactory', function() {
    var compare;
    function set(data) {
        compare = data;
    }
    function get() {
        return compare;
    }

    return {
        set: set,
        get: get
    }
});