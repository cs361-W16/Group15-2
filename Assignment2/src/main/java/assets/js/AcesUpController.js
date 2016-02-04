angular.module('AcesUp').controller('AcesUpController', function($scope, $http){
    // Debugging
    window.$scope = $scope;

    $scope.gameState = {};
    $scope.score = 123456;

    /* --- On page load --- */

    // Get initial game state
    $http.get('/game').then(function(result){
        setGameState(result.data);
    });

    /* --- Actions --- */

    $scope.dealCards = function(){

        // Store initial game state
        initial_game_state = $scope.gameState;

        $http.post('/dealGame', $scope.gameState).then(function(result){
            setGameState(result.data);

            // Animation
            hideShow(initial_game_state);
        });
    };

    $scope.removeCard = function(column){
        $http.post('/removeCard/' + column, $scope.gameState).then(function(result){
            setGameState(result.data);
        });
    };

    $scope.moveCard = function(src, dest){
        $http.post('/moveCard/' + src + '/' + dest, $scope.gameState).then(function(result){
            setGameState(result.data);
        });
    };

    $scope.resetGame = function(){
        $http.get('/game').then(function(result){
            setGameState(result.data);
        });
    };

    /* --- Helper functions --- */

    function setGameState(state){
        $scope.gameState = state;
    }


    function hideShow(initial_game_state) {

        initial_board = initial_game_state.cols;

        // Iterate through every column
        for (i = 0; i < 4; i++) {

            var initial_length = initial_board[i].length;
            var new_length = $scope.gameState.cols[i].length;

            /* Check to see if the column length has changed */

            if (initial_length < new_length) {

                // Set the $scope new_col variable to the column with a new card
                $scope.new_col = i;

                console.log("Added to " + i);
            }
            else if (initial_length > new_length) {
                console.log("Removed");
            }
        }

        // Debugging
        console.log(initial_game_state.cols[0]);
    }
});
