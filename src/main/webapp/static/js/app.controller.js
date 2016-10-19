WebFootballAPI = angular.module('WebFootballAPI.controller', []);

WebFootballAPI.controller("ErrorController", function ($scope, ChangingURL) {

    $scope.URL = ChangingURL.get();

});

WebFootballAPI.controller("FootballController", function ($scope, setYearFactory) {

    $scope.godina = "2015/2016";
    $scope.year = "2015";

    $scope.changeYear = function () {
        $scope.year = $scope.godina.substring(0, 4);
    };
    $scope.setYear = function () {
        setYearFactory.set($scope.year);
    }
});

WebFootballAPI.controller("LeagueController", function ($scope, liga, TableResolve, setYearFactory) {

    $scope.leagues = liga;
    $scope.godina = setYearFactory.get();

    $scope.groupLeague = function (league) {
        var group = league.league;
        if (group == 'CL' || group == 'EL' || group == 'EC' || group == 'WC') {
            TableResolve.set(true)
        }
        else {
            TableResolve.set(false);
        }
    };

});

WebFootballAPI.controller("TableController", function ($scope, table) {

    $scope.leagues = table;
    $scope.grupa = angular.isDefined($scope.leagues.standings);
});

WebFootballAPI.controller("TeamsController", function ($scope, tim) {

    $scope.teams = tim;
    $scope.orderBY = '';
    $scope.reverse = false;
    $scope.classArrow = "";
    $scope.order = function (name) {

        if ($scope.orderBY === name) {
            $scope.reverse = !($scope.reverse);
            if ($scope.reverse) {
                $scope.classArrow = "glyphicon glyphicon-arrow-down";
            }
            else {
                $scope.classArrow = "glyphicon glyphicon-arrow-up"
            }
        }
        else if (name !== "") {
            $scope.reverse = true;
            $scope.classArrow = "glyphicon glyphicon-arrow-down";
        }
        $scope.orderBY = name;
    };

});

WebFootballAPI.controller("TeamController", function ($scope, teamResolve) {

    $scope.team = teamResolve;

});

WebFootballAPI.controller("TeamFixtureController", function ($scope, playersFixtureResolve) {

    $scope.initIni = function () {
        var listRes = playersFixtureResolve.fixtures;
        $scope.finishedFixtures = [];
        $scope.timedFixtures = [];
        $scope.scheduledFixtures = [];
        $scope.competitions = listRes.length != 0 ? listRes[0] : undefined;

        if ($scope.competitions != undefined){
            for (var i = 0; i < listRes.length; i++) {
                var oneObject = listRes[i];
                if (oneObject.status == 'FINISHED') {
                    $scope.finishedFixtures.push(oneObject);
                }
                else if (oneObject.status == 'TIMED') {
                    $scope.timedFixtures.push(oneObject);
                }
                else if (oneObject.status == 'SCHEDULED') {
                    $scope.scheduledFixtures.push(oneObject);
                }
            }
            if ($scope.finishedFixtures.length == 0) {
                $scope.finishedFixtures == undefined;
            }
            if ($scope.timedFixtures.length == 0) {
                $scope.timedFixtures == undefined;
            }
            if ($scope.scheduledFixtures.length == 0) {
                $scope.scheduledFixtures == undefined;
            }
        }
        $scope.finishMessage = true;
    };
    $scope.ss = function () {
        var e = $scope.finishedFixtures;
        var s = $scope.timedFixtures;
        var eeer = $scope.sheduledFixtures;
    }

});

WebFootballAPI.controller("PlayersController", function ($scope, playersResolve) {

    $scope.setAll = function () {
        $scope.playersRes = playersResolve;
    };

    $scope.playersRes = playersResolve;

    $scope.inputFields = {
        searchBy: ''
    };

    $scope.position = ['GK', 'CB', 'LB', 'RB', 'DMF', 'CMF', 'AMF', 'LWF', 'RWF', 'SS', 'CF'];

    $scope.operators = [{
        displayName: 'Age',
        searchField: 'age'
    }, {
        displayName: 'Market Value',
        searchField: 'value'
    }, {
        displayName: 'Name',
        searchField: 'name'
    }, {
        displayName: 'Position',
        searchField: 'sortingByPosition'
    }];

    $scope.changeSearchBy = function () {
        if ($scope.inputFields.searchBy.charAt(0) == 'a') {
            $scope.minValue = 15;
            $scope.maxValue = 50;
        }
        else if ($scope.inputFields.searchBy.charAt(0) == 'v') {
            $scope.minValue = 0;
            $scope.maxValue = 500000000;
        }
        $scope.inputFields.inputF = undefined;
    };

    $scope.searchField = function () {
        var searchByVar = $scope.inputFields.searchBy;
        var firstField = searchByVar == 'name' ? $scope.inputFields.inputF.firstField.toLowerCase() : $scope.inputFields.inputF.firstField;
        var objectInArray;
        var fieldInObject;
        var list = [];

        if (searchByVar == 'name') {
            for (var i = 0; i < $scope.playersRes.players.length; i++) {
                objectInArray = $scope.playersRes.players[i];
                fieldInObject = objectInArray[searchByVar].toLowerCase();
                if (fieldInObject.includes(firstField)) {
                    list.push(objectInArray);
                }
            }
        }
        else {
            for (var i = 0; i < $scope.playersRes.players.length; i++) {
                objectInArray = $scope.playersRes.players[i];
                fieldInObject = objectInArray[searchByVar];
                if (fieldInObject == firstField) {
                    list.push(objectInArray);
                }
            }
        }
        $scope.playersRes.players = list;
    };

    $scope.searchFields = function () {
        var searchByVar = $scope.inputFields.searchBy;
        var firstField = $scope.inputFields.inputF.firstField;
        var secondField = $scope.inputFields.inputF.secondField;
        var objectInArray;
        var fieldInObject;
        var list = [];

        for (var i = 0; i < $scope.playersRes.players.length; i++) {
            objectInArray = $scope.playersRes.players[i];
            fieldInObject = objectInArray[searchByVar];
            if (firstField <= fieldInObject && fieldInObject <= secondField) {
                list.push(objectInArray);
            }
        }
        $scope.playersRes.players = list;
    };

});

WebFootballAPI.controller("LeagueTableController", function ($scope, $http, $window, $routeParams) {

    $scope.initFixtures = function () {
        $http.get("api/leaguetable/" + $routeParams.id)
            .success(function (data) {
                $scope.fixtures = data;
            })
            .error(function () {
                //$window.location.href = '/footballSeason';
            });

    };

});