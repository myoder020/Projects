var passport = require("passport");
var User = require("../models/user");
var LocalStrategy = require("passport-local");
var validator = require("../helpers/validator");

passport.serializeUser(function (user, done) {
    done(null, user.id);
});

passport.deserializeUser(function (id, done) {
    User.findById(id, function (err, user) {
        done(err, user);
    });
});

passport.use(
    "local.signup",
    new LocalStrategy(
        {
            usernameField: "email",
            passwordField: "password",
            passReqToCallback: true,
        },
        function (req, email, password, done) {
            //handle errors
            var messages = [];
            messages = validator.getErrors(req);
            if (messages) {
                return done(null, false, req.flash("error", messages));
            } else {
                User.findOne({ email: email }, function (err, user) {
                    if (err) {
                        return done(err);
                    }
                    if (user) {
                        return done(null, false, {
                            message: "Email is already in use!",
                        });
                    }
                    var newUser = new User();
                    newUser.email = email;
                    newUser.password = newUser.encryptPassword(password);
                    newUser.save(function (err, result) {
                        if (err) {
                            return done(err);
                        }
                        return done(null, newUser);
                    });
                });
            }
        }
    )
);
