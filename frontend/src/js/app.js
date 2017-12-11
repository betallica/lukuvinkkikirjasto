require("font-awesome-webpack");
require('../sass/app.scss');

var $ = require("jquery");

function replaceUrlParam(url, paramName, paramValue){
    if(paramValue == null) {
        paramValue = '';
    }

    var pattern = new RegExp('\\b('+paramName+'=).*?(&|$)');

    if(url.search(pattern)>=0){
        return url.replace(pattern,'$1' + paramValue + '$2');
    }

    url = url.replace(/\?$/,'');

    return url + (url.indexOf('?') > 0 ? '&' : '?') + paramName + '=' + paramValue
}

var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};

// Navigation
document.addEventListener('DOMContentLoaded', function () {
    // Get all "navbar-burger" elements
    var $navbarBurgers = Array.prototype.slice.call(document.querySelectorAll('.navbar-burger'), 0);

    // Check if there are any navbar burgers
    if ($navbarBurgers.length > 0) {

        // Add a click event on each of them
        $navbarBurgers.forEach(function ($el) {
            $el.addEventListener('click', function () {

                // Get the target from the "data-target" attribute
                var target = $el.dataset.target;
                var $target = document.getElementById(target);

                // Toggle the class on both the "navbar-burger" and the "navbar-menu"
                $el.classList.toggle('is-active');
                $target.classList.toggle('is-active');
            });
        });
    }
});

var $radioButtons = $(".filter input:radio, .filter .tags input:checkbox");
var $fiterPanels  = $(".filter .panel-block");

function updateButtons() {
    $radioButtons.each(function() {
        $(this).parent().toggleClass('is-link', this.checked);
    });
}

function toggleFilter() {
    $fiterPanels.each(function() {
        $(this).toggleClass('hidden', this.checked);
    });

    $(".filter #expand").each(function() {
        $(this).toggleClass('fa-chevron-down', this.checked);
    });
}

updateButtons();

if (getUrlParameter('filter') !== "true") {
    toggleFilter();
}

$radioButtons.click(function() {
    updateButtons();
});

$(".filter .panel-heading").click(function() {
    toggleFilter();

    if (getUrlParameter('filter') !== "true") {
        document.location.href = replaceUrlParam(window.location.href, 'filter', 'true');
    } else {
        document.location.href = replaceUrlParam(window.location.href, 'filter', 'false');
    }
});
