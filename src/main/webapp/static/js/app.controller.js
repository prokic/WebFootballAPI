WebFootballAPI = angular.module('WebFootballAPI.controller', []);

WebFootballAPI.controller("HomeController",function($scope, $http){


});

WebFootballAPI.controller("FootballController", function ($scope, $http,$window,$routeParams) {

    $scope.godina = "2013/2014";
    $scope.year = "2013";

    $scope.changeYear = function (){
        $scope.year = $scope.godina.substring(0,4);
    };

    $scope.initLeague = function() {
        $http.get("api/season/" + $routeParams.year)
                .success(function (data) {
                    $scope.leagues = data;
                })
                .error(function () {
                    $window.location.href = '/footballSeason';
                });

    };

});

WebFootballAPI.controller("FixturesController",function ($scope, $http,$window,$routeParams){

    $scope.initFixtures = function() {
        $http.get("api/fixtures/"+$routeParams.id)
            .success(function (data) {
                $scope.fixtures = data;
            })
            .error(function () {
                //$window.location.href = '/footballSeason';
            });

    };

});
WebFootballAPI.controller("TeamController",function ($scope, $http,$window,$routeParams){

    $scope.orderBY = 'name';
    $scope.reverse = true;
    $scope.order = function(name) {
        $scope.reverse = ($scope.orderBY === name) ? !$scope.reverse : false;
        $scope.orderBY = name;
    };


    $scope.initTeams = function() {
        $http.get("api/teams/"+$routeParams.id)
            .success(function (data) {
                $scope.teams = data;
            })
            .error(function () {
                //$window.location.href = '/footballSeason';
            });

    };

});