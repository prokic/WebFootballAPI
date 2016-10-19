WebFootballAPI = angular.module('WebFootballAPI.directives', []);

WebFootballAPI.directive('leagueTableGroup',function(){
    return {
        restrict: 'EA',
        template: '<div ng-include="grupa ? \'static/html/league/leagueGroup.html\' : \'static/html/league/league.html\'"></div>',
        controller : function ($scope) {

            if ($scope.grupa){

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
    }
});

WebFootballAPI.directive('equalSelected', function(){
    return{
        require:'ngModel',
        link: function(scope, elem, attrs, ctrl){

            ctrl.$parsers.unshift(function (viewValue) {

                if (viewValue !== 'Equal') {
                    return true;
                } else {
                    return false;
                }
            });
        }
    };
});