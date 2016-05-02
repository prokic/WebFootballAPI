WebFootballAPI = angular.module('WebFootballAPI.controller', []);

WebFootballAPI.controller ("HomeController",function ($scope){

});

WebFootballAPI.controller("FootballController", function ($scope) {

    $scope.godina = "2013/2014";
    $scope.year = "2013";

    $scope.changeYear = function (){
        $scope.year = $scope.godina.substring(0,4);
    };
    $scope.errorMessage = "";
});

WebFootballAPI.controller("LeagueController", function($scope,liga){

    //$scope.leagues = le.data;
    //LeagueService.getLeaguee($routeParams.year)
    //    .then(function(result){
    //        $scope.leagues = result;
    //    });
    $scope.leagues = liga;
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


    $scope.initTeams = function() {
        $http.get("api/teams/"+$routeParams.id)
            .success(function (data) {
                $scope.teams = data;
                angular.forEach($scope.teams, function(team){
                    if (team.squadMarketValue === 'No market value') {

                    }
                    else {
                        var str = team.squadMarketValue.replace(/,/g, "").trim();
                        var index = str.indexOf(" ");
                        team.value = parseInt(str.substr(0,index));
                    }
                })
            })
            .error(function () {
                //$window.location.href = '/footballSeason';
            });

    };

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