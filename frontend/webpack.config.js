const path = require('path');
const ExtractTextPlugin = require('extract-text-webpack-plugin');

const static_dir = '../src/main/resources/static'

module.exports = {
    entry: './src/js/app.js',

    output: {
        path: path.join(__dirname, static_dir),
        filename: 'js/app.js',
    },

    module: {
        loaders: [
            {
                test: /\.scss$/,
                loader: ExtractTextPlugin.extract('css-loader!sass-loader')
            }
        ]
    },

    plugins: [
        new ExtractTextPlugin(
            'css/app.css',
            {
                allChunks: true
            }
        )
    ]
};
