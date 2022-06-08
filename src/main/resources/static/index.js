var bgApp = angular.module('birthdays-gifts', ["ngRoute"])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/mainPage',
                {
                    templateUrl: 'mainPage/mainPage.html',
                    controller: 'mainPageController'
                })

            .when('/newUser',
                {
                    templateUrl: 'newUser/newUser.html',
                    controller: 'newUserController'
                })

            .otherwise({
                redirectTo: '/'
            });
    });
