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