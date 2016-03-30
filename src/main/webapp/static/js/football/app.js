WebFootballAPI = angular.module('WebFootballAPI', ['WebFootballAPI.controller'])

WebFootballAPI.controller("SeasonController", function ($scope, $http) {

    $scope.godina = "2013/2014"

    $scope.sezona = function () {
        var request_params = {};
        request_params['sezona'] = $scope.godina.substring(0,4);
        $http.get("api/season", { params : request_params })
            .success(function (data) {
                $scope.hello = data;
            })
            .error(function () {

            });
    };

});

WebFootballAPI.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'static/html/football/home.html',
            controller : 'SeasonController'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);
