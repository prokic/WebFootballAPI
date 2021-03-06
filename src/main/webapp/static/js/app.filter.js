WebFootballAPI = angular.module('WebFootballAPI.filter', []);

WebFootballAPI.filter('range', function() {
    return function(input, total) {
        total = parseInt(total);
        for (var i = 0; i < total; i++){
            var res = String.fromCharCode(i+65);
            input.push(res);
        }
        return input;
    };
});
WebFootballAPI.filter('matchdaysList', function() {
    return function(input, total) {
        total = parseInt(total);
        for (var i = 1; i < total; i++){
            input.push(i);
        }
        return input;
    };
});
WebFootballAPI.filter('listOfMatchdays', function() {
    return function(input, keysFromObject) {
        for (var i = 0; i < keysFromObject.length; i++){
            input.push(keysFromObject[i]);
        }
        return input;
    };
});
WebFootballAPI.filter('s', function() {
    return function(input, total,size) {
        total = parseInt(total);
        for (var i = 1; i < total; i++){
            input.push(i);
        }
        return input;
    };
});