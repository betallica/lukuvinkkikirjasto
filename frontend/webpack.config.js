const path = require('path');

module.exports = {
    entry: './src/js/app.js',

    output: {
        path: path.join(__dirname, '../src/main/resources/static/js'),
        filename: 'app.js',
    },
};