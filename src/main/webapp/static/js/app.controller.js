WebFootballAPI = angular.module('WebFootballAPI.controller', []);

WebFootballAPI.controller("ErrorController", function($scope,ChangingURL){

    $scope.URL = ChangingURL.get();

});

WebFootballAPI.controller("FootballController", function ($scope) {

    $scope.godina = "2015/2016";
    $scope.year = "2015";

    $scope.changeYear = function (){
        $scope.year = $scope.godina.substring(0,4);
    };
});

WebFootballAPI.controller("LeagueController", function($scope,liga,$routeParams){

    $scope.leagues = liga;

    $scope.groupLeague = function(league){
        var group = league.league;
        if (group == 'CL' || group == 'EL' || group == 'EC' || group == 'WC'){
            $routeParams.proba = true;
        }
        else {
            $routeParams.proba = false;
        }
    }
});

WebFootballAPI.controller("TableController",function ($scope,table){

    $scope.leagues = table;
    $scope.grupa = angular.isDefined($scope.leagues.standings);
});

WebFootballAPI.controller("TeamController",function ($scope,tim){

    $scope.teams = tim;
    $scope.orderBY = '';
    $scope.reverse = false;
    $scope.classArrow = "";
    $scope.order = function(name) {

        if ($scope.orderBY === name){
            $scope.reverse = !($scope.reverse);
            if ($scope.reverse){
                $scope.classArrow = "glyphicon glyphicon-arrow-down";
            }
            else {
                $scope.classArrow = "glyphicon glyphicon-arrow-up"
            }
        }
        else if(name !== "") {
            $scope.reverse = true;
            $scope.classArrow = "glyphicon glyphicon-arrow-down";
        }
        $scope.orderBY = name;
    };

});

WebFootballAPI.controller("FixturesController",function ($scope){

    $scope.fixtures = data;

});

WebFootballAPI.controller("LeagueTableController",function ($scope, $http,$window,$routeParams){

    $scope.initFixtures = function() {
        $http.get("api/leaguetable/"+$routeParams.id)
            .success(function (data) {
                $scope.fixtures = data;
            })
            .error(function () {
                //$window.location.href = '/footballSeason';
            });

    };

});