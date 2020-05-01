var Product = require("../models/product");

var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/shopping');


var products = [
    new Product({
        imagePath:
            "https://images.unsplash.com/photo-1519669556878-63bdad8a1a49?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1351&q=80",
        title: "DeadMaus Game",
        description: "Is a game!!!",
        price: 10,
    }),
    new Product({
        imagePath:
            "https://steamcdn-a.akamaihd.net/steam/apps/239140/ss_488226f013287012e0feaed2fb7799dbe038fd00.1920x1080.jpg?t=1586510236",
        title: "Dying Light",
        description: "Zombies!!!",
        price: 25,
    }),
    new Product({
        imagePath:
            "https://images.pushsquare.com/78b0f08394c0c/final-fantasy-vii-remake-ps4.900x.jpg",
        title: "Final Fantasy",
        description: "The Remake!!",
        price: 60,
    }),
    new Product({
        imagePath:
            "https://blogs-images.forbes.com/erikkain/files/2018/04/God-of-War-4.jpg",
        title: "God Of War",
        description: "Old Strong Man!!",
        price: 60,
    }),
    new Product({
        imagePath:
            "https://media.playstation.com/is/image/SCEA/horizon-zero-dawn-impact-poster-ps4-us-07feb17?$native_nt$",
        title: "Horizon Zero Dawn",
        description: "Da Future!!",
        price: 60,
    }),
];

var done = 0;

for (var i = 0; i < products.length; i++) {
    products[i].save(function (err, result) {
        done++;
        if (done === products.length) {
            exit();
        }
    });
}

function exit() {
    mongoose.disconnect();
}

