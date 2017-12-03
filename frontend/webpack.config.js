const path = require("path");
const ExtractTextPlugin = require("extract-text-webpack-plugin");
const UglifyJSPlugin = require("uglifyjs-webpack-plugin");

const static_dir = "../src/main/resources/static";

module.exports = {
    entry: "./src/js/app.js",

    output: {
        path: path.join(__dirname, static_dir),
        filename: "js/app.js",
    },

    module: {
        loaders: [
            {
                test: /\.scss$/,
                loader: ExtractTextPlugin.extract("css-loader?minimize=true!sass-loader")
            },
            {
                test: /\.woff(2)?(\?v=[0-9]\.[0-9]\.[0-9])?$/,
                loader: "url-loader?limit=10000&mimetype=application/font-woff&name=fonts/[name].[ext]"
            },
            { 
                test: /\.(ttf|eot|svg)(\?v=[0-9]\.[0-9]\.[0-9])?$/,
                loader: "file-loader?name=fonts/[name].[ext]"
            }
        ]
    },

    plugins: [
        new UglifyJSPlugin(),
        new ExtractTextPlugin(
            "css/app.css",
            {
                allChunks: true
            }
        )
    ]
};
