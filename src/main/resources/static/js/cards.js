
const CardType = {
    CLUBS: {
        name: "clubs",
        css: "&clubs;"
    },
    DIAMONDS: {
        name: "diams",
        css: "♦"
    }, HEARTS: {
        name: "hearts",
        css: "&hearts;"
    },
    SPADES: {
        name: "spades",
        css: "&spades;"
    }
}
let gameId = "";

function getCardRow(card) {
    const cardType = CardType[card.color];
    const cardName = cardType.name;
    const cardCss = cardType.css;
    return "<Li><div class=\"card rank-" + card.rank + " " + cardName + "\">\n" +
        "            <span class=\"rank\">" + card.rank + "</span>\n" +
        "            <span class=\"suit\">" + cardCss + "</span>\n" +
        "        </div></Li>"
}

function clearDeck() {
    $("#shuffled-cards").empty();
    $("#sorted-cards").empty();
}

function newGame() {
    $.ajax({
        url: "http://localhost:8080/game/init"
    }).then(function (data) {
        gameId = data;
        clearDeck();
        $("#game").hide(600);
        $("#new-hand").show(600);
        $("#game-id").empty().append(gameId);
        getHand();
    });
};

function getHand() {
    $.ajax({
        url: `http://localhost:8080/game/${gameId}/hand`
    }).then(function (data) {
        clearDeck();
        $("#game").show(600);
        data.shuffledCards.forEach(card => {
            $("#shuffled-cards").append(getCardRow(card));
        });
        data.sortedCards.forEach(card => {
            $("#sorted-cards").append(getCardRow(card));
        })
    });

    doSSe();
};

function doSSe() {
    const sse = new EventSource('http://localhost:8080/game/count');
    sse.onmessage = (evt) => {
        $("#game-count").empty();
        $("#game-count").append(evt.data);
    }
}