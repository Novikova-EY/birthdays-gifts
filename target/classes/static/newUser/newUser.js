angular.module('birthdays-gifts').controller('newUserController', function ($scope, $http, $location) {
    const constPath = 'http://localhost:8189/birthdays-gifts/';

    $scope.saveNewUser = function () {
        $http.post(constPath + 'api/v1/users', $scope.newUser)
            .then(function () {
                $scope.newUser = null;
                alert('Пользователь создан');
                $location.path('/mainPage');
            });
    }
});