WebFootballAPI = angular.module('WebFootballAPI.directives', [])

WebFootballAPI.directive('leagueTable',function(){
    return {
        restrict: 'E',
        templateUrl: 'static/html/league/league.html',
    }
});
WebFootballAPI.directive('leagueTableGroup',function(){
    return {
        scope : true,
        restrict: 'EA',
        templateUrl: 'static/html/league/leagueGroup.html',
        controller : function ($scope) {
            $scope.leagueGroupTeams = $scope.leagues.standings[0];
            $scope.prvi = 0;

            $scope.broj = function () {
                return ( $scope.leagues.standings.length);
            };

            $scope.makeAClass = function (index) {
                return ($scope.prvi === index) ? "btn btn-primary" : "btn btn-default";
            };

            $scope.changeGroup = function (index) {
                $scope.leagueGroupTeams = $scope.leagues.standings[index];
                $scope.prvi = index;
            };
        }
    }
});