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

    $scope.inputFields = {
        searchBy: ''
    };

    $scope.operators = [{
        displayName: 'Age'
    }, {
        displayName: 'Market Value'
    }, {
        displayName: 'Name'
    }, {
        displayName: 'Position'
    }];

});

WebFootballAPI.controller("LeagueController", function($scope,liga,TableResolve){

    $scope.leagues = liga;

    $scope.groupLeague = function(league){
        var group = league.league;
        if (group == 'CL' || group == 'EL' || group == 'EC' || group == 'WC'){
            TableResolve.set(true)
        }
        else {
            TableResolve.set(false);
        }
    };

});

WebFootballAPI.controller("TableController",function ($scope,table){

    $scope.leagues = table;
    $scope.grupa = angular.isDefined($scope.leagues.standings);
});

WebFootballAPI.controller("TeamsController",function ($scope,tim){

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

WebFootballAPI.controller("TeamController",function ($scope,teamResolve){

    $scope.team = teamResolve;

});

WebFootballAPI.controller("FixturesController",function ($scope){

    $scope.fixtures = data;

});

WebFootballAPI.controller("PlayersController",function ($scope,playersResolve) {

    $scope.playersRes = playersResolve;
    $scope.dataA = {
        availableOptions: [
            {id: '1', name: 'Age'},
            {id: '2', name: 'Jersey number'},
            {id: '3', name: 'Market value'}
        ],
        selectedOption: { id: '3', name: 'Market value'}
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