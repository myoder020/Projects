var { check, validationResult } = require("express-validator");

userValidationRules = [
    check("email", "Invalid email").notEmpty().isEmail(),
    check("password", "Invalid password").notEmpty().isLength({ min: 4 })
];

function getErrors(req) {
    var errors = validationResult(req);
    console.log(errors);
    if (!errors.isEmpty()) {
        var messages = [];
        errors.array().forEach(function (error) {
            messages.push(error.msg);
        });
        return messages;
    }
}

module.exports = {
userValidationRules,
getErrors
}