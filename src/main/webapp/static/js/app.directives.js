WebFootballAPI = angular.module('WebFootballAPI.directives', [])

WebFootballAPI.directives('leagueTable',function(){
    return {
        restrict: 'E',
        templateUrl: 'static/html/league/league.html',
        controller: 'LeagueController'
    }
});
WebFootballAPI.directives('leagueTableGroup',function(){
    return {
        restrict: 'E',
        templateUrl: 'static/html/league/leagueGroup.html',
        controller: 'LeagueController'
    }
});