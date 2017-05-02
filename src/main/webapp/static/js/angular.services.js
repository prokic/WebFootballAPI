WebFootballAPI = angular.module('WebFootballAPI.service', []);

WebFootballAPI.service('LeagueService', function ($http, $q, $timeout) {

    this.getLeaguee = function (id) {
        var deferred = $q.defer();
        return $http.get("api/season/" + id)
            .then(function (response) {
                deferred.resolve(response.data);
                return deferred.promise;
            }, function (response) {
                deferred.reject(response);
                return deferred.promise;
            });
    };

    this.novo = function (lista) {

        var getObject = function (promise, delay) {
            var deferred = $q.defer();
            $timeout(function () {
                $http.get(promise)
                    .then(function (response) {
                        deferred.resolve(response.data);
                    }, function (response) {
                        deferred.reject(response);
                    });
            }, delay);
            return deferred.promise;
        };

        var deferred = $q.defer();
        return $q.all([getObject(lista[0], 5000), getObject(lista[1], 10000)])
            .then(
                function (results) {
                    deferred.resolve(results);
                    return deferred.promise;
                },
                function () {
                    deferred.reject("Something went wrong");
                    return deferred.promise;
                });


        // var getPromise = function(delay) {
        //     // Creates a Deferred object
        //     var deferred = $q.defer();
        //
        //     $timeout(function() {
        //         // Resolve the promise at the end of the delay if said delay was > 0
        //         if(delay > 0) {
        //             deferred.resolve("Success"+delay);
        //         } else {
        //             deferred.reject("Fail");
        //         }
        //     }, delay);
        //     return deferred.promise;
        // };
        //
        // var deferred = $q.defer();
        // $q.all([
        //     getPromise(5000),
        //     getPromise(2000)
        // ]).then(function(value) {
        //     var list = [];
        //     list.push(value[0].data);
        //     list.push(value[1].data);
        //     deferred.resolve(list);
        // }, function(reason) {
        //     // Error callback where reason is the value of the first rejected promise
        // });
        // return deferred.promise;
    };

});

WebFootballAPI.service('TeamsService', function ($http, $q) {

    this.getTeams = function (id) {
        var deferred = $q.defer();
        return $http.get("api/teams/" + id)
            .then(function (response) {
                deferred.resolve(response.data);
                return deferred.promise;
            }, function (response) {
                deferred.reject(response);
                return deferred.promise;
            });
    };

});

WebFootballAPI.service('TeamService', function ($http, $q) {

    this.getTeam = function (id) {
        var deferred = $q.defer();
        return $http.get("api/team/" + id)
            .then(function (response) {
                deferred.resolve(response.data);
                return deferred.promise;
            }, function (response) {
                deferred.reject(response);
                return deferred.promise;
            });
    };

});

WebFootballAPI.service('CompetitionsService', function ($http) {

    this.getNameOfCompetition = function (id) {
        var setHeader = {};
        setHeader['competition'] = true;
        return $http.get("api/leaguetable/" + id, {params: setHeader});
    }
});

WebFootballAPI.service('LeagueTableService', function ($http, $q) {

    this.getLeagueTable = function (id, table) {
        var deferred = $q.defer();
        var getTable = ((table === "true") ? "api/leaguetable/group/" : "api/leaguetable/");
        return $http.get(getTable + id)
            .then(function (response) {
                deferred.resolve(response.data);
                return deferred.promise;
            }, function (response) {
                deferred.reject(response);
                return deferred.promise;
            });
    };

});

WebFootballAPI.service('PlayersService', function ($http, $q) {

    this.getPlayers = function (id) {
        var deferred = $q.defer();
        return $http.get("api/team/players/" + id)
            .then(function (response) {
                deferred.resolve(response.data);
                return deferred.promise;
            }, function (response) {
                deferred.reject(response);
                return deferred.promise;
            });
    }
});

WebFootballAPI.service('FixtureService', function ($http, $q, setYearFactory) {

    this.getTeamFixtures = function (id) {
        var setHeader = {};
        setHeader['year'] = setYearFactory.get().toString();
        var deferred = $q.defer();
        return $http.get("api/team/fixtures/" + id, {params: setHeader})
            .then(function (response) {
                deferred.resolve(response.data);
                return deferred.promise;
            }, function (response) {
                deferred.reject(response);
                return deferred.promise;
            });
    }
});


WebFootballAPI.service('LeagueFixtureService', function ($http, $q) {

    // this.id;
    // this.getLeagueFixtures = function (id,matchday) {
    //     var deferred = $q.defer();
    //     var request_params = {};
    //     request_params['matchday'] = matchday;
    //     return $http.get("api/league/fixtures/" + id,{ params : request_params })
    //         .then(function (response) {
    //             deferred.resolve(response.data);
    //             return deferred.promise;
    //         }, function (response) {
    //             // this.id = id;
    //             deferred.reject(response);
    //             return deferred.promise;
    //         });
    //     //redovna league fixtures, sa matchdays
    // };
    this.getLeagueFixtures = function (id, matchday) {
        var deferred = $q.defer();
        var request_params = {};
        request_params['matchday'] = matchday;
        return $http.get("api/league/fixtures/" + id, {params: request_params})
            .then(function (response) {
                $http.get()
                deferred.resolve(response.data);
                return deferred.promise;
            }, function (response) {
                // this.id = id;
                deferred.reject(response);
                return deferred.promise;
            });
        //redovna league fixtures, sa matchdays
    };

    this.getCupFixtures = function (id) {
        var deferred = $q.defer();
        return $http.get("api/league/teamFixture" + id)
            .then(function (response) {
                deferred.resolve(response.data);
                return deferred.promise;
            }, function (response) {
                deferred.reject(response);
                return deferred.promise;
            });
        //fixtures samo sa matchdays. Uraditi for sa matchdays pa to da je button i izracunati koliko ima do kraja za final,semi-final....
    };
    this.getWorldCupFixtures = function (id) {
        var deferred = $q.defer();
        return $http.get("api/league/teamFixture" + id)
            .then(function (response) {
                deferred.resolve(response.data);
                return deferred.promise;
            }, function (response) {
                deferred.reject(response);
                return deferred.promise;
            });
    };
    //Ovo je zaguljeno :) Treba uraditi utakmice unutar grupe i izvan , znaci prima fixtures za grupu i za matchday i opet izacunati koliko do kraja ima za final :)
});
