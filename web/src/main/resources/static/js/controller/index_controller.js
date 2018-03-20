"use strict";

app.controller("indexController", ["$scope", "$window", "contactService", function($scope, $window, contactService) {
    $scope.contacts = [];

    $scope.delete = function (id) {
        contactService.delete(id).then(
            function (response) {
                $scope.contacts = $scope.contacts.filter(function(element) {
                    return element.id !== id;
                });
            },
            function (errorResponse) {
            }
        );
    };

    $scope.init = function () {
        contactService.getAllContacts().then(
            function (contacts) {
                $scope.contacts = contacts;
            },
            function (errorResponse) {
            }
        );

        $(".ui.popup").popup();
    };

    $scope.openInsertNewContactPage = function() {
        $window.location.href = "http://localhost:8080/cadastrarNovoContato.html";
    };
    
    $scope.openUpdateContactPage = function (contact) {
        $window.location.href = "http://localhost:8080/alterarDadosContato.html?id=" + contact.id + "&name=" + contact.name + "&phone=" + contact.phone;
    }
}]);